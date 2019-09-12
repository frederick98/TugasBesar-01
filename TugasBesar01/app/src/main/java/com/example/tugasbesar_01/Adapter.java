package com.example.tugasbesar_01;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {

    protected List<String> listItems;
    protected Activity activity;
    protected SaveDisplay saveDisplay;
    protected TextView tv_opt_value;
    protected TextView tv_num_value;
    protected AddFragment addFragment;

    public Adapter(Activity activity){
        this.activity=activity;
        this.listItems= new ArrayList<String>();
    }

    public void add(String item){
        this.listItems.add(item);
        this.notifyDataSetChanged();
    }

    public void clearItem(){
        this.listItems.clear();
        this.notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = this.activity.getLayoutInflater().inflate(R.layout.numop_list_item,null);
        this.tv_num_value=itemView.findViewById(R.id.tv_num_value);
        this.tv_num_value.setText(listItems.get(i));

        return itemView;
    }
}
