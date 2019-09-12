package com.example.tugasbesar_01;

public interface FragmentListener {
    void changePage(int page);
    void changeValue();
    void closeApp();
    void addList(String text);

    
    void clearList();
    void saveList();
    void deleteNum(int position);
    void showResult();
    void submitValue();
}
