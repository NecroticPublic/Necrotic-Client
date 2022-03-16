package org.necrotic.client.renderable;

import org.necrotic.Configuration;
import org.necrotic.client.FrameReader;
import org.necrotic.client.cache.definition.SpotAnimDefinition;
import org.necrotic.client.world.Model;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

public final class Animable_Sub3 extends Animable {

	public Animable_Sub3(int i, int j, int l, int i1, int j1, int k1, int l1) {
		aBoolean1567 = false;
		spotAnim = SpotAnimDefinition.cache[i1];
		anInt1560 = i;
		anInt1561 = l1;
		anInt1562 = k1;
		anInt1563 = j1;
		anInt1564 = j + l;
		aBoolean1567 = false;
	}

	@Override
	public Model getRotatedModel() {
		Model model = spotAnim.getModel();
		if (model == null) {
			return null;
		}
		int frame = spotAnim.animation.frameIDs[animFrameId];//
		int nextFrame1 = spotAnim.animation.frameIDs[nextFrame];
		int cycle1 = spotAnim.animation.delays[animFrameId];//
		Model model_1 = new Model(true, FrameReader.isNullFrame(frame), false, model);
		if (!aBoolean1567) {
			model_1.createBones();
			if (Configuration.TWEENING_ENABLED) {
				model_1.interpolateFrames(frame, nextFrame1, cycle1, duration);
			} else {
				model_1.applyTransform(frame);
			}
			model_1.triangleSkin = null;
			model_1.vertexSkin = null;
		}
		if (spotAnim.sizeXY != 128 || spotAnim.sizeZ != 128) {
			model_1.scaleT(spotAnim.sizeXY, spotAnim.sizeXY, spotAnim.sizeZ);
		}
		if (spotAnim.rotation != 0) {
			if (spotAnim.rotation == 90) {
				model_1.method473();
			}
			if (spotAnim.rotation == 180) {
				model_1.method473();
				model_1.method473();
			}
			if (spotAnim.rotation == 270) {
				model_1.method473();
				model_1.method473();
				model_1.method473();
			}
		}
		model_1.light(64 + spotAnim.shadow, 850 + spotAnim.lightness, -30, -50, -30, true);
		return model_1;
	}

	public void method454(int i) {
		for (duration += i; duration > spotAnim.animation.getFrameLength(animFrameId);) {
			duration -= spotAnim.animation.getFrameLength(animFrameId) + 1;
			animFrameId++;
			if (animFrameId >= spotAnim.animation.frameCount && (animFrameId < 0 || animFrameId >= spotAnim.animation.frameCount)) {
				animFrameId = 0;
				aBoolean1567 = true;
			}
		}

	}

	private int nextFrame;
	public final int anInt1560;
	public final int anInt1561;
	public final int anInt1562;
	public final int anInt1563;
	public final int anInt1564;
	public boolean aBoolean1567;
	private final SpotAnimDefinition spotAnim;
	private int animFrameId;
	private int duration;
}
