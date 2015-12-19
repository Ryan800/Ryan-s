package com.ryan.wangbw.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ryan.wangbw.myapplication.R;

public class BaseAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_aty);

    }

    protected void skipAty(Class<?> clazz, boolean isFinish) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        if (isFinish) {
            finish();
        }
    }
    
    protected void TShort(int strId) {
        TShort(getString(strId));
    }
    
    protected void TShort(String str) {
        Toast.makeText(BaseAty.this, str, Toast.LENGTH_SHORT).show();
    }
}
