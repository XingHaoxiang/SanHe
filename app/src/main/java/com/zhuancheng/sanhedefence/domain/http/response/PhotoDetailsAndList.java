package com.zhuancheng.sanhedefence.domain.http.response;

import java.util.List;

/**
 * Created by cong on 2017/5/18.
 */

public class PhotoDetailsAndList {

    private String code;
    private String message;
    private List<ResultBean> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * eprChildId : 23
         * partName : 是否清到槽底
         * engPhotoList : [{"engPhotoId":18,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\bg_2_b_03.png\\"},
         * {"engPhotoId":3,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\工程信息统计.png\\"},
         * {"engPhotoId":5,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\工程信息统计.png\\"},
         * {"engPhotoId":7,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\工程信息统计.png\\"},
         * {"engPhotoId":8,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\ic_launcher.png\\"},
         * {"engPhotoId":9,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\ic_launcher.png\\"},
         * {"engPhotoId":10,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\ic_launcher.png\\"},
         * {"engPhotoId":17,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\bg_1_b_01.png\\"},
         * {"engPhotoId":19,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\bg_2_b_04.png\\"},
         * {"engPhotoId":14,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\bg_1_b_01.png\\"},
         * {"engPhotoId":16,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\bg_2_b_04.png\\"},
         * {"engPhotoId":15,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\bg_2_b_03.png\\"},
         * {"engPhotoId":12,"thumbnailUrl":"2017\\赵鹏测试4\\现场质监照片\\缩略图\\ic_launcher.png\\"}]
         */

        private int eprChildId;
        private String partName;
        private List<EngPhotoListBean> engPhotoList;

        public int getEprChildId() {
            return eprChildId;
        }

        public void setEprChildId(int eprChildId) {
            this.eprChildId = eprChildId;
        }

        public String getPartName() {
            return partName;
        }

        public void setPartName(String partName) {
            this.partName = partName;
        }

        public List<EngPhotoListBean> getEngPhotoList() {
            return engPhotoList;
        }

        public void setEngPhotoList(List<EngPhotoListBean> engPhotoList) {
            this.engPhotoList = engPhotoList;
        }

        public static class EngPhotoListBean {
            /**
             * engPhotoId : 18
             * thumbnailUrl : 2017\赵鹏测试4\现场质监照片\缩略图\bg_2_b_03.png\
             */

            private int engPhotoId;
            private String thumbnailUrl;

            public int getEngPhotoId() {
                return engPhotoId;
            }

            public void setEngPhotoId(int engPhotoId) {
                this.engPhotoId = engPhotoId;
            }

            public String getThumbnailUrl() {
                return thumbnailUrl;
            }

            public void setThumbnailUrl(String thumbnailUrl) {
                this.thumbnailUrl = thumbnailUrl;
            }
        }
    }
}
