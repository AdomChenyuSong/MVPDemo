package com.example.qqweq.mvpdemo.untils;

/**
 * Created by qqweq on 2018/9/25.
 */

public class ErrorCodeUntils {
    public static final int MSG_SUCCESS = 1001; //消息传递成功
    public static final int MSG_FAILED = 1002; // 消息传递失败
    public static final int MSG_LOGIN_SUCCESS = 1003;//登陆成功
    public static final int MSG_LOGIN_FAILED = 1004;//登陆失败
    public static final int MSG_LOGIN_ERROR = 1012;//登陆失败
    public static final int MSG_GET_OBJECT_SUCCESS = 1005;//获取学科成功
    public static final int MSG_GET_OBJECT_FAILED = 1006;//获取学科失败
    public static final int MSG_RUNTIME_SRF = 1007;//实时动态下拉刷新
    public static final int MSG_RANKING_SRF = 1008;//班级排行下拉刷新
    public static final int MSG_CLASSMATE_HOMEPAGE = 1011;//同学详情页
    public static final int MSG_NET_ERROR = 1012;//网络错误
    public static final int INTENT_FRAGMENT_STATUS = 2001;//跳转到
    public static final int INTENT_REQUEST_CODE_PHOTO_PICKER = 2002;//图片回调
    public static final int INTENT_LEARNING = 3001;//进入我的学习币界面
    public static final int INTENT_SCORE = 3002;//进入我的积分
    public static final int REQUEST_CAMERA = 4001; //访问相机回调
    public static final int REQUEST_BUY = 4002; //购买微课回调
    public static final int RESULT_BUY = 4003; //购买微课回调
    public static final int RESULT_BUY_PARENT = 4005; //购买微课回调
    public static final int RESULT_DETIAL = 4004; //微课详情
    public static final int MSG_TIME_EVALUATIING = 5001;//用于计时
    public static final int MSG_TIME_TASK = 5002;//用于计时
    public static final int MSG_TIME_FINISH = 5003;//用于计时
    public static final int MSG_TIME_AVERAGETIME = 5005;//用于计时
    public static final int MSG_TIME = 5006;//用于计时
    public static final int MSG_DIALOG_DISSMISS = 5004;//用于设置dialog消失
}
