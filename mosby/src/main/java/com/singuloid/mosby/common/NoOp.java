package com.singuloid.mosby.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
final class NoOp {

    private static final InvocationHandler DEFAULT_VALUE = new DefaultInvocationHandler();

    private NoOp() {

    }

    public static <T> T of(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, DEFAULT_VALUE);
    }

    private static class DefaultInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            return Defaults.defaultValue(method.getReturnType());
        }
    }

}
