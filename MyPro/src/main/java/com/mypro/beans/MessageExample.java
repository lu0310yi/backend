package com.mypro.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Long value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Long value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Long value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Long value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Long value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Long> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Long> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Long value1, Long value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Long value1, Long value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(Long value) {
            addCriterion("object_id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(Long value) {
            addCriterion("object_id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(Long value) {
            addCriterion("object_id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("object_id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(Long value) {
            addCriterion("object_id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("object_id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<Long> values) {
            addCriterion("object_id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<Long> values) {
            addCriterion("object_id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(Long value1, Long value2) {
            addCriterion("object_id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("object_id not between", value1, value2, "objectId");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andGmtTimeIsNull() {
            addCriterion("gmt_time is null");
            return (Criteria) this;
        }

        public Criteria andGmtTimeIsNotNull() {
            addCriterion("gmt_time is not null");
            return (Criteria) this;
        }

        public Criteria andGmtTimeEqualTo(Date value) {
            addCriterion("gmt_time =", value, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeNotEqualTo(Date value) {
            addCriterion("gmt_time <>", value, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeGreaterThan(Date value) {
            addCriterion("gmt_time >", value, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_time >=", value, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeLessThan(Date value) {
            addCriterion("gmt_time <", value, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeLessThanOrEqualTo(Date value) {
            addCriterion("gmt_time <=", value, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeIn(List<Date> values) {
            addCriterion("gmt_time in", values, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeNotIn(List<Date> values) {
            addCriterion("gmt_time not in", values, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeBetween(Date value1, Date value2) {
            addCriterion("gmt_time between", value1, value2, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andGmtTimeNotBetween(Date value1, Date value2) {
            addCriterion("gmt_time not between", value1, value2, "gmtTime");
            return (Criteria) this;
        }

        public Criteria andNamecardIdIsNull() {
            addCriterion("namecard_id is null");
            return (Criteria) this;
        }

        public Criteria andNamecardIdIsNotNull() {
            addCriterion("namecard_id is not null");
            return (Criteria) this;
        }

        public Criteria andNamecardIdEqualTo(Long value) {
            addCriterion("namecard_id =", value, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdNotEqualTo(Long value) {
            addCriterion("namecard_id <>", value, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdGreaterThan(Long value) {
            addCriterion("namecard_id >", value, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("namecard_id >=", value, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdLessThan(Long value) {
            addCriterion("namecard_id <", value, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdLessThanOrEqualTo(Long value) {
            addCriterion("namecard_id <=", value, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdIn(List<Long> values) {
            addCriterion("namecard_id in", values, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdNotIn(List<Long> values) {
            addCriterion("namecard_id not in", values, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdBetween(Long value1, Long value2) {
            addCriterion("namecard_id between", value1, value2, "namecardId");
            return (Criteria) this;
        }

        public Criteria andNamecardIdNotBetween(Long value1, Long value2) {
            addCriterion("namecard_id not between", value1, value2, "namecardId");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Integer value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Integer value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Integer value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Integer value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Integer value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Integer> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Integer> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Integer value1, Integer value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andLocationNameIsNull() {
            addCriterion("location_name is null");
            return (Criteria) this;
        }

        public Criteria andLocationNameIsNotNull() {
            addCriterion("location_name is not null");
            return (Criteria) this;
        }

        public Criteria andLocationNameEqualTo(String value) {
            addCriterion("location_name =", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotEqualTo(String value) {
            addCriterion("location_name <>", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameGreaterThan(String value) {
            addCriterion("location_name >", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameGreaterThanOrEqualTo(String value) {
            addCriterion("location_name >=", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLessThan(String value) {
            addCriterion("location_name <", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLessThanOrEqualTo(String value) {
            addCriterion("location_name <=", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLike(String value) {
            addCriterion("location_name like", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotLike(String value) {
            addCriterion("location_name not like", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameIn(List<String> values) {
            addCriterion("location_name in", values, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotIn(List<String> values) {
            addCriterion("location_name not in", values, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameBetween(String value1, String value2) {
            addCriterion("location_name between", value1, value2, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotBetween(String value1, String value2) {
            addCriterion("location_name not between", value1, value2, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationDetailIsNull() {
            addCriterion("location_detail is null");
            return (Criteria) this;
        }

        public Criteria andLocationDetailIsNotNull() {
            addCriterion("location_detail is not null");
            return (Criteria) this;
        }

        public Criteria andLocationDetailEqualTo(String value) {
            addCriterion("location_detail =", value, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailNotEqualTo(String value) {
            addCriterion("location_detail <>", value, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailGreaterThan(String value) {
            addCriterion("location_detail >", value, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailGreaterThanOrEqualTo(String value) {
            addCriterion("location_detail >=", value, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailLessThan(String value) {
            addCriterion("location_detail <", value, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailLessThanOrEqualTo(String value) {
            addCriterion("location_detail <=", value, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailLike(String value) {
            addCriterion("location_detail like", value, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailNotLike(String value) {
            addCriterion("location_detail not like", value, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailIn(List<String> values) {
            addCriterion("location_detail in", values, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailNotIn(List<String> values) {
            addCriterion("location_detail not in", values, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailBetween(String value1, String value2) {
            addCriterion("location_detail between", value1, value2, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationDetailNotBetween(String value1, String value2) {
            addCriterion("location_detail not between", value1, value2, "locationDetail");
            return (Criteria) this;
        }

        public Criteria andLocationLatIsNull() {
            addCriterion("location_lat is null");
            return (Criteria) this;
        }

        public Criteria andLocationLatIsNotNull() {
            addCriterion("location_lat is not null");
            return (Criteria) this;
        }

        public Criteria andLocationLatEqualTo(Double value) {
            addCriterion("location_lat =", value, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatNotEqualTo(Double value) {
            addCriterion("location_lat <>", value, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatGreaterThan(Double value) {
            addCriterion("location_lat >", value, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatGreaterThanOrEqualTo(Double value) {
            addCriterion("location_lat >=", value, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatLessThan(Double value) {
            addCriterion("location_lat <", value, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatLessThanOrEqualTo(Double value) {
            addCriterion("location_lat <=", value, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatIn(List<Double> values) {
            addCriterion("location_lat in", values, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatNotIn(List<Double> values) {
            addCriterion("location_lat not in", values, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatBetween(Double value1, Double value2) {
            addCriterion("location_lat between", value1, value2, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLatNotBetween(Double value1, Double value2) {
            addCriterion("location_lat not between", value1, value2, "locationLat");
            return (Criteria) this;
        }

        public Criteria andLocationLngIsNull() {
            addCriterion("location_lng is null");
            return (Criteria) this;
        }

        public Criteria andLocationLngIsNotNull() {
            addCriterion("location_lng is not null");
            return (Criteria) this;
        }

        public Criteria andLocationLngEqualTo(Double value) {
            addCriterion("location_lng =", value, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngNotEqualTo(Double value) {
            addCriterion("location_lng <>", value, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngGreaterThan(Double value) {
            addCriterion("location_lng >", value, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngGreaterThanOrEqualTo(Double value) {
            addCriterion("location_lng >=", value, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngLessThan(Double value) {
            addCriterion("location_lng <", value, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngLessThanOrEqualTo(Double value) {
            addCriterion("location_lng <=", value, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngIn(List<Double> values) {
            addCriterion("location_lng in", values, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngNotIn(List<Double> values) {
            addCriterion("location_lng not in", values, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngBetween(Double value1, Double value2) {
            addCriterion("location_lng between", value1, value2, "locationLng");
            return (Criteria) this;
        }

        public Criteria andLocationLngNotBetween(Double value1, Double value2) {
            addCriterion("location_lng not between", value1, value2, "locationLng");
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