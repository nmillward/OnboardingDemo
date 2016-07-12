package com.nickmillward.onboardingconcept;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nmillward on 7/12/16.
 */
public class OnboardingAdapter extends FragmentPagerAdapter {

    public OnboardingAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return OnboardingFragment.newInstance(Color.parseColor("#03A9F4"), position);
            case 1:
                return OnboardingFragment.newInstance(Color.parseColor("#00BCD4"), position);
            case 2:
                return OnboardingFragment.newInstance(Color.parseColor("#009688"), position);
            default:
                return OnboardingFragment.newInstance(Color.parseColor("#03A9F4"), position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
