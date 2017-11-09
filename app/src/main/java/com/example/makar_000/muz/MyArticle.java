package com.example.makar_000.muz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyArticle extends AppCompatActivity {

    String intentId;

    @SuppressLint("SetTextI18n")
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

            TextView textHtml = (TextView) findViewById(R.id.textHtml);

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                textHtml.setText(Html.fromHtml("<p><strong>Компью́тер</strong>&nbsp;(<a href=\\\"https://ru.wikipedia.org/wiki/%D0%90%D0%BD%D0%B3%D0%BB%D0%B8%D0%B9%D1%81%D0%BA%D0%B8%D0%B9_%D1%8F%D0%B7%D1%8B%D0%BA\\\" title=\\\"Английский язык\\\">англ.</a>&nbsp;<em>computer</em>,&nbsp;<small>МФА:</small>&nbsp;<a href=\\\"https://ru.wikipedia.org/wiki/%D0%9C%D0%B5%D0%B6%D0%B4%D1%83%D0%BD%D0%B0%D1%80%D0%BE%D0%B4%D0%BD%D1%8B%D0%B9_%D1%84%D0%BE%D0%BD%D0%B5%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_%D0%B0%D0%BB%D1%84%D0%B0%D0%B2%D0%B8%D1%82\\\" title=\\\"Международный фонетический алфавит\\\">[kəmˈpjuː.tə(ɹ)]</a><sup><a href=\\\"https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%BF%D1%8C%D1%8E%D1%82%D0%B5%D1%80#cite_note-1\\\">[1]</a></sup>&nbsp;&mdash; &laquo;вычислитель&raquo;)&nbsp;&mdash; устройство или система, способная выполнять заданную, чётко определённую, изменяемую последовательность операций. Это чаще всего операции численных расчётов и манипулирования данными, однако сюда относятся и операции&nbsp;<a href=\\\"https://ru.wikipedia.org/wiki/%D0%92%D0%B2%D0%BE%D0%B4-%D0%B2%D1%8B%D0%B2%D0%BE%D0%B4\\\" title=\\\"Ввод-вывод\\\">ввода-вывода</a>. Описание последовательности операций называется&nbsp;<em><a href=\\\"https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%BF%D1%8C%D1%8E%D1%82%D0%B5%D1%80%D0%BD%D0%B0%D1%8F_%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B0\\\" title=\\\"Компьютерная программа\\\">программой</a></em><sup><a href=\\\"https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%BF%D1%8C%D1%8E%D1%82%D0%B5%D1%80#cite_note-2\\\">[2]</a></sup>.</p>\\n", Html.FROM_HTML_MODE_LEGACY));
//            } else {
//                textHtml.setText(Html.fromHtml("<p><strong>Компью́тер</strong>&nbsp;(<a href=\\\"https://ru.wikipedia.org/wiki/%D0%90%D0%BD%D0%B3%D0%BB%D0%B8%D0%B9%D1%81%D0%BA%D0%B8%D0%B9_%D1%8F%D0%B7%D1%8B%D0%BA\\\" title=\\\"Английский язык\\\">англ.</a>&nbsp;<em>computer</em>,&nbsp;<small>МФА:</small>&nbsp;<a href=\\\"https://ru.wikipedia.org/wiki/%D0%9C%D0%B5%D0%B6%D0%B4%D1%83%D0%BD%D0%B0%D1%80%D0%BE%D0%B4%D0%BD%D1%8B%D0%B9_%D1%84%D0%BE%D0%BD%D0%B5%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_%D0%B0%D0%BB%D1%84%D0%B0%D0%B2%D0%B8%D1%82\\\" title=\\\"Международный фонетический алфавит\\\">[kəmˈpjuː.tə(ɹ)]</a><sup><a href=\\\"https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%BF%D1%8C%D1%8E%D1%82%D0%B5%D1%80#cite_note-1\\\">[1]</a></sup>&nbsp;&mdash; &laquo;вычислитель&raquo;)&nbsp;&mdash; устройство или система, способная выполнять заданную, чётко определённую, изменяемую последовательность операций. Это чаще всего операции численных расчётов и манипулирования данными, однако сюда относятся и операции&nbsp;<a href=\\\"https://ru.wikipedia.org/wiki/%D0%92%D0%B2%D0%BE%D0%B4-%D0%B2%D1%8B%D0%B2%D0%BE%D0%B4\\\" title=\\\"Ввод-вывод\\\">ввода-вывода</a>. Описание последовательности операций называется&nbsp;<em><a href=\\\"https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%BF%D1%8C%D1%8E%D1%82%D0%B5%D1%80%D0%BD%D0%B0%D1%8F_%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B0\\\" title=\\\"Компьютерная программа\\\">программой</a></em><sup><a href=\\\"https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%BF%D1%8C%D1%8E%D1%82%D0%B5%D1%80#cite_note-2\\\">[2]</a></sup>.</p>\\n"));
//            }

            textHtml.setText(extras.getString("id", "1") + " | " + extras.getString("urlImage", "2"));


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
}
