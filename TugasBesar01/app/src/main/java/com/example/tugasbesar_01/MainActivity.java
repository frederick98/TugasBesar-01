package com.example.tugasbesar_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

//pake androidx jgn lupa

public class MainActivity extends AppCompatActivity implements FragmentListener {
    protected AddFragment fragment2;
    protected FragmentManager fragmentManager;
    protected HalamanUtama fragment1;
    protected DrawerLayout drawer;
    private Toolbar toolbar;


    //   protected OperandAdaptor oa;
    protected Presenter presenter;
//   protected NumopListAdapter nla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.presenter = new Presenter(this);
//        this.oa = new OperandAdaptor(this, this.presenter);
//        this.numopList.setAdapter(this.oa);


        // this.presenter = new MainPresenter(this);
        //this.presenter.loadData();

        this.fragment1 = HalamanUtama.newInstance();
        this.fragment2 = AddFragment.newInstance(presenter);
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
    public void changeValue() { //ganti tv ResultValue halamanUtama
        String opt = this.fragment2.sp.getSelectedItem().toString();
        int value = Integer.parseInt(this.fragment2.input.getText().toString());
        int curr = Integer.parseInt(this.fragment1.resultVal.getText().toString());
        if (opt.equals("+")) {
            curr = curr + value;
        } else if (opt.equals("-")) {
            curr = curr - value;
        } else if (opt.equals("*")) {
            curr = curr * value;
        } else if(opt.equals("/")){
            curr = curr / value;
        }
        String res = String.valueOf(curr);
        this.fragment1.resultVal.setText(res);
    }

    @Override
    public void clearList() {
        fragment1.clearListView();
    }

    @Override
    public void deleteListPos(int position) {
        fragment1.listener.deleteListPos(position);
    }


    @Override
    public void closeApp() {
        this.moveTaskToBack(true);
        this.finish();
    }

    @Override
    public void addList(Numop n) {
        fragment1.addListview(n);
    }

}

