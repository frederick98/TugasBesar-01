package com.example.tugasbesar_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    AddFragment fragment2;
    FragmentManager fragmentManager;
    HalamanUtama fragment1;
    //pake androidx jgn lupa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragment1 = HalamanUtama.newInstance("Calculator");
        this.fragment2 = AddFragment.newInstance("Add");
        this.fragmentManager = this.getSupportFragmentManager();

        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.replace(R.id.fragment_container,this.fragment1).commit();


        Spinner sp = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.operator_arrays));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();

        if(page==1){
            if(this.fragment1.isAdded()){
                ft.show(this.fragment1);
            } else{
                ft.add(R.id.fragment_container,this.fragment1);
            }

            if(this.fragment2.isAdded()){
                ft.hide(this.fragment2);
            }
        }else if(page==2){
            if(this.fragment2.isAdded()){
                ft.show(this.fragment2);
            }else{
                ft.add(R.id.fragment_container,this.fragment2);
            }

            if(this.fragment1.isAdded()){
                ft.hide(this.fragment1);
            }
        }
        ft.commit();
    }

    @Override
    public void submitValue(int value) {

    }

    @Override
    public void changeValue(int value) {

    }
}
