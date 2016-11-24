package com.singuloid.mosby.mvp.delegate;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;

/**
 * The MvpDelegate callback that will be called from  {@link
 * ActivityMvpDelegate}. This interface must be implemented by all
 * Activities that you want to support mosby's mvp.
 * <p>
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public interface ActivityMvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> extends MvpDelegateCallback<V, P> {

    /**
     * Return any Object holding the desired state to propagate to the next activity instance. Please
     * note that mosby internals like the presenter are already saved internally and you don't have
     * to take them into account. You can retrieve this value later with {@link
     * ActivityMvpDelegate#getNonMosbyLastCustomNonConfigurationInstance()}.
     * <p>
     * <p>
     * This mechanism works pretty the same way as {@link android.support.v4.app.FragmentActivity#onRetainCustomNonConfigurationInstance()}
     * and {@link #getNonMosbyLastCustomNonConfigurationInstance()}
     * </p>
     *
     * @return Object holding state.
     */
    public Object onRetainNonMosbyCustomNonConfigurationInstance();

    public Object getLastCustomNonConfigurationInstance();

    /**
     * This method should invoke {@link
     * ActivityMvpDelegate#getNonMosbyLastCustomNonConfigurationInstance()}.
     * <p>
     * <p>
     * This method is not really a "callback" method (will not invoked from delegate somehow).
     * However, it's part of this interface to ensure that no custom implementation will miss this
     * method since this method is the counterpart to {@link #onRetainNonMosbyCustomNonConfigurationInstance()}
     * </p>
     */
    public Object getNonMosbyLastCustomNonConfigurationInstance();

}
