package com.singuloid.mosby.common;

import android.support.annotation.UiThread;

import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * A {@link MvpPresenter} implmenetation that implements the <a href="https://en.wikipedia.org/wiki/Null_Object_pattern">null
 * object pattern</a> for the attached mvp view. So whenever the view gets detached from this
 * presenter by calling{@link #detachView(boolean)}, a new "null object" view gets dynamically
 * instantiated by using reflections and set as the current
 * view (instead of null). The new "null object" view simply does nothing. This avoids
 * NullPointerExceptions and checks like {@code if (getView() != null)}
 * <p>
 * <p>
 * Please note that when creating the "null object" the first generic parameter (left depth-first
 * search) that will be found that is subtype of {@link MvpView} will be used as the type of the
 * view. So avoid having multiple generic parameters for "View" like this {@code
 * MyPresenter<FooMvpView, OtherMvpView>} because we can't know wheter FooMvpView or OtherMvpView is
 * the
 * real type of this presenter's view. In that case (left depth-first search) FooMvpView will be
 * used (may cause ClassCastException if OtherMvpView was the desired one)
 * </p>
 * <p>
 * <p>
 * Author: guoshicaho
 * Date: 11/22/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/22/16
 * LastUpdateBy: guoshicaho
 */
public class MvpNullObjectBasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private WeakReference<V> mViewRef;
    private final V mNullView;

    public MvpNullObjectBasePresenter() {
        try {
            // Scan the inheritance hierarchy until we reached MvpNullObjectBasePresenter
            Class<V> viewClass = null;
            Class<?> currentClass = null;

            while (viewClass == null) {
                Type genericSuperType = currentClass.getGenericSuperclass();
                while (!(genericSuperType instanceof ParameterizedType)) {
                    // Scan inheritance tree until we find ParameterizedType which is probably a MvpSubClass
                    currentClass = currentClass.getSuperclass();
                    genericSuperType = currentClass.getGenericSuperclass();
                }

                Type[] types = ((ParameterizedType) genericSuperType).getActualTypeArguments();

                for (Type type : types) {
                    Class<?> genericType = (Class<?>) type;
                    if (genericType.isInterface() && isSubTypeOfMvpView(genericType)) {
                        viewClass = (Class<V>) genericType;
                        break;
                    }
                }

                currentClass = currentClass.getSuperclass();
            }
            mNullView = NoOp.of(viewClass);
        } catch (Throwable e) {
            throw new IllegalArgumentException("");
        }
    }

    /**
     * Scans teh interface inheritance hierarchy and checks if on the root is MvpView.class recursively.
     *
     * @param clazz
     * @return true if subtype of MvpView otherwise false
     */
    private boolean isSubTypeOfMvpView(Class<?> clazz) {
        if (clazz.equals(MvpView.class)) {
            return true;
        }
        Class[] superInterfaces = clazz.getInterfaces();
        for (Class superInterface : superInterfaces) {
            if (isSubTypeOfMvpView(superInterface))
                return true;
        }
        return false;
    }


    @Override
    public void attachView(V view) {
        mViewRef = new WeakReference<>(view);
    }

    @UiThread
    public V getView() {
        if (mViewRef != null) {
            V realView = mViewRef.get();
            if (realView != null) {
                return realView;
            }
        }
        return mNullView;
    }


    @Override
    public void detachView(boolean retainInstance) {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
