package org.necrotic.client.constants;

import java.awt.Toolkit;

public class GameFrameConstants {

	public enum GameFrameType {
		FRAME_525, FRAME_554
	}

	public static final int smallTabs = 1000;

	public static final int minWidth = 800;

	public static final int minHeight = 600;

	public static GameFrameType gameframeType = GameFrameType.FRAME_525;

	public static int getMaxWidth() {
		return (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	}

	public static int getMaxHeight() {
		return (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}

}