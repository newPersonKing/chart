package com.temp.chart.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lixs.charts.RadarChartView;
import com.temp.chart.R;

import java.util.ArrayList;
import java.util.List;

public class RadarChartActivity extends AppCompatActivity {

    RadarChartView radarChartView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radarchart);

        radarChartView = findViewById(R.id.radarView);
        initRadarDatas();
    }

    private void initRadarDatas() {
        List<Float> datas = new ArrayList<>();
        List<String> description = new ArrayList<>();

        datas.add(0.5f);
        datas.add(0.3f);
        datas.add(0.3f);
        datas.add(0.8f);
        datas.add(1f);
        datas.add(0.4f);

        description.add("one");
        description.add("two");
        description.add("three");
        description.add("four");
        description.add("five");
        description.add("six");

        //点击动画开启
        radarChartView.setCanClickAnimation(true);
        radarChartView.setDatas(datas);
        radarChartView.setPolygonNumbers(6);
        radarChartView.setDescriptions(description);
    }

}
