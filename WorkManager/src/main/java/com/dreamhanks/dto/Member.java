package com.dreamhanks.dto;

public class Member {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column member.id
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column member.name
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column member.password
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column member.df_start_time
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	private String dfStartTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column member.df_end_time
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	private String dfEndTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column member.id
	 * @return  the value of member.id
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column member.id
	 * @param id  the value for member.id
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column member.name
	 * @return  the value of member.name
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column member.name
	 * @param name  the value for member.name
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column member.password
	 * @return  the value of member.password
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column member.password
	 * @param password  the value for member.password
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column member.df_start_time
	 * @return  the value of member.df_start_time
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public String getDfStartTime() {
		return dfStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column member.df_start_time
	 * @param dfStartTime  the value for member.df_start_time
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public void setDfStartTime(String dfStartTime) {
		this.dfStartTime = dfStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column member.df_end_time
	 * @return  the value of member.df_end_time
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public String getDfEndTime() {
		return dfEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column member.df_end_time
	 * @param dfEndTime  the value for member.df_end_time
	 * @mbg.generated  Thu Oct 15 11:34:29 JST 2020
	 */
	public void setDfEndTime(String dfEndTime) {
		this.dfEndTime = dfEndTime;
	}
}