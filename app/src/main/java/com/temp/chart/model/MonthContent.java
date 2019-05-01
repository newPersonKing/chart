package com.temp.chart.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MonthContent {

    @Id(autoincrement = true)
    private Long id = null;

    private String month;
    private float value;
    private int tag;

    @Generated(hash = 2078479798)
    public MonthContent(Long id, String month, float value, int tag) {
        this.id = id;
        this.month = month;
        this.value = value;
        this.tag = tag;
    }

    @Generated(hash = 1286834991)
    public MonthContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
