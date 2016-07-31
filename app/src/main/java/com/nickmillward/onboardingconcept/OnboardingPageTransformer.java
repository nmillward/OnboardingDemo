package com.nickmillward.onboardingconcept;

import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/**
 * Created by nmillward on 7/12/16.
 */
public class OnboardingPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        // Get page index from tag
        int pagePosition = (int) page.getTag();

        int pageWidth = (int) page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        // Scale & Overshoot Animation
        final long durcation = 800;

        if (position <= -1.0f || position >= 1.0f) {

            // Page is not visible -- stop any running animations

        } else if (position == 0.0f) {

            // Page is selected -- reset any views if necessary

        } else {

            // Page is currently being swiped -- perform animations here

            // Fragment 1 -- Settings
            final View tv_settings_title = page.findViewById(R.id.tv_settings_title);
            if (tv_settings_title != null) tv_settings_title.setAlpha(1.0f - absPosition * 2);

            final View tv_brightness = page.findViewById(R.id.tv_brightness);
            if (tv_brightness != null) tv_brightness.setTranslationX(pageWidthTimesPosition * 0.5f);

            final View sb_brightness = page.findViewById(R.id.sb_brightness);
            if (sb_brightness != null) sb_brightness.setTranslationX(pageWidthTimesPosition * 0.5f);

            final View tv_size = page.findViewById(R.id.tv_size);
            if (tv_size != null) tv_size.setTranslationX(pageWidthTimesPosition * 1.2f);

            final View sb_size = page.findViewById(R.id.sb_size);
            if (sb_size != null) sb_size.setTranslationX(pageWidthTimesPosition * 1.2f);

            final View tv_background = page.findViewById(R.id.tv_background);
            if (tv_background != null) tv_background.setTranslationX(pageWidthTimesPosition * 0.9f);

            final View switch_background = page.findViewById(R.id.switch_background);
            if (switch_background != null) switch_background.setTranslationX(pageWidthTimesPosition * 0.9f);


            // Fragment 2 -- Social Card
            final View tv_profile_title = page.findViewById(R.id.tv_social_card_title);
            if (tv_profile_title != null) tv_profile_title.setAlpha(1.0f - absPosition * 2);

//            final ImageView profile = (ImageView) page.findViewById(R.id.iv_profile);
//            if (profile != null) profile.setTranslationX(pageWidthTimesPosition * 1.2f);

            final View card = page.findViewById(R.id.ll_profile_bg);
            if (card != null) card.setTranslationX(pageWidthTimesPosition * 0.7f);

            final View button = page.findViewById(R.id.btn_follow);
            if (button != null) button.setTranslationX(pageWidthTimesPosition * 0.2f);

        }

        if (position > 0 || position < 0) {
            ScaleAnimation scaleUp = new ScaleAnimation(0, 1.0f, 0, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            scaleUp.setDuration(durcation);

            scaleUp.setInterpolator(new FastOutSlowInInterpolator());

            final ImageView profile = (ImageView) page.findViewById(R.id.iv_profile);
            if (profile != null) profile.startAnimation(scaleUp);

        }
//        else if (position < 0) {
//            ScaleAnimation scaleDown = new ScaleAnimation(1.0f, 0, 1.0f, 0,
//                    Animation.RELATIVE_TO_SELF, 0.5f,
//                    Animation.RELATIVE_TO_SELF, 0.5f);
//            scaleDown.setDuration(durcation);
//
//            scaleDown.setInterpolator(new FastOutLinearInInterpolator());
//
//            final ImageView profile = (ImageView) page.findViewById(R.id.iv_profile);
//            if (profile != null) profile.startAnimation(scaleDown);
//
//        }

    }
}
