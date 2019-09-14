package com.example.tugasbesar_01;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.TextView;

public class LeftFragment extends Fragment implements View.OnClickListener {
    TextView tv_halamanUtama;
    TextView tv_addFragment;
    TextView exit;
    FragmentListener listener;

    public LeftFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        this.tv_halamanUtama = view.findViewById(R.id.fl_tv_halUtamaFg);
        this.tv_addFragment = view.findViewById(R.id.fl_tv_addFg);
        this.exit = view.findViewById(R.id.fl_tv_exit);

        this.tv_halamanUtama.setOnClickListener(this);
        this.tv_addFragment.setOnClickListener(this);
        this.exit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context){

        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;

        }
        else{
            throw new ClassCastException(context.toString()
                    +"must implement FragmentListener");
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==this.tv_halamanUtama.getId()){
            listener.changePage(1);
        }
        else if(view.getId()==this.tv_addFragment.getId()){
            listener.changePage(2);
        }
        else{
            listener.closeApp();
        }
    }
}

