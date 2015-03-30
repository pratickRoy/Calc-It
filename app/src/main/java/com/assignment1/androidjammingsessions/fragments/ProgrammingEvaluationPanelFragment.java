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
import android.widget.Toast;

import com.assignment1.androidjammingsessions.calculator.R;

/**
 * Created by ${Roy} on ${2050}.
 */

public class ProgrammingEvaluationPanelFragment extends Fragment
{


        View rootView;
        Button[] evalPadKey=new Button[4];
    //



        public String[] EVAL_KEY_MODIFIERS={"Dot","Braces","Backspace","Evaluation"};
    //



        public float alpha=1f;
        public int rootViewWidth=-2;
        public int rootViewHeight=-2;
    //




        public int buttonColor= 0xFF3949AB;
        public int textColor= 0xFFFFFFFF;
        public String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";

    //



    ProgrammingEvaluationPanelListener mCallback;
    //


        public interface ProgrammingEvaluationPanelListener
        {
            public void buttonPressed(String buttonText);
            public void longButtonPressed(String buttonText);
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
                        mCallback = (ProgrammingEvaluationPanelListener) activity;

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


                rootView= inflater.inflate(R.layout.layout_fragment__programming_evaluation_panel, container, false);
                rootView.setAlpha(alpha);
            //


                LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);
                //rootViewLayout.weight=3f;
                rootView.setLayoutParams(rootViewLayout);
            //


                for(int i=0;i<4;i++)
                {

                    evalPadKey[i] =(Button)rootView.findViewById(getResources().getIdentifier("evalKey"+EVAL_KEY_MODIFIERS[i], "id", getActivity().getPackageName()));
                    //
                    //Toast.makeText(getActivity().getApplicationContext(), evalPadKey[i]+" ", Toast.LENGTH_LONG).show();
                    // To style the buttons dynamically

                        evalPadKey[i].setBackgroundColor(buttonColor);
                        evalPadKey[i].setTextColor(textColor);
                        evalPadKey[i].setTypeface(Typeface.createFromAsset(getActivity().getAssets(), STANDARD_FONT));
                    //


                        evalPadKey[i].setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                    mCallback.buttonPressed(((Button)v).getText().toString());
                            }
                        });
                    //

                    evalPadKey[i].setOnTouchListener(new View.OnTouchListener()
                    {
                        @Override
                        public boolean onTouch(View v, MotionEvent event)
                        {
                            mCallback.sendOnTouchMessage(v);
                            return false;
                        }
                    });

                    /**/
                }

                evalPadKey[2].setOnLongClickListener(new View.OnLongClickListener()
                {

                    @Override
                    public boolean onLongClick(View v)
                    {
                        mCallback.longButtonPressed(((Button)v).getText().toString());
                        return false;
                    }
                });



                    return rootView;
                //
            //
        }
    //


}
