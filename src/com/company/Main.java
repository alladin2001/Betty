package com.company;

import com.company.server.impl.MyServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new MyServer().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
