package com.assignment1.androidjammingsessions.fragments;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.assignment1.androidjammingsessions.calculator.R;

/**
 * Created by ${Roy} on ${2050}.
 */
public class ScientificFunctionPanelFragmentMinimized extends Fragment
{
/*

        View rootView;

    //


        public float alpha=1f;
        public int backgroundColor=0xFF4CAF50;
        public int rootViewWidth=-2;
        public int rootViewHeight=-2;

    //


        ScientificFunctionPanelFragmentMinimizedListener mCallback;

    //


        public interface ScientificFunctionPanelFragmentMinimizedListener
        {
            public void ToRightDrag();
            public void ToLeftDrag();
            public void ToTopDrag();
            //public void sendEditTextCursorPosition(int position);
        }
    //

    @Override
    public void onAttach(Activity activity)
    {

        super.onAttach(activity);
        //


        try
        {
            mCallback = (ScientificFunctionPanelFragmentMinimizedListener) activity;

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

            rootView= inflater.inflate(R.layout.layout_fragment__minimized_function_cards, container, false);
            rootView.setAlpha(alpha);
            rootView.setBackgroundColor(backgroundColor);
            rootView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    //mCallback.ToRightDrag();
                }
            });


        final GestureDetector gesture = new GestureDetector(getActivity(),new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY)
            {
                final int SWIPE_MIN_DISTANCE = 120;
                final int SWIPE_MAX_OFF_PATH = 250;
                final int SWIPE_THRESHOLD_VELOCITY = 200;
                mCallback.ToTopDrag();
                try
                {
                    if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                        return false;
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "r2l", Toast.LENGTH_LONG).show();
                        mCallback.ToLeftDrag();
                    }
                    else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "l2r", Toast.LENGTH_LONG).show();
                        mCallback.ToRightDrag();

                    }
                    else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "b2t", Toast.LENGTH_LONG).show();
                        mCallback.ToTopDrag();
                    }
                    else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "b2t", Toast.LENGTH_LONG).show();

                    }
                } catch (Exception e)
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

        LinearLayout.LayoutParams rootViewLayout=new LinearLayout.LayoutParams(rootViewWidth, rootViewHeight);
        //rootViewLayout.weight=2f;
        rootView.setLayoutParams(rootViewLayout);


            return rootView;
        //
    }


    //*/
}
