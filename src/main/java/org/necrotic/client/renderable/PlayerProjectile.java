package org.necrotic.client.renderable;

import org.necrotic.client.FrameReader;
import org.necrotic.client.cache.definition.SpotAnimDefinition;
import org.necrotic.client.world.Model;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

public final class PlayerProjectile extends Animable {

	public void method455(int i, int j, int k, int l) {
		if (!aBoolean1579) {
			double d = l - anInt1580;
			double d2 = j - anInt1581;
			double d3 = Math.sqrt(d * d + d2 * d2);
			aDouble1585 = anInt1580 + d * anInt1589 / d3;
			aDouble1586 = anInt1581 + d2 * anInt1589 / d3;
			aDouble1587 = anInt1582;
		}
		double d1 = anInt1572 + 1 - i;
		aDouble1574 = (l - aDouble1585) / d1;
		aDouble1575 = (j - aDouble1586) / d1;
		aDouble1576 = Math.sqrt(aDouble1574 * aDouble1574 + aDouble1575 * aDouble1575);
		if (!aBoolean1579) {
			aDouble1577 = -aDouble1576 * Math.tan(anInt1588 * 0.02454369D);
		}
		aDouble1578 = 2D * (k - aDouble1587 - aDouble1577 * d1) / (d1 * d1);
	}

	@Override
	public Model getRotatedModel() {
		
		Model model = spotAnim.getModel();
		if(model == null)
			return null;
		int j = -1;
		if(spotAnim.animation != null)
			j = spotAnim.animation.frameIDs[animFrameId];
		Model model_1 = new Model(true, FrameReader.isNullFrame(j), false, model);
		if(j != -1)
		{
			model_1.createBones();
			model_1.applyTransform(j);
			model_1.triangleSkin = null;
			model_1.vertexSkin = null;
		}
		if(spotAnim.sizeXY != 128 || spotAnim.sizeZ != 128)
			model_1.scaleT(spotAnim.sizeXY, spotAnim.sizeXY, spotAnim.sizeZ);
		model_1.rotateX(rotationX);
		model_1.light(64 + spotAnim.shadow, 5050 + spotAnim.lightness, -90, -580, -90, true);
			return model_1;
			/*
		Model model = spotAnim.getModel();
		if (model == null) {
			System.out.println("Null model");
			return null;
		}
		int frame = -1;
		int nextFrame = -1;
		int cycle = -1;
		if (spotAnim.animation != null) {
			frame = spotAnim.animation.frameIDs[animFrameId];
			nextFrame = spotAnim.animation.frameIDs[nextFrame];
			cycle = spotAnim.animation.frameLengths[animFrameId];
		}
		Model model_1 = new Model(true, FrameReader.method532(frame), false, model);
		if (frame != -1) {
			model_1.createBones();
			// model_1.method470(frame);
			model_1.interpolateFrames(frame, nextFrame, cycle, duration);
			model_1.triangleSkin = null;
			model_1.vertexSkin = null;
		}
		if (spotAnim.sizeXY != 128 || spotAnim.sizeZ != 128) {
			model_1.scaleT(spotAnim.sizeXY, spotAnim.sizeXY, spotAnim.sizeZ);
		}
		model_1.method474(anInt1596);
		model_1.light(64 + spotAnim.shadow, 850 + spotAnim.lightness, -30, -50, -30, true);
		return model_1;*/
	}

	public PlayerProjectile(int i, int j, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
		aBoolean1579 = false;
		spotAnim = SpotAnimDefinition.cache[l2];
		anInt1597 = k1;
		anInt1580 = j2;
		anInt1581 = i2;
		anInt1582 = l1;
		anInt1571 = l;
		anInt1572 = i1;
		anInt1588 = i;
		anInt1589 = j1;
		anInt1590 = k2;
		anInt1583 = j;
		aBoolean1579 = false;
	}

	public void method456(int i) {
		aBoolean1579 = true;
		aDouble1585 += aDouble1574 * i;
		aDouble1586 += aDouble1575 * i;
		aDouble1587 += aDouble1577 * i + 0.5D * aDouble1578 * i * i;
		aDouble1577 += aDouble1578 * i;
		rotationY = (int) (Math.atan2(aDouble1574, aDouble1575) * 325.94900000000001D) + 1024 & 0x7ff;
		rotationX = (int) (Math.atan2(aDouble1577, aDouble1576) * 325.94900000000001D) & 0x7ff;
		if (spotAnim.animation != null) {
			for (duration += i; duration > spotAnim.animation.getFrameLength(animFrameId);) {
				duration -= spotAnim.animation.getFrameLength(animFrameId) + 1;
				animFrameId++;
				if (animFrameId >= spotAnim.animation.frameCount) {
					animFrameId = 0;
				}
			}
		}

	}

	public final int anInt1571;
	public final int anInt1572;
	private double aDouble1574;
	private double aDouble1575;
	private double aDouble1576;
	private double aDouble1577;
	private double aDouble1578;
	private boolean aBoolean1579;
	private final int anInt1580;
	private final int anInt1581;
	private final int anInt1582;
	public final int anInt1583;
	public double aDouble1585;
	public double aDouble1586;
	public double aDouble1587;
	private final int anInt1588;
	private final int anInt1589;
	public final int anInt1590;
	private final SpotAnimDefinition spotAnim;
	private int animFrameId;
	private int duration;
	public int rotationY;
	private int rotationX;
	public final int anInt1597;
}
