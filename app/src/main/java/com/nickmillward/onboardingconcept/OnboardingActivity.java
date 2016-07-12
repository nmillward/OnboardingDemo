package com.nickmillward.onboardingconcept;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.onboarding_viewpager);

        // Set Adapter on ViewPager
        viewPager.setAdapter(new OnboardingAdapter(getSupportFragmentManager()));

        // Set PageTransformer on ViewPager
        viewPager.setPageTransformer(false, new OnboardingPageTransformer());
    }
}
