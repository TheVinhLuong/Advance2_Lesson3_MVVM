package com.example.android.advance2_lesson2_mvvm.data;

import com.example.android.advance2_lesson2_mvvm.data.model.UserList;
import retrofit2.Callback;

public interface UserRepository {
    //TODO: implement observable
    void searchUsers(int limit, String keyWord, Callback<UserList> callback);
}