package com.example.dragdropitems.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dragdropitems.R;
import com.example.dragdropitems.adapter.CustomListAdapter;
import com.example.dragdropitems.listener.DragListener;
import com.example.dragdropitems.listener.DropListener;
import com.example.dragdropitems.model.CustomListResponse;

public class MainActivity extends AppCompatActivity implements DropListener {

    TextView textCurrentDate;
    RecyclerView  recyclerViewToday,recyclerViewYesterday;
    TextView textPreviousDate;
    FrameLayout todayDragFrame,yesterdayDragFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        onSuccess();
    }

    public void initializeViews(){
        recyclerViewToday=findViewById(R.id.recyclerViewToday);
        textCurrentDate=findViewById(R.id.textCurrentDate);
        recyclerViewYesterday=findViewById(R.id.recyclerViewYesterday);
        textPreviousDate=findViewById(R.id.textPreviousDate);

        todayDragFrame=findViewById(R.id.todayDragFrame);
        yesterdayDragFrame=findViewById(R.id.yesterdayDragFrame);

        recyclerViewToday.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewYesterday.setLayoutManager(new LinearLayoutManager(this));

        textCurrentDate.setText("TODAY");
        textPreviousDate.setText("YESTERDAY");
    }

    private void onSuccess() {
        try {
            CustomListResponse response = CustomListResponse.getDummyResponseObject();

            CustomListAdapter mYesterdayCustomListAdapter =new CustomListAdapter(this, response.previousDayCustomList, this,recyclerViewYesterday);
            recyclerViewYesterday.setAdapter(mYesterdayCustomListAdapter);
            yesterdayDragFrame.setOnDragListener(DragListener.getDragInstance(recyclerViewYesterday,this));

            CustomListAdapter mCustomListAdapter = new CustomListAdapter(this, response.customList, this,recyclerViewToday);
            recyclerViewToday.setAdapter(mCustomListAdapter);
            todayDragFrame.setOnDragListener(DragListener.getDragInstance(recyclerViewToday,this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDropView(int sourceId, int targetId) {

    }
}
