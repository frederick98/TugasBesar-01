package com.example.tugasbesar_01;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class AddFragment extends Fragment implements View.OnClickListener,IMainActivity{
    FragmentListener listener;
    Button submit;
    EditText input;
    Spinner sp;
    MainPresenter presenter;
    NumopListAdapter nla;

    public AddFragment(){

    }

    public static AddFragment newInstance(MainPresenter presenter){
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.add_fragment,container,false);

        this.input = view.findViewById(R.id.et_input);

        this.sp = view.findViewById(R.id.spinner1);

        this.submit = view.findViewById(R.id.btn_submit);
        this.submit.setOnClickListener(this);

        this.presenter = new MainPresenter(this);
        this.nla = new NumopListAdapter(getActivity(),this.presenter);

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
            int valTemp = Integer.parseInt(this.input.getText().toString());
            String optTemp = this.sp.getSelectedItem().toString();
            this.presenter.addList(optTemp,valTemp);
            listener.changeValue();
            listener.changePage(1);
        }
    }


    @Override
    public void updateList(List<Numop> num) {
        this.nla.update(num);
    }

    @Override
    public void resetAddForm() {
    //   this.input.setText("");
//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(this.fragment2.submit.getWindowToken(),0);
    }
}
