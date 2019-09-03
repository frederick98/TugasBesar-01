//package com.example.tugasbesar_01;
//
//import android.app.Fragment;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//public class AddFragment extends Fragment implements View.OnClickListener {
//
//    public FirstFragment(){
//
//    }
//
//    public static AddFragment newInstance(String title){
//        AddFragment fragment = new AddFragment();
//        Bundle args = new Bundle();
//        args.putString("title",title);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState){
//        View view = inflater.inflate(R.layout.add_fragment,container,false);
//
//        this.tvTitle = view.findViewById(R.id.tv_title);
//
//        this.tvMsg = view.findViewById(R.id.tv_Message);
//
//        this.btnPage2 = view.findViewById(R.id.btnPage2);
//
//        this.btnPage2.setOnClickListener(this);
//        return view;

//        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
//        android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.operator_arrays));
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//    }
//
//    @Override
//    public void onAttach(Context context){
//        super.onAttach(context);
//        if(context instanceof FragmentListener){
//            this.listener = (FragmentListener) context;
//
//        }
//        else{
//            throw new ClassCastException(context.toString()
//                    +"must implement FragmentListener");
//        }
//    }
//
//
//    @Override
//    public void onClick(View view) {
//        if(view.getId()==this.btnPage2.getId()){
//            this.listener.changePage(2);
//        }
//    }
//}
