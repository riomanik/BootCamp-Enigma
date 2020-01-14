package com.example.projeck_login.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public FragmentAdapter(Context c, @NonNull FragmentManager fm, int totalTabs){
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        context = c;
        this.totalTabs = totalTabs;
    }


    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                PayBuyFragment payBuyFragment = new PayBuyFragment();
                return payBuyFragment;
            case 1:
                PromoFragment promoFragment = new PromoFragment();
                return promoFragment;
            default:
                PayBuyFragment payBuyFragmentDef = new PayBuyFragment();
                return payBuyFragmentDef;
        }
    }

    @Override
    public int getCount() {return  totalTabs;}
}
