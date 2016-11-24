package com.singuloid.mosby.common;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 * <p>
 * The mosby library assumes that all interaction between the Presenter and the View is executed
 * on Android's main UI thread.
 */
public interface MvpPresenter<V extends MvpView> {

    void attachView(V view);

    /**
     * Typically this method will be invoked from {@code Activity.detachView()} or {@code Fragment.onDestroyView()}
     *
     * @param retainInstance
     */
    void detachView(boolean retainInstance);

}
