package com.example.tugasbesar_01;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ResultDialogFragment extends DialogFragment implements View.OnClickListener{
    Button btnResult;
    TextView tvMsg;
    TextView tvIntro;
    Button btnClose;
    FragmentListener listener;

    public ResultDialogFragment() {
    }

    public static ResultDialogFragment newInstance() {
        ResultDialogFragment fragment = new ResultDialogFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_dialog, container, false);

        this.btnResult = view.findViewById(R.id.btn_result);
        this.btnClose = view.findViewById(R.id.btn_closeDialog);
        this.tvMsg = view.findViewById(R.id.tvResult);
        this.tvIntro = view.findViewById(R.id.tv_ResultIntro);
        this.tvMsg.setText(getTag());

        this.btnClose.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==this.btnClose.getId()){
            getFragmentManager().beginTransaction().remove(ResultDialogFragment.this).commit();
        }
    }
}


