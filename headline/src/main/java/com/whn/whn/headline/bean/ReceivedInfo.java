package com.whn.whn.headline.bean;

import java.util.List;

/**
 * Created by whn on 2016/12/23.
 */

public class ReceivedInfo {


    /**
     * reason : 成功的返回
     * error_code : 0
     * result :
     */

    public String reason;
    public int error_code;
    public ResultEntity result;

    public static class ResultEntity {
        /**
         * stat : 1
         * data :
         */

        public String stat;
        public List<ResultEntity.DataEntity> data;

        public static class DataEntity {
            /**
             * title : 东方八卦：王凯否认爱上陈乔恩，黄子韬瘫倒轮椅送医，蔡依林锦荣六年情断
             * date : 2016-12-23 10:46
             * author_name : 东方头条
             * thumbnail_pic_s : http://08.imgmini.eastday.com/mobile/20161223/20161223104644_a37be1c58d905f31f63ad35372331124_1_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://08.imgmini.eastday.com/mobile/20161223/20161223104644_a37be1c58d905f31f63ad35372331124_1_mwpl_05500201.jpg
             * thumbnail_pic_s03 : http://08.imgmini.eastday.com/mobile/20161223/20161223104644_a37be1c58d905f31f63ad35372331124_1_mwpl_05500201.jpg
             * url : http://mini.eastday.com/mobile/161223104644066.html?qid=juheshuju
             * uniquekey : 161223104644066
             * type : 头条
             * realtype : 娱乐
             */

            public String title;//标题
            public String date;//时间
            public String author_name;//发布方
            public String thumbnail_pic_s;//图
            public String thumbnail_pic_s02;
            public String thumbnail_pic_s03;
            public String url;//具体内容
            public String uniquekey;
            public String type;//头条
            public String realtype;//分类

            @Override
            public String toString() {
                return "DataEntity{" +
                        "title='" + title + '\'' +
                        ", date='" + date + '\'' +
                        ", author_name='" + author_name + '\'' +
                        ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                        ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                        ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                        ", url='" + url + '\'' +
                        ", uniquekey='" + uniquekey + '\'' +
                        ", type='" + type + '\'' +
                        ", realtype='" + realtype + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "stat='" + stat + '\'' +
                    ", data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
