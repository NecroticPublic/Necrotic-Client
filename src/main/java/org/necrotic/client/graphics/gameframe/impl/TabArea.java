package org.necrotic.client.graphics.gameframe.impl;

import org.necrotic.client.Client;
import org.necrotic.client.RSInterface;
import org.necrotic.client.constants.GameFrameConstants;
import org.necrotic.client.constants.GameFrameConstants.GameFrameType;
import org.necrotic.client.graphics.Sprite;
import org.necrotic.client.graphics.gameframe.GameFrame;
import org.necrotic.client.world.Rasterizer;

public class TabArea extends GameFrame {

	public TabArea(int posX, int posY, int width, int height) {
		super(posX, posY, width, height);
	}

	/**
	 * Draws the RedStones based on tabID
	 *
	 * @param client
	 * @param screenMode
	 */
	private void drawRedStones(Client client, ScreenMode screenMode) {
		if (isVisible()) {
			if (Client.tabID == -1) {
				return;
			}
			if (client.invOverlayInterfaceID == -1 && Client.tabInterfaceIDs[Client.tabID] != -1) {
				if (GameFrameConstants.gameframeType == GameFrameType.FRAME_525) {
					for (int i = 0; i < 14; i++) {
						int tabID = i;
						if(i == 7) {
							tabID = 13;
						} else if(i == 10) {
						//	tabID = 7;
						} else if(i == 13) {
							tabID = 15;
						}
						if (Client.tabID == tabID) {
							Client.cacheSprite[screenMode == ScreenMode.FIXED ? i == 0 ? 8 : i == 6 ? 9 : i == 7 ? 10 : i == 13 ? 11 : 12 : 12].drawSprite(getOffSetX() + 6 + (i > 6 ? i - 7 : Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED ? i : screenMode == ScreenMode.FIXED ? i : i - 7) * Client.cacheSprite[screenMode == ScreenMode.FIXED ? i == 1 || i == 8 ? 8 : 12 : 12].myWidth + (screenMode != ScreenMode.FIXED || i == 1 || i == 8 || i == 0 || i == 7 ? 0 : 5), i > 6 || screenMode != ScreenMode.FIXED ? getOffSetY() + getHeight() - 2 - Client.cacheSprite[12].myHeight * (i < 7 && Client.clientWidth <= GameFrameConstants.smallTabs ? 2 : 1) - 1 : getOffSetY());
						}
					}
				} else if (GameFrameConstants.gameframeType == GameFrameType.FRAME_554) {
					for (int i = 0; i < Client.tabInterfaceIDs.length; i++) {
						int offsetX = getOffSetX() + (i >= 8 ? i - 8 : i) * 30;
						int offsetY = getOffSetY();
						if (i >= 8) {
							if (Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 296;
								offsetX = offsetX - 9;
							} else if (screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 297;
							} else {
								offsetY = offsetY + 298;
							}
							if (Client.clientWidth > GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetX = offsetX - 10;
							}
						}
						if (i < 8) {
							if (Client.clientWidth > GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetX = offsetX - Client.cacheSprite[527].myWidth / 2 - 10;
								offsetY = offsetY + 297;
							} else if (screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 261;
								offsetX = offsetX - 9;
							}
						}
						int tabID = i == 3 ? 15 : i > 3 ? i - 1 : i;
						if (Client.tabID == tabID) {
							Client.cacheSprite[525].drawAdvancedSprite(offsetX, offsetY);
						} else {
							int x = offsetX + (screenMode == ScreenMode.FIXED ? getxPos() : 0);
							int y = offsetY + (screenMode == ScreenMode.FIXED ? getyPos() - 1 : 0);
							if (Client.tabInterfaceIDs[tabID] != -1 && client.mouseX >= x + (screenMode == ScreenMode.FIXED ? 5 : 5) && client.mouseX <= x + 30 + 4 && client.mouseY >= y && client.mouseY <= y + 34) {
								Client.cacheSprite[524].drawAdvancedSprite(offsetX + (screenMode == ScreenMode.FIXED ? 5 : 5), offsetY);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Draws the side icons
	 *
	 * @param client
	 * @param screenMode
	 */
	private void drawSideIcons(Client client, ScreenMode screenMode) {
		if (isVisible()) {
			if (GameFrameConstants.gameframeType == GameFrameType.FRAME_525) {
				for (int i = 0; i < 14; i++) {
					if (client.invOverlayInterfaceID == -1) {
						//	client.sideIcons[i].drawSprite(getOffSetX() + (screenMode == ScreenMode.FIXED ? 13 : 8) + (i > 6 ? i - 7 : screenMode != ScreenMode.FIXED && Client.clientWidth > GameFrameConstants.smallTabs ? i - 7 : i) * Client.cacheSprite[12].myWidth, getOffSetY() + (i > 6 || screenMode != ScreenMode.FIXED ? getHeight() - client.sideIcons[i < 7 ? 0 : i].myHeight - (screenMode != ScreenMode.FIXED && Client.clientWidth <= GameFrameConstants.smallTabs && i < 7 ? 53 : screenMode != ScreenMode.FIXED && Client.clientWidth > GameFrameConstants.smallTabs && i < 7 ? 17 : 9) : 0) + 2);
						Sprite sideIcon = getSideIconForOldFrame(i);
						if(sideIcon != null) {
							int[] xx = getSideIconPosForOldFrame(screenMode, sideIcon, i);
							sideIcon.drawSprite(xx[0], xx[1]);
						}
					}
				}
			} else if (GameFrameConstants.gameframeType == GameFrameType.FRAME_554) {
				int[][] gameFrameData = new int[][] { { 528, 11, 8 }, // attack
					// tab
					{ 529, 11, 8 }, // skills tab
					{ 530, 10, 8 }, // quest tab
					{ 782, 10, 8 }, // achievements tab
					{ 532, 10, 8 }, // inventory tab
					{ 533, 12, 8 }, // equipment tab
					{ 534, 10, 8 }, // prayer tab
					{ 535, 10, 8 }, // magic tab
					{ -1, 11, 8 }, // summoning tab
					{ 536, 11, 8 }, // friends tab
					{ 537, 11, 8 }, // ignores tab
					{ 541, 10, 10 }, // clan chat tab
					{ 538, 10, 8 }, // settings tab
					{ 539, 10, 8 }, // emotes tab
					{ 781, 10, 7 }, // summon tab
					{ -1, 11, 8 }, // extra tab
				};
				for (int i = 0; i < gameFrameData.length; i++) {
					if (client.invOverlayInterfaceID == -1) {
						int offsetX = getOffSetX() + gameFrameData[i][1] + (i >= 8 ? i - 8 : i) * 30;
						int offsetY = getOffSetY() + gameFrameData[i][2];
						if (i >= 8) {
							if (Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 296;
								offsetX = offsetX - 9;
							} else if (screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 297;
							} else {
								offsetY = offsetY + 298;
							}
							if (Client.clientWidth > GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetX = offsetX - 10;
							}
						}
						if (i < 8) {
							if (Client.clientWidth > GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetX = offsetX - Client.cacheSprite[527].myWidth / 2 - 10;
								offsetY = offsetY + 297;
							} else if (screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 261;
								offsetX = offsetX - 9;
							}
						}
						int spriteIndex = gameFrameData[i][0];
						if (spriteIndex != -1) {
							
							if(i == 2 && spriteIndex == 530) {
								if(Client.getClient().doingDungeoneering) {
									spriteIndex = 1031;
								}
							}
							
							Client.cacheSprite[spriteIndex].drawSprite(offsetX, offsetY);
						}
					}
				}
			}
		}
	}

	@Override
	public boolean isHovering(Client client, ScreenMode screenMode) {
		if (!isVisible()) {
			return false;
		}
		if (screenMode == ScreenMode.FIXED) {
			boolean hovering = client.mouseX >= getxPos() && client.mouseX <= getxPos() + getWidth() && client.mouseY >= getyPos() && client.mouseY <= getyPos() + getHeight();
			return hovering;
		}
		if (screenMode != ScreenMode.FIXED) {
			if (GameFrameConstants.gameframeType == GameFrameType.FRAME_525) {
				if (client.inSprite(false, Client.cacheSprite[7], getOffSetX() + 33, getOffSetY() - (Client.clientWidth <= GameFrameConstants.smallTabs ? 13 : -23)) && !componentHidden()) {
					return true;
				}
				for (int i = 0; i < 14; i++) {
					if (client.inSprite(false, Client.cacheSprite[screenMode == ScreenMode.FIXED && (i == 0 || i == 7) ? 8 : 12], getxPos() + 6 + (i > 6 ? i - 7 : Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED ? i : screenMode == ScreenMode.FIXED ? i : i - 7) * Client.cacheSprite[screenMode == ScreenMode.FIXED ? i == 1 || i == 8 ? 8 : 12 : 12].myWidth + (screenMode != ScreenMode.FIXED || i == 1 || i == 8 || i == 0 || i == 7 ? 0 : 5), i > 6 || screenMode != ScreenMode.FIXED ? getyPos() + getHeight() - Client.cacheSprite[12].myHeight * (i < 7 && Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED ? 2 : 1) - 1 : getyPos())) {
						return true;
					}
				}
			} else if (GameFrameConstants.gameframeType == GameFrameType.FRAME_554) {
				if (client.inSprite(false, Client.cacheSprite[7], getOffSetX() + 33, getOffSetY() - (Client.clientWidth <= GameFrameConstants.smallTabs ? 13 : -23)) && !componentHidden()) {
					return true;
				}
				for (int i = 0; i < Client.tabInterfaceIDs.length; i++) {
					int offsetX = getOffSetX() + (i >= 8 ? i - 8 : i) * 30;
					int offsetY = getOffSetY();
					if (i >= 8) {
						if (Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
							offsetY = offsetY + 297;
							offsetX = offsetX - 9;
						} else if (screenMode != ScreenMode.FIXED) {
							offsetY = offsetY + 297;
						} else {
							offsetY = offsetY + 298;
						}
						if (Client.clientWidth > GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
							offsetX = offsetX - 10;
						}
					}
					if (i < 8) {
						if (Client.clientWidth > GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
							offsetX = offsetX - Client.cacheSprite[527].myWidth / 2 - 10;
							offsetY = offsetY + 297;
						} else if (screenMode != ScreenMode.FIXED) {
							offsetY = offsetY + 262;
							offsetX = offsetX - 9;
						}
					}
					if (client.mouseX >= offsetX && client.mouseX <= offsetX + 30 && client.mouseY >= offsetY && client.mouseY <= offsetY + 34) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Processes the tab click
	 *
	 * @param client
	 * @param screenMode
	 */
	public void processTabClick(Client client, ScreenMode screenMode) {
		if (isVisible()) {
			if (client.clickMode3 == 1) {
				if (GameFrameConstants.gameframeType == GameFrameType.FRAME_525) {
					for (int i = 0; i < 14; i++) {
						int tabID = i;
						if(i == 7) {
							tabID = 13;
						} else if(i == 10) {
							//tabID = 7;
						} else if(i == 13) {
							tabID = 15;
						}
						if (client.inSprite(true, Client.cacheSprite[screenMode == ScreenMode.FIXED && (i == 0 || i == 7) ? 8 : 12], getxPos() + 6 + (i > 6 ? i - 7 : Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED ? i : screenMode == ScreenMode.FIXED ? i : i - 7) * Client.cacheSprite[screenMode == ScreenMode.FIXED ? i == 1 || i == 8 ? 8 : 12 : 12].myWidth + (screenMode != ScreenMode.FIXED || i == 1 || i == 8 || i == 0 || i == 7 ? 0 : 5), i > 6 || screenMode != ScreenMode.FIXED ? getyPos() + getHeight() - Client.cacheSprite[12].myHeight * (i < 7 && Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED ? 2 : 1) - 1 : getyPos())) {
							if (screenMode != ScreenMode.FIXED) {
								setHideComponent(Client.tabID != i ? false : componentHidden() ? false : true);
							}
							if(componentHidden()) {
								tabID = -1;
							}
							Client.setTab(tabID);
							break;
						}
					}
				} else if (GameFrameConstants.gameframeType == GameFrameType.FRAME_554) {
					for (int i = 0; i < Client.tabInterfaceIDs.length; i++) {
						if(i == 8 || i == 15) //Disabled tabs.
							continue;
						int offsetX = getOffSetX() + (i >= 8 ? i - 8 : i) * 30;
						int offsetY = getOffSetY();
						if (i >= 8) {
							if (Client.clientWidth <= GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 296;
								offsetX = offsetX - 9;
							} else if (screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 298;
							} else {
								offsetY = offsetY + 300;
							}
							if (Client.clientWidth > GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetX = offsetX - 10;
							}
						}
						if (i < 8) {
							if (Client.clientWidth > GameFrameConstants.smallTabs && screenMode != ScreenMode.FIXED) {
								offsetX = offsetX - Client.cacheSprite[527].myWidth / 2 - 10;
								offsetY = offsetY - 2;
								offsetY = offsetY + 300;
							} else if (screenMode != ScreenMode.FIXED) {
								offsetY = offsetY + 261;
								offsetX = offsetX - 9;
							}
						}
						int tabID = i > 3 ? i - 1 : i;
						if(i == 3) {
							tabID = 15;
						}
						int x = offsetX + (screenMode == ScreenMode.FIXED ? getxPos() : 0);
						int y = offsetY + (screenMode == ScreenMode.FIXED ? getyPos() - 1 : 0);
						if (Client.getClient().getClickMode2() != 0 && client.mouseX >= x + (screenMode == ScreenMode.FIXED ? 5 : 5) && client.mouseX <= x + 30 + 4 && client.mouseY >= y && client.mouseY <= y + 33) {
							if (screenMode != ScreenMode.FIXED) {
								setHideComponent(Client.tabID != tabID ? false : componentHidden() ? false : true);
							}
							Client.setTab(componentHidden() ? -1 : tabID);
							break;
						}

					}
				}
			}
		}
	}

	@Override
	protected void render(Client client, ScreenMode screenMode) {
		if (isVisible()) {
			if (screenMode == ScreenMode.FIXED) {
				if (client.tabAreaIP != null) {
					client.tabAreaIP.initDrawingArea();
				}
			}

			Rasterizer.lineOffsets = client.anIntArray1181;

			if (screenMode == ScreenMode.FIXED) {
				if (GameFrameConstants.gameframeType == GameFrameType.FRAME_525) {
					Client.cacheSprite[5].drawSprite(getOffSetX(), getOffSetY());
				} else if (GameFrameConstants.gameframeType == GameFrameType.FRAME_554) {
					Client.cacheSprite[522].drawSprite(getOffSetX(), getOffSetY());
				}
			} else {
				if (GameFrameConstants.gameframeType == GameFrameType.FRAME_525) {
					for (int i = 0; i < 14; i++) {
						Client.cacheSprite[6].drawSprite(getOffSetX() + 6 + (i > 6 ? i - (Client.clientWidth <= GameFrameConstants.smallTabs ? 7 : 14) : i) * Client.cacheSprite[6].myWidth, getOffSetY() + getHeight() - 2 - Client.cacheSprite[6].myHeight * (i > 6 && Client.clientWidth <= 1000 ? 2 : 1) - 1);
					}
				} else if (GameFrameConstants.gameframeType == GameFrameType.FRAME_554) {
					if (Client.clientWidth <= GameFrameConstants.smallTabs) {
						Client.cacheSprite[526].drawSprite(getOffSetX() - 2, getOffSetY() + 262);
					} else {
						Client.cacheSprite[527].drawSprite(getOffSetX() - Client.cacheSprite[527].myWidth / 2 - 5, getOffSetY() + 298);
					}
				}
			}

			if (!componentHidden() && screenMode != ScreenMode.FIXED) {
				Client.cacheSprite[18].drawTransparentSprite(getOffSetX() + 39, getOffSetY() + (Client.clientWidth <= GameFrameConstants.smallTabs ? -7 : 29), 100);
				Client.cacheSprite[7].drawSprite(getOffSetX() + 33, getOffSetY() - (Client.clientWidth <= GameFrameConstants.smallTabs ? 13 : -23));

			}

			drawRedStones(client, screenMode);

			drawSideIcons(client, screenMode);
			if (!componentHidden() || screenMode == ScreenMode.FIXED) {
				if (client.invOverlayInterfaceID != -1) {
					client.drawInterface(0, getOffSetX() + (screenMode == ScreenMode.FIXED ? 31 : 40), RSInterface.interfaceCache[client.invOverlayInterfaceID], getOffSetY() + (screenMode == ScreenMode.FIXED ? 36 : Client.clientWidth <= GameFrameConstants.smallTabs ? -6 : 30));
				} else if (Client.tabInterfaceIDs[Client.tabID] != -1) {
					RSInterface tab = RSInterface.interfaceCache[Client.tabInterfaceIDs[Client.tabID]];
					client.drawInterface(0, getOffSetX() + (screenMode == ScreenMode.FIXED ? 31 : 40), tab, getOffSetY() + (screenMode == ScreenMode.FIXED ? 36 : Client.clientWidth <= GameFrameConstants.smallTabs ? -6 : 30));
				}
				if (client.menuOpen && client.menuScreenArea == 1) {
					client.drawMenu();
				}
			}
			if (screenMode == ScreenMode.FIXED) {
				if (client.tabAreaIP != null) {
					client.tabAreaIP.drawGraphics(getyPos(), client.graphics, getxPos());
				}
			}
			if (client.tabAreaIP != null) {
				client.gameScreenIP.initDrawingArea();
			}
			Rasterizer.lineOffsets = client.anIntArray1182;
		}
	}

	private Sprite getSideIconForOldFrame(int tab) {
		int spriteIndex = tab;
		if(tab >= 3) {
			spriteIndex++;
		}
		spriteIndex += 528;
		switch(tab) {
		case 7:
			spriteIndex = 781;
			break;
		case 8:
		case 9:
			spriteIndex--;
			break;
		case 10:
			spriteIndex = 541;
			break;
		case 11:
			spriteIndex = 538;
			break;
		case 12:
			spriteIndex = 539;
			break;
		case 13:
			spriteIndex = 782;
			break;
		}
		if(tab == 2 && spriteIndex == 530) {
			if(Client.getClient().doingDungeoneering) {
				spriteIndex = 1031;
			}
		}
		return Client.cacheSprite[spriteIndex];
	}

	private int[] getSideIconPosForOldFrame(ScreenMode screenMode, Sprite sideIcon, int i) {
		int x = getOffSetX() + (screenMode == ScreenMode.FIXED ? 13 : 8) + (i > 6 ? i - 7 : screenMode != ScreenMode.FIXED && Client.clientWidth > GameFrameConstants.smallTabs ? i - 7 : i) * Client.cacheSprite[12].myWidth;
		int y = getOffSetY() + (i > 6 || screenMode != ScreenMode.FIXED ? getHeight() - sideIcon.myHeight - (screenMode != ScreenMode.FIXED && Client.clientWidth <= GameFrameConstants.smallTabs && i < 7 ? 53 : screenMode != ScreenMode.FIXED && Client.clientWidth > GameFrameConstants.smallTabs && i < 7 ? 17 : 9) : 0) + 2;
		x += 3;
		if(!(i >= 7)) {
			y+=5;
		} else {
			y--;
		}
		if(i == 4 || i == 8 || i == 9) {
			x+= i == 4 ? 3 : 2;
		}
		return new int[]{x, y};
	}
}