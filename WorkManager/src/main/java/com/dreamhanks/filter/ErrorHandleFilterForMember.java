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
public class ErrorHandleFilterForMember implements Filter {
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

		// セッションからログイン情報を取得する(一般メンバー）
		Member member = (Member) session.getAttribute("member");

		// クライアント側でログイン画面に初リクエストをした場合
		if ("/workmanager/member/login".equals(current_uri)) {
			// ログイン情報がセッションにない場合
			if (member == null) {
				// そのまま通す
				chain.doFilter(request, response);
				return;
			} //ある場合、登録画面に遷移させる
			else {
				httpResponse.sendRedirect("/workmanager/member/moveWorktimeChoice");
				return;
			}

		} // クライアント側でパスワードを入力してリクエストをした場合or直接URLをたたいた場合
		else if ("/workmanager/member/loginProcess".equals(current_uri)) {
			// 今のリクエストパラメータで、今のURIにリクエストする。
			// リクエストパラメータ自体はこれでOK、この後コントローラでパスワードがDBと合っているか処理を行う
			// 直接ダイレクトされた場合、パスワードが空欄なのでヴァリデーションチェックで引っ掛かりログイン画面に差し戻される
			chain.doFilter(request, response);
			return;

		} // 一度ログインしたのに、もう一度ログインURLを直接たたいた場合。
		else if ("/workmanager/member/moveWorktimeChoice".equals(current_uri)) {
			//			// ログイン情報がセッションにある場合
			//			if(member != null) {　☆★★　ログイン情報がセッションにないなんてない　⇒　やっぱり間違ってるみたい、ログインしない状態で、直接たたいてみて確認して
			// そのまま通す
			chain.doFilter(request, response);
			return;
			//			} //ない場合、登録画面に遷移させる
			//			else {
			//				httpResponse.sendRedirect("/workmanager/member/login");
			//				return;
			//			}
		}
		// 登録画面で登録内容を設定してsubmitボタンを押下した場合orr直接URLをたたいた場合
		else if ("/workmanager/member/regist".equals(current_uri)) {
			// ログイン情報がセッションにある場合
			if (member != null) {
				// そのまま通す
				chain.doFilter(request, response);
				return;
			} //ない場合、ログイン画面に差し戻す
			else {
				httpResponse.sendRedirect("/workmanager/member/login");
				return;
			}
		} // 登録設定画面で登録内容を設定してsubmitボタンを押下した場合orr直接URLをたたいた場合
		else if ("/workmanager/member/registProcess".equals(current_uri)) {
			// ログイン情報がセッションにある場合
			if (member != null) {
				// そのまま通す
				chain.doFilter(request, response);
				return;
			} //ない場合、ログイン画面に差し戻す
			else {
				httpResponse.sendRedirect("/workmanager/member/login");
				return;
			}
		}
	}

	/**
	 * 自分の学習のために、メモを残す
	 */
	public void doFilterExample(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// doFilterのパラのリクエストの形式がどのように格納されているかわからない＝keyがなんだかわからない
		// httpのリクエスト情報の中にはセッション情報とはURIとかURLとURNとかが格納されている

		// ☆HttpServletRequestに型変換した理由：「request.getAttribute("なにか")」で一生懸命デバッグモードで
		// 例えばURIのKeyが何かを調べて取得することも確かにできる。
		// しかしHttpServletRequestに型変換すると「getRequestURI」などの便利なメソッドが使えるようになり
		// これらを使ったほうが、URIやセッションなどの取得が楽になるから。
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// セッションを取得
		HttpSession session = httpRequest.getSession();
		// リクエストのURIを取得。それを文字列にする。
		// ⇒　受け取った言リクエストのURIが「localhost8080:~~login」とかと一致しているかを確かめるために使う
		String current_uri = httpRequest.getRequestURI();

		// セッションからログイン情報を取得する
		//		User user = (User) session.getAttribute("userinfo");

		// URLの整合性のチェック
		if ("/workmanager/user/user_login".equals(current_uri)) {
			try {
				// ログインのURIが同じだった場合に、hhtpのレスポンスにsendRedirect（もう一度方向転換）をする
				// このURLにリクエストをしてね。
				httpResponse.sendRedirect("/workmanager/user/user_select_time");
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			// ログインのURIが
		} else {
			try {
				// そのままの方向でリクエストする。
				chain.doFilter(request, response);
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}

		// 何かからチェックするか？を考えるする
		// OKならChaindFilter。間違っていたら、catth処理

		try {
			chain.doFilter(request, response);
		} catch (Exception ex) {
			//			request.setAttribute("errorMessage", ex);
			//			request.getRequestDispatcher("/WEB-INF/views/jsp/error.jsp")
			//					.forward(request, response);
		}
	}

}
