package com.ryan.wangbw.retrofit;

/**
 * Created by wangxin on 2015/6/25.
 */
public class LoginResponse {
    private String butterfly_id;
    private String uid;
    private String nickname;
    private int sex;
    private String birthday;
    private String qq;
    private int show_role;//用户类型  1：普通用户  2：企业用户
    private String signature;
    private String token;
    private String hobby;
    private String pos_province;
    private String pos_city;
    private int is_verify;
    public String invite_code;  //分享邀请码
    public String username; //第三方登录返回的用户名
    public String avatar;
    public String f_avatar;//交友名片头像
    public String b_avatar;//商务名片头像


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getButterfly_id() {
        return butterfly_id;
    }

    public void setButterfly_id(String butterfly_id) {
        this.butterfly_id = butterfly_id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public int getIs_verify() {
        return is_verify;
    }

    public void setIs_verify(int is_verify) {
        this.is_verify = is_verify;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPos_city() {
        return pos_city;
    }

    public void setPos_city(String pos_city) {
        this.pos_city = pos_city;
    }

    public String getPos_province() {
        return pos_province;
    }

    public void setPos_province(String pos_province) {
        this.pos_province = pos_province;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getShow_role() {
        return show_role;
    }

    public void setShow_role(int show_role) {
        this.show_role = show_role;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "birthday='" + birthday + '\'' +
                ", butterfly_id='" + butterfly_id + '\'' +
                ", uid='" + uid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", qq='" + qq + '\'' +
                ", show_role=" + show_role +
                ", signature='" + signature + '\'' +
                ", token='" + token + '\'' +
                ", hobby='" + hobby + '\'' +
                ", pos_province='" + pos_province + '\'' +
                ", pos_city='" + pos_city + '\'' +
                ", is_verify=" + is_verify +
                ", invite_code='" + invite_code + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
