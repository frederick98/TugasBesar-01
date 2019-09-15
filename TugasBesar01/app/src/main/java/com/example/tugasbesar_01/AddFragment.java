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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class AddFragment extends Fragment implements View.OnClickListener {
    FragmentListener listener;
    Button submit;
    EditText input;
    Spinner spinner;
    Adapter adapter;

    public AddFragment() {
    }

    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        //findViewById initialization
        this.input = view.findViewById(R.id.fa_et_input);
        this.spinner = view.findViewById(R.id.fa_spinner1);
        this.submit = view.findViewById(R.id.fa_btn_submit);
        
        this.adapter = new Adapter(getActivity());

        this.submit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            this.listener = (FragmentListener) context;
        }
        else {
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == this.submit.getId()) {
            Numop numop = new Numop(this.spinner.getSelectedItem().toString(), Integer.parseInt(this.input.getText().toString()));
            listener.addList(numop);
            listener.changeValue();
            listener.changePage(1);
        }
    }
}