package com.redefine.welike.business.feeds.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.redefine.commonui.dialog.MenuItem;
import com.redefine.commonui.dialog.MenuItemIdConstant;
import com.redefine.commonui.dialog.OnMenuItemClickListener;
import com.redefine.commonui.dialog.SimpleMenuAutoGravityDialog;
import com.redefine.commonui.loadmore.viewholder.BaseRecyclerViewHolder;
import com.redefine.welike.R;
import com.redefine.welike.business.feeds.ui.bean.FeedDetailCommentHeadBean;
import com.redefine.welike.business.feeds.ui.listener.IFeedDetailCommentOpListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwenbo on 2018/4/18.
 * <p>
 * hot / latest
 * <p>
 * changed by zhl 2018 /5 /30
 */

public class FeedDetailCommentHeaderViewHolder extends BaseRecyclerViewHolder<FeedDetailCommentHeadBean> {

    private final TextView mHotSwitch;
    private final ImageView mHotSwitchArrow;
    private final IFeedDetailCommentOpListener mListener;
    private String mCreatedSortText;
    private String mHotSortText;
    private String currentText;


    public FeedDetailCommentHeaderViewHolder(View itemView, IFeedDetailCommentOpListener listener) {
        super(itemView);
        mHotSwitch = itemView.findViewById(R.id.feed_detail_comment_hot_switch);
        mHotSwitchArrow = itemView.findViewById(R.id.feed_detail_comment_arrow);
        mListener = listener;
        mHotSortText = itemView.getResources().getString(R.string.sort_hot_text);
        mCreatedSortText = itemView.getResources().getString(R.string.sort_created_text);
    }

    @Override
    public void bindViews(RecyclerView.Adapter adapter, final FeedDetailCommentHeadBean data) {
        super.bindViews(adapter, data);
        if (data.getSortType() == FeedDetailCommentHeadBean.CommentSortType.HOT) {
            mHotSwitch.setText(mHotSortText);
            currentText = mHotSortText;
        } else {
            mHotSwitch.setText(mCreatedSortText);
            currentText = mCreatedSortText;
        }
        if (mListener != null) {
            mHotSwitch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMenu(v, data);
                }
            });
            mHotSwitchArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMenu(v, data);
                }
            });
        }

    }

    private void showMenu(View v, final FeedDetailCommentHeadBean data) {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem(MenuItemIdConstant.MENU_ITEM_SORT_HOT, mHotSortText, TextUtils.equals(mHotSortText, currentText)));
        list.add(new MenuItem(MenuItemIdConstant.MENU_ITEM_SORT_LATEST, mCreatedSortText, TextUtils.equals(mCreatedSortText, currentText)));

        SimpleMenuAutoGravityDialog.show(v.getContext(), list, v, new OnMenuItemClickListener() {
            @Override
            public void onMenuClick(MenuItem menuItem) {
                if (menuItem.menuId == MenuItemIdConstant.MENU_ITEM_SORT_HOT) {
                    if (data.getSortType() == FeedDetailCommentHeadBean.CommentSortType.CREATED) {
                        mListener.onSwitchCommentOrder(FeedDetailCommentHeadBean.CommentSortType.HOT);
                        mHotSwitch.setText(mHotSortText);
                        currentText = mHotSortText;
                    }
                } else if (menuItem.menuId == MenuItemIdConstant.MENU_ITEM_SORT_LATEST) {
                    if (data.getSortType() == FeedDetailCommentHeadBean.CommentSortType.HOT) {
                        mListener.onSwitchCommentOrder(FeedDetailCommentHeadBean.CommentSortType.CREATED);
                        mHotSwitch.setText(mCreatedSortText);
                        currentText = mCreatedSortText;
                    }
                }
            }
        });
    }
}
