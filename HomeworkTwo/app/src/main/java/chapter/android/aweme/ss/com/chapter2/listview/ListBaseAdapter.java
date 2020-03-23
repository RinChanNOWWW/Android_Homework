package chapter.android.aweme.ss.com.chapter2.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import chapter.android.aweme.ss.com.chapter2.R;
import chapter.android.aweme.ss.com.chapter2.recycleview.ColorUtils;

public class ListBaseAdapter extends BaseAdapter {

    private static final int NUM_LIST_ITEMS = 100;


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
            convertView = View.inflate(parent.getContext(), R.layout.number_list_item, null);
            holder.listItemNumberView = (TextView) convertView.findViewById(R.id.tv_item_number);
            holder.viewHolderIndex = (TextView) convertView.findViewById(R.id.tv_view_holder_instance);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        holder.listItemNumberView.setText(String.valueOf(position));
        holder.viewHolderIndex.setText(String.format("ViewHolder index: %s", position));
        int backgroundColorForViewHolder = ColorUtils.
                getViewHolderBackgroundColorFromInstance(convertView.getContext(), position % 10);
        convertView.setBackgroundColor(backgroundColorForViewHolder);
        return convertView;
    }

    private static class ViewHolder {
        private TextView viewHolderIndex;
        private TextView listItemNumberView;
    }
}
