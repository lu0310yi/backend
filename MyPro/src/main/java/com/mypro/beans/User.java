package com.mypro.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data

@NoArgsConstructor
public class User implements Serializable {
    private Long userId;

    private String nickname;

    private String password;

    private String gender;

    private String mobile;
//    @JsonIgnore
    private String avatar;
//    @JsonIgnore
    private String background;
//    @JsonIgnore
    private String countyId;
//    @JsonIgnore
    private Date gmtBirth;

    private String signature;

    private Date gmtSignUp;
//    @JsonIgnore
    private Date gmtLastLogin;
//    @JsonIgnore
    private String lastLoginIpv4;
//    @JsonIgnore
    private String lastLoginIpv6;

    private static final long serialVersionUID = 1L;

    public User(Long userId, String nickname, String password, String gender, String mobile, String avatar, String background, String countyId, Date gmtBirth, String signature, Date gmtSignUp, Date gmtLastLogin, String lastLoginIpv4, String lastLoginIpv6) {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.gender = gender;
        this.mobile = mobile;
        this.avatar = avatar;
        this.background = background;
        this.countyId = countyId;
        this.gmtBirth = gmtBirth;
        this.signature = signature;
        this.gmtSignUp = gmtSignUp;
        this.gmtLastLogin = gmtLastLogin;
        this.lastLoginIpv4 = lastLoginIpv4;
        this.lastLoginIpv6 = lastLoginIpv6;
    }
    public User(String mobile,String password){
        this.mobile = mobile;
        this.password = password;
        this.gmtSignUp = new Date();
        this.gmtLastLogin = new Date();
    }

    public User(Long userId, String nickname, String password, String gender, String mobile, Date birth, String signature) {
        this.userId = userId;
        this.nickname=nickname;
        this.password=password;
        this.gender=gender;
        this.mobile=mobile;
        this.gmtBirth = birth;
        this.signature=signature;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getBackground() {
        return background;
    }

    public String getCountyId() {
        return countyId;
    }

    public Date getGmtBirth() {
        return gmtBirth;
    }

    public String getSignature() {
        return signature;
    }

    public Date getGmtSignUp() {
        return gmtSignUp;
    }

    public Date getGmtLastLogin() {
        return gmtLastLogin;
    }

    public String getLastLoginIpv4() {
        return lastLoginIpv4;
    }

    public String getLastLoginIpv6() {
        return lastLoginIpv6;
    }

    @Override
    public String toString() {

        return  "User{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", avatar='" + avatar + '\'' +
                ", background='" + background + '\'' +
                ", countyId='" + countyId + '\'' +
                ", gmtBirth=" + gmtBirth +
                ", signature='" + signature + '\'' +
                ", gmtSignUp=" + gmtSignUp +
                ", gmtLastLogin=" + gmtLastLogin +
                ", lastLoginIpv4='" + lastLoginIpv4 + '\'' +
                ", lastLoginIpv6='" + lastLoginIpv6 + '\'' +
                '}';

    }

}