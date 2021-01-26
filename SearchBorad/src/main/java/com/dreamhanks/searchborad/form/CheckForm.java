package com.dreamhanks.searchborad.form;

public class CheckForm {

	// 多重検索
	private String multiSearch;
	// 部分検索
	private String partialSearch;
	// 権限
	private String position;
	// 検索日（開始）
	private String startSearchDate;
	// 検索日（終了）
	private String endSearchDate;

	// 検索掲示板id
	private Integer [] id;

	// チェックフラグ
	private String [] checkFlg;

	public String getMultiSearch() {
		return multiSearch;
	}

	public void setMultiSearch(String multiSearch) {
		this.multiSearch = multiSearch;
	}

	public String getPartialSearch() {
		return partialSearch;
	}

	public void setPartialSearch(String partialSearch) {
		this.partialSearch = partialSearch;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStartSearchDate() {
		return startSearchDate;
	}

	public void setStartSearchDate(String startSearchDate) {
		this.startSearchDate = startSearchDate;
	}

	public String getEndSearchDate() {
		return endSearchDate;
	}

	public void setEndSearchDate(String endSearchDate) {
		this.endSearchDate = endSearchDate;
	}

	public Integer[] getId() {
		return id;
	}

	public void setId(Integer[] id) {
		this.id = id;
	}

	public String[] getCheckFlg() {
		return checkFlg;
	}

	public void setCheckFlg(String[] checkFlg) {
		this.checkFlg = checkFlg;
	}

}
