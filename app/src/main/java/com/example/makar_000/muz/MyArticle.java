package com.example.makar_000.muz;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.makar_000.muz.R.string.large_text;

public class MyArticle extends AppCompatActivity {

    String intentId;
    private ArrayList<ObjectItem> objectItems = new ArrayList<ObjectItem>();
    WebView mWebViewDescription, mWebViewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
//        Intent intent = getIntent();
//        intentId = intent.getIntExtra("itemIndex", 1);
            intentId = extras.getString("id", "1");

            Log.i("test", String.valueOf(extras.getString("id", "1")));

            mWebViewDescription = (WebView) findViewById(R.id.webView);
            mWebViewDescription.loadUrl("http://itmuseum.shspu.ru/?p=view&id=" + intentId);
        }
        mWebViewDescription.getSettings().setLoadWithOverviewMode(true);
        mWebViewDescription.getSettings().setUseWideViewPort(true);

        mWebViewImage = (WebView) findViewById(R.id.imageTitle);
        mWebViewImage.loadUrl("http://itmuseum.shspu.ru/images/article/thumbnail/10:07:57_toshtop.jpg");

        mWebViewImage.getSettings().setLoadWithOverviewMode(true);
        mWebViewImage.getSettings().setUseWideViewPort(true);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
}
