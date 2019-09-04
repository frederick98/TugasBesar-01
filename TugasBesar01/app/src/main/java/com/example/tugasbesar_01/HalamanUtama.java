package com.example.tugasbesar_01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HalamanUtama extends Fragment implements View.OnClickListener {
    TextView tvTitle;
    Button add_Button;
    Button res_Button;
    Button clr_Button;
    Button save_Button;
    ListView lv;
    FragmentListener listener;
    NumberListAdapter adapter;


    public HalamanUtama(){

    }

    public static HalamanUtama newInstance(String title, Activity myAct, MainPresenter presenter){
        HalamanUtama fragment = new HalamanUtama();
        fragment.adapter = new NumberListAdapter(myAct, presenter);
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.halaman_utama,container,false);

        this.tvTitle = view.findViewById(R.id.tv_title);

        this.lv = view.findViewById(R.id.lv_history);

        this.lv.setAdapter(adapter);
        this.add_Button = view.findViewById(R.id.btn_add);

        this.add_Button.setOnClickListener(this);

        this.clr_Button.setOnClickListener(this);

        this.res_Button.setOnClickListener(this);

        this.save_Button.setOnClickListener(this);


//        this.sp1 = (Spinner) view.findViewById(R.id.spinner1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.operator_arrays));
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sp1.setAdapter(adapter);

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
        if(view.getId()==this.add_Button.getId()){
            this.listener.changePage(1);
        }
        else if(view.getId()==this.res_Button.getId()){

        }
        else if(view.getId()==this.save_Button.getId()){

        }
        else if(view.getId()==this.clr_Button.getId()){

        }
    }
}
