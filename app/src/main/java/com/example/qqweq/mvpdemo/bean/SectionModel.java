package com.example.qqweq.mvpdemo.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zcj on 2017/9/8.
 */

public class SectionModel implements Serializable {
    private String id;
    private String name;
    private double score;
    private double totalScore;
    private double currScore;
    private int video;
    private int type;
    private List<Integer> wrongs;
    private List<SectionModel> children;
    private boolean isChapter;
    private String isDownLoad;

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getCurrScore() {
        return currScore;
    }

    public void setCurrScore(double currScore) {
        this.currScore = currScore;
    }

    public String isDownLoad() {
        return isDownLoad;
    }

    public void setDownLoad(String downLoad) {
        isDownLoad = downLoad;
    }

    /**
     * @return int 1:章；2：节；3：知识点; -1 unknown
     */
    public int modelType() {
        if (isChapter) {
            return 1;
        }
        if (!TextUtils.isEmpty(id)) {
            if (type == 2) {
                return 3;
            } else {
                return 2;
            }
        }
        return -1;
    }
//    public boolean isKnowledge() {
//        return !TextUtils.isEmpty(id) && type == 2;
//    }

    public boolean isChapter() {
        return isChapter;
    }

    public void setChapter(boolean chapter) {
        isChapter = chapter;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Integer> getWrongs() {
        return wrongs;
    }

    public void setWrongs(List<Integer> wrongs) {
        this.wrongs = wrongs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public List<SectionModel> getChildren() {
        return children;
    }

    public void setChildren(List<SectionModel> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SectionModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", totalScore=" + totalScore +
                ", currScore=" + currScore +
                ", video=" + video +
                ", type=" + type +
                ", wrongs=" + wrongs +
                ", children=" + children +
                ", isChapter=" + isChapter +
                ", isDownLoad='" + isDownLoad + '\'' +
                '}';
    }
}
