package com.dreamhanks.HappyBeautyManager.dao;

import java.util.List;

import com.dreamhanks.HappyBeautyManager.dto.JoinReservationChargehistory;
import com.dreamhanks.HappyBeautyManager.form.SearchForm;


public interface JoinReservationChargehistoryMapper {
	List<JoinReservationChargehistory> joinReservationhistoryResult(SearchForm searchForm);

}
