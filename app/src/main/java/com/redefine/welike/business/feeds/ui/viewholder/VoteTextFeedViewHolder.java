package com.redefine.welike.business.feeds.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.redefine.commonui.loadmore.viewholder.BaseRecyclerViewHolder;
import com.redefine.foundation.utils.NetWorkUtil;
import com.redefine.welike.MyApplication;
import com.redefine.welike.R;
import com.redefine.welike.base.profile.AccountManager;
import com.redefine.welike.base.profile.bean.Account;
import com.redefine.welike.base.resource.ResourceTool;
import com.redefine.welike.base.util.TimeUtil;
import com.redefine.welike.business.browse.management.constant.BrowseConstant;
import com.redefine.welike.business.feeds.management.bean.PollItemInfo;
import com.redefine.welike.business.feeds.management.bean.PollPost;
import com.redefine.welike.business.feeds.management.bean.PostBase;
import com.redefine.welike.business.feeds.ui.adapter.FeedRecyclerViewAdapter;
import com.redefine.welike.business.feeds.ui.adapter.VoteTextAdapter;
import com.redefine.welike.business.feeds.ui.listener.GuideListener;
import com.redefine.welike.business.feeds.ui.listener.IFeedOperationListener;
import com.redefine.welike.business.feeds.ui.listener.IVoteChoiceListener;
import com.redefine.welike.business.feeds.ui.view.CommonFeedVoteHeader;
import com.redefine.welike.common.util.DateTimeUtil;
import com.redefine.welike.commonui.event.expose.ExposeEventReporter;
import com.redefine.welike.commonui.view.MultiTextVoteView;
import com.redefine.welike.statistical.EventConstants;
import com.redefine.welike.statistical.EventLog1;

import java.util.ArrayList;

/**
 * Created by mengnan on 2018/5/13.
 **/
public class VoteTextFeedViewHolder extends TextFeedViewHolder implements VoteTextAdapter.OnVoteTextItemCheckedListener {

    private PollPost mVotePost;

    private MultiTextVoteView mMultiTextView;

    private LinearLayout rlCB;

    private RelativeLayout rlRT;

    private TextView tvRightText, tvVoteCheck2PostInfo;

    private ImageView ivVoteCheck2Post;

    private CommonFeedVoteHeader mCommonFeedVoteHeader;

    private boolean isAccout = false;

    private VoteTextAdapter mAdapter;

    private IVoteChoiceListener listener;
    private RecyclerView.Adapter mHostAdapter;

    public VoteTextFeedViewHolder(View itemView, IFeedOperationListener listener, IVoteChoiceListener voteChoiceListener) {
        super( itemView, listener);
        this.listener = voteChoiceListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {

        mMultiTextView = itemView.findViewById(R.id.vote_text_multi_view);
        rlCB = itemView.findViewById(R.id.common_feed_bottom_cb);
        rlRT = itemView.findViewById(R.id.common_feed_bottom_tx);
        tvRightText = itemView.findViewById(R.id.tv_right_text);
        tvVoteCheck2PostInfo = itemView.findViewById(R.id.tv_vote_check_2_post_info);
        ivVoteCheck2Post = itemView.findViewById(R.id.iv_vote_check_2_post);
        mCommonFeedVoteHeader=itemView.findViewById(R.id.common_vote_header);


        mAdapter = new VoteTextAdapter();
        mAdapter.setVoteItemCheckedListener(this);
        mMultiTextView.setAdapter(mAdapter);

    }

    @Override
    public void bindViews(RecyclerView.Adapter adapter, PostBase postBase) {
        super.bindViews(adapter, postBase);
        mHostAdapter = adapter;
        if (postBase instanceof PollPost) {
            mVotePost = (PollPost) postBase;
            if (null != mVotePost.mPollInfo) {
                initHeader();
                Account account = AccountManager.getInstance().getAccount();
                if (account != null && account.getUid().equals(mVotePost.getUid())) {
                    isAccout = true;
                } else {
                    isAccout = false;
                }
                refreshView();
            }
        }
    }

    private void initHeader(){
        mCommonFeedVoteHeader.initViews(mVotePost);

    }

    private void refreshView() {
        mAdapter.setIsEndAndIsVote(mVotePost.mPollInfo.isPoll, mVotePost.mPollInfo.expirePoll, isAccout);
        mAdapter.setTotal(mVotePost.mPollInfo.totalCount);
        mAdapter.setData(mVotePost.mPollInfo.pollItemInfoList);
        if (mHostAdapter instanceof FeedRecyclerViewAdapter) {
            mAdapter.bindSourceAndPost(((FeedRecyclerViewAdapter) mHostAdapter).getFeedSource(), mVotePost);
        }
        if (isAccout || mVotePost.mPollInfo.isPoll || mVotePost.mPollInfo.expirePoll) {
            rlCB.setVisibility(View.GONE);
        } else {
            rlCB.setVisibility(View.VISIBLE);
        }
        setCheckBox();
        rlCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2018/5/11
                if (iBrowseClickListener != null) {
                    iBrowseClickListener.onBrowseClick(BrowseConstant.TYPE_UNKOWN,true, 0);
                    return;
                }
                mVotePost.setRePost(!mVotePost.isRePost());
                setCheckBox();
                if (voteListener != null) {
                    voteListener.onClick(rlCB);
                }
            }
        });
        tvVoteCheck2PostInfo.setText(ResourceTool.getString(ResourceTool.ResourceFileEnum.FEED, "poll_about_info_1"));
        if (mVotePost.mPollInfo.expirePoll)
            tvRightText.setText(String.format(ResourceTool.getString(ResourceTool.ResourceFileEnum.FEED, "poll_end_info"), mVotePost.mPollInfo.totalCount));
        else {
            if (mVotePost.mPollInfo.expiredTime == -1) {
                tvRightText.setText(String.format(ResourceTool.getString(ResourceTool.ResourceFileEnum.FEED, "poll_no_limit_info"), mVotePost.mPollInfo.totalCount));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                if (!DateTimeUtil.INSTANCE.getVoteExpiredDayTime(mVotePost.mPollInfo.expiredTime).equals("0")) {
                    stringBuilder.append(DateTimeUtil.INSTANCE.getVoteExpiredDayTime(mVotePost.mPollInfo.expiredTime));
                    stringBuilder.append(ResourceTool.getString(ResourceTool.ResourceFileEnum.COMMON, "days"));
                }
                if (!DateTimeUtil.INSTANCE.getVoteExpiredHourTime(mVotePost.mPollInfo.expiredTime).equals("0")) {
                    stringBuilder.append(DateTimeUtil.INSTANCE.getVoteExpiredHourTime(mVotePost.mPollInfo.expiredTime));
                    stringBuilder.append(ResourceTool.getString(ResourceTool.ResourceFileEnum.COMMON, "hour"));
                }
                stringBuilder.append(String.format(ResourceTool.getString(ResourceTool.ResourceFileEnum.FEED, "poll_reset_info"), mVotePost.mPollInfo.totalCount));
                tvRightText.setText(stringBuilder.toString());
            }
        }
    }

    private void setCheckBox() {
        if (mVotePost.isRePost())
            ivVoteCheck2Post.setImageResource(R.drawable.ic_vote_checked_icon);
        else ivVoteCheck2Post.setImageResource(R.drawable.ic_vote_un_check_icon);
    }

    @Override
    public void onChecked(int pos) {

        try {

            if (mListener != null) {
                mListener.onPostAreaClick(mVotePost, EventConstants.CLICK_AREA_POLL);
            }


            if (iBrowseClickListener != null) {
                iBrowseClickListener.onBrowseClick(BrowseConstant.TYPE_UNKOWN,true, 0);
                return;
            }
            if (listener == null) return;
            if(!AccountManager.getInstance().isLogin()) return;
            if (!NetWorkUtil.isNetWorkConnected(MyApplication.getAppContext())) {
                Toast.makeText(MyApplication.getAppContext(), ResourceTool.getString(ResourceTool.ResourceFileEnum.ERROR_CODE, "error_network_poor"), Toast.LENGTH_SHORT).show();
                return;
            }
            if (mVotePost.mPollInfo.isPoll) return;
            mVotePost.mPollInfo.totalCount++;
            mVotePost.mPollInfo.pollItemInfoList.get(pos).choiceCount++;
            mVotePost.mPollInfo.pollItemInfoList.get(pos).isSelected = true;
            mVotePost.mPollInfo.isPoll = true;
            refreshView();

            String pollId = mVotePost.mPollInfo.pollId;
            ArrayList<PollItemInfo> choiceIds = new ArrayList<>();
            choiceIds.add(mVotePost.mPollInfo.pollItemInfoList.get(pos));
            this.listener.onTextVote(mVotePost.getPid(), pollId, choiceIds, mVotePost.isRePost());

            if (mHostAdapter instanceof FeedRecyclerViewAdapter) {
                ExposeEventReporter.INSTANCE.reportPostClick(mVotePost, ((FeedRecyclerViewAdapter) mHostAdapter).getFeedSource(), EventLog1.FeedView.FeedClickArea.POLL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick() {
        if (mListener != null) {
            mListener.onPostAreaClick(mVotePost, EventConstants.CLICK_AREA_POLL);
        }
    }

    public GuideListener<BaseRecyclerViewHolder> voteListener;
}
