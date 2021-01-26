package com.dreamhanks.HappyBeautyManager.dao;

import com.dreamhanks.HappyBeautyManager.dto.SearchResultDisplayMaster;
import com.dreamhanks.HappyBeautyManager.dto.SearchResultDisplayMasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchResultDisplayMasterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    long countByExample(SearchResultDisplayMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    int deleteByExample(SearchResultDisplayMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    int insert(SearchResultDisplayMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    int insertSelective(SearchResultDisplayMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    List<SearchResultDisplayMaster> selectByExample(SearchResultDisplayMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    SearchResultDisplayMaster selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    int updateByExampleSelective(@Param("record") SearchResultDisplayMaster record, @Param("example") SearchResultDisplayMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    int updateByExample(@Param("record") SearchResultDisplayMaster record, @Param("example") SearchResultDisplayMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    int updateByPrimaryKeySelective(SearchResultDisplayMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_result_display_master
     *
     * @mbg.generated Thu Nov 19 15:40:16 KST 2020
     */
    int updateByPrimaryKey(SearchResultDisplayMaster record);
}