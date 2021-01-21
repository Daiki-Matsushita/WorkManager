package com.dreamhanks.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamhanks.dao.MemberMapper;
import com.dreamhanks.dao.WorktimeMapper;
import com.dreamhanks.dao.WorktimeSearchMapper;
import com.dreamhanks.dto.Member;
import com.dreamhanks.dto.MemberExample;
import com.dreamhanks.dto.Worktime;
import com.dreamhanks.dto.WorktimeExample;
import com.dreamhanks.dto.WorktimeSearch;
import com.dreamhanks.form.WorktimeRegistForm;

/**
 * メンバーに対するサービスクラス
 */
@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private WorktimeMapper worktimeMapper;

	@Autowired
	private WorktimeSearchMapper worktimeSearchMapper;

	/**
	 * ログイン画面で入力されたパスワードでメンバーのオブジェクトを取得する
	 * @param password ログイン画面で入力されたパスワード
	 * @return メンバーのオブジェクト
	 */
	public Member getMemberByPassword(String password) {

		MemberExample memberExample = new MemberExample();

		memberExample.createCriteria().andPasswordEqualTo(password);

		List<Member> memberList = memberMapper.selectByExample(memberExample);

		if (memberList.isEmpty()) {
			return null;
		} else {
			return memberList.get(0);
		}
	}

	/**
	 * メンバーのIDでメンバーのオブジェクトを取得する
	 * @param password ログイン画面で入力されたパスワード
	 * @return メンバーのオブジェクト
	 */
	public Member getMemberByMemberId(Integer memberId) {

		MemberExample memberExample = new MemberExample();

		memberExample.createCriteria().andIdEqualTo(memberId);
		List<Member> memberList = memberMapper.selectByExample(memberExample);

		if (memberList.isEmpty()) {
			return null;
		} else {
			return memberList.get(0);
		}
	}

	/**
	 * 00:00～23:30のStringのリストを生成するメソッド
	 *
	 */
	public List<String> makeWorktimeList() {

		// 勤務時間のリスト
		List<String> worktimeList = new ArrayList<String>();

		// 00:00 23:30

		int i = 0;
		int j = 0;

		String worktime = null;

		for (i = 0; i <= 23; i++) {

			//
			String hour = Integer.toString(i);

			if (i < 10) {
				hour = "0" + hour;
			}

			for (j = 0; j <= 1; j++) {
				if (j == 0) {
					// 00分
					worktime = hour + ":" + "00";

				} else {
					// 30分
					worktime = hour + ":" + "30";

				}

				worktimeList.add(worktime);
			}
		}
		return worktimeList;
	}

	/**
	 * メンバー管理IDで勤務時間管理のオブジェクトを取得する
	 * @param memberId メンバー管理ID
	 * @param targetDate 対象の年月
	 * @return 勤務時間管理のオブジェクトList
	 */
	public List<Worktime> getWorktimeByMemberId(Integer memberId, String targetDate) {

		WorktimeExample worktimeExample = new WorktimeExample();

		worktimeExample.createCriteria().andMemberIdEqualTo(memberId).andWorkDateLike(targetDate);
		List<Worktime> worktimeList = worktimeMapper.selectByExampleWithBLOBs(worktimeExample);

		return worktimeList;

	}

	/**
	 * 勤務時間登録画面の画面描画するためのオブジェクトを生成するメソッド
	 * @param todateCalendar カレンダーオブジェクト（先月or今月）
	 * @param worktimeListByMemberId 入力ユーザの勤務時間管理情報List
	 * @param inputedStartTime 選択画面で入力された開始時間
	 * @param inputedEndTime 選択画面で入力された終了時間
	 * @return 勤務時間登録画面の画面描画するためのオブジェクト
	 */
	public List<Worktime> makeWorktimeRegstObj(Calendar todateCalendar, List<Worktime> worktimeListByMemberId, String inputedStartTime, String inputedEndTime) {

		// 日数を取得
		int days = todateCalendar.getActualMaximum(Calendar.DATE);

		// 本日を取得
		int today = todateCalendar.get(Calendar.DATE);

		// 月初日を取得するためのカレンダー
		Calendar firstdateCalendar = Calendar.getInstance();
		firstdateCalendar.set(Calendar.YEAR, todateCalendar.get(Calendar.YEAR));
		firstdateCalendar.set(Calendar.MONTH, todateCalendar.get(Calendar.MONTH));
		firstdateCalendar.set(Calendar.DATE, 1);

		// 曜日を取得
		int week = firstdateCalendar.get(Calendar.DAY_OF_WEEK);


		// 勤務時間管理TBLのオブジェクトを作成
		List<Worktime> wtList = new ArrayList<Worktime>();
		// 選択月の日数分処理を繰り返す
		for (int i = 0; i < days; i++) {

			// 月初日からDBから取得したListのSizeまで処理をする
			if (i < worktimeListByMemberId.size()) {
				Integer intWorkDate = Integer.parseInt(worktimeListByMemberId.get(i).getWorkDate().substring(6));
				worktimeListByMemberId.get(i).setWorkDate(Integer.toString(intWorkDate));

				// 曜日インターバルを作成
				worktimeListByMemberId.get(i).setWeek((worktimeListByMemberId.get(i).getWeek()) % 7);

				// 始業時間
				String startTime = worktimeListByMemberId.get(i).getStartTime();

				if (!"".equals(startTime)) {
					// 始業時間をコロン区切りにする
					String startTimeWithColon = startTime.substring(0, 2) + ":"
							+ startTime.substring(2, startTime.length());
					// 始業時間（コロン区切り）をセットする
					worktimeListByMemberId.get(i).setStartTime(startTimeWithColon);
				}

				// デフォルトの終業時間
				String endTime = worktimeListByMemberId.get(i).getEndTime();
				if (!"".equals(endTime)) {
					// デフォルトの終業時間をコロン区切りにする
					String endTimeWithColon = endTime.substring(0, 2) + ":"
							+ endTime.substring(2, endTime.length());
					// デフォルトの終業時間（コロン区切り）をセットする
					worktimeListByMemberId.get(i).setEndTime(endTimeWithColon);
				}

				wtList.add(worktimeListByMemberId.get(i));
			}
			// 本日以降
			else {

				// 勤務時間管理TBLのオブジェクトに一覧情報を詰める
				Worktime wt = new Worktime();

				// 勤務日付を作成
				wt.setWorkDate(Integer.toString(i + 1));
				// 曜日インターバルを作成
				wt.setWeek((week + i) % 7);

				// DBから取得したListのSizeから今日まで(週末は除く）
				if (i < today && (wt.getWeek() != 0 && wt.getWeek() != 1)) {
					wt.setStartTime(inputedStartTime);
					wt.setEndTime(inputedEndTime);
				}
				wtList.add(wt);
			}
		}
		return wtList;

	}

	/**
	 * コロン区切りのデフォルトの始業時間をセットする
	 * @param member メンバーオブジェクト
	 * @return コロン区切りのデフォルトの始業時間をセットされたメンバーオブジェクト
	 */
	public Member setStartTimeIntoColon(Member member) {

		// デフォルトの始業時間
		String dfStartTime = member.getDfStartTime();

		// デフォルトの始業時間をコロン区切りにする
		String dfStartTimeWithColon = dfStartTime.substring(0, 2) + ":"
				+ dfStartTime.substring(2, dfStartTime.length());

		// デフォルトの始業時間（コロン区切り）をセットする
		member.setDfStartTime(dfStartTimeWithColon);

		return member;

	}

	/**
	 * コロン区切りのデフォルトの終業時間をセットする
	 * @param member メンバーオブジェクト
	 * @return コロン区切りのデフォルトの終業時間をセットされたメンバーオブジェクト
	 */
	public Member setEndTimeIntoColon(Member member) {

		// デフォルトの終業時間
		String dfEndTime = member.getDfEndTime();

		// デフォルトの終業時間をコロン区切りにする
		String dfEndTimeWithColon = dfEndTime.substring(0, 2) + ":" + dfEndTime.substring(2, dfEndTime.length());

		// デフォルトの終業時間（コロン区切り）をセットする
		member.setDfEndTime(dfEndTimeWithColon);

		return member;

	}

	/**
	 * 勤務時間登録画面で入力された出社時間が退社時間より大きい場合、画面にエラーメッセージを出力する
	 * @param worktimeRegistForm 勤務時間登録画面で入力された値
	 * @return true:エラーなし、false:エラーあり
	 */
	public boolean checkInputValueWorktimeRegist(WorktimeRegistForm worktimeRegistForm) {

		// 画面から取得してきた勤務時間List分処理を行う
		for (WorktimeRegistForm record : worktimeRegistForm.getWorktimeRegistFormList()) {

			// 勤務時間の相関チェック
			if (record.getStartTime() != null && record.getEndTime() != null
					&& record.getEndTime().compareTo(record.getStartTime()) == -1) {

				return false;
			}

		}

		//		// 勤務時間登録画面で入力された値を,slpitし、配列の変数に詰めなおす
		//		String[] startTimeArray = worktimeRegistForm.getStartTime().split(",");
		//		String[] endTimeArray = worktimeRegistForm.getEndTime().split(",");
		//
		//		for (int i = 0; i < startTimeArray.length; i++) {
		//			// 勤務時間の相関チェック
		//			if (startTimeArray[i] != null && endTimeArray[i] != null
		//					&& endTimeArray[i].compareTo(startTimeArray[i]) == -1) {
		//
		//				return false;
		//			}
		//		}

		return true;
	}

//	/**
//	 *
//	 * @param worktimeRegistForm
//	 */
//	public void updateOrInsertWorktime(WorktimeRegistForm worktimeRegistForm, Member member) {
//
//		// 特定したmember情報のメンバーID
//		//		String memberId = worktimeRegistForm.getMemberId();
//		Integer memberId = member.getId();
//
//		// 選択月の勤務時間管理Listを取得する
//		List<Worktime> worktimeListByMemberId = getWorktimeByMemberId(memberId,
//				worktimeRegistForm.getYear() + String.format("%02d", Integer.parseInt(worktimeRegistForm.getMonth()))
//						+ "%");
//
//		// システム日付（今月）を取得するためのカレンダー
//		// 例えば今の日付が「20201024]ならば⇒「2020 9 24」という風になる
//		Calendar todateCalendar = Calendar.getInstance();
//
//		// 本日を取得
//		int today = todateCalendar.get(Calendar.DATE);
//
//		// 勤務時間選択画面で先月を選択された場合
//		// MONTHに関しては最初の値が０開始なので、先月かどうかを比べるとき-1をしなくてOK
//		if (Integer.toString(todateCalendar.get(Calendar.MONTH)).equals(worktimeRegistForm.getMonth())) {
//			// 先月を取得
//			todateCalendar.set(Calendar.MONTH, todateCalendar.get(Calendar.MONTH) - 1);
//			// 先月の月末日に設定する
//			today = todateCalendar.getActualMaximum(Calendar.DATE);
//		}
//
//		// 今月の月初日を取得するためのカレンダー
//		Calendar firstdateCalendar = Calendar.getInstance();
//
//		firstdateCalendar.set(Calendar.DATE, 1);
//		// 勤務時間選択画面で先月を選択された場合
//		// MONTHに関しては最初の値が０開始なので、先月かどうかを比べるとき-1をしなくてOK
//		if (Integer.toString(firstdateCalendar.get(Calendar.MONTH)).equals(worktimeRegistForm.getMonth())) {
//			// 先月を取得
//			firstdateCalendar.set(Calendar.MONTH, firstdateCalendar.get(Calendar.MONTH) - 1);
//		}
//		// 選択月の月初日を生成する
//		int firstDate = firstdateCalendar.get(Calendar.DATE);
//		// 先月か今月の月初日の曜日を取得
//		int week = firstdateCalendar.get(Calendar.DAY_OF_WEEK);
//
//		// ★☆★　前のやり方は各カラムの配列を処理の回数分で特定して、その値をDB登録しようとしていた
//		// ★☆★　今回は画面から取得した値をListにしているので、レコード分for文を使って処理するので、その必要がなくなった
//		//		// 今日までの日付で処理を繰り返す
//		//		for(int i = 0; i < today; i++) {
//		//
//		//			// 取得した勤務時間管理がある場合、更新処理
//		//			if(!worktimeListByMemberId.isEmpty()) {
//		//				updateWorktime(worktimeListByMemberId.get(i), worktimeRegistForm, i);
//		//			} // ない場合、登録処理
//		//			else {
//		//				insertWorktime(Integer.parseInt(memberId), workDate, week, worktimeRegistForm, i);
//		//
//		//
//		//			}
//		//		}
//
//		// 更新処理、登録処理の処理カウント
//		int updateLoopCount = 0;
//
//		// 取得した勤務時間管理がある場合、更新処理
//		for (Worktime worktimeByMemberId : worktimeListByMemberId) {
//			// 更新処理
//			updateWorktime(worktimeByMemberId, worktimeRegistForm, updateLoopCount);
//
//			updateLoopCount++;
//			firstDate++;
//			week++;
//		}
//
//		// 残りの日付を月末日までの日付で登録処理を繰り返す
//		for (int insertLoopCount = updateLoopCount; insertLoopCount < today; insertLoopCount++) {
//
//			// 本日の勤務日を生成する
//			String workDate = worktimeRegistForm.getYear()
//					+ String.format("%02d", Integer.parseInt(worktimeRegistForm.getMonth()))
//					+ String.format("%02d", firstDate);
//			int calculatedWeek = (week) % 7;
//
//			insertWorktime(memberId, workDate, calculatedWeek, worktimeRegistForm, insertLoopCount);
//
//			firstDate++;
//			week++;
//		}
//
//		//  ★☆★ このやり方だと一見、更新と登録が少ないコードでシンプルにできるように思えるが
//		//         月初日から月末日までループ、DBから取得できたレコードは更新したいというループ。二つのループをしたいので
//		//         それを無理やりget(i)などを使って、インデックスでやろうとしているから
//		//         nullのチェックや、List自体のチェックをしなくてはいけなくなる。しかし、これがうまくできないでNestedExceptionになる
//		//  ★☆☆ よって、上記のように二つのループをcount変数を使って、インデックスしてあげて分けることにした
//		//
//		//		// 今日までの日付で処理を繰り返す
//		//		for (int i = 0; i < today; i++) {
//		//
//		//			// 本日の勤務日を生成する
//		//			String workDate = worktimeRegistForm.getYear() + String.format("%02d", Integer.parseInt(worktimeRegistForm.getMonth()))
//		//					+ String.format("%02d", firstDate);
//		//			int calculatedWeek = (week) % 7;
//		//
//		//			// 取得した勤務時間管理がある場合、更新処理
//		//			//      ⇒よりマトリョシカの先の例えばIDまでを見てあげないといけない
//		//			if (!worktimeListByMemberId.isEmpty() && worktimeListByMemberId.get(i).getId() != null) {
//		//				updateWorktime(worktimeListByMemberId.get(i), worktimeRegistForm, i);
//		//			} // ない場合、登録処理
//		//			else {
//		//				insertWorktime(Integer.parseInt(memberId), workDate, calculatedWeek, worktimeRegistForm, i);
//		//
//		//			}
//		//
//		//			firstDate++;
//		//			week++;
//		//		}
//
//	}

	/**
	 * 勤務管理TBLを更新か登録するメソッド
	 * @param worktimeRegistForm 勤務管理登録画面で入力された一覧情報form
	 */
	public void updateOrInsertWorktime(WorktimeRegistForm worktimeRegistForm) {

		// 特定したmember情報のメンバーID
		Integer memberId = Integer.parseInt(worktimeRegistForm.getMemberId());

		// 選択月の勤務時間管理Listを取得する
		List<Worktime> worktimeListByMemberId = getWorktimeByMemberId(memberId,
				worktimeRegistForm.getYear() + String.format("%02d", Integer.parseInt(worktimeRegistForm.getMonth()))
						+ "%");

		// システム日付（今月）を取得するためのカレンダー
		// 例えば今の日付が「20201024]ならば⇒「2020 9 24」という風になる
		Calendar todateCalendar = Calendar.getInstance();

		// 本日を取得
		int today = todateCalendar.get(Calendar.DATE);

		// 勤務時間選択画面で先月を選択された場合
		// MONTHに関しては最初の値が０開始なので、先月かどうかを比べるとき-1をしなくてOK
		if (Integer.toString(todateCalendar.get(Calendar.MONTH)).equals(worktimeRegistForm.getMonth())) {
			// 先月を取得
			todateCalendar.set(Calendar.MONTH, todateCalendar.get(Calendar.MONTH) - 1);
			// 先月の月末日に設定する
			today = todateCalendar.getActualMaximum(Calendar.DATE);
		}

		// 今月の月初日を取得するためのカレンダー
		Calendar firstdateCalendar = Calendar.getInstance();

		firstdateCalendar.set(Calendar.DATE, 1);
		// 勤務時間選択画面で先月を選択された場合
		// MONTHに関しては最初の値が０開始なので、先月かどうかを比べるとき-1をしなくてOK
		if (Integer.toString(firstdateCalendar.get(Calendar.MONTH)).equals(worktimeRegistForm.getMonth())) {
			// 先月を取得
			firstdateCalendar.set(Calendar.MONTH, firstdateCalendar.get(Calendar.MONTH) - 1);
		}
		// 選択月の月初日を生成する
		int firstDate = firstdateCalendar.get(Calendar.DATE);
		// 先月か今月の月初日の曜日を取得
		int week = firstdateCalendar.get(Calendar.DAY_OF_WEEK);

		// 更新処理、登録処理の処理カウント
		int updateLoopCount = 0;

		// 取得した勤務時間管理がある場合、更新処理
		for (Worktime worktimeByMemberId : worktimeListByMemberId) {
			// 更新処理
			updateWorktime(worktimeByMemberId, worktimeRegistForm, updateLoopCount);

			updateLoopCount++;
			firstDate++;
			week++;
		}

		// 残りの日付を月末日までの日付で登録処理を繰り返す
		for (int insertLoopCount = updateLoopCount; insertLoopCount < today; insertLoopCount++) {

			// 本日の勤務日を生成する
			String workDate = worktimeRegistForm.getYear()
					+ String.format("%02d", Integer.parseInt(worktimeRegistForm.getMonth()))
					+ String.format("%02d", firstDate);
			int calculatedWeek = (week) % 7;

			insertWorktime(memberId, workDate, calculatedWeek, worktimeRegistForm, insertLoopCount);

			firstDate++;
			week++;
		}
	}

	//	/**
	//	 * 勤務時間管理TBLを更新する
	//	 * @param worktimeByMemberId 対象のメンバーの選択月のレコード
	//	 * @param worktimeRegistForm 登録画面で入力された内容
	//	 * @param loopCount 処理カウント
	//	 */
	//	public void updateWorktime(Worktime worktimeByMemberId, WorktimeRegistForm worktimeRegistForm,int loopCount) {
	//
	//		// 勤務時間登録画面で入力された値を,slpitし、配列の変数に詰めなおす
	//		String[] startTimeArray = worktimeRegistForm.getStartTime().split(",");
	//		String[] endTimeArray = worktimeRegistForm.getEndTime().split(",");
	//		String[] restTimeArray = worktimeRegistForm.getRestTime().split(",");
	//		String[] memoArray = worktimeRegistForm.getMemo().split(",");

	// ★☆★　この方法だとif(!"".equals(restTimeArray) && restTimeArray[loopCount] != null)などをしなくてはいけなくなる
	// ★☆★　しかも実際にチェックがうまくいかず、BoundsExceptionになったりする
	// ★☆★　なので、画面の入力内容をListで受け取り、二重for文を回すことによって、うまく処理を行うようにした。
	//
	//		//
	//		List<Worktime> updateWorktimeList = new ArrayList<Worktime>();
	//
	//			// Worktimeオブジェクトを生成して、更新内容を追加する
	//			Worktime updateWorktime = new Worktime();
	//
	//			// updateするときは主キーは使えない、後で消す
	////			updateWorktime.setId(worktimeByMemberId.getId());
	//			updateWorktime.setMemberId(worktimeByMemberId.getMemberId());
	//			updateWorktime.setWorkDate(worktimeByMemberId.getWorkDate());
	//			updateWorktime.setWeek(worktimeByMemberId.getWeek());
	//			if(!"".equals(startTimeArray) && startTimeArray[loopCount] != null) {
	//				updateWorktime.setStartTime(startTimeArray[loopCount].replace(":",""));
	//			}
	//			if(!"".equals(endTimeArray) && endTimeArray[loopCount] != null) {
	//				updateWorktime.setEndTime(endTimeArray[loopCount].replace(":",""));
	//			}
	//			if(!"".equals(restTimeArray) && restTimeArray[loopCount] != null) {
	//				updateWorktime.setRestTime(restTimeArray[loopCount].replace(":",""));
	//			}
	//			if(!"".equals(memoArray) && memoArray[loopCount] != null) {
	//				updateWorktime.setMemo(memoArray[loopCount]);
	//			}
	//
	//			WorktimeExample worktimeExample = new WorktimeExample();
	//			// このように条件を入れる（202009028　最後）
	//			worktimeExample.createCriteria().andIdEqualTo(worktimeByMemberId.getId());
	//			worktimeMapper.updateByExampleSelective(updateWorktime, worktimeExample);
	//
	//	}

	/**
	 * 勤務時間管理TBLを更新する
	 * @param worktimeByMemberId 対象のメンバーの選択月のレコード
	 * @param worktimeRegistForm 登録画面で入力された内容
	 * @param loopCount 処理カウント
	 */
	private void updateWorktime(Worktime worktimeByMemberId, WorktimeRegistForm worktimeRegistForm, int loopCount) {

		// 画面入力内容（更新リスト）
		List<WorktimeRegistForm> updateList = worktimeRegistForm.getWorktimeRegistFormList();

		// Worktimeオブジェクトを生成して、更新内容を追加する
		Worktime updateWorktime = new Worktime();

		// updateするときは主キーは使えない、後で消す
		//			updateWorktime.setId(worktimeByMemberId.getId());
		updateWorktime.setMemberId(worktimeByMemberId.getMemberId());
		updateWorktime.setWorkDate(worktimeByMemberId.getWorkDate());
		updateWorktime.setWeek(worktimeByMemberId.getWeek());
		if (updateList.get(loopCount).getStartTime() != null) {
			updateWorktime.setStartTime(updateList.get(loopCount).getStartTime().replace(":", ""));
		}
		if (updateList.get(loopCount).getEndTime() != null) {
			updateWorktime.setEndTime(updateList.get(loopCount).getEndTime().replace(":", ""));
		}
		if (updateList.get(loopCount).getRestTime() != null) {
			updateWorktime.setRestTime(updateList.get(loopCount).getRestTime().replace(":", ""));
		}
		if (updateList.get(loopCount).getMemo() != null) {
			updateWorktime.setMemo(updateList.get(loopCount).getMemo());
		}

		WorktimeExample worktimeExample = new WorktimeExample();
		// このように条件を入れる（202009028　最後）
		worktimeExample.createCriteria().andIdEqualTo(worktimeByMemberId.getId());
		worktimeMapper.updateByExampleSelective(updateWorktime, worktimeExample);
	}

	/**
	 * 勤務時間管理TBLを登録する
	 * @param memberId
	 * @param workDate
	 * @param week
	 * @param worktimeRegistForm 登録画面で入力された内容
	 * @param loopCount 処理カウント
	 */
	private void insertWorktime(Integer memberId, String workDate, int week, WorktimeRegistForm worktimeRegistForm,
			int loopCount) {

		// 画面入力内容（登録リスト）
		List<WorktimeRegistForm> insertList = worktimeRegistForm.getWorktimeRegistFormList();

		// Worktimeオブジェクトを生成して、更新内容を追加する
		Worktime updateWorktime = new Worktime();

		// idにautoIncrement制約をつけているので、idを設定しないでinserすれば、最大に１大したシーケンス番号で登録される
		//			updateWorktime.setId(worktimeByMemberId.getId());
		updateWorktime.setMemberId(memberId);
		updateWorktime.setWorkDate(workDate);
		updateWorktime.setWeek(week);
		if (insertList.get(loopCount).getStartTime() != null) {
			updateWorktime.setStartTime(insertList.get(loopCount).getStartTime().replace(":", ""));
		}
		if (insertList.get(loopCount).getEndTime() != null) {
			updateWorktime.setEndTime(insertList.get(loopCount).getEndTime().replace(":", ""));
		}
		if (insertList.get(loopCount).getRestTime() != null) {
			updateWorktime.setRestTime(insertList.get(loopCount).getRestTime().replace(":", ""));
		}
		if (insertList.get(loopCount).getMemo() != null) {
			updateWorktime.setMemo(insertList.get(loopCount).getMemo());
		}
		worktimeMapper.insert(updateWorktime);
	}

	/**
	 * 勤務時間検索画面で選択可能年を生成するメソッド
	 * @return  searchYearList 選択可能年List
	 */
	public List<String> makeSearchYearList() {

		// 選択可能年List
		List<String> searchYearList = new ArrayList<String>();

		// 2000年～2500年までを生成する
		int minYear = 2000;
		int maxYear = 2100;

		// 最小年数から最大年数までの年数Listを生成する
		for (int searchYear = minYear; searchYear <= maxYear; searchYear++) {
			searchYearList.add(Integer.toString(searchYear));
		}

		return searchYearList;
	}

	/**
	 * 勤務時間検索画面で選択可能月を生成するメソッド
	 * @return  searchYearList 選択可能月List
	 */
	public List<String> makeSearchMonthList() {

		// 選択可能月List
		List<String> searchMonthList = new ArrayList<String>();

		// １月～１２月までを生成する
		int minMonth = 1;
		int maxMonth = 12;

		// 最小月数から最大月数までの月数Listを生成する
		for (int searchMonth = minMonth; searchMonth <= maxMonth; searchMonth++) {
			searchMonthList.add(Integer.toString(searchMonth));
		}

		return searchMonthList;
	}

	/**
	 * 勤務管理情報から氏名のリストを取得するメソッド
	 * @return  searchYearList 選択可能月List
	 */
	public List<String> makeSearchNameList() {

		// memberのExampleを生成。
		MemberExample memberExample = new MemberExample();
		// メンバーテーブルを全て取得する
		List<Member> memberList = memberMapper.selectByExample(memberExample);

		// メンバーの名前リストを生成する。
		List<String> memberNameList = new ArrayList<String>();

		for(Member member : memberList) {
			memberNameList.add(member.getName());
		}

		return memberNameList;
	}

	/**
	 * 勤務時間検索結果を取得するメソッド
	 * @param year 年
	 * @param month 月
	 * @param name 氏名
	 * @return 勤務時間検索結果
	 */
	public List<WorktimeSearch> worktimeSearch(String year, String month, String name) {

		// 勤務時間検索結果を取得する
		List<WorktimeSearch> worktimeSearchResult = worktimeSearchMapper.worktimeSearch(year, month, name);

		return worktimeSearchResult;
	}

	/**
	 * 配列データを日数ごとに２次元配列にする [1, 火, 2, 水] ⇒ [[日:1, 曜日:火], [日:2, 曜日:水]]
	 * @param tableData 勤務時間確認画面から取得したデータ
	 * @return ２次元配列になったデータ
	 */
	public String[][] convertTwoDimentionalArray(String tableData) {

		// ,でスプリットして配列データに変更
		String[] splitedTableData = tableData.split(",");

		// カラム数（日、曜日、出社時間、退社時間、休み時間、備考）
		int columnNum = 6;

		// ２次元配列を生成する（[対象月の日数 = data数÷カラム数（※カラム数の倍数が前提）][カラム数]）
		String[][] twoDimTableData= new String[splitedTableData.length / columnNum][columnNum];

		// 配列データ分処理を繰り返す
		for(String data : splitedTableData) {
			for(int dataCount = 0; dataCount <= columnNum; dataCount++) {
				if(dataCount == 0) {
//					twoDimTableData = data;
				}

			}
		}

		return twoDimTableData;
	}

}
