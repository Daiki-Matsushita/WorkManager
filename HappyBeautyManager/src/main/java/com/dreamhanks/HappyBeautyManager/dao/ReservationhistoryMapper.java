package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.Reservationhistory;
import com.dreamhanks.HappyBeautyManager.dto.ReservationhistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservationhistoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	long countByExample(ReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByExample(ReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByPrimaryKey(Integer reservationId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insert(Reservationhistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insertSelective(Reservationhistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<Reservationhistory> selectByExampleWithBLOBs(ReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<Reservationhistory> selectByExample(ReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	Reservationhistory selectByPrimaryKey(Integer reservationId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleSelective(@Param("record") Reservationhistory record,
			@Param("example") ReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleWithBLOBs(@Param("record") Reservationhistory record,
			@Param("example") ReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExample(@Param("record") Reservationhistory record,
			@Param("example") ReservationhistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeySelective(Reservationhistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeyWithBLOBs(Reservationhistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservationhistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKey(Reservationhistory record);
}