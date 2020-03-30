package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {


    private ListView listView;
    private LottieAnimationView animationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        listView = view.findViewById(R.id.items);
        animationView = view.findViewById(R.id.animation_view);
        listView.setAdapter(new ListBaseAdapter());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator alphaAnimator1 =  ObjectAnimator.ofFloat(animationView,
                        "alpha", 1.0f, 0.0f);
                ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(listView,
                        "alpha", 0.0f, 1.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(alphaAnimator1, alphaAnimator2);
                animatorSet.start();
            }
        }, 5000);
    }
}
