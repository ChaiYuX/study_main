package com.enumEntity;


public enum NurseOrderInfoEnum  {
	CANCEL("-1" , "取消"),
	TO_BE_ASSIGNED("1" , "待分配"),
	ASSIGNED("2" , "已分配"),
	LEFT_HOME("4" , "已出门"),
	IN_SERVICE("5" , "服务中"),
	SERVICE_COMPLETED("6" , "服务完成");


	NurseOrderInfoEnum(String value, String desc) {

		this.value = value;
		this.desc = desc;

	}

	public String getValue() {
		return value;
	}

	public String getDesc() {
		return this.desc;
	}

	private String value;
	private String desc;
}
