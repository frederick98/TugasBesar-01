/*
    created by:
        - 2016730035 Lanang Galih Saputro
        - 2016730040 Frederick
        - 2016730045 Reynaldi Irfan Anwar
 */
package com.example.tugasbesar_01;

/*
    needed to import class shown below
 */
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment implements View.OnClickListener {
    protected TextView tv_halamanUtama;
    protected TextView tv_addFragment;
    protected TextView exit;
    protected FragmentListener listener;

    public LeftFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        //findViewById initialization
        this.tv_halamanUtama = view.findViewById(R.id.fl_tv_halUtamaFg);
        this.tv_addFragment = view.findViewById(R.id.fl_tv_addFg);
        this.exit = view.findViewById(R.id.fl_tv_exit);

        //setOnClickListener method initialization
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
            throw new ClassCastException(context.toString() + "must implement FragmentListener");
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