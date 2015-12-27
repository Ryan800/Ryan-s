package com.ryan.wangbw.myapplication;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ryan.wangbw.base.BaseAty;

public class MainActivity extends BaseAty implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.testIv);
//        Picasso.with(this).load("http://pic.nipic.com/2007-11-09/2007119122519868_2.jpg").into(imageView);
        setSupportActionBar(toolbar);


        initViews();
    }

    private void initViews() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
        findViewById(R.id.rv1Btn).setOnClickListener(this);
        findViewById(R.id.rv2Btn).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
    private void initData() {

        getLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<Object>() {
            @Override
            public Loader<Object> onCreateLoader(int id, Bundle args) {
                return null;
            }

            @Override
            public void onLoadFinished(Loader<Object> loader, Object data) {

            }

            @Override
            public void onLoaderReset(Loader<Object> loader) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rv1Btn:

                break;
            case R.id.rv2Btn:
                break;
        }
    }
}
