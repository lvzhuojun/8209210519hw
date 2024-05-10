package com.example.fi1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class fragment1 extends Fragment {

    private LottieAnimationView loadingAnimationView;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    public fragment1() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        loadingAnimationView = view.findViewById(R.id.loading_animation);
        startLoadingAnimation();
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // 创建假数据
        List<String> data = new ArrayList<>();
        data.add("Item 1");
        data.add("Item 2");
        data.add("Item 3");
        data.add("Item 10");
        data.add("Item 20");
        data.add("Item 30");
        data.add("Item 100");
        data.add("Item 200");
        data.add("Item 300");
        data.add("Item 1000");
        data.add("Item 2000");
        data.add("Item 3000");

        mAdapter = new MyAdapter(data);
        mRecyclerView.setAdapter(mAdapter);



        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        stopLoadingAnimation();
    }

    private void startLoadingAnimation() {
        loadingAnimationView.setVisibility(View.VISIBLE);
        loadingAnimationView.playAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stopLoadingAnimation();
            }
        }, 5000);
    }

    private void stopLoadingAnimation() {
        loadingAnimationView.animate()
                .alpha(0f)
                .setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        loadingAnimationView.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.VISIBLE); // 在动画结束后显示列表
                    }
                });
    }
}
