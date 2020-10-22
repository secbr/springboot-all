package com.secbro2.strategy;

/**
 * @author sec
 * @version 1.0
 * @date 2020/10/22
 **/
public enum ParkEnum {

	DEFAULT_PARK(0, "defaultParkStrategy", "默认公园"),
	PERSON_PARK(1, "peopleParkStrategy", "人民公园"),
	BEI_HAI_PARK(2, "beiHaiParkStrategy", "北海公园"),

	;

	ParkEnum(int parkId, String serviceName, String desc) {
		this.parkId = parkId;
		this.serviceName = serviceName;
		this.desc = desc;
	}

	public static ParkEnum valueOf(int parkId) {
		for (ParkEnum parkEnum : ParkEnum.values()) {
			if (parkEnum.getParkId() == parkId) {
				return parkEnum;
			}
		}
		return DEFAULT_PARK;
	}

	private int parkId;

	private String serviceName;

	private String desc;

	public int getParkId() {
		return parkId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getDesc() {
		return desc;
	}
}
