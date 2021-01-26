package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.Customerstamp;
import com.dreamhanks.HappyBeautyManager.dto.CustomerstampExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerstampMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	long countByExample(CustomerstampExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByExample(CustomerstampExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insert(Customerstamp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insertSelective(Customerstamp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<Customerstamp> selectByExample(CustomerstampExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	Customerstamp selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleSelective(@Param("record") Customerstamp record, @Param("example") CustomerstampExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExample(@Param("record") Customerstamp record, @Param("example") CustomerstampExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeySelective(Customerstamp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKey(Customerstamp record);
}