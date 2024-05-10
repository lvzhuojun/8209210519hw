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

import com.airbnb.lottie.LottieAnimationView;

public class fragment2 extends Fragment {

    private LottieAnimationView loadingAnimationView;
    private TextView loadingTextView;

    public fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        loadingAnimationView = view.findViewById(R.id.loading_animation);
        loadingTextView = view.findViewById(R.id.loading_text);

        startLoadingAnimation();

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
                    }
                });

        loadingTextView.setAlpha(0f);
        loadingTextView.setVisibility(View.VISIBLE);
        loadingTextView.animate()
                .alpha(1f)
                .setDuration(500)
                .setListener(null); // 保证不会被动画监听器影响
    }
}
