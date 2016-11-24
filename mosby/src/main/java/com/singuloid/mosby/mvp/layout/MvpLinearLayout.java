package com.singuloid.mosby.mvp.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public abstract class MvpLinearLayout<V extends MvpView, P extends MvpPresenter<V>> extends LinearLayout {
    public MvpLinearLayout(Context context) {
        super(context);
    }

    public MvpLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
