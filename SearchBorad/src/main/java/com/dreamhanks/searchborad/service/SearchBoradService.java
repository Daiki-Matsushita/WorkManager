package com.dreamhanks.searchborad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamhanks.searchborad.dao.BoradMapper;
import com.dreamhanks.searchborad.dao.SearchBoradMapper;
import com.dreamhanks.searchborad.dto.Borad;
import com.dreamhanks.searchborad.dto.BoradExample;

/**
 * メンバーに対するサービスクラス
 */
@Service
public class SearchBoradService {

	@Autowired
	private BoradMapper boradMapper;

	@Autowired
	private SearchBoradMapper searchBoradMapper;

	/**
	 * ログイン画面で入力されたパスワードでメンバーのオブジェクトを取得する
	 * @param password ログイン画面で入力されたパスワード
	 * @return メンバーのオブジェクト
	 */
	public List<Borad> getSarchBoradInfo(Map<String, Object> reqParam) {


		String multiSearch = (String) reqParam.get("multiSearch");
		String partialSearch = (String) reqParam.get("partialSearch");
		String position = (String) reqParam.get("position");
		String startSearchDate = null;
		if(reqParam.get("startSearchDate") != null && !"".equals(reqParam.get("startSearchDate"))) {
			startSearchDate = ((String) reqParam.get("startSearchDate")).replace("-", "");
		}
		String endSearchDate = null;
		if(reqParam.get("endSearchDate") != null && !"".equals(reqParam.get("endSearchDate"))) {
			endSearchDate = ((String) reqParam.get("endSearchDate")).replace("-", "");
		}

		// 入力された多重検索の値をスプリットして配列を作成する
		String[] multiSearchArray = null;
		if (multiSearch != null && !multiSearch.isEmpty()) {
			multiSearchArray = multiSearch.split(",");
		}

		//		// 検索掲示板TBLの情報を全て取得する
		//		BoradExample boradExample = new BoradExample();
		//		List<Borad> boradList = boradMapper.selectByExample(boradExample);

		// 画面入力された条件をもとに検索掲示板TBLから対象のレコードを取得する
		List<Borad> resultBoradList = searchBoradMapper.searchBorad(multiSearchArray, partialSearch, position, startSearchDate, endSearchDate);

		//		List<Borad> resultBoradList = new ArrayList<Borad>();
		//
		//		// 取得した検索掲示板TBL情報分処理を繰り返す
		//		for(Borad borad : boradList) {
		//
		//			// 多重検索が入力されていなければ、下記の判定はスキップ
		//			if(multiSearchArray != null) {
		//				// 文字列マッチフラグ（false:検索文字とDBが一致しない）
		//				boolean mauchFlg = false;
		//				// 入力された多重検索の値分処理を繰り返す
		//				for(String record : multiSearchArray) {
		//					// 検索文字が含まれている場合、マッチフラグをtrueにする
		//					if(borad.getTitle().contains(record)) {
		//						mauchFlg = true;
		//					}
		//				}
		//				// １つも一致しない場合、このレコードに対する処理をスキップ
		//				if(!mauchFlg) {
		//					continue;
		//				}
		//			}
		//
		//			// 部分一致が入力されていなければ、下記の判定はスキップ
		//			if(partialSearch != null) {
		//				// 部分検索文字がタイトルカラムに含まれていない場合、このレコードに対する処理をスキップ
		//				if(!borad.getTitle().contains(partialSearch)) {
		//					continue;
		//				}
		//			}
		//
		//			// 権限検索が入力されていなければ、下記の判定はスキップ
		//			if(position != null) {
		//				// 権限検索文字が権限カラムに含まれていない場合、このレコードに対する処理をスキップ
		//				if(!borad.getPosition().contains(position)) {
		//					continue;
		//				}
		//			}
		//
		//			// 開始日付検索が入力されていなければ、下記の判定はスキップ
		//			if(startSearchDate != null && !startSearchDate.isEmpty()) {
		//				// 開始日付より検索日付が大きい場合、このレコードに対する処理をスキップ
		//				if(Integer.parseInt(startSearchDate) > Integer.parseInt(borad.getCreatAt())) {
		//					continue;
		//				}
		//			}
		//
		//			// 終了日付検索が入力されていなければ、下記の判定はスキップ
		//			if(endSearchDate != null && !endSearchDate.isEmpty()) {
		//				// 終了日付より検索日付が小さい場合、このレコードに対する処理をスキップ
		//				if(Integer.parseInt(endSearchDate) < Integer.parseInt(borad.getCreatAt())) {
		//					continue;
		//				}
		//			}
		//			// 全ての入力値と整合している場合、結果リストにレコードを追加する
		//			resultBoradList.add(borad);
		//		}
		return resultBoradList;
	}

	//	/**
	//	 * チェックされた掲示板を更新する
	//	 * @param password ログイン画面で入力されたパスワード
	//	 * @return メンバーのオブジェクト
	//	 */
	//	public void updateSearchBorad(SearchBoradForm searchBoradForm) {
	//
	//		Integer [] idArray = searchBoradForm.getId();
	//		String [] checkFlgArray = searchBoradForm.getCheckFlg();
	//
	//		// 一覧分繰り返し処理
	//		for(int i = 0 ; i < idArray.length ; i++) {
	//			Borad borad = new Borad();
	//			// チェックされていない場合
	//			if(checkFlgArray[i] == null) {
	//				borad.setCheckFlg("0");
	//			} // チェックされている場合
	//			else {
	//				borad.setCheckFlg(checkFlgArray[i]);
	//			}
	//
	//			BoradExample boradExample = new BoradExample();
	//			boradExample.createCriteria().andIdEqualTo(idArray[i]);
	//			boradMapper.updateByExampleSelective(borad, boradExample);
	//
	//		}
	//	}

	/**
	 * チェックされた掲示板を更新する
	 * @param password ログイン画面で入力されたパスワード
	 * @return メンバーのオブジェクト
	 */
	public void updateSearchBorad(Map<String, Object> reqParam) {

		List<Integer> idArrayList = (ArrayList<Integer>) reqParam.get("idArray");
		List<String> checkFlgArrayList = (ArrayList<String>) reqParam.get("checkFlgArray");

		int loopCount = 0;

		// 一覧分繰り返し処理
		for (Integer idArray : idArrayList) {
			Borad borad = new Borad();

			// チェックされていない場合
			if (checkFlgArrayList.get(loopCount) == null) {
				borad.setCheckFlg("0");
			} // チェックされている場合
			else {
				borad.setCheckFlg(checkFlgArrayList.get(loopCount));
			}

			BoradExample boradExample = new BoradExample();
			boradExample.createCriteria().andIdEqualTo(idArray);
			boradMapper.updateByExampleSelective(borad, boradExample);

			loopCount++;
		}
	}

	/**
	 * チェックされた掲示板を更新する
	 * @param password ログイン画面で入力されたパスワード
	 * @return メンバーのオブジェクト
	 */
	public List<Borad> getIdAndCheckFlg(Map<String, Object> reqParam) {

		List<Integer> idArrayList = (ArrayList<Integer>) reqParam.get("idArray");

		BoradExample boradExample = new BoradExample();
		boradExample.createCriteria().andIdIn(idArrayList);
		List<Borad> boradList = boradMapper.selectByExample(boradExample);

		return boradList;

	}

}
