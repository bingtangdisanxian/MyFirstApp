package com.project.mine.bean.home.tablayout;


import com.chad.library.adapter.base.entity.MultiItemEntity;

public class LiveCategory implements MultiItemEntity {

    public static final int TEXT = 1;
    public static final int IMG_TEXT = 2;
    private int itemType;
    private int spanSize;
    public static final int TEXT_SPAN_SIZE = 3;
    public static final int IMG_TEXT_SPAN_SIZE = 1;


    public LiveCategory(int itemType,int spanSize) {
        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getSpanSize(){
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    /**
     * id: 29,
     * name: "Showing",
     * is_default: 1,
     * sort: 999,
     * icon_gray: "http://uimg.quanmin.tv/1480649956/53ef5.png",
     * icon_red: "http://uimg.quanmin.tv/1480649951/4b823.png",
     * icon_image: "http://uimg.quanmin.tv/1480649936/10414.png",
     * slug: "showing",
     * type: 2,
     * screen: 1
     */

    public int id;
    public String name;
    public int is_default;
    public int sort;
    public String icon_gray;
    public String icon_red;
    public String icon_image;
    public String slug;
    public int type;
    public int screen;
}
