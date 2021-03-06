package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.Owner;
import com.dreamhanks.HappyBeautyManager.dto.OwnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OwnerMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	long countByExample(OwnerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByExample(OwnerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int deleteByPrimaryKey(Integer ownerId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insert(Owner record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int insertSelective(Owner record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	List<Owner> selectByExample(OwnerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	Owner selectByPrimaryKey(Integer ownerId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExampleSelective(@Param("record") Owner record, @Param("example") OwnerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByExample(@Param("record") Owner record, @Param("example") OwnerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKeySelective(Owner record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table owner
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	int updateByPrimaryKey(Owner record);
}