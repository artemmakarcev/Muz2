package com.example.makar_000.muz;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyArticle extends AppCompatActivity {

    String intentId;
    TextView textHtml;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_article);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
//        Intent intent = getIntent();
//        intentId = intent.getIntExtra("itemIndex", 1);
            intentId = extras.getString("id", "1");

//            toolbar.setTitle(extras.getString("nameTitle"));
//            toolbar.setSubtitle("title");


            Log.i("test", String.valueOf(extras.getString("id", "1")));
            Log.i("test", String.valueOf(extras.getString("nameTitle", "Статья")));

            TextView textHtml = (TextView) findViewById(R.id.textHtml);
            TextView nameArticle = (TextView) findViewById(R.id.nameArticle);

            nameArticle.setText(extras.getString("nameTitle"));

//            textHtml.setText(extras.getString("id", "1") + " | " + extras.getString("urlImage", "2"));

            new GetClass().execute();
        }

        ImageView imageView = (ImageView) findViewById(R.id.mainImage);

        assert extras != null;
        Picasso.with(MyArticle.this)
                .load("http://itmuseum.shspu.ru/images/article/thumbnail/" + extras.getString("urlImage", "2"))
//                .load("http://itmuseum.shspu.ru/images/article/" + extras.getString("urlImage", "2"))
//                .resize(200, 200)
//                .centerCrop()
                .into(imageView, null);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @SuppressLint("StaticFieldLeak")
    private class GetClass extends AsyncTask<String, Void, String> {

        //        ProgressDialog progressDialog = new ProgressDialog(MyArticle.this);
        String resultJson = "";

        protected void onPreExecute() {
//            progressDialog.setTitle("Please wait");
//            progressDialog.setMessage("Loading");
//            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {

                URL url = new URL("http://itmuseum.shspu.ru/api/getArticle.php?id=" + intentId);
//
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                int responseCode = connection.getResponseCode();
                System.out.println("Response Code : " + responseCode);

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                System.out.println(br);

                StringBuilder builder = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }
                br.close();

                builder.append(builder.toString());
                resultJson = builder.toString();
                System.out.println(builder);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultJson;
        }

        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);

            try {
                JSONObject jsonAll;
                jsonAll = new JSONObject(strJson);

                String text = jsonAll.getString("text");

                Log.i("JSON", text);

                TextView textHtml = (TextView) findViewById(R.id.textHtml);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    textHtml.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
                } else {
                    textHtml.setText(Html.fromHtml(text));
                }


//                textHtml.setText("123");


            } catch (JSONException e) {
                e.printStackTrace();
            }

//            progressDialog.dismiss();
        }

    }

}
