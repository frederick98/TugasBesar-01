package com.example.tugasbesar_01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainPresenter {
    protected List<Numop> numops;
    protected IMainActivity ui;

    public MainPresenter(IMainActivity activity){
        this.ui = activity;
        this.numops = new LinkedList<Numop>();
    }

    public void loadData(){
        this.numops.addAll(Arrays.asList(MockNumop.foodObjectArr));
        this.ui.updateList(this.numops);
    }

    public void deleteList(int position){
        this.numops.remove(position);
        this.ui.updateList(this.numops);
    }

    public void addList(String operator, int value){
        this.numops.add(new Numop(operator,value));
        this.ui.updateList(this.numops);
        this.ui.resetAddForm();
    }

}
