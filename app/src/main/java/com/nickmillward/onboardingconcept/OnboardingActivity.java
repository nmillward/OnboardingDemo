package com.nickmillward.onboardingconcept;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OnboardingActivity extends AppCompatActivity {

    private int pagePosition = 0;
    private ImageButton nextBtn;
    private Button finishBtn;
    private ViewPager viewPager;
    private ImageView[] indicators;
    private ImageView indicator01, indicator02, indicator03;

    public TextView tv_brightness;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextBtn = (ImageButton) findViewById(R.id.btn_next);
        finishBtn = (Button) findViewById(R.id.btn_finish);

        indicator01 = (ImageView) findViewById(R.id.indicator_01);
        indicator02 = (ImageView) findViewById(R.id.indicator_02);
        indicator03 = (ImageView) findViewById(R.id.indicator_03);
        indicators = new ImageView[] {indicator01, indicator02, indicator03};

        updateIndicator(pagePosition);

        final int pageColor01 = ContextCompat.getColor(this, R.color.lightBlue);
        final int pageColor02 = ContextCompat.getColor(this, R.color.cyan);
        final int pageColor03 = ContextCompat.getColor(this, R.color.teal);
        final int[] pageColorList = new int[] {pageColor01, pageColor02, pageColor03};

        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();  //used to update the page color

        tv_brightness = (TextView) findViewById(R.id.tv_brightness);

        viewPager = (ViewPager) findViewById(R.id.onboarding_viewpager);

        // Set Adapter on ViewPager
        viewPager.setAdapter(new OnboardingAdapter(getSupportFragmentManager()));

        // Set PageTransformer on ViewPager
        viewPager.setPageTransformer(false, new OnboardingPageTransformer());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                // Update Page Background Color
                int pageColorUpdate = (Integer) argbEvaluator.evaluate(
                        positionOffset,
                        pageColorList[position],
                        pageColorList[position == 2 ? position : position + 1]  //If there's no last page, do not increment
                );
                viewPager.setBackgroundColor(pageColorUpdate);

            }

            @Override
            public void onPageSelected(int position) {
                pagePosition = position;
                updateIndicator(pagePosition);

                //set the page color when selected
                switch (position) {
                    case 0:
                        viewPager.setBackgroundColor(pageColor01);
                        break;
                    case 1:
                        viewPager.setBackgroundColor(pageColor02);
                        break;
                    case 2:
                        viewPager.setBackgroundColor(pageColor03);
                        break;
                }

                nextBtn.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
                finishBtn.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void updateIndicator(int pagePosition) {
        for(int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(
                    i == pagePosition ? R.drawable.indicator_selected : R.drawable.indicator_unselected
            );
        }
    }

    public void onNextButton(View view) {
        pagePosition += 1;
        viewPager.setCurrentItem(pagePosition, true);
    }

    public void onFinishButton(View view) {
        //TODO: Send info to data layer
        finish();
    }

    public void onCancelButton(View view) {
        finish();
    }

}
