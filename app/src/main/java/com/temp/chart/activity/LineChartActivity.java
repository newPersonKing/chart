package com.temp.chart.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lixs.charts.LineChartView;
import com.temp.chart.R;

import java.util.ArrayList;
import java.util.List;

/*折线图*/
public class LineChartActivity extends AppCompatActivity {

    LineChartView lineChartView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linechart);
        lineChartView = findViewById(R.id.lineView);
        initLineDatas();
    }

    private void initLineDatas() {
        List<Double> datas = new ArrayList<>();
        datas.add(100d);
        datas.add(20d);
//        datas.add(40d);
//        datas.add(50d);
//        datas.add(50d);
//        datas.add(60d);
//        datas.add(60d);
//        datas.add(80d);
//        datas.add(80d);

        List<String> description = new ArrayList<>();
        description.add("one");
        description.add("two");
//        description.add("three");
//        description.add("four");
//        description.add("five");
//        description.add("six");
//        description.add("six");
//        description.add("six");
//        description.add("six");

        lineChartView.setDatas(datas, description);
    }

}
