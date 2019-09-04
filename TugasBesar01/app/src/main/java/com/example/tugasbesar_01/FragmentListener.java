package com.example.tugasbesar_01;

public interface FragmentListener {
    void changePage(int page);
    void submitValue(int value);
    void changeValue(int value);
    void clearList();
    void saveList();
    void delateNum(int position);
    void showResult();
}
