package com.dreamhanks.form;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.NotEmpty;

public class WorktimeChoiceForm {

	// 設定月
	@NotEmpty(message="空欄は不可です。設定月を選択ください")
	private String month;

	// 出社時間
	@NotEmpty(message="空欄は不可です。出社時間を選択ください")
	private String startTime;

	// 退社時間
	@NotEmpty(message="空欄は不可です。退社時間を選択ください")
	private String endTime;

	// memberId
	private String memberId;

	// 勤務時間の相関チェック
    @AssertTrue(message="出社時間は退社時間以前を入力してください。")
    public boolean isDateValid() {
        if (startTime.compareTo(endTime) == -1) return true;
        return false;
    }

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
