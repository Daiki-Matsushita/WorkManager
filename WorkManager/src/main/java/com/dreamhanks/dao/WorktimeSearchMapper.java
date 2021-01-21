package com.dreamhanks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dreamhanks.dto.WorktimeSearch;

/**
 * WorktimeSearchMapperのインターフェース
 * @author dream
 *
 */
public interface WorktimeSearchMapper {

	/**
	 * 勤務時間検索結果を取得するメソッド
	 * @param year 年
	 * @param month 月
	 * @param name 氏名
	 * @return 勤務時間検索結果
	 */
	public List<WorktimeSearch> worktimeSearch(@Param("year") String year, @Param("month") String month, @Param("name") String name);

}