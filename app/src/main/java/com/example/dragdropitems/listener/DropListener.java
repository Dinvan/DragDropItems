package com.example.dragdropitems.listener;

public interface DropListener {
    void onDropView(int sourceId,int targetId);
    void onDragView(int from,int to);
}
