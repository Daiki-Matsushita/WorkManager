package com.dreamhanks.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dreamhanks.dto.Member;

/**
 * 取得したリクエストに対してフィルター処理を行い、コントローラにリクエストを渡すクラス
 * @author dream
 *
 */
public class ErrorHandleFilterForManager implements Filter {
	public void destroy() {
		//...
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}

	/**
	 * 受けたリクエストに対してフィルタ処理を行い、適切なコントローラにリクエストを渡すメソッド
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// エクセルにも理由を書いたが、ServletRequestよりもHttpServletRequestのほうが便利なメソッドが使えるから
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// セッションを取得
		HttpSession session = httpRequest.getSession();
		// URIの取得
		String current_uri = httpRequest.getRequestURI();

		// セッションからログイン情報を取得する(管理者）
		Member manager = (Member) session.getAttribute("manager");

		// クライアント側でログイン画面に初リクエストをした場合
		if ("/workmanager/manager/login_manager".equals(current_uri)) {
			// ログイン情報がセッションにない場合
//			if (manager == null) {
				// そのまま通す
				chain.doFilter(request, response);
				return;
//			} //ある場合、登録画面に遷移させる
//			else {
//				httpResponse.sendRedirect("/workmanager/member/moveWorktimeChoice");
//				return;
//			}

		} // クライアント側でパスワードを入力してリクエストをした場合or直接URLをたたいた場合
		else if ("/workmanager/manager/loginProcess_manager".equals(current_uri)) {
			// 今のリクエストパラメータで、今のURIにリクエストする。
			// リクエストパラメータ自体はこれでOK、この後コントローラでパスワードがDBと合っているか処理を行う
			// 直接ダイレクトされた場合、パスワードが空欄なのでヴァリデーションチェックで引っ掛かりログイン画面に差し戻される
			chain.doFilter(request, response);
			return;

		} // 一度ログインしたのに、もう一度ログインURLを直接たたいた場合。
		else if ("/workmanager/manager/search".equals(current_uri)) {
						// ログイン情報がセッションにある場合
						if(manager != null) {//　☆★★　ログイン情報がセッションにないなんてない　⇒　やっぱり間違ってるみたい、ログインしない状態で、直接たたいてみて確認して
			// そのまま通す
			chain.doFilter(request, response);
			return;
						} //ない場合、登録画面に遷移させる
						else {
							httpResponse.sendRedirect("/workmanager/manager/login_manager");
							return;
						}
		}
		// 登録画面で登録内容を設定してsubmitボタンを押下した場合orr直接URLをたたいた場合
		else if ("/workmanager/manager/confirm".equals(current_uri)) {
			// ログイン情報がセッションにある場合
			if (manager != null) {
				// そのまま通す
				chain.doFilter(request, response);
				return;
			} //ない場合、ログイン画面に差し戻す
			else {
				httpResponse.sendRedirect("/workmanager/manager/login_manager");
				return;
			}
		}
		// 登録画面で登録内容を設定してsubmitボタンを押下した場合orr直接URLをたたいた場合
		else if ("/workmanager/manager/downloead".equals(current_uri)) {
			// ログイン情報がセッションにある場合
			if (manager != null) {
				// そのまま通す
				chain.doFilter(request, response);
				return;
			} //ない場合、ログイン画面に差し戻す
			else {
				httpResponse.sendRedirect("/workmanager/manager/login_manager");
				return;
			}
		}
	}
}
