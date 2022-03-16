package org.necrotic.client.graphics.gameframe;

import org.necrotic.client.Client;

/**
 *
 * @author Pb600 and Tringan
 *
 *         Huge Thanks to Pb600 for giving a huge help with the main class
 *         Therefore he also takes credits from the subClasses :)
 *
 */

/**
 *
 * @author Pb600 and Tringan
 *
 *         Huge Thanks to Pb600 for giving a huge help with the main class
 *         Therefore he also takes credits from the subClasses :)
 *
 */
public abstract class GameFrame {

	public static enum ScreenMode {
		FIXED, RESIZABLE, FULLSCREEN;
	}

	private static ScreenMode screenMode = ScreenMode.FIXED;

	public static ScreenMode getScreenMode() {
		return screenMode;
	}

	/**
	 * Getters and setters
	 */
	public static void setScreenMode(ScreenMode screenMode) {
		GameFrame.screenMode = screenMode;
	}

	private int width, height;
	private int xPos, yPos;
	private boolean visible;
	private boolean hideComponent;

	private GameFrame(boolean visible, boolean hideComponent, int posX, int posY, int width, int height) {
		this.visible = visible;
		this.hideComponent = hideComponent;
		xPos = posX;
		yPos = posY;
		this.width = width;
		this.height = height;
	}

	public GameFrame(int posX, int posY, int width, int height) {
		this(true, false, posX, posY, width, height);
	}

	public boolean componentHidden() {
		return hideComponent;
	}

	public int getHeight() {
		return height;
	}

	public int getOffSetX() {
		return getScreenMode() == ScreenMode.FIXED ? 0 : getxPos();
	}

	public int getOffSetY() {
		return getScreenMode() == ScreenMode.FIXED ? 0 : getyPos();
	}

	public int getWidth() {
		return width;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public abstract boolean isHovering(Client client, ScreenMode screenMode);

	public boolean isVisible() {
		return visible;
	}

	public void render(Client client) {
		render(client, getScreenMode());
	}

	protected abstract void render(Client client, ScreenMode screenMode);

	public void setHeight(int height) {
		this.height = height;
	}

	public void setHideComponent(boolean hideComponent) {
		this.hideComponent = hideComponent;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setxPos(int posX) {
		xPos = posX;
	}

	public void setyPos(int posY) {
		yPos = posY;
	}

	public static boolean isFixed() {
		return screenMode == ScreenMode.FIXED;
	}

}