package com.assignment1.androidjammingsessions.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;

import com.assignment1.androidjammingsessions.calculator.R;

/**
 * Created by ${Roy} on ${2050}.
 */

public class ProgrammingNumberPanelFragmentAtoF extends Fragment
{

        View rootView;
        Button[] numPadKey=new Button[6];
    //


       //public String[] EVAL_KEY_MODIFIERS={"Fact","Power","Backspace","Evaluation"};
    //


        public float alpha=1f;
        public int rootViewWidth=-2;
        public int rootViewHeight=-2;
    //



        public int buttonColor= 0xFF283593;
        public int textColor= 0xFFFFFFFF;
        public String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";

    //


        ProgrammingNumberPanelFragmentAtoFListener mCallback;
    //


        public interface ProgrammingNumberPanelFragmentAtoFListener
        {
            public void buttonPressed(String buttonText);
            public void sendOnTouchMessage(View v);
            //public void longButtonPressed(String buttonText);
        }
    //


        @Override
        public void onAttach(Activity activity)
        {

                super.onAttach(activity);
            //



                    try
                    {
                        mCallback = (ProgrammingNumberPanelFragmentAtoFListener) activity;

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


                rootView= inflater.inflate(R.layout.layout_fragment__programming_number_panel_atof, container, false);
                rootView.setAlpha(alpha);
            //


                LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);
                //rootViewLayout.weight=3f;
                rootView.setLayoutParams(rootViewLayout);
            //


                for(int i=0;i<6;i++)
                {

                        numPadKey[i] =(Button)rootView.findViewById(getResources().getIdentifier("numKey"+(char)(i+65), "id", getActivity().getPackageName()));
                    //


                        numPadKey[i].setBackgroundColor(buttonColor);
                        numPadKey[i].setTextColor(textColor);
                        numPadKey[i].setTypeface(Typeface.createFromAsset(getActivity().getAssets(), STANDARD_FONT));
                    //


                        numPadKey[i].setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                    mCallback.buttonPressed(((Button)v).getText().toString());
                            }
                        });

                    numPadKey[i].setOnTouchListener(new View.OnTouchListener()
                    {

                        @Override
                        public boolean onTouch(View v, MotionEvent event)
                        {
                            mCallback.sendOnTouchMessage(v);
                            return false;
                        }
                    });
                    //
                }



                    return rootView;
                //
            //
        }
    //


}
