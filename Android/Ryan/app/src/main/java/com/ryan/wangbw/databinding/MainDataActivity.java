package com.ryan.wangbw.databinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.socks.library.KLog;

import java.io.File;

public class MainDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityMainDataBinding binding = DataBindingUtil.setContentView(this, R.layout
//                .activity_main_data);
//        User user = new User("Test", "User");
//        binding.setUser(user);
        File file = getExternalFilesDir(null);
        if (file!=null) {
            KLog.i(file.getAbsolutePath());
        } else {
            KLog.i("file == null");
        }
    }
}
