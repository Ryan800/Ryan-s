package com.ryan.wangbw.retrofit.gitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ryan.wangbw.myapplication.BuildConfig;
import com.ryan.wangbw.myapplication.R;
import com.ryan.wangbw.retrofit.gitdemo.api.GitHubService;
import com.ryan.wangbw.retrofit.gitdemo.model.GitModel;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class GitActivity extends AppCompatActivity {

    String API = "https://api.github.com";

    Button mClickBtn;
    TextView mTextView;
    EditText mEditText;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git);

        mClickBtn = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.tv);
        mEditText = (EditText) findViewById(R.id.edit);
        mProgressBar = (ProgressBar) findViewById(R.id.pb);
        mProgressBar.setVisibility(View.INVISIBLE);
        mClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mEditText.getText().toString();
                mProgressBar.setVisibility(View.VISIBLE);
                req(user);
            }
        });
    }

    private void req(String user) {
        OkHttpClient httpClient = new OkHttpClient();
        if (BuildConfig.DEBUG) {
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call call = gitHubService.getUser(user);
        call.enqueue(new Callback<GitModel>() {
            @Override
            public void onResponse(Response<GitModel> response, Retrofit retrofit) {
                GitModel model = response.body();
                if (model == null) {
                    ResponseBody responsebody = response.errorBody();
                    if (responsebody!=null) {
                        mTextView.setText("responseBody = " + responsebody.toString());
                    } else {
                        mTextView.setText("responseBody == null");
                    }
                } else {
                    mTextView.setText("Github Name:"+model.getName()+"\nWebsite:"+model.getBlog());
                }
                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Throwable t) {
                mTextView.setText("t = "+t.getMessage());
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void req2() {

    }
}
