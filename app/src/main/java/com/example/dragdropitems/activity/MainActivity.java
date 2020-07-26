package com.example.dragdropitems.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dragdropitems.R;
import com.example.dragdropitems.adapter.CustomListAdapter;
import com.example.dragdropitems.listener.DragListener;
import com.example.dragdropitems.listener.DropListener;
import com.example.dragdropitems.model.CustomList;
import com.example.dragdropitems.model.CustomListResponse;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DropListener {

    RecyclerView  recyclerViewToday,recyclerViewYesterday,recyclerViewOther;
    FrameLayout todayDragFrame,yesterdayDragFrame,otherDragFrame;
    GridLayout linearSuccessView;
    HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        onSuccess();
    }

    public void initializeViews(){
        linearSuccessView=findViewById(R.id.linearSuccessView);
        recyclerViewToday=findViewById(R.id.recyclerViewToday);
        recyclerViewYesterday=findViewById(R.id.recyclerViewYesterday);
        recyclerViewOther=findViewById(R.id.recyclerViewOther);
        otherDragFrame=findViewById(R.id.otherDragFrame);
        horizontalScrollView=findViewById(R.id.horizontalScrollView);
        todayDragFrame=findViewById(R.id.todayDragFrame);
        yesterdayDragFrame=findViewById(R.id.yesterdayDragFrame);

        recyclerViewToday.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewYesterday.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOther.setLayoutManager(new LinearLayoutManager(this));

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

            ArrayList<CustomList> othersList=new ArrayList<>();
            othersList.addAll(response.customList);
            othersList.addAll(response.previousDayCustomList);


            CustomListAdapter otherListAdapter = new CustomListAdapter(this, othersList, this,recyclerViewOther);
            recyclerViewOther.setAdapter(otherListAdapter);
            otherDragFrame.setOnDragListener(DragListener.getDragInstance(recyclerViewOther,this));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDropView(int sourceId, int targetId) {

    }
    @Override
    public void onDragView(int from, int to) {
         float scrollX = 0;
        switch (to){
            case 1:
                scrollX=todayDragFrame.getX();
                break;
            case 2:
                scrollX=yesterdayDragFrame.getX();
                break;
            case 3:
               scrollX=otherDragFrame.getX();
                break;
        }
        int x=(int)scrollX;
        new Handler().postDelayed(() -> horizontalScrollView.smoothScrollTo(x,0), 10);
    }
}
