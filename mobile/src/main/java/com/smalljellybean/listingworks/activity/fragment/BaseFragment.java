package com.smalljellybean.listingworks.activity.fragment;

import android.app.Fragment;

import com.smalljellybean.listingworks.activity.IMainActivity;

public class BaseFragment extends Fragment {
    protected IMainActivity getParentActivity(){
        return ((IMainActivity)getActivity());
    }
}
