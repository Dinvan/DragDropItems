package com.example.dragdropitems.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dragdropitems.model.CustomList;
import com.example.dragdropitems.R;
import com.example.dragdropitems.listener.DragListener;
import com.example.dragdropitems.listener.DropListener;
import java.util.List;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.CustomListViewHolder> {

    Context mContext;
    List<CustomList> mCustomList;
    DropListener dropListener;
    RecyclerView recyclerView;

    public CustomListAdapter(Context context, List<CustomList> customList,
                             DropListener dropListener, RecyclerView recyclerView) {
        this.mCustomList = customList;
        this.recyclerView=recyclerView;
        this.mContext = context;
        this.dropListener = dropListener;
    }

    @Override
    public CustomListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_row, parent, false);
        return new CustomListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomListViewHolder holder, int position) {
        CustomList customList = mCustomList.get(position);
        holder.textName.setText(customList.name);
        holder.textAddress.setText(customList.address);
        holder.textMobile.setText(customList.mobile);
        holder.textEstimatedTime.setText("Estimated Time: " + customList.estimatedTime);
        holder.cardView.setTag(position);
        holder.cardView.setOnLongClickListener(view -> {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        });
        holder.cardView.setOnDragListener(new DragListener(dropListener,recyclerView));
    }

    @Override
    public int getItemCount() {
        return mCustomList.size();
    }

    public List<CustomList> getCustomList() {
        return mCustomList;
    }

    public void updateCustomList(List<CustomList> customList) {
        this.mCustomList = customList;
    }

    public class CustomListViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textMobile;
        TextView textAddress;
        TextView textEstimatedTime;
        CardView cardView;

        public CustomListViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textMobile = itemView.findViewById(R.id.textMobile);
            textAddress = itemView.findViewById(R.id.textAddress);
            textEstimatedTime = itemView.findViewById(R.id.textEstimatedTime);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
