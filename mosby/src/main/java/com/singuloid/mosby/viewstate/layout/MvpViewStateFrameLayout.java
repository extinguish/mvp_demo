package com.singuloid.mosby.viewstate.layout;

import android.content.Context;
import android.util.AttributeSet;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;
import com.singuloid.mosby.mvp.layout.MvpFrameLayout;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public abstract class MvpViewStateFrameLayout<V extends MvpView, P extends MvpPresenter<V>> extends MvpFrameLayout<V, P> {
    public MvpViewStateFrameLayout(Context context) {
        super(context);
    }

    public MvpViewStateFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpViewStateFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}


























