package org.necrotic.client.graphics.rsinterface;

import org.necrotic.client.graphics.Sprite;

/**
 *
 * @author Tringan
 *
 */

/**
 *
 * @author Tringan
 *
 */
class InterfaceComponent {

	/**
	 * The at action type of a component
	 */
	private int atActionType;

	/**
	 * The content type
	 */
	private int contentType;

	/**
	 * The height of the interface
	 */
	private int height;

	/**
	 * The hover type
	 */
	private int hoverType;

	/**
	 * The component id
	 */
	private int id;

	/**
	 * Represents if the interface is shown
	 */
	private boolean interfaceShown;

	/**
	 * The opacity of a component
	 */
	private int opacity;

	/**
	 * The component parentId
	 */
	private int parentId;

	/**
	 * The maximium value that the scroll can take
	 */
	private int scrollMax;

	/**
	 * The sprites used by a component
	 */
	private Sprite[] sprites;

	/**
	 * The tooltip used by a component
	 */
	private String toolTip;

	/**
	 * The interface type
	 */
	private int type;
	/**
	 * The width of the interface
	 */
	private int width;

	public InterfaceComponent() {
	}

	/**
	 * Return the at action type
	 *
	 * @return
	 */
	public int getAtActionType() {
		return atActionType;
	}

	/**
	 * Return the content type
	 *
	 * @return
	 */
	public int getContentType() {
		return contentType;
	}

	/**
	 * Return the height
	 *
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Return the hover type
	 *
	 * @return
	 */
	public int getHoverType() {
		return hoverType;
	}

	/**
	 * Return the id
	 *
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Return the opacity
	 *
	 * @return
	 */
	public int getOpacity() {
		return opacity;
	}

	/**
	 * Return the parent id
	 *
	 * @return
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * Return the scrollmax
	 *
	 * @return
	 */
	public int getScrollMax() {
		return scrollMax;
	}

	/**
	 * Return the sprite
	 *
	 * @return
	 */
	public Sprite[] getSprites() {
		return sprites;
	}

	/**
	 * Return the tooltip
	 *
	 * @return
	 */
	public String getToolTip() {
		return toolTip;
	}

	/**
	 * Return the interface type
	 *
	 * @return
	 */
	public int getType() {
		return type;
	}

	/**
	 * Return the width
	 *
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Return interface is shown
	 *
	 * @return
	 */
	public boolean isInterfaceShown() {
		return interfaceShown;
	}

	/**
	 * Sets the at action type
	 *
	 * @param atActionType
	 */
	public void setAtActionType(int atActionType) {
		this.atActionType = atActionType;
	}

	/**
	 * Sets the content type
	 *
	 * @param contentType
	 */
	public void setContentType(int contentType) {
		this.contentType = contentType;
	}

	/**
	 * Sets the component height
	 *
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Sets the hover type
	 *
	 * @param hoverType
	 */
	public void setHoverType(int hoverType) {
		this.hoverType = hoverType;
	}

	/**
	 * Sets the id
	 *
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets interface shown
	 *
	 * @param interfaceShown
	 */
	public void setInterfaceShown(boolean interfaceShown) {
		this.interfaceShown = interfaceShown;
	}

	/**
	 * Sets the opacity
	 *
	 * @param opacity
	 */
	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

	/**
	 * Sets the parent id
	 *
	 * @param parentId
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * Sets the scroll max
	 *
	 * @param scrollMax
	 */
	public void setScrollMax(int scrollMax) {
		this.scrollMax = scrollMax;
	}

	/**
	 * Sets the sprite
	 *
	 * @param sprites
	 */
	public void setSprites(Sprite[] sprites) {
		this.sprites = sprites;
	}

	/**
	 * Sets the tooltip
	 *
	 * @param toolTip
	 */
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	/**
	 * Sets the component type
	 *
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Sets the component width
	 *
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

}