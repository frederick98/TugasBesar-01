package com.example.tugasbesar_01;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentListener {
   protected AddFragment fragment2;
   protected FragmentManager fragmentManager;
   protected HalamanUtama fragment1;
    DrawerLayout drawer;
    private Toolbar toolbar;

    //pake androidx jgn lupa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.fragment1 = HalamanUtama.newInstance();
        this.fragment2 = AddFragment.newInstance();
        this.fragmentManager = this.getSupportFragmentManager();

        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.fragment1).addToBackStack(null).commit();

        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

//        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.openDrawer,R.string.closeDrawer);
//        drawer.addDrawerListener(abdt);
//        abdt.syncState();
    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();

        if (page == 1) {
            if (this.fragment1.isAdded()) {
                ft.show(this.fragment1);
            } else {
                ft.add(R.id.fragment_container, this.fragment1);
            }

            if (this.fragment2.isAdded()) {
                ft.hide(this.fragment2);
            }
        } else if (page == 2) {
            if (this.fragment2.isAdded()) {
                ft.show(this.fragment2);
            } else {
                ft.add(R.id.fragment_container, this.fragment2);
            }

            if (this.fragment1.isAdded()) {
                ft.hide(this.fragment1);
            }
        }
        ft.commit();

    }

    @Override
    public void submitValue() { //masukin input kedalam listView

    }

    @Override
    public void changeValue() { //ganti tv ResultValue halamanUtama
        String opt = this.fragment2.sp.getSelectedItem().toString();
        int value = Integer.parseInt(this.fragment2.input.getText().toString());
        int curr = Integer.parseInt(this.fragment1.resultVal.getText().toString());
        if(opt.equals("+")){
            curr = curr + value;
        }
        else if(opt.equals("-")){
            curr = curr - value;
        }
        else if(opt.equals("*")){
            curr = curr * value;
        }
        else{
            curr = curr / value;
        }
        String res = String.valueOf(curr);
        this.fragment1.resultVal.setText(res);
    }

    @Override
    public void clearList() {

    }

    @Override
    public void saveList() {

    }

    @Override
    public void delateNum(int position) {

    }

    @Override
    public void showResult() {

    }

    @Override
    public void closeApp(){
        this.moveTaskToBack(true);
        this.finish();
    }
}

