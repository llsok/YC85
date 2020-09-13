package com.yc.crbook.bean;

import java.util.ArrayList;
import java.util.List;

public class CrBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrBookExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCategroy1IsNull() {
            addCriterion("categroy1 is null");
            return (Criteria) this;
        }

        public Criteria andCategroy1IsNotNull() {
            addCriterion("categroy1 is not null");
            return (Criteria) this;
        }

        public Criteria andCategroy1EqualTo(String value) {
            addCriterion("categroy1 =", value, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1NotEqualTo(String value) {
            addCriterion("categroy1 <>", value, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1GreaterThan(String value) {
            addCriterion("categroy1 >", value, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1GreaterThanOrEqualTo(String value) {
            addCriterion("categroy1 >=", value, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1LessThan(String value) {
            addCriterion("categroy1 <", value, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1LessThanOrEqualTo(String value) {
            addCriterion("categroy1 <=", value, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1Like(String value) {
            addCriterion("categroy1 like", value, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1NotLike(String value) {
            addCriterion("categroy1 not like", value, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1In(List<String> values) {
            addCriterion("categroy1 in", values, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1NotIn(List<String> values) {
            addCriterion("categroy1 not in", values, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1Between(String value1, String value2) {
            addCriterion("categroy1 between", value1, value2, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy1NotBetween(String value1, String value2) {
            addCriterion("categroy1 not between", value1, value2, "categroy1");
            return (Criteria) this;
        }

        public Criteria andCategroy2IsNull() {
            addCriterion("categroy2 is null");
            return (Criteria) this;
        }

        public Criteria andCategroy2IsNotNull() {
            addCriterion("categroy2 is not null");
            return (Criteria) this;
        }

        public Criteria andCategroy2EqualTo(String value) {
            addCriterion("categroy2 =", value, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2NotEqualTo(String value) {
            addCriterion("categroy2 <>", value, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2GreaterThan(String value) {
            addCriterion("categroy2 >", value, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2GreaterThanOrEqualTo(String value) {
            addCriterion("categroy2 >=", value, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2LessThan(String value) {
            addCriterion("categroy2 <", value, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2LessThanOrEqualTo(String value) {
            addCriterion("categroy2 <=", value, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2Like(String value) {
            addCriterion("categroy2 like", value, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2NotLike(String value) {
            addCriterion("categroy2 not like", value, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2In(List<String> values) {
            addCriterion("categroy2 in", values, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2NotIn(List<String> values) {
            addCriterion("categroy2 not in", values, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2Between(String value1, String value2) {
            addCriterion("categroy2 between", value1, value2, "categroy2");
            return (Criteria) this;
        }

        public Criteria andCategroy2NotBetween(String value1, String value2) {
            addCriterion("categroy2 not between", value1, value2, "categroy2");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNull() {
            addCriterion("publisher is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNotNull() {
            addCriterion("publisher is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherEqualTo(String value) {
            addCriterion("publisher =", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotEqualTo(String value) {
            addCriterion("publisher <>", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThan(String value) {
            addCriterion("publisher >", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("publisher >=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThan(String value) {
            addCriterion("publisher <", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThanOrEqualTo(String value) {
            addCriterion("publisher <=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLike(String value) {
            addCriterion("publisher like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotLike(String value) {
            addCriterion("publisher not like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherIn(List<String> values) {
            addCriterion("publisher in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotIn(List<String> values) {
            addCriterion("publisher not in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherBetween(String value1, String value2) {
            addCriterion("publisher between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotBetween(String value1, String value2) {
            addCriterion("publisher not between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPressDateIsNull() {
            addCriterion("press_date is null");
            return (Criteria) this;
        }

        public Criteria andPressDateIsNotNull() {
            addCriterion("press_date is not null");
            return (Criteria) this;
        }

        public Criteria andPressDateEqualTo(String value) {
            addCriterion("press_date =", value, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateNotEqualTo(String value) {
            addCriterion("press_date <>", value, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateGreaterThan(String value) {
            addCriterion("press_date >", value, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateGreaterThanOrEqualTo(String value) {
            addCriterion("press_date >=", value, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateLessThan(String value) {
            addCriterion("press_date <", value, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateLessThanOrEqualTo(String value) {
            addCriterion("press_date <=", value, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateLike(String value) {
            addCriterion("press_date like", value, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateNotLike(String value) {
            addCriterion("press_date not like", value, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateIn(List<String> values) {
            addCriterion("press_date in", values, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateNotIn(List<String> values) {
            addCriterion("press_date not in", values, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateBetween(String value1, String value2) {
            addCriterion("press_date between", value1, value2, "pressDate");
            return (Criteria) this;
        }

        public Criteria andPressDateNotBetween(String value1, String value2) {
            addCriterion("press_date not between", value1, value2, "pressDate");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNull() {
            addCriterion("isbn is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("isbn is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("isbn =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("isbn <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("isbn >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("isbn >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("isbn <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("isbn <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("isbn like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("isbn not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("isbn in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("isbn not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("isbn between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("isbn not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andPressSnIsNull() {
            addCriterion("press_sn is null");
            return (Criteria) this;
        }

        public Criteria andPressSnIsNotNull() {
            addCriterion("press_sn is not null");
            return (Criteria) this;
        }

        public Criteria andPressSnEqualTo(String value) {
            addCriterion("press_sn =", value, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnNotEqualTo(String value) {
            addCriterion("press_sn <>", value, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnGreaterThan(String value) {
            addCriterion("press_sn >", value, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnGreaterThanOrEqualTo(String value) {
            addCriterion("press_sn >=", value, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnLessThan(String value) {
            addCriterion("press_sn <", value, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnLessThanOrEqualTo(String value) {
            addCriterion("press_sn <=", value, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnLike(String value) {
            addCriterion("press_sn like", value, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnNotLike(String value) {
            addCriterion("press_sn not like", value, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnIn(List<String> values) {
            addCriterion("press_sn in", values, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnNotIn(List<String> values) {
            addCriterion("press_sn not in", values, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnBetween(String value1, String value2) {
            addCriterion("press_sn between", value1, value2, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPressSnNotBetween(String value1, String value2) {
            addCriterion("press_sn not between", value1, value2, "pressSn");
            return (Criteria) this;
        }

        public Criteria andPagesIsNull() {
            addCriterion("pages is null");
            return (Criteria) this;
        }

        public Criteria andPagesIsNotNull() {
            addCriterion("pages is not null");
            return (Criteria) this;
        }

        public Criteria andPagesEqualTo(String value) {
            addCriterion("pages =", value, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesNotEqualTo(String value) {
            addCriterion("pages <>", value, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesGreaterThan(String value) {
            addCriterion("pages >", value, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesGreaterThanOrEqualTo(String value) {
            addCriterion("pages >=", value, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesLessThan(String value) {
            addCriterion("pages <", value, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesLessThanOrEqualTo(String value) {
            addCriterion("pages <=", value, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesLike(String value) {
            addCriterion("pages like", value, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesNotLike(String value) {
            addCriterion("pages not like", value, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesIn(List<String> values) {
            addCriterion("pages in", values, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesNotIn(List<String> values) {
            addCriterion("pages not in", values, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesBetween(String value1, String value2) {
            addCriterion("pages between", value1, value2, "pages");
            return (Criteria) this;
        }

        public Criteria andPagesNotBetween(String value1, String value2) {
            addCriterion("pages not between", value1, value2, "pages");
            return (Criteria) this;
        }

        public Criteria andWordsIsNull() {
            addCriterion("words is null");
            return (Criteria) this;
        }

        public Criteria andWordsIsNotNull() {
            addCriterion("words is not null");
            return (Criteria) this;
        }

        public Criteria andWordsEqualTo(String value) {
            addCriterion("words =", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotEqualTo(String value) {
            addCriterion("words <>", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsGreaterThan(String value) {
            addCriterion("words >", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsGreaterThanOrEqualTo(String value) {
            addCriterion("words >=", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLessThan(String value) {
            addCriterion("words <", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLessThanOrEqualTo(String value) {
            addCriterion("words <=", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLike(String value) {
            addCriterion("words like", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotLike(String value) {
            addCriterion("words not like", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsIn(List<String> values) {
            addCriterion("words in", values, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotIn(List<String> values) {
            addCriterion("words not in", values, "words");
            return (Criteria) this;
        }

        public Criteria andWordsBetween(String value1, String value2) {
            addCriterion("words between", value1, value2, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotBetween(String value1, String value2) {
            addCriterion("words not between", value1, value2, "words");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIsNull() {
            addCriterion("print_time is null");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIsNotNull() {
            addCriterion("print_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrintTimeEqualTo(String value) {
            addCriterion("print_time =", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotEqualTo(String value) {
            addCriterion("print_time <>", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeGreaterThan(String value) {
            addCriterion("print_time >", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeGreaterThanOrEqualTo(String value) {
            addCriterion("print_time >=", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeLessThan(String value) {
            addCriterion("print_time <", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeLessThanOrEqualTo(String value) {
            addCriterion("print_time <=", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeLike(String value) {
            addCriterion("print_time like", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotLike(String value) {
            addCriterion("print_time not like", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIn(List<String> values) {
            addCriterion("print_time in", values, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotIn(List<String> values) {
            addCriterion("print_time not in", values, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeBetween(String value1, String value2) {
            addCriterion("print_time between", value1, value2, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotBetween(String value1, String value2) {
            addCriterion("print_time not between", value1, value2, "printTime");
            return (Criteria) this;
        }

        public Criteria andBookSizeIsNull() {
            addCriterion("book_size is null");
            return (Criteria) this;
        }

        public Criteria andBookSizeIsNotNull() {
            addCriterion("book_size is not null");
            return (Criteria) this;
        }

        public Criteria andBookSizeEqualTo(String value) {
            addCriterion("book_size =", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotEqualTo(String value) {
            addCriterion("book_size <>", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeGreaterThan(String value) {
            addCriterion("book_size >", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeGreaterThanOrEqualTo(String value) {
            addCriterion("book_size >=", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLessThan(String value) {
            addCriterion("book_size <", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLessThanOrEqualTo(String value) {
            addCriterion("book_size <=", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLike(String value) {
            addCriterion("book_size like", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotLike(String value) {
            addCriterion("book_size not like", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeIn(List<String> values) {
            addCriterion("book_size in", values, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotIn(List<String> values) {
            addCriterion("book_size not in", values, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeBetween(String value1, String value2) {
            addCriterion("book_size between", value1, value2, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotBetween(String value1, String value2) {
            addCriterion("book_size not between", value1, value2, "bookSize");
            return (Criteria) this;
        }

        public Criteria andPrintSnIsNull() {
            addCriterion("print_sn is null");
            return (Criteria) this;
        }

        public Criteria andPrintSnIsNotNull() {
            addCriterion("print_sn is not null");
            return (Criteria) this;
        }

        public Criteria andPrintSnEqualTo(String value) {
            addCriterion("print_sn =", value, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnNotEqualTo(String value) {
            addCriterion("print_sn <>", value, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnGreaterThan(String value) {
            addCriterion("print_sn >", value, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnGreaterThanOrEqualTo(String value) {
            addCriterion("print_sn >=", value, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnLessThan(String value) {
            addCriterion("print_sn <", value, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnLessThanOrEqualTo(String value) {
            addCriterion("print_sn <=", value, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnLike(String value) {
            addCriterion("print_sn like", value, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnNotLike(String value) {
            addCriterion("print_sn not like", value, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnIn(List<String> values) {
            addCriterion("print_sn in", values, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnNotIn(List<String> values) {
            addCriterion("print_sn not in", values, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnBetween(String value1, String value2) {
            addCriterion("print_sn between", value1, value2, "printSn");
            return (Criteria) this;
        }

        public Criteria andPrintSnNotBetween(String value1, String value2) {
            addCriterion("print_sn not between", value1, value2, "printSn");
            return (Criteria) this;
        }

        public Criteria andPackingIsNull() {
            addCriterion("packing is null");
            return (Criteria) this;
        }

        public Criteria andPackingIsNotNull() {
            addCriterion("packing is not null");
            return (Criteria) this;
        }

        public Criteria andPackingEqualTo(String value) {
            addCriterion("packing =", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotEqualTo(String value) {
            addCriterion("packing <>", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingGreaterThan(String value) {
            addCriterion("packing >", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingGreaterThanOrEqualTo(String value) {
            addCriterion("packing >=", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLessThan(String value) {
            addCriterion("packing <", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLessThanOrEqualTo(String value) {
            addCriterion("packing <=", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLike(String value) {
            addCriterion("packing like", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotLike(String value) {
            addCriterion("packing not like", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingIn(List<String> values) {
            addCriterion("packing in", values, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotIn(List<String> values) {
            addCriterion("packing not in", values, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingBetween(String value1, String value2) {
            addCriterion("packing between", value1, value2, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotBetween(String value1, String value2) {
            addCriterion("packing not between", value1, value2, "packing");
            return (Criteria) this;
        }

        public Criteria andFormatIsNull() {
            addCriterion("format is null");
            return (Criteria) this;
        }

        public Criteria andFormatIsNotNull() {
            addCriterion("format is not null");
            return (Criteria) this;
        }

        public Criteria andFormatEqualTo(String value) {
            addCriterion("format =", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotEqualTo(String value) {
            addCriterion("format <>", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatGreaterThan(String value) {
            addCriterion("format >", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatGreaterThanOrEqualTo(String value) {
            addCriterion("format >=", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLessThan(String value) {
            addCriterion("format <", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLessThanOrEqualTo(String value) {
            addCriterion("format <=", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLike(String value) {
            addCriterion("format like", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotLike(String value) {
            addCriterion("format not like", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatIn(List<String> values) {
            addCriterion("format in", values, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotIn(List<String> values) {
            addCriterion("format not in", values, "format");
            return (Criteria) this;
        }

        public Criteria andFormatBetween(String value1, String value2) {
            addCriterion("format between", value1, value2, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotBetween(String value1, String value2) {
            addCriterion("format not between", value1, value2, "format");
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