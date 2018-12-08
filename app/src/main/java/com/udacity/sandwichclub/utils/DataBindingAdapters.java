package com.udacity.sandwichclub.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.net.wifi.ScanResult;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.sandwichclub.R;

import java.util.List;

public class DataBindingAdapters {

    private DataBindingAdapters() { }

    @BindingAdapter("android:text")
    public static void listToString(TextView textView, List<?> list){
        StringBuilder stringBuilder = new StringBuilder();
        Context context = textView.getContext();
        for(Object obj  : list){
            String separator = list.indexOf(obj)==list.size()-1?"":", ";
            String item = context.getString(R.string.list_to_string_item, String.valueOf(obj), separator);
            stringBuilder.append(item);
        }
        textView.setText(stringBuilder.toString());
    }

}
