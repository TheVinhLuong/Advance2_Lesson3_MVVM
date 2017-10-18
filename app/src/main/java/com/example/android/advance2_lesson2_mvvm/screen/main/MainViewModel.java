package com.example.android.advance2_lesson2_mvvm.screen.main;

import android.databinding.Bindable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import com.example.android.advance2_lesson2_mvvm.data.UserRepository;
import com.example.android.advance2_lesson2_mvvm.data.model.User;
import com.example.android.advance2_lesson2_mvvm.data.model.UserList;
import com.example.android.advance2_lesson2_mvvm.data.source.remote.api.error.BaseException;
import com.example.android.advance2_lesson2_mvvm.data.source.remote.api.error.Type;
import com.example.android.advance2_lesson2_mvvm.data.source.remote.api.response.ErrorResponse;
import com.example.android.advance2_lesson2_mvvm.screen.BaseViewModel;
import com.example.android.advance2_lesson2_mvvm.screen.searchresult.SearchResultActivity;
import com.example.android.advance2_lesson2_mvvm.utils.Constant;
import com.example.android.advance2_lesson2_mvvm.utils.navigator.Navigator;
import com.example.android.advance2_lesson2_mvvm.widget.dialog.DialogManager;
import com.fstyle.library.DialogAction;
import com.fstyle.library.MaterialDialog;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Exposes the data to be used in the Main screen.
 */

public class MainViewModel extends BaseViewModel {
    public static String TAG = MainViewModel.class.getSimpleName();
    
    private UserRepository mUserRepository;
    private DialogManager mDialogManager;
    private Navigator mNavigator;
    //TODO: Implement validator
    private String mKeyWord;
    private String mLimit;

    public MainViewModel(UserRepository userRepository, DialogManager dialogManager,
            Navigator navigator) {
        mUserRepository = userRepository;
        mDialogManager = dialogManager;
        mNavigator = navigator;
    }

    @Bindable
    public String getKeyWord() {
        return mKeyWord;
    }

    public void setKeyWord(String keyWord) {
        mKeyWord = keyWord;
    }

    @Bindable
    public String getLimit() {
        return mLimit;
    }

    public void setLimit(String limit) {
        mLimit = limit;
    }

    public void onSearchButtonClicked(View view) {
        callAPISearchUsers();
    }

    private void callAPISearchUsers() {
        mDialogManager.showIndeterminateProgressDialog();
        mUserRepository.searchUsers(Integer.parseInt(mLimit), mKeyWord, new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                mDialogManager.dismissProgressDialog();
                if(response.isSuccessful()){
                    Log.d(TAG, new Gson().toJson(response.body().getItems()));
                    gotoSearchResultActivity(response.body().getItems());
                }else{
                    showDialogError(new BaseException(Type.SERVER, 
                            new ErrorResponse("Lỗi server")));
                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                mDialogManager.dismissProgressDialog();
                showDialogError(new BaseException(Type.NETWORK,
                        new ErrorResponse("Lỗi network")));
            }
        });
    }

    public void showDialogError(BaseException e) {
        mDialogManager.dialogError(e.getMessage(), new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog materialDialog,
                    @NonNull DialogAction dialogAction) {
                callAPISearchUsers();
            }
        });
    }

    public void gotoSearchResultActivity(List<User> users) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constant.ARGUMENT_LIST_USER,
                (ArrayList<? extends Parcelable>) users);
        mNavigator.startActivity(SearchResultActivity.class, bundle);
    }
}
