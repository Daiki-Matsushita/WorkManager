package com.dreamhanks.HappyBeautyManager.dto;

import java.util.Date;

public class Manager {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column manager.id
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    private String id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column manager.password
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    private String password;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column manager.name
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column manager.auth
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    private Boolean auth;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column manager.create_date
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    private Date createDate;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column manager.id
     * @return  the value of manager.id
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column manager.id
     * @param id  the value for manager.id
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column manager.password
     * @return  the value of manager.password
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column manager.password
     * @param password  the value for manager.password
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column manager.name
     * @return  the value of manager.name
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column manager.name
     * @param name  the value for manager.name
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column manager.auth
     * @return  the value of manager.auth
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public Boolean getAuth() {
        return auth;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column manager.auth
     * @param auth  the value for manager.auth
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column manager.create_date
     * @return  the value of manager.create_date
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column manager.create_date
     * @param createDate  the value for manager.create_date
     * @mbg.generated  Tue Nov 17 15:08:29 JST 2020
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}