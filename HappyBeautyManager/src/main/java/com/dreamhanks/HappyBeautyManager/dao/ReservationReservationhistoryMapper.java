package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.ReservationReservationhistory;
import com.dreamhanks.HappyBeautyManager.dto.ReservationReservationhistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservationReservationhistoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	long countByExample(ReservationReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByExample(ReservationReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByPrimaryKey(Integer reservationReservationhistoryId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insert(ReservationReservationhistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insertSelective(ReservationReservationhistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<ReservationReservationhistory> selectByExampleWithBLOBs(ReservationReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<ReservationReservationhistory> selectByExample(ReservationReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	ReservationReservationhistory selectByPrimaryKey(Integer reservationReservationhistoryId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleSelective(@Param("record") ReservationReservationhistory record,
			@Param("example") ReservationReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleWithBLOBs(@Param("record") ReservationReservationhistory record,
			@Param("example") ReservationReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExample(@Param("record") ReservationReservationhistory record,
			@Param("example") ReservationReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeySelective(ReservationReservationhistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeyWithBLOBs(ReservationReservationhistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKey(ReservationReservationhistory record);
}