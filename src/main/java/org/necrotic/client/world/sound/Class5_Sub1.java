package org.necrotic.client.world.sound;

import sun.audio.AudioPlayer;

public final class Class5_Sub1 extends Class5 {

	private final InputStream_Sub1 anInputStream_Sub1_1310 = new InputStream_Sub1();

	public Class5_Sub1() {
		super(8000);
		AudioPlayer.player.start(anInputStream_Sub1_1310);
	}

	@Override
	final void stop() {
		AudioPlayer.player.stop(anInputStream_Sub1_1310);
		synchronized (anInputStream_Sub1_1310) {
			anInputStream_Sub1_1310.aBoolean31 = true;
		}
	}

}