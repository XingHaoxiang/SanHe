package com.zhuancheng.sanhedefence.domain.model;

/**
 * Created by cong on 2017/5/6.
 * 质监任务实体类
 */
public class QualityBean {
    private String qualityContent;
    private String projectName;
    private String projectAddress;
    private String time;

    public QualityBean() {
    }

    public QualityBean(String qualityContent, String projectName, String projectAddress, String time) {
        this.qualityContent = qualityContent;
        this.projectName = projectName;
        this.projectAddress = projectAddress;
        this.time = time;
    }

    public String getQualityContent() {
        return qualityContent;
    }

    public void setQualityContent(String qualityContent) {
        this.qualityContent = qualityContent;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
