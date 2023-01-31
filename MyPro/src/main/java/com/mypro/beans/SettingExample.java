package com.mypro.beans;

import java.util.ArrayList;
import java.util.List;

public class SettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettingExample() {
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

        public Criteria andFollowVisibleIsNull() {
            addCriterion("follow_visible is null");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleIsNotNull() {
            addCriterion("follow_visible is not null");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleEqualTo(Byte value) {
            addCriterion("follow_visible =", value, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleNotEqualTo(Byte value) {
            addCriterion("follow_visible <>", value, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleGreaterThan(Byte value) {
            addCriterion("follow_visible >", value, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("follow_visible >=", value, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleLessThan(Byte value) {
            addCriterion("follow_visible <", value, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleLessThanOrEqualTo(Byte value) {
            addCriterion("follow_visible <=", value, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleIn(List<Byte> values) {
            addCriterion("follow_visible in", values, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleNotIn(List<Byte> values) {
            addCriterion("follow_visible not in", values, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleBetween(Byte value1, Byte value2) {
            addCriterion("follow_visible between", value1, value2, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFollowVisibleNotBetween(Byte value1, Byte value2) {
            addCriterion("follow_visible not between", value1, value2, "followVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleIsNull() {
            addCriterion("fans_visible is null");
            return (Criteria) this;
        }

        public Criteria andFansVisibleIsNotNull() {
            addCriterion("fans_visible is not null");
            return (Criteria) this;
        }

        public Criteria andFansVisibleEqualTo(Byte value) {
            addCriterion("fans_visible =", value, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleNotEqualTo(Byte value) {
            addCriterion("fans_visible <>", value, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleGreaterThan(Byte value) {
            addCriterion("fans_visible >", value, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("fans_visible >=", value, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleLessThan(Byte value) {
            addCriterion("fans_visible <", value, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleLessThanOrEqualTo(Byte value) {
            addCriterion("fans_visible <=", value, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleIn(List<Byte> values) {
            addCriterion("fans_visible in", values, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleNotIn(List<Byte> values) {
            addCriterion("fans_visible not in", values, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleBetween(Byte value1, Byte value2) {
            addCriterion("fans_visible between", value1, value2, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andFansVisibleNotBetween(Byte value1, Byte value2) {
            addCriterion("fans_visible not between", value1, value2, "fansVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleIsNull() {
            addCriterion("visited_visible is null");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleIsNotNull() {
            addCriterion("visited_visible is not null");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleEqualTo(Byte value) {
            addCriterion("visited_visible =", value, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleNotEqualTo(Byte value) {
            addCriterion("visited_visible <>", value, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleGreaterThan(Byte value) {
            addCriterion("visited_visible >", value, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("visited_visible >=", value, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleLessThan(Byte value) {
            addCriterion("visited_visible <", value, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleLessThanOrEqualTo(Byte value) {
            addCriterion("visited_visible <=", value, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleIn(List<Byte> values) {
            addCriterion("visited_visible in", values, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleNotIn(List<Byte> values) {
            addCriterion("visited_visible not in", values, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleBetween(Byte value1, Byte value2) {
            addCriterion("visited_visible between", value1, value2, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andVisitedVisibleNotBetween(Byte value1, Byte value2) {
            addCriterion("visited_visible not between", value1, value2, "visitedVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleIsNull() {
            addCriterion("want_visible is null");
            return (Criteria) this;
        }

        public Criteria andWantVisibleIsNotNull() {
            addCriterion("want_visible is not null");
            return (Criteria) this;
        }

        public Criteria andWantVisibleEqualTo(Byte value) {
            addCriterion("want_visible =", value, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleNotEqualTo(Byte value) {
            addCriterion("want_visible <>", value, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleGreaterThan(Byte value) {
            addCriterion("want_visible >", value, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("want_visible >=", value, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleLessThan(Byte value) {
            addCriterion("want_visible <", value, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleLessThanOrEqualTo(Byte value) {
            addCriterion("want_visible <=", value, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleIn(List<Byte> values) {
            addCriterion("want_visible in", values, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleNotIn(List<Byte> values) {
            addCriterion("want_visible not in", values, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleBetween(Byte value1, Byte value2) {
            addCriterion("want_visible between", value1, value2, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andWantVisibleNotBetween(Byte value1, Byte value2) {
            addCriterion("want_visible not between", value1, value2, "wantVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleIsNull() {
            addCriterion("location_visible is null");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleIsNotNull() {
            addCriterion("location_visible is not null");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleEqualTo(Byte value) {
            addCriterion("location_visible =", value, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleNotEqualTo(Byte value) {
            addCriterion("location_visible <>", value, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleGreaterThan(Byte value) {
            addCriterion("location_visible >", value, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("location_visible >=", value, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleLessThan(Byte value) {
            addCriterion("location_visible <", value, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleLessThanOrEqualTo(Byte value) {
            addCriterion("location_visible <=", value, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleIn(List<Byte> values) {
            addCriterion("location_visible in", values, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleNotIn(List<Byte> values) {
            addCriterion("location_visible not in", values, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleBetween(Byte value1, Byte value2) {
            addCriterion("location_visible between", value1, value2, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andLocationVisibleNotBetween(Byte value1, Byte value2) {
            addCriterion("location_visible not between", value1, value2, "locationVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleIsNull() {
            addCriterion("thumbup_visible is null");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleIsNotNull() {
            addCriterion("thumbup_visible is not null");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleEqualTo(Byte value) {
            addCriterion("thumbup_visible =", value, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleNotEqualTo(Byte value) {
            addCriterion("thumbup_visible <>", value, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleGreaterThan(Byte value) {
            addCriterion("thumbup_visible >", value, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("thumbup_visible >=", value, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleLessThan(Byte value) {
            addCriterion("thumbup_visible <", value, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleLessThanOrEqualTo(Byte value) {
            addCriterion("thumbup_visible <=", value, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleIn(List<Byte> values) {
            addCriterion("thumbup_visible in", values, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleNotIn(List<Byte> values) {
            addCriterion("thumbup_visible not in", values, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleBetween(Byte value1, Byte value2) {
            addCriterion("thumbup_visible between", value1, value2, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andThumbupVisibleNotBetween(Byte value1, Byte value2) {
            addCriterion("thumbup_visible not between", value1, value2, "thumbupVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleIsNull() {
            addCriterion("favorites_visible is null");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleIsNotNull() {
            addCriterion("favorites_visible is not null");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleEqualTo(Byte value) {
            addCriterion("favorites_visible =", value, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleNotEqualTo(Byte value) {
            addCriterion("favorites_visible <>", value, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleGreaterThan(Byte value) {
            addCriterion("favorites_visible >", value, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("favorites_visible >=", value, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleLessThan(Byte value) {
            addCriterion("favorites_visible <", value, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleLessThanOrEqualTo(Byte value) {
            addCriterion("favorites_visible <=", value, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleIn(List<Byte> values) {
            addCriterion("favorites_visible in", values, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleNotIn(List<Byte> values) {
            addCriterion("favorites_visible not in", values, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleBetween(Byte value1, Byte value2) {
            addCriterion("favorites_visible between", value1, value2, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andFavoritesVisibleNotBetween(Byte value1, Byte value2) {
            addCriterion("favorites_visible not between", value1, value2, "favoritesVisible");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicIsNull() {
            addCriterion("default_favorites_public is null");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicIsNotNull() {
            addCriterion("default_favorites_public is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicEqualTo(Byte value) {
            addCriterion("default_favorites_public =", value, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicNotEqualTo(Byte value) {
            addCriterion("default_favorites_public <>", value, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicGreaterThan(Byte value) {
            addCriterion("default_favorites_public >", value, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicGreaterThanOrEqualTo(Byte value) {
            addCriterion("default_favorites_public >=", value, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicLessThan(Byte value) {
            addCriterion("default_favorites_public <", value, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicLessThanOrEqualTo(Byte value) {
            addCriterion("default_favorites_public <=", value, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicIn(List<Byte> values) {
            addCriterion("default_favorites_public in", values, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicNotIn(List<Byte> values) {
            addCriterion("default_favorites_public not in", values, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicBetween(Byte value1, Byte value2) {
            addCriterion("default_favorites_public between", value1, value2, "defaultFavoritesPublic");
            return (Criteria) this;
        }

        public Criteria andDefaultFavoritesPublicNotBetween(Byte value1, Byte value2) {
            addCriterion("default_favorites_public not between", value1, value2, "defaultFavoritesPublic");
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