package com.yc.crbook.bean;

import java.util.ArrayList;
import java.util.List;

public class CrShowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrShowExample() {
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

        public Criteria andPageIsNull() {
            addCriterion("page is null");
            return (Criteria) this;
        }

        public Criteria andPageIsNotNull() {
            addCriterion("page is not null");
            return (Criteria) this;
        }

        public Criteria andPageEqualTo(String value) {
            addCriterion("page =", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotEqualTo(String value) {
            addCriterion("page <>", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThan(String value) {
            addCriterion("page >", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThanOrEqualTo(String value) {
            addCriterion("page >=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThan(String value) {
            addCriterion("page <", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThanOrEqualTo(String value) {
            addCriterion("page <=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLike(String value) {
            addCriterion("page like", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotLike(String value) {
            addCriterion("page not like", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageIn(List<String> values) {
            addCriterion("page in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotIn(List<String> values) {
            addCriterion("page not in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageBetween(String value1, String value2) {
            addCriterion("page between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotBetween(String value1, String value2) {
            addCriterion("page not between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andBoardIsNull() {
            addCriterion("board is null");
            return (Criteria) this;
        }

        public Criteria andBoardIsNotNull() {
            addCriterion("board is not null");
            return (Criteria) this;
        }

        public Criteria andBoardEqualTo(String value) {
            addCriterion("board =", value, "board");
            return (Criteria) this;
        }

        public Criteria andBoardNotEqualTo(String value) {
            addCriterion("board <>", value, "board");
            return (Criteria) this;
        }

        public Criteria andBoardGreaterThan(String value) {
            addCriterion("board >", value, "board");
            return (Criteria) this;
        }

        public Criteria andBoardGreaterThanOrEqualTo(String value) {
            addCriterion("board >=", value, "board");
            return (Criteria) this;
        }

        public Criteria andBoardLessThan(String value) {
            addCriterion("board <", value, "board");
            return (Criteria) this;
        }

        public Criteria andBoardLessThanOrEqualTo(String value) {
            addCriterion("board <=", value, "board");
            return (Criteria) this;
        }

        public Criteria andBoardLike(String value) {
            addCriterion("board like", value, "board");
            return (Criteria) this;
        }

        public Criteria andBoardNotLike(String value) {
            addCriterion("board not like", value, "board");
            return (Criteria) this;
        }

        public Criteria andBoardIn(List<String> values) {
            addCriterion("board in", values, "board");
            return (Criteria) this;
        }

        public Criteria andBoardNotIn(List<String> values) {
            addCriterion("board not in", values, "board");
            return (Criteria) this;
        }

        public Criteria andBoardBetween(String value1, String value2) {
            addCriterion("board between", value1, value2, "board");
            return (Criteria) this;
        }

        public Criteria andBoardNotBetween(String value1, String value2) {
            addCriterion("board not between", value1, value2, "board");
            return (Criteria) this;
        }

        public Criteria andRelatbIsNull() {
            addCriterion("relatb is null");
            return (Criteria) this;
        }

        public Criteria andRelatbIsNotNull() {
            addCriterion("relatb is not null");
            return (Criteria) this;
        }

        public Criteria andRelatbEqualTo(String value) {
            addCriterion("relatb =", value, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbNotEqualTo(String value) {
            addCriterion("relatb <>", value, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbGreaterThan(String value) {
            addCriterion("relatb >", value, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbGreaterThanOrEqualTo(String value) {
            addCriterion("relatb >=", value, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbLessThan(String value) {
            addCriterion("relatb <", value, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbLessThanOrEqualTo(String value) {
            addCriterion("relatb <=", value, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbLike(String value) {
            addCriterion("relatb like", value, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbNotLike(String value) {
            addCriterion("relatb not like", value, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbIn(List<String> values) {
            addCriterion("relatb in", values, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbNotIn(List<String> values) {
            addCriterion("relatb not in", values, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbBetween(String value1, String value2) {
            addCriterion("relatb between", value1, value2, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelatbNotBetween(String value1, String value2) {
            addCriterion("relatb not between", value1, value2, "relatb");
            return (Criteria) this;
        }

        public Criteria andRelaidIsNull() {
            addCriterion("relaid is null");
            return (Criteria) this;
        }

        public Criteria andRelaidIsNotNull() {
            addCriterion("relaid is not null");
            return (Criteria) this;
        }

        public Criteria andRelaidEqualTo(Integer value) {
            addCriterion("relaid =", value, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidNotEqualTo(Integer value) {
            addCriterion("relaid <>", value, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidGreaterThan(Integer value) {
            addCriterion("relaid >", value, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("relaid >=", value, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidLessThan(Integer value) {
            addCriterion("relaid <", value, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidLessThanOrEqualTo(Integer value) {
            addCriterion("relaid <=", value, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidIn(List<Integer> values) {
            addCriterion("relaid in", values, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidNotIn(List<Integer> values) {
            addCriterion("relaid not in", values, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidBetween(Integer value1, Integer value2) {
            addCriterion("relaid between", value1, value2, "relaid");
            return (Criteria) this;
        }

        public Criteria andRelaidNotBetween(Integer value1, Integer value2) {
            addCriterion("relaid not between", value1, value2, "relaid");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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