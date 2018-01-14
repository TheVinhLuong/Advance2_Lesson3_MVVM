package com.example.android.advance2_lesson2_mvvm.screen.searchresult;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.android.advance2_lesson2_mvvm.R;
import com.example.android.advance2_lesson2_mvvm.data.model.User;
import com.example.android.advance2_lesson2_mvvm.databinding.ActivitySearchResultBinding;
import com.example.android.advance2_lesson2_mvvm.screen.BaseActivity;
import com.example.android.advance2_lesson2_mvvm.utils.Constant;
import java.util.ArrayList;

/**
 * SearchResult Screen.
 */
public class SearchResultActivity extends BaseActivity {

    private SearchResultViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<User> users =
                getIntent().getParcelableArrayListExtra(Constant.ARGUMENT_LIST_USER);
        SearchResultAdapter searchResultAdapter = new SearchResultAdapter(this, users);
        mViewModel = new SearchResultViewModel(searchResultAdapter);
        ActivitySearchResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_search_result);
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
