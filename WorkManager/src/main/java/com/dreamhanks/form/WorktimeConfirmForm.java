package com.dreamhanks.form;

import java.util.ArrayList;
import java.util.List;

public class WorktimeConfirmForm {

	// WorktimeRegistFormに対するリスト
	private List<WorktimeConfirmForm> worktimeConfirmForm = new ArrayList<WorktimeConfirmForm>();

	// 設定年
	private String year;

	// 設定月
	private String month;

	// 検索氏名
	private String name;

	// 日にち
	private String day;

	// 曜日
	private String week;

	// 出社時間
	private String startTime;

	// 退社時間
	private String endTime;

	// 休み時間
	private String restTime;

	// 備考
	private String memo;


	public List<WorktimeConfirmForm> getWorktimeConfirmForm() {
		return worktimeConfirmForm;
	}

	public void setWorktimeConfirmForm(List<WorktimeConfirmForm> worktimeConfirmForm) {
		this.worktimeConfirmForm = worktimeConfirmForm;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
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
}
