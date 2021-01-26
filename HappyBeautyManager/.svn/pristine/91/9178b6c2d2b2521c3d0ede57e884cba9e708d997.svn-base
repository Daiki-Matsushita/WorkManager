package com.dreamhanks.HappyBeautyManager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dreamhanks.HappyBeautyManager.dao.ManagerMapper;
import com.dreamhanks.HappyBeautyManager.dao.TableListDisplayMasterMapper;
import com.dreamhanks.HappyBeautyManager.dto.Manager;
import com.dreamhanks.HappyBeautyManager.dto.ManagerExample;
import com.dreamhanks.HappyBeautyManager.dto.TableListDisplayMaster;
import com.dreamhanks.HappyBeautyManager.dto.TableListDisplayMasterExample;
import com.dreamhanks.HappyBeautyManager.form.LoginForm;


/**
 * ログイン処理を行うためのサービス
 *
 * @author jini and elmu
 *
 */
@Service
@Transactional
public class LoginService {

	@Autowired
	ManagerMapper managerMapper;
	@Autowired
	TableListDisplayMasterMapper displayMasterMapper;

	/**
	 * ログイン情報でDBで照会し、それに該当するユーザー情報を返すメソッド
	 *
	 * @param form 画面から入力された値が入っているフォームクラス
	 * @return ユーザー情報
	 */
	public Manager getManager(LoginForm form) {
		// ユーザから入力されたIDとPasswordがDBのIDとPasswordが一致するかを確認するためのメッソド
		ManagerExample example = new ManagerExample();
		example.createCriteria().andIdEqualTo(form.getId()).andPasswordEqualTo(form.getPassword());

		// 対象のユーザー情報を取得する
		List<Manager> listManager = managerMapper.selectByExample(example);

		// ユーザ情報が取得できなかった場合nullを返却する
		if (listManager.isEmpty()) {
			return null;
		}

		// ユーザ情報の1行目を返却する
		return listManager.get(0);
	}


	/**
	 * テーブル一覧情報を取得する
	 *
	 * @param groupId 1:データ管理画面, 2:データ認証管理画面
	 * @return テーブル一覧情報
	 */
	public List<TableListDisplayMaster> getDisplayMaster(int groupId) {

		// テーブル一覧表示マスタ検索条件の生成
		TableListDisplayMasterExample example = new TableListDisplayMasterExample();
		example.createCriteria().andAvailableFlgEqualTo(true).andGroupIdEqualTo(groupId);

		// テーブル一覧表示マスタを検索する
		List<TableListDisplayMaster> listDisplayMaster = displayMasterMapper.selectByExample(example);

		return listDisplayMaster;
	}


}


