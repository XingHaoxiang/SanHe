package com.zhuancheng.sanhedefence.domain.http.response;

import java.util.List;

/**
 * Created by cong on 2017/5/15.
 */

public class QualityTaskResponse {

    private String code;
    private List<ResultBean> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {

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
}
