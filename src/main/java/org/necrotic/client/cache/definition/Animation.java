package org.necrotic.client.cache.definition;

import org.necrotic.client.FrameReader;
import org.necrotic.client.cache.Archive;
import org.necrotic.client.io.ByteBuffer;

public final class Animation {

	public static void unpackConfig(Archive streamLoader)
	{
		ByteBuffer stream = new ByteBuffer(streamLoader.get("seq.dat"));
		int length = stream.getUnsignedShort();
		if(cache == null)
			cache = new Animation[length];
		for(int j = 0; j < length; j++)
		{
			if(cache[j] == null)
				cache[j] = new Animation();
			cache[j].readValues(stream);
			/*
			 * Glacor anims
			 */
			 /*if(j == 10867) {
        		anims[j].frameCount = 19;
        		anims[j].loopDelay = 19;
        		anims[j].delays = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        		anims[j].frameIDs = new int[]{244252686, 244252714, 244252760, 244252736, 244252678, 244252780, 244252817, 244252756, 244252700, 244252774, 244252834, 244252715, 244252732, 244252836, 244252776, 244252701, 244252751, 244252743, 244252685};
        	}
        	if(j == 10901) {
        		anims[j].frameCount = 19;
        		anims[j].loopDelay = 19;
        		anims[j].delays = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        		anims[j].frameIDs = new int[]{244252826, 244252833, 244252674, 244252724, 244252793, 244252696, 244252787, 244252753, 244252703, 244252800, 244252752, 244252744, 244252680, 244252815, 244252829, 244252769, 244252699, 244252757, 244252695};
        	}*/
			if (j == 9677) {
				//System.out.println(anims[9677]);
			}
			if (j == 5036) {
				cache[j] = new Animation();
				cache[j].frameCount = 9;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 5;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = -1;
				cache[j].priority = -1;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] {86704129,86704138,86704139,86704140,86704141,86704142,86704143,86704144,86704145,86704130,86704131,86704132,86704133,86704134,86704135,86704136};
				cache[j].delays = new int[] { 3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
			}
			if (j == 5325) {
				cache[j] = new Animation();
				cache[j].frameCount = 10;
				cache[j].loopDelay = 10;
				cache[j].forcedPriority = 5;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = -1;
				cache[j].priority = -1;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] {91095230,91095232,91095233,91095234,
											   91095235,91095236,91095237,91095238,91095239,91095231};
				cache[j].delays = new int[] { 2,2,2,2,2,2,2,2,2,2,};
			}
			if (j == 5327) {
				cache[j] = new Animation();
				cache[j].frameCount = 12;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 6;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = -1;
				cache[j].priority = -1;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = true;
				cache[j].frameIDs = new int[] {91095040,91095057,91095058,91095059,91095060,
												91095061,91095062,
												91095063,91095064,91095054,91095055,91095056,};
				cache[j].delays = new int[] { 4,4,4,4,4,3,3,3,3,3,4,4};
			}
			if (j == 5070) {
				cache[j] = new Animation();
				cache[j].frameCount = 9;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 5;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = 0;
				cache[j].priority = 0;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] { 11927608, 11927625, 11927598, 11927678, 11927582, 11927600, 11927669,
						11927597, 11927678 };
				cache[j].delays = new int[] { 5, 4, 4, 4, 5, 5, 5, 4, 4 };
			}
			if (j == 5061) {
				cache[j].frameCount = 13;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 6;
				cache[j].animationFlowControl = new int[] {1,2,9,11,13,15,17,19,37,39,41,43,45,164,166,168,170,172,174,176,178,180,182,183,185,191,192,9999999};
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = -1;
				cache[j].priority = -1;
				cache[j].delayType = 1;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] { 19267601,19267602,19267603,19267604,19267605,19267606,19267607,19267606,19267605,
						19267604,19267603,19267602,19267601};
				cache[j].delays = new int[] { 4,3,3,4,10,10,15,10,10,4,3,3,4};
			}
			if (j == 618) {
				cache[j].frameIDs = new int[] { 19267634,19267645,19267656,19267658,19267659,19267660,19267661,19267662,19267663,19267635,19267636,19267637,19267638,19267639,19267640,19267641,19267642,19267643,19267644,19267646,19267647,19267648,19267649,19267650,19267651,19267650,19267649,19267648,19267647,19267648,19267649,19267650,19267651,19267652,19267653,19267654,19267655,19267657,19267763,19267764,19267765,19267766 };
			}
			if (j == 619) {
				cache[j].frameIDs = new int[] { 19267664,19267675,19267686,19267691,19267692,19267693,19267694,19267695,19267696,19267665,19267666,19267667,19267668,19267669,19267670,19267671,19267672,19267673,19267674,19267676,19267677,19267678,19267679,19267668,19267669,19267670,19267671,19267672,19267673,19267674,19267676,19267677,19267678,19267679,19267680,19267681,19267682,19267683,19267684,19267685,19267687,19267688,19267689,19267690 };
			}
			if (j == 620) {
				cache[j].frameIDs = new int[] { 19267697,19267708,19267719,19267724,19267725,19267726,19267727,19267728,19267729,19267698,19267699,19267700,19267701,19267702,19267703,19267704,19267705,19267706,19267707,19267709,19267710,19267711,19267712,19267701,19267702,19267703,19267704,19267705,19267706,19267707,19267709,19267710,19267711,19267712,19267713,19267714,19267715,19267716,19267717,19267718,19267720,19267721,19267722,19267723 };
			}
			if (j == 621) {
				cache[j].frameIDs = new int[] {19267697,19267708,19267719,19267724,19267725,19267726,19267727,19267728,19267729,19267698,19267699,19267700,19267701,19267702,19267703,19267704,19267705,19267706,19267707,19267709,19267710,19267711,19267712,19267701,19267702,19267703,19267704,19267705,19267706,19267707,19267709,19267710,19267711,19267712,19267713,19267714,19267715,19267716,19267717,19267718,19267720,19267721,19267722,19267723};
			}
			if (j == 622) {
				cache[j].frameCount = 19;
				cache[j].frameIDs = new int[] {19267585,19267586,19267587,19267588,19267589,19267590,19267591,19267592,19267591,19267592,19267591,19267592,19267591,19267592,19267591,19267591,19267592,19267591,19267592};
				cache[j].delays = new int[] {15,4,4,4,12,4,15,15,15,15,15,15,15,15,15,15,15,15,15};
			}
			if (j == 623) {
				cache[j].frameIDs = new int[] {19267585,19267586,19267587,19267588,19267589,19267590,19267591,19267592,19267591,19267592,19267591,19267592,19267591,19267592,19267591,19267591,19267592,19267591,19267592};
				cache[j].delays = new int[] {15,4,4,4,12,4,15,15,15,15,15,15,15,15,15,15,15,15,15};
			}
			if (j == 1720) {
				cache[j].frameCount = 16;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 6;
				cache[j].animationFlowControl = new int[] {1,2,9,11,13,15,17,19,37,39,41,43,45,164,166,168,170,172,174,176,178,180,182,183,185,191,192,9999999};
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = -1;
				cache[j].priority = -1;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] { 18087977,18087978,18087979,18087980,18087981,18087969,18087970,18087971,
												18087972,18087973,18087979,18087978,18087977,18087976,18087975,18087974};
				cache[j].delays = new int[] { 3,2,3,6,2,2,5,5,5,5,3,2,3,3,4,4,};
			}
			if (j == 7083) {
				cache[j].frameCount = 16;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 6;
				cache[j].animationFlowControl = new int[] {1,2,9,11,13,15,17,19,37,39,41,43,45,164,166,168,170,172,174,176,178,180,182,183,185,191,192,9999999,};
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = -1;
				cache[j].priority = -1;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] { 18087977,18087978,18087979,18087980,18087981,18087969,18087970,18087971,18087972,
						 						18087973,18087979,18087978,18087977,18087976,18087975,18087974};
				cache[j].delays = new int[] { 3,2,3,6,2,2,5,5,5,5,3,2,3,3,4,4,};
			}
			if (j == 5069) {
				cache[j].frameCount = 15;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 6;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = 0;
				cache[j].priority = 0;
				cache[j].delayType = 1;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] { 11927613, 11927599, 11927574, 11927659, 11927676, 11927562, 11927626,
						11927628, 11927684, 11927647, 11927602, 11927576, 11927586, 11927653, 11927616 };
				cache[j].delays = new int[] { 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 };
			}
			if (j == 5072) {
				cache[j].frameCount = 21;
				cache[j].loopDelay = 1;
				cache[j].forcedPriority = 8;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = 0;
				cache[j].priority = 0;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] { 11927623, 11927595, 11927685, 11927636, 11927670, 11927579, 11927664,
						11927666, 11927661, 11927673, 11927633, 11927624, 11927555, 11927588, 11927692, 11927667, 11927556,
						11927630, 11927695, 11927643, 11927640 };
				cache[j].delays = new int[] { 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			}
			if (j == 5073) {
				cache[j].frameCount = 21;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 9;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = 0;
				cache[j].priority = 0;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = false;
				cache[j].frameIDs = new int[] { 11927640, 11927643, 11927695, 11927630, 11927556, 11927667, 11927692,
						11927588, 11927555, 11927624, 11927633, 11927673, 11927661, 11927666, 11927664, 11927579, 11927670,
						11927636, 11927685, 11927595, 11927623 };
				cache[j].delays = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2 };
			}
			if (j == 5806) {
				cache[j].frameCount = 55;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 6;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = 0;
				cache[j].priority = 0;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = true;
				cache[j].frameIDs = new int[] { 11927612, 11927677, 11927615, 11927573, 11927618, 11927567, 11927564,
						11927606, 11927675, 11927657, 11927690, 11927583, 11927672, 11927552, 11927563, 11927683, 11927639,
						11927635, 11927668, 11927614, 11927627, 11927610, 11927693, 11927644, 11927656, 11927660, 11927629,
						11927635, 11927668, 11927614, 11927627, 11927610, 11927693, 11927644, 11927656, 11927660, 11927635,
						11927668, 11927614, 11927560, 11927687, 11927577, 11927569, 11927557, 11927569, 11927577, 11927687,
						11927560, 11927651, 11927611, 11927680, 11927622, 11927691, 11927571, 11927601 };
				cache[j].delays = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
						4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 3 };
			}
			if (j == 5807) {
				cache[j].frameCount = 53;
				cache[j].loopDelay = -1;
				cache[j].forcedPriority = 6;
				cache[j].leftHandItem = -1;
				cache[j].rightHandItem = -1;
				cache[j].frameStep = 99;
				cache[j].resetWhenWalk = 0;
				cache[j].priority = 0;
				cache[j].delayType = 2;
				cache[j].oneSquareAnimation = true;
				cache[j].frameIDs = new int[] { 11927612, 11927677, 11927615, 11927573, 11927618, 11927567, 11927564,
						11927606, 11927675, 11927657, 11927690, 11927583, 11927672, 11927552, 11927563, 11927683, 11927639,
						11927635, 11927668, 11927614, 11927627, 11927610, 11927693, 11927644, 11927656, 11927660, 11927629,
						11927635, 11927668, 11927614, 11927627, 11927610, 11927693, 11927644, 11927656, 11927604, 11927637,
						11927688, 11927696, 11927681, 11927605, 11927681, 11927696, 11927688, 11927637, 11927604, 11927656,
						11927611, 11927680, 11927622, 11927691, 11927571, 11927601 };
				cache[j].delays = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
						4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 3 };
			}
		}
	}

	public int getFrameLength(int i)
	{
		if(i > delays.length)
			return 1;
		int j = delays[i];
		if(j == 0)
		{
			FrameReader reader = FrameReader.forId(frameIDs[i]);
			if(reader != null)
				j = delays[i] = reader.displayLength;
		}
		if(j == 0)
			j = 1;
		return j;
	}

	public void readValues(ByteBuffer stream)
	{
		do {
			int i = stream.getUnsignedByte();
			if(i == 0)
				break;
			if(i == 1) {
				frameCount = stream.getUnsignedShort();
				frameIDs = new int[frameCount];
				frameIDs2 = new int[frameCount];
				delays = new int[frameCount];
				for(int i_ = 0; i_ < frameCount; i_++){
					frameIDs[i_] = stream.getIntLittleEndian();
					frameIDs2[i_] = -1;
				}
				for(int i_ = 0; i_ < frameCount; i_++)
					delays[i_] = stream.getUnsignedByte();
			}
			else if(i == 2)
				loopDelay = stream.getUnsignedShort();
			else if(i == 3) {
				int k = stream.getUnsignedByte();
				animationFlowControl = new int[k + 1];
				for(int l = 0; l < k; l++)
					animationFlowControl[l] = stream.getUnsignedByte();
				animationFlowControl[k] = 0x98967f;
			}
			else if(i == 4)
				oneSquareAnimation = true;
			else if(i == 5)
				forcedPriority = stream.getUnsignedByte();
			else if(i == 6)
				leftHandItem = stream.getUnsignedShort();
			else if(i == 7)
				rightHandItem = stream.getUnsignedShort();
			else if(i == 8)
				frameStep = stream.getUnsignedByte();
			else if(i == 9)
				resetWhenWalk = stream.getUnsignedByte();
			else if(i == 10)
				priority = stream.getUnsignedByte();
			else if(i == 11)
				delayType = stream.getUnsignedByte();
			else
				System.out.println("Unrecognized seq.dat config code: "+i);
		} while(true);
		if(frameCount == 0)
		{
			frameCount = 1;
			frameIDs = new int[1];
			frameIDs[0] = -1;
			frameIDs2 = new int[1];
			frameIDs2[0] = -1;
			delays = new int[1];
			delays[0] = -1;
		}
		if(resetWhenWalk == -1)
			if(animationFlowControl != null)
				resetWhenWalk = 2;
			else
				resetWhenWalk = 0;
		if(priority == -1)
		{
			if(animationFlowControl != null)
			{
				priority = 2;
				return;
			}
			priority = 0;
		}
	}

	private Animation()
	{
		loopDelay = -1;
		oneSquareAnimation = false;
		forcedPriority = 5;
		leftHandItem = -1;
		rightHandItem = -1;
		frameStep = 99;
		resetWhenWalk = -1;
		priority = -1;
		delayType = 2;
	}
	public static Animation cache[];
	public int frameCount;
	public int frameIDs[];
	public int frameIDs2[];
	public int[] delays;
	public int loopDelay;
	public int animationFlowControl[];
	public boolean oneSquareAnimation;
	public int forcedPriority;
	public int leftHandItem;
	public int rightHandItem;
	public int frameStep;
	public int resetWhenWalk;
	public int priority;
	public int delayType;
	public static int anInt367;
}