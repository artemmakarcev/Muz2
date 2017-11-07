package com.example.makar_000.muz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    public List<ObjectItem> data;
    private Context context;

    public MyAdapter(Context context, List<ObjectItem> data) {
        super(context, R.layout.my_listview);
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        // возвращаем количество элементов списка
        return data.size();
    }

    @Override
    public String getItem(int position) {
        // получение одного элемента по индексу
        return data.get(position).getId();
    }

//    @Override
//    public String getUrlImage() {
//        // получение одного элемента по индексу
//        return data.getImage();
//    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    // заполнение элементов списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // задаем вид элемента списка, который мы создали высше
        View view = inflater.inflate(R.layout.my_listview, parent, false);

        // проставляем данные для элементов
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView type = (TextView) view.findViewById(R.id.type);
        TextView description = (TextView) view.findViewById(R.id.description);
//        ImageView thumbImage = (ImageView) view.findViewById(R.id.imageView);
        WebView image = (WebView) view.findViewById(R.id.image);

        // получаем элемент со списка
        ObjectItem objectItem = data.get(position);

        // устанавливаем значения компонентам одного эелемента списка
        title.setText(objectItem.getTitle());
        type.setText(objectItem.getCategory());
        description.setText(objectItem.getDescription());
        image.loadUrl("http://itmuseum.shspu.ru/images/article/thumbnail/" + objectItem.getImage());

        image.getSettings().setLoadWithOverviewMode(true);
        image.getSettings().setUseWideViewPort(true);
//        http://itmuseum.shspu.ru/images/article/thumbnail/10:07:57_toshtop.jpg
//        try {
//            URL url = new URL("http://itmuseum.shspu.ru/images/article/thumbnail/10:07:57_toshtop.jpg");
//            Bitmap btp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            thumbImage.setImageBitmap(btp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        title.setText(objectItem.getDate());
//        thumbImage.setImageDrawable(objectItem.getImage());
//        thumbImage.setImageDrawable(R.drawable.close);

        return view;
    }

}