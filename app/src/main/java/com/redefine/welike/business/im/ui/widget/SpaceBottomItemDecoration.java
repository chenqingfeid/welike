package com.redefine.welike.business.im.ui.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liwenbo on 2018/2/8.
 */

public class SpaceBottomItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;

    public SpaceBottomItemDecoration(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        if(parent.getChildAdapterPosition(view) != 0){
            outRect.bottom = mSpace;
        }

    }
}
