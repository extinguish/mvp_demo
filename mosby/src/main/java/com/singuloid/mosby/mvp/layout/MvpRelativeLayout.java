package com.singuloid.mosby.mvp.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public class MvpRelativeLayout<V extends MvpView, P extends MvpPresenter<V>> extends RelativeLayout {

    public MvpRelativeLayout(Context context) {
        super(context);
    }

    public MvpRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MvpRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
