package com.project.mine.bean.yunyue.music;

import java.util.List;

/**
 * @author 钟教授
 * @time 2017/4/26  15:08
 * @desc ${TODD}
 */

public class EveryDayBean {


    private ResultBeanXXXXXXXXXXXXXXX result;
    private int error_code;
    private List<ModuleBean> module;

    public ResultBeanXXXXXXXXXXXXXXX getResult() {
        return result;
    }

    public void setResult(ResultBeanXXXXXXXXXXXXXXX result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ModuleBean> getModule() {
        return module;
    }

    public void setModule(List<ModuleBean> module) {
        this.module = module;
    }

    public static class ResultBeanXXXXXXXXXXXXXXX {

        private Mix9Bean mix_9;
        private Mod29Bean mod_29;
        private ShowListBean show_list;
        private FocusBean focus;
        private Mix22Bean mix_22;
        private DiyBean diy;
        private EntryBean entry;
        private Mod7Bean mod_7;
        private Mix5Bean mix_5;
        private RadioBean radio;
        private RecsongBean recsong;
        private NewSongBean new_song;
        private Mix2Bean mix_2;
        private Mix1Bean mix_1;
        private SceneBean scene;
        private KingBean king;

        public Mix9Bean getMix_9() {
            return mix_9;
        }

        public void setMix_9(Mix9Bean mix_9) {
            this.mix_9 = mix_9;
        }

        public Mod29Bean getMod_29() {
            return mod_29;
        }

        public void setMod_29(Mod29Bean mod_29) {
            this.mod_29 = mod_29;
        }

        public ShowListBean getShow_list() {
            return show_list;
        }

        public void setShow_list(ShowListBean show_list) {
            this.show_list = show_list;
        }

        public FocusBean getFocus() {
            return focus;
        }

        public void setFocus(FocusBean focus) {
            this.focus = focus;
        }

        public Mix22Bean getMix_22() {
            return mix_22;
        }

        public void setMix_22(Mix22Bean mix_22) {
            this.mix_22 = mix_22;
        }

        public DiyBean getDiy() {
            return diy;
        }

        public void setDiy(DiyBean diy) {
            this.diy = diy;
        }

        public EntryBean getEntry() {
            return entry;
        }

        public void setEntry(EntryBean entry) {
            this.entry = entry;
        }

        public Mod7Bean getMod_7() {
            return mod_7;
        }

        public void setMod_7(Mod7Bean mod_7) {
            this.mod_7 = mod_7;
        }

        public Mix5Bean getMix_5() {
            return mix_5;
        }

        public void setMix_5(Mix5Bean mix_5) {
            this.mix_5 = mix_5;
        }

        public RadioBean getRadio() {
            return radio;
        }

        public void setRadio(RadioBean radio) {
            this.radio = radio;
        }

        public RecsongBean getRecsong() {
            return recsong;
        }

        public void setRecsong(RecsongBean recsong) {
            this.recsong = recsong;
        }

        public NewSongBean getNew_song() {
            return new_song;
        }

        public void setNew_song(NewSongBean new_song) {
            this.new_song = new_song;
        }

        public Mix2Bean getMix_2() {
            return mix_2;
        }

        public void setMix_2(Mix2Bean mix_2) {
            this.mix_2 = mix_2;
        }

        public Mix1Bean getMix_1() {
            return mix_1;
        }

        public void setMix_1(Mix1Bean mix_1) {
            this.mix_1 = mix_1;
        }

        public SceneBean getScene() {
            return scene;
        }

        public void setScene(SceneBean scene) {
            this.scene = scene;
        }

        public KingBean getKing() {
            return king;
        }

        public void setKing(KingBean king) {
            this.king = king;
        }

        public static class Mix9Bean {

            private int error_code;
            private List<ResultBean> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBean> getResult() {
                return result;
            }

            public void setResult(List<ResultBean> result) {
                this.result = result;
            }

            public static class ResultBean {

                private String desc;
                private String pic;
                private String type_id;
                private int type;
                private String title;
                private int tip_type;
                private String author;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getType_id() {
                    return type_id;
                }

                public void setType_id(String type_id) {
                    this.type_id = type_id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTip_type() {
                    return tip_type;
                }

                public void setTip_type(int tip_type) {
                    this.tip_type = tip_type;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }

        public static class Mod29Bean {

            private int error_code;
            private List<ResultBeanX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanX> result) {
                this.result = result;
            }

            public static class ResultBeanX {

                private String desc;
                private String pic;
                private String type_id;
                private int type;
                private String title;
                private int tip_type;
                private String author;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getType_id() {
                    return type_id;
                }

                public void setType_id(String type_id) {
                    this.type_id = type_id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTip_type() {
                    return tip_type;
                }

                public void setTip_type(int tip_type) {
                    this.tip_type = tip_type;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }

        public static class ShowListBean {

            private int error_code;
            private List<ResultBeanXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXX> result) {
                this.result = result;
            }

            public static class ResultBeanXX {

                private String type;
                private String picture_iphone6;
                private String picture;
                private String web_url;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getPicture_iphone6() {
                    return picture_iphone6;
                }

                public void setPicture_iphone6(String picture_iphone6) {
                    this.picture_iphone6 = picture_iphone6;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public String getWeb_url() {
                    return web_url;
                }

                public void setWeb_url(String web_url) {
                    this.web_url = web_url;
                }
            }
        }

        public static class FocusBean {

            private int error_code;
            private List<ResultBeanXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXX {

                private String randpic;
                private String code;
                private int mo_type;
                private int type;
                private String is_publish;
                private String randpic_iphone6;
                private String randpic_desc;

                public String getRandpic() {
                    return randpic;
                }

                public void setRandpic(String randpic) {
                    this.randpic = randpic;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public int getMo_type() {
                    return mo_type;
                }

                public void setMo_type(int mo_type) {
                    this.mo_type = mo_type;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getIs_publish() {
                    return is_publish;
                }

                public void setIs_publish(String is_publish) {
                    this.is_publish = is_publish;
                }

                public String getRandpic_iphone6() {
                    return randpic_iphone6;
                }

                public void setRandpic_iphone6(String randpic_iphone6) {
                    this.randpic_iphone6 = randpic_iphone6;
                }

                public String getRandpic_desc() {
                    return randpic_desc;
                }

                public void setRandpic_desc(String randpic_desc) {
                    this.randpic_desc = randpic_desc;
                }
            }
        }

        public static class Mix22Bean {
            private int error_code;
            private List<ResultBeanXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXX {


                private String desc;
                private String pic;
                private String type_id;
                private int type;
                private String title;
                private int tip_type;
                private String author;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getType_id() {
                    return type_id;
                }

                public void setType_id(String type_id) {
                    this.type_id = type_id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTip_type() {
                    return tip_type;
                }

                public void setTip_type(int tip_type) {
                    this.tip_type = tip_type;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }

        public static class DiyBean {

            private int error_code;
            private List<ResultBeanXXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXXX {

                private int position;
                private String tag;
                private String pic;
                private String title;
                private int collectnum;
                private String type;
                private int listenum;
                private String listid;
                private List<?> songidlist;

                public int getPosition() {
                    return position;
                }

                public void setPosition(int position) {
                    this.position = position;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getCollectnum() {
                    return collectnum;
                }

                public void setCollectnum(int collectnum) {
                    this.collectnum = collectnum;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getListenum() {
                    return listenum;
                }

                public void setListenum(int listenum) {
                    this.listenum = listenum;
                }

                public String getListid() {
                    return listid;
                }

                public void setListid(String listid) {
                    this.listid = listid;
                }

                public List<?> getSongidlist() {
                    return songidlist;
                }

                public void setSongidlist(List<?> songidlist) {
                    this.songidlist = songidlist;
                }
            }
        }

        public static class EntryBean {
            /**
             * error_code : 22000
             * result : [{"day":"","title":"歌手","icon":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14639875926652ed7c4988517cab87526f15d8f359.jpg","jump":"2"},{"day":"","title":"歌曲分类","icon":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_146398764316d87d01865b91f90a598777b1569fdf.jpg","jump":"1"},{"day":"26","title":"今日推荐歌曲","icon":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1463987629793f4361391282bde14d9b19156cfac3.jpg","jump":"0"}]
             */

            private int error_code;
            private List<ResultBeanXXXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXXXX {
                /**
                 * day :
                 * title : 歌手
                 * icon : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14639875926652ed7c4988517cab87526f15d8f359.jpg
                 * jump : 2
                 */

                private String day;
                private String title;
                private String icon;
                private String jump;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getJump() {
                    return jump;
                }

                public void setJump(String jump) {
                    this.jump = jump;
                }
            }
        }

        public static class Mod7Bean {
            /**
             * error_code : 22000
             * result : [{"desc":"一周音乐热 | 网罗一周乐坛动态！","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_149311671995538636df214cc969433f47f9eb93f4.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=285&columnid=87","type":4,"title":"春风十里不如李，嫁不出去全赖你！","tip_type":0,"author":""},{"desc":"爱豆SHOW VOL.23 | 带你跟进新、热idol的脚步","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1492597582e94e2a80c3b8c03de5234a5289e92c07.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=275&columnid=86","type":4,"title":"如果春天是樱花和爱情的季节\u2026","tip_type":0,"author":""},{"desc":"音乐大人物 | 带给你绝妙的音乐，独特的故事","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14924137326c843962dc4fb86ef062d49a09573510.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=265&columnid=92","type":4,"title":"薛之谦独家专访，现场金句频出","tip_type":0,"author":""},{"desc":"明星私房歌 | 听偶像推荐的歌","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_149267359983dc745343164e187c14a242e7c8886f.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=273&columnid=84","type":4,"title":"迪丽热巴的私房歌曲大公开","tip_type":0,"author":""},{"desc":"百度音乐独家DJ节目《有待咖啡》 | 第二十三期","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1493183690e24a56bea633ae34d3be9da6381440de.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=286&columnid=89","type":4,"title":"百老汇与爵士乐水乳交融的亲密关系","tip_type":0,"author":""},{"desc":"百度音乐独家DJ节目《在云端》 | 第十六期","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_149276257979cb9f4c59ae3254af2f84ef1ee5ef4e.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=276&columnid=88","type":4,"title":"数字情歌里，隐藏了多少不能说的秘密","tip_type":0,"author":""},{"desc":"百度音乐独家DJ节目《音乐风格馆》 | 第三期","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1492482083258ca1087756f30e8bb64351b177a81c.jpg","type_id":"http://music.baidu.com/cms/webview/bigwig/yyfgg_v3/index.html","type":4,"title":"方大同：我想做\u201c无框架的音乐\u201d","tip_type":0,"author":""},{"desc":"跟着音乐 环球世界 | 第七期","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1492768238ba9d6a891d902cd1c3fe0f6467c769d0.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=277&columnid=90","type":4,"title":"Kendrick Lamar钟情怪诞采样","tip_type":0,"author":""},{"desc":"百度音乐独家策划","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1491585039f774e14e884c6aed4e10765acdf9d392.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=249&columnid=95","type":4,"title":"岁月的船，许侯孝贤一座悲情城市。","tip_type":0,"author":""}]
             */

            private int error_code;
            private List<ResultBeanXXXXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXXXXX {
                /**
                 * desc : 一周音乐热 | 网罗一周乐坛动态！
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_149311671995538636df214cc969433f47f9eb93f4.jpg
                 * type_id : http://music.baidu.com/h5pc/spec_detail?id=285&columnid=87
                 * type : 4
                 * title : 春风十里不如李，嫁不出去全赖你！
                 * tip_type : 0
                 * author :
                 */

                private String desc;
                private String pic;
                private String type_id;
                private int type;
                private String title;
                private int tip_type;
                private String author;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getType_id() {
                    return type_id;
                }

                public void setType_id(String type_id) {
                    this.type_id = type_id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTip_type() {
                    return tip_type;
                }

                public void setTip_type(int tip_type) {
                    this.tip_type = tip_type;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }

        public static class Mix5Bean {
            /**
             * error_code : 22000
             * result : [{"desc":"郭美美","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_149310938128ca95350e2a98d1e4ad9c1e3a3fec6b.jpg","type_id":"334137830","type":5,"title":"光阴 电视剧《繁星四月》主题曲","tip_type":0,"author":"郭美美"},{"desc":"何琪","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1492774354042e23f2247184aa8bf11597f95aab18.jpg","type_id":"269713175","type":5,"title":"每天","tip_type":0,"author":"何琪"},{"desc":"司云阁","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1492497496ecd02e9fe064e2e7cf42b161d9c4e2c8.jpg","type_id":"334034668","type":5,"title":"不醒","tip_type":0,"author":"司云阁"},{"desc":"徐子崴","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1492415714b278f7aad25d9a6cf6d989ecc8216e56.jpg","type_id":"334017044","type":5,"title":"永远别说永远","tip_type":0,"author":"徐子崴"},{"desc":"苏运莹","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_149241542261c8e7edf67e8d2c7569194ac40c5887.jpg","type_id":"333853497","type":5,"title":"蓝孩子 电影《蓝精灵：寻找神秘村》中国区主题曲","tip_type":0,"author":"苏运莹"},{"desc":"小球（庄鹃瑛）","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14919741102ec92b99d20905a4f3c9e2185d61efbc.jpg","type_id":"333874095","type":5,"title":"希望","tip_type":0,"author":"小球（庄鹃瑛）"}]
             */

            private int error_code;
            private List<ResultBeanXXXXXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXXXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXXXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXXXXXX {
                /**
                 * desc : 郭美美
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_149310938128ca95350e2a98d1e4ad9c1e3a3fec6b.jpg
                 * type_id : 334137830
                 * type : 5
                 * title : 光阴 电视剧《繁星四月》主题曲
                 * tip_type : 0
                 * author : 郭美美
                 */

                private String desc;
                private String pic;
                private String type_id;
                private int type;
                private String title;
                private int tip_type;
                private String author;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getType_id() {
                    return type_id;
                }

                public void setType_id(String type_id) {
                    this.type_id = type_id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTip_type() {
                    return tip_type;
                }

                public void setTip_type(int tip_type) {
                    this.tip_type = tip_type;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }

        public static class RadioBean {
            /**
             * error_code : 22000
             * result : [{"desc":"都市情感","itemid":"13456631","title":"与回忆和解，向未来前行（主播：秋婉）","album_id":"12545344","type":"lebo","channelid":"11373553","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_6f9e3f288baab5d70c4583cddf145a10.jpg"},{"desc":"音乐推荐","itemid":"13458443","title":"《中国嘻哈榜》第356期：全部都是你，《陆》强势夺冠！","album_id":"13385010","type":"lebo","channelid":"11373552","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_8b5ed76d49dd0c439551fb5baa1dcb2e.jpg"},{"desc":"都市情感","itemid":"13455521","title":"听一首歌，想一个人-【晨曦微露】","album_id":"12380577","type":"lebo","channelid":"11373553","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_49d1dc7b629720811e3cbfc7a574060c.jpg"},{"desc":"都市情感","itemid":"13451477","title":"因为有你，旅程才多了欢声笑语（主播：法朵）","album_id":"12545344","type":"lebo","channelid":"11373553","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_ddb1c986c75590f0b657819be0b20670.jpg"},{"desc":"音乐推荐","itemid":"13450723","title":"《拆弹专家》4月28日公映 刘德华赌命对决炸弹狂魔","album_id":"12602702","type":"lebo","channelid":"11373552","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_936b5cc8a435140bbb42e64102756fdb.jpg"},{"desc":"笑话段子","itemid":"13451154","title":"颜值高的人说话更加令人信服","album_id":"12380502","type":"lebo","channelid":"11373547","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_34c111aa588d988a80ee48437de351bb.jpg"}]
             */

            private int error_code;
            private List<ResultBeanXXXXXXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXXXXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXXXXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXXXXXXX {
                /**
                 * desc : 都市情感
                 * itemid : 13456631
                 * title : 与回忆和解，向未来前行（主播：秋婉）
                 * album_id : 12545344
                 * type : lebo
                 * channelid : 11373553
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_6f9e3f288baab5d70c4583cddf145a10.jpg
                 */

                private String desc;
                private String itemid;
                private String title;
                private String album_id;
                private String type;
                private String channelid;
                private String pic;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getItemid() {
                    return itemid;
                }

                public void setItemid(String itemid) {
                    this.itemid = itemid;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getAlbum_id() {
                    return album_id;
                }

                public void setAlbum_id(String album_id) {
                    this.album_id = album_id;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getChannelid() {
                    return channelid;
                }

                public void setChannelid(String channelid) {
                    this.channelid = channelid;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }
            }
        }

        public static class RecsongBean {
            /**
             * error_code : 22001
             */

            private int error_code;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }
        }

        public static class NewSongBean {
            /**
             * error_code : 22000
             * result : {"pic_500":"http://b.hiphotos.baidu.com/ting/pic/item/a50f4bfbfbedab64bcae572ef136afc378311e7b.jpg","listid":"5126","song_info":[{"song_id":"261812117","title":"二十四小时","pic_premium":"http://qukufile2.qianqian.com/data2/pic/261811991/261811991.jpg@s_0,w_500","author":"陈坤,韩庚,大鹏,吴磊,尹正"},{"song_id":"74109283","title":"灵主不悔《画江湖之灵主》手游暨动漫主题曲","author":"汪苏泷"},{"song_id":"261496612","title":"Protocole","pic_premium":"http://qukufile2.qianqian.com/data2/pic/07a830e962bbb4e58e29842f45d44b66/261496583/261496583.jpg@s_0,w_500","author":"Alpha Wann"}]}
             */

            private int error_code;
            private ResultBeanXXXXXXXXXX result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public ResultBeanXXXXXXXXXX getResult() {
                return result;
            }

            public void setResult(ResultBeanXXXXXXXXXX result) {
                this.result = result;
            }

            public static class ResultBeanXXXXXXXXXX {
                /**
                 * pic_500 : http://b.hiphotos.baidu.com/ting/pic/item/a50f4bfbfbedab64bcae572ef136afc378311e7b.jpg
                 * listid : 5126
                 * song_info : [{"song_id":"261812117","title":"二十四小时","pic_premium":"http://qukufile2.qianqian.com/data2/pic/261811991/261811991.jpg@s_0,w_500","author":"陈坤,韩庚,大鹏,吴磊,尹正"},{"song_id":"74109283","title":"灵主不悔《画江湖之灵主》手游暨动漫主题曲","author":"汪苏泷"},{"song_id":"261496612","title":"Protocole","pic_premium":"http://qukufile2.qianqian.com/data2/pic/07a830e962bbb4e58e29842f45d44b66/261496583/261496583.jpg@s_0,w_500","author":"Alpha Wann"}]
                 */

                private String pic_500;
                private String listid;
                private List<SongInfoBean> song_info;

                public String getPic_500() {
                    return pic_500;
                }

                public void setPic_500(String pic_500) {
                    this.pic_500 = pic_500;
                }

                public String getListid() {
                    return listid;
                }

                public void setListid(String listid) {
                    this.listid = listid;
                }

                public List<SongInfoBean> getSong_info() {
                    return song_info;
                }

                public void setSong_info(List<SongInfoBean> song_info) {
                    this.song_info = song_info;
                }

                public static class SongInfoBean {
                    /**
                     * song_id : 261812117
                     * title : 二十四小时
                     * pic_premium : http://qukufile2.qianqian.com/data2/pic/261811991/261811991.jpg@s_0,w_500
                     * author : 陈坤,韩庚,大鹏,吴磊,尹正
                     */

                    private String song_id;
                    private String title;
                    private String pic_premium;
                    private String author;

                    public String getSong_id() {
                        return song_id;
                    }

                    public void setSong_id(String song_id) {
                        this.song_id = song_id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getPic_premium() {
                        return pic_premium;
                    }

                    public void setPic_premium(String pic_premium) {
                        this.pic_premium = pic_premium;
                    }

                    public String getAuthor() {
                        return author;
                    }

                    public void setAuthor(String author) {
                        this.author = author;
                    }
                }
            }
        }

        public static class Mix2Bean {
            /**
             * error_code : 22000
             * result : [{"desc":"百度音乐独家策划","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1493194796a233e64befca84c3fab525939dc81cf0.jpg","type_id":"http://music.baidu.com/h5pc/spec_detail?id=287&columnid=103","type":4,"title":"尾崎丰，说 I LOVE YOU的方式","tip_type":0,"author":""}]
             */

            private int error_code;
            private List<ResultBeanXXXXXXXXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXXXXXXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXXXXXXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXXXXXXXXX {
                /**
                 * desc : 百度音乐独家策划
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1493194796a233e64befca84c3fab525939dc81cf0.jpg
                 * type_id : http://music.baidu.com/h5pc/spec_detail?id=287&columnid=103
                 * type : 4
                 * title : 尾崎丰，说 I LOVE YOU的方式
                 * tip_type : 0
                 * author :
                 */

                private String desc;
                private String pic;
                private String type_id;
                private int type;
                private String title;
                private int tip_type;
                private String author;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getType_id() {
                    return type_id;
                }

                public void setType_id(String type_id) {
                    this.type_id = type_id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTip_type() {
                    return tip_type;
                }

                public void setTip_type(int tip_type) {
                    this.tip_type = tip_type;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }

        public static class Mix1Bean {
            /**
             * error_code : 22000
             * result : [{"desc":"薛之谦","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14930485318dd6a53653a1673130055d3bea95679d.jpg","type_id":"540560824","type":2,"title":"我害怕","tip_type":0,"author":"薛之谦"},{"desc":"容祖儿","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14931939410145cb028c764ba9aff14ef4d7e5f618.jpg","type_id":"540580708","type":2,"title":"他狠过你 (Live version)","tip_type":0,"author":"容祖儿"},{"desc":"蔡卓妍/周柏豪","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14931939825da54d0ab6b3daa9721bf1a31252eb86.jpg","type_id":"540580040","type":2,"title":"请你爱我","tip_type":0,"author":"蔡卓妍/周柏豪"},{"desc":"果味VC","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1493195331dce3fcfaa59ceee9d2d664291bfba461.jpg","type_id":"540579985","type":2,"title":"躁不完的青春","tip_type":0,"author":"果味VC"},{"desc":"每个星期二下午/啝乐队/猫科动物","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_149303117953ce441507c21af2da3f5e74eeb2b752.jpg","type_id":"540451296","type":2,"title":"2016滚石原创乐团大赛纪念专辑","tip_type":0,"author":"每个星期二下午/啝乐队/猫科动物"},{"desc":"庆庆","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1493102980e8848ce663e6ca2de4486fb9055635d0.jpg","type_id":"540522810","type":2,"title":"在爱情里 (Live Version)","tip_type":3,"author":"庆庆"}]
             */

            private int error_code;
            private List<ResultBeanXXXXXXXXXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXXXXXXXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXXXXXXXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXXXXXXXXXX {
                /**
                 * desc : 薛之谦
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14930485318dd6a53653a1673130055d3bea95679d.jpg
                 * type_id : 540560824
                 * type : 2
                 * title : 我害怕
                 * tip_type : 0
                 * author : 薛之谦
                 */

                private String desc;
                private String pic;
                private String type_id;
                private int type;
                private String title;
                private int tip_type;
                private String author;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getType_id() {
                    return type_id;
                }

                public void setType_id(String type_id) {
                    this.type_id = type_id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTip_type() {
                    return tip_type;
                }

                public void setTip_type(int tip_type) {
                    this.tip_type = tip_type;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }

        public static class SceneBean {
            /**
             * result : {"action":[{"icon_ios":"http://a.hiphotos.baidu.com/ting/pic/item/4b90f603738da977c8c2a3dbb651f8198718e355.jpg","scene_name":"瑜伽","bgpic_android":"","icon_android":"http://d.hiphotos.baidu.com/ting/pic/item/c8ea15ce36d3d5390281a5c03d87e950352ab071.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"30"},{"icon_ios":"http://b.hiphotos.baidu.com/ting/pic/item/94cad1c8a786c917cd5a64c9cf3d70cf3ac757e0.jpg","scene_name":"在路上","bgpic_android":"","icon_android":"http://c.hiphotos.baidu.com/ting/pic/item/b999a9014c086e06604a914805087bf40bd1cbd7.jpg","scene_model":"2","scene_desc":"","bgpic_ios":"","scene_id":"0"},{"icon_ios":"http://d.hiphotos.baidu.com/ting/pic/item/3ac79f3df8dcd1000b09c1d1748b4710b8122fac.jpg","scene_name":"开车","bgpic_android":"","icon_android":"http://c.hiphotos.baidu.com/ting/pic/item/29381f30e924b899d1d0d13b69061d950b7bf6c1.jpg","scene_model":"2","scene_desc":"开车路上，安全为上","bgpic_ios":"","scene_id":"17"},{"icon_ios":"http://b.hiphotos.baidu.com/ting/pic/item/5bafa40f4bfbfbed7770128f7ef0f736afc31f10.jpg","scene_name":"做家务","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/960a304e251f95cad85a0fb5ce177f3e67095201.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"31"},{"icon_ios":"http://c.hiphotos.baidu.com/ting/pic/item/6159252dd42a28340be30dfb5db5c9ea14cebffc.jpg","scene_name":"蹲马桶","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/11385343fbf2b2112cb92e4dcd8065380cd78e1a.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"22"},{"icon_ios":"http://b.hiphotos.baidu.com/ting/pic/item/5366d0160924ab18426ed0c733fae6cd7a890bc1.jpg","scene_name":"运动","bgpic_android":"","icon_android":"http://a.hiphotos.baidu.com/ting/pic/item/8326cffc1e178a82d9d1d1a3f103738da877e8c0.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"1"},{"icon_ios":"http://a.hiphotos.baidu.com/ting/pic/item/0dd7912397dda144f5a95742b4b7d0a20df48699.jpg","scene_name":"咖啡时光","bgpic_android":"","icon_android":"http://c.hiphotos.baidu.com/ting/pic/item/b8014a90f603738dc815a721b41bb051f819ec52.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"23"}],"emotion":[{"icon_ios":"http://d.hiphotos.baidu.com/ting/pic/item/7acb0a46f21fbe094353e1e46d600c338744ad34.jpg","scene_name":"轻松","bgpic_android":"","icon_android":"http://c.hiphotos.baidu.com/ting/pic/item/bf096b63f6246b609bc02d77ecf81a4c500fa2e3.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"40"},{"icon_ios":"http://a.hiphotos.baidu.com/ting/pic/item/d058ccbf6c81800a94d3a4feb73533fa828b470f.jpg","scene_name":"思念","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/aa64034f78f0f736eac8d2020d55b319ebc413fa.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"41"},{"icon_ios":"http://d.hiphotos.baidu.com/ting/pic/item/3c6d55fbb2fb431677aa588a26a4462308f7d38c.jpg","scene_name":"醉了","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/5ab5c9ea15ce36d37d9c1c333df33a87e950b11d.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"39"},{"icon_ios":"http://b.hiphotos.baidu.com/ting/pic/item/a1ec08fa513d26974c932aad53fbb2fb4216d8f9.jpg","scene_name":"开心","bgpic_android":"","icon_android":"http://c.hiphotos.baidu.com/ting/pic/item/f703738da9773912e4621a62ff198618367ae269.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"38"},{"icon_ios":"http://b.hiphotos.baidu.com/ting/pic/item/9d82d158ccbf6c810ea60f18ba3eb13532fa40a8.jpg","scene_name":"治愈","bgpic_android":"","icon_android":"http://a.hiphotos.baidu.com/ting/pic/item/472309f790529822ffa5a6c0d0ca7bcb0a46d41b.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"37"}],"operation":[{"icon_ios":"http://a.hiphotos.baidu.com/ting/pic/item/4a36acaf2edda3cc469cb5ad07e93901203f92c6.jpg","scene_name":"校园歌曲","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/a71ea8d3fd1f4134ed57037c221f95cad1c85e4b.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"160"},{"icon_ios":"http://c.hiphotos.baidu.com/ting/pic/item/faedab64034f78f04fd1977e7f310a55b2191c60.jpg","scene_name":"古风","bgpic_android":"","icon_android":"http://c.hiphotos.baidu.com/ting/pic/item/2cf5e0fe9925bc313c5e079a59df8db1cb1370b4.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"157"},{"icon_ios":"http://b.hiphotos.baidu.com/ting/pic/item/18d8bc3eb13533faf2ba9fa3aed3fd1f41345b2a.jpg","scene_name":"网络歌曲","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/9922720e0cf3d7ca73313874f51fbe096a63a9e8.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"156"},{"icon_ios":"http://c.hiphotos.baidu.com/ting/pic/item/bd3eb13533fa828bd727916efb1f4134970a5a32.jpg","scene_name":"新歌抢鲜听","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/9213b07eca8065382359a31190dda144ad348204.jpg","scene_model":"1","scene_desc":"网罗全球最新歌曲","bgpic_ios":"","scene_id":"33"},{"icon_ios":"http://a.hiphotos.baidu.com/ting/pic/item/d01373f082025aaff566d3a4fcedab64034f1a0c.jpg","scene_name":"热歌","bgpic_android":"","icon_android":"http://a.hiphotos.baidu.com/ting/pic/item/838ba61ea8d3fd1f55b20f55374e251f95ca5f21.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"162"},{"icon_ios":"http://d.hiphotos.baidu.com/ting/pic/item/cb8065380cd79123bb1999f9ab345982b3b78045.jpg","scene_name":"小清新","bgpic_android":"","icon_android":"http://a.hiphotos.baidu.com/ting/pic/item/80cb39dbb6fd526672003a16ac18972bd407368c.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"158"},{"icon_ios":"http://a.hiphotos.baidu.com/ting/pic/item/dbb44aed2e738bd461c6bebca78b87d6267ff95c.jpg","scene_name":"情人节","bgpic_android":"","icon_android":"http://c.hiphotos.baidu.com/ting/pic/item/63d0f703918fa0ecfe25630f219759ee3c6ddbd6.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"155"},{"icon_ios":"http://d.hiphotos.baidu.com/ting/pic/item/c2fdfc039245d6884448bf29a2c27d1ed31b24f0.jpg","scene_name":"经典老歌","bgpic_android":"","icon_android":"http://a.hiphotos.baidu.com/ting/pic/item/d058ccbf6c81800a68b98f0cb63533fa828b4757.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"161"},{"icon_ios":"http://d.hiphotos.baidu.com/ting/pic/item/c8ea15ce36d3d539961d09c13d87e950352ab08b.jpg","scene_name":"舒缓","bgpic_android":"","icon_android":"http://a.hiphotos.baidu.com/ting/pic/item/0824ab18972bd40792add5ff7c899e510fb3094d.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"159"}],"other":[{"icon_ios":"http://c.hiphotos.baidu.com/ting/pic/item/b2de9c82d158ccbfe74098ca1fd8bc3eb0354145.jpg","scene_name":"国语","bgpic_android":"","icon_android":"http://a.hiphotos.baidu.com/ting/pic/item/d439b6003af33a87423e9e19c15c10385343b566.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"42"},{"icon_ios":"http://c.hiphotos.baidu.com/ting/pic/item/b3b7d0a20cf431ad9bb26ac94d36acaf2fdd98d9.jpg","scene_name":"流行","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/a50f4bfbfbedab6443ffd5c3f036afc379311e27.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"48"},{"icon_ios":"http://d.hiphotos.baidu.com/ting/pic/item/377adab44aed2e7364d7a8dc8101a18b87d6fa00.jpg","scene_name":"2000年代","bgpic_android":"","icon_android":"http://b.hiphotos.baidu.com/ting/pic/item/aa64034f78f0f736ec9dd4020d55b319ebc41355.jpg","scene_model":"1","scene_desc":"","bgpic_ios":"","scene_id":"71"}]}
             * error_code : 22000
             * config : [{"color_other":"","play_color":"","scene_version":0,"desc":"","end_time":0,"start_time":0,"scene_color":"","bgpic":"","bgpic_special":"","button_color":""}]
             */

            private ResultBeanXXXXXXXXXXXXX result;
            private int error_code;
            private List<ConfigBean> config;

            public ResultBeanXXXXXXXXXXXXX getResult() {
                return result;
            }

            public void setResult(ResultBeanXXXXXXXXXXXXX result) {
                this.result = result;
            }

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ConfigBean> getConfig() {
                return config;
            }

            public void setConfig(List<ConfigBean> config) {
                this.config = config;
            }

            public static class ResultBeanXXXXXXXXXXXXX {
                private List<ActionBean> action;
                private List<EmotionBean> emotion;
                private List<OperationBean> operation;
                private List<OtherBean> other;

                public List<ActionBean> getAction() {
                    return action;
                }

                public void setAction(List<ActionBean> action) {
                    this.action = action;
                }

                public List<EmotionBean> getEmotion() {
                    return emotion;
                }

                public void setEmotion(List<EmotionBean> emotion) {
                    this.emotion = emotion;
                }

                public List<OperationBean> getOperation() {
                    return operation;
                }

                public void setOperation(List<OperationBean> operation) {
                    this.operation = operation;
                }

                public List<OtherBean> getOther() {
                    return other;
                }

                public void setOther(List<OtherBean> other) {
                    this.other = other;
                }

                public static class ActionBean {
                    /**
                     * icon_ios : http://a.hiphotos.baidu.com/ting/pic/item/4b90f603738da977c8c2a3dbb651f8198718e355.jpg
                     * scene_name : 瑜伽
                     * bgpic_android :
                     * icon_android : http://d.hiphotos.baidu.com/ting/pic/item/c8ea15ce36d3d5390281a5c03d87e950352ab071.jpg
                     * scene_model : 1
                     * scene_desc :
                     * bgpic_ios :
                     * scene_id : 30
                     */

                    private String icon_ios;
                    private String scene_name;
                    private String bgpic_android;
                    private String icon_android;
                    private String scene_model;
                    private String scene_desc;
                    private String bgpic_ios;
                    private String scene_id;

                    public String getIcon_ios() {
                        return icon_ios;
                    }

                    public void setIcon_ios(String icon_ios) {
                        this.icon_ios = icon_ios;
                    }

                    public String getScene_name() {
                        return scene_name;
                    }

                    public void setScene_name(String scene_name) {
                        this.scene_name = scene_name;
                    }

                    public String getBgpic_android() {
                        return bgpic_android;
                    }

                    public void setBgpic_android(String bgpic_android) {
                        this.bgpic_android = bgpic_android;
                    }

                    public String getIcon_android() {
                        return icon_android;
                    }

                    public void setIcon_android(String icon_android) {
                        this.icon_android = icon_android;
                    }

                    public String getScene_model() {
                        return scene_model;
                    }

                    public void setScene_model(String scene_model) {
                        this.scene_model = scene_model;
                    }

                    public String getScene_desc() {
                        return scene_desc;
                    }

                    public void setScene_desc(String scene_desc) {
                        this.scene_desc = scene_desc;
                    }

                    public String getBgpic_ios() {
                        return bgpic_ios;
                    }

                    public void setBgpic_ios(String bgpic_ios) {
                        this.bgpic_ios = bgpic_ios;
                    }

                    public String getScene_id() {
                        return scene_id;
                    }

                    public void setScene_id(String scene_id) {
                        this.scene_id = scene_id;
                    }
                }

                public static class EmotionBean {
                    /**
                     * icon_ios : http://d.hiphotos.baidu.com/ting/pic/item/7acb0a46f21fbe094353e1e46d600c338744ad34.jpg
                     * scene_name : 轻松
                     * bgpic_android :
                     * icon_android : http://c.hiphotos.baidu.com/ting/pic/item/bf096b63f6246b609bc02d77ecf81a4c500fa2e3.jpg
                     * scene_model : 1
                     * scene_desc :
                     * bgpic_ios :
                     * scene_id : 40
                     */

                    private String icon_ios;
                    private String scene_name;
                    private String bgpic_android;
                    private String icon_android;
                    private String scene_model;
                    private String scene_desc;
                    private String bgpic_ios;
                    private String scene_id;

                    public String getIcon_ios() {
                        return icon_ios;
                    }

                    public void setIcon_ios(String icon_ios) {
                        this.icon_ios = icon_ios;
                    }

                    public String getScene_name() {
                        return scene_name;
                    }

                    public void setScene_name(String scene_name) {
                        this.scene_name = scene_name;
                    }

                    public String getBgpic_android() {
                        return bgpic_android;
                    }

                    public void setBgpic_android(String bgpic_android) {
                        this.bgpic_android = bgpic_android;
                    }

                    public String getIcon_android() {
                        return icon_android;
                    }

                    public void setIcon_android(String icon_android) {
                        this.icon_android = icon_android;
                    }

                    public String getScene_model() {
                        return scene_model;
                    }

                    public void setScene_model(String scene_model) {
                        this.scene_model = scene_model;
                    }

                    public String getScene_desc() {
                        return scene_desc;
                    }

                    public void setScene_desc(String scene_desc) {
                        this.scene_desc = scene_desc;
                    }

                    public String getBgpic_ios() {
                        return bgpic_ios;
                    }

                    public void setBgpic_ios(String bgpic_ios) {
                        this.bgpic_ios = bgpic_ios;
                    }

                    public String getScene_id() {
                        return scene_id;
                    }

                    public void setScene_id(String scene_id) {
                        this.scene_id = scene_id;
                    }
                }

                public static class OperationBean {
                    /**
                     * icon_ios : http://a.hiphotos.baidu.com/ting/pic/item/4a36acaf2edda3cc469cb5ad07e93901203f92c6.jpg
                     * scene_name : 校园歌曲
                     * bgpic_android :
                     * icon_android : http://b.hiphotos.baidu.com/ting/pic/item/a71ea8d3fd1f4134ed57037c221f95cad1c85e4b.jpg
                     * scene_model : 1
                     * scene_desc :
                     * bgpic_ios :
                     * scene_id : 160
                     */

                    private String icon_ios;
                    private String scene_name;
                    private String bgpic_android;
                    private String icon_android;
                    private String scene_model;
                    private String scene_desc;
                    private String bgpic_ios;
                    private String scene_id;

                    public String getIcon_ios() {
                        return icon_ios;
                    }

                    public void setIcon_ios(String icon_ios) {
                        this.icon_ios = icon_ios;
                    }

                    public String getScene_name() {
                        return scene_name;
                    }

                    public void setScene_name(String scene_name) {
                        this.scene_name = scene_name;
                    }

                    public String getBgpic_android() {
                        return bgpic_android;
                    }

                    public void setBgpic_android(String bgpic_android) {
                        this.bgpic_android = bgpic_android;
                    }

                    public String getIcon_android() {
                        return icon_android;
                    }

                    public void setIcon_android(String icon_android) {
                        this.icon_android = icon_android;
                    }

                    public String getScene_model() {
                        return scene_model;
                    }

                    public void setScene_model(String scene_model) {
                        this.scene_model = scene_model;
                    }

                    public String getScene_desc() {
                        return scene_desc;
                    }

                    public void setScene_desc(String scene_desc) {
                        this.scene_desc = scene_desc;
                    }

                    public String getBgpic_ios() {
                        return bgpic_ios;
                    }

                    public void setBgpic_ios(String bgpic_ios) {
                        this.bgpic_ios = bgpic_ios;
                    }

                    public String getScene_id() {
                        return scene_id;
                    }

                    public void setScene_id(String scene_id) {
                        this.scene_id = scene_id;
                    }
                }

                public static class OtherBean {
                    /**
                     * icon_ios : http://c.hiphotos.baidu.com/ting/pic/item/b2de9c82d158ccbfe74098ca1fd8bc3eb0354145.jpg
                     * scene_name : 国语
                     * bgpic_android :
                     * icon_android : http://a.hiphotos.baidu.com/ting/pic/item/d439b6003af33a87423e9e19c15c10385343b566.jpg
                     * scene_model : 1
                     * scene_desc :
                     * bgpic_ios :
                     * scene_id : 42
                     */

                    private String icon_ios;
                    private String scene_name;
                    private String bgpic_android;
                    private String icon_android;
                    private String scene_model;
                    private String scene_desc;
                    private String bgpic_ios;
                    private String scene_id;

                    public String getIcon_ios() {
                        return icon_ios;
                    }

                    public void setIcon_ios(String icon_ios) {
                        this.icon_ios = icon_ios;
                    }

                    public String getScene_name() {
                        return scene_name;
                    }

                    public void setScene_name(String scene_name) {
                        this.scene_name = scene_name;
                    }

                    public String getBgpic_android() {
                        return bgpic_android;
                    }

                    public void setBgpic_android(String bgpic_android) {
                        this.bgpic_android = bgpic_android;
                    }

                    public String getIcon_android() {
                        return icon_android;
                    }

                    public void setIcon_android(String icon_android) {
                        this.icon_android = icon_android;
                    }

                    public String getScene_model() {
                        return scene_model;
                    }

                    public void setScene_model(String scene_model) {
                        this.scene_model = scene_model;
                    }

                    public String getScene_desc() {
                        return scene_desc;
                    }

                    public void setScene_desc(String scene_desc) {
                        this.scene_desc = scene_desc;
                    }

                    public String getBgpic_ios() {
                        return bgpic_ios;
                    }

                    public void setBgpic_ios(String bgpic_ios) {
                        this.bgpic_ios = bgpic_ios;
                    }

                    public String getScene_id() {
                        return scene_id;
                    }

                    public void setScene_id(String scene_id) {
                        this.scene_id = scene_id;
                    }
                }
            }

            public static class ConfigBean {
                /**
                 * color_other :
                 * play_color :
                 * scene_version : 0
                 * desc :
                 * end_time : 0
                 * start_time : 0
                 * scene_color :
                 * bgpic :
                 * bgpic_special :
                 * button_color :
                 */

                private String color_other;
                private String play_color;
                private int scene_version;
                private String desc;
                private int end_time;
                private int start_time;
                private String scene_color;
                private String bgpic;
                private String bgpic_special;
                private String button_color;

                public String getColor_other() {
                    return color_other;
                }

                public void setColor_other(String color_other) {
                    this.color_other = color_other;
                }

                public String getPlay_color() {
                    return play_color;
                }

                public void setPlay_color(String play_color) {
                    this.play_color = play_color;
                }

                public int getScene_version() {
                    return scene_version;
                }

                public void setScene_version(int scene_version) {
                    this.scene_version = scene_version;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public int getEnd_time() {
                    return end_time;
                }

                public void setEnd_time(int end_time) {
                    this.end_time = end_time;
                }

                public int getStart_time() {
                    return start_time;
                }

                public void setStart_time(int start_time) {
                    this.start_time = start_time;
                }

                public String getScene_color() {
                    return scene_color;
                }

                public void setScene_color(String scene_color) {
                    this.scene_color = scene_color;
                }

                public String getBgpic() {
                    return bgpic;
                }

                public void setBgpic(String bgpic) {
                    this.bgpic = bgpic;
                }

                public String getBgpic_special() {
                    return bgpic_special;
                }

                public void setBgpic_special(String bgpic_special) {
                    this.bgpic_special = bgpic_special;
                }

                public String getButton_color() {
                    return button_color;
                }

                public void setButton_color(String button_color) {
                    this.button_color = button_color;
                }
            }
        }

        public static class KingBean {
            /**
             * error_code : 22000
             * result : [{"pic_big":"http://musicdata.baidu.com/data2/pic/cdf739f2c64831f0d7d36a36348f844c/537880220/537880220.jpg@s_0,w_150","title":"深夜书店","author":"许嵩,洛天依"},{"pic_big":"http://musicdata.baidu.com/data2/pic/2d84b6ab618c31442be900b9ec31f580/540139155/540139155.jpg@s_0,w_150","title":"并肩闪耀","author":"1931女子偶像组合"},{"pic_big":"http://musicdata.baidu.com/data2/pic/9d4faa13282c9d6beea41f479448f259/540090993/540090993.jpg@s_0,w_150","title":"拿不走的记忆","author":"迪玛希"}]
             */

            private int error_code;
            private List<ResultBeanXXXXXXXXXXXXXX> result;

            public int getError_code() {
                return error_code;
            }

            public void setError_code(int error_code) {
                this.error_code = error_code;
            }

            public List<ResultBeanXXXXXXXXXXXXXX> getResult() {
                return result;
            }

            public void setResult(List<ResultBeanXXXXXXXXXXXXXX> result) {
                this.result = result;
            }

            public static class ResultBeanXXXXXXXXXXXXXX {
                /**
                 * pic_big : http://musicdata.baidu.com/data2/pic/cdf739f2c64831f0d7d36a36348f844c/537880220/537880220.jpg@s_0,w_150
                 * title : 深夜书店
                 * author : 许嵩,洛天依
                 */

                private String pic_big;
                private String title;
                private String author;

                public String getPic_big() {
                    return pic_big;
                }

                public void setPic_big(String pic_big) {
                    this.pic_big = pic_big;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }
    }

    public static class ModuleBean {
        /**
         * link_url :
         * pos : 1
         * title : 焦点图
         * key : focus
         * picurl :
         * title_more :
         * style : 1
         * jump :
         */

        private String link_url;
        private int pos;
        private String title;
        private String key;
        private String picurl;
        private String title_more;
        private int style;
        private String jump;

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getTitle_more() {
            return title_more;
        }

        public void setTitle_more(String title_more) {
            this.title_more = title_more;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public String getJump() {
            return jump;
        }

        public void setJump(String jump) {
            this.jump = jump;
        }
    }
}


