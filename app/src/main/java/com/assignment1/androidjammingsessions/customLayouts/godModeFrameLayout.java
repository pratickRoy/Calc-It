package com.assignment1.androidjammingsessions.customLayouts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by ${Roy} on ${2050}.
 */
public class godModeFrameLayout extends FrameLayout
{

    public godModeFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public godModeFrameLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }
    public godModeFrameLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    public godModeFrameLayout(Context context)
    {
        super(context);
    }


    //
        public float getYFraction()
        {
            if (getHeight() == 0)
            {
                return 0;
            }
            return getTranslationY() / getHeight();
        }
        public void setYFraction(final float fraction)
        {
            float translationY = getHeight() * fraction;
            setTranslationY(translationY);
        }
    //


    //
        public float getXFraction()
        {
            if (getWidth() == 0)
            {
                return 0;
            }
            return getTranslationX() / getWidth();
        }
        public void setXFraction(final float fraction)
        {
            float translationX = getWidth() * fraction;
            setTranslationX(translationX);
        }
    //



}
