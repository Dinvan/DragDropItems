package com.example.dragdropitems.listener;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dragdropitems.model.CustomList;
import com.example.dragdropitems.adapter.CustomListAdapter;
import com.example.dragdropitems.R;
import java.util.List;

public class DragListener implements View.OnDragListener {

    boolean isDropped = false;
    DropListener dropListener;
    RecyclerView target;

    public static DragListener getDragInstance(RecyclerView recyclerView, DropListener dropListener) {
        return new DragListener(dropListener, recyclerView);
    }

    public DragListener(DropListener dropListener, RecyclerView target) {
        this.dropListener = dropListener;
        this.target = target;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        View viewSource1 = (View) event.getLocalState();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                break;

            case DragEvent.ACTION_DRAG_ENTERED:

                break;

            case DragEvent.ACTION_DRAG_EXITED:

                break;
            case DragEvent.ACTION_DRAG_LOCATION:
                dropListener.onDragView(Integer.parseInt(((RecyclerView)viewSource1.getParent()).getTag().toString()),Integer.parseInt(target.getTag().toString()));
                break;

            case DragEvent.ACTION_DROP:

                isDropped = true;
                int positionSource = -1;
                int positionTarget = -1;

                View viewSource = (View) event.getLocalState();
                if (v.getId() == R.id.cardView
                        || v.getId() == R.id.todayDragFrame
                        || v.getId() == R.id.yesterdayDragFrame
                        ||v.getId() == R.id.otherDragFrame) {

                    RecyclerView source = (RecyclerView) viewSource.getParent();
                    if (source.getId() == target.getId()) {
                        return false;
                    }
                    if (v.getId() == R.id.cardView) {
                        positionTarget = (int) v.getTag();
                    }
                    /*  Source Changes*/
                    CustomListAdapter adapterSource = (CustomListAdapter) source.getAdapter();
                    positionSource = (int) viewSource.getTag();

                    CustomList customList = adapterSource.getCustomList().get(positionSource);
                    List<CustomList> customListSource = adapterSource.getCustomList();

                    customListSource.remove(positionSource);
                    adapterSource.updateCustomList(customListSource);
                    adapterSource.notifyDataSetChanged();

                    /*  Target Changes*/
                    CustomListAdapter adapterTarget = (CustomListAdapter) target.getAdapter();
                    List<CustomList> customListTarget = adapterTarget.getCustomList();
                    if (positionTarget >= 0) {
                        customListTarget.add(positionTarget, customList);
                    } else {
                        customListTarget.add(customList);
                    }
                    adapterTarget.updateCustomList(customListTarget);
                    adapterTarget.notifyDataSetChanged();
                    dropListener.onDropView(source.getId(), target.getId());
                }
                break;

            case DragEvent.ACTION_DRAG_ENDED:
                //v.setBackgroundColor(0);
                break;
            default:
                break;
        }

        if (!isDropped) {
            View vw = (View) event.getLocalState();
            vw.setVisibility(View.VISIBLE);
        }
        return true;
    }
}
