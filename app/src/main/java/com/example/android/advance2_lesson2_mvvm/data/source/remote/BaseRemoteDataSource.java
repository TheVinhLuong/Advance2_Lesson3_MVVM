package com.example.android.advance2_lesson2_mvvm.data.source.remote;

import com.example.android.advance2_lesson2_mvvm.data.source.remote.api.service.NameApi;

/**
 * Created by VinhTL on 18/10/2017.
 */

public class BaseRemoteDataSource {
    NameApi mNameApi;

    public BaseRemoteDataSource(NameApi nameApi) {
        mNameApi = nameApi;
    }
}
