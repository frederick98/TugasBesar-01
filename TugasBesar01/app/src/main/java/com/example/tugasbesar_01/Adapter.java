package com.example.tugasbesar_01;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class Adapter extends BaseAdapter {

    protected List<Numop> numops;
    protected Activity activity;
    protected TextView tv_num_value;


    public Adapter(Activity activity){
        this.activity=activity;
        this.numops= new LinkedList<Numop>();
    }

    public void add(Numop item){
        this.numops.add(item);
        this.notifyDataSetChanged();
    }

    public void clearItem(){
        this.numops.clear();
        this.notifyDataSetChanged();
    }

    public void deleteItemOnList(int position){
        this.numops.remove(position);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.numops.size();
    }

    @Override
    public Object getItem(int i) {
        return this.numops.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
//        View itemView = this.activity.getLayoutInflater().inflate(R.layout.numop_list_item,null);
//        this.tv_num_value=itemView.findViewById(R.id.tv_num_value);
//        this.tv_num_value.setText(listItems.get(i));
//
//        return itemView;

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.activity).inflate(R.layout.numop_list_item,parent,false);
            viewHolder = new ViewHolder(convertView,this);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.updateView((Numop) this.getItem(i),i);

        // returns the view for the current row
        return convertView;

    }

    private class ViewHolder implements View.OnClickListener{
        protected TextView num;
        protected TextView opt;
        protected ImageButton btnDelete;
        protected Adapter adapter;
        private int position;
        protected HalamanUtama hm;


        public ViewHolder(View view, Adapter adapter) {
            this.num = view.findViewById(R.id.tv_num_value);
            this.opt = view.findViewById(R.id.tv_opt_value);
            this.btnDelete = view.findViewById(R.id.btn_delete);

            this.btnDelete.setOnClickListener(this);
            view.setOnClickListener(this);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View view) {
            //Log.d(this.getClass().getCanonicalName(), "Position :"+position);
            if (view.getId() == this.btnDelete.getId()){
                 this.adapter.deleteItemOnList(this.position);
            }
        }

        public void updateView(Numop numop, int position){
            this.position = position;
            String convertNum =String.valueOf(numop.getValue()) ;
            this.opt.setText(numop.getOperator());
            this.num.setText(convertNum);
        }
    }
}
