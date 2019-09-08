package com.example.tugasbesar_01;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class NumopListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Numop> numops;
    private MainPresenter presenter;

    public NumopListAdapter(Activity activity, MainPresenter presenter){
        this.activity =  activity;
        this.presenter = presenter;
        this.numops = new LinkedList<Numop>();
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
        // inflate the layout for each list row
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.activity).inflate(R.layout.numop_list_item, parent, false);
            viewHolder = new ViewHolder(convertView,this.presenter);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.updateView((Numop) this.getItem(i),i);

        // returns the view for the current row
        return convertView;
    }

    public void update(List<Numop> getNum){
        this.numops.clear();
        this.numops.addAll((getNum));
        this.notifyDataSetChanged();
    }

    private class ViewHolder implements View.OnClickListener{
        protected TextView value;
        protected TextView operator;
        protected ImageButton btnDelete;
        protected MainPresenter presenter;
        private int position;

        public ViewHolder(View view, MainPresenter presenter) {
            this.value = view.findViewById(R.id.tv_num_value);
            this.operator = view.findViewById(R.id.tv_opt_value);
            this.btnDelete = view.findViewById(R.id.btn_delete);

            this.btnDelete.setOnClickListener(this);
            view.setOnClickListener(this);
            this.presenter = presenter;
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == this.btnDelete.getId()){
                this.presenter.deleteList(this.position);
            }
        }

        public void updateView(Numop numop,int position){
            this.position = position;
            this.value.setText(numop.getValue());
            this.operator.setText(numop.getOperator());

        }
    }
}
