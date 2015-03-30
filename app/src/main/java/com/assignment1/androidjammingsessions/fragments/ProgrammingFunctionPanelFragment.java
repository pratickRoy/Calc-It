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
public class ProgrammingFunctionPanelFragment extends Fragment
{


        View rootView;
        Button[] funcPadKey=new Button[16];
    //




        String[] FUNC_KEY_MODIFIERS={"Add","Sub","Mul","Div","ToBin","ToDec","ToHex","ToOct","OnesComplement","TwosComplement","Decimal","Octal","BitwiseLeft","BitwiseRight","Binary","Hexadecimal"};
    //


        public float alpha=1f;
        public int rootViewWidth=-2;
        public int rootViewHeight=-2;
    //


        public int[] buttonColor= {0xFFFF8F00,0xFFFF6F00,0xFFFFA000,0xFFFFB300};
        public int textColor= 0xFFFFFFFF;
        String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";
    //


        ProgrammingFunctionPanelFragmentListener mCallback;
    //


        public interface ProgrammingFunctionPanelFragmentListener
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
                    mCallback = (ProgrammingFunctionPanelFragmentListener) activity;

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

            rootView= inflater.inflate(R.layout.layout_fragment__programming_function_panel, container, false);
            rootView.setAlpha(alpha);

        //


            LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);
            rootView.setLayoutParams(rootViewLayout);
        //












            for(int i=0;i<16;i++)
            {


                    funcPadKey[i]= (Button)rootView.findViewById(getResources().getIdentifier("funcKey" + FUNC_KEY_MODIFIERS[i], "id", getActivity().getPackageName()));
                    //Toast.makeText(getActivity().getApplicationContext(),funcPadKey[i]+"" , Toast.LENGTH_LONG).show();
                //

                        if(i<4)
                            funcPadKey[i].setBackgroundColor(buttonColor[0]);
                        else if(i<8)
                            funcPadKey[i].setBackgroundColor(buttonColor[1]);
                        else if(i<10)
                            funcPadKey[i].setBackgroundColor(buttonColor[2]);
                        else if(i<12)
                            funcPadKey[i].setBackgroundColor(buttonColor[3]);
                        else if(i<14)
                            funcPadKey[i].setBackgroundColor(buttonColor[2]);
                        else if(i<16)
                            funcPadKey[i].setBackgroundColor(buttonColor[3]);

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
        //






            return rootView;
        //
    }
    //


}

