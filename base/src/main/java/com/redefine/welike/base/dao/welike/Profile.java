package com.redefine.welike.base.dao.welike;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "PROFILE".
 */
@Entity
public class Profile {

    @Id
    @NotNull
    @Unique
    private String uid;
    private String nick;
    private String head;

    @NotNull
    private String atoken;

    @NotNull
    private String ttype;

    @NotNull
    private String rtoken;

    @NotNull
    private String expired;
    private String introduction;
    private Byte sex;
    private Integer postsCount;
    private Integer followingCount;
    private Integer followerCount;
    private Long likedMyPostsCount;
    private Long myLikedPostsCount;
    private int completeLevel;
    private boolean login;
    private Integer vip;
    private String intrests;
    private Integer status;

    @Generated
    public Profile() {
    }

    public Profile(String uid) {
        this.uid = uid;
    }

    @Generated
    public Profile(String uid, String nick, String head, String atoken, String ttype, String rtoken, String expired, String introduction, Byte sex, Integer postsCount, Integer followingCount, Integer followerCount, Long likedMyPostsCount, Long myLikedPostsCount, int completeLevel, boolean login, Integer vip, String intrests, Integer status) {
        this.uid = uid;
        this.nick = nick;
        this.head = head;
        this.atoken = atoken;
        this.ttype = ttype;
        this.rtoken = rtoken;
        this.expired = expired;
        this.introduction = introduction;
        this.sex = sex;
        this.postsCount = postsCount;
        this.followingCount = followingCount;
        this.followerCount = followerCount;
        this.likedMyPostsCount = likedMyPostsCount;
        this.myLikedPostsCount = myLikedPostsCount;
        this.completeLevel = completeLevel;
        this.login = login;
        this.vip = vip;
        this.intrests = intrests;
        this.status = status;
    }

    @NotNull
    public String getUid() {
        return uid;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUid(@NotNull String uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @NotNull
    public String getAtoken() {
        return atoken;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setAtoken(@NotNull String atoken) {
        this.atoken = atoken;
    }

    @NotNull
    public String getTtype() {
        return ttype;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTtype(@NotNull String ttype) {
        this.ttype = ttype;
    }

    @NotNull
    public String getRtoken() {
        return rtoken;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setRtoken(@NotNull String rtoken) {
        this.rtoken = rtoken;
    }

    @NotNull
    public String getExpired() {
        return expired;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setExpired(@NotNull String expired) {
        this.expired = expired;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(Integer postsCount) {
        this.postsCount = postsCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public Long getLikedMyPostsCount() {
        return likedMyPostsCount;
    }

    public void setLikedMyPostsCount(Long likedMyPostsCount) {
        this.likedMyPostsCount = likedMyPostsCount;
    }

    public Long getMyLikedPostsCount() {
        return myLikedPostsCount;
    }

    public void setMyLikedPostsCount(Long myLikedPostsCount) {
        this.myLikedPostsCount = myLikedPostsCount;
    }

    public int getCompleteLevel() {
        return completeLevel;
    }

    public void setCompleteLevel(int completeLevel) {
        this.completeLevel = completeLevel;
    }

    public boolean getLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getIntrests() {
        return intrests;
    }

    public void setIntrests(String intrests) {
        this.intrests = intrests;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
