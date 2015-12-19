package com.ryan.wangbw.volley;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ryan.wangbw.base.BaseAty;
import com.ryan.wangbw.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VolleyActivity extends BaseAty {

    @Bind(R.id.getStringBtn)
    Button mGetStringBtn;
    @Bind(R.id.getJsonBtn)
    Button mGetJsonBtn;
    @Bind(R.id.getImageBtn)
    Button mGetImageBtn;

    @Bind(R.id.volleyTv)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.getStringBtn)
    public void getString() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.sina.com" +
                ".cn", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    @OnClick(R.id.getJsonBtn)
    public void getJson() {

    }

}
