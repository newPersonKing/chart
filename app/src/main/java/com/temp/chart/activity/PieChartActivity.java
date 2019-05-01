package com.temp.chart.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lixs.charts.PieChartView;
import com.temp.chart.BaseActivity;
import com.temp.chart.R;
import com.temp.chart.model.MonthContent;
import com.temp.chart.utils.DaoUntils;
import com.temp.chart.utils.ThreadPool;

import java.util.ArrayList;
import java.util.List;

/*环形图 饼状图*/
public class PieChartActivity extends BaseActivity {
    PieChartView pieView;
    List<MonthContent> monthContents;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initPieDatas();
        }
    };
    private int index;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);
        pieView = findViewById(R.id.pieView);

        index = getIntent().getIntExtra("tag",4);

        ThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                monthContents = DaoUntils.getData();
                handler.sendEmptyMessage(1);
            }
        });

    }

    private void initPieDatas() {

        List<Float> mRatios = new ArrayList<>();

        List<String> mDescription = new ArrayList<>();

        List<Integer> mArcColors = new ArrayList<>();

        for(int i=0;i<index;i++){
            MonthContent monthContent = monthContents.get(i);
            mRatios.add(monthContent.getValue()/getTotal());
            mArcColors.add(mColors[i]);
            mDescription.add(monthContent.getMonth());
        }


        //点击动画开启
        pieView.setCanClickAnimation(true);
        pieView.setDatas(mRatios, mArcColors, mDescription);
    }

    private float getTotal(){
        float total = 0;
        for(int i=0;i<index;i++){
            MonthContent monthContent = monthContents.get(i);
            total+=monthContent.getValue();
        }
        return total;
    }

}


