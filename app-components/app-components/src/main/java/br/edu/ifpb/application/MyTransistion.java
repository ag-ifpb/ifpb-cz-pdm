package br.edu.ifpb.application;

import android.transition.Transition;
import android.transition.TransitionValues;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyTransistion extends Transition {
    @Override
    public void captureStartValues(TransitionValues transitionValues) {

        Proxy.getInvocationHandler(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        })
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {

    }

}
