package com.example.tugasbesar_01;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

public class HalamanUtama extends Fragment implements View.OnClickListener {
    Button add_Button;
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

        this.add_Button.setOnClickListener(this);



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
            this.listener.changePage(2);
        }
    }
}
