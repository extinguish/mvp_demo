package com.singuloid.mosby.mvp.delegate;

import android.os.Bundle;

import com.singuloid.mosby.common.MvpPresenter;
import com.singuloid.mosby.common.MvpView;

/**
 * A delegate for Activities to attach them to mosbies mvp.
 *
 * <p>
 * The following methods must be invoked from the corresponding Activities lifecycle methods:
 * <ul>
 * <li>{@link #onCreate(Bundle)}</li>
 * <li>{@link #onDestroy()}</li>
 * <li>{@link #onPause()} </li>
 * <li>{@link #onResume()} </li>
 * <li>{@link #onStart()} </li>
 * <li>{@link #onStop()} </li>
 * <li>{@link #onRestart()} </li>
 * <li>{@link #onContentChanged()} </li>
 * <li>{@link #onSaveInstanceState(Bundle)} </li>
 * <li>{@link #onPostCreate(Bundle)} </li>
 * <li></li>
 * </ul>
 * </p>
 *
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public interface ActivityMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    public void onCreate(Bundle bundle);

    public void onDestroy();

    public void onPause();

    public void onResume();

    public void onStart();

    public void onStop();

    public void onRestart();

    public void onContentChanged();

    public void onSaveInstanceState(Bundle bundle);

    public void onPostCreate(Bundle bundle);

    public Object onRetainCustomNonConfigurationInstance();

    public Object getNonMosbyLastCustomNonConfigurationInstance();



}
