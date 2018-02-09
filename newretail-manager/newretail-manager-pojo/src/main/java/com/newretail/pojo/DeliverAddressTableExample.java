package com.newretail.pojo;

import java.util.ArrayList;
import java.util.List;

public class DeliverAddressTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliverAddressTableExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqIsNull() {
            addCriterion("deliver_address_seq is null");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqIsNotNull() {
            addCriterion("deliver_address_seq is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqEqualTo(String value) {
            addCriterion("deliver_address_seq =", value, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqNotEqualTo(String value) {
            addCriterion("deliver_address_seq <>", value, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqGreaterThan(String value) {
            addCriterion("deliver_address_seq >", value, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_address_seq >=", value, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqLessThan(String value) {
            addCriterion("deliver_address_seq <", value, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqLessThanOrEqualTo(String value) {
            addCriterion("deliver_address_seq <=", value, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqLike(String value) {
            addCriterion("deliver_address_seq like", value, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqNotLike(String value) {
            addCriterion("deliver_address_seq not like", value, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqIn(List<String> values) {
            addCriterion("deliver_address_seq in", values, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqNotIn(List<String> values) {
            addCriterion("deliver_address_seq not in", values, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqBetween(String value1, String value2) {
            addCriterion("deliver_address_seq between", value1, value2, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressSeqNotBetween(String value1, String value2) {
            addCriterion("deliver_address_seq not between", value1, value2, "deliverAddressSeq");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressIsNull() {
            addCriterion("deliver_address is null");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressIsNotNull() {
            addCriterion("deliver_address is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressEqualTo(String value) {
            addCriterion("deliver_address =", value, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressNotEqualTo(String value) {
            addCriterion("deliver_address <>", value, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressGreaterThan(String value) {
            addCriterion("deliver_address >", value, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_address >=", value, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressLessThan(String value) {
            addCriterion("deliver_address <", value, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressLessThanOrEqualTo(String value) {
            addCriterion("deliver_address <=", value, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressLike(String value) {
            addCriterion("deliver_address like", value, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressNotLike(String value) {
            addCriterion("deliver_address not like", value, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressIn(List<String> values) {
            addCriterion("deliver_address in", values, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressNotIn(List<String> values) {
            addCriterion("deliver_address not in", values, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressBetween(String value1, String value2) {
            addCriterion("deliver_address between", value1, value2, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andDeliverAddressNotBetween(String value1, String value2) {
            addCriterion("deliver_address not between", value1, value2, "deliverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNull() {
            addCriterion("receiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNotNull() {
            addCriterion("receiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            addCriterion("receiver_phone =", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            addCriterion("receiver_phone <>", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            addCriterion("receiver_phone >", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_phone >=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            addCriterion("receiver_phone <", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("receiver_phone <=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLike(String value) {
            addCriterion("receiver_phone like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            addCriterion("receiver_phone not like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            addCriterion("receiver_phone in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            addCriterion("receiver_phone not in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            addCriterion("receiver_phone between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            addCriterion("receiver_phone not between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}