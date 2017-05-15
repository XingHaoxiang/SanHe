package com.zhuancheng.sanhedefence.domain.http.response;

/**
 * Created by cong on 2017/5/15.
 */

public class QualityTaskResponse{

    private int id;
    private String taskName;
    private String engName;
    private String engAddress;
    private String taskDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getEngAddress() {
        return engAddress;
    }

    public void setEngAddress(String engAddress) {
        this.engAddress = engAddress;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
}
