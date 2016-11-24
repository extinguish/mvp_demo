package com.singuloid.mosby.mvp.lce;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;

import com.singuloid.mosby.R;

/**
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 * <p>
 * Little helper class of which using to animate the loading procedure of {@link com.singuloid.mosby.common.MvpView}
 */
public class LceAnimator {

    private LceAnimator() {

    }

    /**
     * show the loading view with no animation cause in most situations the loading speed are very fast.
     */
    public static void showLoadingView(View loadingView, View contentView, View errorView) {
        contentView.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }

    /**
     * show the error view instead of the loading view.
     *
     * @param loadingView
     * @param contentView
     * @param errorView
     */
    public static void showErrorView(final View loadingView, final View contentView, final View errorView) {
        contentView.setVisibility(View.GONE);

        final Resources resources = loadingView.getResources();

        AnimatorSet animatorSet = new AnimatorSet();
        // create the animator to animate the errorView in
        ObjectAnimator inAnimator = ObjectAnimator.ofFloat(errorView, View.ALPHA, 1f);
        // create the animator to animate the loadingView out
        final ObjectAnimator loadingOutAnimator = ObjectAnimator.ofFloat(loadingView, View.ALPHA, 0f);

        animatorSet.playTogether(inAnimator, loadingOutAnimator);
        animatorSet.setDuration(resources.getInteger(R.integer.lce_error_view_show_animation_time));
        animatorSet.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                loadingView.setVisibility(View.GONE);
                loadingView.setAlpha(1f); // for future loading animation
            }
        });


    }

    /**
     * display the content instead of the loading view.
     */
    public static void showContent(final View loadingView, final View contentView, final View errorView) {

        if (contentView.getVisibility() == View.VISIBLE) {
            errorView.setVisibility(View.GONE);
            loadingView.setVisibility(View.GONE);
        } else {
            errorView.setVisibility(View.GONE);

            final Resources resources = loadingView.getResources();
            final int translateInPixels = resources.getDimensionPixelSize(R.dimen.lce_content_view_animation_translate_y);


        }

    }


}
