package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.Servicehistory;
import com.dreamhanks.HappyBeautyManager.dto.ServicehistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServicehistoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	long countByExample(ServicehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByExample(ServicehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByPrimaryKey(Integer serviceId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insert(Servicehistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insertSelective(Servicehistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<Servicehistory> selectByExampleWithBLOBs(ServicehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<Servicehistory> selectByExample(ServicehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	Servicehistory selectByPrimaryKey(Integer serviceId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleSelective(@Param("record") Servicehistory record,
			@Param("example") ServicehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleWithBLOBs(@Param("record") Servicehistory record,
			@Param("example") ServicehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExample(@Param("record") Servicehistory record, @Param("example") ServicehistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeySelective(Servicehistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeyWithBLOBs(Servicehistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table servicehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKey(Servicehistory record);
}