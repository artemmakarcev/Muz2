package com.example.makar_000.muz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    public List<ObjectItem> data;
    private Context context;

    MyAdapter(Context context, List<ObjectItem> data) {
        super(context, R.layout.my_listview);
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position).getId();
    }

    String getUrlImage(int position) {
        return data.get(position).getImage();
    }
    String getNameTitle(int position) {
        return data.get(position).getTitle();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // заполнение элементов списка
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.my_listview, parent, false);

        // проставляем данные для элементов
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView type = (TextView) view.findViewById(R.id.type);
        TextView description = (TextView) view.findViewById(R.id.description);
        ImageView imageArticle = (ImageView) view.findViewById(R.id.imageView);

        ObjectItem objectItem = data.get(position);

        // устанавливаем значения компонентам одного эелемента списка
        title.setText(objectItem.getTitle());
        type.setText(objectItem.getCategory());
        description.setText(objectItem.getDescription());
//        imageArticle.setImageBitmap();

        Picasso.with(context)
                .load("http://itmuseum.shspu.ru/images/article/thumbnail/" + objectItem.getImage())
                .resize(60, 60)
                .into(imageArticle);

        return view;
    }

}