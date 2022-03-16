package org.necrotic.client.world.sound;

import org.necrotic.client.Client;

public final class Class3_Sub7_Sub2 extends Class3_Sub7 {

	private static final int method388(int i, int i_0_, byte[] is, int[] is_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_, Class3_Sub7_Sub2 class3_sub7_sub2, int i_8_, int i_9_) {
		if (i_8_ == 0 || (i_5_ = i_3_ + (i_7_ + 256 - i_2_ + i_8_) / i_8_) > i_6_) {
			i_5_ = i_6_;
		}
		while (i_3_ < i_5_) {
			i_0_ = i_2_ >> 8;
		i = is[i_0_ - 1];
		is_1_[i_3_++] += ((i << 8) + (is[i_0_] - i) * (i_2_ & 0xff)) * i_4_;
		i_2_ += i_8_;
		}
		if (i_8_ == 0 || (i_5_ = i_3_ + (i_7_ - i_2_ + i_8_) / i_8_) > i_6_) {
			i_5_ = i_6_;
		}
		i = i_9_;
		i_0_ = i_8_;
		while (i_3_ < i_5_) {
			is_1_[i_3_++] += ((i << 8) + (is[i_2_ >> 8] - i) * (i_2_ & 0xff)) * i_4_;
			i_2_ += i_0_;
		}
		class3_sub7_sub2.anInt1820 = i_2_;
		return i_3_;
	}

	private static final int method389(byte[] is, int[] is_10_, int i, int i_11_, int i_12_, int i_13_, int i_14_, int i_15_, Class3_Sub7_Sub2 class3_sub7_sub2) {
		i >>= 8;
		i_15_ >>= 8;
		i_12_ <<= 8;
		if ((i_13_ = i_11_ + i_15_ - i) > i_14_) {
			i_13_ = i_14_;
		}
		i_13_ -= 3;
		while (i_11_ < i_13_) {
			is_10_[i_11_++] += is[i++] * i_12_;
			is_10_[i_11_++] += is[i++] * i_12_;
			is_10_[i_11_++] += is[i++] * i_12_;
			is_10_[i_11_++] += is[i++] * i_12_;
		}
		i_13_ += 3;
		while (i_11_ < i_13_) {
			is_10_[i_11_++] += is[i++] * i_12_;
		}
		class3_sub7_sub2.anInt1820 = i << 8;
		return i_11_;
	}

	private static final int method390(int i, int i_16_, byte[] is, int[] is_17_, int i_18_, int i_19_, int i_20_, int i_21_, int i_22_, int i_23_, int i_24_, int i_25_, Class3_Sub7_Sub2 class3_sub7_sub2, int i_26_, int i_27_) {
		if (i_26_ == 0 || (i_23_ = i_19_ + (i_25_ - i_18_ + i_26_ - 257) / i_26_) > i_24_) {
			i_23_ = i_24_;
		}
		while (i_19_ < i_23_) {
			i_16_ = i_18_ >> 8;
		i = is[i_16_];
		is_17_[i_19_++] += ((i << 8) + (is[i_16_ + 1] - i) * (i_18_ & 0xff)) * i_20_ >> i_21_;
		i_20_ += i_22_;
		i_18_ += i_26_;
		}
		if (i_26_ == 0 || (i_23_ = i_19_ + (i_25_ - i_18_ + i_26_ - 1) / i_26_) > i_24_) {
			i_23_ = i_24_;
		}
		i_16_ = i_27_;
		while (i_19_ < i_23_) {
			i = is[i_18_ >> 8];
			is_17_[i_19_++] += ((i << 8) + (i_16_ - i) * (i_18_ & 0xff)) * i_20_ >> i_21_;
			i_20_ += i_22_;
			i_18_ += i_26_;
		}
		class3_sub7_sub2.anInt1822 = i_20_;
		class3_sub7_sub2.anInt1820 = i_18_;
		return i_19_;
	}

	private static final int method391(int i, int i_28_, byte[] is, int[] is_29_, int i_30_, int i_31_, int i_32_, int i_33_, int i_34_, int i_35_, int i_36_, int i_37_, Class3_Sub7_Sub2 class3_sub7_sub2, int i_38_, int i_39_) {
		if (i_38_ == 0 || (i_35_ = i_31_ + (i_37_ + 256 - i_30_ + i_38_) / i_38_) > i_36_) {
			i_35_ = i_36_;
		}
		while (i_31_ < i_35_) {
			i_28_ = i_30_ >> 8;
		i = is[i_28_ - 1];
		is_29_[i_31_++] += ((i << 8) + (is[i_28_] - i) * (i_30_ & 0xff)) * i_32_ >> i_33_;
		i_32_ += i_34_;
		i_30_ += i_38_;
		}
		if (i_38_ == 0 || (i_35_ = i_31_ + (i_37_ - i_30_ + i_38_) / i_38_) > i_36_) {
			i_35_ = i_36_;
		}
		i = i_39_;
		i_28_ = i_38_;
		while (i_31_ < i_35_) {
			is_29_[i_31_++] += ((i << 8) + (is[i_30_ >> 8] - i) * (i_30_ & 0xff)) * i_32_ >> i_33_;
		i_32_ += i_34_;
		i_30_ += i_28_;
		}
		class3_sub7_sub2.anInt1822 = i_32_;
		class3_sub7_sub2.anInt1820 = i_30_;
		return i_31_;
	}

	private static final int method392(byte[] is, int[] is_40_, int i, int i_41_, int i_42_, int i_43_, int i_44_, int i_45_, int i_46_, int i_47_, Class3_Sub7_Sub2 class3_sub7_sub2) {
		i >>= 8;
		i_47_ >>= 8;
		i_42_ <<= 8;
		if ((i_45_ = i_41_ + i - (i_47_ - 1)) > i_46_) {
			i_45_ = i_46_;
		}
		i_45_ -= 3;
		while (i_41_ < i_45_) {
			is_40_[i_41_++] += is[i--] * i_42_ >> i_43_;
		i_42_ += i_44_;
		is_40_[i_41_++] += is[i--] * i_42_ >> i_43_;
		i_42_ += i_44_;
		is_40_[i_41_++] += is[i--] * i_42_ >> i_43_;
		i_42_ += i_44_;
		is_40_[i_41_++] += is[i--] * i_42_ >> i_43_;
		i_42_ += i_44_;
		}
		i_45_ += 3;
		while (i_41_ < i_45_) {
			is_40_[i_41_++] += is[i--] * i_42_ >> i_43_;
		i_42_ += i_44_;
		}
		class3_sub7_sub2.anInt1822 = i_42_ >> 8;
		class3_sub7_sub2.anInt1820 = i << 8;
		return i_41_;
	}

	private static final int method393(int i, int i_48_, byte[] is, int[] is_49_, int i_50_, int i_51_, int i_52_, int i_53_, int i_54_, int i_55_, Class3_Sub7_Sub2 class3_sub7_sub2, int i_56_, int i_57_) {
		if (i_56_ == 0 || (i_53_ = i_51_ + (i_55_ - i_50_ + i_56_ - 257) / i_56_) > i_54_) {
			i_53_ = i_54_;
		}
		while (i_51_ < i_53_) {
			i_48_ = i_50_ >> 8;
		i = is[i_48_];
		is_49_[i_51_++] += ((i << 8) + (is[i_48_ + 1] - i) * (i_50_ & 0xff)) * i_52_;
		i_50_ += i_56_;
		}
		if (i_56_ == 0 || (i_53_ = i_51_ + (i_55_ - i_50_ + i_56_ - 1) / i_56_) > i_54_) {
			i_53_ = i_54_;
		}
		i_48_ = i_57_;
		while (i_51_ < i_53_) {
			i = is[i_50_ >> 8];
			is_49_[i_51_++] += ((i << 8) + (i_48_ - i) * (i_50_ & 0xff)) * i_52_;
			i_50_ += i_56_;
		}
		class3_sub7_sub2.anInt1820 = i_50_;
		return i_51_;
	}

	public static final Class3_Sub7_Sub2 method396(Class3_Sub9_Sub1 class3_sub9_sub1, int i, int i_70_) {
		if (class3_sub9_sub1.aByteArray1827 == null || class3_sub9_sub1.aByteArray1827.length == 0) {
			return null;
		}
		return new Class3_Sub7_Sub2(class3_sub9_sub1, (int) (class3_sub9_sub1.anInt1828 * 256L * i / (Client.anInt197 * 100)), i_70_);
	}

	private static final int method397(byte[] is, int[] is_71_, int i, int i_72_, int i_73_, int i_74_, int i_75_, int i_76_, Class3_Sub7_Sub2 class3_sub7_sub2) {
		i >>= 8;
			i_76_ >>= 8;
			i_73_ <<= 8;
			if ((i_74_ = i_72_ + i - (i_76_ - 1)) > i_75_) {
				i_74_ = i_75_;
			}
			i_74_ -= 3;
			while (i_72_ < i_74_) {
				is_71_[i_72_++] += is[i--] * i_73_;
				is_71_[i_72_++] += is[i--] * i_73_;
				is_71_[i_72_++] += is[i--] * i_73_;
				is_71_[i_72_++] += is[i--] * i_73_;
			}
			i_74_ += 3;
			while (i_72_ < i_74_) {
				is_71_[i_72_++] += is[i--] * i_73_;
			}
			class3_sub7_sub2.anInt1820 = i << 8;
			return i_72_;
	}

	private static final int method399(byte[] is, int[] is_88_, int i, int i_89_, int i_90_, int i_91_, int i_92_, int i_93_, int i_94_, int i_95_, Class3_Sub7_Sub2 class3_sub7_sub2) {
		i >>= 8;
			i_95_ >>= 8;
			i_90_ <<= 8;
			if ((i_93_ = i_89_ + i_95_ - i) > i_94_) {
				i_93_ = i_94_;
			}
			i_93_ -= 3;
			while (i_89_ < i_93_) {
				is_88_[i_89_++] += is[i++] * i_90_ >> i_91_;
			i_90_ += i_92_;
			is_88_[i_89_++] += is[i++] * i_90_ >> i_91_;
			i_90_ += i_92_;
			is_88_[i_89_++] += is[i++] * i_90_ >> i_91_;
			i_90_ += i_92_;
			is_88_[i_89_++] += is[i++] * i_90_ >> i_91_;
			i_90_ += i_92_;
			}
			i_93_ += 3;
			while (i_89_ < i_93_) {
				is_88_[i_89_++] += is[i++] * i_90_ >> i_91_;
			i_90_ += i_92_;
			}
			class3_sub7_sub2.anInt1822 = i_90_ >> 8;
			class3_sub7_sub2.anInt1820 = i << 8;
			return i_89_;
	}

	private int anInt1816;
	private int anInt1817;
	private int anInt1818;
	private int anInt1819;
	private int anInt1820;
	private boolean aBoolean1821;
	private int anInt1822;
	private final int anInt1823;
	private final int anInt1824;
	private int anInt1825;
	private int anInt1826;

	private Class3_Sub7_Sub2(Class3_Sub9_Sub1 class3_sub9_sub1, int i, int i_83_) {
		aClass3_Sub9_1220 = class3_sub9_sub1;
		anInt1823 = class3_sub9_sub1.anInt1830;
		anInt1824 = class3_sub9_sub1.anInt1829;
		anInt1826 = i;
		anInt1822 = i_83_;
		anInt1820 = 0;
	}

	@Override
	public final synchronized int method378(int[] is, int i, int i_58_) {
		if (anInt1822 == 0 && (anInt1819 == 0 || anInt1825 == 0 || anInt1825 == -2147483648)) {
			method380(i_58_);
			return 0;
		}
		Class3_Sub9_Sub1 class3_sub9_sub1 = (Class3_Sub9_Sub1) aClass3_Sub9_1220;
		int i_59_ = anInt1823 << 8;
		int i_60_ = anInt1824 << 8;
		int i_61_ = class3_sub9_sub1.aByteArray1827.length << 8;
		int i_62_ = i_60_ - i_59_;
		if (i_62_ <= 0) {
			anInt1816 = 0;
		}
		int i_63_ = i;
		i_58_ += i;
		if (anInt1816 < 0) {
			if (aBoolean1821) {
				if (anInt1826 < 0) {
					i_63_ = method395(is, i_63_, i_59_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1823]);
					if (anInt1820 >= i_59_) {
						return 1;
					}
					anInt1820 = i_59_ + i_59_ - 1 - anInt1820;
					anInt1826 = -anInt1826;
				}
				for (;;) {
					i_63_ = method398(is, i_63_, i_60_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1824 - 1]);
					if (anInt1820 < i_60_) {
						return 1;
					}
					anInt1820 = i_60_ + i_60_ - 1 - anInt1820;
					anInt1826 = -anInt1826;
					i_63_ = method395(is, i_63_, i_59_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1823]);
					if (anInt1820 >= i_59_) {
						return 1;
					}
					anInt1820 = i_59_ + i_59_ - 1 - anInt1820;
					anInt1826 = -anInt1826;
				}
			}
			if (anInt1826 < 0) {
				for (;;) {
					i_63_ = method395(is, i_63_, i_59_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1824 - 1]);
					if (anInt1820 >= i_59_) {
						return 1;
					}
					anInt1820 = i_60_ - 1 - (i_60_ - 1 - anInt1820) % i_62_;
				}
			}
			for (;;) {
				i_63_ = method398(is, i_63_, i_60_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1823]);
				if (anInt1820 < i_60_) {
					return 1;
				}
				anInt1820 = i_59_ + (anInt1820 - i_59_) % i_62_;
			}
		}
		do {
			if (anInt1816 > 0) {
				if (aBoolean1821) {
					if (anInt1826 < 0) {
						i_63_ = method395(is, i_63_, i_59_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1823]);
						if (anInt1820 >= i_59_) {
							return 1;
						}
						anInt1820 = i_59_ + i_59_ - 1 - anInt1820;
						anInt1826 = -anInt1826;
						if (--anInt1816 == 0) {
							break;
						}
					}
					do {
						i_63_ = method398(is, i_63_, i_60_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1824 - 1]);
						if (anInt1820 < i_60_) {
							return 1;
						}
						anInt1820 = i_60_ + i_60_ - 1 - anInt1820;
						anInt1826 = -anInt1826;
						if (--anInt1816 == 0) {
							break;
						}
						i_63_ = method395(is, i_63_, i_59_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1823]);
						if (anInt1820 >= i_59_) {
							return 1;
						}
						anInt1820 = i_59_ + i_59_ - 1 - anInt1820;
						anInt1826 = -anInt1826;
					} while (--anInt1816 != 0);
				} else if (anInt1826 < 0) {
					for (;;) {
						i_63_ = method395(is, i_63_, i_59_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1824 - 1]);
						if (anInt1820 >= i_59_) {
							return 1;
						}
						int i_64_ = (i_60_ - 1 - anInt1820) / i_62_;
						if (i_64_ >= anInt1816) {
							anInt1820 += i_62_ * anInt1816;
							anInt1816 = 0;
							break;
						}
						anInt1820 += i_62_ * i_64_;
						anInt1816 -= i_64_;
					}
				} else {
					for (;;) {
						i_63_ = method398(is, i_63_, i_60_, i_58_, class3_sub9_sub1.aByteArray1827[anInt1823]);
						if (anInt1820 < i_60_) {
							return 1;
						}
						int i_65_ = (anInt1820 - i_59_) / i_62_;
						if (i_65_ >= anInt1816) {
							anInt1820 -= i_62_ * anInt1816;
							anInt1816 = 0;
							break;
						}
						anInt1820 -= i_62_ * i_65_;
						anInt1816 -= i_65_;
					}
				}
			}
		} while (false);
		if (anInt1826 < 0) {
			method395(is, i_63_, 0, i_58_, 0);
			if (anInt1820 < 0) {
				anInt1820 = 0;
				unlink();
			}
		} else {
			method398(is, i_63_, i_61_, i_58_, 0);
			if (anInt1820 >= i_61_) {
				anInt1820 = i_61_ - 1;
				unlink();
			}
		}
		return 1;
	}

	@Override
	final int method379() {
		int i = anInt1822 * 3;
		i = (i ^ i >> 31) + (i >>> 31);
		if (anInt1816 == 0) {
			i -= i * anInt1820 / (((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827.length << 8);
		} else if (anInt1816 >= 0) {
			i -= i * anInt1823 / ((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827.length;
		}
		if (i > 255) {
			return 255;
		}
		return i;
	}

	@Override
	public final synchronized void method380(int i) {
		if (anInt1819 > 0) {
			if (i >= anInt1819) {
				if (anInt1825 == -2147483648) {
					unlink();
					i = anInt1819;
				} else {
					anInt1822 = anInt1825;
				}
				anInt1819 = 0;
			} else {
				anInt1822 += anInt1817 * i;
				anInt1819 -= i;
			}
		}
		anInt1820 += anInt1826 * i;
		Class3_Sub9_Sub1 class3_sub9_sub1 = (Class3_Sub9_Sub1) aClass3_Sub9_1220;
		int i_77_ = anInt1823 << 8;
		int i_78_ = anInt1824 << 8;
		int i_79_ = class3_sub9_sub1.aByteArray1827.length << 8;
		int i_80_ = i_78_ - i_77_;
		if (i_80_ <= 0) {
			anInt1816 = 0;
		}
		if (anInt1816 < 0) {
			if (aBoolean1821) {
				if (anInt1826 < 0) {
					if (anInt1820 >= i_77_) {
						return;
					}
					anInt1820 = i_77_ + i_77_ - 1 - anInt1820;
					anInt1826 = -anInt1826;
				}
				while (anInt1820 >= i_78_) {
					anInt1820 = i_78_ + i_78_ - 1 - anInt1820;
					anInt1826 = -anInt1826;
					if (anInt1820 >= i_77_) {
						break;
					}
					anInt1820 = i_77_ + i_77_ - 1 - anInt1820;
					anInt1826 = -anInt1826;
				}
			} else if (anInt1826 < 0) {
				if (anInt1820 < i_77_) {
					anInt1820 = i_78_ - 1 - (i_78_ - 1 - anInt1820) % i_80_;
				}
			} else if (anInt1820 >= i_78_) {
				anInt1820 = i_77_ + (anInt1820 - i_77_) % i_80_;
			}
		} else {
			do {
				if (anInt1816 > 0) {
					if (aBoolean1821) {
						if (anInt1826 < 0) {
							if (anInt1820 >= i_77_) {
								return;
							}
							anInt1820 = i_77_ + i_77_ - 1 - anInt1820;
							anInt1826 = -anInt1826;
							if (--anInt1816 == 0) {
								break;
							}
						}
						do {
							if (anInt1820 < i_78_) {
								return;
							}
							anInt1820 = i_78_ + i_78_ - 1 - anInt1820;
							anInt1826 = -anInt1826;
							if (--anInt1816 == 0) {
								break;
							}
							if (anInt1820 >= i_77_) {
								return;
							}
							anInt1820 = i_77_ + i_77_ - 1 - anInt1820;
							anInt1826 = -anInt1826;
						} while (--anInt1816 != 0);
					} else if (anInt1826 < 0) {
						if (anInt1820 >= i_77_) {
							return;
						}
						int i_81_ = (i_78_ - 1 - anInt1820) / i_80_;
						if (i_81_ >= anInt1816) {
							anInt1820 += i_80_ * anInt1816;
							anInt1816 = 0;
						} else {
							anInt1820 += i_80_ * i_81_;
							anInt1816 -= i_81_;
							return;
						}
					} else {
						if (anInt1820 < i_78_) {
							return;
						}
						int i_82_ = (anInt1820 - i_77_) / i_80_;
						if (i_82_ >= anInt1816) {
							anInt1820 -= i_80_ * anInt1816;
							anInt1816 = 0;
						} else {
							anInt1820 -= i_80_ * i_82_;
							anInt1816 -= i_82_;
							return;
						}
					}
				}
			} while (false);
			if (anInt1826 < 0) {
				if (anInt1820 < 0) {
					anInt1820 = 0;
					unlink();
				}
			} else if (anInt1820 >= i_79_) {
				anInt1820 = i_79_ - 1;
				unlink();
			}
		}
	}

	public final synchronized void method394(int i) {
		anInt1816 = i;
	}

	private final int method395(int[] is, int i, int i_66_, int i_67_, int i_68_) {
		if (anInt1819 > 0) {
			int i_69_ = i + anInt1819;
			if (i_69_ > i_67_) {
				i_69_ = i_67_;
			}
			anInt1819 += i;
			if (anInt1826 == -256 && (anInt1820 & 0xff) == 0) {
				i = method392(((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827, is, anInt1820, i, anInt1822, anInt1818, anInt1817, 0, i_69_, i_66_, this);
			} else {
				i = method391(0, 0, ((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827, is, anInt1820, i, anInt1822, anInt1818, anInt1817, 0, i_69_, i_66_, this, anInt1826, i_68_);
			}
			anInt1819 -= i;
			if (anInt1819 != 0) {
				return i;
			}
			if (anInt1825 == -2147483648) {
				unlink();
				return i_67_;
			}
			anInt1822 = anInt1825;
		}
		if (anInt1826 == -256 && (anInt1820 & 0xff) == 0) {
			return method397(((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827, is, anInt1820, i, anInt1822, 0, i_67_, i_66_, this);
		}
		return method388(0, 0, ((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827, is, anInt1820, i, anInt1822, 0, i_67_, i_66_, this, anInt1826, i_68_);
	}

	private final int method398(int[] is, int i, int i_84_, int i_85_, int i_86_) {
		if (anInt1819 > 0) {
			int i_87_ = i + anInt1819;
			if (i_87_ > i_85_) {
				i_87_ = i_85_;
			}
			anInt1819 += i;
			if (anInt1826 == 256 && (anInt1820 & 0xff) == 0) {
				i = method399(((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827, is, anInt1820, i, anInt1822, anInt1818, anInt1817, 0, i_87_, i_84_, this);
			} else {
				i = method390(0, 0, ((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827, is, anInt1820, i, anInt1822, anInt1818, anInt1817, 0, i_87_, i_84_, this, anInt1826, i_86_);
			}
			anInt1819 -= i;
			if (anInt1819 != 0) {
				return i;
			}
			if (anInt1825 == -2147483648) {
				unlink();
				return i_85_;
			}
			anInt1822 = anInt1825;
		}
		if (anInt1826 == 256 && (anInt1820 & 0xff) == 0) {
			return method389(((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827, is, anInt1820, i, anInt1822, 0, i_85_, i_84_, this);
		}
		return method393(0, 0, ((Class3_Sub9_Sub1) aClass3_Sub9_1220).aByteArray1827, is, anInt1820, i, anInt1822, 0, i_85_, i_84_, this, anInt1826, i_86_);
	}
}
