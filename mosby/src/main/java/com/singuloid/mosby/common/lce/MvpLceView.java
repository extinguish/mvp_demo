package com.singuloid.mosby.common.lce;

import android.support.annotation.UiThread;

import com.singuloid.mosby.common.MvpView;

/**
 * A {@link MvpView} that assumes that there are 3 display operation:
 * <ul>
 * <li>{@link #showLoading(boolean)}: Display a loading animation while loading data in background
 * by
 * invoking the corresponding presenter method</li>
 * <p>
 * <li>{@link #showError(Throwable, boolean)}: Display a error view (a TextView) on the screen if
 * an error has occurred while loading data. You can distinguish between a pull-to-refresh error by
 * checking the boolean parameter and display the error message in another, more suitable way like
 * a
 * Toast</li>
 * <p>
 * <li>{@link #showContent()}: After the content has been loaded the presenter calls {@link
 * #setData(Object)} to fill the view with data. Afterwards, the presenter calls {@link
 * #showContent()} to display the data</li>
 * </ul>
 * <p>
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public interface MvpLceView<M> extends MvpView {

    @UiThread
    public void showLoading(boolean pullToRefresh);

    /**
     * Show the content view.
     * <p>
     * <b>The content view must have the id = R.id.contentView</b>
     */
    @UiThread
    public void showContent();

    @UiThread
    public void showError(Throwable e, boolean pullToRefresh);


    @UiThread
    public void setData(M data);

    /**
     * Load the data. Typically invokes the presenter method to load the desired data.
     * <p>
     * <b>Should not be called from presenter</b> to prevent infinity loops. The method is declared
     * in
     * the views interface to add support for view state easily.
     * </p>
     *
     * @param pullToRefresh true, if triggered by a pull to refresh. Otherwise false.
     */
    @UiThread
    public void loadData(boolean pullToRefresh);

}
