package com.example.qqweq.mvpdemo.bean;


/**
 * Created by zcj on 2017/8/4.
 */

public class ObjectModel extends BaseEntity {
    /**
     * id : 1
     * title : 数学
     * code : Ma
     * deleted : 0
     */

    private int id;
    private String title;
    private String deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "ObjectModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
