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
import android.content.Context;
import android.content.SharedPreferences;

public class SaveDisplay {

    protected SharedPreferences sharedPref;
    protected final static  String NAMA_SHARED_PREF = "sp_nilai_display";
    protected final static String KEY_INPUT = "INPUT";
    protected final static String KEY_SPINNER = "SPINNER";


    public SaveDisplay(Context context){
        this.sharedPref = context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }

    public void saveInput(String input){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_INPUT,input);
        editor.commit();
    }

    public String getInput(){
        return sharedPref.getString(KEY_INPUT,"");
    }

    public void saveSpinner(String spinner){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_SPINNER,spinner);
        editor.commit();
    }

    public String getSpinner(){
        return sharedPref.getString(KEY_SPINNER,"");
    }
}