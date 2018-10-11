package com.example.qqweq.mvpdemo.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by qqweq on 2018/10/9.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int verticalSpacing;
    private int horizontalSpacing;

    public SpacesItemDecoration(int verticalSpacing, int horizontalSpacing) {
        this.verticalSpacing = verticalSpacing;
        this.horizontalSpacing = horizontalSpacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = horizontalSpacing;
        outRect.right = horizontalSpacing;
        outRect.top = verticalSpacing;
        outRect.bottom = verticalSpacing;
    }
}
