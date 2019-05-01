package com.temp.chart.activity;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;


import com.lixs.charts.BarChart.DragInerfaces;
import com.lixs.charts.BarChart.LBarChartView;
import com.temp.chart.BaseActivity;
import com.temp.chart.R;
import com.temp.chart.model.MonthContent;
import com.temp.chart.utils.DaoUntils;
import com.temp.chart.utils.ThreadPool;

import java.util.ArrayList;
import java.util.List;

/*柱状图*/
public class BarChartActivity extends BaseActivity {

    LBarChartView lBarChartView;
    private int index;
    List<MonthContent> monthContents = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initNewBarDatas();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);

        index = getIntent().getIntExtra("tag",4);

        lBarChartView = findViewById(R.id.frameNewBase);

        ThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                monthContents = DaoUntils.getData();
                handler.sendEmptyMessage(1);
            }
        });
    }

    private void initNewBarDatas() {
        final List<Double> datas = new ArrayList<>();
        final List<String> description = new ArrayList<>();

        for(int i=0;i<index;i++){
            datas.add((double) monthContents.get(i).getValue());
            description.add(monthContents.get(i).getMonth());
        }


        lBarChartView.setDatas(datas, description, true);
        lBarChartView.setDragInerfaces(new DragInerfaces() {
            @Override
            public void onEnd() {
//                final List<Double> datas = new ArrayList<>();
//                final List<String> description = new ArrayList<>();
//                datas.add(40d);
//                datas.add(15d);
//                datas.add(38d);
//                datas.add(60d);
//                datas.add(10d);
//
//                description.add("one");
//                description.add("two");
//                description.add("three");
//                description.add("four");
//                description.add("five");
//                lBarChartView.addEndMoreData(datas, description);
            }

            @Override
            public void onStart() {

            }
        });
    }


}
