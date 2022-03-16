package org.necrotic.client.graphics.fonts;

import java.awt.Color;

import org.necrotic.Configuration;
import org.necrotic.client.Client;
import org.necrotic.client.cache.Archive;
import org.necrotic.client.graphics.DrawingArea;
import org.necrotic.client.graphics.Sprite;
import org.necrotic.client.io.ByteBuffer;

public class RSFontSystem extends DrawingArea {

	private int baseCharacterHeight = 0;
	private int[] characterDrawYOffsets;
	private int[] characterHeights;
	private int[] characterDrawXOffsets;
	private int[] characterWidths;
	private byte[][] fontPixels;
	private int[] characterScreenWidths;
	private static String aRSString_4135;
	private static String startTransparency;
	private static String startDefaultShadow;
	private static String endShadow = "/shad";
	private static String endEffect;
	private static String endStrikethrough = "/str";
	private static String aRSString_4147;
	private static String startColor;
	private static String lineBreak;
	private static String startStrikethrough;
	private static String endColor;
	private static String startImage;
	private static String startClanImage;
	private static String endUnderline;
	private static String defaultStrikethrough;
	private static String startShadow;
	private static String startEffect;
	private static String aRSString_4162;
	private static String aRSString_4163;
	private static String endTransparency;
	private static String aRSString_4165;
	private static String startUnderline;
	private static String startDefaultUnderline;
	private static String aRSString_4169;
	private static int defaultColor;
	private static int textShadowColor;
	private static int strikethroughColor;
	private static int defaultTransparency;
	private static int anInt4175;
	private static int underlineColor;
	private static int defaultShadow;
	private static int anInt4178;
	private static int transparency;
	private static int textColor;

	static {
		startTransparency = "trans=";
		startStrikethrough = "str=";
		startDefaultShadow = "shad";
		startColor = "col=";
		lineBreak = "br";
		defaultStrikethrough = "str";
		endUnderline = "/u";
		startImage = "img=";
		startClanImage = "clan=";
		startShadow = "shad=";
		startUnderline = "u=";
		endColor = "/col";
		startDefaultUnderline = "u";
		endTransparency = "/trans";
		aRSString_4135 = "nbsp";
		aRSString_4169 = "reg";
		aRSString_4165 = "times";
		aRSString_4162 = "shy";
		aRSString_4163 = "copy";
		endEffect = "gt";
		aRSString_4147 = "euro";
		startEffect = "lt";
		defaultTransparency = 256;
		defaultShadow = -1;
		anInt4175 = 0;
		textShadowColor = -1;
		textColor = 0;
		defaultColor = 0;
		strikethroughColor = -1;
		underlineColor = -1;
		anInt4178 = 0;
		transparency = 256;
	}

	private static void createCharacterPixels(int[] is, byte[] is_24_, int i, int i_25_, int i_26_, int i_27_, int i_28_, int i_29_, int i_30_) {
		int i_31_ = -(i_27_ >> 2);
		i_27_ = -(i_27_ & 0x3);
		for (int i_32_ = -i_28_; i_32_ < 0; i_32_++) {
			for (int i_33_ = i_31_; i_33_ < 0; i_33_++) {
				if (is_24_[i_25_++] != 0) {
					is[i_26_++] = i;
				} else {
					i_26_++;
				}
				if (is_24_[i_25_++] != 0) {
					is[i_26_++] = i;
				} else {
					i_26_++;
				}
				if (is_24_[i_25_++] != 0) {
					is[i_26_++] = i;
				} else {
					i_26_++;
				}
				if (is_24_[i_25_++] != 0) {
					is[i_26_++] = i;
				} else {
					i_26_++;
				}
			}
			for (int i_34_ = i_27_; i_34_ < 0; i_34_++) {
				if (is_24_[i_25_++] != 0) {
					is[i_26_++] = i;
				} else {
					i_26_++;
				}
			}
			i_26_ += i_29_;
			i_25_ += i_30_;
		}
	}

	private static void createTransparentCharacterPixels(int[] is, byte[] is_0_, int i, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_) {
		i = ((i & 0xff00ff) * i_7_ & ~0xff00ff) + ((i & 0xff00) * i_7_ & 0xff0000) >> 8;
			i_7_ = 256 - i_7_;
			for (int i_8_ = -i_4_; i_8_ < 0; i_8_++) {
				for (int i_9_ = -i_3_; i_9_ < 0; i_9_++) {
					if (is_0_[i_1_++] != 0) {
						int i_10_ = is[i_2_];
						is[i_2_++] = (((i_10_ & 0xff00ff) * i_7_ & ~0xff00ff) + ((i_10_ & 0xff00) * i_7_ & 0xff0000) >> 8) + i;
					} else {
						i_2_++;
					}
				}
				i_2_ += i_5_;
				i_1_ += i_6_;
			}
	}

	public static String handleOldSyntax(String text) {
		text = text.replaceAll("@red@", "<col=ff0000>");
		text = text.replaceAll("@gre@", "<col=65280>");
		text = text.replaceAll("@blu@", "<col=255>");
		text = text.replaceAll("@yel@", "<col=ffff00>");
		text = text.replaceAll("@cya@", "<col=65535>");
		text = text.replaceAll("@mag@", "<col=ff00ff>");
		text = text.replaceAll("@whi@", "<col=ffffff>");
		text = text.replaceAll("@lre@", "<col=ff9040>");
		text = text.replaceAll("@dre@", "<col=800000>");
		text = text.replaceAll("@bla@", "<col=0>");
		text = text.replaceAll("@or1@", "<col=ffb000>");
		text = text.replaceAll("@or2@", "<col=ff7000>");
		text = text.replaceAll("@or3@", "<col=ff3000>");
		text = text.replaceAll("@gr1@", "<col=c0ff00>");
		text = text.replaceAll("@gr2@", "<col=80ff00>");
		text = text.replaceAll("@gr3@", "<col=40ff00>");
		text = text.replaceAll("@cr1@", "<img=1>");
		text = text.replaceAll("@cr2@", "<img=2>");
		text = text.replaceAll("@cr3@", "<img=3>");
		text = text.replaceAll("@dev@", "<img=4>");
		text = text.replaceAll("@con@", "<img=6>");
		text = text.replaceAll("@vet@", "<img=5>");
		text = text.replaceAll("@mem@", "<img=7>");
		text = text.replaceAll("@sup@", "<img=10>");
		text = text.replaceAll("@str@","<str>");
		text = text.replaceAll("@end@", "</str>");
		text = text.replaceAll("@leg@", "<col=e3522c>");
		text = text.replaceAll("@epi@", "<col=a334c4>");
		text = text.replaceAll("@rar@", "<col=005fbe>");
		text = text.replaceAll("@unc@", "<col=1ee021>");
		text = text.replaceAll("@com@", "<col=ffffff>");
		text = text.replaceAll("@sta@", "<col=9d9d9d>");
		//text = text.replaceAll("@bob@", ""+Client.cacheSprite[105].drawSprite(3, 3); //CacheSprite[497].drawSprite(childX - 3, childY - 3);
		if(Configuration.SMILIES_ENABLED && !text.contains(":store")) {
			text = text.replace(":=)", "<img=12>");
			text = text.replace("=)", "<img=12>");
			text = text.replace(":)", "<img=12>");
			text = text.replace(":]", "<img=12>");
			text = text.replace(":=(", "<img=13>");
			text = text.replace("=(", "<img=13>");
			text = text.replace(":(", "<img=13>");
			text = text.replace(":[", "<img=13>");			
			text = text.replace(":|", "<img=14>");
			text = text.replace(":S", "<img=15>");
			text = text.replace(":s", "<img=15>");
			text = text.replace(":O", "<img=17>");
			text = text.replace(":o", "<img=17>");
			text = text.replace(":8", "<img=16>");
			text = text.replace(":$", "<img=18>");
			text = text.replace(";)", "<img=19>");
			text = text.replace(";]", "<img=19>");
			text = text.replace(":/", "<img=20>"); 
			text = text.replace(":\\", "<img=20>");
			text = text.replace("\\:", "<img=20>");
			text = text.replace("(y)", "<img=21>"); 
			text = text.replace("(Y)", "<img=21>");
			text = text.replace("(n)", "<img=22>");
			text = text.replace("(N)", "<img=22>");
			text = text.replace(":p", "<img=23>");
			text = text.replace(":P", "<img=23>");
			text = text.replace(":d", "<img=24>"); 
			text = text.replace(":D", "<img=24>");
			text = text.replace("=D", "<img=24>");
			text = text.replace("=d", "<img=24>");
			text = text.replace("^^", "<img=25>");
			text = text.replace("<3", "<img=26>");
			text = text.replace("(L)", "<img=26>");
			text = text.replace("(l)", "<img=26>");
			text = text.replace(":'(", "<img=28>");
			text = text.replace(":*", "<img=29>");
			text = text.replace("(a)", "<img=27>");
			text = text.replace("(A)", "<img=27>");
			text = text.replace("-.-", "<img=30>");
			text = text.replace("O.o", "<img=31>"); 
			text = text.replace("o.O", "<img=31>");
			text = text.replace("o.o", "<img=31>"); 
			text = text.replace("O.O", "<img=31>");
		}
		return text;
	}

	public RSFontSystem(boolean TypeFont, String s, Archive archive) {
		try {
			int length = s.equals("regularhit") || s.equals("bighit") ? 58 : 256;
			fontPixels = new byte[length][];
			characterWidths = new int[length];
			characterHeights = new int[length];
			characterDrawXOffsets = new int[length];
			characterDrawYOffsets = new int[length];
			characterScreenWidths = new int[length];
			ByteBuffer stream = new ByteBuffer(archive.get(s + ".dat"));
			ByteBuffer stream_1 = new ByteBuffer(archive.get("index.dat"));
			stream_1.position = stream.getShort() + 4;
			int k = stream_1.getUnsignedByte();

			if (k > 0) {
				stream_1.position += 3 * (k - 1);
			}

			for (int l = 0; l < length; l++) {
				characterDrawXOffsets[l] = stream_1.getUnsignedByte();
				characterDrawYOffsets[l] = stream_1.getUnsignedByte();
				int i1 = characterWidths[l] = stream_1.getShort();
				int j1 = characterHeights[l] = stream_1.getShort();
				int k1 = stream_1.getUnsignedByte();
				int l1 = i1 * j1;
				fontPixels[l] = new byte[l1];

				if (k1 == 0) {
					for (int i2 = 0; i2 < l1; i2++) {
						fontPixels[l][i2] = stream.getByte();
					}
				} else if (k1 == 1) {
					for (int j2 = 0; j2 < i1; j2++) {
						for (int l2 = 0; l2 < j1; l2++) {
							fontPixels[l][j2 + l2 * i1] = stream.getByte();
						}
					}
				}

				if (j1 > baseCharacterHeight && l < 128) {
					baseCharacterHeight = j1;
				}

				characterDrawXOffsets[l] = 1;
				characterScreenWidths[l] = i1 + 2;
				int k2 = 0;

				for (int i3 = j1 / 7; i3 < j1; i3++) {
					k2 += fontPixels[l][i3 * i1];
				}

				if (k2 <= j1 / 7) {
					characterScreenWidths[l]--;
					characterDrawXOffsets[l] = 0;
				}

				k2 = 0;

				for (int j3 = j1 / 7; j3 < j1; j3++) {
					k2 += fontPixels[l][i1 - 1 + j3 * i1];
				}

				if (k2 <= j1 / 7) {
					characterScreenWidths[l]--;
				}
			}

			if (TypeFont) {
				characterScreenWidths[32] = characterScreenWidths[73];
			} else {
				characterScreenWidths[32] = characterScreenWidths[105];
			}
		} catch (Exception e) {
		}
	}

	public void drawBasicString(String string, int drawX, int drawY, boolean handleOldSyntax) {
		drawY -= baseCharacterHeight;
		int startIndex = -1;
		if(handleOldSyntax) {
			string = handleOldSyntax(string);
		}
		for (int currentCharacter = 0; currentCharacter < string.length(); currentCharacter++) {
			int character = string.charAt(currentCharacter);
			if (character > 255) {
				character = 32;
			}
			if (character == 60) {
				startIndex = currentCharacter;
			} else {
				if (character == 62 && startIndex != -1) {
					String effectString = string.substring(startIndex + 1, currentCharacter);
					startIndex = -1;
					if (effectString.equals(startEffect)) {
						character = 60;
					} else if (effectString.equals(endEffect)) {
						character = 62;
					} else if (effectString.equals(aRSString_4135)) {
						character = 160;
					} else if (effectString.equals(aRSString_4162)) {
						character = 173;
					} else if (effectString.equals(aRSString_4165)) {
						character = 215;
					} else if (effectString.equals(aRSString_4147)) {
						character = 128;
					} else if (effectString.equals(aRSString_4163)) {
						character = 169;
					} else if (effectString.equals(aRSString_4169)) {
						character = 174;
					} else {
						if (effectString.startsWith(startImage)) {
							try {
								int offsetY = 0;
								int imageId = Integer.valueOf(effectString.substring(4));
								if(imageId >= 1 && imageId <= 11) { //Player icons
									imageId = 827 + imageId;
								} else if(imageId >= 12 && imageId <= 31) { //Smilies
									imageId = 838 + imageId;
									offsetY += 3;
								}
								Sprite icon = Client.cacheSprite[imageId];
								int iconModY = icon.myHeight;
								if (transparency == 256) {
									icon.drawSprite(drawX, drawY + baseCharacterHeight + offsetY - iconModY);
								} else {
									icon.drawSprite(drawX, drawY + baseCharacterHeight + offsetY - iconModY, transparency);
								}
								drawX += icon.myWidth;
							} catch (Exception exception) {
								/* empty */
							}
						} else if (effectString.startsWith(startClanImage)) {
							try {
								int imageId = Integer.valueOf(effectString.substring(5));
								Sprite icon = Client.cacheSprite[imageId];
								int iconModY = icon.myHeight + icon.drawOffsetY + 1;
								if (transparency == 256) {
									icon.drawSprite(drawX, drawY + baseCharacterHeight - iconModY);
								} else {
									icon.drawSprite(drawX, drawY + baseCharacterHeight - iconModY, transparency);
								}
								drawX += 11;
							} catch (Exception exception) {
								/* empty */
							}
						} else {
							setTextEffects(effectString);
						}
						continue;
					}
				}
				if (startIndex == -1) {
					int width = characterWidths[character];
					int height = characterHeights[character];
					if (character != 32) {
						if (transparency == 256) {
							if (textShadowColor != -1) {
								drawCharacter(character, drawX + characterDrawXOffsets[character] + 1, drawY + characterDrawYOffsets[character] + 1, width, height, textShadowColor, true);
							}
							drawCharacter(character, drawX + characterDrawXOffsets[character], drawY + characterDrawYOffsets[character], width, height, textColor, false);
						} else {
							if (textShadowColor != -1) {
								drawTransparentCharacter(character, drawX + characterDrawXOffsets[character] + 1, drawY + characterDrawYOffsets[character] + 1, width, height, textShadowColor, transparency, true);
							}
							drawTransparentCharacter(character, drawX + characterDrawXOffsets[character], drawY + characterDrawYOffsets[character], width, height, textColor, transparency, false);
						}
					} else if (anInt4178 > 0) {
						anInt4175 += anInt4178;
						drawX += anInt4175 >> 8;
				anInt4175 &= 0xff;
					}
					int lineWidth = characterScreenWidths[character];
					if (strikethroughColor != -1) {
						DrawingArea.drawHorizontalLine(drawY + (int) (baseCharacterHeight * 0.7), strikethroughColor, lineWidth, drawX);
					}
					if (underlineColor != -1) {
						DrawingArea.drawHorizontalLine(drawY + baseCharacterHeight, underlineColor, lineWidth, drawX);
					}
					drawX += lineWidth;
				}
			}
		}
	}

	public void drawBasicString(String string, int drawX, int drawY, int color, int shadow, boolean handleOldSyntax) {
		if (string != null) {
			setColorAndShadow(color, shadow);
			drawBasicString(string, drawX, drawY, handleOldSyntax);
		}
	}
	
	public void drawCenteredString(String string, int drawX, int drawY, int color, int shadow) {
		if (string != null) {
			setColorAndShadow(color, shadow);
			string = handleOldSyntax(string);
			drawBasicString(string, drawX - getTextWidth(string) / 2, drawY, true);
		}
	}

	private void drawCharacter(int character, int i_35_, int i_36_, int i_37_, int i_38_, int i_39_, boolean bool) {
		int i_40_ = i_35_ + i_36_ * DrawingArea.width;
		int i_41_ = DrawingArea.width - i_37_;
		int i_42_ = 0;
		int i_43_ = 0;

		if (i_36_ < DrawingArea.topY) {
			int i_44_ = DrawingArea.topY - i_36_;
			i_38_ -= i_44_;
			i_36_ = DrawingArea.topY;
			i_43_ += i_44_ * i_37_;
			i_40_ += i_44_ * DrawingArea.width;
		}

		if (i_36_ + i_38_ > DrawingArea.bottomY) {
			i_38_ -= i_36_ + i_38_ - DrawingArea.bottomY;
		}

		if (i_35_ < DrawingArea.topX) {
			int i_45_ = DrawingArea.topX - i_35_;
			i_37_ -= i_45_;
			i_35_ = DrawingArea.topX;
			i_43_ += i_45_;
			i_40_ += i_45_;
			i_42_ += i_45_;
			i_41_ += i_45_;
		}

		if (i_35_ + i_37_ > DrawingArea.bottomX) {
			int i_46_ = i_35_ + i_37_ - DrawingArea.bottomX;
			i_37_ -= i_46_;
			i_42_ += i_46_;
			i_41_ += i_46_;
		}

		if (i_37_ > 0 && i_38_ > 0) {
			try {
				createCharacterPixels(DrawingArea.pixels, fontPixels[character], i_39_, i_43_, i_40_, i_37_, i_38_, i_41_, i_42_);
			} catch (Exception ex) {
			}
		}
	}

	private void drawTransparentCharacter(int i, int i_11_, int i_12_, int i_13_, int i_14_, int i_15_, int i_16_, boolean bool) {
		int i_17_ = i_11_ + i_12_ * DrawingArea.width;
		int i_18_ = DrawingArea.width - i_13_;
		int i_19_ = 0;
		int i_20_ = 0;
		if (i_12_ < DrawingArea.topY) {
			int i_21_ = DrawingArea.topY - i_12_;
			i_14_ -= i_21_;
			i_12_ = DrawingArea.topY;
			i_20_ += i_21_ * i_13_;
			i_17_ += i_21_ * DrawingArea.width;
		}
		if (i_12_ + i_14_ > DrawingArea.bottomY) {
			i_14_ -= i_12_ + i_14_ - DrawingArea.bottomY;
		}
		if (i_11_ < DrawingArea.topX) {
			int i_22_ = DrawingArea.topX - i_11_;
			i_13_ -= i_22_;
			i_11_ = DrawingArea.topX;
			i_20_ += i_22_;
			i_17_ += i_22_;
			i_19_ += i_22_;
			i_18_ += i_22_;
		}
		if (i_11_ + i_13_ > DrawingArea.bottomX) {
			int i_23_ = i_11_ + i_13_ - DrawingArea.bottomX;
			i_13_ -= i_23_;
			i_19_ += i_23_;
			i_18_ += i_23_;
		}
		if (i_13_ > 0 && i_14_ > 0) {
			createTransparentCharacterPixels(DrawingArea.pixels, fontPixels[i], i_15_, i_20_, i_17_, i_13_, i_14_, i_18_, i_19_, i_16_);
		}
	}

	public int getTextWidth(String string) {
		if (string == null) {
			return 0;
		}
		int startIndex = -1;
		int finalWidth = 0;
		for (int currentCharacter = 0; currentCharacter < string.length(); currentCharacter++) {
			if (string.charAt(currentCharacter) == '@' && currentCharacter + 4 < string.length() && string.charAt(currentCharacter + 4) == '@') {
				currentCharacter += 4;
			} else {
				int character = string.charAt(currentCharacter);
				if (character > 255) {
					character = 32;
				}
				if (character == 60) {
					startIndex = currentCharacter;
				} else {
					if (character == 62 && startIndex != -1) {
						String effectString = string.substring(startIndex + 1, currentCharacter);
						startIndex = -1;
						if (effectString.equals(startEffect)) {
							character = 60;
						} else if (effectString.equals(endEffect)) {
							character = 62;
						} else if (effectString.equals(aRSString_4135)) {
							character = 160;
						} else if (effectString.equals(aRSString_4162)) {
							character = 173;
						} else if (effectString.equals(aRSString_4165)) {
							character = 215;
						} else if (effectString.equals(aRSString_4147)) {
							character = 128;
						} else if (effectString.equals(aRSString_4163)) {
							character = 169;
						} else if (effectString.equals(aRSString_4169)) {
							character = 174;
						} else {
							if (effectString.startsWith(startImage)) {
								try {// <img=
									int iconId = Integer.valueOf(effectString.substring(4));
									finalWidth += Client.cacheSprite[iconId].myWidth;
								} catch (Exception exception) {
									/* empty */
								}
							}
							continue;
						}
					}
					if (startIndex == -1) {
						finalWidth += characterScreenWidths[character];
					}
				}
			}
		}
		return finalWidth;
	}

	private void setColorAndShadow(int color, int shadow) {
		strikethroughColor = -1;
		underlineColor = -1;
		textShadowColor = defaultShadow = shadow;
		textColor = defaultColor = color;
		transparency = defaultTransparency = 256;
		anInt4178 = 0;
		anInt4175 = 0;
	}

	private void setDefaultTextEffectValues(int color, int shadow, int trans) {
		strikethroughColor = -1;
		underlineColor = -1;
		textShadowColor = defaultShadow = shadow;
		textColor = defaultColor = color;
		transparency = defaultTransparency = trans;
		anInt4178 = 0;
		anInt4175 = 0;
	}

	public void setTextEffects(String string) {
		do {
			try {
				if (string.startsWith(startColor)) {
					String color = string.substring(4);
					textColor = color.length() < 6 ? Color.decode(color).getRGB() : Integer.parseInt(color, 16);
				} else if (string.equals(endColor)) {
					textColor = defaultColor;
				} else if (string.startsWith(startTransparency)) {
					transparency = Integer.valueOf(string.substring(6));
				} else if (string.equals(endTransparency)) {
					transparency = defaultTransparency;
				} else if (string.startsWith(startStrikethrough)) {
					String color = string.substring(4);
					strikethroughColor = color.length() < 6 ? Color.decode(color).getRGB() : Integer.parseInt(color, 16);
				} else if (string.equals(defaultStrikethrough)) {
					strikethroughColor = 8388608;
				} else if (string.equals(endStrikethrough)) {
					strikethroughColor = -1;
				} else if (string.startsWith(startUnderline)) {
					String color = string.substring(2);
					underlineColor = color.length() < 6 ? Color.decode(color).getRGB() : Integer.parseInt(color, 16);
				} else if (string.equals(startDefaultUnderline)) {
					underlineColor = 0;
				} else if (string.equals(endUnderline)) {
					underlineColor = -1;
				} else if (string.startsWith(startShadow)) {
					String color = string.substring(5);
					textShadowColor = color.length() < 6 ? Color.decode(color).getRGB() : Integer.parseInt(color, 16);
				} else if (string.equals(startDefaultShadow)) {
					textShadowColor = 0;
				} else if (string.equals(endShadow)) {
					textShadowColor = defaultShadow;
				} else {
					if (!string.equals(lineBreak)) {
						break;
					}
					setDefaultTextEffectValues(defaultColor, defaultShadow, defaultTransparency);
				}
			} catch (Exception exception) {
				break;
			}
			break;
		} while (false);
	}
}