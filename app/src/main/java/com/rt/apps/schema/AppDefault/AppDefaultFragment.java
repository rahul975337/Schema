package com.rt.apps.schema.AppDefault;

import android.app.DatePickerDialog;
import android.os.Bundle;
//import android.support.annotation.LayoutRes;
////import android.support.annotation.Nullable;
////import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;

public abstract class AppDefaultFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(layoutRes(), container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public abstract void onTimeSet(RadialPickerLayout radialPickerLayout, int hour, int minute);

    public abstract void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day);

    @LayoutRes
    protected abstract int layoutRes();
}
