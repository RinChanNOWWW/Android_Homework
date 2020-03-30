package com.example.chapter3.homework;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListBaseAdapter extends BaseAdapter {

    private static final int NUM_LIST_ITEMS = 5;


    @Override
    public int getCount() {
        return NUM_LIST_ITEMS;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.item, null);
            holder.itemText = (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.itemText.setText("好友 " + String.valueOf(position + 1));
        return convertView;
    }

    private static class ViewHolder {
        private TextView itemText;
    }
}
