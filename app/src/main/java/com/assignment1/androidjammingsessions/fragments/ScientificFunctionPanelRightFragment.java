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
public class ScientificFunctionPanelRightFragment extends Fragment
{

    View rootView;
    Button[] funcPadKey=new Button[15];
    //


    String[] FUNC_KEY_MODIFIERS={"Pi","Permuation","Rand","Exponential","Combination","RCL","AnyRoot","FracToDec","ENG","AnyPower","TenPower","Rec","Angles2","Angle1","Pol"};
    //


    public float alpha=1f;
    public int rootViewWidth=-2;
    public int rootViewHeight=-2;
    //


    public int[] buttonColor= {0xFF4CAF50};
    public int textColor= 0xFFFFFFFF;
    String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";
    //


    ScientificFunctionPanelRightFragmentListener mCallback;
    //


    public interface ScientificFunctionPanelRightFragmentListener
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
            mCallback = (ScientificFunctionPanelRightFragmentListener) activity;

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

        rootView= inflater.inflate(R.layout.layout_fragment__scientific_function_panel_right, container, false);
        rootView.setAlpha(alpha);

        //


        LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);
        rootView.setLayoutParams(rootViewLayout);
        //











        for(int i=0;i<15;i++)
        {


            funcPadKey[i]= (Button)rootView.findViewById(getResources().getIdentifier("funcKey" + FUNC_KEY_MODIFIERS[i], "id", getActivity().getPackageName()));

            //


            funcPadKey[i].setBackgroundColor(buttonColor[0]);
            funcPadKey[i].setTextColor(textColor);
            funcPadKey[i].setTypeface(Typeface.createFromAsset(getActivity().getAssets(), STANDARD_FONT));
            //


            funcPadKey[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(),"Available in Pro Mode !!",Toast.LENGTH_SHORT).show();
                    //mCallback.buttonPressed(((Button)v).getText().toString());
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
        //






        return rootView;
        //
    }
    //

}
