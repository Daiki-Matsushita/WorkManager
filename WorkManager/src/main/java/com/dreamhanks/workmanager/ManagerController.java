package com.dreamhanks.workmanager;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamhanks.dto.Member;
import com.dreamhanks.dto.Worktime;
import com.dreamhanks.dto.WorktimeSearch;
import com.dreamhanks.form.LoginFormForManager;
import com.dreamhanks.form.WorktimeConfirmForm;
import com.dreamhanks.form.WorktimeSearchForm;
import com.dreamhanks.service.MemberService;

/**
 * 管理者に対するコントローラクラス
 */
@RequestMapping(value = "/manager")
@Controller
public class ManagerController {

	@Autowired
	private MemberService memberService;

	/**
	 * ログイン画面を開くためのメソッド(管理者用）
	 * @param loginFormForManager クライアント側でloginFormを使えるようにする空クラス（管理者用）
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return  ログイン画面のJSPファイル名
	 */
	@RequestMapping(value = "/login_manager")
	public String initLoginForManager(LoginFormForManager loginFormForManager, Model model) {

		model.addAttribute("loginFormForManager", new LoginFormForManager());

		return "login_manager";
	}

	/**
	 * ログイン画面で入力されたパスワードの整合性を判定するメソッド（管理者用）
	 * @param loginFormForManager ログイン画面の入力値を保存するform（管理者用）
	 * @param result 入力値のバリデーション結果
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return ログイン画面のJSPファイル名 or 勤務時間検索画面のJSPファイル名
	 */
	@RequestMapping(value = "/loginProcess_manager")
	public String loginProcessForManager(HttpSession session, @ModelAttribute @Valid LoginFormForManager loginFormForManager, BindingResult result, Model model) {

		// ヴァリデーションチェック不正がある場合
		// result.hasErrors()の意味はエラーがある場合にtrueをreturnするメソッド
		if (result.hasErrors()) {

			return "login_manager";
		}

		// ログイン画面で入力されたパスワード
		String password = loginFormForManager.getPassword();

		// 入力されたパスワードからメンバー情報を取得する
		Member manager = memberService.getMemberByPassword(password);

		// 勤務時間検索画面で選択可能年を取得する
		List<String> searchYearList = memberService.makeSearchYearList();

		// 勤務時間検索画面で選択可能月を取得する
		List<String> searchMonthList = memberService.makeSearchMonthList();

		// 勤務管理情報から氏名のリストを取得する
		List<String> memberNameList = memberService.makeSearchNameList();

		// パスワードが正しい場合、勤務時間選択画面に遷移する
		if (manager != null) {

			// 勤務時間検索画面でjspにformを使えるようにするために（インポートのような感覚で）attributeする。
			model.addAttribute("worktimeSearchForm", new WorktimeSearchForm());

			// 選択可能年数をアトリビュートする
			model.addAttribute("searchYearList", searchYearList);

			// 選択可能年月をアトリビュートする
			model.addAttribute("searchMonthList", searchMonthList);

			// 選択可能氏名をアトリビュートする　
			//⇒★メンバーテーブル全てのレコードをアトリビュートで渡して、JSPでforearchを使って、回してオプションタグを作ってもよかったかも
			model.addAttribute("memberNameList", memberNameList);

			// セッションオブジェクトにログイン情報を詰める
			session.setAttribute("manager", manager);

			// 勤務時間検索画面に遷移する
			return "worktime_search";
		}
		// パスワードが間違っている場合、ログイン画面に遷移する
		else {

			//パスワードに一致するメンバーのデータが取得できませんでした。
			// これがヴァリデーションではく、DBに情報がない場合のサーバーサイドでのエラーメッセージの出し方。
			model.addAttribute("message", "パスワードに一致するメンバー情報がありません。");

			// ログイン画面（管理者用）に差し戻す
			return "login_manager";
		}
	}

	//	/** ⇒ forEachで一覧を作成するために使う。
	//   *********
	//	 * 各メンバーごとの勤務時間を検索するメソッド
	//	 * @param loginFormForManager クライアント側でloginFormを使えるようにする空クラス（管理者用）
	//	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	//	 * @return  ログイン画面のJSPファイル名
	//	 */
	//	@RequestMapping(value = "/search")
	//	public String search(@ModelAttribute WorktimeSearchForm worktimeSearchForm, Model model) {
	//
	//		// 画面の入力値をもとに、勤務時間検索結果を取得する
	//		List<WorktimeSearch> worktimeSearchResult = memberService
	//				.worktimeSearch(worktimeSearchForm.getYear(),worktimeSearchForm.getMonth(),worktimeSearchForm.getName());
	//
	//
	//
	//
	//		model.addAttribute("worktimeSearchResult", worktimeSearchResult);
	//
	//
	//		model.addAttribute("loginFormForManager", new LoginFormForManager());
	//
	//		return "worktime_search";
	//	}

	/**
	 * 各メンバーごとの勤務時間を検索するメソッド(ajax用)
	 * @param loginFormForManager クライアント側でloginFormを使えるようにする空クラス（管理者用）
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return  ログイン画面のJSPファイル名
	 */
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<WorktimeSearch> search(HttpSession session, @RequestBody Map<String, Object> reqParam) {

		String year = (String) reqParam.get("year");

		String month = "";
		// 取得した月数が入力されている場合、２桁で０埋めにフォーマットする。
		if((String) reqParam.get("month") != null && !"".equals((String) reqParam.get("month"))) {
			month = String.format("%02d", Integer.parseInt((String) reqParam.get("month")));
		}
		String name = (String) reqParam.get("name");

		// 画面の入力値をもとに、勤務時間検索結果を取得する
		List<WorktimeSearch> worktimeSearchResult = memberService.worktimeSearch(year, month, name);

		return worktimeSearchResult;
	}

	/**
	 * クリックされた年月のメンバーに対する勤務管理情報を取得する
	 * @param worktimeSearchForm 選択された行の情報（管理者用）
	 * @param model ControllerからViewに値を受け渡すためのパラメータ
	 * @return  勤務時間確認.jsp
	 */
	@RequestMapping(value = "/confirm")
	public String confirm(HttpSession session, @ModelAttribute WorktimeSearchForm worktimeSearchForm, Model model) {

		// 勤務時間管理Listを取得する
		List<Worktime> worktimeListByMemberId = memberService.getWorktimeByMemberId(Integer.parseInt(worktimeSearchForm.getMemberId()),
				worktimeSearchForm.getYear() + worktimeSearchForm.getMonth() + "%");

		// カレンダー
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(worktimeSearchForm.getYear()));
		calendar.set(Calendar.MONTH, Integer.parseInt(worktimeSearchForm.getMonth()) -1);


		// 勤務時間確認画面の画面描画するためのオブジェクトを生成する
		List<Worktime> wtList = memberService.makeWorktimeRegstObj(calendar, worktimeListByMemberId, "", "");

		// 年をアトリビュート
		model.addAttribute("year", worktimeSearchForm.getYear());

		// 月をアトリビュート
		model.addAttribute("month", worktimeSearchForm.getMonth());

		// 氏名をアトリビュート
		model.addAttribute("name", worktimeSearchForm.getName());

		// 勤務時間選択画面にwtListをマッピングして渡す
		model.addAttribute("wtList", wtList);

		// WorktimeConfirmFormをアトリビュート（画面で使えるようにインポートする）
		model.addAttribute("worktimeConfirmForm", new WorktimeConfirmForm());

		return "worktime_confirm";
	}

	/**
	 * 勤務時間確認画面のデータをCSV出力するメソッド
	 * @param worktimeConfirmForm 勤務時間確認画面のデータ
	 * @throws IOException
	 */
	@RequestMapping(value = "/downloead")
	public void downloead(HttpSession session, @ModelAttribute WorktimeConfirmForm worktimeConfirmForm, HttpServletResponse response) throws IOException {

		// ワークブックを作成
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("勤務時間");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// テーブルヘッダのスタイル
		CellStyle headStyle = wb.createCellStyle();

		// ヘッダー境界線設定
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);

		// ヘッダー背景色は黄色です。
		headStyle.setFillBackgroundColor(HSSFColorPredefined.SKY_BLUE.getIndex());
		//headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// ヘッダーのデータは中央に配置します。
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// ボディー用境界スタイルの境界線のみを指定
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		// ヘッダ生成
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("日");

		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("曜日");

		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("出社時間");

		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("退社時間");

		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("休み時間");

		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("備考");

		List<WorktimeConfirmForm> displayList = worktimeConfirmForm.getWorktimeConfirmForm();

		String[] weekArry = "日,月,火,水,木,金,土".split(",");

		// データ部分の作成
		for(WorktimeConfirmForm display : displayList) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(display.getDay());

			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);


			int weekNUm = Integer.parseInt(display.getWeek());

			String week = null;

			if (weekNUm==0) {
				week = weekArry[6];
			} else if (weekNUm==1) {
				week = weekArry[weekNUm-1];
			} else {
				week = weekArry[weekNUm-1];
			}



			cell.setCellValue(week);

			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(display.getStartTime());

			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(display.getEndTime());

			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(display.getRestTime());

			cell = row.createCell(5);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(display.getMemo());
		}

		// コンテンツタイプとファイル名を指定
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment; filename = test.xls");

		// エクセル出力
		wb.write(response.getOutputStream());
		wb.close();

//		String [][]tweDimTableDate = memberService.convertTwoDimentionalArray("");

	}
}
