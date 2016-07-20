package com.nickmillward.onboardingconcept;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class OnboardingActivity extends AppCompatActivity {

    private int pagePosition = 0;
    private ViewPager viewPager;
    private ImageView[] indicators;
    private ImageView indicator01, indicator02, indicator03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicator01 = (ImageView) findViewById(R.id.indicator_01);
        indicator02 = (ImageView) findViewById(R.id.indicator_02);
        indicator03 = (ImageView) findViewById(R.id.indicator_03);
        indicators = new ImageView[] {indicator01, indicator02, indicator03};

        updateIndicator(pagePosition);

        viewPager = (ViewPager) findViewById(R.id.onboarding_viewpager);

        // Set Adapter on ViewPager
        viewPager.setAdapter(new OnboardingAdapter(getSupportFragmentManager()));

        // Set PageTransformer on ViewPager
        viewPager.setPageTransformer(false, new OnboardingPageTransformer());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pagePosition = position;
                updateIndicator(pagePosition);
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
}
