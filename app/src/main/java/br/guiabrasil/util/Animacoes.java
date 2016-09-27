package br.guiabrasil.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by 0118431 on 27/09/2016.
 */
public class Animacoes {

    public static void animaEntradaMenu(View view, final View viewOpacidade){

        TranslateAnimation animation = new TranslateAnimation(-1000,0,0,0);
        animation.setDuration(200);

        /*animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                viewOpacidade.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewOpacidade.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/
        animaInseriOpacidade(viewOpacidade);
        view.startAnimation(animation);

    }

    public static void animaSaidaMenu(final View view, final View viewOpacidade){

        if(view.getVisibility() == View.VISIBLE){
            TranslateAnimation animation = new TranslateAnimation(0,-1000,0,0);
            animation.setDuration(200);

            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    //viewOpacidade.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            animaRemoveOpacidade(viewOpacidade);
            view.startAnimation(animation);
        }

    }

    public static void animaInseriOpacidade(final View view){
        if(view.getVisibility() == View.GONE){
            view.setAlpha(0.0f);
            view.setVisibility(View.VISIBLE);
            view.animate()
                    .alpha(1.0f)
                    .setDuration(500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            view.setVisibility(View.VISIBLE);
                        }
                    });
        }
    }

    public static void animaRemoveOpacidade(final View view){
        if(view.getVisibility() == View.VISIBLE){
            view.animate()
                    .alpha(0.0f)
                    .setDuration(500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            view.setVisibility(View.GONE);
                        }
                    });
        }
    }
}
