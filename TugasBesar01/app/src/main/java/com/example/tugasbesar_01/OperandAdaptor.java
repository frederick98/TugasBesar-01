package com.example.tugasbesar_01;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


public class OperandAdaptor extends BaseAdapter {
    private List<Numop> operandList;
    private Activity activity;
    private Presenter presenter;

    public OperandAdaptor(Activity activity, Presenter presenter){
        this.operandList = new LinkedList<Numop>();
        this.activity = activity;
        this.presenter = presenter;
    }

    //this method is used to update the damn list
    protected void update(List<Numop> newNumop){
        this.operandList.clear();
        this.operandList.addAll((newNumop));
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return operandList.size();
    }

    @Override
    public Object getItem(int i) {
        return operandList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if(view == null){
            view = LayoutInflater.from(this.activity).inflate(R.layout.numop_list_item, viewGroup, false);
            viewHolder = new ViewHolder(view, this.presenter);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.updateView((Numop)this.getItem(i),i);

        //this will return the view for the correct row
        return view;
    }
}

class ViewHolder implements View.OnClickListener{
    protected Spinner spinner;
    protected EditText et_number;
    protected Button btn_submit;
    protected TextView tv_operand;
    protected TextView tv_number;

    protected Presenter presenter;
    private int position;

    public ViewHolder(View view, Presenter presenter){
        this.spinner = view.findViewById(R.id.spinner1);
        this.et_number = view.findViewById(R.id.et_input);
        this.btn_submit = view.findViewById(R.id.btn_submit);

        //not yet needed
        //this.ivDelete = view.findViewById(R.id.ivTrash);

        //not yet needed
        //this.ivDelete.setOnClickListener(this);

        this.btn_submit.setOnClickListener(this);
        view.setOnClickListener(this);
        this.presenter = presenter;
    }

    public void updateView(Numop numop, int position){
        this.position = position;
        this.tv_operand.setText(numop.getOperator());
        this.tv_number.setText(numop.getValue());

        //this section is not yet needed
        /*
        if(numop.getFavourite()){
            ivStar.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else{
            ivStar.setImageResource(android.R.drawable.btn_star_big_off);
        }
        
         */
    }

    @Override
    public void onClick(View view) {
        //Log.d(this.getClass().getCanonicalName(), "Position :" + position);

        if(view.getId() == this.btn_submit.getId()){
            int value = Integer.parseInt(tv_number.getText().toString());
            this.presenter.addList(spinner.getOnItemSelectedListener().toString(), value);
        }

        /*
        if(view.getId() == this.ivDelete.getId()){
            this.presenter.deleteList(this.position);
        } else{
            this.presenter.toggleFav(this.position);
        }

         */

    }
}
