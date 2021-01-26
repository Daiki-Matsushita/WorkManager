package com.dreamhanks.HappyBeautyManager.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dreamhanks.HappyBeautyManager.dao.ReservationStampeventMapper;
import com.dreamhanks.HappyBeautyManager.dao.SearchDisplayMasterMapper;
import com.dreamhanks.HappyBeautyManager.dao.SearchMapper;
import com.dreamhanks.HappyBeautyManager.dao.StampeventMapper;
import com.dreamhanks.HappyBeautyManager.dao.TableListDisplayMasterMapper;
import com.dreamhanks.HappyBeautyManager.dto.ReservationStampevent;
import com.dreamhanks.HappyBeautyManager.dto.Reservationhistory;
import com.dreamhanks.HappyBeautyManager.dto.SearchDisplayMaster;
import com.dreamhanks.HappyBeautyManager.dto.SearchDisplayMasterExample;
import com.dreamhanks.HappyBeautyManager.dto.Servicehistory;
import com.dreamhanks.HappyBeautyManager.dto.Stampevent;
import com.dreamhanks.HappyBeautyManager.dto.StampeventExample;
import com.dreamhanks.HappyBeautyManager.dto.TableListDisplayMaster;
import com.dreamhanks.HappyBeautyManager.dto.TableListDisplayMasterExample;
import com.dreamhanks.HappyBeautyManager.form.SearchForm;
import com.dreamhanks.HappyBeautyManager.form.UpdateForm;

/**
 * データ管理のサービス
 * 
 * @author SEC
 *
 */
@Service
public class ManageService {
	@Inject
	private TableListDisplayMasterMapper tableListDisplayMasterMapper;

	@Autowired
	SearchDisplayMasterMapper searchDisplayMasterMapper;
	@Autowired
	StampeventMapper stampeventMapper;
	@Autowired
	SearchMapper searchMapper;
	@Autowired
	ReservationStampeventMapper reservationStampeventMapper;

	// Display_Masterテーブルから基本テーブルの情報を習得するためのメッソド
	public List<TableListDisplayMaster> getDisplayMaster() {
		TableListDisplayMasterExample de = new TableListDisplayMasterExample();
		de.createCriteria().andGroupIdEqualTo(1).andAvailableFlgEqualTo(true);
		List<TableListDisplayMaster> tablesList = tableListDisplayMasterMapper.selectByExample(de);
		if (tablesList != null) {
			return tablesList;
		}
		return null;
	}


	/**
	 * DBにある予約テーブルを読み込む処理をするためのメソッド
	 * 
	 * @return 予約テーブル名
	 */
	public List<TableListDisplayMaster> bringTableName() {
		TableListDisplayMasterExample example = new TableListDisplayMasterExample();
		example.createCriteria().andGroupIdEqualTo(1).andAvailableFlgEqualTo(true);
		List<TableListDisplayMaster> tableName = tableListDisplayMasterMapper.selectByExample(example);
		if (tableName.isEmpty()) {
			return null;
		}
		return tableName;
	}


	/**
	 * 検索画面表示マスタからテーブル識別番号に合うテーブルのカラム名を取得するメソッド
	 * @param identificationNum なるべく共通部品化できるようにする。
	 * @return null値とカラム名リスト
	 */
	public List<SearchDisplayMaster> selectedTableInfo(String identificationNumber) {
		
		// 識別番号にあう、使用可能なテーブルのカラム名を取得する
		SearchDisplayMasterExample example = new SearchDisplayMasterExample();
		example.createCriteria().andIdentificationNumEqualTo(identificationNumber).andAvailableFlgEqualTo(true);
		List<SearchDisplayMaster> selectedTableInfoList = searchDisplayMasterMapper.selectByExample(example);
		
		// 取得できなかった場合nullを返す
		if (selectedTableInfoList.isEmpty()) {
			return null;
		}

		return selectedTableInfoList;

	}


	/**
	 * テーブルによって検索結果リストを返すメソッド
	 * @param searchList 検索条件の入力値
	 * @param tableName テーブルの識別番号情報
	 * @return 検索結果リスト
	 * @throws ParseException これはチェックされた例外であり、特別な形式である必要がある文字列の解析に失敗した場合に発生する可能性があります。 
	 * その上で非常に重要な例の1つは、文字列を日付オブジェクトに解析しようとしている場合です。 ...指定された文字列がその形式を満たさない場合はjava。
	 */
	public List<Object> searchProcessing(List<String> searchList, String tableName) throws ParseException {

		// 検索結果Listの初期化
		List<Object> serchResultList = null;

		// StringをDateに変換
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// boolean値の初期化
		Boolean result = false;

		// StampEventの結果リスト取得
		if (tableName.equals("A5")) {

			Stampevent stampevent = new Stampevent();

			if (!searchList.get(0).isEmpty()) {
				stampevent.setStampEventId(Integer.parseInt(searchList.get(0)));
			}
			if (!searchList.get(1).isEmpty()) {
				stampevent.setStampId(Integer.parseInt(searchList.get(1)));
			}
			if (!searchList.get(2).isEmpty()) {
				stampevent.setEventSpace(Integer.parseInt(searchList.get(2)));
			}
			if (!searchList.get(3).isEmpty()) {
				stampevent.setEventContents(searchList.get(3));
			}
			if (!searchList.get(4).isEmpty()) {
				// Stringをbooleanに変換
				result = Boolean.valueOf(searchList.get(4)).booleanValue();
				stampevent.setDeleteFlg(result);
			}
			serchResultList = searchMapper.stampeventSearchResultMap(stampevent);
		}

		// Reservation Historyの結果リスト取得
		if (tableName.equals("A7")) {

			Reservationhistory reservationhistory = new Reservationhistory();

			if (!searchList.get(0).isEmpty()) {
				reservationhistory.setReservationId(Integer.parseInt(searchList.get(0)));
			}
			if (!searchList.get(1).isEmpty()) {
				reservationhistory.setReservationContents(searchList.get(1));
			}
			if (!searchList.get(2).isEmpty()) {
				reservationhistory.setCustomerId(Integer.parseInt(searchList.get(2)));
			}
			if (!searchList.get(3).isEmpty()) {
				reservationhistory.setOwnerId(Integer.parseInt(searchList.get(3)));
			}
			if (!searchList.get(4).isEmpty()) {
				reservationhistory.setReservationDate(searchList.get(4));
			}
			if (!searchList.get(5).isEmpty()) {
				reservationhistory.setReservationTime(searchList.get(5));
			}
			if (!searchList.get(6).isEmpty()) {
				reservationhistory.setServiceEstimatedTime(searchList.get(6));
			}
			if (!searchList.get(7).isEmpty()) {
				reservationhistory.setDeleteFlg(Integer.parseInt(searchList.get(7)));
			}
			if (!searchList.get(8).isEmpty()) {
				reservationhistory.setCustomerPhoneNumber(searchList.get(8));
			}
			serchResultList = searchMapper.reservationhistorySearchResultMap(reservationhistory);
		}

		if (tableName.equals("A9")) {

			Servicehistory servicehistory = new Servicehistory();

			if (!searchList.get(0).isEmpty()) {
				servicehistory.setServiceId(Integer.parseInt(searchList.get(0)));
			}
			if (!searchList.get(1).isEmpty()) {
				servicehistory.setServiceContents(searchList.get(1));
			}
			if (!searchList.get(2).isEmpty()) {
				servicehistory.setServiceMoney(Integer.parseInt(searchList.get(2)));
			}
			if (!searchList.get(3).isEmpty()) {
				servicehistory.setServiceImg(searchList.get(3));
			}
			if (!searchList.get(4).isEmpty()) {
				servicehistory.setCustomerId(Integer.parseInt(searchList.get(4)));
			}
			if (!searchList.get(5).isEmpty()) {
				servicehistory.setOwnerId(Integer.parseInt(searchList.get(5)));
			}
			if (!searchList.get(6).isEmpty()) {
				Date date = fm.parse(searchList.get(6));
				servicehistory.setServiceDate(date);
			}

			serchResultList = searchMapper.servicehistorySearchResultMap(servicehistory);
		}


		return serchResultList;
	}


	
	/**
	 * このメソッドは、manageControllerがデータベースにデータを挿入するのに役立ちます
	 * @param searchList 検索条件の入力値
	 * @param managerId ユーザーID
	 * @param tableName テーブルの識別番号情報
	 * @return 'check'が成功した場合は1になりますが、それ以外の場合は0になります。 つまり、挿入処理が成功すれば、それは1つになります。
	 * @throws ParseException これはチェックされた例外であり、特別な形式である必要がある文字列の解析に失敗した場合に発生する可能性があります。 
	 * その上で非常に重要な例の1つは、文字列を日付オブジェクトに解析しようとしている場合です。 ...指定された文字列がその形式を満たさない場合はjava。
	 */
	public int registrateProcessing(List<String> searchList, String managerId, String tableName) throws ParseException {

		int check = 0;

		// テーブル名がA5の場合
		if (tableName.equals("A5")) {
			// 新しいオブジェクトを作成する
			ReservationStampevent stampevent = new ReservationStampevent();
			// データをオブジェクトに設定する
			stampevent.setManagerId(managerId);
			stampevent.setJudgmentFlg(1);
			stampevent.setStampEventId(Integer.parseInt(searchList.get(0)));
			stampevent.setStampId(Integer.parseInt(searchList.get(1)));
			stampevent.setEventSpace(Integer.parseInt(searchList.get(2)));
			stampevent.setEventContents(searchList.get(3));
			// データベースへのデータの挿入
			check = reservationStampeventMapper.insertSelective(stampevent);

		}

		// 'check'が成功した場合は1になりますが、それ以外の場合は0になります。 つまり、挿入処理が成功すれば、それは1つになります。
		return check;
	}
	
	
	public List<Object> getSelectedData(SearchForm searchForm){
		
		List<Object> selectedDataList = new ArrayList<Object>();
		
		String[] checkList = searchForm.getCheckList();
		
		if (searchForm.getIdentificationNumber().equals("A5")) {
			for (String id : checkList) {
				StampeventExample example = new StampeventExample();
				example.createCriteria().andStampEventIdEqualTo(Integer.parseInt(id));
				selectedDataList.add(stampeventMapper.selectByExampleWithBLOBs(example));
			}
		}
		
		return selectedDataList;
	}
	

	public String getSelectedTableName(UpdateForm updateForm) {

		TableListDisplayMasterExample example = new TableListDisplayMasterExample();
		example.createCriteria().andIdentificationNumEqualTo(updateForm.getIdentificationNum());
		TableListDisplayMaster selectedtable =
				(TableListDisplayMaster) tableListDisplayMasterMapper.selectByExample(example);

		if (selectedtable != null) {
			String selectedtableName = selectedtable.getTableName();
			return selectedtableName;
		}
		return null;

	}

	public Stampevent getSelectedRow(UpdateForm updateForm) {
		StampeventExample example = new StampeventExample();

		example.createCriteria().andStampEventIdEqualTo(Integer.parseInt(updateForm.getStampEventId()));

		Stampevent ste = (Stampevent) stampeventMapper.selectByExample(example);


		if (ste != null) {
			return ste;
		}
		return null;

	}



}


