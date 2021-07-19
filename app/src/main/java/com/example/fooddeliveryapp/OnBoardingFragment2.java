package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class OnBoardingFragment2 extends Fragment {

    TextView textView;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_onboarding2,container,false);

        textView = root.findViewById(R.id.skip2);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(),SignInActivity.class);
            getActivity().startActivity(intent);
        });
        return root;
    }
}
