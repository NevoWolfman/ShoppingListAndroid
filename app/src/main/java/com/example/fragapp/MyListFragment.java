package com.example.fragapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class MyListFragment extends Fragment implements View.OnClickListener {

    private LinearLayout list;
    private List<TextView> tv = new ArrayList<>();
    private List<CheckBox> cb = new ArrayList<>();
    int index = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_list, container, false);
        list = view.findViewById(R.id.list);
        return view;
    }

    public void Add(String str)
    {
        LinearLayout ll = new LinearLayout(requireContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        params.gravity = 1;
        ll.setLayoutParams(params);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setBackground(getResources().getDrawable(R.drawable.border, null));

        TextView textView = new TextView(requireContext());
        params = new LinearLayout.LayoutParams(400, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(params);
        textView.setText(str);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(1);
        textView.setBackground(getResources().getDrawable(R.drawable.border, null));
        tv.add(index, textView);
        ll.addView(tv.get(index));

        cb.add(index, new CheckBox(requireContext()));
        cb.get(index).setOnClickListener(this);
        ll.addView(cb.get(index));

        list.addView(ll);
        index++;
    }

    @Override
    public void onClick(View v) {
        CheckBox box = (CheckBox) v;
        int i = cb.indexOf(box);
        int c;
        if(box.isChecked())
        {
            c = Color.BLUE;
        }
        else
        {
            c = Color.BLACK;
        }
        tv.get(i).setTextColor(c);
    }
}
