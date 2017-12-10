package com.fasteat.server.pojo;

import java.util.ArrayList;
import java.util.List;

public class RestaurantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RestaurantExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("rname is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("rname is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("rname =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("rname <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("rname >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("rname >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("rname <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("rname <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("rname like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("rname not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("rname in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("rname not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("rname between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("rname not between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRphoneIsNull() {
            addCriterion("rphone is null");
            return (Criteria) this;
        }

        public Criteria andRphoneIsNotNull() {
            addCriterion("rphone is not null");
            return (Criteria) this;
        }

        public Criteria andRphoneEqualTo(Long value) {
            addCriterion("rphone =", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotEqualTo(Long value) {
            addCriterion("rphone <>", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneGreaterThan(Long value) {
            addCriterion("rphone >", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneGreaterThanOrEqualTo(Long value) {
            addCriterion("rphone >=", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneLessThan(Long value) {
            addCriterion("rphone <", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneLessThanOrEqualTo(Long value) {
            addCriterion("rphone <=", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneIn(List<Long> values) {
            addCriterion("rphone in", values, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotIn(List<Long> values) {
            addCriterion("rphone not in", values, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneBetween(Long value1, Long value2) {
            addCriterion("rphone between", value1, value2, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotBetween(Long value1, Long value2) {
            addCriterion("rphone not between", value1, value2, "rphone");
            return (Criteria) this;
        }

        public Criteria andRcodeIsNull() {
            addCriterion("rcode is null");
            return (Criteria) this;
        }

        public Criteria andRcodeIsNotNull() {
            addCriterion("rcode is not null");
            return (Criteria) this;
        }

        public Criteria andRcodeEqualTo(String value) {
            addCriterion("rcode =", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeNotEqualTo(String value) {
            addCriterion("rcode <>", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeGreaterThan(String value) {
            addCriterion("rcode >", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeGreaterThanOrEqualTo(String value) {
            addCriterion("rcode >=", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeLessThan(String value) {
            addCriterion("rcode <", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeLessThanOrEqualTo(String value) {
            addCriterion("rcode <=", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeLike(String value) {
            addCriterion("rcode like", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeNotLike(String value) {
            addCriterion("rcode not like", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeIn(List<String> values) {
            addCriterion("rcode in", values, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeNotIn(List<String> values) {
            addCriterion("rcode not in", values, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeBetween(String value1, String value2) {
            addCriterion("rcode between", value1, value2, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeNotBetween(String value1, String value2) {
            addCriterion("rcode not between", value1, value2, "rcode");
            return (Criteria) this;
        }

        public Criteria andRdescIsNull() {
            addCriterion("rdesc is null");
            return (Criteria) this;
        }

        public Criteria andRdescIsNotNull() {
            addCriterion("rdesc is not null");
            return (Criteria) this;
        }

        public Criteria andRdescEqualTo(String value) {
            addCriterion("rdesc =", value, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescNotEqualTo(String value) {
            addCriterion("rdesc <>", value, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescGreaterThan(String value) {
            addCriterion("rdesc >", value, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescGreaterThanOrEqualTo(String value) {
            addCriterion("rdesc >=", value, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescLessThan(String value) {
            addCriterion("rdesc <", value, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescLessThanOrEqualTo(String value) {
            addCriterion("rdesc <=", value, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescLike(String value) {
            addCriterion("rdesc like", value, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescNotLike(String value) {
            addCriterion("rdesc not like", value, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescIn(List<String> values) {
            addCriterion("rdesc in", values, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescNotIn(List<String> values) {
            addCriterion("rdesc not in", values, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescBetween(String value1, String value2) {
            addCriterion("rdesc between", value1, value2, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRdescNotBetween(String value1, String value2) {
            addCriterion("rdesc not between", value1, value2, "rdesc");
            return (Criteria) this;
        }

        public Criteria andRmaxdayIsNull() {
            addCriterion("rmaxday is null");
            return (Criteria) this;
        }

        public Criteria andRmaxdayIsNotNull() {
            addCriterion("rmaxday is not null");
            return (Criteria) this;
        }

        public Criteria andRmaxdayEqualTo(Long value) {
            addCriterion("rmaxday =", value, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayNotEqualTo(Long value) {
            addCriterion("rmaxday <>", value, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayGreaterThan(Long value) {
            addCriterion("rmaxday >", value, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayGreaterThanOrEqualTo(Long value) {
            addCriterion("rmaxday >=", value, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayLessThan(Long value) {
            addCriterion("rmaxday <", value, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayLessThanOrEqualTo(Long value) {
            addCriterion("rmaxday <=", value, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayIn(List<Long> values) {
            addCriterion("rmaxday in", values, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayNotIn(List<Long> values) {
            addCriterion("rmaxday not in", values, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayBetween(Long value1, Long value2) {
            addCriterion("rmaxday between", value1, value2, "rmaxday");
            return (Criteria) this;
        }

        public Criteria andRmaxdayNotBetween(Long value1, Long value2) {
            addCriterion("rmaxday not between", value1, value2, "rmaxday");
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