package com.xinqiu.user.test;

public class singleton {

    private static singleton instance = null;

    public static synchronized singleton getInstance(){
        if (instance == null){
            instance = new singleton();
        }
        return instance;
    }

}
