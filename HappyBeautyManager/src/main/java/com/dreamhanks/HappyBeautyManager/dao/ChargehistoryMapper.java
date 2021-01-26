package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.Chargehistory;
import com.dreamhanks.HappyBeautyManager.dto.ChargehistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChargehistoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	long countByExample(ChargehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByExample(ChargehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByPrimaryKey(Integer chargeId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insert(Chargehistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insertSelective(Chargehistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<Chargehistory> selectByExample(ChargehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	Chargehistory selectByPrimaryKey(Integer chargeId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleSelective(@Param("record") Chargehistory record, @Param("example") ChargehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExample(@Param("record") Chargehistory record, @Param("example") ChargehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeySelective(Chargehistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKey(Chargehistory record);
}