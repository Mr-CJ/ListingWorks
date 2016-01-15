package com.smalljellybean.listingworks.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.smalljellybean.listingworks.R;
import com.smalljellybean.listingworks.adapters.CatalogueAdapter;
import com.smalljellybean.listingworks.domain.Catalogue;
import com.smalljellybean.listingworks.utils.CatalogueUtil;
import com.yalantis.flipviewpager.utils.FlipSettings;

public class HomeFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        final ListView friends = (ListView) rootView.findViewById(R.id.catalogue);

        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        friends.setAdapter(new CatalogueAdapter(getActivity(), CatalogueUtil.catalogues, settings));
        friends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Catalogue f = (Catalogue) friends.getAdapter().getItem(position);

                Toast.makeText(getActivity(), f.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
