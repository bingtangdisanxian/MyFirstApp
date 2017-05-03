package com.project.mine.bean.yunyue.movie;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenqi on 2017/4/26.
 * 描述:
 */
public class MovieBean implements Serializable{
    public int count;
    public int start;
    public int total;
    public String title;
    public List<SubjectsBean> subjects;
}
