package com.example.qqweq.mvpdemo.untils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.qqweq.mvpdemo.MvpApplication;

/**
 * Created by qqweq on 2018/10/8.
 */

public class SharedPrefenceUtils {
    public final String SHARED_NAME = "shared_filed_student";
    public static final String SHARED_USER_ID = "shared_user_id";
    public static final String USERTOKEN = "share_user_token";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static class ShareHolder {
        private static final SharedPrefenceUtils sharedPrefenceUtils = new SharedPrefenceUtils();
    }

    public static SharedPrefenceUtils getInstance() {
        return ShareHolder.sharedPrefenceUtils;
    }

    public SharedPrefenceUtils() {
        sharedPreferences = MvpApplication.mvpApplication.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /**
     * 存储数据
     *
     * @param key
     * @param value
     */
    public void putValue(String key, Object value) {
        if (value instanceof String) {
            editor.putString(key, String.valueOf(value));
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }
        editor.apply();
    }

    /**
     * 获取值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return object
     */
    public Object getValue(String key, Object defaultValue) {
        if (defaultValue instanceof String) {
            return sharedPreferences.getString(key, String.valueOf(defaultValue));
        } else if (defaultValue instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultValue);
        } else if (defaultValue instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultValue);
        } else {
            return defaultValue;
        }
    }

    /**
     * 清除SharedPreferences
     */
    public void clear() {
        editor.clear();
        editor.apply();
    }

    /**
     * 移除某个键对应的值
     *
     * @param key 键
     */
    public void remove(String key) {
        editor.remove(key);
        editor.apply();
    }

}
