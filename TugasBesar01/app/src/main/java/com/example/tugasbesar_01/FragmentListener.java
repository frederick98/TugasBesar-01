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
