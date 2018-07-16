package com.example.qqweq.mvpdemo.bean;

import java.io.Serializable;

public class FinishedDataBean implements Serializable {

    /**
     * classes :
     * mystatus : 1:未提交 2:已提交
     * studentIds : 158
     * createTime : 1504258460000
     * correctRate : 0.0
     * teacheravatar : avatar
     * status : 1
     * corectCount : 0
     * taskid : 28071
     * questionAnswer : [{"submissionReview":1224548,"score":0,"correctness":1,"type":3,"questionid":195},{"submissionReview":1224547,"score":0,"correctness":1,"type":2,"questionid":207},{"submissionReview":1224549,"score":0,"correctness":0,"type":1,"questionid":216}]
     * reviewType : 1
     * submissionid : 192032
     * questions : [{"id":195,"score":0,"type":3},{"id":207,"score":0,"type":2},{"id":216,"score":0,"type":1}]
     * courseid : 1
     * endTime : 1504281599000
     * type : 1
     * incorectCount : 3
     * deleted : 0
     * reviewed : 1
     * startTime : 1504258460000
     * title : 潇洒走一回
     * studentId : 158
     * unapprovedCount : 0
     * partCorectCount : 0
     * teacherId : 22
     * teachername : 温慧
     * submitTimeText
     * knowledgeId
     * sectionId
     * rank
     */

    private String classes;
    private int mystatus;
    private String studentIds;
    private long createTime;
    private double correctRate;
    private String teacheravatar;
    private int status;
    private int corectCount;
    private long taskid;
    private int reviewType;
    private int submissionid;
    private int courseId;
    private long endTime;
    private int type;
    private int incorectCount;
    private String deleted;
    private int reviewed;
    private long startTime;
    private String title;
    private int studentId;
    private int unapprovedCount;
    private int partCorectCount;
    private int teacherId;
    private String teachername;
    private int totalScore;
    private int testTotalScore;//试卷满分
    private int clazzRank;   //班级排名
    private int highestScore;//最高得分
    private float averageScore;//平均得分
    private String submitTimeText;
    private int sectionId;
    private int knowledgeId;
    private int rank;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(int knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTestTotalScore() {
        return testTotalScore;
    }

    public void setTestTotalScore(int testTotalScore) {
        this.testTotalScore = testTotalScore;
    }

    public int getClazzRank() {
        return clazzRank;
    }

    public void setClazzRank(int clazzRank) {
        this.clazzRank = clazzRank;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }


    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getMystatus() {
        return mystatus;
    }

    public void setMystatus(int mystatus) {
        this.mystatus = mystatus;
    }

    public String getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(String studentIds) {
        this.studentIds = studentIds;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public double getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(double correctRate) {
        this.correctRate = correctRate;
    }

    public String getTeacheravatar() {
        return teacheravatar;
    }

    public void setTeacheravatar(String teacheravatar) {
        this.teacheravatar = teacheravatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCorrectCount() {
        return corectCount;
    }

    public void setCorectCount(int corectCount) {
        this.corectCount = corectCount;
    }

    public long getTaskid() {
        return taskid;
    }

    public void setTaskid(long taskid) {
        this.taskid = taskid;
    }

    public int getReviewType() {
        return reviewType;
    }

    public void setReviewType(int reviewType) {
        this.reviewType = reviewType;
    }

    public int getSubmissionid() {
        return submissionid;
    }

    public void setSubmissionid(int submissionid) {
        this.submissionid = submissionid;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIncorectCount() {
        return incorectCount;
    }

    public void setIncorectCount(int incorectCount) {
        this.incorectCount = incorectCount;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public int getReviewed() {
        return reviewed;
    }

    public void setReviewed(int reviewed) {
        this.reviewed = reviewed;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getUnapprovedCount() {
        return unapprovedCount;
    }

    public void setUnapprovedCount(int unapprovedCount) {
        this.unapprovedCount = unapprovedCount;
    }

    public int getPartCorectCount() {
        return partCorectCount;
    }

    public void setPartCorectCount(int partCorectCount) {
        this.partCorectCount = partCorectCount;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getSubmitTimeText() {
        return submitTimeText;
    }

    public void setSubmitTimeText(String submitTimeText) {
        this.submitTimeText = submitTimeText;
    }

    @Override
    public String toString() {
        return "FinishedDataBean{" +
                "classes='" + classes + '\'' +
                ", mystatus=" + mystatus +
                ", studentIds='" + studentIds + '\'' +
                ", createTime=" + createTime +
                ", correctRate=" + correctRate +
                ", teacheravatar='" + teacheravatar + '\'' +
                ", status=" + status +
                ", corectCount=" + corectCount +
                ", taskid=" + taskid +
                ", reviewType=" + reviewType +
                ", submissionid=" + submissionid +
                ", courseId=" + courseId +
                ", endTime=" + endTime +
                ", type=" + type +
                ", incorectCount=" + incorectCount +
                ", deleted='" + deleted + '\'' +
                ", reviewed=" + reviewed +
                ", startTime=" + startTime +
                ", title='" + title + '\'' +
                ", studentId=" + studentId +
                ", unapprovedCount=" + unapprovedCount +
                ", partCorectCount=" + partCorectCount +
                ", teacherId=" + teacherId +
                ", teachername='" + teachername + '\'' +
                ", totalScore=" + totalScore +
                ", testTotalScore=" + testTotalScore +
                ", clazzRank=" + clazzRank +
                ", highestScore=" + highestScore +
                ", averageScore=" + averageScore +
                ", submitTimeText='" + submitTimeText + '\'' +
                ", sectionId=" + sectionId +
                ", knowledgeId=" + knowledgeId +
                ", rank=" + rank +
                '}';
    }
}