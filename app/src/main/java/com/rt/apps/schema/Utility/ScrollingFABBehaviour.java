package com.rt.apps.schema.Utility;

import android.content.Context;
import android.os.Build;
//import android.support.design.widget.CoordinatorLayout;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ScrollingFABBehaviour extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private int toolbarHeight;
    private static boolean scrolledUp = false;
    private static boolean scrolledDown = false;

    public ScrollingFABBehaviour(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.toolbarHeight = Utils.getToolbarHeight(context);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return (dependency instanceof Snackbar.SnackbarLayout) || (dependency instanceof Toolbar);
//        return (dependency instanceof Snackbar.SnackbarLayout);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final FloatingActionButton child, View dependency) {
        if (dependency instanceof Snackbar.SnackbarLayout) {
            float finalVal = (float) parent.getHeight() - dependency.getY();
            child.setTranslationY(-finalVal);
        }
//
//        if(dependency instanceof RecyclerView){
//            RecyclerView view = (RecyclerView)dependency;
//            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams)child.getLayoutParams();
//            int fabBottomMargin = lp.bottomMargin;
//            final int distanceToScroll = child.getHeight() + fabBottomMargin;
//
//            final RecyclerView.LayoutManager rlp = (RecyclerView.LayoutManager)view.getLayoutManager();
//            Log.d("OskarSchindler", "Height: "+rlp.getHeight());
//
//
//
//        }
        if (dependency instanceof Toolbar) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = child.getHeight() + fabBottomMargin;
            float finalVal = dependency.getY() / (float) toolbarHeight;
            float distFinal = -distanceToScroll * finalVal;
            child.setTranslationY(distFinal);
        }


        return true;
    }

}
