package com.e.taskapp_1;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {
    ViewPager viewPager;
    TableLayout tableLayout;


    public BoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        TextView textDesc = view.findViewById(R.id.textDesc);
        TextView textTitle = view.findViewById(R.id.textTitle);
        ImageView imageView = view.findViewById(R.id.imageView);
        Button button = view.findViewById(R.id.button);

        int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                button.setVisibility(View.GONE);
                imageView.setImageResource(R.drawable.smile1);
                textTitle.setText("Привет");
                break;
            case 1:
                button.setVisibility(View.GONE);
                imageView.setImageResource(R.drawable.smile2);
                textTitle.setText("Как дела ?");
                break;
            case 2:
                button.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.smile3);
                textTitle.setText("Что делаешь ?");
                button.setVisibility(View.VISIBLE);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("settings",
                        Context.MODE_PRIVATE);
                preferences.edit().putBoolean("isShown", true).apply();
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        });
        return view;
    }

}
