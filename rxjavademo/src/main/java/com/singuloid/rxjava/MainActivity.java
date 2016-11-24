package com.singuloid.rxjava;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RxAndroid_test";

    private ImageView mTargetImgView;

    private Looper mBackgroundLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTargetImgView = (ImageView) findViewById(R.id.target_img_view);

        BackgroundThread backgroundThread = new BackgroundThread();
        backgroundThread.start();
        mBackgroundLooper = backgroundThread.getLooper();

        findViewById(R.id.btn_run_scheduler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRunSchedulerExampleBtnClicked();
            }
        });
    }

    void onRunSchedulerExampleBtnClicked() {
        sampleObservable()
                .subscribeOn(AndroidSchedulers.from(mBackgroundLooper))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, " on event completed ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, " error happened cause of " + e);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, " the event are triggered  ");
                        Log.d(TAG, " the next event " + s);
                    }
                });
    }

    static Observable<String> sampleObservable() {
        /**
         * The defer Observer allows you to defer or delay emitting items from an Observable until such time as an
         * Observer subscribes to the Observable. This allows an {@link Observer} to easily obtain updates or a
         * refreshed version of the sequence.
         */
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                // here we make the process sleep, thus to simulate the feature of long background work
                try {
                    Log.d(TAG, " start execute the event at here ");
                    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return Observable.just("One", "Two", "Third", "Fourth", "Fifth");
            }
        });
    }

    static class BackgroundThread extends HandlerThread {

        public BackgroundThread() {
            super("SchedulerSample-BackgroundThread", Process.THREAD_PRIORITY_BACKGROUND);
        }
    }



}
