package com.singuloid.mosby.mvp.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public abstract class MvpFrameLayout<V extends MvpView, P extends MvpPresenter<V>> extends FrameLayout {

    public MvpFrameLayout(Context context) {
        super(context);
    }

    public MvpFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
