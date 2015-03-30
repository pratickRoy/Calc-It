package com.assignment1.androidjammingsessions.fragments;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.assignment1.androidjammingsessions.calculator.R;

/**
 * Created by ${Roy} on ${2050}.
 */
public class ScientificFunctionPanelLeftFragment extends Fragment
{

        View rootView;
        Button[] funcPadKey=new Button[15];
    //



        String[] FUNC_KEY_MODIFIERS={"Sine","Cosine","Tangent","Log","SquareRoot","SineInverse","CosineInverse","TangentInverse","Ln","RoundOff","SineHyperbolic","CosineHyperbolic","TangentHyperbolic","Degrees","Radians"};
    //


        public float alpha=1f;
        public int rootViewWidth=-2;
        public int rootViewHeight=-2;
        public int activeButton=14;
    //


        public int[] buttonColor= {0xFF4CAF50,0xFFFF6F00};
        public int textColor= 0xFFFFFFFF;
        String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";
    //


        ScientificFunctionPanelLeftFragmentListener mCallback;
    //


        public interface ScientificFunctionPanelLeftFragmentListener
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
                    mCallback = (ScientificFunctionPanelLeftFragmentListener) activity;

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

            rootView= inflater.inflate(R.layout.layout_fragment__sceintific_function_panel_left, container, false);
            rootView.setAlpha(alpha);

        //


            LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);
            rootView.setLayoutParams(rootViewLayout);
        //








        //Toast.makeText(getActivity(),"Hello",Toast.LENGTH_SHORT).show();



            for(int i=0;i<15;i++)
            {


                    funcPadKey[i]= (Button)rootView.findViewById(getResources().getIdentifier("funcKey" + FUNC_KEY_MODIFIERS[i], "id", getActivity().getPackageName()));

                //

                        if(i!=activeButton)
                            funcPadKey[i].setBackgroundColor(buttonColor[0]);
                        else
                            funcPadKey[i].setBackgroundColor(buttonColor[1]);
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

                funcPadKey[i].setOnTouchListener(new View.OnTouchListener()
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

        funcPadKey[13].setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                activeButton=13;
                funcPadKey[13].setBackgroundColor(buttonColor[1]);
                funcPadKey[14].setBackgroundColor(buttonColor[0]);
            }
        });

        funcPadKey[14].setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                activeButton=14;
                funcPadKey[13].setBackgroundColor(buttonColor[0]);
                funcPadKey[14].setBackgroundColor(buttonColor[1]);
            }
        });
        //






            return rootView;
        //
    }
    //

}
