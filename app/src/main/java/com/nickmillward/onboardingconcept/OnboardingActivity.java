package com.nickmillward.onboardingconcept;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class OnboardingActivity extends AppCompatActivity {

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

        viewPager = (ViewPager) findViewById(R.id.onboarding_viewpager);

        // Set Adapter on ViewPager
        viewPager.setAdapter(new OnboardingAdapter(getSupportFragmentManager()));

        // Set PageTransformer on ViewPager
        viewPager.setPageTransformer(false, new OnboardingPageTransformer());
    }
}
