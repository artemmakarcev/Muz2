package com.example.makar_000.muz;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

    private ListView listView;
    private MyAdapter adapter;
    private TypedArray images;
    private ArrayList<ObjectItem> objectItems = new ArrayList<ObjectItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Инициализируем изображения с помощью ресурса изображений
        // данный ресурс будет рассмотрен ниже
        Resources res = getResources();
        images = res.obtainTypedArray(R.array.images);

        listView = (ListView) findViewById(R.id.list);

        // инициализация нашего адаптера
        adapter = new MyAdapter(this, new ArrayList<ObjectItem>());
        listView.setAdapter(adapter);

        new GetClass(MyListView.this).execute();

        // По клику будем выводить текст элемента
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MyListView.this, MyArticle.class);
                intent.putExtra("id", adapter.getItem(position));
//                intent.putExtra("urlImage", adapter.get)
                startActivity(intent);

//                Toast.makeText(getApplicationContext(), adapter.getItem(position).toString(),
//                Toast.makeText(getApplicationContext(), adapter.getItem(position),
//                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    private class GetClass extends AsyncTask<String, Void, Void> {

        private final Context context;
        ProgressDialog progressDialog = new ProgressDialog(MyListView.this);

        public GetClass(Context c) {
            this.context = c;
        }

        protected void onPreExecute() {
//            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
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
//                        if (object.has("id")) {
//                            object.getInt("id");
//                            object.getString("title");
//                            object.getString("description");
//                        }
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
