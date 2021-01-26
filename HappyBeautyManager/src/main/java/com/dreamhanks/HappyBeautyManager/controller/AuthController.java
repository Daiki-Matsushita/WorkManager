package com.dreamhanks.HappyBeautyManager.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamhanks.HappyBeautyManager.dto.SearchDisplayMaster;
import com.dreamhanks.HappyBeautyManager.dto.TableListDisplayMaster;
import com.dreamhanks.HappyBeautyManager.form.ReservationSearchForm;
import com.dreamhanks.HappyBeautyManager.form.TableForm;
import com.dreamhanks.HappyBeautyManager.service.AuthService;

/**
 * 承認却下画面で行うリクエストを実行するためのコントローラー
 * @author jini
 *
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	/**
	 * 承認却下確認画面を開くためのメソッド
	 * @param model　ControllerからViewに値を受け渡すためのパラメータ
	 * @return　承認却下確認画面のJSPファイル名
	 */
	@RequestMapping(value = "/switchToAuthProcess")
	public String switchToAuthProcess(Model model) {
		List<TableListDisplayMaster> tableName = authService.bringTableName();
		model.addAttribute("tableName", tableName);
		model.addAttribute("TableForm", new TableForm());

		return "auth";
	}

	/**
	 * テーブルをクリックした時、検索条件までの実行をするためのメソッド
	 * @param map 画面から受けた入力値
	 * @return テーブルのカラム名リストが入っているMap
	 */
	@ResponseBody
	@RequestMapping(value = "/selectTableProcess")
	public Map<String,Object> selectTableProcess(@RequestBody Map<String,Object> map) {
		String identificationNum=(String) map.get("tableValue");
		List<SearchDisplayMaster> tableColumList = authService.selectedTableInfo(identificationNum);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("tableColumList", tableColumList);
		resultMap.put("identificationNum", identificationNum);
	
		return resultMap;
	}
	
	/**
	 * 検索条件から検索結果リストでの実行をするためのメソッド
	 * @param map 画面から受けた入力値
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return 結果リストが入っているMap
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/searchProcess")
	public Map<String,Object> searchProcess(@RequestBody Map<String,Object> map,Model model) throws ParseException {
		String tableValue = (String) map.get("tableValue");
		List<String> searchList = (List<String>) map.get("searchResultList");
		
		List<Object> searchResultList = authService.searchResultList(searchList,tableValue);
		List<SearchDisplayMaster> tableColumList = authService.selectedTableInfo(tableValue);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("searchResultList", searchResultList);
		resultMap.put("identificationNum", (String) map.get("tableValue"));
		resultMap.put("tableColumList", tableColumList);
		model.addAttribute("reservationSearchForm", new ReservationSearchForm());


		return resultMap;
	}
	/**
	 * 承認却下をする値を確認するメソッド
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @param reservationSearchForm テーブルの識別番号情報とチェックされた値
	 * @return　承認却下確認画面のjspファイル名
	 */
	@RequestMapping(value = "/authConfirmProcess")
	public String authConfirmProcess(Model model,ReservationSearchForm reservationSearchForm) {
		List<Object> authConfirmList = authService.authConfirmList(reservationSearchForm);
		List<SearchDisplayMaster> tableColumList = authService.selectedTableInfo(reservationSearchForm.getIdentificationNumber());
		String[] checkList = reservationSearchForm.getCheckedList();
		model.addAttribute("tableColumList", tableColumList);
		model.addAttribute("authConfirmList", authConfirmList);
		model.addAttribute("identificationNumber", reservationSearchForm.getIdentificationNumber());
		model.addAttribute("checkedList",checkList);
		model.addAttribute("reservationSearchForm", new ReservationSearchForm());

		return "authComfirm";
	}
	/**
	 * 承認却下をする値を確認してDBにその情報を適用するメソッド
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @param reservationSearchForm　テーブルの識別番号情報とチェックされた値 
	 * @return　承認却下成功画面のjspファイル名
	 */
	@RequestMapping(value = "/authSucessProcess")
	public String authSucessProcess(Model model,ReservationSearchForm reservationSearchForm) {
		
		authService.insertTableInfo(reservationSearchForm);
		authService.updateTableInfo(reservationSearchForm);
		authService.deleteTableInfo(reservationSearchForm);

		

		return "authSucessProcess";
	}
	

}
