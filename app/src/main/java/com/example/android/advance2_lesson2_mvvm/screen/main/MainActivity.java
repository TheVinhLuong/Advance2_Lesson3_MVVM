package com.example.android.advance2_lesson2_mvvm.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.android.advance2_lesson2_mvvm.R;
import com.example.android.advance2_lesson2_mvvm.data.UserRepository;
import com.example.android.advance2_lesson2_mvvm.data.source.UserRepositoryImpl;
import com.example.android.advance2_lesson2_mvvm.data.source.remote.UserRemoteDataSource;
import com.example.android.advance2_lesson2_mvvm.data.source.remote.api.service.NameServiceClient;
import com.example.android.advance2_lesson2_mvvm.databinding.ActivityMainBinding;
import com.example.android.advance2_lesson2_mvvm.screen.BaseActivity;
import com.example.android.advance2_lesson2_mvvm.utils.navigator.Navigator;
import com.example.android.advance2_lesson2_mvvm.widget.dialog.DialogManager;
import com.example.android.advance2_lesson2_mvvm.widget.dialog.DialogManagerImplement;

/**
 * Main Screen.
 */
public class MainActivity extends BaseActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserRepository userRepository =
                new UserRepositoryImpl(new UserRemoteDataSource(NameServiceClient
                        .getInstance(getApplication())));
        DialogManager dialogManager = new DialogManagerImplement(this);
        Navigator navigator = new Navigator(this);
        mViewModel = new MainViewModel(userRepository, dialogManager, navigator);
        
        ActivityMainBinding binding = DataBindingUtil.setContentView(this
                , R.layout.activity_main);
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
