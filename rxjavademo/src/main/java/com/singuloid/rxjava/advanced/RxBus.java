package com.singuloid.rxjava.advanced;

import com.jakewharton.rxrelay.PublishRelay;
import com.jakewharton.rxrelay.Relay;

/**
 * Author: guoshicaho
 * Date: 11/23/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/23/16
 * LastUpdateBy: guoshicaho
 */
public class RxBus {
    private final Relay<Object, Object> mBus = PublishRelay.create().toSerialized();


}
