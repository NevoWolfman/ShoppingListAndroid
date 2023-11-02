package com.example.fragapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FormFragment extends Fragment {

    private TextView tv;
    private EditText et;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_form, container, false);
        tv = view.findViewById(R.id.tv);
        et = view.findViewById(R.id.et);
        btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = et.getText().toString();
                et.setText("");
                if(!str.isEmpty())
                {
                    MyListFragment lf = (MyListFragment) getParentFragmentManager().findFragmentById(R.id.listfrag);
                    lf.Add(str);
                }
            }
        });
        return view;
    }
}
