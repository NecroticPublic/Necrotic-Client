package org.necrotic.client.graphics.rsinterface;

import org.necrotic.client.graphics.Sprite;

/**
 * CustomMinimapIcon class to make custom minimap icons
 * 
 * @author Beagon
 */
public class CustomMinimapIcon {
	private int x, y;
	private Sprite sprite;
	
	/**
	 * Create a new {@link CustomMinimapIcon}.
	 * 
	 * @param int x
	 *            The X coordinate on the map
	 * @param int y
	 *            The Y coordinate on the map
	 * @param Sprite
	 *            The sprite to display
	 */
	public CustomMinimapIcon(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}

	/**
	 * Sets the X coordinate.
	 * @return CustomMinimapIcon
	 */
	public CustomMinimapIcon setX(int x) {
		this.x = x;
		return this;
	}

	/**
	 * Gets the X coordinate.
	 * @param int X
	 *            The X coordinate on the map
	 * @return int
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Sets the Y coordinate.
	 * @param int y
	 *            The Y coordinate on the map
	 * @return CustomMinimapIcon
	 */
	public CustomMinimapIcon setY(int y) {
		this.y = y;
		return this;
	}

	/**
	 * Gets the Y coordinate.
	 * @return int
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Sets the icon Sprite
	 * @param Sprite sprite
	 *            The sprite of the icon
	 * @return CustomMinimapIcon
	 */
	public CustomMinimapIcon setSprite(Sprite sprite) {
		this.sprite = sprite;
		return this;
	}
	
	/**
	 * Gets the sprite.
	 * @return Sprite
	 */
	public Sprite getSprite() {
		return this.sprite;
	}
}