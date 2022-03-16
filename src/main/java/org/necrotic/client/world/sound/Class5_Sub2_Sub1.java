package org.necrotic.client.world.sound;

/*
 * Class5_Sub2_Sub1 - Decompiled by JODE Visit http://jode.sourceforge.net/
 */
import java.awt.Component;

public final class Class5_Sub2_Sub1 extends Class5_Sub2 {

	private static SoundInterface anInterface2_1845;

	public Class5_Sub2_Sub1(Component component) throws Exception {
		super(22050);
		anInterface2_1845 = null;
		anInterface2_1845.method1(component);
		method502(16384);
	}

	@Override
	final int avail() {
		return anInterface2_1845.method4(32403);
	}

	@Override
	final void close() {
		anInterface2_1845.method5(102);
	}

	@Override
	final void method494(int i) throws Exception {
		anInterface2_1845.method2(26853, i);
	}

	@Override
	final void write() {
		anInterface2_1845.method3(Class5_Sub2.anIntArray1317);
	}

}