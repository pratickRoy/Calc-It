package com.assignment1.androidjammingsessions.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.assignment1.androidjammingsessions.calculator.R;

/**
 * Created by ${Roy} on ${2050}.
 */
public class ShadowFragment extends Fragment
{
    View rootView;
    public float alpha=1f;
    public int backgroundColorStart=0xFF000000;
    public int backgroundColorEnd=0x00FFFFFF;
    public int rootViewWidth=-2;
    public int rootViewHeight=-2;
    public int x1=0;
    public int y1=0;
    public int x2=0;
    public int y2=0;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        rootView = inflater.inflate(R.layout.layout_fragment__shadow, container, false);
        rootView.setAlpha(alpha);


        ShapeDrawable mDrawable = new ShapeDrawable(new RectShape());
        mDrawable.getPaint().setShader(new LinearGradient(x1,y1,x2,y2,backgroundColorStart, backgroundColorEnd, Shader.TileMode.CLAMP));
        rootView.setBackground(mDrawable);



        LinearLayout.LayoutParams rootViewLayout=new LinearLayout.LayoutParams(rootViewWidth, rootViewHeight);
        //rootViewLayout.weight=2f;
        rootView.setLayoutParams(rootViewLayout);

        return rootView;
    }


}
