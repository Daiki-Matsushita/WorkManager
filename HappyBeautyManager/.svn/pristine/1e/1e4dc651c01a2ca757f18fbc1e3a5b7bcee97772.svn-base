package com.dreamhanks.HappyBeautyManager.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dreamhanks.HappyBeautyManager.constants.Constants;
import com.dreamhanks.HappyBeautyManager.dto.Manager;
import com.dreamhanks.HappyBeautyManager.dto.SearchDisplayMaster;
import com.dreamhanks.HappyBeautyManager.dto.Stampevent;
import com.dreamhanks.HappyBeautyManager.dto.TableListDisplayMaster;
import com.dreamhanks.HappyBeautyManager.form.DataManageProcessForm;
import com.dreamhanks.HappyBeautyManager.form.SearchForm;
import com.dreamhanks.HappyBeautyManager.form.UpdateForm;
import com.dreamhanks.HappyBeautyManager.service.LoginService;
import com.dreamhanks.HappyBeautyManager.service.ManageService;

/**
 * データ管理(manage)のコントローラー
 *
 * @author SungWook Lee and Elmurodjon
 *
 */
@Controller
@RequestMapping(value = "/manage")
public class ManageController {
	@Autowired
	private ManageService manageService;

	@Autowired
	LoginService loginService;

	/**
	 * データ管理画面とデータ認証管理画面をスイッチするメソッド
	 *
	 * @param dataManageProcessForm データ管理画面のForm
	 * @param model model
	 * @return データ管理画面.jsp or データ認証画面.jsp
	 */
	@RequestMapping(value = "/dataManageProcess")
	public String dataManageProcess(
			@ModelAttribute("DataManageProcessForm") DataManageProcessForm dataManageProcessForm, HttpSession session,
			Model model) {
		// ユーザがデータ管理を押下した場合
		if (dataManageProcessForm.getManage().equals("manage")) {
			// データ管理画面のテーブル一覧表示マスタ情報を取得する
			List<TableListDisplayMaster> tablesList =
					loginService.getDisplayMaster(Constants.MANAGE_DISPLAY_TABLE_LIST);

			// テーブル一覧表示マスタをアトリビュート
			model.addAttribute("tablesList", tablesList);

			// TODO ユーザ情報をセッションから取得（使ってないけどどうするの？）
			String userifo = (String) session.getAttribute("userInfo");

			return "manage";
		}
		// ユーザがデータ承認管理を押下した場合
		else if (dataManageProcessForm.getAuth().equals("auth")) {
			return "auth";
		}
		return "manage";
	}

	/**
	 * テーブル一覧のテーブルを押下した時に、検索条件を表示するためのメッソド
	 *
	 * @param model
	 * @return manage
	 */
	@RequestMapping(value = "/selectTableProcess")
	public String selectTableProcess(Model model) {

		return "search";
	}

	
	/**
	 * このメソッドは、テーブルの列名を表示するのに役立ちます
	 * 
	 * @param map 画面から受けた入力値
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return 結果リストが入っているMap
	 */
	@ResponseBody
	@RequestMapping(value = "/search_result")
	public Map<String, Object> selectTableProcess(@RequestBody Map<String, Object> map, Model model) {

		// テーブルの名前をに挿入します
		String identificationNumber = (String) map.get("identificationNumber");
		// データベースから列の名前を取得する
		List<SearchDisplayMaster> tableColumList = manageService.selectedTableInfo(identificationNumber);

		// jspファイルにデータを送信するためのオブジェクトの作成
		Map<String, Object> resultMap = new HashMap<String, Object>();

		// resultMapオブジェクトに列の名前を挿入します
		resultMap.put("tableColumList", tableColumList);

		// jspファイルにデータを返す
		return resultMap;
	}

	/**
	 * この方法はデータの検索に役立ちます
	 * 
	 * @param map 画面から受けた入力値
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return 結果リストが入っているMap
	 * @throws ParseException これはチェックされた例外であり、特別な形式である必要がある文字列の解析に失敗した場合に発生する可能性があります。 
	 * その上で非常に重要な例の1つは、文字列を日付オブジェクトに解析しようとしている場合です。 ...指定された文字列がその形式を満たさない場合はjava。
	 */
	@ResponseBody
	@RequestMapping(value = "/search_data")
	public Map<String, Object> searchProcessing(@RequestBody Map<String, Object> map, Model model)
			throws ParseException {

		// 検索結果一覧から選択された行のテーブル識別番号を取得する
		String identificationNumber = (String) map.get("identificationNumber");
		
		// 入力された検索条件を取得する
		List<String> searchList = (List<String>) map.get("searchResultList");
		
		
		// 検索条件にあう対象のテーブルの情報を取得する
		List<Object> resultList = manageService.searchProcessing(searchList, identificationNumber);
		
		// テーブル識別番号に合うテーブルのカラム名を取得する
		List<SearchDisplayMaster> tableColumList = manageService.selectedTableInfo(identificationNumber);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// テーブル識別番号に合うテーブルのカラム名を取得する
		
		// 取得した対象テーブルの情報
		resultMap.put("searchResultList", resultList);
		// 識別番号
		resultMap.put("identificationNum", identificationNumber);
		// 対象テーブルのカラム名リスト
		resultMap.put("tableColumList", tableColumList);
		// searchForm覧表示マスタをアトリビュート
		model.addAttribute("searchForm", new SearchForm());

		return resultMap;

	}


	/**
	 * jspファイルを画面に表示するために'登録メソッド'を作成する
	 * 
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @param session HttpSessionオブジェクトは、セッション管理に使用されます。 セッションには、アプリケーション全体の特定のユーザーに固有の情報が含まれています。 
	 * ユーザーがWebサイト（またはオンラインアプリケーション）に初めてアクセスしたときに、リクエストを介してHttpSessionが取得されます。
	 * @return 登録jspファイルを返す
	 */
	@RequestMapping(value = "/registrate")
	public String registrate(Model model, HttpSession session) {

		// セッションからユーザー情報を取得する
		Manager userResult = (Manager) session.getAttribute("userInfo");

		// Display_Masterの中で基本テーブル(group_idが１、available_flgが１)の情報を取得
		List<TableListDisplayMaster> listDisplayMaster =
				loginService.getDisplayMaster(Constants.MANAGE_DISPLAY_TABLE_LIST);



		// jspファイルで使用するために、属性に「ユーザー名、認証、テーブルリスト」を追加します
		model.addAttribute("userName", userResult.getName());
		model.addAttribute("auth", userResult.getAuth());
		model.addAttribute("tablesList", listDisplayMaster);


		return "registrate";

	}

	
	/**
	 * データベースにデータを挿入するために「registrateProcessingメソッド」を作成する
	 * 
	 * @param map 画面から受けた入力値
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @param session HttpSessionオブジェクトは、セッション管理に使用されます。 セッションには、アプリケーション全体の特定のユーザーに固有の情報が含まれています。 
	 * ユーザーがWebサイト（またはオンラインアプリケーション）に初めてアクセスしたときに、リクエストを介してHttpSessionが取得されます。
	 * @return 結果リストが入っているMap
	 * @throws ParseException これはチェックされた例外であり、特別な形式である必要がある文字列の解析に失敗した場合に発生する可能性があります。 
	 * その上で非常に重要な例の1つは、文字列を日付オブジェクトに解析しようとしている場合です。 ...指定された文字列がその形式を満たさない場合はjava。
	 */
	@ResponseBody
	@RequestMapping(value = "/registrate_processing")
	public Map<String, Object> registrateProcessing(@RequestBody Map<String, Object> map, Model model,
			HttpSession session) throws ParseException {

		// セッションからユーザー情報を取得する
		Manager userResult = (Manager) session.getAttribute("userInfo");
		// ユーザーIDの取得
		String managerId = userResult.getId();
		// テーブル名の取得
		String identificationNumber = (String) map.get("identificationNumber");
		// Input valueの取得
		List<String> searchList = (List<String>) map.get("searchResultList");
		// データベースにデータを挿入するために、「manageServiceクラスregistrateProcessingメソッド」にデータを送信します
		int result = manageService.registrateProcessing(searchList, managerId, identificationNumber);

		String message = "";

		// 登録処理が成功する場合は成功のメッセージを送信しますが、それ以外の場合はエラーのメッセージを送信します
		if (result == 1) {
			message = "登録が完了しました";
		} else {
			message = "error";
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("insertResult", message);

		return resultMap;

	}
	
	
	
	@RequestMapping(value = "/delete")
	public String delete(Model model, SearchForm searchForm) { 

		List<Object> selectedDataList = manageService.getSelectedData(searchForm);
		List<SearchDisplayMaster> tableColumList = manageService.selectedTableInfo(searchForm.getIdentificationNumber());
		
		model.addAttribute("selectedDataList", selectedDataList);
		model.addAttribute("tableColumList", tableColumList);
		
		return "deleteConfirmation";
	}


	@RequestMapping(value = "/updateProcess")
	public String insertProcess(@ModelAttribute("UpdateForm") UpdateForm updateForm, Model model) {
		// クリックされた時のレーコドのテーブル名を取得
		String tableName = manageService.getSelectedTableName(updateForm);
		// クリックされた時のレーコドを取得
		Stampevent SelectedRow = manageService.getSelectedRow(updateForm);

		// 取得されたレーコドのテーブル名とレーコドをモデルに詰める。
		model.addAttribute("SelectedRow", SelectedRow);
		model.addAttribute("tableName", tableName);
		return "test";
	}



}


