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
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    private Toolbar toolbar;
    protected AddFragment fragment2;
    protected FragmentManager fragmentManager;
    protected HalamanUtama fragment1;
    protected DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragment initialization
        this.fragment1 = HalamanUtama.newInstance();
        this.fragment2 = AddFragment.newInstance();
        this.fragmentManager = this.getSupportFragmentManager();

        //fragment transaction assigned
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.fragment1).addToBackStack(null).commit();

        //findViewById initialization
        this.toolbar = findViewById(R.id.toolbar);
        this.drawer = findViewById(R.id.drawer_layout);
        this.setSupportActionBar(toolbar);

        ActionBarDrawerToggle adbt = new ActionBarDrawerToggle (this,this.drawer,toolbar,R.string.openDrawer,R.string.closeDrawer);
        drawer.addDrawerListener(adbt);
        adbt.syncState();
    }

    @Override
    /*
        this method controls fragment's changing pages
     */
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();

        if (page == 1) {
            if (this.fragment1.isAdded()) {
                ft.show(this.fragment1);
            }
            else {
                ft.add(R.id.fragment_container, this.fragment1);
            }

            if (this.fragment2.isAdded()) {
                ft.hide(this.fragment2);
            }
        }
        else if (page == 2) {
            if (this.fragment2.isAdded()) {
                ft.show(this.fragment2);
            }
            else {
                ft.add(R.id.fragment_container, this.fragment2);
            }

            if (this.fragment1.isAdded()) {
                ft.hide(this.fragment1);
            }
        }
        ft.commit();
    }

    @Override
    /*
        this method controls operand operation
     */
    public void changeValue() {
        //ganti tv ResultValue halamanUtama
        String opt = this.fragment2.spinner.getSelectedItem().toString();
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

        /*
            this section is not yet finished
         */
        //ketika delete list dari tombol delete sebelah kanan [JANGAN DIHAPUS]
//        if(viewHolder.opt.getText().equals("+")){
//            curr = curr - Integer.parseInt(viewHolder.num.getText().toString());
//        }
//        else if(viewHolder.opt.getText().equals("-")){
//            curr = curr + Integer.parseInt(viewHolder.num.getText().toString());
//        }
//        else if(viewHolder.opt.getText().equals("*")){
//            curr = curr / Integer.parseInt(viewHolder.num.getText().toString());
//        }
//        else if(viewHolder.opt.getText().equals("/")){
//            curr = curr * Integer.parseInt(viewHolder.num.getText().toString());
//        }

        String res = String.valueOf(curr);
        this.fragment1.resultVal.setText(res);
    }

    @Override
    /*
        this method clears fragment's ListView
     */
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

    @Override
    public void saveList(Numop numop){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("label", String.valueOf(numop));
        editor.apply();
    }

    @Override
    /*
        this method should saves last changes made by user
     */
    public void onResume(){
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String previousText = preferences.getString("label","");
        if(!TextUtils.isEmpty(previousText)){
            this.fragment1.nla.add((Numop) this.fragment1.numopList.getSelectedItem());
            this.fragment1.nla.notifyDataSetChanged();
        }
    }
}