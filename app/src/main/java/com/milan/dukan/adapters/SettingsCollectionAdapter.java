package com.milan.dukan.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.milan.dukan.NotificationFragment;
import com.milan.dukan.ProfileFragment;

public class SettingsCollectionAdapter extends FragmentStateAdapter {

    public SettingsCollectionAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ProfileFragment();
        } else {
            return new NotificationFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
