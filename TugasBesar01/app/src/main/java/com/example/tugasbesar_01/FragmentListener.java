package com.example.tugasbesar_01;

public interface FragmentListener {
    void changePage(int page);
    void submitValue();
    void changeValue();
    void clearList();
    void saveList();
    void deleteNum(int position);
    void showResult();
    void closeApp();
}
