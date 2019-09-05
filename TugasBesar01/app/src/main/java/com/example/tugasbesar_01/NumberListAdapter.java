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

public class NumberListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Numop> numop;
    private MainPresenter presenter;

    public NumberListAdapter(Activity activity, MainPresenter presenter) {
        this.activity = activity;
        this.presenter = presenter;
        this.numop = new LinkedList<Numop>();
    }

    @Override
    public int getCount() {
        return this.numop.size();
    }

    @Override
    public Object getItem(int i) {
        return this.numop.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        /*
        // inflate the layout for each list row
        ViewHolder viewHolder;

        if (convertView == null) {
            //buat dulu numop_list_item.xml nya(sudah)
            convertView = LayoutInflater.from(this.activity).inflate(R.layout.numop_list_item, parent, false);
            viewHolder = new ViewHolder(convertView,this.presenter);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.updateView((Numop)this.getItem(i),i);

         */

        // returns the view for the current row
        return convertView;
    }

    public void update(List<Numop> getNumop){
        /*
        this.numop.clear();
        this.numop.addAll((getNumop));
        this.notifyDataSetChanged();

         */
    }

    public void tambah(String str, int num) {
        /*

        this.numop.add(new Numop(str, num));
        this.notifyDataSetChanged();
         */
    }
    private class ViewHolder implements View.OnClickListener{
        /*
        protected TextView num;
        protected TextView opt;
        protected ImageButton btnDelete;
        protected MainPresenter presenter;
        private int position;

        public ViewHolder(View view, MainPresenter presenter) {
            this.num = view.findViewById(R.id.tv_num_value);
            this.opt = view.findViewById(R.id.tv_opt_value);
            this.btnDelete = view.findViewById(R.id.btn_delete);

            this.btnDelete.setOnClickListener(this);
            view.setOnClickListener(this);
            this.presenter = presenter;

         */
        }

        @Override
        public void onClick(View view) {
            //Log.d(this.getClass().getCanonicalName(), "Position :"+position);
            /*
            if (view.getId() == this.btnDelete.getId()){
                this.presenter.deleteList(this.position);
            }

             */
        }

        public void updateView(Numop numops, int position){
        /*
            this.position = position;
            this.num.setText(numops.getValue());
            this.opt.setText(numops.getOperator());
            
         */
        }
    }
}



