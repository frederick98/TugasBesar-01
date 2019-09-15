/*
    created by:
        - 2016730035 Lanang Galih Saputro
        - 2016730040 Frederick
        - 2016730045 Reynaldi Irfan Anwar
 */
package com.example.tugasbesar_01;

public interface FragmentListener {
    void changePage(int page);
    void changeValue();
    void closeApp();
    void addList(Numop numop);
    void clearList();
    void deleteListPos(int position);
    void saveList(Numop numop);
}