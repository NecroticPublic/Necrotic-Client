package org.necrotic.client;

final class ArrayUtils {

	static final void arraycopy(byte[] is, int i, byte[] is_0_, int i_1_, int i_2_) {
		if (is == is_0_) {
			if (i == i_1_) {
				return;
			}
			if (i_1_ > i && i_1_ < i + i_2_) {
				i_2_--;
				i += i_2_;
				i_1_ += i_2_;
				i_2_ = i - i_2_;
				i_2_ += 7;
				while (i >= i_2_) {
					is_0_[i_1_--] = is[i--];
					is_0_[i_1_--] = is[i--];
					is_0_[i_1_--] = is[i--];
					is_0_[i_1_--] = is[i--];
					is_0_[i_1_--] = is[i--];
					is_0_[i_1_--] = is[i--];
					is_0_[i_1_--] = is[i--];
					is_0_[i_1_--] = is[i--];
				}
				i_2_ -= 7;
				while (i >= i_2_) {
					is_0_[i_1_--] = is[i--];
				}
				return;
			}
		}
		i_2_ += i;
		i_2_ -= 7;
		while (i < i_2_) {
			is_0_[i_1_++] = is[i++];
			is_0_[i_1_++] = is[i++];
			is_0_[i_1_++] = is[i++];
			is_0_[i_1_++] = is[i++];
			is_0_[i_1_++] = is[i++];
			is_0_[i_1_++] = is[i++];
			is_0_[i_1_++] = is[i++];
			is_0_[i_1_++] = is[i++];
		}
		i_2_ += 7;
		while (i < i_2_) {
			is_0_[i_1_++] = is[i++];
		}
	}

}
