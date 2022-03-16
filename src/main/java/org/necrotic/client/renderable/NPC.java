package org.necrotic.client.renderable;

import java.util.ArrayList;
import java.util.List;

import org.necrotic.client.FrameReader;
import org.necrotic.client.cache.definition.Animation;
import org.necrotic.client.cache.definition.MobDefinition;
import org.necrotic.client.cache.definition.SpotAnimDefinition;
import org.necrotic.client.graphics.rsinterface.DamageDealer;
import org.necrotic.client.world.Model;

public final class NPC extends Entity {

	public MobDefinition definitionOverride;

	public NPC() {
	}

	@Override
	public Model getRotatedModel() {
		if (definitionOverride == null) {
			return null;
		}

		Model model = method450();

		if (model == null) {
			return null;
		}

		super.height = model.modelHeight;

		if (super.gfxId != -1 && super.currentAnim != -1) {
			SpotAnimDefinition spotAnim = SpotAnimDefinition.cache[super.gfxId];
			Model model_1 = spotAnim.getModel();

			if (model_1 != null) {
				int frame = spotAnim.animation.frameIDs[super.currentAnim];
				int nextFrame = spotAnim.animation.frameIDs[super.nextGraphicsAnimationFrame];
				int cycle1 = spotAnim.animation.delays[super.currentAnim];
				int cycle2 = super.animCycle;
				Model model_2 = new Model(true, FrameReader.isNullFrame(frame), false, model_1);
				model_2.translate(0, -super.graphicHeight, 0);
				model_2.createBones();
				// model_2.method470(frame);
				model_2.interpolateFrames(frame, nextFrame, cycle1, cycle2);
				model_2.triangleSkin = null;
				model_2.vertexSkin = null;

				if (spotAnim.sizeXY != 128 || spotAnim.sizeZ != 128) {
					model_2.scaleT(spotAnim.sizeXY, spotAnim.sizeXY, spotAnim.sizeZ);
				}

				model_2.light(64 + spotAnim.shadow, 850 + spotAnim.lightness, -30, -50, -30, true);
				Model aModel[] = { model, model_2 };
				model = new Model(aModel);
			}
		}

		if (definitionOverride.npcSizeInSquares == 1) {
			model.aBoolean1659 = true;
		}

		return model;
	}

	@Override
	public boolean isVisible() {
		return definitionOverride != null;
	}

	private Model method450() {
		if (super.anim >= 0 && super.animationDelay == 0) {
			Animation animation = Animation.cache[super.anim];
			int currentFrame = Animation.cache[super.anim].frameIDs[super.currentAnimFrame];
			int nextFrame = animation.frameIDs[super.nextAnimationFrame];
			int cycle1 = animation.delays[super.currentAnimFrame];
			int cycle2 = super.anInt1528;
			int i1 = -1;

			if (super.anInt1517 >= 0 && super.anInt1517 != super.anInt1511) {
				i1 = Animation.cache[super.anInt1517].frameIDs[super.currentForcedAnimFrame];
			}
			return definitionOverride.method164(i1, currentFrame, Animation.cache[super.anim].animationFlowControl, nextFrame, cycle1, cycle2);
			// return definitionOverride.method164(i1, currentFrame,
			// Animation.cache[super.anim].animationFlowControl);
		}

		int currentFrame = -1;
		int nextFrame = -1;
		int cycle1 = 0;
		int cycle2 = 0;

		if (super.anInt1517 >= 0) {
			Animation animation = Animation.cache[super.anInt1517];
			currentFrame = animation.frameIDs[super.currentForcedAnimFrame];
			nextFrame = animation.frameIDs[super.nextIdleAnimationFrame];
			cycle1 = animation.delays[super.currentForcedAnimFrame];
			cycle2 = super.frameDelay;
		}

		// return definitionOverride.method164(-1, currentFrame, null);
		return definitionOverride.method164(-1, currentFrame, null, nextFrame, cycle1, cycle2);
	}
	
	public List<DamageDealer> damageDealers = new ArrayList<DamageDealer>();

}