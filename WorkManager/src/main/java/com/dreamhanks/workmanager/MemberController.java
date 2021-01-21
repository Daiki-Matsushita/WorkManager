package com.dreamhanks.workmanager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dreamhanks.dto.Member;
import com.dreamhanks.dto.Worktime;
import com.dreamhanks.form.LoginForm;
import com.dreamhanks.form.WorktimeChoiceForm;
import com.dreamhanks.form.WorktimeRegistForm;
import com.dreamhanks.service.MemberService;

/**
 * メンバーに対するコントローラクラス
 */
@RequestMapping(value = "/member")
@Controller
// @SessionAttributes("password")
public class MemberController {

	@Autowired
	private MemberService memberService = new MemberService();

	/**
	 * ログイン画面を開くためのメソッド
	 * 
	 * @param loginForm クライアント側でloginFormを使えるようにする空クラス
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return ログイン画面のJSPファイル名
	 */
	@RequestMapping(value = "/login")
	public String initLogin(LoginForm loginForm, Model model) {

		model.addAttribute("loginForm", new LoginForm());

		return "login";
	}

	/**
	 * ログイン画面で入力されたパスワードの整合性を判定するメソッド
	 * 
	 * @param aa ログイン画面の入力値を保存するform
	 * @param result 入力値のバリデーション結果
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return ログイン画面のJSPファイル名 or 勤務時間選択画面のJSPファイル名
	 */
	@RequestMapping(value = "/loginProcess")
	public String loginProcess(HttpSession session, @ModelAttribute("loginForm") @Valid LoginForm aa,
			BindingResult result, Model model) {

		// ヴァリデーションチェック不正がある場合
		// result.hasErrors()の意味はエラーがある場合にtrueをreturnするメソッド
		if (result.hasErrors()) {

			return "login";
		}

		// ログイン画面で入力されたパスワード
		String password = aa.getPassword();

		// /**
		// * 本来最後に定義した「あいうえお」が画面に表示されるのが正しい考え方だが
		// * MVCモデルのセッションは画面ができた後にアトリビュートされる
		// * HttpSessionのほうは画面に描画される前にアトリビュートされる
		// * この違いがある。
		// */
		// // @SessionAttributes("password")こっちはMVCモデルのセッションを作っている
		// model.addAttribute("password", password);
		// // こっちはHttpSessionのオブジェクトを使ってセッションを作っている
		// session.setAttribute("password", "あいうえお");

		// 入力されたパスワードからメンバー情報を取得する
		Member member = memberService.getMemberByPassword(password);

		// 出社時間・退社時間を生成する
		List<String> worktimeList = memberService.makeWorktimeList();

		// パスワードが正しい場合、勤務時間選択画面に遷移する
		if (member != null) {

			// コロン区切りのデフォルトの始業時間をセットする
			member = memberService.setStartTimeIntoColon(member);

			// コロン区切りのデフォルトの終業時間をセットする
			member = memberService.setEndTimeIntoColon(member);

			// 勤務時間選択画面でjspにformを使えるようにするために（インポートのような感覚で）attributeする。
			model.addAttribute("worktimeChoiceForm", new WorktimeChoiceForm());

			// ☆★ もともとモデルアトリビュートしていたが、セッションのオブジェクトに入れたので片方アトリビュートしておけばおOK
			// // 勤務時間選択画面にmemberオブジェクトをマッピングして渡す
			// model.addAttribute("member", member);

			// セッションオブジェクトにログイン情報を詰める
			session.setAttribute("member", member);

			// 勤務時間選択画面に出社/退社時間をマッピングして渡す
			model.addAttribute("worktimeList", worktimeList);

			return "worktime_choice";
		}
		// パスワードが間違っている場合、ログイン画面に遷移する
		else {

			// パスワードに一致するメンバーのデータが取得できませんでした。
			// これがヴァリデーションではく、DBに情報がない場合のサーバーサイドでのエラーメッセージの出し方。
			model.addAttribute("message", "パスワードに一致するメンバー情報がありません。");
			return "login";
		}
	}

	/**
	 * ログイン情報がある状態で、ログイン画面に直接URLをたたいた場合、セッションのログイン情報で登録画面に直接移動するメソッド
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/moveWorktimeChoice")
	public String moveWorktimeChoice(HttpSession session, Model model) {

		// 出社時間・退社時間を生成する
		List<String> worktimeList = memberService.makeWorktimeList();

		// 勤務時間選択画面でjspにformを使えるようにするために（インポートのような感覚で）attributeする。
		model.addAttribute("worktimeChoiceForm", new WorktimeChoiceForm());

		// ☆★ もともとモデルアトリビュートしていたが、セッションのオブジェクトに入れたので片方アトリビュートしておけばおOK
		// // 勤務時間選択画面にmemberオブジェクトをマッピングして渡す
		// model.addAttribute("member", member);

		// // セッションオブジェクトにログイン情報を詰める
		// session.setAttribute("member", member);

		// 勤務時間選択画面に出社/退社時間をマッピングして渡す
		model.addAttribute("worktimeList", worktimeList);

		return "worktime_choice";
	}

	/**
	 * 勤務時間登録画面を作成するメソッド
	 * 
	 * @param worktimeChoiceForm 勤務時間選択画面で入力されてた値
	 * @param result バリデーションチェック結果
	 * @param model model
	 * @return 勤務時間登録画面.jsp
	 */
	@RequestMapping(value = "/regist")
	public String regist(@ModelAttribute @Valid WorktimeChoiceForm worktimeChoiceForm, BindingResult result,
			Model model) {

		// ヴァリデーションチェック不正がある場合
		// result.hasErrors()の意味はエラーがある場合にtrueをreturnするメソッド
		if (result.hasErrors()) {
			return "worktime_choice";
		}

		// システム日付を取得するためのカレンダー
		Calendar todateCalendar = Calendar.getInstance();

		// 勤務時間選択画面で先月を選択された場合
		if ("0".equals(worktimeChoiceForm.getMonth())) {
			// 先月を取得
			todateCalendar.set(Calendar.MONTH, todateCalendar.get(Calendar.MONTH) - 1);
		}

		// DBの年月フォーマットを生成する。
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

		// 勤務時間管理Listを取得する
		List<Worktime> worktimeListByMemberId = memberService.getWorktimeByMemberId(
				Integer.parseInt(worktimeChoiceForm.getMemberId()), sdf.format(todateCalendar.getTime()) + "%");


		// 勤務時間登録画面の画面描画するためのオブジェクトを生成する
		List<Worktime> wtList = memberService.makeWorktimeRegstObj(todateCalendar, worktimeListByMemberId,
				worktimeChoiceForm.getStartTime(), worktimeChoiceForm.getEndTime());


		// 出社時間・退社時間を生成する
		List<String> worktimeList = memberService.makeWorktimeList();

		// 勤務時間登録画面でjspにformを使えるようにするために（インポートのような感覚で）attributeする。
		model.addAttribute("worktimeRegistForm", new WorktimeRegistForm());

		// 勤務時間選択画面に年をマッピングして渡す
		model.addAttribute("year", todateCalendar.get(Calendar.YEAR));

		// 勤務時間選択画面に月をマッピングして渡す
		model.addAttribute("month", todateCalendar.get(Calendar.MONTH) + 1);

		// 勤務時間選択画面にwtListをマッピングして渡す
		model.addAttribute("wtList", wtList);

		// 勤務時間選択画面に出社/退社時間をマッピングして渡す
		model.addAttribute("worktimeList", worktimeList);

		// 勤務時間選択画面にworktimeChoiceFormをマッピングして渡す
		model.addAttribute("worktimeChoiceForm", worktimeChoiceForm);

		// 勤務時間選択画面にメンバーIDをマッピングして渡す
		model.addAttribute("memberId", worktimeChoiceForm.getMemberId());

		return "worktime_regist";
	}

	// /**
	// */
	// @RequestMapping(value = "/regist")
	// public String regist(HttpSession session, @ModelAttribute @Valid WorktimeChoiceForm
	// worktimeChoiceForm,
	// BindingResult result, Model model) {
	//
	// // ヴァリデーションチェック不正がある場合
	// // result.hasErrors()の意味はエラーがある場合にtrueをreturnするメソッド
	// if (result.hasErrors()) {
	// return "worktime_choice";
	// }
	//
	// // システム日付を取得するためのカレンダー
	// Calendar todateCalendar = Calendar.getInstance();
	//
	// // 勤務時間選択画面で先月を選択された場合
	// if ("0".equals(worktimeChoiceForm.getMonth())) {
	// // 先月を取得
	// todateCalendar.set(Calendar.MONTH, todateCalendar.get(Calendar.MONTH) - 1);
	// }
	//
	// // 日数を取得
	// int days = todateCalendar.getActualMaximum(Calendar.DATE);
	//
	// // 本日を取得
	// int today = todateCalendar.get(Calendar.DATE);
	//
	// // 月初日を取得するためのカレンダー
	// Calendar firstdateCalendar = Calendar.getInstance();
	// firstdateCalendar.set(Calendar.DATE, 1);
	//
	// // 月末日を取得するためのカレンダー
	// Calendar lastdateCalendar = Calendar.getInstance();
	// lastdateCalendar.set(Calendar.DATE, days);
	//
	// // 曜日を取得
	// int week = firstdateCalendar.get(Calendar.DAY_OF_WEEK);
	//
	// // 日Listを作る
	// //List<Integer> dayList = new ArrayList<Integer>();
	//
	// // 特定したmember情報のメンバーID
	// // セッションから取得するようにしたので不要 String memberId = worktimeChoiceForm.getMemberId();
	// Member member = (Member) session.getAttribute("member");
	// Integer memberId = member.getId();
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	//
	// // 勤務時間管理Listを取得する
	// List<Worktime> worktimeListByMemberId = memberService.getWorktimeByMemberId(memberId,
	// sdf.format(todateCalendar.getTime()) + "%");
	//
	// // 勤務時間管理TBLのオブジェクトを作成
	// List<Worktime> wtList = new ArrayList<Worktime>();
	// // 選択月の日数分処理を繰り返す
	// for (int i = 0; i < days; i++) {
	//
	// // 月初日からDBから取得したListのSizeまで処理をする
	// if (i < worktimeListByMemberId.size()) {
	// Integer intWorkDate = Integer.parseInt(worktimeListByMemberId.get(i).getWorkDate().substring(6));
	// worktimeListByMemberId.get(i).setWorkDate(Integer.toString(intWorkDate));
	//
	// // 曜日インターバルを作成
	// worktimeListByMemberId.get(i).setWeek((worktimeListByMemberId.get(i).getWeek()) % 7);
	//
	// // 始業時間
	// String startTime = worktimeListByMemberId.get(i).getStartTime();
	//
	// if (!"".equals(startTime)) {
	// // 始業時間をコロン区切りにする
	// String startTimeWithColon = startTime.substring(0, 2) + ":"
	// + startTime.substring(2, startTime.length());
	// // 始業時間（コロン区切り）をセットする
	// worktimeListByMemberId.get(i).setStartTime(startTimeWithColon);
	// }
	//
	// // デフォルトの終業時間
	// String endTime = worktimeListByMemberId.get(i).getEndTime();
	// if (!"".equals(endTime)) {
	// // デフォルトの終業時間をコロン区切りにする
	// String endTimeWithColon = endTime.substring(0, 2) + ":"
	// + endTime.substring(2, endTime.length());
	// // デフォルトの終業時間（コロン区切り）をセットする
	// worktimeListByMemberId.get(i).setEndTime(endTimeWithColon);
	// }
	//
	// wtList.add(worktimeListByMemberId.get(i));
	// }
	// // 本日以降
	// else {
	//
	// // 勤務時間管理TBLのオブジェクトに一覧情報を詰める
	// Worktime wt = new Worktime();
	//
	// // 勤務日付を作成
	// wt.setWorkDate(Integer.toString(i + 1));
	// // 曜日インターバルを作成
	// wt.setWeek((week + i) % 7);
	//
	// // DBから取得したListのSizeから今日まで(週末は除く）
	// if (i < today && (wt.getWeek() != 0 && wt.getWeek() != 1)) {
	// wt.setStartTime(worktimeChoiceForm.getStartTime());
	// wt.setEndTime(worktimeChoiceForm.getEndTime());
	// }
	// wtList.add(wt);
	// }
	// }
	//
	// // 出社時間・退社時間を生成する
	// List<String> worktimeList = memberService.makeWorktimeList();
	//
	// // 勤務時間登録画面でjspにformを使えるようにするために（インポートのような感覚で）attributeする。
	// model.addAttribute("worktimeRegistForm", new WorktimeRegistForm());
	//
	// // 勤務時間選択画面に年をマッピングして渡す
	// model.addAttribute("year", todateCalendar.get(Calendar.YEAR));
	//
	// // 勤務時間選択画面に月をマッピングして渡す
	// model.addAttribute("month", todateCalendar.get(Calendar.MONTH) + 1);
	//
	// // 勤務時間選択画面にwtListをマッピングして渡す
	// model.addAttribute("wtList", wtList);
	//
	// // 勤務時間選択画面に出社/退社時間をマッピングして渡す
	// model.addAttribute("worktimeList", worktimeList);
	//
	// // 勤務時間選択画面にworktimeChoiceFormをマッピングして渡す
	// model.addAttribute("worktimeChoiceForm", worktimeChoiceForm);
	//
	// // ★☆★ セッションにユーザ情報を詰めているので、不要になった。
	// // 勤務時間選択画面にメンバーIDをマッピングして渡す
	// // model.addAttribute("memberId", memberId);
	//
	// return "worktime_regist";
	// }

	/**
	 * 勤務時間登録画面で入力された一覧情報を使って、勤務時間管理TBLを更新/登録を行うメソッド
	 * 
	 * @param worktimeRegistForm 勤務管理登録画面で入力された一覧情報form
	 * @param result 入力値のバリデーション結果
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return 勤務時間選択画面
	 */
	@RequestMapping(value = "/registProcess")
	public String registProcess(HttpSession session, @ModelAttribute WorktimeRegistForm worktimeRegistForm,
			BindingResult result, Model model) {

		// 勤務時間登録画面で入力された値にエラーがある場合に、画面にエラーメッセージを表示する
		if (!memberService.checkInputValueWorktimeRegist(worktimeRegistForm)) {
			// エラーメッセージをを表示する
			model.addAttribute("message", "出社時間は退社時間以前を入力してください。");
			return "regist";

		}

		// DBを更新か登録する
		memberService.updateOrInsertWorktime(worktimeRegistForm);

		// 出社時間・退社時間を生成する
		List<String> worktimeList = memberService.makeWorktimeList();

		// 勤務時間選択画面でjspにformを使えるようにするために（インポートのような感覚で）attributeする。
		model.addAttribute("worktimeChoiceForm", new WorktimeChoiceForm());

		// 勤務時間選択画面にmemberオブジェクトをマッピングして渡す
		model.addAttribute("member", worktimeRegistForm.getMemberId());

		// 勤務時間選択画面に出社/退社時間をマッピングして渡す
		model.addAttribute("worktimeList", worktimeList);

		return "worktime_choice";

	}

	/**
	 * // * 勤務時間登録画面で入力された勤務管理情報の整合性を判定するメソッド // * @param aa 勤務時間登録画面の入力値を保存するform // * @param result
	 * 入力値のバリデーション結果 // * @param model ControllerからViewに値を受け渡すためのパラメータ // * @return 勤務時間登録画面 or
	 * 完了画面のJSPファイル名 //
	 */
	// @RequestMapping(value = "/registProcess")
	// public String registProcess(HttpSession session, @ModelAttribute WorktimeRegistForm
	// worktimeRegistForm,
	// BindingResult result,
	// Model model) {
	//
	// // 勤務時間登録画面で入力された値にエラーがある場合に、画面にエラーメッセージを表示する
	// if (!memberService.checkInputValueWorktimeRegist(worktimeRegistForm)) {
	// // エラーメッセージをを表示する
	// model.addAttribute("message", "出社時間は退社時間以前を入力してください。");
	// return "regist";
	//
	// }
	//
	// Member member = (Member) session.getAttribute("member");
	//
	// // DBを更新か登録する
	// memberService.updateOrInsertWorktime(worktimeRegistForm, member);
	//
	// // // メンバーのIDを取得
	// // String memberId = worktimeRegistForm.getMemberId();
	// // // 入力されたパスワードからメンバー情報を取得する
	// // Member member = memberService.getMemberByMemberId(Integer.parseInt(memberId));
	//
	// // セッションから取得するようにしたので、不要
	// // LoginForm loginForm = new LoginForm();
	// // // ログイン画面で入力されたパスワード
	// // String password = loginForm.getPassword();
	// // // 入力されたパスワードからメンバー情報を取得する
	// // Member member = memberService.getMemberByPassword(password);
	//
	// // 出社時間・退社時間を生成する
	// List<String> worktimeList = memberService.makeWorktimeList();
	//
	// //****************** memberにまた「：」を追加していることになる。
	// // // デフォルトの始業時間
	// // String dfStartTime = member.getDfStartTime();
	// //
	// // // デフォルトの始業時間をコロン区切りにする
	// // String dfStartTimeWithColon = dfStartTime.substring(0, 2) + ":"
	// // + dfStartTime.substring(2, dfStartTime.length());
	// //
	// // // デフォルトの始業時間（コロン区切り）をセットする
	// // member.setDfStartTime(dfStartTimeWithColon);
	// //
	// // // デフォルトの終業時間
	// // String dfEndTime = member.getDfEndTime();
	// //
	// // // デフォルトの終業時間をコロン区切りにする
	// // String dfEndTimeWithColon = dfEndTime.substring(0, 2) + ":" + dfEndTime.substring(2,
	// dfEndTime.length());
	// //
	// // // デフォルトの終業時間（コロン区切り）をセットする
	// // member.setDfEndTime(dfEndTimeWithColon);
	// //********************************************
	//
	// // 勤務時間選択画面でjspにformを使えるようにするために（インポートのような感覚で）attributeする。
	// model.addAttribute("worktimeChoiceForm", new WorktimeChoiceForm());
	//
	// // セッションにユーザ情報を詰めたので不要になった。
	// // 勤務時間選択画面にmemberオブジェクトをマッピングして渡す
	// // model.addAttribute("member", member);
	//
	// // 勤務時間選択画面に出社/退社時間をマッピングして渡す
	// model.addAttribute("worktimeList", worktimeList);
	//
	// return "worktime_choice";
	//
	// }
}
