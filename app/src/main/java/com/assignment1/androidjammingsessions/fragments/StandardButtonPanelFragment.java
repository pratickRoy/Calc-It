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
import android.widget.Toast;

import com.assignment1.androidjammingsessions.calculator.CalculatorUI;
import com.assignment1.androidjammingsessions.calculator.R;

/**
 * Created by ${Roy} on ${2050}.
 */
public class StandardButtonPanelFragment extends Fragment
{

        View rootView;
        Button[] numPadKey=new Button[12];
    //


        String[] NUM_KEY_MODIFIERS={"Dot","Braces"};
    //


        public float alpha=1f;
        public int rootViewWidth=-2;
        public int rootViewHeight=-2;
    //


        public int[] buttonColor= {0xFF03A9F4,0xFF039BE5,0xFF0288D1};
        public int textColor= 0xFFFFFFFF;
        String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";
    //


        standardButtonPanelFragmentListener mCallback;
    //


        public interface standardButtonPanelFragmentListener
        {
            public void buttonPressed(String buttonText);
            //public void sendOnFlingMessage(int FlingDirection);
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
                    mCallback = (standardButtonPanelFragmentListener) activity;

                }
                catch (ClassCastException e)
                {
                    throw new ClassCastException(activity.toString() + " must implement OnViewScreenSelectedListener");
                }
            //
        }

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {

                rootView= inflater.inflate(R.layout.layout_fragment__standard_button_panel, container, false);
                rootView.setAlpha(alpha);
            //


                LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);
                rootView.setLayoutParams(rootViewLayout);
            //

                int k=1;
                for(int i=0;i<12;i++)
                {


                        if(i<10)
                        {
                            numPadKey[i] = (Button)rootView.findViewById(getResources().getIdentifier("numKey" + i, "id", getActivity().getPackageName()));
                        }
                    //


                        else
                        {
                            numPadKey[i]= (Button)rootView.findViewById(getResources().getIdentifier("numKey" + NUM_KEY_MODIFIERS[i - 10], "id", getActivity().getPackageName()));
                        }
                    //


                        if(k%3==0 || i==1)
                            k=0;
                        else if(i==11)
                            k=2;
                        numPadKey[i].setBackgroundColor(buttonColor[k++]);
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
                        //setOnFling(numPadKey[i]);
                        //.setOnFlings(numPadKey[i]);
                    //
                }
            //
                //setOnFling(rootView);



                return rootView;
            //
        }
    //
/*

    public void setOnFling(View rootView)
    {
        final int FLING_TO_LEFT  =1;
        final int FLING_TO_RIGHT =2;
        final int FLING_TO_TOP   =3;
        final int FLING_TO_BOTTOM=4;

        final GestureDetector gesture = new GestureDetector(getActivity(),new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY)
            {

                //Toast.makeText(getActivity(), "gestures", Toast.LENGTH_LONG).show();

                final int SWIPE_MIN_DISTANCE = 120;
                final int SWIPE_MAX_OFF_PATH = 250;
                final int SWIPE_THRESHOLD_VELOCITY = 200;

                        */
/*Toast.makeText(getParent(), e2.getY()+" ", Toast.LENGTH_LONG).show();
                        Toast.makeText(getParent().getApplicationContext(), e1.getY()+" ", Toast.LENGTH_LONG).show();
                        Toast.makeText(getParent().getApplicationContext(), SWIPE_MIN_DISTANCE+" ", Toast.LENGTH_LONG).show();
                        Toast.makeText(getParent().getApplicationContext(), Math.abs(velocityY)+" ", Toast.LENGTH_LONG).show();
                        Toast.makeText(getParent().getApplicationContext(), SWIPE_THRESHOLD_VELOCITY+" ", Toast.LENGTH_LONG).show();
                        Toast.makeText(getParent().getApplicationContext(), e2.getY()+" "+e1.getY()+" "+SWIPE_MIN_DISTANCE+" "+Math.abs(velocityY)+" "+SWIPE_THRESHOLD_VELOCITY, Toast.LENGTH_LONG).show();
                        Toast.makeText(getParent().getApplicationContext(), (e2.getY()-e1.getY()-SWIPE_MIN_DISTANCE)+" "+(Math.abs(velocityY)-SWIPE_THRESHOLD_VELOCITY), Toast.LENGTH_LONG).show();*//*


                try
                {
                    if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    {
                        Toast.makeText(getActivity(), "fcuk", Toast.LENGTH_LONG).show();
                        //Toast.makeText(getActivity(), "gestures", Toast.LENGTH_LONG).show();
                        return false;
                    }
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                    {
                        //Toast.makeText(getActivity(), "gestures", Toast.LENGTH_LONG).show();
                        mCallback.sendOnFlingMessage(FLING_TO_LEFT);
                    }
                    else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                    {
                        //Toast.makeText(getActivity(), "gestures", Toast.LENGTH_LONG).show();
                        mCallback.sendOnFlingMessage(FLING_TO_RIGHT);
                    }
                    else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
                    {
                        //Toast.makeText(getActivity(), "gestures", Toast.LENGTH_LONG).show();
                        mCallback.sendOnFlingMessage(FLING_TO_TOP);
                    }
                    else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
                    {
                        //Toast.makeText(getActivity(), "gestures", Toast.LENGTH_LONG).show();
                        mCallback.sendOnFlingMessage(FLING_TO_BOTTOM);
                    }
                }
                catch (Exception e)
                {
                    // nothing
                }
                return super.onFling(e1, e2, velocityX, velocityY);

            }
        });

        rootView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return gesture.onTouchEvent(event);
            }
        });
    }
*/
}
