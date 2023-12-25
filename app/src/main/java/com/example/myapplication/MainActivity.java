package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.sahana.horizontalcalendar.HorizontalCalendar;
import com.sahana.horizontalcalendar.model.DateModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private TextView mDateTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thoikhoabieu);
        HorizontalCalendar mHorizontalCalendar = findViewById(R.id.horizontalCalendar);
        mDateTextView = findViewById(R.id.dateTextView);
        ProgressBar khongdiemdanh=(ProgressBar) findViewById(R.id.khongDiemDanh); // initiate the progress bar
        khongdiemdanh.setMax(100);
        khongdiemdanh.setProgress(50);
        mHorizontalCalendar.setOnDateSelectListener(dateModel -> {
            mDateTextView.setText(dateModel != null ?
                    dateModel.day + " " + dateModel.dayOfWeek + " " + dateModel.month + "," + dateModel.year : "");
            handleEvents(dateModel);
        });
    }
    private void handleEvents(DateModel dateModel) {
        //BE check ngày để show ra data
        ListView listView;
        ArrayAdapter<Schedule> adapter;
        ArrayList<Schedule> arrSchedule = new ArrayList<>();
        listView = findViewById(R.id.lv_thoi_khoa_bieu);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrSchedule);
        listView.setAdapter(adapter);
        for (int i=1; i<5; i++){
            Schedule schedule = new Schedule();
            schedule.setMonHoc("Triết học Mác-Lênin");
            schedule.setBuoi("Sáng");
            List<Integer> tiet = new ArrayList<>();
            tiet.add(1);
            tiet.add(2);
            schedule.setTiet(tiet);
            schedule.setGiaoVien("Nguyễn Thị A");
            schedule.setDiaDiem("614 - A10");
            arrSchedule.add(schedule);
        }
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Schedule schedule = arrSchedule.get(position);
            //check thời gian điểm danh
            List<Integer> tietHoc = schedule.getTiet();
            tietHoc.stream().sorted().toArray();
            Integer first = tietHoc.stream().findFirst().get();
            Integer last = tietHoc.get(tietHoc.size()-1);
            Date firstTime = getTime(first, "first");
            Date lastTime = getTime(last, "last");
            Date currentTime = new Date();
            if(currentTime.after(firstTime) && currentTime.before(lastTime)) {
                new AlertDialog.Builder(this).setMessage("Bạn có muốn điểm danh")
                        .setNegativeButton("Không", ((dialog, which) -> {
                        })).setPositiveButton("Đồng ý", ((dialog, which) -> {
                            //set hành động sau khi click điểm danh
                            new AlertDialog.Builder(this).setMessage("Điểm danh thành công").show();
                            adapter.notifyDataSetChanged();
                        })).show();
            }else{
                new AlertDialog.Builder(this).setMessage("Vui lòng điểm danh trong thời gian học").show();
            }
        });
    }
    Date getTime (Integer tietHoc, String type){
        Date first = new Date();
        Date last = new Date();
        switch (tietHoc){
            case 1:
                first.setHours(7);
                first.setMinutes(0);
                first.setSeconds(0);
                last.setHours(7);
                last.setMinutes(50);
                last.setSeconds(0);
                break;
            case 2:
                first.setHours(7);
                first.setMinutes(50);
                first.setSeconds(0);
                last.setHours(8);
                last.setMinutes(40);
                last.setSeconds(0);
                break;
            case 3:
                first.setHours(8);
                first.setMinutes(50);
                first.setSeconds(0);
                last.setHours(9);
                last.setMinutes(40);
                last.setSeconds(0);
                break;
            case 4:
                first.setHours(9);
                first.setMinutes(50);
                first.setSeconds(0);
                last.setHours(10);
                last.setMinutes(40);
                last.setSeconds(0);
                break;
            case 5:
                first.setHours(10);
                first.setMinutes(40);
                first.setSeconds(0);
                last.setHours(11);
                last.setMinutes(30);
                last.setSeconds(0);
                break;
            case 6:
                first.setHours(11);
                first.setMinutes(30);
                first.setSeconds(0);
                last.setHours(12);
                last.setMinutes(20);
                last.setSeconds(0);
                break;
            case 7:
                first.setHours(12);
                first.setMinutes(30);
                first.setSeconds(0);
                last.setHours(13);
                last.setMinutes(20);
                last.setSeconds(0);
                break;
        }
        if(type.equals("first")){
            return first;
        }
        return last;
    }
}