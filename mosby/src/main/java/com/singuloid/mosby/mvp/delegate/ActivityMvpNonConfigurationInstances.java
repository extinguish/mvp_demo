package com.singuloid.mosby.mvp.delegate;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
class ActivityMvpNonConfigurationInstances<V extends MvpView, P extends MvpPresenter<V>> {

    P presenter;

    Object nonMosbyCustomConfigurationInstance;

    ActivityMvpNonConfigurationInstances(P presenter, Object nonMosbyCustomConfigurationInstance) {
        this.presenter = presenter;
        this.nonMosbyCustomConfigurationInstance = nonMosbyCustomConfigurationInstance;
    }

}
