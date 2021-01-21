package com.dreamhanks.form;

import java.util.ArrayList;
import java.util.List;

public class WorktimeRegistForm {

	// WorktimeRegistFormに対するリスト
	private List<WorktimeRegistForm> worktimeRegistFormList = new ArrayList<WorktimeRegistForm>();

	// 設定年
	private String year;

	// 設定月
	private String month;

	// 出社時間
	private String startTime;

	// 退社時間
	private String endTime;

	// 休み時間
	private String restTime;

	// 備考
	private String memo;

	// memberId
	private String memberId;



	public List<WorktimeRegistForm> getWorktimeRegistFormList() {
		return worktimeRegistFormList;
	}

	public void setWorktimeRegistFormList(List<WorktimeRegistForm> worktimeRegistFormList) {
		this.worktimeRegistFormList = worktimeRegistFormList;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public String getRestTime() {
		return restTime;
	}

	public void setRestTime(String restTime) {
		this.restTime = restTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
