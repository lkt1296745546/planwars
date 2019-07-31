package com.neuedu;

import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;

import javax.xml.crypto.Data;

public class Gamestart {
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        DataStore.put("gameFrame",gameFrame);
        gameFrame.init();
    }
}
