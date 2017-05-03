package com.project.mine.bean.yunyue.movie;

import java.io.Serializable;

/**
 * Created by chenqi on 2017/4/26.
 * 描述:
 */
public class CastsBean implements Serializable{

    /**
     * alt : https://movie.douban.com/celebrity/1041020/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/53186.jpg","large":"https://img3.doubanio.com/img/celebrity/large/53186.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/53186.jpg"}
     * name : 范·迪塞尔
     * id : 1041020
     */
    public String alt;
    public AvatarsBean avatars;
    public String name;
    public String id;
}
