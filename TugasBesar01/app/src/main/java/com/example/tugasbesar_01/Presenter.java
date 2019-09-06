package com.example.tugasbesar_01;

import java.util.LinkedList;
import java.util.List;

public class Presenter {
    protected List<Numop> numop;
    protected IMainActivity activity;

    public Presenter(IMainActivity activity){
        this.activity = activity;
        this.numop = new LinkedList<Numop>();
    }

    public void deleteList(int position){
        this.numop.remove(position);
        this.activity.updateList(this.numop);
    }

    public void addList(String operand, int number){
        this.numop.add(new Numop(operand, number));
        this.activity.updateList(this.numop);
        this.activity.resetAddForm();
    }
}
