package org.necrotic.client.graphics.gameframe.impl;

import java.awt.AWTException;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;

import org.necrotic.client.Client;
import org.necrotic.client.RSInterface;
import org.necrotic.client.Settings.Save;
import org.necrotic.client.Signlink;
import org.necrotic.client.graphics.DrawingArea;
import org.necrotic.client.graphics.fonts.RSFontSystem;
import org.necrotic.client.graphics.gameframe.GameFrame;
import org.necrotic.client.world.Rasterizer;

public class ChatArea extends GameFrame {

	private static final ExecutorService SERVICE = Executors.newSingleThreadExecutor();

	// private int resizeY = getOffSetY();
	// private boolean isDragging = false;

	public class ChannelButtons {

		private final String[] channelText = { "All", "Game", "Public",
				"Private", "Clan", "Trade", "Duel", "Screenshot" };
		private final int[] channelXCoords = { 5, 62, 119, 176, 233, 290, 347,
				430 };
		private final String[] chatStatus = { "On", "Friends", "Off", "Hide",
		"All" };
		private final int[] chatTextColor = { 65280, 0xffff00, 0xff0000, 65535,
				0xffff00, 65280 };
		private final String[][] chatMenuText = {
				{ "View All" },
				{ "View Game" },
				{ "Hide Public", "Off Public", "Friends Public", "On Public",
				"View Public" },
				{ "Off Private", "Friends Private", "On Private",
				"View Private" },
				{ "Off Clan chat", "Friends Clan chat", "On Clan chat",
				"View Clan chat" },
				{ "Off Trade", "Friends Trade", "On Trade", "View Trade" },
				{ "Off Duel", "Friends Duel", "On Duel", "View Duel" } };
		private final int[][] actions = { { 999 }, { 998 },
				{ 997, 996, 995, 994, 993 }, { 992, 991, 990, 989 },
				{ 1003, 1002, 1001, 1000 }, { 987, 986, 985, 984 },
				{ 983, 982, 981, 980 } };

		public void drawChannelButtons(Client client, ScreenMode screenMode) {
			if (screenMode != ScreenMode.FIXED) {
				Client.cacheSprite[4].drawSprite(getOffSetX() + 5, getOffSetY() + 143);
			}

			switch (client.cButtonCPos) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				Client.cacheSprite[1].drawSprite(getOffSetX() + channelXCoords[client.cButtonCPos], getOffSetY() + 143);
				break;
			}
			if (client.cButtonHPos == client.cButtonCPos) {
				switch (client.cButtonHPos) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
					Client.cacheSprite[2].drawSprite(getOffSetX() + channelXCoords[client.cButtonHPos], getOffSetY() + 143);
					break;
				case 7:
					break;
				}
			} else {
				switch (client.cButtonHPos) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
					Client.cacheSprite[0].drawSprite(getOffSetX() + channelXCoords[client.cButtonHPos], getOffSetY() + 143);
					break;
				case 7:
					break;
				}
			}

			if (client.inSprite(false, Client.cacheSprite[17], getxPos() + 404, getyPos() + 143)) {
				Client.cacheSprite[17].drawSprite(getOffSetX() + 404, getOffSetY() + 143);
			}

			for (int i = 0; i < channelText.length; i++) {
				client.smallText.drawCenteredText(0xffffff, getOffSetX() + channelXCoords[i] + 28, channelText[i], getOffSetY() + (i < 2 || i == 7 ? 157 : 154), true);
			}

			for (int i = 0; i < chatStatus.length; i++) {
				client.smallText.drawCenteredText(chatTextColor[getChatStatus(i, client)], getOffSetX() + 142 + channelXCoords[i], chatStatus[getChatStatus(i, client)], getOffSetY() + 164, true);
			}
		}

		/**
		 * Gets the chat status
		 *
		 * @param i
		 * @param client
		 * @return
		 */
		private final int getChatStatus(int i, Client client) {
			return i == 0 ? client.publicChatMode : i == 1 ? client.privateChatMode : i == 2 ? /**
			 *
			 *
			 *
			 *
			 *
			 * 
			 * clan chatmode to add
			 */
					0 : i == 3 ? client.tradeMode : client.duelStatus;
		}

		public void processChatModeActions(final Client client, ScreenMode screenMode) {
			if (isVisible()) {
				for (int i = 0; i < channelXCoords.length - 1; i++) {
					if (client.inSprite(false, Client.cacheSprite[0], getxPos() + channelXCoords[i], getyPos() + 143)) {

						client.cButtonHPos = i;
						client.setInputTaken(true);
						break;
					} else {
						client.cButtonHPos = -1;
						client.setInputTaken(true);
					}
				}
				if (clickClanChatSelectionBox(client)) {
					return;
				}
				if (clickSplitChatSelectionBox(client)) {
					return;
				}

				if (client.inSprite(true, Client.cacheSprite[17], getxPos() + 404, getyPos() + 143)) {
					SERVICE.execute(new Runnable() {
						@Override
						public void run() {
							try {
								Window window = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
								Point point = window.getLocationOnScreen();
								Robot robot = new Robot(window.getGraphicsConfiguration().getDevice());
								Rectangle rectangle = new Rectangle((int) point.getX(), (int) point.getY(), window.getWidth(), window.getHeight());
								BufferedImage img = robot.createScreenCapture(rectangle);
								Path path = Paths.get(Signlink.getCacheDirectory().toString(), "screenshots");
								if (!Files.exists(path)) {
									Files.createDirectories(path);
								}
								DateFormat format = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss a");
								File file = new File(path.toFile(), format.format(new Date()) + ".png");
								ImageIO.write(img, "png", file);
								client.pushMessage("A screenshot has been taken and placed in your data folder.", 0, "");
							} catch (AWTException | IOException reason) {
								client.pushMessage("An error occured whilst capturing your screenshot.", 0, "");
								throw new RuntimeException("Fatal error whilst capturing screenshot", reason);
							}
						}
					});
				}

				for (int i = 0; i < chatMenuText.length; i++) {
					if (client.inSprite(false, Client.cacheSprite[0], getxPos() + channelXCoords[i], getyPos() + 143)) {
						for (int id = 0; id < chatMenuText[i].length; id++) {
							client.menuActionName[client.menuActionRow] = chatMenuText[i][id];
							client.menuActionID[client.menuActionRow] = actions[i][id];
							client.menuActionRow++;
						}
					}
				}
			}
		}

	}

	public ChannelButtons channel = new ChannelButtons();

	public ChatArea(int posX, int posY, int width, int height) {
		super(posX, posY, width, height);
	}

	@Override
	public boolean isHovering(Client client, ScreenMode screenMode) {
		if (!isVisible()) {
			return false;
		}
		if (client.cButtonHPos != -1) {
			return true;
		}
		if (screenMode != ScreenMode.FIXED && client.mouseX > getxPos() + 478 && client.mouseX < getxPos() + 512 && client.mouseY > getyPos() + 4 && client.mouseY < getyPos() + 121) {
			return true;
		}
		if (screenMode != ScreenMode.FIXED && client.inSprite(false, Client.cacheSprite[3], getxPos(), getyPos()) && (client.messagePromptRaised || client.aString844 != null || client.backDialogID != -1 || client.dialogID != -1 | client.inputDialogState != 0)) {
			return true;
		}
		if (client.inSprite(false, Client.cacheSprite[17], getxPos() + 404, getyPos() + 143)) {
			return true;
		}
		if (screenMode == ScreenMode.FIXED && client.inSprite(false, Client.cacheSprite[3], getOffSetX(), getOffSetY())) {
			return true;
		}
		return false;
	}

	@Override
	protected void render(Client client, ScreenMode screenMode) {
		if (isVisible()) {
			if(client.chatAreaIP == null)
				return;
			if (screenMode == ScreenMode.FIXED) {
				if (client.loggedIn) {
					client.chatAreaIP.initDrawingArea();
				}
			}

			Rasterizer.lineOffsets = client.anIntArray1180;
			/*
			 * if(screenMode != ScreenMode.FIXED && !componentHidden()) {
			 * if((client.mouseX >= getOffSetX() && client.mouseX <=
			 * getOffSetX() + getWidth() && client.mouseY >= resizeY - 8 &&
			 * client.mouseY <= resizeY + 8) && client.getClickType() ==
			 * ClickType.DRAG) { isDragging = true; } if(client.getClickType()
			 * != ClickType.DRAG) isDragging = false;
			 *
			 * if(isDragging) { resizeY = client.mouseY;
			 *
			 * if(resizeY <= 20) resizeY = 20;
			 *
			 * if(resizeY <= getyPos() - 271) resizeY = getyPos() - 271;
			 *
			 * if(resizeY >= getyPos() - 10) resizeY = getyPos() - 10;
			 *
			 * if(getHeight() < 400 || getHeight() >= 150) setHeight(getyPos() +
			 * 150 - resizeY - 10);
			 *
			 * //System.out.println("YPos: "+getyPos()+ " Height: "+
			 * getHeight()+" ResizeY: "+resizeY); //System.out.println(getyPos()
			 * - 400); } }
			 */

			if (screenMode == ScreenMode.FIXED) {
				Client.cacheSprite[3].drawSprite(getOffSetX(), getOffSetY());
			} else {
				if (!componentHidden()) {
					if (!client.messagePromptRaised && client.aString844 == null && client.backDialogID == -1 && client.dialogID == -1 && client.inputDialogState == 0) {
						float rate = 50f / getHeight();

						for (int i = 0; i < getHeight() - 35; i++) {
							int opacity = (int) (i * rate);
							// if(resizeY + i < Client.clientHeight - 26)
							DrawingArea.fillRect(getOffSetX() + 5, getOffSetY() + 121 - i, getWidth() - 10, 1, 0, opacity);

						}

						DrawingArea.drawAlphaGradient(getOffSetX() + 5, getOffSetY() + 5, getWidth() - 10, 1, 0xb4aea1, 0, 250);
					} else {
						Client.cacheSprite[3].drawTransparentSprite(getOffSetX(), getOffSetY(), 255);
					}

					// for(int i = 0; i < getWidth)
					// DrawingArea.drawHorizontalLine(resizeY, 0x807660,
					// getWidth() - 20, getOffSetX() + 5);
				}
			}
			channel.drawChannelButtons(client, screenMode);

			if (client.messagePromptRaised) {
				client.newBoldFont.drawCenteredString(client.promptMessage, 259 + getOffSetX(), 60 + getOffSetY(), 0, -1);
				client.newBoldFont.drawCenteredString(client.promptInput + "*", 259 + getOffSetX(), 80 + getOffSetY(), 128, -1);
			} else if (client.inputDialogState == 1 || client.inputDialogState == 2) {
				client.newBoldFont.drawCenteredString(client.inputTitle != null ? client.inputTitle : "Enter amount:", getOffSetX() + 259, getOffSetY() + 60, 0, -1);
				client.newBoldFont.drawCenteredString(client.amountOrNameInput + "*", 259 + getOffSetX(), 80 + getOffSetY(), 128, -1);
			} else if (client.inputDialogState == 3) {
				client.getGrandExchange().displayItemSearch();
			} else if (client.aString844 != null) {
				client.newBoldFont.drawCenteredString(client.aString844, 259 + getOffSetX(), 60 + getOffSetY(), 0, -1);
				client.newBoldFont.drawCenteredString("Click to continue", 259 + getOffSetX(), 80 + getOffSetY(), 128, -1);
			} else if (client.backDialogID != -1) {
				client.drawInterface(getOffSetX(), 0, RSInterface.interfaceCache[client.backDialogID], getOffSetY() + 20);
			} else if (client.dialogID != -1) {
				client.drawInterface(getOffSetX(), 0, RSInterface.interfaceCache[client.dialogID], getOffSetY() + 20);
			} else if (!componentHidden()) {
				RSFontSystem textDrawingArea = client.newRegularFont;
				int messageY = -3;
				int scrollPosition = 0;
				DrawingArea.setBounds(getOffSetX() + 8, getOffSetY() + 7, getOffSetX() + getWidth() - 22, getOffSetY() + getHeight() - 28);

				for (int i = 0; i < 500; i++) {
					// http://www.rune-server.org/runescape-development/rs2-client/snippets/395479-chat-line-splitting.html
					if (client.chatMessages[i] != null) {
						int chatType = client.chatTypes[i];
						int positionY = 70 - messageY * 14 + Client.anInt1089 + 6;
						String name = client.chatNames[i];
						String prefixName = name;
						byte playerRights = 0;
						int ironman = 0;

						if (name != null && name.indexOf("@") == 0) {
							int substringLength = Client.getClient().getPrefixSubstringLength(name);
							name = name.substring(substringLength);
							playerRights = client.getPrefixRights(prefixName.substring(0, prefixName.indexOf(name)), new Boolean(substringLength == 6));
							if(playerRights > 11) {
								ironman = playerRights - 11;
								playerRights = 0;
							}
						}

						// Don't show Private messages in "All" if split chat is
						// enabled.
						if (client.chatTypeView == 0 && chatType >= 5 && chatType <= 7 && client.splitPrivateChat == 1) {
							continue;
						}

						// Private
						if (client.chatTypeView == 2 && chatType != 3 && chatType != 6 && chatType != 7) {
							continue;
						}

						// Game
						if (client.chatTypeView == 5 && chatType != 0) {
							continue;
						}

						// Trade
						if (client.chatTypeView == 3 && chatType != 4) {
							continue;
						}

						if (client.chatTypeView == 4 && chatType != 8) {
							continue;
						}

						// Clanchat
						if (client.chatTypeView == 11 && chatType != 16) {
							continue;
						}

						// System.out.println(client.chatTypeView);
						// System.out.println(chatType + ": " +
						// client.chatMessages[i]);

						/**
						 * SendMessages
						 */
						if (chatType == 0) {
							if (client.chatTypeView == 5 || client.chatTypeView == 0) {
								if (positionY > 0 && positionY < 210) {
									int xPos = 11;
									textDrawingArea.drawBasicString(client.chatMessages[i], xPos + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0 : 0xffffff, screenMode == ScreenMode.FIXED ? -1 : 0x000000, true);
								}

								scrollPosition++;
								messageY++;
							}
						}

						/**
						 * Normal chat
						 */
						if ((chatType == 1 || chatType == 2) && (chatType == 1 || client.publicChatMode == 0 || client.publicChatMode == 1 && client.isFriendOrSelf(name))) {
							if (client.chatTypeView == 1 || client.chatTypeView == 0 || playerRights > 0 && playerRights <= 4 && playerRights != 3) {
								if (positionY > 0 && positionY < 210) {
									int xPos = 8;

									if (playerRights > 0) {
										client.modIcons[playerRights].drawTransparentSprite(xPos + 1 + getOffSetX(), positionY - 11 + getOffSetY(), 255);
										xPos += 11;
									} else if(playerRights == 0 && ironman > 0) {
										client.modIcons[11 + ironman].drawTransparentSprite(xPos + 1 + getOffSetX(), positionY - 11 + getOffSetY(), 255);
										xPos += 10;
									}

									String title = client.chatTitles[i] == null || client.chatTitles[i].isEmpty() ? "" : client.chatTitles[i];
									title = title.trim();
									int position = 0;
									if (!title.isEmpty()) {
										xPos += 2;
										position = client.chatPosition[i];
									}
									if (position == 0) {
										textDrawingArea.drawBasicString(title, xPos + getOffSetX(), positionY + getOffSetY(), client.chatColor[i], -1, true);
										xPos += textDrawingArea.getTextWidth(title) + 3;
										textDrawingArea.drawBasicString(name + ":", xPos + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0 : 0xffffff, screenMode == ScreenMode.FIXED ? -1 : 0x000000, true);
										xPos += textDrawingArea.getTextWidth(name + ":") + 2;
										textDrawingArea.drawBasicString(client.chatMessages[i], xPos + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 255 : 0x7FA9FF, screenMode == ScreenMode.FIXED ? -1 : 0x000000, true);
									} else {
										textDrawingArea.drawBasicString(name, xPos + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0 : 0xffffff, screenMode == ScreenMode.FIXED ? -1 : 0x000000, true);
										xPos += textDrawingArea.getTextWidth(name) + 2;
										textDrawingArea.drawBasicString(title, xPos + getOffSetX(), positionY + getOffSetY(), client.chatColor[i], -1, true);
										xPos += textDrawingArea.getTextWidth(title);
										textDrawingArea.drawBasicString("<col=000000>:</col> " + client.chatMessages[i], xPos + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 255 : 0x7FA9FF, screenMode == ScreenMode.FIXED ? -1 : 0x000000, true);
									}
								}
								scrollPosition++;
								messageY++;
							}
						}
						if ((chatType == 3 || chatType == 7) && (chatType == 7 || client.privateChatMode == 0 || client.privateChatMode == 1 && client.isFriendOrSelf(name))) {
							if (client.chatTypeView == 2 || client.chatTypeView == 0 && client.splitPrivateChat == 0) {
								if (positionY > 0 && positionY < 210) {
									int xPos = 11;
									textDrawingArea.drawBasicString("From", xPos + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0 : 0xffffff, screenMode == ScreenMode.FIXED ? -1 : 0, true);
									xPos += textDrawingArea.getTextWidth("From ");

									if (playerRights > 0) {
										client.modIcons[playerRights].drawTransparentSprite(xPos + getOffSetX(), positionY - 11 + getOffSetY(), 255);
										xPos += 11;
									} else if(playerRights == 0 && ironman > 0) {
										client.modIcons[11 + ironman].drawTransparentSprite(xPos + getOffSetX(), positionY - 11 + getOffSetY(), 255);
										xPos += 10;
									}

									textDrawingArea.drawBasicString(name + ":", xPos + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0 : 0xffffff, screenMode == ScreenMode.FIXED ? -1 : 0, true);
									xPos += textDrawingArea.getTextWidth(name) + 8;
									textDrawingArea.drawBasicString(client.chatMessages[i], xPos + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0x800000 : 0xFF5256, screenMode == ScreenMode.FIXED ? -1 : 0x000000, true);
								}

								scrollPosition++;
								messageY++;
							}
						}
						if (chatType == 4 && (client.tradeMode == 0 || client.tradeMode == 1 && client.isFriendOrSelf(name))) {
							if (client.chatTypeView == 3 || client.chatTypeView == 0) {
								if (positionY > 0 && positionY < 210) {
									textDrawingArea.drawBasicString(name + " " + client.chatMessages[i], 11 + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0x800080 : 0xFF00D4, screenMode == ScreenMode.FIXED ? -1 : 0, false);
								}

								scrollPosition++;
								messageY++;
							}
						}
						if (chatType == 5 && client.splitPrivateChat == 0 && client.privateChatMode < 2) {
							if (client.chatTypeView == 2 || client.chatTypeView == 0) {
								if (positionY > 0 && positionY < 210) {
									textDrawingArea.drawBasicString(client.chatMessages[i], 11 + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0x800000 : 0xFF5256, screenMode == ScreenMode.FIXED ? -1 : 0x000000, true);
								}

								scrollPosition++;
								messageY++;
							}
						}
						/**
						 * Private messaging
						 */
						if (chatType == 6 && client.privateChatMode < 2) {
							if (client.chatTypeView == 2 || client.chatTypeView == 0) {
								if (positionY > 0 && positionY < 210) {
									textDrawingArea.drawBasicString("To " + name + ":", 11 + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0 : 0xffffff, screenMode == ScreenMode.FIXED ? -1 : 0, true);
									textDrawingArea.drawBasicString(client.chatMessages[i], 15 + textDrawingArea.getTextWidth("To :" + name) + getOffSetX(), positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0x800000 : 0xFF5256, screenMode == ScreenMode.FIXED ? -1 : 0, true);
								}

								scrollPosition++;
								messageY++;
							}
						}
						if (chatType == 8 && (client.duelStatus == 0 || client.duelStatus == 1 && client.isFriendOrSelf(name))) {
							if (client.chatTypeView == 4 || client.chatTypeView == 0) {
								if (positionY > 0 && positionY < 210) {
									textDrawingArea.drawBasicString(name + " " + client.chatMessages[i], 11 + getOffSetX(), positionY + getOffSetY(), 0x7e3200, -1, true);
								}

								scrollPosition++;
								messageY++;
							}
						}

						if (chatType == 16) {
							if (client.chatTypeView == 11 || client.chatTypeView == 0) {
								if (positionY > 0 && positionY < 210) {
									int positionX = 11;
									//String title = (screenMode == ScreenMode.FIXED ? "<col=0000FF>" : "<col=7FA9FF>") + client.clanName + "</col>";
									//String username = (client.chatRights[i] > 0 ? "<img=" + client.chatRights[i] + "> " : "") + Client.capitalize(client.chatNames[i]);
									String message = (screenMode == ScreenMode.FIXED ? "<col=800000>" : "<col=FF5256>") + client.chatMessages[i] + "</col>";
									textDrawingArea.drawBasicString("" + message, positionX, positionY + getOffSetY(), screenMode == ScreenMode.FIXED ? 0 : 0xffffff, screenMode == ScreenMode.FIXED ? -1 : 0, true);
								}

								scrollPosition++;
								messageY++;
							}
						}
					}
				}

				DrawingArea.defaultDrawingAreaSize();
				Client.anInt1211 = scrollPosition * 14 + 7 + 5;

				if (Client.anInt1211 < 111) {
					Client.anInt1211 = 111;
				}

				client.drawScrollbar(114, Client.anInt1211 - Client.anInt1089 - 113, getOffSetY() + 7, getOffSetX() + 495, Client.anInt1211, false, screenMode != ScreenMode.FIXED);

				if (Client.myPlayer != null && Client.myPlayer.name != null) {

					int drawOffsetX = getOffSetX() + getOffSetX() + 8;
					int drawOffsetY = getOffSetY() + 133;

					if (client.myRights > 0) {
						int crown = client.myRights;
						int yOffset = 0;
						if (crown == 1 || crown == 2 || crown == 3) {
							yOffset = 1;
						}
						if(crown == 4) {
							yOffset--;
						}
						client.modIcons[crown].drawTransparentSprite(drawOffsetX + 1, getOffSetY() + 133 - 11 + yOffset, 255);
						drawOffsetX += 11;
					} else if(client.myRights == 0 && client.ironman > 0) {
						client.modIcons[11 + client.ironman].drawTransparentSprite(drawOffsetX + 1, getOffSetY() + 133 - 11, 255);
						drawOffsetX += 10;
					}

					if (Client.myPlayer.loyaltyTitle != null && !Client.myPlayer.loyaltyTitle.isEmpty()) {
						drawOffsetX += 2;
					}

					textDrawingArea.drawBasicString(Client.myPlayer.loyaltyTitle + "<col=000000> </col>", drawOffsetX, drawOffsetY, Client.myPlayer.loyaltyColor, -1, true);
					drawOffsetX += textDrawingArea.getTextWidth(Client.myPlayer.loyaltyTitle) + 3;
					textDrawingArea.drawBasicString(Client.myPlayer.name + ":", drawOffsetX, drawOffsetY, screenMode == ScreenMode.FIXED ? 0 : 0xffffff, -1, true);
					drawOffsetX += textDrawingArea.getTextWidth(Client.myPlayer.name) + 2;
					textDrawingArea.drawBasicString(" "+ RSFontSystem.handleOldSyntax(client.inputString) +"*", drawOffsetX, drawOffsetY, getScreenMode() == ScreenMode.FIXED ? 255 : 0x7fa9ff, -1, false);
				}

				drawSplitChatSelectionBox(client);
				drawClanChatSelectionBox(client);

				DrawingArea.fillRect(getOffSetX() + 7, getOffSetY() + 121, getWidth() - 13, 1, screenMode == ScreenMode.FIXED ? 0x807660 : 0xaea799, 150);
			}

			if (client.menuOpen && client.menuScreenArea == 2) {
				client.drawMenu();
			}

			if (screenMode == ScreenMode.FIXED) {
				client.chatAreaIP.drawGraphics(getyPos(), client.graphics, getxPos());
			}

			client.gameScreenIP.initDrawingArea();
			Rasterizer.lineOffsets = client.anIntArray1182;
		}
	}

	public static final int[] SPLIT_CHAT_COLORS = new int[] { 65535, // cyan
			16758784, // orange
			2861308, // darkish blue
			14942335, // sort of a pinkish red
			12458710, // purple
			16777215, // white
			0, // black
			51456, // green
			16711680, // red
			16776960, // yellow
			12500669, // gray
	};
	public static final String[] CLAN_CHAT_COLORS = new String[] { "<col=26FEFD>",
			"<col=FDB432>",
			"<col=32A8F7>",
			"<col=E10F7C>",
			"<col=BA2DD0>",
			"<col=FFFFFF>",
			"<col=000000>",
			"<col=20C531>",
			"<col=FC001A>",
			"<col=FEFC42>",
			"<col=BCBCBB>"
	};

	private boolean clickSplitChatSelectionBox(Client client) {
		int splitBoxX = 480;
		int splitBoxY = 122 + (GameFrame.getScreenMode() == ScreenMode.FIXED ? 0 : 2);
		if (client.getClickMode2() == 1 && client.mouseX >= splitBoxX && client.mouseX <= splitBoxX + 16 && client.mouseY >= getyPos() + splitBoxY && client.mouseY <= getyPos() + splitBoxY + 13) {
			client.setClickMode2(0);
			client.splitChatColor = client.splitChatColor + 1 == SPLIT_CHAT_COLORS.length ? 0 : client.splitChatColor + 1;
			Save.settings(Client.getClient());
			client.pushMessage("You've changed your private split-chat color.", 0, "");
			return true;
		}
		return false;
	}

	private void drawSplitChatSelectionBox(Client client) {
		try {
			int splitBoxX = 480;
			int splitBoxY = 122 + (GameFrame.getScreenMode() == ScreenMode.FIXED ? 0 : 2);
			DrawingArea.fillRect(splitBoxX + 1, getOffSetY() + splitBoxY + 1, 15, 12, SPLIT_CHAT_COLORS[client.splitChatColor], 255);
			DrawingArea.fillPixels(splitBoxX, 16, 13, 0, getOffSetY() + splitBoxY);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			client.splitChatColor = 0;
		}
	}

	private boolean clickClanChatSelectionBox(Client client) {
		int splitBoxX = 495;
		int splitBoxY = 122 + (GameFrame.getScreenMode() == ScreenMode.FIXED ? 0 : 2);
		if (client.getClickMode2() == 1 && client.mouseX >= splitBoxX && client.mouseX <= splitBoxX + 16 && client.mouseY >= getyPos() + splitBoxY && client.mouseY <= getyPos() + splitBoxY + 13) {
			client.setClickMode2(0);
			client.clanChatColor = client.clanChatColor + 1 == SPLIT_CHAT_COLORS.length ? 0 : client.clanChatColor + 1;
			Save.settings(Client.getClient());
			client.pushMessage("You've changed your clan chat color.", 0, "");
			return true;
		}
		return false;
	}

	private void drawClanChatSelectionBox(Client client) {
		try {
			if(client.clanChatColor > SPLIT_CHAT_COLORS.length + 1) {
				client.clanChatColor = 0;
			}
			int splitBoxX = 495;
			int splitBoxY = 122 + (GameFrame.getScreenMode() == ScreenMode.FIXED ? 0 : 2);
			DrawingArea.fillRect(splitBoxX + 1, getOffSetY() + splitBoxY + 1, 15, 12, SPLIT_CHAT_COLORS[client.clanChatColor], 255);
			//client.pushMessage(client.clanChatColor + "", 0, "");
			DrawingArea.fillPixels(splitBoxX, 16, 13, 0, getOffSetY() + splitBoxY);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			client.splitChatColor = 0;
		}
	}

	public void toggleButton(Client client, int button) {
		if (GameFrame.getScreenMode() == ScreenMode.FIXED) {
			return;
		}
		if (client.cButtonCPos == button) {
			setHideComponent(!componentHidden());
		} else {
			setHideComponent(false);
		}
	}

}