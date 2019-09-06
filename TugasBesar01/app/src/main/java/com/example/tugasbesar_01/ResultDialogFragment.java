package com.example.tugasbesar_01;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ResultDialogFragment extends DialogFragment implements View.OnClickListener{
    Button btn_result;
    TextView text_msg;
    TextView text_intro;
    Button btn_close;
    FragmentListener listener;

    public ResultDialogFragment() {
    }

    public static ResultDialogFragment newInstance() {
        ResultDialogFragment fragment = new ResultDialogFragment();
        Bundle args = new Bundle();
        //args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_dialog, container, false);

        this.btn_result = view.findViewById(R.id.btn_result);
        this.btn_close = view.findViewById(R.id.btn_closeDialog);
        this.text_msg = view.findViewById(R.id.tvResult);
        this.text_intro = view.findViewById(R.id.tv_ResultIntro);
        this.text_msg.setText(getTag());

        this.btn_close.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==this.btn_close.getId()){
            //
        }
    }
}


