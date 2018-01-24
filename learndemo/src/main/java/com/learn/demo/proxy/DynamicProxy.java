package com.learn.demo.proxy;

import com.learn.demo.util.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: millioncoder@sina.com
 * Date: 2018/1/24
 * Dscreption:
 */

public class DynamicProxy implements InvocationHandler {

    Object cakeMachine;

    public DynamicProxy(Object cakeMachine){
        this.cakeMachine = cakeMachine;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(cakeMachine,args);
            Logger.i("add cheese ");
            return result;
    }
}
