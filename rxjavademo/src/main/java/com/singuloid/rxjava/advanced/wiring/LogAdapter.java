package com.singuloid.rxjava.advanced.wiring;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.singuloid.rxjava.R;

import java.util.List;

/**
 * Author: guoshicaho
 * Date: 11/23/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/23/16
 * LastUpdateBy: guoshicaho
 */
public class LogAdapter extends ArrayAdapter<String> {

    public LogAdapter(Context context, List<String> logs) {
        super(context, R.layout.item_log, R.id.item_log, logs);
    }
}
