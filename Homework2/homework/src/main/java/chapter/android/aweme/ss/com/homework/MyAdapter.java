package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;


/**
 * 适配器
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static final String TAG = "hezheyu";

//    private int mItems;

    private final ListItemClickListener mOnClickListener;

//    private static int viewHolderCount;
    private  List<Message> dataList;

    public MyAdapter(ListItemClickListener listener, List<Message> l)  {
//        mItems = numListItems;
        mOnClickListener = listener;
        dataList = l;
        Log.d(TAG, "data nums: " + dataList.size());
//        viewHolderCount = l.size();
        Log.d(TAG, "create adapter");
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
//        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        Log.d(TAG, "create view holder");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        Message data = dataList.get(position);
        viewHolder.titleView.setText(data.getTitle());
        viewHolder.timeView.setText(data.getTime());
        viewHolder.descriptionView.setText(data.getDescription());
        if (data.isOfficial())
            viewHolder.robot_notice.setVisibility(View.VISIBLE);
        else
            viewHolder.robot_notice.setVisibility(View.INVISIBLE);
        switch (data.getIcon()) {
            case "TYPE_ROBOT":
                viewHolder.iconView.setImageResource(R.drawable.session_robot);
                break;
            case "TYPE_GAME":
                viewHolder.iconView.setImageResource(R.drawable.icon_micro_game_comment);
                break;
            case "TYPE_SYSTEM":
                viewHolder.iconView.setImageResource(R.drawable.session_system_notice);
                break;
            case "TYPE_USER":
                viewHolder.iconView.setImageResource(R.drawable.icon_girl);
                break;
            default:
                viewHolder.iconView.setImageResource(R.drawable.session_stranger);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleView;
        private TextView descriptionView;
        private TextView timeView;
        private CircleImageView iconView;
        private ImageView robot_notice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.tv_title);
            descriptionView = (TextView) itemView.findViewById(R.id.tv_description);
            timeView = (TextView) itemView.findViewById(R.id.tv_time);
            robot_notice = (ImageView) itemView.findViewById(R.id.robot_notice);
            iconView = (CircleImageView) itemView.findViewById(R.id.iv_avatar);

            itemView.setOnClickListener(this);
        }

//        public void bind(int position) {
//            listItemNumberView.setText(String.valueOf(position));
//        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
