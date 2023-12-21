package com.example.myapplication.lcb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Môn 1", "-----", "Chi tiết 1", "8.5"));

        subjects.add(new Subject("Môn 2", "---", "Chi tiết 2", "7.5"));



        SubjectAdapter adapter = new SubjectAdapter(this, subjects);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}