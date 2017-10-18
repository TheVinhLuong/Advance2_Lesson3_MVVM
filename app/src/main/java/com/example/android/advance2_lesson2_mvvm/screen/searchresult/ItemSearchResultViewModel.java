package com.example.android.advance2_lesson2_mvvm.screen.searchresult;

import android.databinding.BaseObservable;
import android.view.View;
import com.example.android.advance2_lesson2_mvvm.data.model.User;
import com.example.android.advance2_lesson2_mvvm.screen.BaseRecyclerViewAdapter;

public class ItemSearchResultViewModel extends BaseObservable {

    private User mUser;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> mItemClickListener;

    public ItemSearchResultViewModel(User user,
            BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> listener) {
        mUser = user;
        mItemClickListener = listener;
    }

    public String getUserLogin() {
        return mUser.getLogin();
    }

    public void onItemClicked(View view) {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mUser);
    }
}