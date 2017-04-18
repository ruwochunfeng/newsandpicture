package com.zhoubing.newsandpicture;

import android.widget.ImageView;

/**
 * Created by dell on 2017/4/18.
 */

public class News {

    private int imageId;

    private  String title;

    private  String content ;

    public News(int imageId, String title, String content){
        this.imageId=imageId;
        this.title  =title  ;
        this.content=content;
    }

    public int getImageId() {
        return imageId;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
