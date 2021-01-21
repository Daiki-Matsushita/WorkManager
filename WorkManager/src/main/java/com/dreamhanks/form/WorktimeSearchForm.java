package com.dreamhanks.form;

import org.hibernate.validator.constraints.NotEmpty;

public class WorktimeSearchForm {

	// 検索年
	@NotEmpty(message="空欄は不可です。検索年をご入力ください")
	private String year;

	// 検索月
	@NotEmpty(message="空欄は不可です。検索月をご入力ください")
	private String month;

	// 検索氏名
	@NotEmpty(message="空欄は不可です。検索氏名をご入力ください")
	private String name;

	// メンバーID
	private String memberId;

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


}
