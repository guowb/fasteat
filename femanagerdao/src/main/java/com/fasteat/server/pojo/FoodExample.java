package com.fasteat.server.pojo;

import java.util.ArrayList;
import java.util.List;

public class FoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodExample() {
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

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("fname is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("fname is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("fname =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("fname <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("fname >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fname >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("fname <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("fname <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("fname like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("fname not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("fname in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("fname not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("fname between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("fname not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNull() {
            addCriterion("fprice is null");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNotNull() {
            addCriterion("fprice is not null");
            return (Criteria) this;
        }

        public Criteria andFpriceEqualTo(Double value) {
            addCriterion("fprice =", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotEqualTo(Double value) {
            addCriterion("fprice <>", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThan(Double value) {
            addCriterion("fprice >", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("fprice >=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThan(Double value) {
            addCriterion("fprice <", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThanOrEqualTo(Double value) {
            addCriterion("fprice <=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceIn(List<Double> values) {
            addCriterion("fprice in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotIn(List<Double> values) {
            addCriterion("fprice not in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceBetween(Double value1, Double value2) {
            addCriterion("fprice between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotBetween(Double value1, Double value2) {
            addCriterion("fprice not between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFdescIsNull() {
            addCriterion("fdesc is null");
            return (Criteria) this;
        }

        public Criteria andFdescIsNotNull() {
            addCriterion("fdesc is not null");
            return (Criteria) this;
        }

        public Criteria andFdescEqualTo(String value) {
            addCriterion("fdesc =", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescNotEqualTo(String value) {
            addCriterion("fdesc <>", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescGreaterThan(String value) {
            addCriterion("fdesc >", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescGreaterThanOrEqualTo(String value) {
            addCriterion("fdesc >=", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescLessThan(String value) {
            addCriterion("fdesc <", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescLessThanOrEqualTo(String value) {
            addCriterion("fdesc <=", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescLike(String value) {
            addCriterion("fdesc like", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescNotLike(String value) {
            addCriterion("fdesc not like", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescIn(List<String> values) {
            addCriterion("fdesc in", values, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescNotIn(List<String> values) {
            addCriterion("fdesc not in", values, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescBetween(String value1, String value2) {
            addCriterion("fdesc between", value1, value2, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescNotBetween(String value1, String value2) {
            addCriterion("fdesc not between", value1, value2, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFnumIsNull() {
            addCriterion("fnum is null");
            return (Criteria) this;
        }

        public Criteria andFnumIsNotNull() {
            addCriterion("fnum is not null");
            return (Criteria) this;
        }

        public Criteria andFnumEqualTo(Integer value) {
            addCriterion("fnum =", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumNotEqualTo(Integer value) {
            addCriterion("fnum <>", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumGreaterThan(Integer value) {
            addCriterion("fnum >", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fnum >=", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumLessThan(Integer value) {
            addCriterion("fnum <", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumLessThanOrEqualTo(Integer value) {
            addCriterion("fnum <=", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumIn(List<Integer> values) {
            addCriterion("fnum in", values, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumNotIn(List<Integer> values) {
            addCriterion("fnum not in", values, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumBetween(Integer value1, Integer value2) {
            addCriterion("fnum between", value1, value2, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumNotBetween(Integer value1, Integer value2) {
            addCriterion("fnum not between", value1, value2, "fnum");
            return (Criteria) this;
        }

        public Criteria andFphotoIsNull() {
            addCriterion("fphoto is null");
            return (Criteria) this;
        }

        public Criteria andFphotoIsNotNull() {
            addCriterion("fphoto is not null");
            return (Criteria) this;
        }

        public Criteria andFphotoEqualTo(String value) {
            addCriterion("fphoto =", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoNotEqualTo(String value) {
            addCriterion("fphoto <>", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoGreaterThan(String value) {
            addCriterion("fphoto >", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoGreaterThanOrEqualTo(String value) {
            addCriterion("fphoto >=", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoLessThan(String value) {
            addCriterion("fphoto <", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoLessThanOrEqualTo(String value) {
            addCriterion("fphoto <=", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoLike(String value) {
            addCriterion("fphoto like", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoNotLike(String value) {
            addCriterion("fphoto not like", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoIn(List<String> values) {
            addCriterion("fphoto in", values, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoNotIn(List<String> values) {
            addCriterion("fphoto not in", values, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoBetween(String value1, String value2) {
            addCriterion("fphoto between", value1, value2, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoNotBetween(String value1, String value2) {
            addCriterion("fphoto not between", value1, value2, "fphoto");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
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