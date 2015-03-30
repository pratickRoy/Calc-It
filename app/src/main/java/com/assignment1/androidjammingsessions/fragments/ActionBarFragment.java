package com.assignment1.androidjammingsessions.fragments;

import com.assignment1.androidjammingsessions.calculator.*;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

public class ActionBarFragment extends Fragment
{


        View rootView;
        TextView actionBarTitleText;
        Button actionBarSettingsKey;
    //



        public int actionBarTitleTextColor          = 0xFFFFFFFF;
        public int actionBarSettingsKeyColor        = 0xFFFFFFFF;
        public float actionBarTitleTextRotation     = 0f;
        public float actionBarSettingsKeyRotation   = 270f;
        public int actionBarBackTextBackgroundColor = 0xFFf57c00;//0xFFEF6C00;
        public int actionBarSettingsBackgroundColor = 0xFFf57c00;//0xFFEF6C00;;
        public int textColor                        = 0xFFFFFFFF;
        public String STANDARD_FONT                 = "font/RobotoCondensed-BoldItalic.ttf";
        public String MENU_ICON_FONT                = "font/Roboto-Thin.ttf";
    //



        public float alpha=1f;
        public int actionBarBackgroundColor= 0xFFf57c00;//0xFFEF6C00;;
        public int rootViewWidth=-2;
        public int rootViewHeight=-2;
    //






    actionBarFragmentListener mCallback;
    //



    public interface actionBarFragmentListener
    {
        public void buttonPressed(String buttonText);
        public void sendOnTouchMessage(View v);
    }
    //



    @Override
    public void onAttach(Activity activity)
    {


        super.onAttach(activity);
        //




        try
        {
            mCallback = (actionBarFragmentListener) activity;


        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " must implement OnViewScreenSelectedListener");
        }
        //
        //
    }








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {


            rootView= inflater.inflate(R.layout.layout_fragment__action_bar, container, false);
            rootView.setAlpha(alpha);
            rootView.setBackgroundColor(actionBarBackgroundColor);

        //setOnFling(rootView);



        //



            LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);
            rootView.setLayoutParams(rootViewLayout);
        //



            actionBarTitleText = (TextView)rootView.findViewById(R.id.actionBarText);
            actionBarSettingsKey = (Button)rootView.findViewById(R.id.actionBarSettingsButton);
        //



            actionBarTitleText.setTextColor(actionBarTitleTextColor);
            actionBarTitleText.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), STANDARD_FONT));
            actionBarTitleText.setRotation(actionBarTitleTextRotation);
            actionBarTitleText.setBackgroundColor(actionBarBackTextBackgroundColor);

            actionBarTitleText.setFocusable(true);
        actionBarTitleText.setClickable(true);


            actionBarSettingsKey.setTextColor(actionBarSettingsKeyColor);
            actionBarSettingsKey.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), MENU_ICON_FONT));
            actionBarSettingsKey.setRotation(actionBarSettingsKeyRotation);
            actionBarSettingsKey.setBackgroundColor(actionBarSettingsBackgroundColor);


            actionBarSettingsKey.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mCallback.buttonPressed(((Button)v).getText().toString());
                }
            });
        //
        actionBarTitleText.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                mCallback.sendOnTouchMessage(v);
                return false;
            }
        });
        actionBarSettingsKey.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                mCallback.sendOnTouchMessage(v);
                return false;
            }
        });

        //setOnFling(actionBarSettingsKey);

        return rootView;
    }


}