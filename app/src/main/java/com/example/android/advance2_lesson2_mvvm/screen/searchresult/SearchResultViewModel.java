package com.example.android.advance2_lesson2_mvvm.screen.searchresult;

import com.example.android.advance2_lesson2_mvvm.data.model.User;
import com.example.android.advance2_lesson2_mvvm.screen.BaseRecyclerViewAdapter;
import com.example.android.advance2_lesson2_mvvm.screen.BaseViewModel;

/**
 * Exposes the data to be used in the SearchResult screen.
 */

public class SearchResultViewModel extends BaseViewModel 
        implements BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User>{

    private SearchResultAdapter mAdapter;

    public SearchResultViewModel(SearchResultAdapter adapter) {
        mAdapter = adapter;
        mAdapter.setItemClickListener(this);
    }

    public SearchResultAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(SearchResultAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public void onItemRecyclerViewClick(User item) {
    }
    
}
