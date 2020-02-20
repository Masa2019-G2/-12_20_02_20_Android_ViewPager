package com.telran.a20_02_20;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class PageFragment extends Fragment {
    String name;
    int color;

    public static Fragment of(String name) {
        PageFragment fragment = new PageFragment();
        fragment.name = name;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random rnd = new Random();
        color = Color.rgb(rnd.nextInt(256),
                rnd.nextInt(256),
                rnd.nextInt(256)
        );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_page, container, false);
        TextView title = view.findViewById(R.id.titleTxt);
        title.setText(name);

        view.setBackgroundColor(color);
        return view;
    }
}
