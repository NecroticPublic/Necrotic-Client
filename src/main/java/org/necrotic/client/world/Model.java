package org.necrotic.client.world;

import org.necrotic.Configuration;
import org.necrotic.client.Class21;
import org.necrotic.client.Class33;
import org.necrotic.client.Client;
import org.necrotic.client.FrameReader;
import org.necrotic.client.SkinList;
import org.necrotic.client.cache.ondemand.OnDemandFetcherParent;
import org.necrotic.client.graphics.DrawingArea;
import org.necrotic.client.io.ByteBuffer;
import org.necrotic.client.renderable.Animable;

public class Model extends Animable {

	public static boolean aBoolean1684;
	private static boolean aBooleanArray1663[] = new boolean[8000];
	private static boolean outOfReach[] = new boolean[8000];
	private static Class21 aClass21Array1661[];
	public static Model aModel_1621 = new Model(true);
	private static int anInt1681;
	private static int anInt1682;
	private static int anInt1683;
	public static int anInt1685;
	public static int anInt1686;
	public static int anInt1687;
	private static int anIntArray1622[] = new int[2000];
	private static int anIntArray1623[] = new int[2000];
	private static int anIntArray1624[] = new int[2000];
	private static int anIntArray1625[] = new int[2000];
	private static int anIntArray1665[] = new int[8000];
	private static int anIntArray1666[] = new int[8000];
	private static int anIntArray1667[] = new int[8000];
	private static int anIntArray1668[] = new int[8000];
	private static int anIntArray1669[] = new int[8000];
	private static int anIntArray1670[] = new int[8000];
	private static int depthListIndices[] = new int[1500];
	private static int anIntArray1673[] = new int[12];
	private static int anIntArray1675[] = new int[2000];
	private static int anIntArray1676[] = new int[2000];
	private static int anIntArray1677[] = new int[12];
	private static int anIntArray1678[] = new int[10];
	private static int anIntArray1679[] = new int[10];
	private static int anIntArray1680[] = new int[10];
	public static int mapObjIds[] = new int[1000];
	public static int anIntArray1688[] = new int[1000];
	private static int faceLists[][] = new int[1500][512];
	private static int anIntArrayArray1674[][] = new int[12][2000];
	private static OnDemandFetcherParent aOnDemandFetcherParent_1662;
	public static int SINE[];
	public static int COSINE[];
	private static int[] modelIntArray3;
	private static int[] modelIntArray4;
	private static boolean[] newmodel;

	static {
		SINE = Rasterizer.SINE;
		COSINE = Rasterizer.COSINE;
		modelIntArray3 = Rasterizer.anIntArray1482;
		modelIntArray4 = Rasterizer.anIntArray1469;
	}

	public static void method459(int i, OnDemandFetcherParent onDemandFetcherParent) {
		aClass21Array1661 = new Class21[80000];
		newmodel = new boolean[100000];
		aOnDemandFetcherParent_1662 = onDemandFetcherParent;
	}

	public static void method460(byte[] tmp, int i) {
		try {
			if (tmp == null) {
				Class21 class21 = aClass21Array1661[i] = new Class21();
				class21.anInt369 = 0;
				class21.anInt370 = 0;
				class21.anInt371 = 0;
				return;
			}

			ByteBuffer buffer = new ByteBuffer(tmp);
			buffer.position = tmp.length - 18;
			Class21 class21_1 = aClass21Array1661[i] = new Class21();
			class21_1.aByteArray368 = tmp;
			class21_1.anInt369 = buffer.getUnsignedShort();
			class21_1.anInt370 = buffer.getUnsignedShort();
			class21_1.anInt371 = buffer.getUnsignedByte();
			int k = buffer.getUnsignedByte();
			int l = buffer.getUnsignedByte();
			int i1 = buffer.getUnsignedByte();
			int j1 = buffer.getUnsignedByte();
			int k1 = buffer.getUnsignedByte();
			int l1 = buffer.getUnsignedShort();
			int i2 = buffer.getUnsignedShort();
			int j2 = buffer.getUnsignedShort();
			int k2 = buffer.getUnsignedShort();
			int l2 = 0;
			class21_1.anInt372 = l2;
			l2 += class21_1.anInt369;
			class21_1.anInt378 = l2;
			l2 += class21_1.anInt370;
			class21_1.anInt381 = l2;

			if (l == 255) {
				l2 += class21_1.anInt370;
			} else {
				class21_1.anInt381 = -l - 1;
			}

			class21_1.anInt383 = l2;

			if (j1 == 1) {
				l2 += class21_1.anInt370;
			} else {
				class21_1.anInt383 = -1;
			}

			class21_1.anInt380 = l2;

			if (k == 1) {
				l2 += class21_1.anInt370;
			} else {
				class21_1.anInt380 = -1;
			}

			class21_1.anInt376 = l2;

			if (k1 == 1) {
				l2 += class21_1.anInt369;
			} else {
				class21_1.anInt376 = -1;
			}

			class21_1.anInt382 = l2;

			if (i1 == 1) {
				l2 += class21_1.anInt370;
			} else {
				class21_1.anInt382 = -1;
			}

			class21_1.anInt377 = l2;
			l2 += k2;
			class21_1.anInt379 = l2;
			l2 += class21_1.anInt370 * 2;
			class21_1.anInt384 = l2;
			l2 += class21_1.anInt371 * 6;
			class21_1.anInt373 = l2;
			l2 += l1;
			class21_1.anInt374 = l2;
			l2 += i2;
			class21_1.anInt375 = l2;
			l2 += j2;
		} catch (Exception _ex) {
		}
	}

	public static Model fetchModel(int j) {
		if (aClass21Array1661 == null) {
			return null;
		}
		if(j == 0)
			return null;
		Class21 class21 = aClass21Array1661[j];

		if (class21 == null) {
			aOnDemandFetcherParent_1662.get(j);
			return null;
		} else {
			return new Model(j);
		}
	}

	public static boolean method463(int i) {
		if (aClass21Array1661 == null) {
			return false;
		}

		Class21 class21 = aClass21Array1661[i];

		if (class21 == null) {
			aOnDemandFetcherParent_1662.get(i);
			return false;
		} else {
			return true;
		}
	}

	private static final int method481(int i, int j, int k) {
		if (i == 65535) {
			return 0;
		}

		if ((k & 2) == 2) {
			if (j < 0) {
				j = 0;
			} else if (j > 127) {
				j = 127;
			}

			j = 127 - j;
			return j;
		}

		j = j * (i & 0x7f) >> 7;

		if (j < 2) {
			j = 2;
		} else if (j > 126) {
			j = 126;
		}

		return (i & 0xff80) + j;
	}

	public static void nullify() {
		aClass21Array1661 = null;
		aBooleanArray1663 = null;
		outOfReach = null;
		anIntArray1666 = null;
		anIntArray1667 = null;
		anIntArray1668 = null;
		anIntArray1669 = null;
		anIntArray1670 = null;
		depthListIndices = null;
		faceLists = null;
		anIntArray1673 = null;
		anIntArrayArray1674 = null;
		anIntArray1675 = null;
		anIntArray1676 = null;
		anIntArray1677 = null;
		SINE = null;
		COSINE = null;
		modelIntArray3 = null;
		modelIntArray4 = null;
	}

	private boolean aBoolean1618;
	public boolean aBoolean1659;
	public Class33 aClass33Array1660[];
	public int numberOfVerticeCoordinates;
	public int anInt1630;
	private int anInt1641;
	private int anInt1642;
	public int anInt1646;
	public int anInt1647;
	public int anInt1648;
	public int anInt1649;
	public int anInt1650;
	public int anInt1651;
	private int diagonal3D;
	private int anInt1653;
	public int anInt1654;
	public int verticesXCoordinate[];
	public int verticesYCoordinate[];
	public int verticesZCoordinate[];
	public int anIntArray1631[];
	public int anIntArray1632[];
	public int anIntArray1633[];
	private int anIntArray1634[];
	private int anIntArray1635[];
	private int anIntArray1636[];
	public int anIntArray1637[];
	private int face_render_priorities[];
	private int anIntArray1639[];
	public int anIntArray1640[];
	private int anIntArray1643[];
	private int anIntArray1644[];
	private int anIntArray1645[];
	private int anIntArray1655[];
	private int anIntArray1656[];
	public int vertexSkin[][];
	public int triangleSkin[][];

	private Model(boolean flag) {
		aBoolean1618 = true;
		aBoolean1659 = false;

		if (!flag) {
			aBoolean1618 = !aBoolean1618;
		}
	}

	public Model(boolean flag, boolean flag1, boolean flag2, Model model) {
		aBoolean1618 = true;
		aBoolean1659 = false;
		numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
		anInt1630 = model.anInt1630;
		anInt1642 = model.anInt1642;

		if (flag2) {
			verticesXCoordinate = model.verticesXCoordinate;
			verticesYCoordinate = model.verticesYCoordinate;
			verticesZCoordinate = model.verticesZCoordinate;
		} else {
			verticesXCoordinate = new int[numberOfVerticeCoordinates];
			verticesYCoordinate = new int[numberOfVerticeCoordinates];
			verticesZCoordinate = new int[numberOfVerticeCoordinates];

			for (int j = 0; j < numberOfVerticeCoordinates; j++) {
				verticesXCoordinate[j] = model.verticesXCoordinate[j];
				verticesYCoordinate[j] = model.verticesYCoordinate[j];
				verticesZCoordinate[j] = model.verticesZCoordinate[j];
			}
		}

		if (flag) {
			anIntArray1640 = model.anIntArray1640;
		} else {
			anIntArray1640 = new int[anInt1630];

			for (int k = 0; k < anInt1630; k++) {
				anIntArray1640[k] = model.anIntArray1640[k];
			}
		}

		if (flag1) {
			anIntArray1639 = model.anIntArray1639;
		} else {
			anIntArray1639 = new int[anInt1630];

			if (model.anIntArray1639 == null) {
				for (int l = 0; l < anInt1630; l++) {
					anIntArray1639[l] = 0;
				}
			} else {
				for (int i1 = 0; i1 < anInt1630; i1++) {
					anIntArray1639[i1] = model.anIntArray1639[i1];
				}
			}
		}

		anIntArray1655 = model.anIntArray1655;
		anIntArray1656 = model.anIntArray1656;
		anIntArray1637 = model.anIntArray1637;
		anIntArray1631 = model.anIntArray1631;
		anIntArray1632 = model.anIntArray1632;
		anIntArray1633 = model.anIntArray1633;
		face_render_priorities = model.face_render_priorities;
		anInt1641 = model.anInt1641;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
	}

	public Model(boolean flag, boolean flag1, Model model) {
		aBoolean1618 = true;
		aBoolean1659 = false;
		numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
		anInt1630 = model.anInt1630;
		anInt1642 = model.anInt1642;

		if (flag) {
			verticesYCoordinate = new int[numberOfVerticeCoordinates];

			for (int j = 0; j < numberOfVerticeCoordinates; j++) {
				verticesYCoordinate[j] = model.verticesYCoordinate[j];
			}
		} else {
			verticesYCoordinate = model.verticesYCoordinate;
		}

		if (flag1) {
			anIntArray1634 = new int[anInt1630];
			anIntArray1635 = new int[anInt1630];
			anIntArray1636 = new int[anInt1630];

			for (int k = 0; k < anInt1630; k++) {
				anIntArray1634[k] = model.anIntArray1634[k];
				anIntArray1635[k] = model.anIntArray1635[k];
				anIntArray1636[k] = model.anIntArray1636[k];
			}

			anIntArray1637 = new int[anInt1630];

			if (model.anIntArray1637 == null) {
				for (int l = 0; l < anInt1630; l++) {
					anIntArray1637[l] = 0;
				}
			} else {
				for (int i1 = 0; i1 < anInt1630; i1++) {
					anIntArray1637[i1] = model.anIntArray1637[i1];
				}
			}

			super.aClass33Array1425 = new Class33[numberOfVerticeCoordinates];

			for (int j1 = 0; j1 < numberOfVerticeCoordinates; j1++) {
				Class33 class33 = super.aClass33Array1425[j1] = new Class33();
				Class33 class33_1 = model.aClass33Array1425[j1];
				class33.anInt602 = class33_1.anInt602;
				class33.anInt603 = class33_1.anInt603;
				class33.anInt604 = class33_1.anInt604;
				class33.anInt605 = class33_1.anInt605;
			}

			aClass33Array1660 = model.aClass33Array1660;
		} else {
			anIntArray1634 = model.anIntArray1634;
			anIntArray1635 = model.anIntArray1635;
			anIntArray1636 = model.anIntArray1636;
			anIntArray1637 = model.anIntArray1637;
		}

		verticesXCoordinate = model.verticesXCoordinate;
		verticesZCoordinate = model.verticesZCoordinate;
		anIntArray1640 = model.anIntArray1640;
		anIntArray1639 = model.anIntArray1639;
		face_render_priorities = model.face_render_priorities;
		anInt1641 = model.anInt1641;
		anIntArray1631 = model.anIntArray1631;
		anIntArray1632 = model.anIntArray1632;
		anIntArray1633 = model.anIntArray1633;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
		super.modelHeight = model.modelHeight;
		anInt1650 = model.anInt1650;
		anInt1653 = model.anInt1653;
		diagonal3D = model.diagonal3D;
		anInt1646 = model.anInt1646;
		anInt1648 = model.anInt1648;
		anInt1649 = model.anInt1649;
		anInt1647 = model.anInt1647;
	}

	private Model(int modelId) {
		byte[] is = aClass21Array1661[modelId].aByteArray368;

		if (is[is.length - 1] == -1 && is[is.length - 2] == -1) {
			read622Model(is, modelId);
		} else {
			readOldModel(modelId);
		}

	}

	public Model(int i, Model amodel[]) {
		aBoolean1618 = true;
		aBoolean1659 = false;
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		numberOfVerticeCoordinates = 0;
		anInt1630 = 0;
		anInt1642 = 0;
		anInt1641 = -1;

		for (int k = 0; k < i; k++) {
			Model model = amodel[k];

			if (model != null) {
				numberOfVerticeCoordinates += model.numberOfVerticeCoordinates;
				anInt1630 += model.anInt1630;
				anInt1642 += model.anInt1642;
				flag |= model.anIntArray1637 != null;

				if (model.face_render_priorities != null) {
					flag1 = true;
				} else {
					if (anInt1641 == -1) {
						anInt1641 = model.anInt1641;
					}

					if (anInt1641 != model.anInt1641) {
						flag1 = true;
					}
				}

				flag2 |= model.anIntArray1639 != null;
				flag3 |= model.anIntArray1656 != null;
			}
		}

		verticesXCoordinate = new int[numberOfVerticeCoordinates];
		verticesYCoordinate = new int[numberOfVerticeCoordinates];
		verticesZCoordinate = new int[numberOfVerticeCoordinates];
		anIntArray1655 = new int[numberOfVerticeCoordinates];
		anIntArray1631 = new int[anInt1630];
		anIntArray1632 = new int[anInt1630];
		anIntArray1633 = new int[anInt1630];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];

		if (flag) {
			anIntArray1637 = new int[anInt1630];
		}

		if (flag1) {
			face_render_priorities = new int[anInt1630];
		}

		if (flag2) {
			anIntArray1639 = new int[anInt1630];
		}

		if (flag3) {
			anIntArray1656 = new int[anInt1630];
		}

		anIntArray1640 = new int[anInt1630];
		numberOfVerticeCoordinates = 0;
		anInt1630 = 0;
		anInt1642 = 0;
		int l = 0;

		for (int i1 = 0; i1 < i; i1++) {
			Model model_1 = amodel[i1];

			if (model_1 != null) {
				for (int j1 = 0; j1 < model_1.anInt1630; j1++) {
					if (flag) {
						if (model_1.anIntArray1637 == null) {
							anIntArray1637[anInt1630] = 0;
						} else {
							int k1 = model_1.anIntArray1637[j1];

							if ((k1 & 2) == 2) {
								k1 += l << 2;
							}

							anIntArray1637[anInt1630] = k1;
						}
					}

					if (flag1) {
						if (model_1.face_render_priorities == null) {
							face_render_priorities[anInt1630] = model_1.anInt1641;
						} else {
							face_render_priorities[anInt1630] = model_1.face_render_priorities[j1];
						}
					}

					if (flag2) {
						if (model_1.anIntArray1639 == null) {
							anIntArray1639[anInt1630] = 0;
						} else {
							anIntArray1639[anInt1630] = model_1.anIntArray1639[j1];
						}
					}

					if (flag3 && model_1.anIntArray1656 != null) {
						anIntArray1656[anInt1630] = model_1.anIntArray1656[j1];
					}

					anIntArray1640[anInt1630] = model_1.anIntArray1640[j1];
					anIntArray1631[anInt1630] = method465(model_1, model_1.anIntArray1631[j1]);
					anIntArray1632[anInt1630] = method465(model_1, model_1.anIntArray1632[j1]);
					anIntArray1633[anInt1630] = method465(model_1, model_1.anIntArray1633[j1]);
					anInt1630++;
				}

				for (int l1 = 0; l1 < model_1.anInt1642; l1++) {
					anIntArray1643[anInt1642] = method465(model_1, model_1.anIntArray1643[l1]);
					anIntArray1644[anInt1642] = method465(model_1, model_1.anIntArray1644[l1]);
					anIntArray1645[anInt1642] = method465(model_1, model_1.anIntArray1645[l1]);
					anInt1642++;
				}

				l += model_1.anInt1642;
			}
		}
	}

	public Model(Model amodel[]) {
		int i = 2;
		aBoolean1618 = true;
		aBoolean1659 = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		numberOfVerticeCoordinates = 0;
		anInt1630 = 0;
		anInt1642 = 0;
		anInt1641 = -1;

		for (int k = 0; k < i; k++) {
			Model model = amodel[k];
			if (model != null) {
				numberOfVerticeCoordinates += model.numberOfVerticeCoordinates;
				anInt1630 += model.anInt1630;
				anInt1642 += model.anInt1642;
				flag1 |= model.anIntArray1637 != null;
				if (model.face_render_priorities != null) {
					flag2 = true;
				} else {
					if (anInt1641 == -1) {
						anInt1641 = model.anInt1641;
					}
					if (anInt1641 != model.anInt1641) {
						flag2 = true;
					}
				}
				flag3 |= model.anIntArray1639 != null;
				flag4 |= model.anIntArray1640 != null;
			}
		}

		verticesXCoordinate = new int[numberOfVerticeCoordinates];
		verticesYCoordinate = new int[numberOfVerticeCoordinates];
		verticesZCoordinate = new int[numberOfVerticeCoordinates];
		anIntArray1631 = new int[anInt1630];
		anIntArray1632 = new int[anInt1630];
		anIntArray1633 = new int[anInt1630];
		anIntArray1634 = new int[anInt1630];
		anIntArray1635 = new int[anInt1630];
		anIntArray1636 = new int[anInt1630];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (flag1) {
			anIntArray1637 = new int[anInt1630];
		}
		if (flag2) {
			face_render_priorities = new int[anInt1630];
		}
		if (flag3) {
			anIntArray1639 = new int[anInt1630];
		}
		if (flag4) {
			anIntArray1640 = new int[anInt1630];
		}
		numberOfVerticeCoordinates = 0;
		anInt1630 = 0;
		anInt1642 = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < i; j1++) {
			Model model_1 = amodel[j1];
			if (model_1 != null) {
				int k1 = numberOfVerticeCoordinates;
				for (int l1 = 0; l1 < model_1.numberOfVerticeCoordinates; l1++) {
					verticesXCoordinate[numberOfVerticeCoordinates] = model_1.verticesXCoordinate[l1];
					verticesYCoordinate[numberOfVerticeCoordinates] = model_1.verticesYCoordinate[l1];
					verticesZCoordinate[numberOfVerticeCoordinates] = model_1.verticesZCoordinate[l1];
					numberOfVerticeCoordinates++;
				}

				for (int i2 = 0; i2 < model_1.anInt1630; i2++) {
					anIntArray1631[anInt1630] = model_1.anIntArray1631[i2] + k1;
					anIntArray1632[anInt1630] = model_1.anIntArray1632[i2] + k1;
					anIntArray1633[anInt1630] = model_1.anIntArray1633[i2] + k1;
					anIntArray1634[anInt1630] = model_1.anIntArray1634[i2];
					anIntArray1635[anInt1630] = model_1.anIntArray1635[i2];
					anIntArray1636[anInt1630] = model_1.anIntArray1636[i2];
					if (flag1) {
						if (model_1.anIntArray1637 == null) {
							anIntArray1637[anInt1630] = 0;
						} else {
							int j2 = model_1.anIntArray1637[i2];
							if ((j2 & 2) == 2) {
								j2 += i1 << 2;
							}
							anIntArray1637[anInt1630] = j2;
						}
					}
					if (flag2) {
						if (model_1.face_render_priorities == null) {
							face_render_priorities[anInt1630] = model_1.anInt1641;
						} else {
							face_render_priorities[anInt1630] = model_1.face_render_priorities[i2];
						}
					}
					if (flag3) {
						if (model_1.anIntArray1639 == null) {
							anIntArray1639[anInt1630] = 0;
						} else {
							anIntArray1639[anInt1630] = model_1.anIntArray1639[i2];
						}
					}
					if (flag4 && model_1.anIntArray1640 != null) {
						anIntArray1640[anInt1630] = model_1.anIntArray1640[i2];
					}

					anInt1630++;
				}

				for (int k2 = 0; k2 < model_1.anInt1642; k2++) {
					anIntArray1643[anInt1642] = model_1.anIntArray1643[k2] + k1;
					anIntArray1644[anInt1642] = model_1.anIntArray1644[k2] + k1;
					anIntArray1645[anInt1642] = model_1.anIntArray1645[k2] + k1;
					anInt1642++;
				}

				i1 += model_1.anInt1642;
			}
		}

		method466();
	}

	public void method464(Model model, boolean flag) {
		numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
		anInt1630 = model.anInt1630;
		anInt1642 = model.anInt1642;
		if (anIntArray1622.length < numberOfVerticeCoordinates) {
			anIntArray1622 = new int[numberOfVerticeCoordinates + 10000];
			anIntArray1623 = new int[numberOfVerticeCoordinates + 10000];
			anIntArray1624 = new int[numberOfVerticeCoordinates + 10000];
		}
		verticesXCoordinate = anIntArray1622;
		verticesYCoordinate = anIntArray1623;
		verticesZCoordinate = anIntArray1624;
		for (int k = 0; k < numberOfVerticeCoordinates; k++) {
			verticesXCoordinate[k] = model.verticesXCoordinate[k];
			verticesYCoordinate[k] = model.verticesYCoordinate[k];
			verticesZCoordinate[k] = model.verticesZCoordinate[k];
		}

		if (flag) {
			anIntArray1639 = model.anIntArray1639;
		} else {
			if (anIntArray1625.length < anInt1630) {
				anIntArray1625 = new int[anInt1630 + 100];
			}
			anIntArray1639 = anIntArray1625;
			if (model.anIntArray1639 == null) {
				for (int l = 0; l < anInt1630; l++) {
					anIntArray1639[l] = 0;
				}

			} else {
				for (int i1 = 0; i1 < anInt1630; i1++) {
					anIntArray1639[i1] = model.anIntArray1639[i1];
				}

			}
		}
		anIntArray1637 = model.anIntArray1637;
		anIntArray1640 = model.anIntArray1640;
		face_render_priorities = model.face_render_priorities;
		anInt1641 = model.anInt1641;
		triangleSkin = model.triangleSkin;
		vertexSkin = model.vertexSkin;
		anIntArray1631 = model.anIntArray1631;
		anIntArray1632 = model.anIntArray1632;
		anIntArray1633 = model.anIntArray1633;
		anIntArray1634 = model.anIntArray1634;
		anIntArray1635 = model.anIntArray1635;
		anIntArray1636 = model.anIntArray1636;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
	}

	private final int method465(Model model, int i) {
		int j = -1;
		int k = model.verticesXCoordinate[i];
		int l = model.verticesYCoordinate[i];
		int i1 = model.verticesZCoordinate[i];
		for (int j1 = 0; j1 < numberOfVerticeCoordinates; j1++) {
			if (k != verticesXCoordinate[j1] || l != verticesYCoordinate[j1] || i1 != verticesZCoordinate[j1]) {
				continue;
			}
			j = j1;
			break;
		}

		if (j == -1) {
			verticesXCoordinate[numberOfVerticeCoordinates] = k;
			verticesYCoordinate[numberOfVerticeCoordinates] = l;
			verticesZCoordinate[numberOfVerticeCoordinates] = i1;
			if (model.anIntArray1655 != null) {
				anIntArray1655[numberOfVerticeCoordinates] = model.anIntArray1655[i];
			}
			j = numberOfVerticeCoordinates++;
		}
		return j;
	}

	public void method466() {
		super.modelHeight = 0;
		anInt1650 = 0;
		anInt1651 = 0;
		for (int i = 0; i < numberOfVerticeCoordinates; i++) {
			int j = verticesXCoordinate[i];
			int k = verticesYCoordinate[i];
			int l = verticesZCoordinate[i];
			if (-k > super.modelHeight) {
				super.modelHeight = -k;
			}
			if (k > anInt1651) {
				anInt1651 = k;
			}
			int i1 = j * j + l * l;
			if (i1 > anInt1650) {
				anInt1650 = i1;
			}
		}
		anInt1650 = (int) (Math.sqrt(anInt1650) + 0.98999999999999999D);
		anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight) + 0.98999999999999999D);
		diagonal3D = anInt1653 + (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651) + 0.98999999999999999D);
	}

	public void method467() {
		super.modelHeight = 0;
		anInt1651 = 0;
		for (int i = 0; i < numberOfVerticeCoordinates; i++) {
			int j = verticesYCoordinate[i];
			if (-j > super.modelHeight) {
				super.modelHeight = -j;
			}
			if (j > anInt1651) {
				anInt1651 = j;
			}
		}

		anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight) + 0.98999999999999999D);
		diagonal3D = anInt1653 + (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651) + 0.98999999999999999D);
	}

	private void method468(int i) {
		super.modelHeight = 0;
		anInt1650 = 0;
		anInt1651 = 0;
		anInt1646 = 0xf423f;
		anInt1647 = 0xfff0bdc1;
		anInt1648 = 0xfffe7961;
		anInt1649 = 0x1869f;
		for (int j = 0; j < numberOfVerticeCoordinates; j++) {
			int k = verticesXCoordinate[j];
			int l = verticesYCoordinate[j];
			int i1 = verticesZCoordinate[j];
			if (k < anInt1646) {
				anInt1646 = k;
			}
			if (k > anInt1647) {
				anInt1647 = k;
			}
			if (i1 < anInt1649) {
				anInt1649 = i1;
			}
			if (i1 > anInt1648) {
				anInt1648 = i1;
			}
			if (-l > super.modelHeight) {
				super.modelHeight = -l;
			}
			if (l > anInt1651) {
				anInt1651 = l;
			}
			int j1 = k * k + i1 * i1;
			if (j1 > anInt1650) {
				anInt1650 = j1;
			}
		}

		anInt1650 = (int) Math.sqrt(anInt1650);
		anInt1653 = (int) Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight);
		if (i != 21073) {
			return;
		} else {
			diagonal3D = anInt1653 + (int) Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651);
			return;
		}
	}

	public void createBones() {
		if (anIntArray1655 != null) {
			int ai[] = new int[256];
			int j = 0;
			for (int l = 0; l < numberOfVerticeCoordinates; l++) {
				int j1 = anIntArray1655[l];
				ai[j1]++;
				if (j1 > j) {
					j = j1;
				}
			}

			vertexSkin = new int[j + 1][];
			for (int k1 = 0; k1 <= j; k1++) {
				vertexSkin[k1] = new int[ai[k1]];
				ai[k1] = 0;
			}

			for (int j2 = 0; j2 < numberOfVerticeCoordinates; j2++) {
				int l2 = anIntArray1655[j2];
				vertexSkin[l2][ai[l2]++] = j2;
			}

			anIntArray1655 = null;
		}
		if (anIntArray1656 != null) {
			int ai1[] = new int[256];
			int k = 0;
			for (int i1 = 0; i1 < anInt1630; i1++) {
				int l1 = anIntArray1656[i1];
				ai1[l1]++;
				if (l1 > k) {
					k = l1;
				}
			}

			triangleSkin = new int[k + 1][];
			for (int i2 = 0; i2 <= k; i2++) {
				triangleSkin[i2] = new int[ai1[i2]];
				ai1[i2] = 0;
			}

			for (int k2 = 0; k2 < anInt1630; k2++) {
				int i3 = anIntArray1656[k2];
				triangleSkin[i3][ai1[i3]++] = k2;
			}

			anIntArray1656 = null;
		}
	}

	public void applyTransform(int i) {
		if (vertexSkin == null) {
			return;
		}
		if (i == -1) {
			return;
		}
		FrameReader class36 = FrameReader.forId(i);
		if (class36 == null) {
			return;
		}
		SkinList class18 = class36.skinList;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		for (int k = 0; k < class36.stepCount; k++) {
			int l = class36.opcodeLinkTable[k];
			method472(class18.opcodes[l], class18.skinList[l], class36.xOffset[k], class36.yOffset[k], class36.zOffset[k]);
		}

	}

	public void interpolateFrames(int firstFrame, int nextFrame, int end, int cycle) {
		if (!Configuration.TWEENING_ENABLED) {
			applyTransform(nextFrame);
			return;
		}
		try {
			if (vertexSkin != null && firstFrame != -1) {
				FrameReader currentAnimation = FrameReader.forId(firstFrame);
				if(currentAnimation == null) {
					applyTransform(nextFrame);
					return;
				}
				SkinList list1 = currentAnimation.skinList;
				anInt1681 = 0;
				anInt1682 = 0;
				anInt1683 = 0;
				FrameReader nextAnimation = null;
				SkinList list2 = null;
				if (nextFrame != -1) {
					nextAnimation = FrameReader.forId(nextFrame);
					if (nextAnimation.skinList != list1)
						nextAnimation = null;
					list2 = nextAnimation.skinList;
				}
				if(nextAnimation == null || list2 == null) {
					for (int i_263_ = 0; i_263_ < currentAnimation.stepCount; i_263_++) {
						int i_264_ = currentAnimation.opcodeLinkTable[i_263_];
						method472(list1.opcodes[i_264_], list1.skinList[i_264_], currentAnimation.xOffset[i_263_], currentAnimation.yOffset[i_263_], currentAnimation.zOffset[i_263_]);

					}
				} else {
					for (int i1 = 0; i1 < currentAnimation.stepCount; i1++) {
						int n1 = currentAnimation.opcodeLinkTable[i1];
						int opcode = list1.opcodes[n1];
						int[] skin = list1.skinList[n1];
						int x = currentAnimation.xOffset[i1];
						int y = currentAnimation.yOffset[i1];
						int z = currentAnimation.zOffset[i1];
						boolean found = false;
						for (int i2 = 0; i2 < nextAnimation.stepCount; i2++) {
							int n2 = nextAnimation.opcodeLinkTable[i2];
							if (list2.skinList[n2].equals(skin)) {
								if (opcode != 2) {
									x += (nextAnimation.xOffset[i2] - x) * cycle / end;
									y += (nextAnimation.yOffset[i2] - y) * cycle / end;
									z += (nextAnimation.zOffset[i2] - z) * cycle / end;
								} else {
									x &= 0xff;
									y &= 0xff;
									z &= 0xff;
									int dx = nextAnimation.xOffset[i2] - x & 0xff;
									int dy = nextAnimation.yOffset[i2] - y & 0xff;
									int dz = nextAnimation.zOffset[i2] - z & 0xff;
									if (dx >= 128) {
										dx -= 256;
									}
									if (dy >= 128) {
										dy -= 256;
									}
									if (dz >= 128) {
										dz -= 256;
									}
									x = x + dx * cycle / end & 0xff;
									y = y + dy * cycle / end & 0xff;
									z = z + dz * cycle / end & 0xff;
								}
								found = true;
								break;
							}
						}
						if (!found) {
							if (opcode != 3 && opcode != 2) {
								x = x * (end - cycle) / end;
								y = y * (end - cycle) / end;
								z = z * (end - cycle) / end;
							} else if (opcode == 3) {
								x = (x * (end - cycle) + (cycle << 7)) / end;
								y = (y * (end - cycle) + (cycle << 7)) / end;
								z = (z * (end - cycle) + (cycle << 7)) / end;
							} else {
								x &= 0xff;
								y &= 0xff;
								z &= 0xff;
								int dx = -x & 0xff;
								int dy = -y & 0xff;
								int dz = -z & 0xff;
								if (dx >= 128) {
									dx -= 256;
								}
								if (dy >= 128) {
									dy -= 256;
								}
								if (dz >= 128) {
									dz -= 256;
								}
								x = x + dx * cycle / end & 0xff;
								y = y + dy * cycle / end & 0xff;
								z = z + dz * cycle / end & 0xff;
							}
						}
						method472(opcode, skin, x, y, z);
					}
				}
			}

		} catch(Exception e) {
		//	e.printStackTrace();
			applyTransform(firstFrame);
		}
	}

	public void method471(int ai[], int j, int k) {
		if (k == -1) {
			return;
		}
		if (ai == null || j == -1) {
			applyTransform(k);
			return;
		}
		FrameReader class36 = FrameReader.forId(k);
		if (class36 == null) {
			return;
		}
		FrameReader class36_1 = FrameReader.forId(j);
		if (class36_1 == null) {
			applyTransform(k);
			return;
		}
		SkinList class18 = class36.skinList;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		int l = 0;
		int i1 = ai[l++];
		for (int j1 = 0; j1 < class36.stepCount; j1++) {
			int k1;
			for (k1 = class36.opcodeLinkTable[j1]; k1 > i1; i1 = ai[l++]) {
				;
			}
			if (k1 != i1 || class18.opcodes[k1] == 0) {
				method472(class18.opcodes[k1], class18.skinList[k1], class36.xOffset[j1], class36.yOffset[j1], class36.zOffset[j1]);
			}
		}

		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		l = 0;
		i1 = ai[l++];
		for (int l1 = 0; l1 < class36_1.stepCount; l1++) {
			int i2;
			for (i2 = class36_1.opcodeLinkTable[l1]; i2 > i1; i1 = ai[l++]) {
				;
			}
			if (i2 == i1 || class18.opcodes[i2] == 0) {
				method472(class18.opcodes[i2], class18.skinList[i2], class36_1.xOffset[l1], class36_1.yOffset[l1], class36_1.zOffset[l1]);
			}
		}

	}

	private void method472(int i, int ai[], int j, int k, int l) {

		int i1 = ai.length;
		if (i == 0) {
			int j1 = 0;
			anInt1681 = 0;
			anInt1682 = 0;
			anInt1683 = 0;
			for (int k2 = 0; k2 < i1; k2++) {
				int l3 = ai[k2];
				if (l3 < vertexSkin.length) {
					int ai5[] = vertexSkin[l3];
					for (int j6 : ai5) {
						anInt1681 += verticesXCoordinate[j6];
						anInt1682 += verticesYCoordinate[j6];
						anInt1683 += verticesZCoordinate[j6];
						j1++;
					}

				}
			}

			if (j1 > 0) {
				anInt1681 = anInt1681 / j1 + j;
				anInt1682 = anInt1682 / j1 + k;
				anInt1683 = anInt1683 / j1 + l;
				return;
			} else {
				anInt1681 = j;
				anInt1682 = k;
				anInt1683 = l;
				return;
			}
		}
		if (i == 1) {
			for (int k1 = 0; k1 < i1; k1++) {
				int l2 = ai[k1];
				if (l2 < vertexSkin.length) {
					int ai1[] = vertexSkin[l2];
					for (int element : ai1) {
						int j5 = element;
						verticesXCoordinate[j5] += j;
						verticesYCoordinate[j5] += k;
						verticesZCoordinate[j5] += l;
					}

				}
			}

			return;
		}
		if (i == 2) {
			for (int l1 = 0; l1 < i1; l1++) {
				int i3 = ai[l1];
				if (i3 < vertexSkin.length) {
					int ai2[] = vertexSkin[i3];
					for (int element : ai2) {
						int k5 = element;
						verticesXCoordinate[k5] -= anInt1681;
						verticesYCoordinate[k5] -= anInt1682;
						verticesZCoordinate[k5] -= anInt1683;
						int k6 = (j & 0xff) * 8;
						int l6 = (k & 0xff) * 8;
						int i7 = (l & 0xff) * 8;
						if (i7 != 0) {
							int j7 = SINE[i7];
							int i8 = COSINE[i7];
							int l8 = verticesYCoordinate[k5] * j7 + verticesXCoordinate[k5] * i8 >> 16;
				verticesYCoordinate[k5] = verticesYCoordinate[k5] * i8 - verticesXCoordinate[k5] * j7 >> 16;
				verticesXCoordinate[k5] = l8;
						}
						if (k6 != 0) {
							int k7 = SINE[k6];
							int j8 = COSINE[k6];
							int i9 = verticesYCoordinate[k5] * j8 - verticesZCoordinate[k5] * k7 >> 16;
			verticesZCoordinate[k5] = verticesYCoordinate[k5] * k7 + verticesZCoordinate[k5] * j8 >> 16;
							verticesYCoordinate[k5] = i9;
						}
						if (l6 != 0) {
							int l7 = SINE[l6];
							int k8 = COSINE[l6];
							int j9 = verticesZCoordinate[k5] * l7 + verticesXCoordinate[k5] * k8 >> 16;
		verticesZCoordinate[k5] = verticesZCoordinate[k5] * k8 - verticesXCoordinate[k5] * l7 >> 16;
			verticesXCoordinate[k5] = j9;
						}
						verticesXCoordinate[k5] += anInt1681;
						verticesYCoordinate[k5] += anInt1682;
						verticesZCoordinate[k5] += anInt1683;
					}

				}
			}
			return;
		}
		if (i == 3) {
			for (int i2 = 0; i2 < i1; i2++) {
				int j3 = ai[i2];
				if (j3 < vertexSkin.length) {
					int ai3[] = vertexSkin[j3];
					for (int element : ai3) {
						int l5 = element;
						verticesXCoordinate[l5] -= anInt1681;
						verticesYCoordinate[l5] -= anInt1682;
						verticesZCoordinate[l5] -= anInt1683;
						verticesXCoordinate[l5] = verticesXCoordinate[l5] * j / 128;
						verticesYCoordinate[l5] = verticesYCoordinate[l5] * k / 128;
						verticesZCoordinate[l5] = verticesZCoordinate[l5] * l / 128;
						verticesXCoordinate[l5] += anInt1681;
						verticesYCoordinate[l5] += anInt1682;
						verticesZCoordinate[l5] += anInt1683;
					}
				}
			}
			return;
		}
		if (i == 5 && triangleSkin != null && anIntArray1639 != null) {
			for (int j2 = 0; j2 < i1; j2++) {
				int k3 = ai[j2];
				if (k3 < triangleSkin.length) {
					int ai4[] = triangleSkin[k3];
					for (int element : ai4) {
						int i6 = element;
						anIntArray1639[i6] += j * 8;
						if (anIntArray1639[i6] < 0) {
							anIntArray1639[i6] = 0;
						}
						if (anIntArray1639[i6] > 255) {
							anIntArray1639[i6] = 255;
						}
					}
				}
			}
		}
	}

	public void method473() {
		for (int j = 0; j < numberOfVerticeCoordinates; j++) {
			int k = verticesXCoordinate[j];
			verticesXCoordinate[j] = verticesZCoordinate[j];
			verticesZCoordinate[j] = -k;
		}
	}

	public void rotateX(int i) {
		int k = SINE[i];
		int l = COSINE[i];

		for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
			int j1 = verticesYCoordinate[i1] * l - verticesZCoordinate[i1] * k >> 16;
		verticesZCoordinate[i1] = verticesYCoordinate[i1] * k + verticesZCoordinate[i1] * l >> 16;
				verticesYCoordinate[i1] = j1;
		}
	}

	public void translate(int i, int j, int l) {
		for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
			verticesXCoordinate[i1] += i;
			verticesYCoordinate[i1] += j;
			verticesZCoordinate[i1] += l;
		}
	}

	public void method476(int i, int j) {
		for (int k = 0; k < anInt1630; k++) {
			if (anIntArray1640[k] == i) {
				anIntArray1640[k] = j;
			}
		}
	}

	public void method477() {
		for (int j = 0; j < numberOfVerticeCoordinates; j++) {
			verticesZCoordinate[j] = -verticesZCoordinate[j];
		}
		for (int k = 0; k < anInt1630; k++) {
			int l = anIntArray1631[k];
			anIntArray1631[k] = anIntArray1633[k];
			anIntArray1633[k] = l;
		}
	}

	public void scaleT(int i, int j, int l) {
		for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
			verticesXCoordinate[i1] = verticesXCoordinate[i1] * i / 128;
			verticesYCoordinate[i1] = verticesYCoordinate[i1] * l / 128;
			verticesZCoordinate[i1] = verticesZCoordinate[i1] * j / 128;
		}

	}

	public final void light(int i, int j, int k, int l, int i1, boolean flag) {
		int j1 = (int) Math.sqrt(k * k + l * l + i1 * i1);
		int k1 = j * j1 >> 8;
		if (anIntArray1634 == null) {
			anIntArray1634 = new int[anInt1630];
			anIntArray1635 = new int[anInt1630];
			anIntArray1636 = new int[anInt1630];
		}
		if (super.aClass33Array1425 == null) {
			super.aClass33Array1425 = new Class33[numberOfVerticeCoordinates];
			for (int l1 = 0; l1 < numberOfVerticeCoordinates; l1++) {
				super.aClass33Array1425[l1] = new Class33();
			}

		}
		for (int i2 = 0; i2 < anInt1630; i2++) {
			if (anIntArray1640 != null && anIntArray1639 != null) {
				if (anIntArray1640[i2] == 65535
						/*
						 * || (anIntArray1640[i2] == 0 // Black Triangles 633 // Models
						 * - Fixes Gwd walls // & Black models )
						 */|| anIntArray1640[i2] == 16705) {
					anIntArray1639[i2] = 255;
				}
			}
			int j2 = anIntArray1631[i2];
			int l2 = anIntArray1632[i2];
			int i3 = anIntArray1633[i2];
			int j3 = verticesXCoordinate[l2] - verticesXCoordinate[j2];
			int k3 = verticesYCoordinate[l2] - verticesYCoordinate[j2];
			int l3 = verticesZCoordinate[l2] - verticesZCoordinate[j2];
			int i4 = verticesXCoordinate[i3] - verticesXCoordinate[j2];
			int j4 = verticesYCoordinate[i3] - verticesYCoordinate[j2];
			int k4 = verticesZCoordinate[i3] - verticesZCoordinate[j2];
			int l4 = k3 * k4 - j4 * l3;
			int i5 = l3 * i4 - k4 * j3;
			int j5;
			for (j5 = j3 * j4 - i4 * k3; l4 > 8192 || i5 > 8192 || j5 > 8192 || l4 < -8192 || i5 < -8192 || j5 < -8192; j5 >>= 1) {
				l4 >>= 1;
			i5 >>= 1;
			}

			int k5 = (int) Math.sqrt(l4 * l4 + i5 * i5 + j5 * j5);
			if (k5 <= 0) {
				k5 = 1;
			}
			l4 = l4 * 256 / k5;
			i5 = i5 * 256 / k5;
			j5 = j5 * 256 / k5;

			if (anIntArray1637 == null || (anIntArray1637[i2] & 1) == 0) {

				Class33 class33_2 = super.aClass33Array1425[j2];
				class33_2.anInt602 += l4;
				class33_2.anInt603 += i5;
				class33_2.anInt604 += j5;
				class33_2.anInt605++;
				class33_2 = super.aClass33Array1425[l2];
				class33_2.anInt602 += l4;
				class33_2.anInt603 += i5;
				class33_2.anInt604 += j5;
				class33_2.anInt605++;
				class33_2 = super.aClass33Array1425[i3];
				class33_2.anInt602 += l4;
				class33_2.anInt603 += i5;
				class33_2.anInt604 += j5;
				class33_2.anInt605++;

			} else {

				int l5 = i + (k * l4 + l * i5 + i1 * j5) / (k1 + k1 / 2);
				anIntArray1634[i2] = method481(anIntArray1640[i2], l5, anIntArray1637[i2]);

			}
		}

		if (flag) {
			method480(i, k1, k, l, i1);
		} else {
			aClass33Array1660 = new Class33[numberOfVerticeCoordinates];
			for (int k2 = 0; k2 < numberOfVerticeCoordinates; k2++) {
				Class33 class33 = super.aClass33Array1425[k2];
				Class33 class33_1 = aClass33Array1660[k2] = new Class33();
				class33_1.anInt602 = class33.anInt602;
				class33_1.anInt603 = class33.anInt603;
				class33_1.anInt604 = class33.anInt604;
				class33_1.anInt605 = class33.anInt605;
			}

		}
		if (flag) {
			method466();
			return;
		} else {
			method468(21073);
			return;
		}
	}

	public final void method480(int i, int j, int k, int l, int i1) {
		for (int j1 = 0; j1 < anInt1630; j1++) {
			int k1 = anIntArray1631[j1];
			int i2 = anIntArray1632[j1];
			int j2 = anIntArray1633[j1];
			if (anIntArray1637 == null) {
				int i3 = anIntArray1640[j1];
				Class33 class33 = super.aClass33Array1425[k1];
				int k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604) / (j * class33.anInt605);
				anIntArray1634[j1] = method481(i3, k2, 0);
				class33 = super.aClass33Array1425[i2];
				k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604) / (j * class33.anInt605);
				anIntArray1635[j1] = method481(i3, k2, 0);
				class33 = super.aClass33Array1425[j2];
				k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604) / (j * class33.anInt605);
				anIntArray1636[j1] = method481(i3, k2, 0);
			} else if ((anIntArray1637[j1] & 1) == 0) {
				int j3 = anIntArray1640[j1];
				int k3 = anIntArray1637[j1];
				Class33 class33_1 = super.aClass33Array1425[k1];
				int l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604) / (j * class33_1.anInt605);
				anIntArray1634[j1] = method481(j3, l2, k3);
				class33_1 = super.aClass33Array1425[i2];
				l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604) / (j * class33_1.anInt605);
				anIntArray1635[j1] = method481(j3, l2, k3);
				class33_1 = super.aClass33Array1425[j2];
				l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604) / (j * class33_1.anInt605);
				anIntArray1636[j1] = method481(j3, l2, k3);
			}
		}

		super.aClass33Array1425 = null;
		aClass33Array1660 = null;
		anIntArray1655 = null;
		anIntArray1656 = null;
		if (anIntArray1637 != null) {
			for (int l1 = 0; l1 < anInt1630; l1++) {
				if ((anIntArray1637[l1] & 2) == 2) {
					return;
				}
			}

		}
		anIntArray1640 = null;
	}

	public final void renderSingle(int j, int k, int l, int i1, int j1, int k1) {
		int i = 0;
		int l1 = Rasterizer.centerX;
		int i2 = Rasterizer.centerY;
		int j2 = SINE[i];
		int k2 = COSINE[i];
		int l2 = SINE[j];
		int i3 = COSINE[j];
		int j3 = SINE[k];
		int k3 = COSINE[k];
		int l3 = SINE[l];
		int i4 = COSINE[l];
		int j4 = j1 * l3 + k1 * i4 >> 16;
			for (int k4 = 0; k4 < numberOfVerticeCoordinates; k4++) {
				int l4 = verticesXCoordinate[k4];
				int i5 = verticesYCoordinate[k4];
				int j5 = verticesZCoordinate[k4];
				if (k != 0) {
					int k5 = i5 * j3 + l4 * k3 >> 16;
			i5 = i5 * k3 - l4 * j3 >> 16;
			l4 = k5;
				}
				if (i != 0) {
					int l5 = i5 * k2 - j5 * j2 >> 16;
			j5 = i5 * j2 + j5 * k2 >> 16;
				i5 = l5;
				}
				if (j != 0) {
					int i6 = j5 * l2 + l4 * i3 >> 16;
								j5 = j5 * i3 - l4 * l2 >> 16;
				l4 = i6;
				}
				l4 += i1;
				i5 += j1;
				j5 += k1;
				int j6 = i5 * i4 - j5 * l3 >> 16;
		j5 = i5 * l3 + j5 * i4 >> 16;
								i5 = j6;
								anIntArray1667[k4] = j5 - j4;
								if (j5 == 0) {
									return;
								}
								anIntArray1665[k4] = l1 + (l4 << 9) / j5;
								anIntArray1666[k4] = i2 + (i5 << 9) / j5;
								if (anInt1642 > 0) {
									anIntArray1668[k4] = l4;
									anIntArray1669[k4] = i5;
									anIntArray1670[k4] = j5;
								}
			}

			try {
				translateToScreen(false, false, 0, 0);
				return;
			} catch (Exception _ex) {
				_ex.printStackTrace();
				return;
			}
	}

	@Override
	public void method443(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int uid, int newuid) {
		int j2 = l1 * i1 - j1 * l >> 16;
								int k2 = k1 * j + j2 * k >> 16;
								int l2 = anInt1650 * k >> 16;
		int i3 = k2 + l2;
		if (i3 <= 50 || k2 >= 3500) {
			return;
		}
		int j3 = l1 * l + j1 * i1 >> 16;
			int k3 = j3 - anInt1650 << Client.log_view_dist;
			if (k3 / i3 >= DrawingArea.centerY) {
				return;
			}
			int l3 = j3 + anInt1650 << Client.log_view_dist;
			if (l3 / i3 <= -DrawingArea.centerY) {
				return;
			}
			int i4 = k1 * k - j2 * j >> 16;
			int j4 = anInt1650 * j >> 16;
			int k4 = i4 + j4 << Client.log_view_dist;
			if (k4 / i3 <= -DrawingArea.middleY) {
				return;
			}
			int l4 = j4 + (super.modelHeight * k >> 16);
			int i5 = i4 - l4 << Client.log_view_dist;
			if (i5 / i3 >= DrawingArea.middleY) {
				return;
			}
			int j5 = l2 + (super.modelHeight * j >> 16);
			boolean flag = false;
			if (k2 - j5 <= 50) {
				flag = true;
			}
			boolean flag1 = false;
			if (uid > 0 && aBoolean1684) {
				int k5 = k2 - l2;
				if (k5 <= 50) {
					k5 = 50;
				}
				if (j3 > 0) {
					k3 /= i3;
					l3 /= k5;
				} else {
					l3 /= i3;
					k3 /= k5;
				}
				if (i4 > 0) {
					i5 /= i3;
					k4 /= k5;
				} else {
					k4 /= i3;
					i5 /= k5;
				}
				int i6 = anInt1685 - Rasterizer.centerX;
				int k6 = anInt1686 - Rasterizer.centerY;
				if (i6 > k3 && i6 < l3 && k6 > i5 && k6 < k4) {
					if (aBoolean1659) {
						mapObjIds[anInt1687] = newuid;
						anIntArray1688[anInt1687++] = uid;
					} else {
						flag1 = true;
					}
				}
			}
			int l5 = Rasterizer.centerX;
			int j6 = Rasterizer.centerY;
			int l6 = 0;
			int i7 = 0;
			if (i != 0) {
				l6 = SINE[i];
				i7 = COSINE[i];
			}
			for (int j7 = 0; j7 < numberOfVerticeCoordinates; j7++) {
				int k7 = verticesXCoordinate[j7];
				int l7 = verticesYCoordinate[j7];
				int i8 = verticesZCoordinate[j7];
				if (i != 0) {
					int j8 = i8 * l6 + k7 * i7 >> 16;
			i8 = i8 * i7 - k7 * l6 >> 16;
			k7 = j8;
				}
				k7 += j1;
				l7 += k1;
				i8 += l1;
				int k8 = i8 * l + k7 * i1 >> 16;
				i8 = i8 * i1 - k7 * l >> 16;
			k7 = k8;
			k8 = l7 * k - i8 * j >> 16;
			i8 = l7 * j + i8 * k >> 16;
			l7 = k8;
			anIntArray1667[j7] = i8 - k2;
			if (i8 >= 50) {
				anIntArray1665[j7] = l5 + (k7 << Client.log_view_dist) / i8;
				anIntArray1666[j7] = j6 + (l7 << Client.log_view_dist) / i8;
			} else {
				anIntArray1665[j7] = -5000;
				flag = true;
			}
			if (flag || anInt1642 > 0) {
				anIntArray1668[j7] = k7;
				anIntArray1669[j7] = l7;
				anIntArray1670[j7] = i8;
			} else if (fog) {
				anIntArray1670[j7] = i8;
			}
			}
			try {
				translateToScreen(flag, flag1, uid, newuid);
				return;
			} catch (Exception _ex) {
				return;
			}
	}

	public static boolean fog;

	private final void translateToScreen(boolean flag, boolean flag1, int i, int id) {
		for (int j = 0; j < diagonal3D; j++) {
			depthListIndices[j] = 0;
		}

		for (int k = 0; k < anInt1630; k++) {
			if (anIntArray1637 == null || anIntArray1637[k] != -1) {
				int l = anIntArray1631[k];
				int k1 = anIntArray1632[k];
				int j2 = anIntArray1633[k];
				int i3 = anIntArray1665[l];
				int l3 = anIntArray1665[k1];
				int k4 = anIntArray1665[j2];
				if (flag && (i3 == -5000 || l3 == -5000 || k4 == -5000)) {
					outOfReach[k] = true;
					int j5 = (anIntArray1667[l] + anIntArray1667[k1] + anIntArray1667[j2]) / 3 + anInt1653;
					faceLists[j5][depthListIndices[j5]++] = k;
				} else {
					if (flag1 && method486(anInt1685, anInt1686, anIntArray1666[l], anIntArray1666[k1], anIntArray1666[j2], i3, l3, k4)) {
						mapObjIds[anInt1687] = id;
						anIntArray1688[anInt1687++] = i;
						flag1 = false;
					}
					if ((i3 - l3) * (anIntArray1666[j2] - anIntArray1666[k1]) - (anIntArray1666[l] - anIntArray1666[k1]) * (k4 - l3) > 0) {
						outOfReach[k] = false;
						if (i3 < 0 || l3 < 0 || k4 < 0 || i3 > DrawingArea.centerX || l3 > DrawingArea.centerX || k4 > DrawingArea.centerX) {
							aBooleanArray1663[k] = true;
						} else {
							aBooleanArray1663[k] = false;
						}
						int k5 = (anIntArray1667[l] + anIntArray1667[k1] + anIntArray1667[j2]) / 3 + anInt1653;
						faceLists[k5][depthListIndices[k5]++] = k;
					}
				}
			}
		}

		if (face_render_priorities == null) {
			for (int i1 = diagonal3D - 1; i1 >= 0; i1--) {
				int l1 = depthListIndices[i1];
				if (l1 > 0) {
					int ai[] = faceLists[i1];
					for (int j3 = 0; j3 < l1; j3++) {
						rasterise(ai[j3]);
					}

				}
			}

			return;
		}
		for (int j1 = 0; j1 < 12; j1++) {
			anIntArray1673[j1] = 0;
			anIntArray1677[j1] = 0;
		}

		for (int i2 = diagonal3D - 1; i2 >= 0; i2--) {
			int k2 = depthListIndices[i2];
			if (k2 > 0) {
				int ai1[] = faceLists[i2];
				for (int i4 = 0; i4 < k2; i4++) {
					int l4 = ai1[i4];
					int l5 = face_render_priorities[l4];
					int j6 = anIntArray1673[l5]++;
					anIntArrayArray1674[l5][j6] = l4;
					if (l5 < 10) {
						anIntArray1677[l5] += i2;
					} else if (l5 == 10) {
						anIntArray1675[j6] = i2;
					} else {
						anIntArray1676[j6] = i2;
					}
				}

			}
		}

		int l2 = 0;
		if (anIntArray1673[1] > 0 || anIntArray1673[2] > 0) {
			l2 = (anIntArray1677[1] + anIntArray1677[2]) / (anIntArray1673[1] + anIntArray1673[2]);
		}
		int k3 = 0;
		if (anIntArray1673[3] > 0 || anIntArray1673[4] > 0) {
			k3 = (anIntArray1677[3] + anIntArray1677[4]) / (anIntArray1673[3] + anIntArray1673[4]);
		}
		int j4 = 0;
		if (anIntArray1673[6] > 0 || anIntArray1673[8] > 0) {
			j4 = (anIntArray1677[6] + anIntArray1677[8]) / (anIntArray1673[6] + anIntArray1673[8]);
		}
		int i6 = 0;
		int k6 = anIntArray1673[10];
		int ai2[] = anIntArrayArray1674[10];
		int ai3[] = anIntArray1675;
		if (i6 == k6) {
			i6 = 0;
			k6 = anIntArray1673[11];
			ai2 = anIntArrayArray1674[11];
			ai3 = anIntArray1676;
		}
		int i5;
		if (i6 < k6) {
			i5 = ai3[i6];
		} else {
			i5 = -1000;
		}
		for (int l6 = 0; l6 < 10; l6++) {
			while (l6 == 0 && i5 > l2) {
				rasterise(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6) {
					i5 = ai3[i6];
				} else {
					i5 = -1000;
				}
			}
			while (l6 == 3 && i5 > k3) {
				rasterise(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6) {
					i5 = ai3[i6];
				} else {
					i5 = -1000;
				}
			}
			while (l6 == 5 && i5 > j4) {
				rasterise(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6) {
					i5 = ai3[i6];
				} else {
					i5 = -1000;
				}
			}
			int i7 = anIntArray1673[l6];
			int ai4[] = anIntArrayArray1674[l6];
			for (int j7 = 0; j7 < i7; j7++) {
				rasterise(ai4[j7]);
			}

		}

		while (i5 != -1000) {
			rasterise(ai2[i6++]);
			if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
				i6 = 0;
				ai2 = anIntArrayArray1674[11];
				k6 = anIntArray1673[11];
				ai3 = anIntArray1676;
			}
			if (i6 < k6) {
				i5 = ai3[i6];
			} else {
				i5 = -1000;
			}
		}
	}

	private final void rasterise(int i) {
		if (outOfReach[i]) {
			method485(i);
			return;
		}
		int j = anIntArray1631[i];
		int k = anIntArray1632[i];
		int l = anIntArray1633[i];
		Rasterizer.aBoolean1462 = aBooleanArray1663[i];
		if (anIntArray1639 == null) {
			Rasterizer.anInt1465 = 0;
		} else {
			Rasterizer.anInt1465 = anIntArray1639[i];
		}
		int i1;
		if (anIntArray1637 == null) {
			i1 = 0;
		} else {
			i1 = anIntArray1637[i] & 3;
		}
		if (i1 == 0) {
			Rasterizer.method374(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1634[i], anIntArray1635[i], anIntArray1636[i]);
			if (fog) { 
				Rasterizer.drawFogTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1670[j], anIntArray1670[k], anIntArray1670[l]);
			}
		} else if (i1 == 1) {
			Rasterizer.method376(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], modelIntArray3[anIntArray1634[i]]);
			if (fog) {
				Rasterizer.drawFogTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1670[j], anIntArray1670[k], anIntArray1670[l]);
			}
		} else if (i1 == 2) {
			int j1 = anIntArray1637[i] >> 2;
			int l1 = anIntArray1643[j1];
			int j2 = anIntArray1644[j1];
			int l2 = anIntArray1645[j1];
			Rasterizer.method378(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1634[i], anIntArray1635[i], anIntArray1636[i], anIntArray1668[l1], anIntArray1668[j2], anIntArray1668[l2], anIntArray1669[l1], anIntArray1669[j2], anIntArray1669[l2], anIntArray1670[l1], anIntArray1670[j2], anIntArray1670[l2], anIntArray1640[i]);
			if (fog) {
				Rasterizer.drawTexturedFogTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1670[j], anIntArray1670[k], anIntArray1670[l], anIntArray1668[l1], anIntArray1668[j2], anIntArray1668[l2], anIntArray1669[l1], anIntArray1669[j2], anIntArray1669[l2], anIntArray1670[l1], anIntArray1670[j2], anIntArray1670[l2], anIntArray1640[i]);
			}
		} else if (i1 == 3) {
			int k1 = anIntArray1637[i] >> 2;
				int i2 = anIntArray1643[k1];
				int k2 = anIntArray1644[k1];
				int i3 = anIntArray1645[k1];
				Rasterizer.method378(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], anIntArray1668[i2], anIntArray1668[k2], anIntArray1668[i3], anIntArray1669[i2], anIntArray1669[k2], anIntArray1669[i3], anIntArray1670[i2], anIntArray1670[k2], anIntArray1670[i3], anIntArray1640[i]);
				if (fog) {
					Rasterizer.drawTexturedFogTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1670[j], anIntArray1670[k], anIntArray1670[l], anIntArray1668[i2], anIntArray1668[k2], anIntArray1668[i3], anIntArray1669[i2], anIntArray1669[k2], anIntArray1669[i3], anIntArray1670[i2], anIntArray1670[k2], anIntArray1670[i3], anIntArray1640[i]);
				}
		}
	}

	private final void method485(int i) {
		if (anIntArray1640 != null) {
			if (anIntArray1640[i] == 65535) {
				return;
			}
		}
		int j = Rasterizer.centerX;
		int k = Rasterizer.centerY;
		int l = 0;
		int i1 = anIntArray1631[i];
		int j1 = anIntArray1632[i];
		int k1 = anIntArray1633[i];
		int l1 = anIntArray1670[i1];
		int i2 = anIntArray1670[j1];
		int j2 = anIntArray1670[k1];

		if (l1 >= 50) {
			anIntArray1678[l] = anIntArray1665[i1];
			anIntArray1679[l] = anIntArray1666[i1];
			anIntArray1680[l++] = anIntArray1634[i];
		} else {
			int k2 = anIntArray1668[i1];
			int k3 = anIntArray1669[i1];
			int k4 = anIntArray1634[i];
			if (j2 >= 50) {
				int k5 = (50 - l1) * modelIntArray4[j2 - l1];
				anIntArray1678[l] = j + (k2 + ((anIntArray1668[k1] - k2) * k5 >> 16) << Client.log_view_dist) / 50;
				anIntArray1679[l] = k + (k3 + ((anIntArray1669[k1] - k3) * k5 >> 16) << Client.log_view_dist) / 50;
				anIntArray1680[l++] = k4 + ((anIntArray1636[i] - k4) * k5 >> 16);
			}
			if (i2 >= 50) {
				int l5 = (50 - l1) * modelIntArray4[i2 - l1];
				anIntArray1678[l] = j + (k2 + ((anIntArray1668[j1] - k2) * l5 >> 16) << Client.log_view_dist) / 50;
				anIntArray1679[l] = k + (k3 + ((anIntArray1669[j1] - k3) * l5 >> 16) << Client.log_view_dist) / 50;
				anIntArray1680[l++] = k4 + ((anIntArray1635[i] - k4) * l5 >> 16);
			}
		}
		if (i2 >= 50) {
			anIntArray1678[l] = anIntArray1665[j1];
			anIntArray1679[l] = anIntArray1666[j1];
			anIntArray1680[l++] = anIntArray1635[i];
		} else {
			int l2 = anIntArray1668[j1];
			int l3 = anIntArray1669[j1];
			int l4 = anIntArray1635[i];
			if (l1 >= 50) {
				int i6 = (50 - i2) * modelIntArray4[l1 - i2];
				anIntArray1678[l] = j + (l2 + ((anIntArray1668[i1] - l2) * i6 >> 16) << Client.log_view_dist) / 50;
				anIntArray1679[l] = k + (l3 + ((anIntArray1669[i1] - l3) * i6 >> 16) << Client.log_view_dist) / 50;
				anIntArray1680[l++] = l4 + ((anIntArray1634[i] - l4) * i6 >> 16);
			}
			if (j2 >= 50) {
				int j6 = (50 - i2) * modelIntArray4[j2 - i2];
				anIntArray1678[l] = j + (l2 + ((anIntArray1668[k1] - l2) * j6 >> 16) << Client.log_view_dist) / 50;
				anIntArray1679[l] = k + (l3 + ((anIntArray1669[k1] - l3) * j6 >> 16) << Client.log_view_dist) / 50;
				anIntArray1680[l++] = l4 + ((anIntArray1636[i] - l4) * j6 >> 16);
			}
		}
		if (j2 >= 50) {
			anIntArray1678[l] = anIntArray1665[k1];
			anIntArray1679[l] = anIntArray1666[k1];
			anIntArray1680[l++] = anIntArray1636[i];
		} else {
			int i3 = anIntArray1668[k1];
			int i4 = anIntArray1669[k1];
			int i5 = anIntArray1636[i];
			if (i2 >= 50) {
				int k6 = (50 - j2) * modelIntArray4[i2 - j2];
				anIntArray1678[l] = j + (i3 + ((anIntArray1668[j1] - i3) * k6 >> 16) << Client.log_view_dist) / 50;
				anIntArray1679[l] = k + (i4 + ((anIntArray1669[j1] - i4) * k6 >> 16) << Client.log_view_dist) / 50;
				anIntArray1680[l++] = i5 + ((anIntArray1635[i] - i5) * k6 >> 16);
			}
			if (l1 >= 50) {
				int l6 = (50 - j2) * modelIntArray4[l1 - j2];
				anIntArray1678[l] = j + (i3 + ((anIntArray1668[i1] - i3) * l6 >> 16) << Client.log_view_dist) / 50;
				anIntArray1679[l] = k + (i4 + ((anIntArray1669[i1] - i4) * l6 >> 16) << Client.log_view_dist) / 50;
				anIntArray1680[l++] = i5 + ((anIntArray1634[i] - i5) * l6 >> 16);
			}
		}
		int j3 = anIntArray1678[0];
		int j4 = anIntArray1678[1];
		int j5 = anIntArray1678[2];
		int i7 = anIntArray1679[0];
		int j7 = anIntArray1679[1];
		int k7 = anIntArray1679[2];
		if ((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0) {
			Rasterizer.aBoolean1462 = false;
			if (l == 3) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.centerX || j4 > DrawingArea.centerX || j5 > DrawingArea.centerX) {
					Rasterizer.aBoolean1462 = true;
				}
				int l7;
				if (anIntArray1637 == null) {
					l7 = 0;
				} else {
					l7 = anIntArray1637[i] & 3;
				}
				if (l7 == 0) {
					Rasterizer.method374(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2]);
				} else if (l7 == 1) {
					Rasterizer.method376(i7, j7, k7, j3, j4, j5, modelIntArray3[anIntArray1634[i]]);
				} else if (l7 == 2) {
					int j8 = anIntArray1637[i] >> 2;
					int k9 = anIntArray1643[j8];
					int k10 = anIntArray1644[j8];
					int k11 = anIntArray1645[j8];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], anIntArray1668[k9], anIntArray1668[k10], anIntArray1668[k11], anIntArray1669[k9], anIntArray1669[k10], anIntArray1669[k11], anIntArray1670[k9], anIntArray1670[k10], anIntArray1670[k11], anIntArray1640[i]);
				} else if (l7 == 3) {
					int k8 = anIntArray1637[i] >> 2;
					int l9 = anIntArray1643[k8];
					int l10 = anIntArray1644[k8];
					int l11 = anIntArray1645[k8];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5, anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], anIntArray1668[l9], anIntArray1668[l10], anIntArray1668[l11], anIntArray1669[l9], anIntArray1669[l10], anIntArray1669[l11], anIntArray1670[l9], anIntArray1670[l10], anIntArray1670[l11], anIntArray1640[i]);
				}
			}
			if (l == 4) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.centerX || j4 > DrawingArea.centerX || j5 > DrawingArea.centerX || anIntArray1678[3] < 0 || anIntArray1678[3] > DrawingArea.centerX) {
					Rasterizer.aBoolean1462 = true;
				}
				int i8;
				if (anIntArray1637 == null) {
					i8 = 0;
				} else {
					i8 = anIntArray1637[i] & 3;
				}
				if (i8 == 0) {
					Rasterizer.method374(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2]);
					Rasterizer.method374(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3]);
					return;
				}
				if (i8 == 1) {
					int l8 = modelIntArray3[anIntArray1634[i]];
					Rasterizer.method376(i7, j7, k7, j3, j4, j5, l8);
					Rasterizer.method376(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], l8);
					return;
				}
				if (i8 == 2) {
					int i9 = anIntArray1637[i] >> 2;
					int i10 = anIntArray1643[i9];
					int i11 = anIntArray1644[i9];
					int i12 = anIntArray1645[i9];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], anIntArray1668[i10], anIntArray1668[i11], anIntArray1668[i12], anIntArray1669[i10], anIntArray1669[i11], anIntArray1669[i12], anIntArray1670[i10], anIntArray1670[i11], anIntArray1670[i12], anIntArray1640[i]);
					Rasterizer.method378(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3], anIntArray1668[i10], anIntArray1668[i11], anIntArray1668[i12], anIntArray1669[i10], anIntArray1669[i11], anIntArray1669[i12], anIntArray1670[i10], anIntArray1670[i11], anIntArray1670[i12], anIntArray1640[i]);
					return;
				}
				if (i8 == 3) {
					int j9 = anIntArray1637[i] >> 2;
					int j10 = anIntArray1643[j9];
					int j11 = anIntArray1644[j9];
					int j12 = anIntArray1645[j9];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5, anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], anIntArray1668[j10], anIntArray1668[j11], anIntArray1668[j12], anIntArray1669[j10], anIntArray1669[j11], anIntArray1669[j12], anIntArray1670[j10], anIntArray1670[j11], anIntArray1670[j12], anIntArray1640[i]);
					Rasterizer.method378(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], anIntArray1668[j10], anIntArray1668[j11], anIntArray1668[j12], anIntArray1669[j10], anIntArray1669[j11], anIntArray1669[j12], anIntArray1670[j10], anIntArray1670[j11], anIntArray1670[j12], anIntArray1640[i]);
				}
			}
		}
	}

	private final boolean method486(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
		if (j < k && j < l && j < i1) {
			return false;
		}
		if (j > k && j > l && j > i1) {
			return false;
		}
		if (i < j1 && i < k1 && i < l1) {
			return false;
		}
		return i <= j1 || i <= k1 || i <= l1;
	}

	/*
	 * void read814Model(byte[] instream) { int maxDepth = 0; int numTriangles =
	 * 0; byte priority = (byte)0; int numTextureTriangles = 0; ByteBuffer
	 * class588_sub11 = new ByteBuffer(instream); ByteBuffer class588_sub11_156_
	 * = new ByteBuffer(instream); ByteBuffer class588_sub11_157_ = new
	 * ByteBuffer(instream); ByteBuffer class588_sub11_158_ = new
	 * ByteBuffer(instream); ByteBuffer class588_sub11_159_ = new
	 * ByteBuffer(instream); ByteBuffer class588_sub11_160_ = new
	 * ByteBuffer(instream); ByteBuffer class588_sub11_161_ = new
	 * ByteBuffer(instream); int type =
	 * class588_sub11.getUnsignedByte();//ReadUnsignedByte(); if (type != 1)
	 * System.out.println(type);//Console.WriteLine(type); else {
	 * class588_sub11.getUnsignedByte(); int version =
	 * class588_sub11.getUnsignedByte(); class588_sub11.bitPosition =
	 * instream.length - 26; int numVertices =
	 * class588_sub11.getUnsignedShort();//ReadUnsignedShort(); numTriangles =
	 * class588_sub11.getUnsignedShort(); numTextureTriangles =
	 * class588_sub11.getUnsignedShort(); int flags =
	 * class588_sub11.getUnsignedByte(); boolean bool_1 = (flags & 0x1) == 1;
	 * boolean bool_163_ = (flags & 0x2) == 2; boolean bool_164_ = (flags & 0x4)
	 * == 4; boolean bool_165_ = (flags & 0x10) == 16; boolean bool_166_ =
	 * (flags & 0x20) == 32; boolean bool_167_ = (flags & 0x40) == 64; boolean
	 * hasUVCoordinates = (flags & 0x80) == 128; int i_169_ =
	 * class588_sub11.getUnsignedByte(); int i_170_ =
	 * class588_sub11.getUnsignedByte(); int i_171_ =
	 * class588_sub11.getUnsignedByte(); int i_172_ =
	 * class588_sub11.getUnsignedByte(); int i_173_ =
	 * class588_sub11.getUnsignedByte(); int i_174_ =
	 * class588_sub11.getUnsignedShort(); int i_175_ =
	 * class588_sub11.getUnsignedShort(); int i_176_ =
	 * class588_sub11.getUnsignedShort(); int i_177_ =
	 * class588_sub11.getUnsignedShort(); int i_178_ =
	 * class588_sub11.getUnsignedShort(); int i_179_ =
	 * class588_sub11.getUnsignedShort(); int i_180_ =
	 * class588_sub11.getUnsignedShort(); if (!bool_165_) { if (i_173_ == 1)
	 * i_179_ = numVertices; else i_179_ = 0; } if (!bool_166_) { if (i_171_ ==
	 * 1) i_180_ = numTriangles; else i_180_ = 0; } int i_181_ = 0; int i_182_ =
	 * 0; int i_183_ = 0; if (((Model)this).numTextureTriangles > 0) {
	 * textureRenderTypes = new sbyte[numTextureTriangles];
	 * class588_sub11.mainStream.Position = 3; for (int i_184_ = 0; i_184_ <
	 * numTextureTriangles; i_184_++) { sbyte i_185_ =
	 * (textureRenderTypes[i_184_] = (sbyte)class588_sub11.ReadByte()); if
	 * (i_185_ == 0) i_181_++; if (i_185_ >= 1 && i_185_ <= 3) i_182_++; if
	 * (i_185_ == 2) i_183_++; } } int i_186_ = 3 +
	 * ((Model)this).numTextureTriangles; int i_187_ = i_186_; i_186_ +=
	 * numVertices; int i_188_ = i_186_; if (bool_1) i_186_ += numTriangles; int
	 * i_189_ = i_186_; i_186_ += numTriangles; int i_190_ = i_186_; if (i_169_
	 * == 255) i_186_ += numTriangles; int i_191_ = i_186_; i_186_ += i_180_;
	 * int i_192_ = i_186_; i_186_ += i_179_; int i_193_ = i_186_; if (i_170_ ==
	 * 1) i_186_ += numTriangles; int i_194_ = i_186_; i_186_ += i_177_; int
	 * i_195_ = i_186_; if (i_172_ == 1) i_186_ += numTriangles * 2; int i_196_
	 * = i_186_; i_186_ += i_178_; int i_197_ = i_186_; i_186_ += numTriangles *
	 * 2; int i_198_ = i_186_; i_186_ += i_174_; int i_199_ = i_186_; i_186_ +=
	 * i_175_; int i_200_ = i_186_; i_186_ += i_176_; int i_201_ = i_186_;
	 * i_186_ += i_181_ * 6; int i_202_ = i_186_; i_186_ += i_182_ * 6; int
	 * i_203_ = 6; if (version == 14) i_203_ = 7; else if (version >= 15) i_203_
	 * = 9; int i_204_ = i_186_; i_186_ += i_182_ * i_203_; int i_205_ = i_186_;
	 * i_186_ += i_182_; int i_206_ = i_186_; i_186_ += i_182_; int i_207_ =
	 * i_186_; i_186_ += i_182_ + i_183_ * 2; int i_208_ = i_186_; int i_209_ =
	 * instream.Length; int i_210_ = instream.Length; int i_211_ =
	 * instream.Length; int i_212_ = instream.Length; if (hasUVCoordinates) {
	 * ExtendedBufferReader class588_sub11_213_ = new ExtendedBufferReader(new
	 * MemoryStream((byte[])(Array)instream));
	 * class588_sub11_213_.mainStream.Position = (instream.Length - 26);
	 * class588_sub11_213_.mainStream.Position -=
	 * instream[class588_sub11_213_.mainStream.Position - 1];
	 * ((Model)this).anInt1234 = class588_sub11_213_.getUnsignedShort(); int
	 * i_214_ = class588_sub11_213_.getUnsignedShort(); int i_215_ =
	 * class588_sub11_213_.getUnsignedShort(); i_209_ = i_208_ + i_214_; i_210_
	 * = i_209_ + i_215_; i_211_ = i_210_ + numVertices; i_212_ = i_211_ +
	 * ((Model)this).anInt1234 * 2; } verticesX = new int[numVertices];
	 * verticesY = new int[numVertices]; verticesZ = new int[numVertices];
	 * triangleViewspaceX = new short[numTriangles]; triangleViewspaceY = new
	 * short[numTriangles]; triangleViewspaceZ = new short[numTriangles]; if
	 * (i_173_ == 1) vertexSkins = new int[numVertices]; if (bool_1)
	 * faceRenderType = new byte[numTriangles]; if (i_169_ == 255)
	 * trianglePriorities = new sbyte[numTriangles]; else ((Model)this).priority
	 * = (sbyte)i_169_; if (i_170_ == 1) faceAlpha = new sbyte[numTriangles]; if
	 * (i_171_ == 1) triangleSkinValues = new int[numTriangles]; if (i_172_ ==
	 * 1) faceTexture = new short[numTriangles]; if (i_172_ == 1 &&
	 * (((Model)this).numTextureTriangles > 0 || ((Model)this).anInt1234 > 0))
	 * textureCoords = new short[numTriangles]; colorValues = new
	 * short[numTriangles]; if (((Model)this).numTextureTriangles > 0) {
	 * textureTrianglePIndex = new ushort[((Model)this).numTextureTriangles];
	 * textureTriangleMIndex = new ushort[((Model)this).numTextureTriangles];
	 * textureTriangleNIndex = new ushort[((Model)this).numTextureTriangles]; if
	 * (i_182_ > 0) { particleDirectionX = new int[i_182_]; particleDirectionY =
	 * new int[i_182_]; particleDirectionZ = new int[i_182_]; particleLifespanX
	 * = new sbyte[i_182_]; particleLifespanY = new sbyte[i_182_];
	 * particleLifespanZ = new int[i_182_]; } if (i_183_ > 0) {
	 * texturePrimaryColor = new int[i_183_]; textureSecondaryColor = new
	 * int[i_183_]; } } class588_sub11.mainStream.Position = i_187_;
	 * class588_sub11_156_.mainStream.Position = i_198_;
	 * class588_sub11_157_.mainStream.Position = i_199_;
	 * class588_sub11_158_.mainStream.Position = i_200_;
	 * class588_sub11_159_.mainStream.Position = i_192_; int i_216_ = 0; int
	 * i_217_ = 0; int i_218_ = 0; for (int i_219_ = 0; i_219_ < numVertices;
	 * i_219_++) { int i_220_ = class588_sub11.getUnsignedByte(); int i_221_ =
	 * 0; if ((i_220_ & 0x1) != 0) i_221_ =
	 * class588_sub11_156_.ReadUnsignedSmart(); int i_222_ = 0; if ((i_220_ &
	 * 0x2) != 0) i_222_ = class588_sub11_157_.ReadUnsignedSmart(); int i_223_ =
	 * 0; if ((i_220_ & 0x4) != 0) i_223_ =
	 * class588_sub11_158_.ReadUnsignedSmart(); verticesX[i_219_] = i_216_ +
	 * i_221_; verticesY[i_219_] = i_217_ + i_222_; verticesZ[i_219_] = i_218_ +
	 * i_223_; i_216_ = verticesX[i_219_]; i_217_ = verticesY[i_219_]; i_218_ =
	 * verticesZ[i_219_]; if (i_173_ == 1) { if (bool_165_) vertexSkins[i_219_]
	 * = class588_sub11_159_ .ReadSpecialSmart(); else { vertexSkins[i_219_] =
	 * class588_sub11_159_ .getUnsignedByte(); if (vertexSkins[i_219_] == 255)
	 * vertexSkins[i_219_] = -1; } } } if (((Model)this).anInt1234 > 0) {
	 * class588_sub11.mainStream.Position = i_210_;
	 * class588_sub11_156_.mainStream.Position = i_211_;
	 * class588_sub11_157_.mainStream.Position = i_212_; anIntArray1231 = new
	 * int[numVertices]; int i_224_ = 0; int i_225_ = 0; for (; i_224_ <
	 * numVertices; i_224_++) { anIntArray1231[i_224_] = i_225_; i_225_ +=
	 * class588_sub11.getUnsignedByte(); } aByteArray1241 = new
	 * byte[numTriangles]; aByteArray1266 = new byte[numTriangles];
	 * aByteArray1243 = new byte[numTriangles]; texCoordU = new
	 * float[((Model)this).anInt1234]; texCoordV = new
	 * float[((Model)this).anInt1234]; for (i_224_ = 0; i_224_ <
	 * ((Model)this).anInt1234; i_224_++) { texCoordU[i_224_] =
	 * ((float)class588_sub11_156_ .ReadShort() / 4096.0F); texCoordV[i_224_] =
	 * ((float)class588_sub11_157_ .ReadShort() / 4096.0F); } }
	 * class588_sub11.mainStream.Position = i_197_;
	 * class588_sub11_156_.mainStream.Position = i_188_;
	 * class588_sub11_157_.mainStream.Position = i_190_;
	 * class588_sub11_158_.mainStream.Position = i_193_;
	 * class588_sub11_159_.mainStream.Position = i_191_;
	 * class588_sub11_160_.mainStream.Position = i_195_;
	 * class588_sub11_161_.mainStream.Position = i_196_; for (int i_226_ = 0;
	 * i_226_ < numTriangles; i_226_++) { colorValues[i_226_] =
	 * (short)class588_sub11 .getUnsignedShort(); if (bool_1)
	 * faceRenderType[i_226_] = (byte)class588_sub11_156_ .ReadByte(); if
	 * (i_169_ == 255) trianglePriorities[i_226_] = (sbyte)class588_sub11_157_
	 * .ReadByte(); if (i_170_ == 1) faceAlpha[i_226_] =
	 * (sbyte)class588_sub11_158_ .ReadByte(); if (i_171_ == 1) { if (bool_166_)
	 * triangleSkinValues[i_226_] = class588_sub11_159_ .ReadSpecialSmart();
	 * else { triangleSkinValues[i_226_] = class588_sub11_159_
	 * .getUnsignedByte(); if (triangleSkinValues[i_226_] == 255)
	 * triangleSkinValues[i_226_] = -1; } } if (i_172_ == 1) faceTexture[i_226_]
	 * = (short)(class588_sub11_160_ .getUnsignedShort() - 1); if (textureCoords
	 * != null) { if (faceTexture[i_226_] != -1) { if (version >= 16)
	 * textureCoords[i_226_] = (short)(class588_sub11_161_ .ReadSmart() - 1);
	 * else textureCoords[i_226_] = (short)(class588_sub11_161_
	 * .getUnsignedByte() - 1); } else textureCoords[i_226_] = (short)-1; } }
	 * maxDepth = -1; class588_sub11.mainStream.Position = i_194_;
	 * class588_sub11_156_.mainStream.Position = i_189_;
	 * class588_sub11_157_.mainStream.Position = i_209_;
	 * calculateMaxDepth(class588_sub11, class588_sub11_156_,
	 * class588_sub11_157_); class588_sub11.mainStream.Position = i_201_;
	 * class588_sub11_156_.mainStream.Position = i_202_;
	 * class588_sub11_157_.mainStream.Position = i_204_;
	 * class588_sub11_158_.mainStream.Position = i_205_;
	 * class588_sub11_159_.mainStream.Position = i_206_;
	 * class588_sub11_160_.mainStream.Position = i_207_;
	 * decodeTexturedTriangles(class588_sub11, class588_sub11_156_,
	 * class588_sub11_157_, class588_sub11_158_, class588_sub11_159_,
	 * class588_sub11_160_); class588_sub11.mainStream.Position = i_208_; if
	 * (bool_163_) { int i_227_ = class588_sub11.getUnsignedByte(); if (i_227_ >
	 * 0) { surfaces = new Surface[i_227_]; for (int i_228_ = 0; i_228_ <
	 * i_227_; i_228_++) { int i_229_ = class588_sub11 .getUnsignedShort(); int
	 * i_230_ = class588_sub11 .getUnsignedShort(); sbyte i_231_; if (i_169_ ==
	 * 255) i_231_ = trianglePriorities[i_230_]; else i_231_ = (sbyte)i_169_;
	 * surfaces[i_228_] = new Surface(i_229_, i_230_,
	 * triangleViewspaceX[i_230_], triangleViewspaceY[i_230_],
	 * triangleViewspaceZ[i_230_], (byte)i_231_); } } int i_232_ =
	 * class588_sub11.getUnsignedByte(); if (i_232_ > 0) { surfaceSkins = new
	 * SurfaceSkin[i_232_]; for (int i_233_ = 0; i_233_ < i_232_; i_233_++) {
	 * int i_234_ = class588_sub11 .getUnsignedShort(); int i_235_ =
	 * class588_sub11 .getUnsignedShort(); surfaceSkins[i_233_] = new
	 * SurfaceSkin(i_234_, i_235_); } } } if (bool_164_) { int i_236_ =
	 * class588_sub11.getUnsignedByte(); if (i_236_ > 0) { isolatedVertexNormals
	 * = new VertexNormal[i_236_]; for (int i_237_ = 0; i_237_ < i_236_;
	 * i_237_++) { int i_238_ = class588_sub11 .getUnsignedShort(); int i_239_ =
	 * class588_sub11 .getUnsignedShort(); int i_240_; if (bool_167_) i_240_ =
	 * class588_sub11.ReadSpecialSmart(); else { i_240_ =
	 * class588_sub11.getUnsignedByte(); if (i_240_ == 255) i_240_ = -1; } byte
	 * i_241_ = (byte)class588_sub11.ReadByte(); isolatedVertexNormals[i_237_] =
	 * new VertexNormal(i_238_, i_239_, i_240_, i_241_); } } } } }
	 */

	private void read525Model(byte abyte0[], int modelID) {
		ByteBuffer nc1 = new ByteBuffer(abyte0);
		ByteBuffer nc2 = new ByteBuffer(abyte0);
		ByteBuffer nc3 = new ByteBuffer(abyte0);
		ByteBuffer nc4 = new ByteBuffer(abyte0);
		ByteBuffer nc5 = new ByteBuffer(abyte0);
		ByteBuffer nc6 = new ByteBuffer(abyte0);
		ByteBuffer nc7 = new ByteBuffer(abyte0);
		nc1.position = abyte0.length - 23;
		int numVertices = nc1.getUnsignedShort();
		int numTriangles = nc1.getUnsignedShort();
		int numTextureTriangles = nc1.getUnsignedByte();
		Class21 ModelDef_1 = aClass21Array1661[modelID] = new Class21();
		ModelDef_1.aByteArray368 = abyte0;
		ModelDef_1.anInt369 = numVertices;
		ModelDef_1.anInt370 = numTriangles;
		ModelDef_1.anInt371 = numTextureTriangles;
		int l1 = nc1.getUnsignedByte();
		boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
		int i2 = nc1.getUnsignedByte();
		int j2 = nc1.getUnsignedByte();
		int k2 = nc1.getUnsignedByte();
		int l2 = nc1.getUnsignedByte();
		int i3 = nc1.getUnsignedByte();
		int j3 = nc1.getUnsignedShort();
		int k3 = nc1.getUnsignedShort();
		int l3 = nc1.getUnsignedShort();
		int i4 = nc1.getUnsignedShort();
		int j4 = nc1.getUnsignedShort();
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		byte[] x = null;
		byte[] O = null;
		byte[] J = null;
		byte[] F = null;
		byte[] cb = null;
		byte[] gb = null;
		byte[] lb = null;
		int[] kb = null;
		int[] y = null;
		int[] N = null;
		short[] D = null;
		int[] triangleColours2 = new int[numTriangles];
		if (numTextureTriangles > 0) {
			O = new byte[numTextureTriangles];
			nc1.position = 0;
			for (int j5 = 0; j5 < numTextureTriangles; j5++) {
				byte byte0 = O[j5] = nc1.getSignedByte();
				if (byte0 == 0) {
					k4++;
				}
				if (byte0 >= 1 && byte0 <= 3) {
					l4++;
				}
				if (byte0 == 2) {
					i5++;
				}
			}
		}
		int k5 = numTextureTriangles;
		int l5 = k5;
		k5 += numVertices;
		int i6 = k5;
		if (l1 == 1) {
			k5 += numTriangles;
		}
		int j6 = k5;
		k5 += numTriangles;
		int k6 = k5;
		if (i2 == 255) {
			k5 += numTriangles;
		}
		int l6 = k5;
		if (k2 == 1) {
			k5 += numTriangles;
		}
		int i7 = k5;
		if (i3 == 1) {
			k5 += numVertices;
		}
		int j7 = k5;
		if (j2 == 1) {
			k5 += numTriangles;
		}
		int k7 = k5;
		k5 += i4;
		int l7 = k5;
		if (l2 == 1) {
			k5 += numTriangles * 2;
		}
		int i8 = k5;
		k5 += j4;
		int j8 = k5;
		k5 += numTriangles * 2;
		int k8 = k5;
		k5 += j3;
		int l8 = k5;
		k5 += k3;
		int i9 = k5;
		k5 += l3;
		int j9 = k5;
		k5 += k4 * 6;
		int k9 = k5;
		k5 += l4 * 6;
		int l9 = k5;
		k5 += l4 * 6;
		int i10 = k5;
		k5 += l4;
		int j10 = k5;
		k5 += l4;
		int k10 = k5;
		k5 += l4 + i5 * 2;
		int[] vertexX = new int[numVertices];
		int[] vertexY = new int[numVertices];
		int[] vertexZ = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
		anIntArray1655 = new int[numVertices];
		anIntArray1637 = new int[numTriangles];
		face_render_priorities = new int[numTriangles];
		anIntArray1639 = new int[numTriangles];
		anIntArray1656 = new int[numTriangles];
		if (i3 == 1) {
			anIntArray1655 = new int[numVertices];
		}
		if (bool) {
			anIntArray1637 = new int[numTriangles];
		}
		if (i2 == 255) {
			face_render_priorities = new int[numTriangles];
		} else {
		}
		if (j2 == 1) {
			anIntArray1639 = new int[numTriangles];
		}
		if (k2 == 1) {
			anIntArray1656 = new int[numTriangles];
		}
		if (l2 == 1) {
			D = new short[numTriangles];
		}
		if (l2 == 1 && numTextureTriangles > 0) {
			x = new byte[numTriangles];
		}
		triangleColours2 = new int[numTriangles];
		int[] texTrianglesPoint1 = null;
		int[] texTrianglesPoint2 = null;
		int[] texTrianglesPoint3 = null;
		if (numTextureTriangles > 0) {
			texTrianglesPoint1 = new int[numTextureTriangles];
			texTrianglesPoint2 = new int[numTextureTriangles];
			texTrianglesPoint3 = new int[numTextureTriangles];
			if (l4 > 0) {
				kb = new int[l4];
				N = new int[l4];
				y = new int[l4];
				gb = new byte[l4];
				lb = new byte[l4];
				F = new byte[l4];
			}
			if (i5 > 0) {
				cb = new byte[i5];
				J = new byte[i5];
			}
		}
		nc1.position = l5;
		nc2.position = k8;
		nc3.position = l8;
		nc4.position = i9;
		nc5.position = i7;
		int l10 = 0;
		int i11 = 0;
		int j11 = 0;
		for (int k11 = 0; k11 < numVertices; k11++) {
			int l11 = nc1.getUnsignedByte();
			int j12 = 0;
			if ((l11 & 1) != 0) {
				j12 = nc2.method421();
			}
			int l12 = 0;
			if ((l11 & 2) != 0) {
				l12 = nc3.method421();
			}
			int j13 = 0;
			if ((l11 & 4) != 0) {
				j13 = nc4.method421();
			}
			vertexX[k11] = l10 + j12;
			vertexY[k11] = i11 + l12;
			vertexZ[k11] = j11 + j13;
			l10 = vertexX[k11];
			i11 = vertexY[k11];
			j11 = vertexZ[k11];
			if (anIntArray1655 != null) {
				anIntArray1655[k11] = nc5.getUnsignedByte();
			}
		}
		nc1.position = j8;
		nc2.position = i6;
		nc3.position = k6;
		nc4.position = j7;
		nc5.position = l6;
		nc6.position = l7;
		nc7.position = i8;
		for (int i12 = 0; i12 < numTriangles; i12++) {
			triangleColours2[i12] = nc1.getUnsignedShort();
			if (l1 == 1) {
				anIntArray1637[i12] = nc2.getSignedByte();
				if (anIntArray1637[i12] == 2) {
					triangleColours2[i12] = 65535;
				}
				anIntArray1637[i12] = 0;
			}
			if (i2 == 255) {
				face_render_priorities[i12] = nc3.getSignedByte();
			}
			if (j2 == 1) {
				anIntArray1639[i12] = nc4.getSignedByte();
				if (anIntArray1639[i12] < 0) {
					anIntArray1639[i12] = 256 + anIntArray1639[i12];
				}
			}
			if (k2 == 1) {
				anIntArray1656[i12] = nc5.getUnsignedByte();
			}
			if (l2 == 1) {
				D[i12] = (short) (nc6.getUnsignedShort() - 1);
			}
			if (x != null) {
				if (D[i12] != -1) {
					x[i12] = (byte) (nc7.getUnsignedByte() - 1);
				} else {
					x[i12] = -1;
				}
			}
		}
		// /fix's triangle issue, but fucked up - no need, loading all 474-
		// models
		/*
		 * try { for(int i12 = 0; i12 < numTriangles; i12++) {
		 * triangleColours2[i12] = nc1.readUnsignedWord(); if(l1 == 1){
		 * anIntArray1637[i12] = nc2.readSignedByte(); } if(i2 == 255){
		 * anIntArray1638[i12] = nc3.readSignedByte(); } if(j2 == 1){
		 * anIntArray1639[i12] = nc4.readSignedByte(); if(anIntArray1639[i12] <
		 * 0) anIntArray1639[i12] = (256+anIntArray1639[i12]); } if(k2 == 1)
		 * anIntArray1656[i12] = nc5.readUnsignedByte(); if(l2 == 1) D[i12] =
		 * (short)(nc6.readUnsignedWord() - 1); if(x != null) if(D[i12] != -1)
		 * x[i12] = (byte)(nc7.readUnsignedByte() -1); else x[i12] = -1; } }
		 * catch (Exception ex) { }
		 */
		nc1.position = k7;
		nc2.position = j6;
		int k12 = 0;
		int i13 = 0;
		int k13 = 0;
		int l13 = 0;
		for (int i14 = 0; i14 < numTriangles; i14++) {
			int j14 = nc2.getUnsignedByte();
			if (j14 == 1) {
				k12 = nc1.method421() + l13;
				l13 = k12;
				i13 = nc1.method421() + l13;
				l13 = i13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 2) {
				i13 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 3) {
				k12 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 4) {
				int l14 = k12;
				k12 = i13;
				i13 = l14;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
		}
		nc1.position = j9;
		nc2.position = k9;
		nc3.position = l9;
		nc4.position = i10;
		nc5.position = j10;
		nc6.position = k10;
		for (int k14 = 0; k14 < numTextureTriangles; k14++) {
			int i15 = O[k14] & 0xff;
			if (i15 == 0) {
				texTrianglesPoint1[k14] = nc1.getUnsignedShort();
				texTrianglesPoint2[k14] = nc1.getUnsignedShort();
				texTrianglesPoint3[k14] = nc1.getUnsignedShort();
			}
			if (i15 == 1) {
				texTrianglesPoint1[k14] = nc2.getUnsignedShort();
				texTrianglesPoint2[k14] = nc2.getUnsignedShort();
				texTrianglesPoint3[k14] = nc2.getUnsignedShort();
				kb[k14] = nc3.getUnsignedShort();
				N[k14] = nc3.getUnsignedShort();
				y[k14] = nc3.getUnsignedShort();
				gb[k14] = nc4.getSignedByte();
				lb[k14] = nc5.getSignedByte();
				F[k14] = nc6.getSignedByte();
			}
			if (i15 == 2) {
				texTrianglesPoint1[k14] = nc2.getUnsignedShort();
				texTrianglesPoint2[k14] = nc2.getUnsignedShort();
				texTrianglesPoint3[k14] = nc2.getUnsignedShort();
				kb[k14] = nc3.getUnsignedShort();
				N[k14] = nc3.getUnsignedShort();
				y[k14] = nc3.getUnsignedShort();
				gb[k14] = nc4.getSignedByte();
				lb[k14] = nc5.getSignedByte();
				F[k14] = nc6.getSignedByte();
				cb[k14] = nc6.getSignedByte();
				J[k14] = nc6.getSignedByte();
			}
			if (i15 == 3) {
				texTrianglesPoint1[k14] = nc2.getUnsignedShort();
				texTrianglesPoint2[k14] = nc2.getUnsignedShort();
				texTrianglesPoint3[k14] = nc2.getUnsignedShort();
				kb[k14] = nc3.getUnsignedShort();
				N[k14] = nc3.getUnsignedShort();
				y[k14] = nc3.getUnsignedShort();
				gb[k14] = nc4.getSignedByte();
				lb[k14] = nc5.getSignedByte();
				F[k14] = nc6.getSignedByte();
			}
		}
		if (i2 != 255) {
			for (int i12 = 0; i12 < numTriangles; i12++) {
				face_render_priorities[i12] = i2;
			}
		}
		anIntArray1640 = triangleColours2;
		numberOfVerticeCoordinates = numVertices;
		anInt1630 = numTriangles;
		verticesXCoordinate = vertexX;
		verticesYCoordinate = vertexY;
		verticesZCoordinate = vertexZ;
		anIntArray1631 = facePoint1;
		anIntArray1632 = facePoint2;
		anIntArray1633 = facePoint3;
	}

	private void read622Model(byte abyte0[], int modelID) {
		ByteBuffer nc1 = new ByteBuffer(abyte0);
		ByteBuffer nc2 = new ByteBuffer(abyte0);
		ByteBuffer nc3 = new ByteBuffer(abyte0);
		ByteBuffer nc4 = new ByteBuffer(abyte0);
		ByteBuffer nc5 = new ByteBuffer(abyte0);
		ByteBuffer nc6 = new ByteBuffer(abyte0);
		ByteBuffer nc7 = new ByteBuffer(abyte0);
		nc1.position = abyte0.length - 23;
		int numVertices = nc1.getUnsignedShort();
		int numTriangles = nc1.getUnsignedShort();
		int numTexTriangles = nc1.getUnsignedByte();
		Class21 ModelDef_1 = aClass21Array1661[modelID] = new Class21();
		ModelDef_1.aByteArray368 = abyte0;
		ModelDef_1.anInt369 = numVertices;
		ModelDef_1.anInt370 = numTriangles;
		ModelDef_1.anInt371 = numTexTriangles;
		int l1 = nc1.getUnsignedByte();
		boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
		boolean bool_26_ = (0x8 & l1) == 8;
		if (!bool_26_) {
			read525Model(abyte0, modelID);
			return;
		}
		int newformat = 0;
		if (bool_26_) {
			nc1.position -= 7;
			newformat = nc1.getUnsignedByte();
			nc1.position += 6;
		}
		if (newformat == 15) {
			newmodel[modelID] = true;
		}
		int i2 = nc1.getUnsignedByte();
		int j2 = nc1.getUnsignedByte();
		int k2 = nc1.getUnsignedByte();
		int l2 = nc1.getUnsignedByte();
		int i3 = nc1.getUnsignedByte();
		int j3 = nc1.getUnsignedShort();
		int k3 = nc1.getUnsignedShort();
		int l3 = nc1.getUnsignedShort();
		int i4 = nc1.getUnsignedShort();
		int j4 = nc1.getUnsignedShort();
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		byte[] x = null;
		byte[] O = null;
		byte[] J = null;
		byte[] F = null;
		byte[] cb = null;
		byte[] gb = null;
		byte[] lb = null;
		int[] kb = null;
		int[] y = null;
		int[] N = null;
		short[] D = null;
		int[] triangleColours2 = new int[numTriangles];
		if (numTexTriangles > 0) {
			O = new byte[numTexTriangles];
			nc1.position = 0;
			for (int j5 = 0; j5 < numTexTriangles; j5++) {
				byte byte0 = O[j5] = nc1.getSignedByte();
				if (byte0 == 0) {
					k4++;
				}
				if (byte0 >= 1 && byte0 <= 3) {
					l4++;
				}
				if (byte0 == 2) {
					i5++;
				}
			}
		}
		int k5 = numTexTriangles;
		int l5 = k5;
		k5 += numVertices;
		int i6 = k5;
		if (bool) {
			k5 += numTriangles;
		}
		if (l1 == 1) {
			k5 += numTriangles;
		}
		int j6 = k5;
		k5 += numTriangles;
		int k6 = k5;
		if (i2 == 255) {
			k5 += numTriangles;
		}
		int l6 = k5;
		if (k2 == 1) {
			k5 += numTriangles;
		}
		int i7 = k5;
		if (i3 == 1) {
			k5 += numVertices;
		}
		int j7 = k5;
		if (j2 == 1) {
			k5 += numTriangles;
		}
		int k7 = k5;
		k5 += i4;
		int l7 = k5;
		if (l2 == 1) {
			k5 += numTriangles * 2;
		}
		int i8 = k5;
		k5 += j4;
		int j8 = k5;
		k5 += numTriangles * 2;
		int k8 = k5;
		k5 += j3;
		int l8 = k5;
		k5 += k3;
		int i9 = k5;
		k5 += l3;
		int j9 = k5;
		k5 += k4 * 6;
		int k9 = k5;
		k5 += l4 * 6;
		int i_59_ = 6;
		if (newformat != 14) {
			if (newformat >= 15) {
				i_59_ = 9;
			}
		} else {
			i_59_ = 7;
		}
		int l9 = k5;
		k5 += i_59_ * l4;
		int i10 = k5;
		k5 += l4;
		int j10 = k5;
		k5 += l4;
		int k10 = k5;
		k5 += l4 + i5 * 2;
		int[] vertexX = new int[numVertices];
		int[] vertexY = new int[numVertices];
		int[] vertexZ = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
		anIntArray1655 = new int[numVertices];
		anIntArray1637 = new int[numTriangles];
		face_render_priorities = new int[numTriangles];
		anIntArray1639 = new int[numTriangles];
		anIntArray1656 = new int[numTriangles];
		if (i3 == 1) {
			anIntArray1655 = new int[numVertices];
		}
		if (bool) {
			anIntArray1637 = new int[numTriangles];
		}
		if (i2 == 255) {
			face_render_priorities = new int[numTriangles];
		} else {
		}
		if (j2 == 1) {
			anIntArray1639 = new int[numTriangles];
		}
		if (k2 == 1) {
			anIntArray1656 = new int[numTriangles];
		}
		if (l2 == 1) {
			D = new short[numTriangles];
		}
		if (l2 == 1 && numTexTriangles > 0) {
			x = new byte[numTriangles];
		}
		triangleColours2 = new int[numTriangles];
		int[] texTrianglesPoint1 = null;
		int[] texTrianglesPoint2 = null;
		int[] texTrianglesPoint3 = null;
		if (numTexTriangles > 0) {
			texTrianglesPoint1 = new int[numTexTriangles];
			texTrianglesPoint2 = new int[numTexTriangles];
			texTrianglesPoint3 = new int[numTexTriangles];
			if (l4 > 0) {
				kb = new int[l4];
				N = new int[l4];
				y = new int[l4];
				gb = new byte[l4];
				lb = new byte[l4];
				F = new byte[l4];
			}
			if (i5 > 0) {
				cb = new byte[i5];
				J = new byte[i5];
			}
		}
		nc1.position = l5;
		nc2.position = k8;
		nc3.position = l8;
		nc4.position = i9;
		nc5.position = i7;
		int l10 = 0;
		int i11 = 0;
		int j11 = 0;
		for (int k11 = 0; k11 < numVertices; k11++) {
			int l11 = nc1.getUnsignedByte();
			int j12 = 0;
			if ((l11 & 1) != 0) {
				j12 = nc2.method421();
			}
			int l12 = 0;
			if ((l11 & 2) != 0) {
				l12 = nc3.method421();
			}
			int j13 = 0;
			if ((l11 & 4) != 0) {
				j13 = nc4.method421();
			}
			vertexX[k11] = l10 + j12;
			vertexY[k11] = i11 + l12;
			vertexZ[k11] = j11 + j13;
			l10 = vertexX[k11];
			i11 = vertexY[k11];
			j11 = vertexZ[k11];
			if (anIntArray1655 != null) {
				anIntArray1655[k11] = nc5.getUnsignedByte();
			}
		}
		nc1.position = j8;
		nc2.position = i6;
		nc3.position = k6;
		nc4.position = j7;
		nc5.position = l6;
		nc6.position = l7;
		nc7.position = i8;
		for (int i12 = 0; i12 < numTriangles; i12++) {
			triangleColours2[i12] = nc1.getUnsignedShort();
			if (l1 == 1) {
				anIntArray1637[i12] = nc2.getSignedByte();
				if (anIntArray1637[i12] == 2) {
					triangleColours2[i12] = 65535;
				}
				anIntArray1637[i12] = 0;
			}
			if (i2 == 255) {
				face_render_priorities[i12] = nc3.getSignedByte();
			}
			if (j2 == 1) {
				anIntArray1639[i12] = nc4.getSignedByte();
				if (anIntArray1639[i12] < 0) {
					anIntArray1639[i12] = 256 + anIntArray1639[i12];
				}
			}
			if (k2 == 1) {
				anIntArray1656[i12] = nc5.getUnsignedByte();
			}
			if (l2 == 1) {
				D[i12] = (short) (nc6.getUnsignedShort() - 1);
			}
			if (x != null) {
				if (D[i12] != -1) {
					x[i12] = (byte) (nc7.getUnsignedByte() - 1);
				} else {
					x[i12] = -1;
				}
			}
		}
		nc1.position = k7;
		nc2.position = j6;
		int k12 = 0;
		int i13 = 0;
		int k13 = 0;
		int l13 = 0;
		for (int i14 = 0; i14 < numTriangles; i14++) {
			int j14 = nc2.getUnsignedByte();
			if (j14 == 1) {
				k12 = nc1.method421() + l13;
				l13 = k12;
				i13 = nc1.method421() + l13;
				l13 = i13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 2) {
				i13 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 3) {
				k12 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 4) {
				int l14 = k12;
				k12 = i13;
				i13 = l14;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
		}
		nc1.position = j9;
		nc2.position = k9;
		nc3.position = l9;
		nc4.position = i10;
		nc5.position = j10;
		nc6.position = k10;
		for (int k14 = 0; k14 < numTexTriangles; k14++) {
			int i15 = O[k14] & 0xff;
			if (i15 == 0) {
				texTrianglesPoint1[k14] = nc1.getUnsignedShort();
				texTrianglesPoint2[k14] = nc1.getUnsignedShort();
				texTrianglesPoint3[k14] = nc1.getUnsignedShort();
			}
			if (i15 == 1) {
				texTrianglesPoint1[k14] = nc2.getUnsignedShort();
				texTrianglesPoint2[k14] = nc2.getUnsignedShort();
				texTrianglesPoint3[k14] = nc2.getUnsignedShort();

				if (newformat < 15) {
					kb[k14] = nc3.getUnsignedShort();

					if (newformat >= 14) {
						N[k14] = nc3.getTribyte(-1);
					} else {
						N[k14] = nc3.getUnsignedShort();
					}

					y[k14] = nc3.getUnsignedShort();
				} else {
					kb[k14] = nc3.getTribyte(-1);
					N[k14] = nc3.getTribyte(-1);
					y[k14] = nc3.getTribyte(-1);
				}

				gb[k14] = nc4.getSignedByte();
				lb[k14] = nc5.getSignedByte();
				F[k14] = nc6.getSignedByte();
			}
			if (i15 == 2) {
				texTrianglesPoint1[k14] = nc2.getUnsignedShort();
				texTrianglesPoint2[k14] = nc2.getUnsignedShort();
				texTrianglesPoint3[k14] = nc2.getUnsignedShort();

				if (newformat >= 15) {
					kb[k14] = nc3.getTribyte(-1);
					N[k14] = nc3.getTribyte(-1);
					y[k14] = nc3.getTribyte(-1);
				} else {
					kb[k14] = nc3.getUnsignedShort();
					if (newformat < 14) {
						N[k14] = nc3.getUnsignedShort();
					} else {
						N[k14] = nc3.getTribyte(-1);
					}
					y[k14] = nc3.getUnsignedShort();
				}
				gb[k14] = nc4.getSignedByte();
				lb[k14] = nc5.getSignedByte();
				F[k14] = nc6.getSignedByte();
				cb[k14] = nc6.getSignedByte();
				J[k14] = nc6.getSignedByte();
			}
			if (i15 == 3) {
				texTrianglesPoint1[k14] = nc2.getUnsignedShort();
				texTrianglesPoint2[k14] = nc2.getUnsignedShort();
				texTrianglesPoint3[k14] = nc2.getUnsignedShort();
				if (newformat < 15) {
					kb[k14] = nc3.getUnsignedShort();
					if (newformat < 14) {
						N[k14] = nc3.getUnsignedShort();
					} else {
						N[k14] = nc3.getTribyte(-1);
					}
					y[k14] = nc3.getUnsignedShort();
				} else {
					kb[k14] = nc3.getTribyte(-1);
					N[k14] = nc3.getTribyte(-1);
					y[k14] = nc3.getTribyte(-1);
				}
				gb[k14] = nc4.getSignedByte();
				lb[k14] = nc5.getSignedByte();
				F[k14] = nc6.getSignedByte();
			}
		}
		if (i2 != 255) {
			for (int i12 = 0; i12 < numTriangles; i12++) {
				face_render_priorities[i12] = i2;
			}
		}
		anIntArray1640 = triangleColours2;
		numberOfVerticeCoordinates = numVertices;
		anInt1630 = numTriangles;
		verticesXCoordinate = vertexX;
		verticesYCoordinate = vertexY;
		verticesZCoordinate = vertexZ;
		anIntArray1631 = facePoint1;
		anIntArray1632 = facePoint2;
		anIntArray1633 = facePoint3;
		scale2(2); //2 seems to be right with the new scale2. scale2Old should be set to 4.
		translate(0, 6, 0);
		if (face_render_priorities != null) {
			for (int j = 0; j < face_render_priorities.length; j++) {
				face_render_priorities[j] = 10;
			}
		}
	}

	private void readOldModel(int i) {
		int j = -870;
		aBoolean1618 = true;
		aBoolean1659 = false;
		Class21 class21 = aClass21Array1661[i];
		numberOfVerticeCoordinates = class21.anInt369;
		anInt1630 = class21.anInt370;
		anInt1642 = class21.anInt371;
		verticesXCoordinate = new int[numberOfVerticeCoordinates];
		verticesYCoordinate = new int[numberOfVerticeCoordinates];
		verticesZCoordinate = new int[numberOfVerticeCoordinates];
		anIntArray1631 = new int[anInt1630];
		anIntArray1632 = new int[anInt1630];
		while (j >= 0) {
			aBoolean1618 = !aBoolean1618;
		}
		anIntArray1633 = new int[anInt1630];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (class21.anInt376 >= 0) {
			anIntArray1655 = new int[numberOfVerticeCoordinates];
		}
		if (class21.anInt380 >= 0) {
			anIntArray1637 = new int[anInt1630];
		}
		if (class21.anInt381 >= 0) {
			face_render_priorities = new int[anInt1630];
		} else {
			anInt1641 = -class21.anInt381 - 1;
		}
		if (class21.anInt382 >= 0) {
			anIntArray1639 = new int[anInt1630];
		}
		if (class21.anInt383 >= 0) {
			anIntArray1656 = new int[anInt1630];
		}
		anIntArray1640 = new int[anInt1630];
		ByteBuffer stream = new ByteBuffer(class21.aByteArray368);
		stream.position = class21.anInt372;
		ByteBuffer stream_1 = new ByteBuffer(class21.aByteArray368);
		stream_1.position = class21.anInt373;
		ByteBuffer stream_2 = new ByteBuffer(class21.aByteArray368);
		stream_2.position = class21.anInt374;
		ByteBuffer stream_3 = new ByteBuffer(class21.aByteArray368);
		stream_3.position = class21.anInt375;
		ByteBuffer stream_4 = new ByteBuffer(class21.aByteArray368);
		stream_4.position = class21.anInt376;
		int k = 0;
		int l = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < numberOfVerticeCoordinates; j1++) {
			int k1 = stream.getUnsignedByte();
			int i2 = 0;
			if ((k1 & 1) != 0) {
				i2 = stream_1.method421();
			}
			int k2 = 0;
			if ((k1 & 2) != 0) {
				k2 = stream_2.method421();
			}
			int i3 = 0;
			if ((k1 & 4) != 0) {
				i3 = stream_3.method421();
			}
			verticesXCoordinate[j1] = k + i2;
			verticesYCoordinate[j1] = l + k2;
			verticesZCoordinate[j1] = i1 + i3;
			k = verticesXCoordinate[j1];
			l = verticesYCoordinate[j1];
			i1 = verticesZCoordinate[j1];
			if (anIntArray1655 != null) {
				anIntArray1655[j1] = stream_4.getUnsignedByte();
			}
		}
		stream.position = class21.anInt379;
		stream_1.position = class21.anInt380;
		stream_2.position = class21.anInt381;
		stream_3.position = class21.anInt382;
		stream_4.position = class21.anInt383;
		for (int l1 = 0; l1 < anInt1630; l1++) {
			anIntArray1640[l1] = stream.getUnsignedShort();
			if (anIntArray1637 != null) {
				anIntArray1637[l1] = stream_1.getUnsignedByte();
			}
			if (face_render_priorities != null) {
				face_render_priorities[l1] = stream_2.getUnsignedByte();
			}
			if (anIntArray1639 != null) {
				anIntArray1639[l1] = stream_3.getUnsignedByte();
			}
			if (anIntArray1656 != null) {
				anIntArray1656[l1] = stream_4.getUnsignedByte();
			}
		}
		stream.position = class21.anInt377;
		stream_1.position = class21.anInt378;
		int j2 = 0;
		int l2 = 0;
		int j3 = 0;
		int k3 = 0;
		for (int l3 = 0; l3 < anInt1630; l3++) {
			int i4 = stream_1.getUnsignedByte();
			if (i4 == 1) {
				j2 = stream.method421() + k3;
				k3 = j2;
				l2 = stream.method421() + k3;
				k3 = l2;
				j3 = stream.method421() + k3;
				k3 = j3;
				anIntArray1631[l3] = j2;
				anIntArray1632[l3] = l2;
				anIntArray1633[l3] = j3;
			}
			if (i4 == 2) {
				l2 = j3;
				j3 = stream.method421() + k3;
				k3 = j3;
				anIntArray1631[l3] = j2;
				anIntArray1632[l3] = l2;
				anIntArray1633[l3] = j3;
			}
			if (i4 == 3) {
				j2 = j3;
				j3 = stream.method421() + k3;
				k3 = j3;
				anIntArray1631[l3] = j2;
				anIntArray1632[l3] = l2;
				anIntArray1633[l3] = j3;
			}
			if (i4 == 4) {
				int k4 = j2;
				j2 = l2;
				l2 = k4;
				j3 = stream.method421() + k3;
				k3 = j3;
				anIntArray1631[l3] = j2;
				anIntArray1632[l3] = l2;
				anIntArray1633[l3] = j3;
			}
		}
		stream.position = class21.anInt384;
		for (int j4 = 0; j4 < anInt1642; j4++) {
			anIntArray1643[j4] = stream.getUnsignedShort();
			anIntArray1644[j4] = stream.getUnsignedShort();
			anIntArray1645[j4] = stream.getUnsignedShort();
		}
	}
	
	public void scale2(int i) {
		for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
			verticesXCoordinate[i1] = verticesXCoordinate[i1] >> i;
			verticesYCoordinate[i1] = verticesYCoordinate[i1] >> i;
			verticesZCoordinate[i1] = verticesZCoordinate[i1] >> i;
		}
	}

	public void scale2Old(int i) {
		for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
			verticesXCoordinate[i1] = verticesXCoordinate[i1] / i;
			verticesYCoordinate[i1] = verticesYCoordinate[i1] / i;
			verticesZCoordinate[i1] = verticesZCoordinate[i1] / i;
		}
	}

}