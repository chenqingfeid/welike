package com.redefine.welike.business.assignment.management.bean;

/**
 * Created by liubin on 2018/3/22.
 */

public class TopReviewUser {
    private String uid;
    private String name;
    private String head;
    private int vip = 0;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }
}
