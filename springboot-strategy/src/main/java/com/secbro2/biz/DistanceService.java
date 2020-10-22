package com.secbro2.biz;

/**
 * 原始方法实现
 * @author sec
 * @version 1.0
 * @date 2020/10/22
 **/
public class DistanceService {

	public int getDistance(int parkId, int count) {
		// 如果是公园x，1个间距为y（比如：10）米
		if (parkId == 1) {
			return 10 * count;
		} else if (parkId == 2) {
			return 5 * count;
		} else if (parkId == 3) {
			return 50 * count;
		} else {
			// 默认 20米
			return 20 * count;
		}
	}
}
