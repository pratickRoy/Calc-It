package com.assignment1.androidjammingsessions.fragments;

/**
 * Created by Pratick on 28-03-2015.
 */

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.assignment1.androidjammingsessions.calculator.R;

public class SettingsPanelMainSettingsCard extends Fragment
{

    View rootView;
    Button settingsPanelMainHeadingButton;
    Button[] settingsPanelMainContentButton=new Button[3];
    //


    public String[] SETTINGS_PANEL_MODIFIERS={"Standard","Scientific","Programming"};
    //


    public float HeadingsAlpha=1f;
    public float ContentAlpha=0f;
    public int rootViewWidth=-1;
    public int rootViewHeight=-2;
    public int rootViewBackgroundColor=0xFFE3E3E3;
    //


    public int buttonColor= 0xFFFFFFFF;
    public int textColor= 0xFF000000;
    public String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";

    //

    public boolean clicked=false;


    settingsPanelMainSettingsCardListener mCallback;
    //



    public interface settingsPanelMainSettingsCardListener
    {
        public void buttonPressed(String buttonText);
        //public void sendOnTouchMessage(View v);
    }
    //


    @Override
    public void onAttach(Activity activity)
    {

        super.onAttach(activity);
        //




        try
        {
            mCallback = (settingsPanelMainSettingsCardListener) activity;

        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " must implement OnViewScreenSelectedListener");
        }
        //
        //
    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {


        rootView= inflater.inflate(R.layout.layout_fragment__settings_panel__mode_card, container, false);
        rootView.setBackgroundColor(rootViewBackgroundColor);




        settingsPanelMainHeadingButton=(Button)rootView.findViewById(getResources().getIdentifier("settingsPanelCardHeadingsModes", "id", getActivity().getPackageName()));
        settingsPanelMainHeadingButton.setAlpha(HeadingsAlpha);


        for(int i=0;i<3;i++) {

            settingsPanelMainContentButton[i] = (Button) rootView.findViewById(getResources().getIdentifier("settingsPanelCardContentModes" + SETTINGS_PANEL_MODIFIERS[i], "id", getActivity().getPackageName()));
            Toast.makeText(getActivity(),settingsPanelMainContentButton[i]+"",Toast.LENGTH_SHORT);
            //


            settingsPanelMainContentButton[i].setBackgroundColor(buttonColor);
            settingsPanelMainContentButton[i].setTextColor(textColor);
            //settingsPanelMainContentButton[i].setAlpha(ContentAlpha);
            settingsPanelMainContentButton[i].setTypeface(Typeface.createFromAsset(getActivity().getAssets(), STANDARD_FONT));

            LinearLayout.LayoutParams settingsPanelMainContentButtonLayout=new LinearLayout.LayoutParams(rootViewWidth, 0);
            //rootViewLayout.weight=3f;
            settingsPanelMainContentButton[i].setLayoutParams(settingsPanelMainContentButtonLayout);



            settingsPanelMainContentButton[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mCallback.buttonPressed(((Button)v).getText().toString());
                }
            });
            //



            //settingsPanelMainContentButton[i].height;
            //settingsPanelMainContentButton[i].setVisibility(View.INVISIBLE);
            //rootView.invalidate();
            //
            //((ViewGroup) settingsPanelMainContentButton[i].getParent()).removeView(settingsPanelMainContentButton[i]);



        }
        settingsPanelMainHeadingButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(clicked==false)
                {
                    clicked=true;
                    for (int i = 0; i < 3; i++)
                    {
                        LinearLayout.LayoutParams settingsPanelMainContentButtonLayout=new LinearLayout.LayoutParams(rootViewWidth, -2);
                        //rootViewLayout.weight=3f;
                        settingsPanelMainContentButton[i].setLayoutParams(settingsPanelMainContentButtonLayout);
                        //settingsPanelMainContentButton[i].setHeight(-2);
                        //settingsPanelMainContentButton[i].setVisibility(View.VISIBLE);
                        //settingsPanelMainContentButton[i] = (Button) rootView.findViewById(getResources().getIdentifier("settingsPanelCardContentModes" + SETTINGS_PANEL_MODIFIERS[i], "id", getActivity().getPackageName()));
                        //((ViewGroup) settingsPanelMainContentButton[i].getParent()).addView(settingsPanelMainContentButton[i], i);
                    }
                }
                else
                {
                    clicked=false;
                    for (int i = 0; i < 3; i++)
                    {
                        LinearLayout.LayoutParams settingsPanelMainContentButtonLayout=new LinearLayout.LayoutParams(rootViewWidth, 0);
                        //rootViewLayout.weight=3f;
                        settingsPanelMainContentButton[i].setLayoutParams(settingsPanelMainContentButtonLayout);
                        //settingsPanelMainContentButton[i].setVisibility(View.INVISIBLE);
                        //((ViewGroup) settingsPanelMainContentButton[i].getParent()).removeView(settingsPanelMainContentButton[i]);
                    }
                }
            }
        });

        //


        LinearLayout.LayoutParams rootViewLayout=new LinearLayout.LayoutParams(rootViewWidth, rootViewHeight);
        //rootViewLayout.weight=3f;
        rootView.setLayoutParams(rootViewLayout);

        return rootView;
        //
        //
    }
    //
}
