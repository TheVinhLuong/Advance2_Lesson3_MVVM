package com.example.android.advance2_lesson2_mvvm.screen;


public interface BasePresenter<T> {

    void setView(T view);

    void onStart();

    void onStop();
}
