package com.example.tugasbesar_01;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HalamanUtama extends Fragment implements View.OnClickListener {
    Button add_Button;
    Button res_Button;
    FragmentListener listener;
    TextView resultVal;


    public HalamanUtama(){

    }

    public static HalamanUtama newInstance(){

        HalamanUtama fragment = new HalamanUtama();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.halaman_utama,container,false);

        this.resultVal = view.findViewById(R.id.tv_resultValue);

        this.add_Button = view.findViewById(R.id.btn_add);

        this.res_Button = view.findViewById(R.id.btn_result);
        this.res_Button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ResultDialogFragment resultDialogFragment = new ResultDialogFragment();
                resultDialogFragment.show(ft,resultVal.getText().toString());
            }
        });


        this.add_Button.setOnClickListener(this);


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
            this.listener.changePage(2);
        }
    }
}
