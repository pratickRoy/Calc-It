package com.assignment1.androidjammingsessions.fragments;

import com.assignment1.androidjammingsessions.calculator.*;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

public class ViewScreenFragment extends Fragment
{

        View rootView;
        EditText viewScreen;
    //


        public int rootViewColor= 0xFFFFFFFF;
        public float alpha=1f;
        public int rootViewWidth=-2;
        public int rootViewHeight=-2;
    //


        public int textFieldColor= 0xFFFFFFFF;
        public int textColor= 0xFF000000;
        public String STANDARD_FONT="font/RobotoCondensed-BoldItalic.ttf";

    //


        ViewScreenTextMaster mCallback;
    //


        public interface ViewScreenTextMaster
        {
            public void sendEditTextData(String editTextData);
            public void sendEditTextCursorPosition(int position);
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
                        mCallback = (ViewScreenTextMaster) activity;

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


                rootView= inflater.inflate(R.layout.layout_fragment__view_screen, container, false);
                rootView.setBackgroundColor(rootViewColor);
                rootView.setAlpha(alpha);
            //


                LayoutParams rootViewLayout=new LayoutParams(rootViewWidth, rootViewHeight);
                rootView.setLayoutParams(rootViewLayout);
            //


                viewScreen = (EditText)rootView.findViewById(R.id.editText);
            //


                viewScreen.setBackgroundColor(textFieldColor);
                viewScreen.setTextColor(textColor);
                viewScreen.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), STANDARD_FONT));
            //


                viewScreen.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        ((InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(viewScreen.getWindowToken(), 0);
                    }
                });
            //

            viewScreen.setOnTouchListener(new View.OnTouchListener()
            {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    mCallback.sendOnTouchMessage(v);
                    return false;
                }
            });

            return rootView;
        }
    //

    //

        public void getEditTextData()
        {
            mCallback.sendEditTextData(viewScreen.getText().toString());
        }
        public void getEditTextCursorPosition()
        {
            mCallback.sendEditTextCursorPosition(viewScreen.getSelectionStart());
        }
        public void updateEditTextData(String newEditTextData)
        {
            viewScreen.getText().insert(viewScreen.getSelectionStart(), newEditTextData);
        }
        public void updateTextCursorPosition(int position)
        {
                        viewScreen.setSelection(position);
        }
        public void setEditTextData(String newEditTextData)
        {
            viewScreen.setText(newEditTextData);
        }





}