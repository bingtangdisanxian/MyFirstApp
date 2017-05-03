package com.project.mine.bean.yunyue.movie;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenqi on 2017/4/26.
 * 描述:
 */
public class SubjectsBean implements Serializable{

    /**
     * rating : {"max":10,"average":7.2,"stars":"40","min":0}
     * genres : ["动作","犯罪"]
     * title : 速度与激情8
     * casts : [{"alt":"https://movie.douban.com/celebrity/1041020/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/53186.jpg","large":"https://img3.doubanio.com/img/celebrity/large/53186.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/53186.jpg"},"name":"范·迪塞尔","id":"1041020"},{"alt":"https://movie.douban.com/celebrity/1044707/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/196.jpg","large":"https://img3.doubanio.com/img/celebrity/large/196.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/196.jpg"},"name":"道恩·强森","id":"1044707"},{"alt":"https://movie.douban.com/celebrity/1018991/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/44470.jpg","large":"https://img3.doubanio.com/img/celebrity/large/44470.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/44470.jpg"},"name":"查理兹·塞隆","id":"1018991"}]
     * collect_count : 110327
     * original_title : The Fate of the Furious
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1009396/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/4451.jpg","large":"https://img3.doubanio.com/img/celebrity/large/4451.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/4451.jpg"},"name":"F·加里·格雷","id":"1009396"}]
     * year : 2017
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2444256500.webp","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2444256500.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2444256500.webp"}
     * alt : https://movie.douban.com/subject/26260853/
     * id : 26260853
     */
    public RatingBean rating;
    public String title;
    public int collect_count;
    public String original_title;
    public String subtype;
    public String year;
    public ImagesBean images;
    public String alt;
    public String id;
    public List<String> genres;
    public List<CastsBean> casts;
    public List<DirectorsBean> directors;
}
