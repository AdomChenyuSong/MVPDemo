package com.example.qqweq.mvpdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int computeVerticalScrollExtent() {
        return 1;
    }

    @Override
    protected int computeVerticalScrollOffset() {
        int sRange = super.computeVerticalScrollRange();
        int sExtent = super.computeVerticalScrollExtent();
        int range = sRange - sExtent;
        if(range == 0){
            return 0;
        }
        return (int) (sRange * super.computeVerticalScrollOffset() * 1.0f / range);
    }

}