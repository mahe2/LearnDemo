package com.learn.demo.proxy;

import com.learn.demo.util.Logger;


/**
 * Created by mahe on 2018/1/24.
 */

public class FruitCakeMachine implements CakeMachine {
    @Override
    public void makeCacke() {
        Logger.i("make fruit cake");
    }
}
