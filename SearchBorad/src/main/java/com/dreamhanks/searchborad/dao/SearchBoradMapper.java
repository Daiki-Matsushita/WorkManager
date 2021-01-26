package com.dreamhanks.searchborad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dreamhanks.searchborad.dto.Borad;

public interface SearchBoradMapper {

	/**
	 * 画面入力された条件をもとに検索掲示板TBLから対象のレコードを取得するメソッド
	 * @param multiSearch 複数語検索
	 * @param partialSearch 部分検索
	 * @param position 役割検索
	 * @param startSearchDate 開始時間検索
	 * @param endSearchDate 終了時間検索
	 * @return 検索結果
	 */
	List<Borad> searchBorad(@Param("multiSearchArray") String[] multiSearchArray, @Param("partialSearch") String partialSearch,
			@Param("position") String position, @Param("startSearchDate") String startSearchDate,
			@Param("endSearchDate") String endSearchDate);
}