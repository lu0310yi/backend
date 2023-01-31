package com.mypro.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNull() {
            addCriterion("background is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNotNull() {
            addCriterion("background is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundEqualTo(String value) {
            addCriterion("background =", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotEqualTo(String value) {
            addCriterion("background <>", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThan(String value) {
            addCriterion("background >", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("background >=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThan(String value) {
            addCriterion("background <", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThanOrEqualTo(String value) {
            addCriterion("background <=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLike(String value) {
            addCriterion("background like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotLike(String value) {
            addCriterion("background not like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundIn(List<String> values) {
            addCriterion("background in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotIn(List<String> values) {
            addCriterion("background not in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundBetween(String value1, String value2) {
            addCriterion("background between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotBetween(String value1, String value2) {
            addCriterion("background not between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andCountyIdIsNull() {
            addCriterion("county_id is null");
            return (Criteria) this;
        }

        public Criteria andCountyIdIsNotNull() {
            addCriterion("county_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountyIdEqualTo(String value) {
            addCriterion("county_id =", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotEqualTo(String value) {
            addCriterion("county_id <>", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdGreaterThan(String value) {
            addCriterion("county_id >", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdGreaterThanOrEqualTo(String value) {
            addCriterion("county_id >=", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLessThan(String value) {
            addCriterion("county_id <", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLessThanOrEqualTo(String value) {
            addCriterion("county_id <=", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLike(String value) {
            addCriterion("county_id like", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotLike(String value) {
            addCriterion("county_id not like", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdIn(List<String> values) {
            addCriterion("county_id in", values, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotIn(List<String> values) {
            addCriterion("county_id not in", values, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdBetween(String value1, String value2) {
            addCriterion("county_id between", value1, value2, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotBetween(String value1, String value2) {
            addCriterion("county_id not between", value1, value2, "countyId");
            return (Criteria) this;
        }

        public Criteria andGmtBirthIsNull() {
            addCriterion("gmt_birth is null");
            return (Criteria) this;
        }

        public Criteria andGmtBirthIsNotNull() {
            addCriterion("gmt_birth is not null");
            return (Criteria) this;
        }

        public Criteria andGmtBirthEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_birth =", value, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_birth <>", value, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthGreaterThan(Date value) {
            addCriterionForJDBCDate("gmt_birth >", value, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_birth >=", value, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthLessThan(Date value) {
            addCriterionForJDBCDate("gmt_birth <", value, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_birth <=", value, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthIn(List<Date> values) {
            addCriterionForJDBCDate("gmt_birth in", values, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("gmt_birth not in", values, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gmt_birth between", value1, value2, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andGmtBirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gmt_birth not between", value1, value2, "gmtBirth");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpIsNull() {
            addCriterion("gmt_sign_up is null");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpIsNotNull() {
            addCriterion("gmt_sign_up is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpEqualTo(Date value) {
            addCriterion("gmt_sign_up =", value, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpNotEqualTo(Date value) {
            addCriterion("gmt_sign_up <>", value, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpGreaterThan(Date value) {
            addCriterion("gmt_sign_up >", value, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_sign_up >=", value, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpLessThan(Date value) {
            addCriterion("gmt_sign_up <", value, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpLessThanOrEqualTo(Date value) {
            addCriterion("gmt_sign_up <=", value, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpIn(List<Date> values) {
            addCriterion("gmt_sign_up in", values, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpNotIn(List<Date> values) {
            addCriterion("gmt_sign_up not in", values, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpBetween(Date value1, Date value2) {
            addCriterion("gmt_sign_up between", value1, value2, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtSignUpNotBetween(Date value1, Date value2) {
            addCriterion("gmt_sign_up not between", value1, value2, "gmtSignUp");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginIsNull() {
            addCriterion("gmt_last_login is null");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginIsNotNull() {
            addCriterion("gmt_last_login is not null");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginEqualTo(Date value) {
            addCriterion("gmt_last_login =", value, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginNotEqualTo(Date value) {
            addCriterion("gmt_last_login <>", value, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginGreaterThan(Date value) {
            addCriterion("gmt_last_login >", value, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_last_login >=", value, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginLessThan(Date value) {
            addCriterion("gmt_last_login <", value, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginLessThanOrEqualTo(Date value) {
            addCriterion("gmt_last_login <=", value, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginIn(List<Date> values) {
            addCriterion("gmt_last_login in", values, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginNotIn(List<Date> values) {
            addCriterion("gmt_last_login not in", values, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginBetween(Date value1, Date value2) {
            addCriterion("gmt_last_login between", value1, value2, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andGmtLastLoginNotBetween(Date value1, Date value2) {
            addCriterion("gmt_last_login not between", value1, value2, "gmtLastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4IsNull() {
            addCriterion("last_login_ipv4 is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4IsNotNull() {
            addCriterion("last_login_ipv4 is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4EqualTo(String value) {
            addCriterion("last_login_ipv4 =", value, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4NotEqualTo(String value) {
            addCriterion("last_login_ipv4 <>", value, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4GreaterThan(String value) {
            addCriterion("last_login_ipv4 >", value, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4GreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ipv4 >=", value, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4LessThan(String value) {
            addCriterion("last_login_ipv4 <", value, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4LessThanOrEqualTo(String value) {
            addCriterion("last_login_ipv4 <=", value, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4Like(String value) {
            addCriterion("last_login_ipv4 like", value, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4NotLike(String value) {
            addCriterion("last_login_ipv4 not like", value, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4In(List<String> values) {
            addCriterion("last_login_ipv4 in", values, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4NotIn(List<String> values) {
            addCriterion("last_login_ipv4 not in", values, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4Between(String value1, String value2) {
            addCriterion("last_login_ipv4 between", value1, value2, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv4NotBetween(String value1, String value2) {
            addCriterion("last_login_ipv4 not between", value1, value2, "lastLoginIpv4");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6IsNull() {
            addCriterion("last_login_ipv6 is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6IsNotNull() {
            addCriterion("last_login_ipv6 is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6EqualTo(String value) {
            addCriterion("last_login_ipv6 =", value, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6NotEqualTo(String value) {
            addCriterion("last_login_ipv6 <>", value, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6GreaterThan(String value) {
            addCriterion("last_login_ipv6 >", value, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6GreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ipv6 >=", value, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6LessThan(String value) {
            addCriterion("last_login_ipv6 <", value, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6LessThanOrEqualTo(String value) {
            addCriterion("last_login_ipv6 <=", value, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6Like(String value) {
            addCriterion("last_login_ipv6 like", value, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6NotLike(String value) {
            addCriterion("last_login_ipv6 not like", value, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6In(List<String> values) {
            addCriterion("last_login_ipv6 in", values, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6NotIn(List<String> values) {
            addCriterion("last_login_ipv6 not in", values, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6Between(String value1, String value2) {
            addCriterion("last_login_ipv6 between", value1, value2, "lastLoginIpv6");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpv6NotBetween(String value1, String value2) {
            addCriterion("last_login_ipv6 not between", value1, value2, "lastLoginIpv6");
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