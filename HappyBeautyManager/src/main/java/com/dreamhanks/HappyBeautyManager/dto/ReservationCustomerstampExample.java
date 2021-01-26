package com.dreamhanks.HappyBeautyManager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationCustomerstampExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public ReservationCustomerstampExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andReservationCustomerstampIdIsNull() {
			addCriterion("reservation_customerstamp_id is null");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdIsNotNull() {
			addCriterion("reservation_customerstamp_id is not null");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdEqualTo(Integer value) {
			addCriterion("reservation_customerstamp_id =", value, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdNotEqualTo(Integer value) {
			addCriterion("reservation_customerstamp_id <>", value, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdGreaterThan(Integer value) {
			addCriterion("reservation_customerstamp_id >", value, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("reservation_customerstamp_id >=", value, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdLessThan(Integer value) {
			addCriterion("reservation_customerstamp_id <", value, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdLessThanOrEqualTo(Integer value) {
			addCriterion("reservation_customerstamp_id <=", value, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdIn(List<Integer> values) {
			addCriterion("reservation_customerstamp_id in", values, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdNotIn(List<Integer> values) {
			addCriterion("reservation_customerstamp_id not in", values, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdBetween(Integer value1, Integer value2) {
			addCriterion("reservation_customerstamp_id between", value1, value2, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andReservationCustomerstampIdNotBetween(Integer value1, Integer value2) {
			addCriterion("reservation_customerstamp_id not between", value1, value2, "reservationCustomerstampId");
			return (Criteria) this;
		}

		public Criteria andManagerIdIsNull() {
			addCriterion("manager_id is null");
			return (Criteria) this;
		}

		public Criteria andManagerIdIsNotNull() {
			addCriterion("manager_id is not null");
			return (Criteria) this;
		}

		public Criteria andManagerIdEqualTo(String value) {
			addCriterion("manager_id =", value, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdNotEqualTo(String value) {
			addCriterion("manager_id <>", value, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdGreaterThan(String value) {
			addCriterion("manager_id >", value, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdGreaterThanOrEqualTo(String value) {
			addCriterion("manager_id >=", value, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdLessThan(String value) {
			addCriterion("manager_id <", value, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdLessThanOrEqualTo(String value) {
			addCriterion("manager_id <=", value, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdLike(String value) {
			addCriterion("manager_id like", value, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdNotLike(String value) {
			addCriterion("manager_id not like", value, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdIn(List<String> values) {
			addCriterion("manager_id in", values, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdNotIn(List<String> values) {
			addCriterion("manager_id not in", values, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdBetween(String value1, String value2) {
			addCriterion("manager_id between", value1, value2, "managerId");
			return (Criteria) this;
		}

		public Criteria andManagerIdNotBetween(String value1, String value2) {
			addCriterion("manager_id not between", value1, value2, "managerId");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgIsNull() {
			addCriterion("reservation_delete_flg is null");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgIsNotNull() {
			addCriterion("reservation_delete_flg is not null");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgEqualTo(Integer value) {
			addCriterion("reservation_delete_flg =", value, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgNotEqualTo(Integer value) {
			addCriterion("reservation_delete_flg <>", value, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgGreaterThan(Integer value) {
			addCriterion("reservation_delete_flg >", value, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgGreaterThanOrEqualTo(Integer value) {
			addCriterion("reservation_delete_flg >=", value, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgLessThan(Integer value) {
			addCriterion("reservation_delete_flg <", value, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgLessThanOrEqualTo(Integer value) {
			addCriterion("reservation_delete_flg <=", value, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgIn(List<Integer> values) {
			addCriterion("reservation_delete_flg in", values, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgNotIn(List<Integer> values) {
			addCriterion("reservation_delete_flg not in", values, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgBetween(Integer value1, Integer value2) {
			addCriterion("reservation_delete_flg between", value1, value2, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andReservationDeleteFlgNotBetween(Integer value1, Integer value2) {
			addCriterion("reservation_delete_flg not between", value1, value2, "reservationDeleteFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgIsNull() {
			addCriterion("judgment_flg is null");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgIsNotNull() {
			addCriterion("judgment_flg is not null");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgEqualTo(Integer value) {
			addCriterion("judgment_flg =", value, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgNotEqualTo(Integer value) {
			addCriterion("judgment_flg <>", value, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgGreaterThan(Integer value) {
			addCriterion("judgment_flg >", value, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgGreaterThanOrEqualTo(Integer value) {
			addCriterion("judgment_flg >=", value, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgLessThan(Integer value) {
			addCriterion("judgment_flg <", value, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgLessThanOrEqualTo(Integer value) {
			addCriterion("judgment_flg <=", value, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgIn(List<Integer> values) {
			addCriterion("judgment_flg in", values, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgNotIn(List<Integer> values) {
			addCriterion("judgment_flg not in", values, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgBetween(Integer value1, Integer value2) {
			addCriterion("judgment_flg between", value1, value2, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andJudgmentFlgNotBetween(Integer value1, Integer value2) {
			addCriterion("judgment_flg not between", value1, value2, "judgmentFlg");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateIsNull() {
			addCriterion("resarvation_create_date is null");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateIsNotNull() {
			addCriterion("resarvation_create_date is not null");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateEqualTo(Date value) {
			addCriterion("resarvation_create_date =", value, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateNotEqualTo(Date value) {
			addCriterion("resarvation_create_date <>", value, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateGreaterThan(Date value) {
			addCriterion("resarvation_create_date >", value, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("resarvation_create_date >=", value, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateLessThan(Date value) {
			addCriterion("resarvation_create_date <", value, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("resarvation_create_date <=", value, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateIn(List<Date> values) {
			addCriterion("resarvation_create_date in", values, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateNotIn(List<Date> values) {
			addCriterion("resarvation_create_date not in", values, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateBetween(Date value1, Date value2) {
			addCriterion("resarvation_create_date between", value1, value2, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andResarvationCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("resarvation_create_date not between", value1, value2, "resarvationCreateDate");
			return (Criteria) this;
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberIsNull() {
			addCriterion("owner_phone_number is null");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberIsNotNull() {
			addCriterion("owner_phone_number is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberEqualTo(String value) {
			addCriterion("owner_phone_number =", value, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberNotEqualTo(String value) {
			addCriterion("owner_phone_number <>", value, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberGreaterThan(String value) {
			addCriterion("owner_phone_number >", value, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberGreaterThanOrEqualTo(String value) {
			addCriterion("owner_phone_number >=", value, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberLessThan(String value) {
			addCriterion("owner_phone_number <", value, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberLessThanOrEqualTo(String value) {
			addCriterion("owner_phone_number <=", value, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberLike(String value) {
			addCriterion("owner_phone_number like", value, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberNotLike(String value) {
			addCriterion("owner_phone_number not like", value, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberIn(List<String> values) {
			addCriterion("owner_phone_number in", values, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberNotIn(List<String> values) {
			addCriterion("owner_phone_number not in", values, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberBetween(String value1, String value2) {
			addCriterion("owner_phone_number between", value1, value2, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNumberNotBetween(String value1, String value2) {
			addCriterion("owner_phone_number not between", value1, value2, "ownerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberIsNull() {
			addCriterion("customer_phone_number is null");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberIsNotNull() {
			addCriterion("customer_phone_number is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberEqualTo(String value) {
			addCriterion("customer_phone_number =", value, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberNotEqualTo(String value) {
			addCriterion("customer_phone_number <>", value, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberGreaterThan(String value) {
			addCriterion("customer_phone_number >", value, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberGreaterThanOrEqualTo(String value) {
			addCriterion("customer_phone_number >=", value, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberLessThan(String value) {
			addCriterion("customer_phone_number <", value, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberLessThanOrEqualTo(String value) {
			addCriterion("customer_phone_number <=", value, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberLike(String value) {
			addCriterion("customer_phone_number like", value, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberNotLike(String value) {
			addCriterion("customer_phone_number not like", value, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberIn(List<String> values) {
			addCriterion("customer_phone_number in", values, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberNotIn(List<String> values) {
			addCriterion("customer_phone_number not in", values, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberBetween(String value1, String value2) {
			addCriterion("customer_phone_number between", value1, value2, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andCustomerPhoneNumberNotBetween(String value1, String value2) {
			addCriterion("customer_phone_number not between", value1, value2, "customerPhoneNumber");
			return (Criteria) this;
		}

		public Criteria andStampIdIsNull() {
			addCriterion("stamp_id is null");
			return (Criteria) this;
		}

		public Criteria andStampIdIsNotNull() {
			addCriterion("stamp_id is not null");
			return (Criteria) this;
		}

		public Criteria andStampIdEqualTo(Integer value) {
			addCriterion("stamp_id =", value, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdNotEqualTo(Integer value) {
			addCriterion("stamp_id <>", value, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdGreaterThan(Integer value) {
			addCriterion("stamp_id >", value, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("stamp_id >=", value, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdLessThan(Integer value) {
			addCriterion("stamp_id <", value, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdLessThanOrEqualTo(Integer value) {
			addCriterion("stamp_id <=", value, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdIn(List<Integer> values) {
			addCriterion("stamp_id in", values, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdNotIn(List<Integer> values) {
			addCriterion("stamp_id not in", values, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdBetween(Integer value1, Integer value2) {
			addCriterion("stamp_id between", value1, value2, "stampId");
			return (Criteria) this;
		}

		public Criteria andStampIdNotBetween(Integer value1, Integer value2) {
			addCriterion("stamp_id not between", value1, value2, "stampId");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextIsNull() {
			addCriterion("customer_qr_text is null");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextIsNotNull() {
			addCriterion("customer_qr_text is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextEqualTo(String value) {
			addCriterion("customer_qr_text =", value, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextNotEqualTo(String value) {
			addCriterion("customer_qr_text <>", value, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextGreaterThan(String value) {
			addCriterion("customer_qr_text >", value, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextGreaterThanOrEqualTo(String value) {
			addCriterion("customer_qr_text >=", value, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextLessThan(String value) {
			addCriterion("customer_qr_text <", value, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextLessThanOrEqualTo(String value) {
			addCriterion("customer_qr_text <=", value, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextLike(String value) {
			addCriterion("customer_qr_text like", value, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextNotLike(String value) {
			addCriterion("customer_qr_text not like", value, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextIn(List<String> values) {
			addCriterion("customer_qr_text in", values, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextNotIn(List<String> values) {
			addCriterion("customer_qr_text not in", values, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextBetween(String value1, String value2) {
			addCriterion("customer_qr_text between", value1, value2, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andCustomerQrTextNotBetween(String value1, String value2) {
			addCriterion("customer_qr_text not between", value1, value2, "customerQrText");
			return (Criteria) this;
		}

		public Criteria andStampCountIsNull() {
			addCriterion("stamp_count is null");
			return (Criteria) this;
		}

		public Criteria andStampCountIsNotNull() {
			addCriterion("stamp_count is not null");
			return (Criteria) this;
		}

		public Criteria andStampCountEqualTo(Integer value) {
			addCriterion("stamp_count =", value, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountNotEqualTo(Integer value) {
			addCriterion("stamp_count <>", value, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountGreaterThan(Integer value) {
			addCriterion("stamp_count >", value, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("stamp_count >=", value, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountLessThan(Integer value) {
			addCriterion("stamp_count <", value, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountLessThanOrEqualTo(Integer value) {
			addCriterion("stamp_count <=", value, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountIn(List<Integer> values) {
			addCriterion("stamp_count in", values, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountNotIn(List<Integer> values) {
			addCriterion("stamp_count not in", values, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountBetween(Integer value1, Integer value2) {
			addCriterion("stamp_count between", value1, value2, "stampCount");
			return (Criteria) this;
		}

		public Criteria andStampCountNotBetween(Integer value1, Integer value2) {
			addCriterion("stamp_count not between", value1, value2, "stampCount");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIsNull() {
			addCriterion("delete_flg is null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIsNotNull() {
			addCriterion("delete_flg is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgEqualTo(Boolean value) {
			addCriterion("delete_flg =", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotEqualTo(Boolean value) {
			addCriterion("delete_flg <>", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgGreaterThan(Boolean value) {
			addCriterion("delete_flg >", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgGreaterThanOrEqualTo(Boolean value) {
			addCriterion("delete_flg >=", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgLessThan(Boolean value) {
			addCriterion("delete_flg <", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgLessThanOrEqualTo(Boolean value) {
			addCriterion("delete_flg <=", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIn(List<Boolean> values) {
			addCriterion("delete_flg in", values, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotIn(List<Boolean> values) {
			addCriterion("delete_flg not in", values, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_flg between", value1, value2, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_flg not between", value1, value2, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateIsNull() {
			addCriterion("validity_start_date is null");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateIsNotNull() {
			addCriterion("validity_start_date is not null");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateEqualTo(Date value) {
			addCriterion("validity_start_date =", value, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateNotEqualTo(Date value) {
			addCriterion("validity_start_date <>", value, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateGreaterThan(Date value) {
			addCriterion("validity_start_date >", value, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateGreaterThanOrEqualTo(Date value) {
			addCriterion("validity_start_date >=", value, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateLessThan(Date value) {
			addCriterion("validity_start_date <", value, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateLessThanOrEqualTo(Date value) {
			addCriterion("validity_start_date <=", value, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateIn(List<Date> values) {
			addCriterion("validity_start_date in", values, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateNotIn(List<Date> values) {
			addCriterion("validity_start_date not in", values, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateBetween(Date value1, Date value2) {
			addCriterion("validity_start_date between", value1, value2, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityStartDateNotBetween(Date value1, Date value2) {
			addCriterion("validity_start_date not between", value1, value2, "validityStartDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateIsNull() {
			addCriterion("validity_end_date is null");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateIsNotNull() {
			addCriterion("validity_end_date is not null");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateEqualTo(Date value) {
			addCriterion("validity_end_date =", value, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateNotEqualTo(Date value) {
			addCriterion("validity_end_date <>", value, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateGreaterThan(Date value) {
			addCriterion("validity_end_date >", value, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateGreaterThanOrEqualTo(Date value) {
			addCriterion("validity_end_date >=", value, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateLessThan(Date value) {
			addCriterion("validity_end_date <", value, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateLessThanOrEqualTo(Date value) {
			addCriterion("validity_end_date <=", value, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateIn(List<Date> values) {
			addCriterion("validity_end_date in", values, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateNotIn(List<Date> values) {
			addCriterion("validity_end_date not in", values, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateBetween(Date value1, Date value2) {
			addCriterion("validity_end_date between", value1, value2, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andValidityEndDateNotBetween(Date value1, Date value2) {
			addCriterion("validity_end_date not between", value1, value2, "validityEndDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNull() {
			addCriterion("update_date is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNotNull() {
			addCriterion("update_date is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateEqualTo(Date value) {
			addCriterion("update_date =", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotEqualTo(Date value) {
			addCriterion("update_date <>", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThan(Date value) {
			addCriterion("update_date >", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("update_date >=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThan(Date value) {
			addCriterion("update_date <", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
			addCriterion("update_date <=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIn(List<Date> values) {
			addCriterion("update_date in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotIn(List<Date> values) {
			addCriterion("update_date not in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateBetween(Date value1, Date value2) {
			addCriterion("update_date between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
			addCriterion("update_date not between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("create_date is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("create_date >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table reservation_customerstamp
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table reservation_customerstamp
     *
     * @mbg.generated do_not_delete_during_merge Mon Nov 16 16:02:40 KST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}