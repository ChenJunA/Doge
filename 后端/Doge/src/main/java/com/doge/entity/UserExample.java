package com.doge.entity;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andBiographyIsNull() {
            addCriterion("biography is null");
            return (Criteria) this;
        }

        public Criteria andBiographyIsNotNull() {
            addCriterion("biography is not null");
            return (Criteria) this;
        }

        public Criteria andBiographyEqualTo(String value) {
            addCriterion("biography =", value, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyNotEqualTo(String value) {
            addCriterion("biography <>", value, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyGreaterThan(String value) {
            addCriterion("biography >", value, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyGreaterThanOrEqualTo(String value) {
            addCriterion("biography >=", value, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyLessThan(String value) {
            addCriterion("biography <", value, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyLessThanOrEqualTo(String value) {
            addCriterion("biography <=", value, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyLike(String value) {
            addCriterion("biography like", value, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyNotLike(String value) {
            addCriterion("biography not like", value, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyIn(List<String> values) {
            addCriterion("biography in", values, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyNotIn(List<String> values) {
            addCriterion("biography not in", values, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyBetween(String value1, String value2) {
            addCriterion("biography between", value1, value2, "biography");
            return (Criteria) this;
        }

        public Criteria andBiographyNotBetween(String value1, String value2) {
            addCriterion("biography not between", value1, value2, "biography");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberIsNull() {
            addCriterion("Followers_number is null");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberIsNotNull() {
            addCriterion("Followers_number is not null");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberEqualTo(Long value) {
            addCriterion("Followers_number =", value, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberNotEqualTo(Long value) {
            addCriterion("Followers_number <>", value, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberGreaterThan(Long value) {
            addCriterion("Followers_number >", value, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("Followers_number >=", value, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberLessThan(Long value) {
            addCriterion("Followers_number <", value, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberLessThanOrEqualTo(Long value) {
            addCriterion("Followers_number <=", value, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberIn(List<Long> values) {
            addCriterion("Followers_number in", values, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberNotIn(List<Long> values) {
            addCriterion("Followers_number not in", values, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberBetween(Long value1, Long value2) {
            addCriterion("Followers_number between", value1, value2, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowersNumberNotBetween(Long value1, Long value2) {
            addCriterion("Followers_number not between", value1, value2, "followersNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberIsNull() {
            addCriterion("Following_number is null");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberIsNotNull() {
            addCriterion("Following_number is not null");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberEqualTo(Long value) {
            addCriterion("Following_number =", value, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberNotEqualTo(Long value) {
            addCriterion("Following_number <>", value, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberGreaterThan(Long value) {
            addCriterion("Following_number >", value, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("Following_number >=", value, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberLessThan(Long value) {
            addCriterion("Following_number <", value, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberLessThanOrEqualTo(Long value) {
            addCriterion("Following_number <=", value, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberIn(List<Long> values) {
            addCriterion("Following_number in", values, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberNotIn(List<Long> values) {
            addCriterion("Following_number not in", values, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberBetween(Long value1, Long value2) {
            addCriterion("Following_number between", value1, value2, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andFollowingNumberNotBetween(Long value1, Long value2) {
            addCriterion("Following_number not between", value1, value2, "followingNumber");
            return (Criteria) this;
        }

        public Criteria andStarsIsNull() {
            addCriterion("stars is null");
            return (Criteria) this;
        }

        public Criteria andStarsIsNotNull() {
            addCriterion("stars is not null");
            return (Criteria) this;
        }

        public Criteria andStarsEqualTo(Integer value) {
            addCriterion("stars =", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsNotEqualTo(Integer value) {
            addCriterion("stars <>", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsGreaterThan(Integer value) {
            addCriterion("stars >", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsGreaterThanOrEqualTo(Integer value) {
            addCriterion("stars >=", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsLessThan(Integer value) {
            addCriterion("stars <", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsLessThanOrEqualTo(Integer value) {
            addCriterion("stars <=", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsIn(List<Integer> values) {
            addCriterion("stars in", values, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsNotIn(List<Integer> values) {
            addCriterion("stars not in", values, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsBetween(Integer value1, Integer value2) {
            addCriterion("stars between", value1, value2, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsNotBetween(Integer value1, Integer value2) {
            addCriterion("stars not between", value1, value2, "stars");
            return (Criteria) this;
        }

        public Criteria andIsBanIsNull() {
            addCriterion("is_ban is null");
            return (Criteria) this;
        }

        public Criteria andIsBanIsNotNull() {
            addCriterion("is_ban is not null");
            return (Criteria) this;
        }

        public Criteria andIsBanEqualTo(Boolean value) {
            addCriterion("is_ban =", value, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanNotEqualTo(Boolean value) {
            addCriterion("is_ban <>", value, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanGreaterThan(Boolean value) {
            addCriterion("is_ban >", value, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_ban >=", value, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanLessThan(Boolean value) {
            addCriterion("is_ban <", value, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanLessThanOrEqualTo(Boolean value) {
            addCriterion("is_ban <=", value, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanIn(List<Boolean> values) {
            addCriterion("is_ban in", values, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanNotIn(List<Boolean> values) {
            addCriterion("is_ban not in", values, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanBetween(Boolean value1, Boolean value2) {
            addCriterion("is_ban between", value1, value2, "isBan");
            return (Criteria) this;
        }

        public Criteria andIsBanNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_ban not between", value1, value2, "isBan");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andIsAcitveIsNull() {
            addCriterion("is_acitve is null");
            return (Criteria) this;
        }

        public Criteria andIsAcitveIsNotNull() {
            addCriterion("is_acitve is not null");
            return (Criteria) this;
        }

        public Criteria andIsAcitveEqualTo(Boolean value) {
            addCriterion("is_acitve =", value, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveNotEqualTo(Boolean value) {
            addCriterion("is_acitve <>", value, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveGreaterThan(Boolean value) {
            addCriterion("is_acitve >", value, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_acitve >=", value, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveLessThan(Boolean value) {
            addCriterion("is_acitve <", value, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveLessThanOrEqualTo(Boolean value) {
            addCriterion("is_acitve <=", value, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveIn(List<Boolean> values) {
            addCriterion("is_acitve in", values, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveNotIn(List<Boolean> values) {
            addCriterion("is_acitve not in", values, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveBetween(Boolean value1, Boolean value2) {
            addCriterion("is_acitve between", value1, value2, "isAcitve");
            return (Criteria) this;
        }

        public Criteria andIsAcitveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_acitve not between", value1, value2, "isAcitve");
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