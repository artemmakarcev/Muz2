package com.example.makar_000.muz;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

public class MyListView extends AppCompatActivity {

    private MyAdapter adapter;
    private ArrayList<ObjectItem> objectItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Инициализируем изображения с помощью ресурса изображений
        // данный ресурс будет рассмотрен ниже

        ListView listView = (ListView) findViewById(R.id.list);

        adapter = new MyAdapter(this, new ArrayList<ObjectItem>());
        listView.setAdapter(adapter);

        new GetClass().execute();

        // По клику будем выводить текст элемента
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyListView.this, MyArticle.class);
                intent.putExtra("id", adapter.getItem(position));
                intent.putExtra("urlImage", adapter.getUrlImage(position));
                intent.putExtra("nameTitle", adapter.getNameTitle(position));
                startActivity(intent);

//                Toast.makeText(getApplicationContext(), adapter.getItem(position).toString(),
//                Toast.makeText(getApplicationContext(), adapter.getItem(position),
//                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    @SuppressLint("StaticFieldLeak")
    public class GetClass extends AsyncTask<String, Void, Void> {

        ProgressDialog progressDialog = new ProgressDialog(MyListView.this);

        protected void onPreExecute() {
            progressDialog.setTitle("Please wait");
            progressDialog.setMessage("Loading");
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(String... params) {
            try {

                URL url = new URL("http://itmuseum.shspu.ru/api/getArticles.php");
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

                System.out.println(builder);
                try {
                    JSONArray arr = new JSONArray(builder.toString());
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject object = arr.getJSONObject(i);
                        objectItems.add(new ObjectItem(object.getString("id"), object.getString("title"), object.getString("category"), object.getString("description"), object.getString("image")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            adapter.data = objectItems;
            adapter.notifyDataSetChanged();
        }

    }

}
