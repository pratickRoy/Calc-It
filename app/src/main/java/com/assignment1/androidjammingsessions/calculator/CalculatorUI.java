package com.assignment1.androidjammingsessions.calculator;

import com.assignment1.androidjammingsessions.fragments.*;

import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;

public class CalculatorUI extends ActionBarActivity implements

        ViewScreenFragment.ViewScreenTextMaster,
        StandardButtonPanelFragment.standardButtonPanelFragmentListener,
        StandardFunctionPanelFragment.standardFunctionPanelFragmentListener,
        StandardEvaluationPanelFragment.standardEvaluationPanelFragmentListener,
        ActionBarFragment.actionBarFragmentListener,
        ScientificFunctionPanelLeftFragment.ScientificFunctionPanelLeftFragmentListener,
        ScientificFunctionPanelRightFragment.ScientificFunctionPanelRightFragmentListener,
        ProgrammingNumberPanelFragment0to4.ProgrammingNumberPanelFragment0to4Listener,
        ProgrammingNumberPanelFragment5to9.ProgrammingNumberPanelFragment5to9Listener,
        ProgrammingNumberPanelFragmentAtoF.ProgrammingNumberPanelFragmentAtoFListener,
        ProgrammingEvaluationPanelFragment.ProgrammingEvaluationPanelListener,
        SettingsPanelMainSettingsCard.settingsPanelMainSettingsCardListener,
        ProgrammingFunctionPanelFragment.ProgrammingFunctionPanelFragmentListener

{
    ShadowFragment[] shadowFragment;
    ActionBarFragment  actionBarFragment;
    ViewScreenFragment viewScreenFragment;
    StandardButtonPanelFragment standardButtonPanelFragment;
    StandardFunctionPanelFragment standardFunctionPanelFragment;
    StandardEvaluationPanelFragment standardEvaluationPanelFragment;
    ScientificFunctionPanelLeftFragment scientificFunctionPanelLeftFragment;
    ScientificFunctionPanelRightFragment scientificFunctionPanelRightFragment;
    SettingsPanelPersonalizationFragment[] settingsPanelPersonalizationFragments;
    ProgrammingNumberPanelFragment0to4 programmingNumberPanelFragment0to4;
    ProgrammingNumberPanelFragment5to9 programmingNumberPanelFragment5to9;
    ProgrammingNumberPanelFragmentAtoF programmingNumberPanelFragmentAtoF;
    ProgrammingEvaluationPanelFragment programmingEvaluationPanelFragment;
    ProgrammingFunctionPanelFragment programmingFunctionPanelFragment;
    SettingsPanelMainSettingsCard settingsPanelMainSettingsCard;


    

        int c=0;
        boolean flag=true;
        MotionEvent initialEvent;
        int shadowFragmentIndex;
        int scientificFunctionPanelFragmentMinimizedIndex;
        int activeUI;
        String mainComponentText;
        int mainComponentCursorPosition;
        DisplayMetrics metrics = new DisplayMetrics();
   
        final String[] OPERATORS={"()!^/*+-","!","^/*+-","()"};

        final int FLING_TO_LEFT  =1;
        final int FLING_TO_RIGHT =2;
        final int FLING_TO_TOP   =3;
        final int FLING_TO_BOTTOM=4;

        final int STANDARD_UI=1;
        final int SCIENTIFIC_UI=2;
        final int PROGRAMMING_UI=3;
        final int DUMMY=-1;
   


    /*@Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }*/
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            //stdUI();
            //savedInstanceState.clear();
            //if(activeUI!=STANDARD_UI)
            //{
                //Toast.makeText(this,"yo",Toast.LENGTH_LONG).show();;
                standardUI();
            //}


            //super.getApplication().
            //super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            /*if(super.getRequestedOrientation()==ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
            {


                clean();
                switch (activeUI)
                {
                    case STANDARD_UI: {
                        standardUI();

                        break;
                    }
                    case SCIENTIFIC_UI: {
                        scientificUI();
                        break;
                    }
                    case PROGRAMMING_UI: {
                        ProgrammingUI();
                        break;
                    }
                }


            }*/

            //onConfigurationChanged();
        }


            //ProgrammingUI();
            //scientificUI();
            //getWindowManager().getDefaultDisplay().getMetrics(metrics);
            //metrics.heightPixels-=getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android"))/2;

            //settingsPanel();


        private void scientificUI()
        {
            activeUI=SCIENTIFIC_UI;

            double weightHeight[]={1,0.1,3,0.1,1,4};
            double totalHeight=0;

            double weightWidth[]={3,1};
            double totalWidth=0;

            for(int i=0;i<weightHeight.length;i++)
            {
                totalHeight+=weightHeight[i];
            }

            for(int i=0;i<weightWidth.length;i++)
            {
                totalWidth+=weightWidth[i];
            }


            
            shadowFragment=new ShadowFragment[7];
            

            setContentView(R.layout.layout_canvas__scientific_ui);

            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            metrics.heightPixels-=getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android"))/2;


            //findViewById(R.id.scientificUI).setBackgroundColor(Color.BLUE);
            //setOnFling(findViewById(R.id.scientificUI));

            //((LinearLayout)findViewById(R.id.scientificUI)).onInterceptTouchEvent(new MotionEvent());



            //

            //Toast.makeText(getApplicationContext(),(getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android")))+"", Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),(getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android")))+"", Toast.LENGTH_LONG).show();

            

            //if (actionBarFragment==null)
            {
                actionBarFragment=new ActionBarFragment();
                actionBarFragment.rootViewWidth=-1;
                actionBarFragment.rootViewHeight=(int)(metrics.heightPixels*(weightHeight[0]/totalHeight));
                //Toast.makeText(getApplicationContext(),actionBarFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                actionBarFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, DUMMY).add(R.id.LinearUIVerticalL1N1Z1,actionBarFragment).addToBackStack(null).commit();
            }
            //

          
            shadowFragmentIndex=0;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[1]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y2=shadowFragment[shadowFragmentIndex].rootViewHeight;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, DUMMY).add(R.id.LinearUIVerticalL1N1Z1, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //


            //if (viewScreenFragment==null)
            {
                viewScreenFragment=new ViewScreenFragment();
                viewScreenFragment.rootViewWidth=-1;
                viewScreenFragment.rootViewHeight=(int)(metrics.heightPixels*((weightHeight[2]/totalHeight)));
                //Toast.makeText(getApplicationContext(),viewScreenFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                viewScreenFragment.alpha=0f;
                viewScreenFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, DUMMY).add(R.id.LinearUIVerticalL1N1Z1,viewScreenFragment).commit();
            }

            //

            

            shadowFragmentIndex=1;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[3]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y1=shadowFragment[shadowFragmentIndex].rootViewHeight;
                //shadowFragment[shadowFragmentIndex].backgroundColorStart=0x00FFFFFF;
                //shadowFragment[shadowFragmentIndex].backgroundColorEnd=0xFF000000;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, DUMMY).add(R.id.LinearUIVerticalL1N1Z1, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //

            

            //if (standardFunctionPanelFragment==null)
            {

                standardFunctionPanelFragment=new StandardFunctionPanelFragment();
                standardFunctionPanelFragment.rootViewWidth=-1;
                standardFunctionPanelFragment.rootViewHeight=(int)(metrics.heightPixels*((weightHeight[4]/totalHeight)));
                //Toast.makeText(getApplicationContext(),standardFunctionPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                //+viewScreenFragment.getView().getHeight()+(2*shadowFragment[0].getView().getHeight());
                standardFunctionPanelFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIVerticalL1N2Z1,standardFunctionPanelFragment).commit();
            }

            //

            

            //if (standardButtonPanelFragment==null)
            {

                standardButtonPanelFragment=new StandardButtonPanelFragment();
                standardButtonPanelFragment.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[0]/totalWidth));
                standardButtonPanelFragment.rootViewHeight=(int)(Math.ceil(metrics.heightPixels*((weightHeight[5]/totalHeight))));
                //Toast.makeText(getApplicationContext(),standardButtonPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                standardButtonPanelFragment.buttonColor=new int[]{0xFF00BCD4, 0xFF00ACC1, 0xFF0097A7};
                standardButtonPanelFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z1,standardButtonPanelFragment).commit();
            }

            //

            

            //if (standardEvaluationPanelFragment==null)
            {

                standardEvaluationPanelFragment=new StandardEvaluationPanelFragment();
                standardEvaluationPanelFragment.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[1]/totalWidth));
                standardEvaluationPanelFragment.rootViewHeight=(int)(Math.ceil(metrics.heightPixels*((weightHeight[5]/totalHeight))));
                //Toast.makeText(getApplicationContext(),standardEvaluationPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                standardEvaluationPanelFragment.buttonColor=0xFF00838F;
                standardEvaluationPanelFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z1,standardEvaluationPanelFragment).commit();
            }

            shadowFragmentIndex=2;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(((weightHeight[5]+weightHeight[4])/totalHeight)));
                shadowFragment[shadowFragmentIndex].rootViewWidth=(int)(metrics.heightPixels*(weightHeight[1]/totalHeight));
                shadowFragment[shadowFragmentIndex].x2=shadowFragment[shadowFragmentIndex].rootViewWidth;
                shadowFragment[shadowFragmentIndex].backgroundColorStart=0xFF4CAF50;
                shadowFragment[shadowFragmentIndex].y2=0;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalL2N1Z2, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            shadowFragmentIndex=3;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(((weightHeight[5]+weightHeight[4])/totalHeight)));
                shadowFragment[shadowFragmentIndex].rootViewWidth=(int)(metrics.heightPixels*(weightHeight[1]/totalHeight));
                shadowFragment[shadowFragmentIndex].x1=shadowFragment[shadowFragmentIndex].rootViewWidth;
                shadowFragment[shadowFragmentIndex].backgroundColorStart=0xFF4CAF50;
                shadowFragment[shadowFragmentIndex].y1=0;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalL2N1Z3, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }





            //findViewById(android.R.id.content).

            //setOnFling(findViewById(android.R.id.content));

            /*setOnFling(actionBarFragment.getView());
            setOnFling(shadowFragment[0].getView());

            setOnFling(shadowFragment[1].getView());
            setOnFling(standardFunctionPanelFragment.getView());
            setOnFling(standardButtonPanelFragment.getView());
            setOnFling(standardEvaluationPanelFragment.getView());*/

            //

            

            /*scientificFunctionPanelFragmentMinimizedIndex=0;
            //if (scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex] ==null)
            {
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex] =new ScientificFunctionPanelFragmentMinimized();
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].setArguments(getIntent().getExtras());
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].rootViewWidth=(int)(((metrics.widthPixels*(weightWidth[0]/totalWidth))/3)/5);
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].rootViewHeight=(int)(metrics.heightPixels*(((weightHeight[5]+weightHeight[4])/totalHeight)));
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].alpha=0f;
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).add(R.id.LinearUIHorizontalLevel2Upper, scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex]).commit();
            }

            //


            shadowFragmentIndex=2;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(((weightHeight[5]+weightHeight[4])/totalHeight)));
                shadowFragment[shadowFragmentIndex].rootViewWidth=(int)(metrics.heightPixels*(weightHeight[1]/totalHeight));
                shadowFragment[shadowFragmentIndex].x2=shadowFragment[shadowFragmentIndex].rootViewWidth;
                shadowFragment[shadowFragmentIndex].y2=0;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalLevel2Upper, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //


            shadowFragmentIndex=3;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(((weightHeight[5]+weightHeight[4])/totalHeight)));
                shadowFragment[shadowFragmentIndex].rootViewWidth=(int)(metrics.heightPixels*(weightHeight[1]/totalHeight));
                shadowFragment[shadowFragmentIndex].x1=shadowFragment[shadowFragmentIndex].rootViewWidth;
                shadowFragment[shadowFragmentIndex].y1=0;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalLevel2UpperRight, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //


            scientificFunctionPanelFragmentMinimizedIndex=1;
            //if (scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex] ==null)
            {
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex] =new ScientificFunctionPanelFragmentMinimized();
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].setArguments(getIntent().getExtras());
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].rootViewWidth=(int)((metrics.widthPixels*(weightWidth[1]/totalWidth))/5);
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].rootViewHeight=(int)(metrics.heightPixels*(((weightHeight[5]+weightHeight[4])/totalHeight)));
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].alpha=0f;
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).add(R.id.LinearUIHorizontalLevel2UpperRight, scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex]).commit();
            }

            //


            shadowFragmentIndex=4;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[3]/totalHeight));
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].x1=0;
                shadowFragment[shadowFragmentIndex].y1=shadowFragment[shadowFragmentIndex].rootViewHeight;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalLevel3UpperBottom, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //


            scientificFunctionPanelFragmentMinimizedIndex=2;
            //if (scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex] ==null)
            {
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex] =new ScientificFunctionPanelFragmentMinimized();
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].setArguments(getIntent().getExtras());
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].rootViewHeight=(int)(((metrics.heightPixels*(weightHeight[5]/totalHeight))/3)/5);
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].rootViewWidth=-1;
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].alpha=0f;
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).add(R.id.LinearUIHorizontalLevel3UpperBottom, scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex]).commit();
            }*/

        //
    }

        private void settingsPanel()
        {
            activeUI*=10;

            double weightHeight[]={2,0.1,7,0.1,1};
            double totalHeight=0;

            double weightWidth[]={3,1,0.1};
            double totalWidth=0;

            for(int i=0;i<weightHeight.length;i++)
            {
                totalHeight+=weightHeight[i];
            }

            for(int i=0;i<weightWidth.length;i++)
            {
                totalWidth+=weightWidth[i];
            }


            //scientificFunctionPanelFragmentMinimized=new ScientificFunctionPanelFragmentMinimized[3];
            //shadowFragment=new ShadowFragment[3];
            settingsPanelPersonalizationFragments=new SettingsPanelPersonalizationFragment[2];
            

            //setContentView(R.layout.layout_canvas__standard_ui);

            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            metrics.heightPixels-=getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android"))/2;


            //findViewById(R.id.scientificUI).setBackgroundColor(Color.BLUE);
            //setOnFling(findViewById(R.id.scientificUI));

            //((LinearLayout)findViewById(R.id.scientificUI)).onInterceptTouchEvent(new MotionEvent());



            //

            //Toast.makeText(getApplicationContext(),(getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android")))+"", Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),(getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android")))+"", Toast.LENGTH_LONG).show();

            
            {
                settingsPanelPersonalizationFragments[0]=new SettingsPanelPersonalizationFragment();
                settingsPanelPersonalizationFragments[0].rootViewWidth=(int)(metrics.widthPixels*(weightWidth[0]/totalWidth));
                settingsPanelPersonalizationFragments[0].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[0]/totalHeight));
                settingsPanelPersonalizationFragments[0].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.settingsPanelLeft,settingsPanelPersonalizationFragments[0]).commit();
            }

            shadowFragmentIndex++;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=(int)(metrics.widthPixels*(weightWidth[0]/totalWidth));
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[1]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y2=shadowFragment[shadowFragmentIndex].rootViewHeight;
                shadowFragment[shadowFragmentIndex].backgroundColorEnd=0xFFE3E3E3;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, DUMMY).add(R.id.settingsPanelLeft, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }


            //if (standardEvaluationPanelFragment==null)
            {
                settingsPanelMainSettingsCard=new SettingsPanelMainSettingsCard();
                settingsPanelMainSettingsCard.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[0]/totalWidth));
                settingsPanelMainSettingsCard.rootViewHeight=(int)(metrics.heightPixels*(weightHeight[2]/totalHeight));
                settingsPanelMainSettingsCard.rootViewBackgroundColor=0xFFE3E3E3;
                settingsPanelMainSettingsCard.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.settingsPanelLeft,settingsPanelMainSettingsCard).commit();
            }

            shadowFragmentIndex++;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=(int)(metrics.widthPixels*(weightWidth[0]/totalWidth));
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[3]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y1=shadowFragment[shadowFragmentIndex].rootViewHeight;
                //shadowFragment[shadowFragmentIndex].backgroundColorStart=0x00FFFFFF;
                shadowFragment[shadowFragmentIndex].backgroundColorEnd=0xFFE3E3E3;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, DUMMY).add(R.id.settingsPanelLeft, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }

            {
                settingsPanelPersonalizationFragments[1]=new SettingsPanelPersonalizationFragment();
                settingsPanelPersonalizationFragments[1].rootViewWidth=(int)(metrics.widthPixels*(weightWidth[0]/totalWidth));
                settingsPanelPersonalizationFragments[1].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[4]/totalHeight));
                settingsPanelPersonalizationFragments[1].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.settingsPanelLeft,settingsPanelPersonalizationFragments[1]).commit();
            }

            shadowFragmentIndex++;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=(int)(metrics.widthPixels*(weightWidth[2]/totalWidth));
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels);

                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].x2=shadowFragment[shadowFragmentIndex].rootViewWidth;
                //shadowFragment[shadowFragmentIndex].backgroundColorStart=0x00FFFFFF;
                //shadowFragment[shadowFragmentIndex].backgroundColorEnd=0xFF000000;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, DUMMY).add(R.id.settingsPanelRight, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }

            //
        }

       /* public void setOnFling(View rootView)
        {
            final GestureDetector gesture = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener()
            {
                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY)
                {

                    Toast.makeText(getParent(), "gestures", Toast.LENGTH_LONG).show();

                    final int SWIPE_MIN_DISTANCE = 120;
                    final int SWIPE_MAX_OFF_PATH = 250;
                    final int SWIPE_THRESHOLD_VELOCITY = 200;

                    *//*Toast.makeText(getParent(), e2.getY()+" ", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(getParent(), "gestures", Toast.LENGTH_LONG).show();
                            return false;
                        }
                        if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                        {
                            Toast.makeText(getParent(), "gestures", Toast.LENGTH_LONG).show();
                            ToLeftDrag();
                        }
                        else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                        {
                            Toast.makeText(getParent(), "gestures", Toast.LENGTH_LONG).show();
                            ToRightDrag();
                        }
                        else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
                        {
                            Toast.makeText(getParent(), "gestures", Toast.LENGTH_LONG).show();
                            ToTopDrag();
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
        }*/



        public void standardUI()
        {
            activeUI=STANDARD_UI;

            double weightHeight[]={1,0.1,3,0.1,1,4};
            double totalHeight=0;

            double weightWidth[]={3,1};
            double totalWidth=0;

            for(int i=0;i<weightHeight.length;i++)
            {
                totalHeight+=weightHeight[i];
            }

            for(int i=0;i<weightWidth.length;i++)
            {
                totalWidth+=weightWidth[i];
            }


            shadowFragment=new ShadowFragment[5];


            setContentView(R.layout.layout_canvas__standard_ui);
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            metrics.heightPixels-=getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android"))/2;
            //

            //Toast.makeText(getApplicationContext(),(getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android")))+"", Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),(getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android")))+"", Toast.LENGTH_LONG).show();

            

            //if (actionBarFragment==null)
            {
                actionBarFragment=new ActionBarFragment();
                actionBarFragment.rootViewWidth=-1;
                actionBarFragment.rootViewHeight=(int)(metrics.heightPixels*(weightHeight[0]/totalHeight));
                //Toast.makeText(getApplicationContext(),actionBarFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                actionBarFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1,actionBarFragment).addToBackStack(null).commit();
            }
            //



            shadowFragmentIndex=0;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[1]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y2=shadowFragment[shadowFragmentIndex].rootViewHeight;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //



            //if (viewScreenFragment==null)
            {
                viewScreenFragment=new ViewScreenFragment();
                viewScreenFragment.rootViewWidth=-1;
                viewScreenFragment.rootViewHeight=(int)(metrics.heightPixels*((weightHeight[2]/totalHeight)));
                //Toast.makeText(getApplicationContext(),viewScreenFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                viewScreenFragment.alpha=0f;
                viewScreenFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1,viewScreenFragment).commit();
            }

            //



            shadowFragmentIndex=1;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[3]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y1=shadowFragment[shadowFragmentIndex].rootViewHeight;
                //shadowFragment[shadowFragmentIndex].backgroundColorStart=0x00FFFFFF;
                //shadowFragment[shadowFragmentIndex].backgroundColorEnd=0xFF000000;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //



            //if (standardFunctionPanelFragment==null)
            {

                standardFunctionPanelFragment=new StandardFunctionPanelFragment();
                standardFunctionPanelFragment.rootViewWidth=-1;
                standardFunctionPanelFragment.rootViewHeight=(int)(metrics.heightPixels*((weightHeight[4]/totalHeight)));
                //standardFunctionPanelFragment.minimumHeight=(int)(metrics.heightPixels*((weightHeight[0]+weightHeight[1]+weightHeight[2]+weightHeight[3]+weightHeight[4])/totalHeight));
                //Toast.makeText(getApplicationContext(),standardFunctionPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                //+viewScreenFragment.getView().getHeight()+(2*shadowFragment[0].getView().getHeight());
                standardFunctionPanelFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1,standardFunctionPanelFragment).commit();
            }

            //



            //if (standardButtonPanelFragment==null)
            {

                standardButtonPanelFragment=new StandardButtonPanelFragment();
                standardButtonPanelFragment.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[0]/totalWidth));
                standardButtonPanelFragment.rootViewHeight=(int)(Math.ceil(metrics.heightPixels*((weightHeight[5]/totalHeight))));
                //Toast.makeText(getApplicationContext(),standardButtonPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                standardButtonPanelFragment.buttonColor=new int[]{0xFF00BCD4, 0xFF00ACC1, 0xFF0097A7};
                standardButtonPanelFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalL1N1Z1,standardButtonPanelFragment).commit();
            }

            //



            //if (standardEvaluationPanelFragment==null)
            {

                standardEvaluationPanelFragment=new StandardEvaluationPanelFragment();
                standardEvaluationPanelFragment.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[1]/totalWidth));
                standardEvaluationPanelFragment.rootViewHeight=(int)(Math.ceil(metrics.heightPixels*((weightHeight[5]/totalHeight))));
                //Toast.makeText(getApplicationContext(),standardEvaluationPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                standardEvaluationPanelFragment.buttonColor=0xFF00838F;
                standardEvaluationPanelFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalL1N1Z1,standardEvaluationPanelFragment).commit();
            }

            //


        }

    //



        private void ProgrammingUI()
        {
            activeUI=PROGRAMMING_UI;

            double weightHeight[]={1,0.1,3,0.1,5};
            double totalHeight=0;

            double weightWidth[]={1,1,2};
            double totalWidth=0;

            for(int i=0;i<weightHeight.length;i++)
            {
                totalHeight+=weightHeight[i];
            }

            for(int i=0;i<weightWidth.length;i++)
            {
                totalWidth+=weightWidth[i];
            }


            //scientificFunctionPanelFragmentMinimized=new ScientificFunctionPanelFragmentMinimized[1];
            shadowFragment=new ShadowFragment[6];
            //  Adding the XML file for Standard interface

            setContentView(R.layout.layout_canvas__programming_ui);
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            metrics.heightPixels-=getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android"))/2;
            //

            //Toast.makeText(getApplicationContext(),(getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android")))+"", Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),(getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android")))+"", Toast.LENGTH_LONG).show();

            

            //if (actionBarFragment==null)
            {
                actionBarFragment=new ActionBarFragment();
                actionBarFragment.rootViewWidth=-1;
                actionBarFragment.rootViewHeight=(int)(metrics.heightPixels*(weightHeight[0]/totalHeight));
                //Toast.makeText(getApplicationContext(),actionBarFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                actionBarFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1,actionBarFragment).addToBackStack(null).commit();
            }
            //



            shadowFragmentIndex=0;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[1]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y2=shadowFragment[shadowFragmentIndex].rootViewHeight;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //



            //if (viewScreenFragment==null)
            {
                viewScreenFragment=new ViewScreenFragment();
                viewScreenFragment.rootViewWidth=-1;
                viewScreenFragment.rootViewHeight=(int)(metrics.heightPixels*((weightHeight[2]/totalHeight)));
                //Toast.makeText(getApplicationContext(),viewScreenFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                viewScreenFragment.alpha=0f;
                viewScreenFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1,viewScreenFragment).commit();
            }

            //



            shadowFragmentIndex=1;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[3]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y1=shadowFragment[shadowFragmentIndex].rootViewHeight;
                //shadowFragment[shadowFragmentIndex].backgroundColorStart=0x00FFFFFF;
                //shadowFragment[shadowFragmentIndex].backgroundColorEnd=0xFF000000;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL1N1Z1, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //





            //if (standardButtonPanelFragment==null)
            {

                programmingNumberPanelFragment0to4=new ProgrammingNumberPanelFragment0to4();
                programmingNumberPanelFragment0to4.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[0]/totalWidth));
                programmingNumberPanelFragment0to4.rootViewHeight=(int)(Math.ceil(metrics.heightPixels*((weightHeight[4]/totalHeight))));
                //Toast.makeText(getApplicationContext(),standardButtonPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                programmingNumberPanelFragment0to4.buttonColor=0xFF283593;
                programmingNumberPanelFragment0to4.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalL1N1Z1,programmingNumberPanelFragment0to4).commit();
            }

            //if (standardButtonPanelFragment==null)
            {

                programmingNumberPanelFragment5to9=new ProgrammingNumberPanelFragment5to9();
                programmingNumberPanelFragment5to9.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[1]/totalWidth));
                programmingNumberPanelFragment5to9.rootViewHeight=(int)(Math.ceil(metrics.heightPixels*((weightHeight[4]/totalHeight))));
                //Toast.makeText(getApplicationContext(),standardButtonPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                programmingNumberPanelFragment5to9.buttonColor=0xFF303F9F;
                programmingNumberPanelFragment5to9.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalL1N1Z1,programmingNumberPanelFragment5to9).commit();
            }


            //if (standardButtonPanelFragment==null)
            {

                programmingNumberPanelFragmentAtoF=new ProgrammingNumberPanelFragmentAtoF();
                programmingNumberPanelFragmentAtoF.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[2]/totalWidth));
                programmingNumberPanelFragmentAtoF.rootViewHeight=(int)((metrics.heightPixels*((weightHeight[4]/totalHeight)))*(3d/5d));
                //Toast.makeText(getApplicationContext(),standardButtonPanelFragment.rootViewHeight+"", Toast.LENGTH_LONG).show();
                programmingNumberPanelFragmentAtoF.buttonColor=0xFF3F51B5;
                programmingNumberPanelFragmentAtoF.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL2N1Z1,programmingNumberPanelFragmentAtoF).commit();
            }

            //if (standardButtonPanelFragment==null)
            {

                programmingEvaluationPanelFragment=new ProgrammingEvaluationPanelFragment();
                programmingEvaluationPanelFragment.rootViewWidth=(int)(metrics.widthPixels*(weightWidth[2]/totalWidth));
                programmingEvaluationPanelFragment.rootViewHeight=(int)(Math.ceil((metrics.heightPixels*((weightHeight[4]/totalHeight)))*(2d/5d)));
                //Toast.makeText(getApplicationContext(),(int)((metrics.heightPixels*((weightHeight[4]/totalHeight))))+"", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),((int)((metrics.heightPixels*((weightHeight[4]/totalHeight)))*(2d/5d))+(int)((metrics.heightPixels*((weightHeight[4]/totalHeight)))*(3d/5d)))+"", Toast.LENGTH_LONG).show();
                programmingEvaluationPanelFragment.buttonColor=0xFF3949AB;
                programmingEvaluationPanelFragment.setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL2N1Z1,programmingEvaluationPanelFragment).commit();
            }

            /*shadowFragmentIndex=2;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[3]/totalHeight));
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].x1=0;
                shadowFragment[shadowFragmentIndex].y1=shadowFragment[shadowFragmentIndex].rootViewHeight;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL2N1Z2, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
            //


            scientificFunctionPanelFragmentMinimizedIndex=0;
            //if (scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex] ==null)
            {
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex] =new ScientificFunctionPanelFragmentMinimized();
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].setArguments(getIntent().getExtras());
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].rootViewHeight=(int)(((metrics.heightPixels*(weightHeight[4]/totalHeight))/3)/5);
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].rootViewWidth=-1;
                scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex].alpha=0f;
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).add(R.id.LinearUIVerticalL2N1Z2, scientificFunctionPanelFragmentMinimized[scientificFunctionPanelFragmentMinimizedIndex]).commit();
            }*/

            shadowFragmentIndex=2;
            //if (shadowFragment[shadowFragmentIndex]==null)
            {
                shadowFragment[shadowFragmentIndex]=new ShadowFragment();
                shadowFragment[shadowFragmentIndex].alpha=0f;
                shadowFragment[shadowFragmentIndex].rootViewWidth=-1;
                shadowFragment[shadowFragmentIndex].rootViewHeight=(int)(metrics.heightPixels*(weightHeight[3]/totalHeight));
                //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                shadowFragment[shadowFragmentIndex].y1=shadowFragment[shadowFragmentIndex].rootViewHeight;
                shadowFragment[shadowFragmentIndex].backgroundColorStart=0xFFFF8F00;
                //shadowFragment[shadowFragmentIndex].backgroundColorStart=0x00FFFFFF;
                //shadowFragment[shadowFragmentIndex].backgroundColorEnd=0xFF000000;
                shadowFragment[shadowFragmentIndex].setArguments(getIntent().getExtras());
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIVerticalL2N1Z2, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
            }
        //
    }
    //







        @Override
        public void sendEditTextData(String editTextData)
        {
            mainComponentText=editTextData;
        }
        @Override
        public void sendEditTextCursorPosition(int position)
        {
            mainComponentCursorPosition=position;
        }

    @Override
    public void sendOnTouchMessage(final View rootView)
    {
        final ArrayList X=new ArrayList();
        final ArrayList Y=new ArrayList();

        rootView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                switch (event.getAction())
                {

                    case MotionEvent.ACTION_DOWN:
                    {
                        //X.add(event.getX());
                        //Y.add(event.getY());
                        //Toast.makeText(getApplication(), event.getX()+" DOWN "+event.getY(), Toast.LENGTH_SHORT).show();
                        break;
                    }


                    case MotionEvent.ACTION_MOVE:
                    {
                        X.add(event.getX());
                        Y.add(event.getY());
                        //User is moving around on the screen
                        break;
                    }

                    case MotionEvent.ACTION_UP:
                    {
                        if(X.size()!=0)
                        {
                            touchInterpreter(Float.parseFloat(X.get(0).toString()), (Float.parseFloat(X.get(X.size() - 1).toString())), (Float.parseFloat(Y.get(0).toString())), (Float.parseFloat(Y.get(Y.size() - 1).toString())));
                            X.clear();
                            Y.clear();
                            //Toast.makeText(getApplication(), X+" UP "+Y, Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            return false;
                        }

                    }
                    //case MotionEvent.
                }


                //Toast.makeText(getApplication(), "touched", Toast.LENGTH_SHORT).show();
                //if(X.size()<2)// && flag==true)
                //{

                    //Toast.makeText(getApplication(), X+" "+Y, Toast.LENGTH_SHORT).show();
                //}
                //else if(X.size()==2)
                //{
                    //touchInterpreter(Float.parseFloat(X.get(0).toString()),(Float.parseFloat(X.get(X.size()-1).toString())),(Float.parseFloat(Y.get(0).toString())),(Float.parseFloat(Y.get(Y.size()-1).toString())));

                    //X.remove(1);
                    //X.remove(0);

                    //Y.remove(1);
                    //Y.remove(0);

                    //flag=fal;
                //}
                //flag=true;


                return false;
            }

        });







    }
    public void touchInterpreter(float x1,float x2,float y1,float y2)
    {
        //Toast.makeText(getApplication(), x1+" "+x2+" "+y1+" "+y2, Toast.LENGTH_SHORT).show();


        if(Math.abs(x2-x1)>Math.abs(y2-y1))
        {

            if (x1 > x2)
            {
                //Toast.makeText(getParent(), rootView+"", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplication(), (c)+"toLeft", Toast.LENGTH_LONG).show();

                    onFlingHandler(FLING_TO_LEFT);

            }
            else if (x1 < x2)
            {
                //Toast.makeText(getApplication(), (c)+"toRight", Toast.LENGTH_LONG).show();

                    onFlingHandler(FLING_TO_RIGHT);
            }
        }
        else
        {
            if (y1 > y2)
            {
                //Toast.makeText(getParent(), rootView+"", Toast.LENGTH_LONG).show();
                //Toast.makeText(getActivity(), "gestures", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplication(), "toTop", Toast.LENGTH_LONG).show();
                onFlingHandler(FLING_TO_TOP);
            }
            else if (y1 < y2)
            {
                //Toast.makeText(getActivity(), "gestures", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplication(), "toBottom", Toast.LENGTH_LONG).show();
                onFlingHandler(FLING_TO_BOTTOM);
            }
        }
        //flag=true;
    }
    public void onFlingHandler(int FlingDirection)
    {

        switch (FlingDirection)
        {
            case FLING_TO_LEFT:
            {

                switch (activeUI)
                {
                    case STANDARD_UI:
                    {
                        break;
                    }
                    case SCIENTIFIC_UI:
                    {
                        //Toast.makeText(this, scientificFunctionPanelLeftFragment.isAdded()+"added", Toast.LENGTH_LONG).show();
                        //Toast.makeText(this,FlingDirection+"tt", Toast.LENGTH_LONG).show();

                        if(scientificFunctionPanelLeftFragment==null || !scientificFunctionPanelLeftFragment.isAdded())
                        {
                           /* if (shadowFragment[2] == null)
                            {
                                //Toast.makeText(this, "xxx", Toast.LENGTH_LONG).show();
                                shadowFragment[2]=new ShadowFragment();
                                shadowFragment[2].alpha=0f;
                                shadowFragment[2].rootViewHeight=standardButtonPanelFragment.getView().getHeight() + standardFunctionPanelFragment.getView().getHeight();
                                shadowFragment[2].rootViewWidth=(int)(standardButtonPanelFragment.getView().getWidth()*(1d/40d));
                                shadowFragment[2].x1=shadowFragment[2].rootViewWidth;
                                shadowFragment[2].setArguments(getIntent().getExtras());
                                //getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalLevel2UpperRight, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z3, shadowFragment[2]).commit();
                            }*/
                            if (scientificFunctionPanelRightFragment == null)
                            {
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(shadowFragment[3]).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[2]).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_right_with_fade_out).remove(shadowFragment[3]).commit();
                                shadowFragment[3].backgroundColorStart=0xFF000000;
                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z3, shadowFragment[3]).commit();
                                scientificFunctionPanelRightFragment = new ScientificFunctionPanelRightFragment();
                                scientificFunctionPanelRightFragment.setArguments(getIntent().getExtras());
                                scientificFunctionPanelRightFragment.alpha = 0f;
                                scientificFunctionPanelRightFragment.rootViewWidth = standardButtonPanelFragment.getView().getWidth();
                                scientificFunctionPanelRightFragment.rootViewHeight = standardButtonPanelFragment.getView().getHeight() + standardFunctionPanelFragment.getView().getHeight();
                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z3, scientificFunctionPanelRightFragment).commit();
                            }
                            else if(!scientificFunctionPanelRightFragment.isAdded())
                            {
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[2]).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_right_with_fade_out).remove(shadowFragment[3]).commit();
                                shadowFragment[3].backgroundColorStart=0xFF000000;
                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z3, shadowFragment[3]).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z3, scientificFunctionPanelRightFragment).commit();
                            }






                        }
                        else
                        {
                            //Toast.makeText(this, "to be added", Toast.LENGTH_LONG).show();
                            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(scientificFunctionPanelLeftFragment).commit();
                            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[2]).commit();

                            shadowFragment[2].backgroundColorStart=0xFF4CAF50;
                            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z3, shadowFragment[3]).commit();
                            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z2, shadowFragment[2]).commit();

                            //shadowFragment[3].backgroundColorStart=0xFF000000;
                            //getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z3, shadowFragment[3]).commit();
                            //scientificFunctionPanelLeftFragment=null;
                            //shadowFragment[3]=null;


                        }
                        break;
                    }
                    case PROGRAMMING_UI:
                    {
                        break;
                    }
                }
                break;
            }
            case FLING_TO_RIGHT:
            {
                switch (activeUI)
                {
                    case STANDARD_UI:
                    {
                        break;
                    }
                    case SCIENTIFIC_UI:
                    {
                        if(scientificFunctionPanelRightFragment==null  || !scientificFunctionPanelRightFragment.isAdded())
                        {
                            if (scientificFunctionPanelLeftFragment == null)
                            {
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[2]).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_right_with_fade_out).remove(shadowFragment[3]).commit();
                                scientificFunctionPanelLeftFragment = new ScientificFunctionPanelLeftFragment();
                                scientificFunctionPanelLeftFragment.setArguments(getIntent().getExtras());
                                scientificFunctionPanelLeftFragment.alpha = 0f;
                                scientificFunctionPanelLeftFragment.rootViewWidth = standardButtonPanelFragment.getView().getWidth();
                                scientificFunctionPanelLeftFragment.rootViewHeight = standardButtonPanelFragment.getView().getHeight() + standardFunctionPanelFragment.getView().getHeight();
                                shadowFragment[2].backgroundColorStart=0xFF000000;
                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z2, scientificFunctionPanelLeftFragment).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z2, shadowFragment[2]).commit();
                            }
                            else if(!scientificFunctionPanelLeftFragment.isAdded())
                            {
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[2]).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_right_with_fade_out).remove(shadowFragment[3]).commit();
                                shadowFragment[2].backgroundColorStart=0xFF000000;

                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z2, scientificFunctionPanelLeftFragment).commit();
                                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z2, shadowFragment[2]).commit();
                            }

                            /*if (shadowFragment[2] == null)
                            {
                                //Toast.makeText(this, "xxx", Toast.LENGTH_LONG).show();
                                shadowFragment[2]=new ShadowFragment();
                                shadowFragment[2].alpha=0f;
                                shadowFragment[2].rootViewHeight=standardButtonPanelFragment.getView().getHeight() + standardFunctionPanelFragment.getView().getHeight();
                                shadowFragment[2].rootViewWidth=(int)(standardButtonPanelFragment.getView().getWidth()*(1d/40d));
                                shadowFragment[2].x2=shadowFragment[2].rootViewWidth;
                                shadowFragment[2].setArguments(getIntent().getExtras());

                                //getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, R.animator.fragment_animator__slide_out).add(R.id.LinearUIHorizontalLevel2UpperRight, shadowFragment[shadowFragmentIndex]).addToBackStack(null).commit();
                            }
                            //*/





                        }
                        else
                        {
                            //Toast.makeText(this, "added", Toast.LENGTH_LONG).show();
                            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(scientificFunctionPanelRightFragment).commit();
                            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(shadowFragment[3]).commit();

                            shadowFragment[3].backgroundColorStart=0xFF4CAF50;
                            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_right_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z3, shadowFragment[3]).commit();
                            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, DUMMY).add(R.id.LinearUIHorizontalL2N1Z2, shadowFragment[2]).commit();
                            //scientificFunctionPanelRightFragment=null;
                            //shadowFragment[2]=null;
                        }
                        break;
                    }
                    case PROGRAMMING_UI:
                    {
                        break;
                    }
                }
                break;
            }
            case FLING_TO_BOTTOM:
            {
                switch (activeUI)
                {
                    case STANDARD_UI:
                    {
                        break;
                    }
                    case SCIENTIFIC_UI:
                    {
                        break;
                    }
                    case PROGRAMMING_UI:
                    {
                        if(programmingFunctionPanelFragment!=null)
                        {
                            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(programmingFunctionPanelFragment).commit();
                            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(shadowFragment[2]).commit();
                            shadowFragment[2].backgroundColorStart=0xFFFF8F00;
                            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, DUMMY).add(R.id.LinearUIVerticalL2N1Z2, shadowFragment[2]).addToBackStack(null).commit();
                            programmingFunctionPanelFragment = null;
                            //shadowFragment[2] = null;
                        }
                        break;
                    }
                }
                break;
            }
            case FLING_TO_TOP:
            {
                switch (activeUI)
                {
                    case STANDARD_UI:
                    {
                        break;
                    }
                    case SCIENTIFIC_UI:
                    {
                        break;
                    }
                    case PROGRAMMING_UI:
                    {
                        /*if (shadowFragment[2]==null)
                        {
                            shadowFragment[2]=new ShadowFragment();
                            shadowFragment[2].alpha=0f;
                            shadowFragment[2].rootViewWidth=-1;
                            shadowFragment[2].rootViewHeight=(int)((programmingNumberPanelFragment0to4.getView().getHeight())*(1d/50d));
                            //Toast.makeText(getApplicationContext(),shadowFragment[shadowFragmentIndex].rootViewHeight+"", Toast.LENGTH_LONG).show();
                            shadowFragment[2].y1=shadowFragment[shadowFragmentIndex].rootViewHeight;
                            //shadowFragment[shadowFragmentIndex].backgroundColorStart=0x00FFFFFF;
                            //shadowFragment[shadowFragmentIndex].backgroundColorEnd=0xFF000000;
                            shadowFragment[2].setArguments(getIntent().getExtras());
                            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, DUMMY).add(R.id.LinearUIVerticalL2N1Z2, shadowFragment[2]).addToBackStack(null).commit();
                        }*/
                        if (programmingFunctionPanelFragment==null)
                        {
                            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY,R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(shadowFragment[2]).addToBackStack(null).commit();
                            shadowFragment[2].backgroundColorStart=0xFF000000;
                            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, DUMMY).add(R.id.LinearUIVerticalL2N1Z2, shadowFragment[2]).addToBackStack(null).commit();
                            programmingFunctionPanelFragment = new ProgrammingFunctionPanelFragment();
                            programmingFunctionPanelFragment.setArguments(getIntent().getExtras());
                            programmingFunctionPanelFragment.alpha = 0f;
                            programmingFunctionPanelFragment.buttonColor= new int[]{0xFFFF8F00,0xFFFF6F00,0xFFFFA000,0xFFFFB300};
                            programmingFunctionPanelFragment.rootViewWidth = programmingNumberPanelFragment0to4.getView().getWidth() + programmingNumberPanelFragment5to9.getView().getWidth() + programmingNumberPanelFragmentAtoF.getView().getWidth();
                            programmingFunctionPanelFragment.rootViewHeight = (int) (programmingNumberPanelFragment0to4.getView().getHeight() * (4d / 5d));
                            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, DUMMY).add(R.id.LinearUIVerticalL2N1Z2, programmingFunctionPanelFragment).commit();
                        }



                            //getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out_left_with_fade_out).add(R.id.LinearUIHorizontalLevel2Upper,shadowFragment[shadowFragmentIndex]);
                            //shadowFragmentIndex=3;

                        }
                        break;
                    }
                }
                break;
            }

        }







    @Override
    public void buttonPressed(String buttonText)
    {


            if(activeUI==PROGRAMMING_UI && !buttonText.equals("\u2162") && !buttonText.equals("Standard") && !buttonText.equals("Scientific") && !buttonText.equals("Programming"))
            {
                Toast.makeText(this,"Available in Pro Mode !!",Toast.LENGTH_SHORT).show();
            }
            else if(buttonText.equals("\u2190"))
            {

                viewScreenFragment.getEditTextData();

                if(!mainComponentText.equals(""))
                {
                    viewScreenFragment.getEditTextCursorPosition();
                    int pos = mainComponentCursorPosition;

                    //Toast.makeText(getApplicationContext(),mainComponentText.substring(0,pos-1)+" || "+mainComponentText.substring(pos), Toast.LENGTH_LONG).show();

                    viewScreenFragment.setEditTextData(mainComponentText.substring(0,pos-1)+mainComponentText.substring(pos));
                    viewScreenFragment.updateTextCursorPosition(mainComponentCursorPosition-1);
                }
            }
        //

            else if (buttonText.equals("\u2162"))
            {
                if(activeUI<10)
                {
                    if(scientificFunctionPanelLeftFragment!=null)
                    {
                        //Toast.makeText(this,"right",Toast.LENGTH_SHORT).show();
                        onFlingHandler(FLING_TO_LEFT);
                    }
                    else if(scientificFunctionPanelRightFragment!=null)
                    {
                        onFlingHandler(FLING_TO_RIGHT);
                    }
                    else if(programmingFunctionPanelFragment!=null)
                    {
                        onFlingHandler(FLING_TO_BOTTOM);
                    }
                    settingsPanel();
                    //Toast.makeText(this,"yo",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Toast.makeText(this,"yos",Toast.LENGTH_SHORT).show();
                    clean();

                    /*\
                    switch (activeUI)
                    {
                        case STANDARD_UI:
                        {
                            standardUI();
                            break;
                        }
                        case SCIENTIFIC_UI:
                        {
                            scientificUI();
                            break;
                        }
                        case PROGRAMMING_UI:
                        {
                            ProgrammingUI();
                            break;
                        }
                    }*/

                }
                /*clean();
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        switch (activeUI)
                        {
                            case STANDARD_UI:
                            {
                                scientificUI();
                                break;
                            }
                            case SCIENTIFIC_UI:
                            {
                                standardUI();
                                break;
                            }
                            case PROGRAMMING_UI:
                            {
                                break;
                            }
                        }
                    }
                },5000);*/

               /*new java.util.Timer().schedule(new java.util.TimerTask()
               {
                    @Override
                    public void run()
                    {
                        Toast.makeText(getApplicationContext(),"Invalid Input", Toast.LENGTH_LONG).show();
                        //scientificUI();
                    }
                },10000);*/

                //viewScreenFragment.updateTextCursorPosition(mainComponentCursorPosition-1);
            }



            else if(buttonText.indexOf("( )")!=-1)
            {
                viewScreenFragment.updateEditTextData(buttonText.substring(0,buttonText.indexOf("("))+"()");
                viewScreenFragment.getEditTextCursorPosition();
                viewScreenFragment.updateTextCursorPosition(mainComponentCursorPosition-1);
            }

            else if(buttonText.equals("Standard"))
            {
                UiSwitcher(STANDARD_UI);
            }
            else if(buttonText.equals("Scientific"))
            {
                UiSwitcher(SCIENTIFIC_UI);
            }
            else if(buttonText.equals("Programming"))
            {
                UiSwitcher(PROGRAMMING_UI);
            }


        //


            else if(buttonText.equals("="))
            {
                try
                {
                    viewScreenFragment.getEditTextData();
                    viewScreenFragment.setEditTextData((new EquationHandler()).mathParser(mainComponentText, OPERATORS,scientificFunctionPanelLeftFragment==null?true:(scientificFunctionPanelLeftFragment.activeButton==14?true:false)) + "");
                    viewScreenFragment.getEditTextData();
                    viewScreenFragment.updateTextCursorPosition(mainComponentText.length());
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Input", Toast.LENGTH_LONG).show();
                }
            }
        //


            else
            {
                viewScreenFragment.updateEditTextData(buttonText);
            }
        //
    }


    public void UiSwitcher(final int targetUI)
    {
        clean();
        if(activeUI!=targetUI) {
            clean();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (targetUI) {
                        case STANDARD_UI: {
                            standardUI();

                            break;
                        }
                        case SCIENTIFIC_UI: {
                            scientificUI();
                            break;
                        }
                        case PROGRAMMING_UI: {
                            ProgrammingUI();
                            break;
                        }
                    }
                }
            }, 500);
        }
        /*switch (targetUI)
        {
            case STANDARD_UI:
            {
                standardUI();
                break;
            }
            case SCIENTIFIC_UI:
            {
                scientificUI();
                break;
            }
            case PROGRAMMING_UI:
            {

                break;
            }
        }*/
    }
    public void clean()
    {
        switch (activeUI)
        {
            case PROGRAMMING_UI:
            {
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(shadowFragment[2]).addToBackStack(null).commit();

                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_top_with_fade_out).remove(actionBarFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(shadowFragment[0]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(viewScreenFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(shadowFragment[1]).addToBackStack(null).commit();

                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(programmingNumberPanelFragment0to4).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(programmingNumberPanelFragment5to9).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(programmingNumberPanelFragmentAtoF).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(programmingEvaluationPanelFragment).addToBackStack(null).commit();


                actionBarFragment.alpha=0f;
                shadowFragment[0].alpha=0f;
                shadowFragment[1].alpha=0f;
                viewScreenFragment.alpha=0f;
                programmingNumberPanelFragment0to4.alpha=0f;
                programmingNumberPanelFragment0to4.rootViewWidth*=2;

                getFragmentManager().beginTransaction().add(R.id.LinearUIHorizontalL1N1Z1,programmingNumberPanelFragment0to4).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,actionBarFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,shadowFragment[0]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,viewScreenFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,shadowFragment[1]).addToBackStack(null).commit();




                break;
            }
            case SCIENTIFIC_UI:
            {
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[2]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(shadowFragment[3]).addToBackStack(null).commit();

                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_top_with_fade_out).remove(actionBarFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(shadowFragment[0]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(viewScreenFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(shadowFragment[1]).addToBackStack(null).commit();

                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(standardFunctionPanelFragment).addToBackStack(null).commit();

                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(standardButtonPanelFragment).addToBackStack(null).commit();

                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(standardEvaluationPanelFragment).addToBackStack(null).commit();


                actionBarFragment.alpha=0f;
                shadowFragment[0].alpha=0f;
                shadowFragment[1].alpha=0f;
                viewScreenFragment.alpha=0f;

                standardFunctionPanelFragment.alpha=0f;



                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,actionBarFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,shadowFragment[0]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,viewScreenFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,shadowFragment[1]).addToBackStack(null).commit();

                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N2Z1,standardFunctionPanelFragment).addToBackStack(null).commit();


                break;
            }
            case STANDARD_UI:
            {
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_top_with_fade_out).remove(actionBarFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(shadowFragment[0]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(viewScreenFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(shadowFragment[1]).addToBackStack(null).commit();


                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(standardButtonPanelFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(standardFunctionPanelFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(standardEvaluationPanelFragment).addToBackStack(null).commit();


                actionBarFragment.alpha=0f;
                shadowFragment[0].alpha=0f;
                shadowFragment[1].alpha=0f;
                viewScreenFragment.alpha=0f;
                standardFunctionPanelFragment.alpha=0f;

                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1, standardFunctionPanelFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1,actionBarFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1, shadowFragment[0]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1, viewScreenFragment).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalL1N1Z1, shadowFragment[1]).addToBackStack(null).commit();
                break;
            }
            default:
            {
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(settingsPanelPersonalizationFragments[0]).addToBackStack(null).commit();

                settingsPanelPersonalizationFragments[0].alpha=0f;
                settingsPanelPersonalizationFragments[0].rootViewHeight=0;
                getFragmentManager().beginTransaction().add(R.id.settingsPanelLeft, settingsPanelPersonalizationFragments[0]).addToBackStack(null).commit();

                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[shadowFragmentIndex--]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[shadowFragmentIndex--]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[shadowFragmentIndex--]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(settingsPanelPersonalizationFragments[1]).addToBackStack(null).commit();
                getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(settingsPanelMainSettingsCard).addToBackStack(null).commit();
                activeUI/=10;
                break;
            }

        }
        /*if(activeUI.equals("std"))
        {
            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_top_with_fade_out).remove(actionBarFragment).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(shadowFragment[0]).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(viewScreenFragment).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__fade_out).remove(shadowFragment[1]).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(standardButtonPanelFragment).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(standardFunctionPanelFragment).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(DUMMY, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(standardEvaluationPanelFragment).addToBackStack(null).commit();

        }
        else if(activeUI.equals("scn"))
        {
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(scientificFunctionPanelFragmentMinimized[0]).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[2]).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(scientificFunctionPanelFragmentMinimized[1]).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(shadowFragment[3]).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(scientificFunctionPanelFragmentMinimized[2]).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(shadowFragment[4]).addToBackStack(null).commit();



            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(standardButtonPanelFragment).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).remove(standardFunctionPanelFragment).addToBackStack(null).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_bottom_with_fade_out).remove(standardEvaluationPanelFragment).addToBackStack(null).commit();



                    getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__slide_out_top_with_fade_out).remove(actionBarFragment).addToBackStack(null).commit();
                    getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__fade_out).remove(shadowFragment[0]).addToBackStack(null).commit();
                    getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__fade_out).remove(viewScreenFragment).addToBackStack(null).commit();
                    getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_top_with_fade_in, R.animator.fragment_animator__fade_out).remove(shadowFragment[1]).addToBackStack(null).commit();

                    getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalLevel2,actionBarFragment).addToBackStack(null).commit();
                    getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalLevel2,shadowFragment[0]).addToBackStack(null).commit();
                    getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalLevel2,viewScreenFragment).addToBackStack(null).commit();
                    getFragmentManager().beginTransaction().add(R.id.LinearUIVerticalLevel2,shadowFragment[1]).addToBackStack(null).commit();

                    actionBarFragment.alpha=0f;
                    shadowFragment[0].alpha=0f;
                    viewScreenFragment.alpha=0f;
                    shadowFragment[1].alpha=0f;




        }*/

    }

    @Override
    public void longButtonPressed(String buttonText)
    {


            if (buttonText.equals("\u2190"))
            {
                viewScreenFragment.setEditTextData("");
            }
        //
    }




   /* public void ToTopDrag()
    {
        if (programmingFunctionPanelFragment==null)
        {
            programmingFunctionPanelFragment=new ProgrammingFunctionPanelFragment();
            programmingFunctionPanelFragment.setArguments(getIntent().getExtras());
            programmingFunctionPanelFragment.alpha=0f;
            programmingFunctionPanelFragment.rootViewWidth=programmingNumberPanelFragment0to4.getView().getWidth()+programmingNumberPanelFragment5to9.getView().getWidth()+programmingNumberPanelFragmentAtoF.getView().getWidth();
            programmingFunctionPanelFragment.rootViewHeight=(int)(programmingNumberPanelFragment0to4.getView().getHeight()*(4d/5d));

            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(shadowFragment[2]).commit();

            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_left_with_fade_in, R.animator.fragment_animator__slide_out_left_with_fade_out).remove(scientificFunctionPanelFragmentMinimized[0]).commit();

            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).add(R.id.LinearUIVerticalL2N1Z2, shadowFragment[2]).commit();
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__slide_in_bottom_with_fade_in, R.animator.fragment_animator__slide_out_right_with_fade_out).add(R.id.LinearUIVerticalL2N1Z2, programmingFunctionPanelFragment).commit();

            //getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_animator__fade_in, R.animator.fragment_animator__slide_out_left_with_fade_out).add(R.id.LinearUIHorizontalLevel2Upper,shadowFragment[shadowFragmentIndex]);
            //shadowFragmentIndex=3;

        }
    }
    //
*/
}
