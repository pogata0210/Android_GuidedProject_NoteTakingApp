package com.lambdaschool.notetaker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Long> notes;
    private Context         context;
    private LinearLayout    listLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notes = new ArrayList<>();
        context = this;
        listLayout = findViewById(R.id.list_layout);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes.add(System.currentTimeMillis());
                int noteIndex = notes.size() - 1;
                listLayout.addView(getDefaultTextView(notes.get(noteIndex).toString()));
                Log.i(getLocalClassName(), notes.toString());
            }
        });
    }

    private TextView getDefaultTextView(String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(24);
        textView.setPadding(10, 10, 10, 10);
        return textView;
    }
}