package com.example.makar_000.muz;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class MyListView extends Activity {

    private ListView listView;
    private MyAdapter adapter;
    private TypedArray images;
    private static long back_pressed;
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
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

//                String message = adapter.getItem(position).toString();
                // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
                // второй параметр - значение этого объекта
//                intent.putExtra(EXTRA_MESSAGE, message);

                startActivity(intent);
//                Toast.makeText(getApplicationContext(), adapter.getItem(position).toString(),
//                        Toast.LENGTH_SHORT).show();
            }
        });
    }


//    // Этот медот будет инициализировать список даных для ListView
//    private ArrayList<ObjectItem> initData() {
//        // ObjectItem это наш POJO объект который мы ниже разберем.
//        // Даный список будет возвращаться для заполнения LIstView
//        ArrayList<ObjectItem> maps = new ArrayList<ObjectItem>();
//
//
//
////        for (int a = 1; a < 101; a++) {
////
////            ObjectItem objectItema = new ObjectItem("Title "+ a ,
////                    "Description " + a + " Краткое описание экспоната в музее",
////                    images.getDrawable(IMGEnum.NOTDONE.index()));
////
////            maps.add(objectItema);
////
////        }
//
////        ObjectItem objectItem1 = new ObjectItem("Test 1",
////                GregorianCalendar.getInstance().getTime(),
////                images.getDrawable(IMGEnum.DONE.index()));
////
////        maps.add(objectItem1);
////
////        ObjectItem objectItem2 = new ObjectItem("Test 2",
////                GregorianCalendar.getInstance().getTime(),
////                images.getDrawable(IMGEnum.NOTDONE.index()));
////
////        maps.add(objectItem2);
////
//        return maps;
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (back_pressed + 3000 > System.currentTimeMillis()) super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), "Для выхода нажмите ещё назад", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
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

                URL url = new URL("http://itmuseum.shspu.ru/api/4");
//
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                String urlParameters = "fizz=buzz";
                connection.setRequestMethod("GET");
                connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
                connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");

                int responseCode = connection.getResponseCode();
//                System.out.println("\nSending 'POST' request to URL : " + url);
//                System.out.println("Post parameters : " + urlParameters);
                System.out.println("Response Code : " + responseCode);
                final StringBuilder output = new StringBuilder();//"Request URL " + url
                //output.append(System.getProperty("line.separator") + "Request Parameters " + urlParameters);
//                output.append(System.getProperty("line.separator")  + "Response Code " + responseCode);
//                output.append(System.getProperty("line.separator")  + "Type " + "GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder responseOutput = new StringBuilder();
                System.out.println("output===============" + br);
                while ((line = br.readLine()) != null) {
                    responseOutput.append(line + "\n");
                }
                br.close();

                output.append(responseOutput.toString());//+ "Response "
//                output.append(System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator") + responseOutput.toString());//+ "Response "

                System.out.println(output);
                try {
                    JSONArray arr = new JSONArray(output.toString());
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject object = arr.getJSONObject(i);
//                        if (object.has("id")) {
//                            object.getInt("id");
//                            object.getString("title");
//                            object.getString("description");
//                        }
                        objectItems.add(new ObjectItem(object.getInt("id"), object.getString("title"), object.getString("description")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                        outputView.setText(output);
                progressDialog.dismiss();

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
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
