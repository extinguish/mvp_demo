package com.singuloid.mosby.mvp.delegate;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;

/**
 * The MvpDelegate callback that will be called from  {@link
 * FragmentMvpDelegate} or {@link ViewGroupMvpDelegate}. This interface must be implemented by all
 * Fragment or android.view.View that you want to support mosbys mvp. Please note that Activties
 * need a special callback {@link ActivityMvpDelegateCallback}
 * <p>
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public interface MvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> {


    public P createPresenter();

    public void setPresenter(P presenter);

    public V getMvpView();

    public boolean isRetainInstance();

    public void setRetainInstance(boolean retainingInstance);

    public boolean shouldInstanceBeRetained();


}
