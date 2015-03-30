package com.assignment1.androidjammingsessions.fragments;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
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
public class StandardFunctionPanelFragment extends Fragment
{

        View rootView;
        Button[] funcPadKey=new Button[4];
    //


        String[] FUNC_KEY_MODIFIERS={"Add","Sub","Mul","Div"};
    //


        public float alpha=1f;
        public int rootViewWidth=-1;
        public int rootViewHeight=-2;
        //public int minimumHeight=0;
    //


        public int[] buttonColor= {0xFFFFB300,0xFFFFA000,0xFFFF8F00,0xFFFF6F00};
        public int textColor= 0xFFFFFFFF;
        String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";
    //


        standardFunctionPanelFragmentListener mCallback;
    //


        public interface standardFunctionPanelFragmentListener
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
                        mCallback = (standardFunctionPanelFragmentListener) activity;

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

                rootView= inflater.inflate(R.layout.layout_fragment__standard_function_panel, container, false);
                rootView.setAlpha(alpha);
                //((ViewGroup)funcPadKey[0].getParent()).setMinimumHeight(minimumHeight);
            //


                LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);

                //rootViewLayout.weight=2f;
                rootView.setLayoutParams(rootViewLayout);
            //


                for(int i=0;i<4;i++)
                {

                        funcPadKey[i] =(Button)rootView.findViewById(getResources().getIdentifier("funcKey"+FUNC_KEY_MODIFIERS[i], "id", getActivity().getPackageName()));
                    //


                        funcPadKey[i].setBackgroundColor(buttonColor[i]);
                        funcPadKey[i].setTextColor(textColor);
                        funcPadKey[i].setTypeface(Typeface.createFromAsset(getActivity().getAssets(), STANDARD_FONT));
                    //


                        funcPadKey[i].setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                mCallback.buttonPressed(((Button)v).getText().toString());
                            }
                        });
                    //
                    funcPadKey[i].setOnTouchListener(new View.OnTouchListener()
                    {
                        @Override
                        public boolean onTouch(View v, MotionEvent event)
                        {
                            mCallback.sendOnTouchMessage(v);
                            return false;
                        }
                    });
                }
            //


                return rootView;
            //
        }
    //



}
