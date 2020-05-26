package com.rt.apps.schema.Reminder;

import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.rt.apps.schema.AppDefault.AppDefaultActivity;
import com.rt.apps.schema.R;

public class ReminderActivity extends AppDefaultActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.reminder_layout;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return ReminderFragment.newInstance();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }


}
