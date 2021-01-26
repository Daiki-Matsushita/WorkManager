package com.dreamhanks.HappyBeautyManager.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dreamhanks.HappyBeautyManager.constants.Constants;
import com.dreamhanks.HappyBeautyManager.dto.Manager;
import com.dreamhanks.HappyBeautyManager.dto.TableListDisplayMaster;
import com.dreamhanks.HappyBeautyManager.form.LoginForm;
import com.dreamhanks.HappyBeautyManager.service.LoginService;

/**
 * ログイン画面のコントローラ
 *
 * @author jini and elmu
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	Constants constants;



	/**
	 * ログイン画面を開くためのメソッド
	 *
	 * @param model JSPに渡す情報を格納するパラメータ
	 * @return ログイン画面jspのファイル名
	 */
	@RequestMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}


	/**
	 * 入力チェックを行うメソッド
	 *
	 * @param loginform 画面から入力された値が入っているフォームクラス
	 * @param result 入力チェック結果
	 * @param session session情報
	 * @param model JSPに渡す情報を格納するパラメータ
	 * @return ログイン画面や検索画面jspのファイル名
	 */
	@RequestMapping(value = "/loginProcess")
	public String loginProcess(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult theBindingResult,
			Model model, HttpSession session) {

		Manager userResult;

		// 入力情報に誤りがある場合、ログイン画面に差し戻す
		if (theBindingResult.hasErrors()) {
			return "login";
		}
		// 入力情報が正しい場合、かつセッション情報がない場合
		else if (session.getAttribute("userInfo") == null) {

			// ログイン情報でDBで照会し、それに該当するユーザー情報を返す
			userResult = loginService.getManager(loginForm);

			// ユーザー情報が取得できない場合、ログイン画面に差し戻す
			if (userResult == null) {
				return "login";
			}

			// ログイン情報が合っている場合、セッションにユーザの情報をアトリビュート
			session.setAttribute("userInfo", userResult);

		}
		// セッションの中にある場合
		else {
			// セッション情報からユーザー情報を取得する
			userResult = (Manager) session.getAttribute("userInfo");
		}


		// データ管理画面のテーブル一覧情報を取得する
		List<TableListDisplayMaster> listDisplayMaster =
				loginService.getDisplayMaster(Constants.MANAGE_DISPLAY_TABLE_LIST);

		// ユーザネームをアトリビュート
		model.addAttribute("userName", userResult.getName());

		// 権限authをアトリビュート
		model.addAttribute("auth", userResult.getAuth());

		// データ管理画面のテーブル一覧のアトリビュート
		model.addAttribute("tablesList", listDisplayMaster);


		return "search";

	}

}


