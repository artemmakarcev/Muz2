package com.example.makar_000.muz;

/**
 * Created by makar_000 on 13.04.2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        return data.get(position).getTitle();
    }

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
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView time = (TextView)view.findViewById(R.id.time);
        ImageView thumbImage = (ImageView)view.findViewById(R.id.imageView);

        // получаем элемент со списка
        ObjectItem objectItem = data.get(position);

        // устанавливаем значения компонентам одного эелемента списка
        time.setText(objectItem.getTitle().toString());
//        title.setText(objectItem.getDate());
        thumbImage.setImageDrawable(objectItem.getImage());

        return view;
    }
}