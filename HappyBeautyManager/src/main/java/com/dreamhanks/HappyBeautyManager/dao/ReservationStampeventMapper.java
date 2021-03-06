package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.ReservationStampevent;
import com.dreamhanks.HappyBeautyManager.dto.ReservationStampeventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservationStampeventMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	long countByExample(ReservationStampeventExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int deleteByExample(ReservationStampeventExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int deleteByPrimaryKey(Integer reservationStampeventId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int insert(ReservationStampevent record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int insertSelective(ReservationStampevent record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	List<Object> selectByExampleWithBLOBs(ReservationStampeventExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	List<Object> selectByExample(ReservationStampeventExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	ReservationStampevent selectByPrimaryKey(Integer reservationStampeventId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int updateByExampleSelective(@Param("record") ReservationStampevent record,
			@Param("example") ReservationStampeventExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int updateByExampleWithBLOBs(@Param("record") ReservationStampevent record,
			@Param("example") ReservationStampeventExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int updateByExample(@Param("record") ReservationStampevent record,
			@Param("example") ReservationStampeventExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int updateByPrimaryKeySelective(ReservationStampevent record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int updateByPrimaryKeyWithBLOBs(ReservationStampevent record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_stampevent
	 * @mbg.generated  Thu Nov 26 15:55:59 KST 2020
	 */
	int updateByPrimaryKey(ReservationStampevent record);
}