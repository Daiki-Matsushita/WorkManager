//package com.dreamhanks.workmanager;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.dreamhanks.form.LoginForm;
//
///**
// * メンバーに対するコントローラクラス
// */
//@RequestMapping(value = "/member")
//@Controller
//public class MemberController2 {
//
//	/**
//	 * ログイン画面を開くためのメソッド
//	 * @param loginForm クライアント側でloginFormを使えるようにする空クラス
//	 * @param model ControllerからViewに値を受け渡すためのパラメータ
//	 * @return  ログイン画面のJSPファイル名
//	 */
//	@RequestMapping(value = "/login")
//	public String initLogin(LoginForm loginForm, Model model) {
//
//		model.addAttribute("loginForm", new LoginForm());
//
//		return "login";
//	}
//}
