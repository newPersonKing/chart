package com.temp.chart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.temp.chart.activity.BarChartActivity;
import com.temp.chart.activity.LineChartActivity;
import com.temp.chart.activity.PieChartActivity;
import com.temp.chart.activity.RadarChartActivity;
import com.temp.chart.model.MonthContent;
import com.temp.chart.utils.DaoUntils;
import com.temp.chart.utils.ThreadPool;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_add,btn_bar_chart,btn_pie_chart,btn_RadarChart,btn_LineChart;
    LinearLayout ll_content;
    String[] months = new String[12];

    List<MonthContent> monthContents = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_bar_chart = findViewById(R.id.btn_bar_chart);
        btn_pie_chart = findViewById(R.id.btn_pie_chart);
        btn_RadarChart = findViewById(R.id.btn_RadarChart);
        btn_LineChart = findViewById(R.id.btn_LineChart);
        btn_add.setOnClickListener(this);
        btn_bar_chart.setOnClickListener(this);
        btn_pie_chart.setOnClickListener(this);
        btn_RadarChart.setOnClickListener(this);
        btn_LineChart.setOnClickListener(this);
        ll_content = findViewById(R.id.ll_content);
        initMonths();
        initList();

        ThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                int size = DaoUntils.getSize();
                if (size>0){

                }else{
                    DaoUntils.insertMonthContents(monthContents);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_add:
                int childCount = ll_content.getChildCount();
                if(childCount>12){
                    return;
                }
                ll_content.addView(createItem(monthContents.get(childCount-1)));
                break;
            case R.id.btn_bar_chart:
                int tagA = ll_content.getChildCount();
                intent.setClass(this,BarChartActivity.class);
                intent.putExtra("tag",tagA-1);
                startActivity(intent);
                break;
            case R.id.btn_pie_chart:
                int tagB = ll_content.getChildCount();
                intent.putExtra("tag",tagB-1);
                intent.setClass(this,PieChartActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_RadarChart:
                intent.setClass(this,RadarChartActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_LineChart:
                intent.setClass(this,LineChartActivity.class);
                startActivity(intent);
                break;
        }
    }

    private View createItem(MonthContent monthContent){
        View view = LayoutInflater.from(this).inflate(R.layout.item_content,null);
        TextView tv1 = view.findViewById(R.id.month_value);
        TextView tv2 = view.findViewById(R.id.num_value);
        tv1.setText(monthContent.getMonth());
        tv2.setText(monthContent.getValue()+"");
        return  view;
    }

    private void  initMonths(){
        months[0]="January";
        months[1]="February";
        months[2]="March";
        months[3]="April";
        months[4]="May";
        months[5]="June";
        months[6]="July";
        months[7]="August";
        months[8]="September";
        months[9]="October ";
        months[10]="November";
        months[11]="December";
    }

    private void initList(){
        for(int i=0;i<12;i++){
            MonthContent monthContent = new MonthContent();
            monthContent.setMonth(months[i]);
            monthContent.setValue(100);
            monthContents.add(monthContent);
        }
    }
}
