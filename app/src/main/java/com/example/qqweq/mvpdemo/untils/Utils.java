package com.example.qqweq.mvpdemo.untils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.qqweq.mvpdemo.R;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zcj on 2017/7/18.
 */

public class Utils {
    public static final boolean isDebug = true;
    private static final String TAG = "Utils";

    //用户名是否只包含数字和字母
    public static boolean isLegelUserName(String str) {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        boolean a = str.length() == 18;
        boolean b = match.matches();
        return a && b;
    }

    public static GradientDrawable changeColor(Context context, int drawableInt) {
        GradientDrawable drawable = (GradientDrawable) context.getResources().getDrawable(drawableInt);
        return drawable;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int getColorByScore(int score) {
        if (score >= 0 && score <= 59) {
            return R.color.red_ed6767;
        } else if (score > 59 && score <= 74) {
            return R.color.yellow_fead00;
        } else if (score > 74 && score <= 84) {
            return R.color.pink_fd6acb;
        } else if (score > 84 && score <= 100) {
            return R.color.green_2ec5c2;
        } else {
            return R.color.hint_text;
        }
    }

    public static String getStrByScore(int score) {
        if (score > 59 && score <= 74) {
            return "中";
        } else if (score > 74 && score <= 84) {
            return "良";
        } else if (score > 84 && score <= 100) {
            return "优";
        } else {
            return "差";
        }
    }

    public static String getKnowledgeColorByState(String state) {
        String color = "#ed6767";
        state = state.trim();
        if (TextUtils.isEmpty(state)) {
            return color;
        }
        if (state.equals("差")) {
            color = "#ed6767";
        } else if (state.equals("中")) {
            color = "#fead00";
        } else if (state.equals("良")) {
            color = "#fd6acb";
        } else if (state.equals("优")) {
            color = "#2ec5c2";
        }
        return color;
    }

    public static int getKnowledgeColorByScore(int score) {
        int color;
        switch (score) {
            case 0:
                color = R.color.red_ed6767;
                break;
            case 1:
                color = R.color.yellow_fead00;
                break;
            case 2:
                color = R.color.pink_fd6acb;
                break;
            case 3:
                color = R.color.green_2ec5c2;
                break;
            default:
                color = R.color.hint_text;
                break;
        }
        return color;
    }

    public static int getStatusByScore(int score) {
        if (score >= 0 && score <= 59) {
            return 0;
        } else if (score > 59 && score <= 74) {
            return 1;
        } else if (score > 74 && score <= 84) {
            return 2;
        } else if (score > 84 && score <= 100) {
            return 3;
        } else {
            return -1;
        }
    }

    public static String getknowledgeStatusByScore(int score) {
        String status;
        switch (score) {
            case 0:
                status = "差";
                break;
            case 1:
                status = "中";
                break;
            case 2:
                status = "良";
                break;
            case 3:
                status = "优";
                break;
            default:
                status = "未学";
                break;
        }
        return status;
    }


    public static String getStatusByRank(int rank) {
        if (rank > 74 && rank <= 84) {
            return "良好";
        } else if (rank > 84 && rank <= 100) {
            return "优秀";
        } else {
            return null;
        }
    }

    public static void setDrawableTop(Drawable drawable, TextView textView) {

        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        textView.setCompoundDrawables(null, drawable, null, null);
    }

    public static LinearLayout.LayoutParams setMarginLeft(int left) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(left, 0, 0, 0);
        return lp;
    }

    public static LinearLayout.LayoutParams setMarginTop() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 30, 0, 0);
        return lp;
    }

    /**
     * 获取拍照相片存储文件
     *
     * @param context
     * @return
     */
    public static File createFile(Context context) {
        File file;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            String timeStamp = String.valueOf(new Date().getTime());
            file = new File(Environment.getExternalStorageDirectory() +
                    File.separator + timeStamp + ".jpg");
        } else {
            File cacheDir = context.getCacheDir();
            String timeStamp = String.valueOf(new Date().getTime());
            file = new File(cacheDir, timeStamp + ".jpg");
        }
        return file;
    }

    /**
     * @param time
     * @return 年-月-日 时：分
     */
    public static String fromatTime_YMDHM(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String data = simpleDateFormat.format(time);
        return data;//+ " " + timeFormat.format(date)
    }

    /**
     * @param time
     * @return 年-月-日
     */
    public static String fromatTime_YMD(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String data = simpleDateFormat.format(time);
        return data;//+ " " + timeFormat.format(date)
    }

    /**
     * @param time
     * @return 月日
     */
    public static String fromatTime_MD(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String data = simpleDateFormat.format(time);
        data = data.substring(5, data.length());
        return data;//+ " " + timeFormat.format(date)
    }

    /**
     * @param time
     * @return 年
     */
    public static String fromatTime_Y(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String data = simpleDateFormat.format(time);
        data = data.substring(0, 5);
        return data;//+ " " + timeFormat.format(date)
    }

    /**
     * @param time
     * @return 年月日时：分
     */
    public static String fromatTime(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
        String data = simpleDateFormat.format(time);
        return data;//+ " " + timeFormat.format(date)
    }

    public static String formatTime(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String data = simpleDateFormat.format(time);
        return data;//+ " " + timeFormat.format(date)
    }

    /**
     * @param time
     * @return 时分
     */
    public static String fromatTimeHM(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
        String data = simpleDateFormat.format(time);
        int index = data.lastIndexOf("日");
        data = data.substring(index + 1, data.length());
        return data;//+ " " + timeFormat.format(date)
    }

    /**
     * @param time
     * @return 月日 时分
     */
    public static String fromatTimeMDHM(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String data = simpleDateFormat.format(time);
        int index = data.lastIndexOf("年");
        data = data.substring(index + 1, data.length());
        return data;//+ " " + timeFormat.format(date)
    }

    /**
     * @param time
     * @return 天 时分秒
     */
    public static String fromatHour(long time) {
        long hour = time / 1000 / 60 / 60 % 24;
        long m = time / 1000 / 60 % 60;
        long s = time / 1000 % 60 % 60;
        long day = time / 1000 / 60 / 60 / 24;
        return day > 0 ? (day + "天 ") : "" + String.format("%02d", hour) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);
    }

    /**
     * @param time
     * @return 时分
     */
    public static String fromatVideoTime(int time) {
        if (time < 60) {
            return time + "分钟";
        } else {
            int h = time / 60;
            int m = time % 60;
            return h + "小时" + m + "分钟";
        }
    }

    /**
     * @param time
     * @return 00：00
     */
    public static String formatTimeMS(long time) {
        if (time <= 0) {
            return "0s";
        }
        int minute = (int) (time / 1000 / 60 % 60);
        int second = (int) (time / 1000 % 60 % 60);

        return String.format("%02d", minute) + ":" + String.format("%02d", second);
    }

    /**
     * @param time
     * @return s
     */
    public static String fromatTimeSecond(long time) {
        if (time <= 0) {
            return "1s";
        }
        long second = time / 1000;
        return second + "s";//+ " " + timeFormat.format(date)
    }

    public static String formateWekiTime(int time, Context context) {
        if (time < 0 || time >= 0 && time < 60) {
            if (time <= 0) {
                time = 1;
            }
            return context.getResources().getString(R.string.string_time_s, time);
        } else {
            int m = time / 60;
            int s = time % 60;
            return context.getResources().getString(R.string.string_time, m) + context.getResources().getString(R.string.string_time_s, s);
        }
    }

    public static String formatSystemTime(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd.HHmmss");
        String data = simpleDateFormat.format(time);
        return data;
    }

    public static String MD5(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(base.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                int unsigned = aByte & 0xff;
                if (unsigned < 0x10)
                    sb.append('0');
                sb.append(Integer.toHexString(unsigned));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    //判断章节知识点id是否是纯数字，如果不是去掉第一位的s或者k
    public static int getId(String id) {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = null;
//        java.lang.NullPointerException: Attempt to invoke interface method 'int java.lang.CharSequence.length()' on a null object reference
//        at java.util.regex.Matcher.reset(Matcher.java:177)
//        at java.util.regex.Matcher.<init>(Matcher.java:90)
//        at java.util.regex.Pattern.matcher(Pattern.java:297)
//        at cn.com.linktrust.als.ipad.util.Utils.getId(Utils.java:418)
//        at cn.com.linktrust.als.ipad.exercise.AnalysisActivity.getSubmissionStatusModel(AnalysisActivity.java:239)
//        at cn.com.linktrust.als.ipad.exercise.AnalysisActivity.pushData(AnalysisActivity.java:530)
//        at cn.com.linktrust.als.ipad.exercise.AnalysisActivity.handleMessage(AnalysisActivity.java:515)
        try {
            match = pattern.matcher(id);
            if (match.matches()) {
                return Integer.parseInt(id);
            } else {
                String str = id.substring(1, id.length());
                return Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Long getLongId(String id) {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(id);
        if (match.matches()) {
            return Long.parseLong(id);
        } else {
            return Long.parseLong(id.substring(1, id.length()));
        }
    }

    public static List<String> formateKnowledgeIdS(List<Integer> idList) {
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < idList.size(); i++) {
            String newId = addStar(idList.get(i));
            ids.add(newId);
        }
        return ids;
    }

    private static String addStar(int id) {
        StringBuffer sb = new StringBuffer("*");
        sb.append(id);
        sb.append("*");
        return sb.toString();
    }

    private static Integer removeStar(String ids) {
        if (ids.startsWith("*")) {
            int index = ids.indexOf("*");
            String newIds = ids.substring(index + 1, ids.length() - 1);
            return Integer.parseInt(newIds);
        } else {
            return Integer.parseInt(ids);
        }
    }

    public static String getStr(List<String> strList) {
        String str = "";
        for (int i = 0; i < strList.size(); i++) {
            str += strList.get(i);
            if (i != strList.size() - 1) {
                str += ",";
            }
        }
        return str;
    }

    public static String formateString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }

    public static SpannableStringBuilder getColorText(String text) {
        if (text.length() < 6) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.parseColor("#2ec5c2"));
        builder.setSpan(redSpan, 6, text.length() - 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }

    public static SpannableStringBuilder getColorText(String text, String scoreText, int color) {
        String title = text + scoreText;
        if (text.length() < 6) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder builder = new SpannableStringBuilder(title);
        //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
        ForegroundColorSpan redSpan = new ForegroundColorSpan(color);
        builder.setSpan(redSpan, text.length(), title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }
}
