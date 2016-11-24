package com.singuloid.mosby.viewstate.layout;

import android.content.Context;
import android.util.AttributeSet;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;
import com.singuloid.mosby.mvp.layout.MvpLinearLayout;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public class MvpViewStateLinearLayout<V extends MvpView, P extends MvpPresenter<V>> extends MvpLinearLayout<V, P> {
    public MvpViewStateLinearLayout(Context context) {
        super(context);
    }

    public MvpViewStateLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpViewStateLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
