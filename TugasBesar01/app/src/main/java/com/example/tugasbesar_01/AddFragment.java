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
    FragmentListener listener;
    Button submit;
    EditText input;

    public AddFragment(){

    }

    public static AddFragment newInstance(){

        AddFragment fragment = new AddFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.add_fragment,container,false);

        this.input = view.findViewById(R.id.et_input);

        this.submit = view.findViewById(R.id.btn_submit);
        this.submit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context){

        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;

        }
        else{
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==this.submit.getId()){
            listener.changePage(1);
        }
    }
}
