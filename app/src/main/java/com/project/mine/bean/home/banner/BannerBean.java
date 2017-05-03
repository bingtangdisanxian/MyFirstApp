package com.project.mine.bean.home.banner;

/**
 * Created by chenqi on 2017/4/17.
 * 描述:
 */
public class BannerBean {

    /**
     * title : 2区不上钻二不睡了，男爵已经是王者了！
     * link : quanmin://mobile.app/liveroom?live=666
     * fk : 666
     * slot_id : 113
     * ext : {"type":"play"}
     * link_object : {"no":"666","nick":"解说小漠","avatar":"http://image.quanmin.tv/avatar/bd6033825a6541e5e0a26af5d8f0d560png?imageView2/2/w/300/","follow":"1289284","uid":"666","play_at":"2017-04-17 18:50:58","screen":0,"views":"0","intro":"【小漠新浪微博】weibo.com/ixmxiaomo 【小漠腾讯微博】t.qq.com/lol-xiaomo 【小漠娃娃店】wawa.ixm.tv/ 【小漠零食店】lolxiaochi.taobao.com 【小漠男装店】xiezi.ixm.tv/ 【小漠男装店】lolhaoyifu.taobao.com/ 【小漠外设店】lolxiaomo.taobao.com/..","videoQuality":"234","thumb":"http://image.quanmin.tv/4b58ee79b9c3d20d9572d17386ed3e4djpg","stream":"http://flv.quanmin.tv/live/666_L3.flv","position":"","announcement":"每天7点到12点周六加播单机","id":"100996","video":"http://thumb.quanmin.tv/666.mp4?t=1492443600","slug":"xiaomo","category_id":"1","cover":"666-1492443843-195.jpg","status":"2","recommend_image":"http://image.quanmin.tv/de73e608930d71bce9ba5793dd577b05jpg","weight":"0","start_time":"1492426258.909","check":"1","priv":"0","category_name":"英雄联盟","title":"2区不上钻二不睡了，男爵已经是王者了！","source":"ws","last_play_at":"","landscape":"1","view":"1317613","app_shuffling_image":"http://image.quanmin.tv/4b58ee79b9c3d20d9572d17386ed3e4djpg","categoryId":"1","hidden":false,"play_status":true}
     * thumb : http://image.quanmin.tv/4b58ee79b9c3d20d9572d17386ed3e4djpg
     */

    public String title;
    public String link;
    public String fk;
    public int slot_id;
    public ExtBean ext;
    public LinkObjectBean link_object;
    public String thumb;

    public static class ExtBean {
        /**
         * type : play
         */

        public String type;

    }

    public static class LinkObjectBean {
        /**
         * no : 666
         * nick : 解说小漠
         * avatar : http://image.quanmin.tv/avatar/bd6033825a6541e5e0a26af5d8f0d560png?imageView2/2/w/300/
         * follow : 1289284
         * uid : 666
         * play_at : 2017-04-17 18:50:58
         * screen : 0
         * views : 0
         * intro : 【小漠新浪微博】weibo.com/ixmxiaomo 【小漠腾讯微博】t.qq.com/lol-xiaomo 【小漠娃娃店】wawa.ixm.tv/ 【小漠零食店】lolxiaochi.taobao.com 【小漠男装店】xiezi.ixm.tv/ 【小漠男装店】lolhaoyifu.taobao.com/ 【小漠外设店】lolxiaomo.taobao.com/..
         * videoQuality : 234
         * thumb : http://image.quanmin.tv/4b58ee79b9c3d20d9572d17386ed3e4djpg
         * stream : http://flv.quanmin.tv/live/666_L3.flv
         * position :
         * announcement : 每天7点到12点周六加播单机
         * id : 100996
         * video : http://thumb.quanmin.tv/666.mp4?t=1492443600
         * slug : xiaomo
         * category_id : 1
         * cover : 666-1492443843-195.jpg
         * status : 2
         * recommend_image : http://image.quanmin.tv/de73e608930d71bce9ba5793dd577b05jpg
         * weight : 0
         * start_time : 1492426258.909
         * check : 1
         * priv : 0
         * category_name : 英雄联盟
         * title : 2区不上钻二不睡了，男爵已经是王者了！
         * source : ws
         * last_play_at :
         * landscape : 1
         * view : 1317613
         * app_shuffling_image : http://image.quanmin.tv/4b58ee79b9c3d20d9572d17386ed3e4djpg
         * categoryId : 1
         * hidden : false
         * play_status : true
         */

        public String no;
        public String nick;
        public String avatar;
        public String follow;
        public String uid;
        public String play_at;
        public int screen;
        public String views;
        public String intro;
        public String videoQuality;
        public String thumb;
        public String stream;
        public String position;
        public String announcement;
        public String id;
        public String video;
        public String slug;
        public String category_id;
        public String cover;
        public String status;
        public String recommend_image;
        public String weight;
        public String start_time;
        public String check;
        public String priv;
        public String category_name;
        public String title;
        public String source;
        public String last_play_at;
        public String landscape;
        public String view;
        public String app_shuffling_image;
        public String categoryId;
        public boolean hidden;
        public boolean play_status;
    }
}
