package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.Customer;
import com.dreamhanks.HappyBeautyManager.dto.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	long countByExample(CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByExample(CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByPrimaryKey(Short customerId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insert(Customer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insertSelective(Customer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<Customer> selectByExample(CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	Customer selectByPrimaryKey(Short customerId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeySelective(Customer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table customer
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKey(Customer record);
}