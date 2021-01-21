package com.dreamhanks.dto;

public class WorktimeSearch {

	// メンバーID
	private Integer memberId;
	// 勤務年
	private String year;
	// 勤務月
	private String month;
	// 氏名
	private String name;
	// 月間総勤務時間
	private String sumWorktime;

	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSumWorktime() {
		return sumWorktime;
	}
	public void setSumWorktime(String sumWorktime) {
		this.sumWorktime = sumWorktime;
	}

}