package com.example.android.advance2_lesson2_mvvm.data.source;

import com.example.android.advance2_lesson2_mvvm.data.model.UserList;
import retrofit2.Callback;

/**
 * Created by VinhTL on 18/10/2017.
 */

public interface UserDataSource{
    //TODO: Add observable
    interface RemoteDataSource {
        void searchUsers(int limit, String keyWord, Callback<UserList> callback);
    }
}
