package com.example.tugasbesar_01;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AddFragment extends Fragment implements View.OnClickListener {
    TextView tvTitle;
    EditText etInput;
    Button btnSubmit;
    Spinner sp1;
    FragmentListener listener;


    public AddFragment(){

    }

    public static AddFragment newInstance(String title){
        /*
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;

         */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.add_fragment,container,false);

        this.tvTitle = view.findViewById(R.id.tv_title);
        this.etInput = view.findViewById(R.id.et_input);
        this.btnSubmit = view.findViewById(R.id.btn_submit);
        this.btnSubmit.setOnClickListener(this);

//        this.sp1 = (Spinner) view.findViewById(R.id.spinner1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.operator_arrays));
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sp1.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context){
    /*
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;

        }
        else{
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }

     */
    }

    @Override
    public void onClick(View view) {
        /*
        if(view.getId()==this.btnSubmit.getId()){
            this.listener.submitValue(Integer.parseInt(this.etInput.getText().toString()));
            this.listener.changePage(2);
        }
        
         */
    }
}
