package com.dreamhanks.HappyBeautyManager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChargehistoryExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public ChargehistoryExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chargehistory
	 * @mbg.generated  Mon Nov 16 16:42:54 KST 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table chargehistory
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

		public Criteria andChargeIdIsNull() {
			addCriterion("charge_id is null");
			return (Criteria) this;
		}

		public Criteria andChargeIdIsNotNull() {
			addCriterion("charge_id is not null");
			return (Criteria) this;
		}

		public Criteria andChargeIdEqualTo(Integer value) {
			addCriterion("charge_id =", value, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdNotEqualTo(Integer value) {
			addCriterion("charge_id <>", value, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdGreaterThan(Integer value) {
			addCriterion("charge_id >", value, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("charge_id >=", value, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdLessThan(Integer value) {
			addCriterion("charge_id <", value, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdLessThanOrEqualTo(Integer value) {
			addCriterion("charge_id <=", value, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdIn(List<Integer> values) {
			addCriterion("charge_id in", values, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdNotIn(List<Integer> values) {
			addCriterion("charge_id not in", values, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdBetween(Integer value1, Integer value2) {
			addCriterion("charge_id between", value1, value2, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("charge_id not between", value1, value2, "chargeId");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyIsNull() {
			addCriterion("charge_money is null");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyIsNotNull() {
			addCriterion("charge_money is not null");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyEqualTo(Integer value) {
			addCriterion("charge_money =", value, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyNotEqualTo(Integer value) {
			addCriterion("charge_money <>", value, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyGreaterThan(Integer value) {
			addCriterion("charge_money >", value, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyGreaterThanOrEqualTo(Integer value) {
			addCriterion("charge_money >=", value, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyLessThan(Integer value) {
			addCriterion("charge_money <", value, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyLessThanOrEqualTo(Integer value) {
			addCriterion("charge_money <=", value, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyIn(List<Integer> values) {
			addCriterion("charge_money in", values, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyNotIn(List<Integer> values) {
			addCriterion("charge_money not in", values, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyBetween(Integer value1, Integer value2) {
			addCriterion("charge_money between", value1, value2, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andChargeMoneyNotBetween(Integer value1, Integer value2) {
			addCriterion("charge_money not between", value1, value2, "chargeMoney");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNull() {
			addCriterion("customer_id is null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNotNull() {
			addCriterion("customer_id is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdEqualTo(Integer value) {
			addCriterion("customer_id =", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotEqualTo(Integer value) {
			addCriterion("customer_id <>", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThan(Integer value) {
			addCriterion("customer_id >", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("customer_id >=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThan(Integer value) {
			addCriterion("customer_id <", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
			addCriterion("customer_id <=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIn(List<Integer> values) {
			addCriterion("customer_id in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotIn(List<Integer> values) {
			addCriterion("customer_id not in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
			addCriterion("customer_id between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("customer_id not between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdIsNull() {
			addCriterion("owner_id is null");
			return (Criteria) this;
		}

		public Criteria andOwnerIdIsNotNull() {
			addCriterion("owner_id is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerIdEqualTo(Integer value) {
			addCriterion("owner_id =", value, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdNotEqualTo(Integer value) {
			addCriterion("owner_id <>", value, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdGreaterThan(Integer value) {
			addCriterion("owner_id >", value, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("owner_id >=", value, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdLessThan(Integer value) {
			addCriterion("owner_id <", value, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdLessThanOrEqualTo(Integer value) {
			addCriterion("owner_id <=", value, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdIn(List<Integer> values) {
			addCriterion("owner_id in", values, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdNotIn(List<Integer> values) {
			addCriterion("owner_id not in", values, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdBetween(Integer value1, Integer value2) {
			addCriterion("owner_id between", value1, value2, "ownerId");
			return (Criteria) this;
		}

		public Criteria andOwnerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("owner_id not between", value1, value2, "ownerId");
			return (Criteria) this;
		}

		public Criteria andChargeDateIsNull() {
			addCriterion("charge_date is null");
			return (Criteria) this;
		}

		public Criteria andChargeDateIsNotNull() {
			addCriterion("charge_date is not null");
			return (Criteria) this;
		}

		public Criteria andChargeDateEqualTo(Date value) {
			addCriterion("charge_date =", value, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateNotEqualTo(Date value) {
			addCriterion("charge_date <>", value, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateGreaterThan(Date value) {
			addCriterion("charge_date >", value, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateGreaterThanOrEqualTo(Date value) {
			addCriterion("charge_date >=", value, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateLessThan(Date value) {
			addCriterion("charge_date <", value, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateLessThanOrEqualTo(Date value) {
			addCriterion("charge_date <=", value, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateIn(List<Date> values) {
			addCriterion("charge_date in", values, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateNotIn(List<Date> values) {
			addCriterion("charge_date not in", values, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateBetween(Date value1, Date value2) {
			addCriterion("charge_date between", value1, value2, "chargeDate");
			return (Criteria) this;
		}

		public Criteria andChargeDateNotBetween(Date value1, Date value2) {
			addCriterion("charge_date not between", value1, value2, "chargeDate");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table chargehistory
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
     * This class corresponds to the database table chargehistory
     *
     * @mbg.generated do_not_delete_during_merge Thu Nov 05 14:37:24 KST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}