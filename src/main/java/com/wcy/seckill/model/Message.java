package com.wcy.seckill.model;

import java.util.Date;

/**
 * @description: message by kafka
 * @author: wcy
 * @createdTime: 2019-01-02 15:28
 */
public class Message {
    private Long id;

    private String pId;

    private int count;

    public Message() {
    }

    public Message(Long id, String pId, Date sendTime, int count) {
        this.id = id;
        this.pId = pId;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
