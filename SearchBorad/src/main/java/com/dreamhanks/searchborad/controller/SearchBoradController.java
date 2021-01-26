package com.dreamhanks.searchborad.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamhanks.searchborad.dto.Borad;
import com.dreamhanks.searchborad.form.SearchBoradForm;
import com.dreamhanks.searchborad.service.SearchBoradService;

/**
 * 検索掲示板に対するコントローラクラス
 */
@RequestMapping(value = "/searchborad")
@Controller
public class SearchBoradController {

	@Autowired
	private SearchBoradService searchBoradService;

	/**
	 * 検索掲示板画面を開くためのメソッド
	 * @param searchBoradForm クライアント側でsearchBoradFormを使えるようにする空クラス
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return  検索掲示板画面のJSPファイル名
	 */
	@RequestMapping(value = "/init")
	public String initSarchBorad(SearchBoradForm searchBoradForm, Model model) {

		model.addAttribute("searchBoradForm", new SearchBoradForm());

		return "search_borad";
	}

//	/**
//	 * 入力されたデータをもとにDB検索を行い検索掲示板結果を出力するためのメソッド
//	 * @param searchBoradForm クライアント側でsearchBoradFormを使えるようにする空クラス
//	 * @param model ControllerからViewに値を受け渡すためのパラメータ
//	 * @return  検索掲示板画面のJSPファイル名
//	 */
//	@RequestMapping(value = "/search_result")
//	public String selectSarchBorad(@ModelAttribute SearchBoradForm searchBoradForm, Model model) {
//
//		// 入力されたデータをもとに検索掲示板情報を取得する
//		List<Borad> boradList = searchBoradService.getSarchBoradInfo(searchBoradForm);
//
//		model.addAttribute("searchBoradForm", searchBoradForm);
//
//		model.addAttribute("boradList", boradList);
//
//		return "search_borad";
//	}

	/**
	 * 入力されたデータをもとにDB検索を行い検索掲示板結果を出力するためのメソッド
	 * @param searchBoradForm クライアント側で入力されたデータ
	 * @return  検索掲示板画面のJSPファイル名
	 */
	@ResponseBody
	@RequestMapping(value = "/search_result", method = RequestMethod.POST)
	public List<Borad> selectSarchBorad(@RequestBody Map<String, Object> reqParam) {

		// 入力されたデータをもとに検索掲示板情報を取得する
		List<Borad> boradList = searchBoradService.getSarchBoradInfo(reqParam);
		
				
				

		return boradList;
	}


//	/**
//	 */
//	@RequestMapping(value = "/update_result")
//	public String updateSarchBorad(@ModelAttribute SearchBoradForm searchBoradForm, Model model) {
//
//		// 検索掲示板結果一覧を更新する
//		searchBoradService.updateSearchBorad(searchBoradForm);
//
//		// 入力されたデータをもとに検索掲示板情報を取得する
//		List<Borad> boradList = searchBoradService.getSarchBoradInfo(searchBoradForm);
//
//		model.addAttribute("searchBoradForm", searchBoradForm);
//
//		model.addAttribute("boradList", boradList);
//
//		return "search_borad";
//	}

	/**
	 */
	@ResponseBody
	@RequestMapping(value = "/update_result")
	public List<Borad> updateSarchBorad(@RequestBody Map<String, Object> reqParam) {

		// 検索掲示板結果一覧を更新する
		searchBoradService.updateSearchBorad(reqParam);

		// 入力されたデータをもとに検索掲示板情報を取得する
		List<Borad> boradList = searchBoradService.getSarchBoradInfo(reqParam);

		return boradList;
	}

}
