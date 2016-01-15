package com.smalljellybean.listingworks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smalljellybean.listingworks.R;
import com.smalljellybean.listingworks.domain.Catalogue;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatalogueAdapter extends BaseFlipAdapter<Catalogue> {

    private Context context;
    private final int PAGES = 3;
    private int[] IDS_INTEREST = {R.id.category_1, R.id.category_2, R.id.category_3, R.id.category_4, R.id.category_5};

    public CatalogueAdapter(Context context, List<Catalogue> items, FlipSettings settings) {
        super(context, items, settings);
        this.context = context;
    }

    @Override
    public View getPage(int position, View convertView, ViewGroup parent, Catalogue item1, Catalogue item2) {
        final CatalogueHolder holder;

        if (convertView == null) {
            holder = new CatalogueHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.catalogue_merge_page, parent, false);
            holder.leftCatalogue = (ImageView) convertView.findViewById(R.id.first);
            holder.rightCatalogue = (ImageView) convertView.findViewById(R.id.second);
            holder.infoPage = LayoutInflater.from(context).inflate(R.layout.catalogue_info, parent, false);
            holder.name = (TextView) holder.infoPage.findViewById(R.id.catalogue_name);

            for (int id : IDS_INTEREST)
                holder.categories.add((TextView) holder.infoPage.findViewById(id));

            convertView.setTag(holder);
        } else {
            holder = (CatalogueHolder) convertView.getTag();
        }

        switch (position) {
            case 1:
                holder.leftCatalogue.setImageResource(item1.getImageResId());
                if (item2 != null)
                    holder.rightCatalogue.setImageResource(item2.getImageResId());
                break;
            default:
                fillHolder(holder, position == 0 ? item1 : item2);
                holder.infoPage.setTag(holder);
                return holder.infoPage;
        }
        return convertView;
    }

    @Override
    public int getPagesCount() {
        return PAGES;
    }

    private void fillHolder(CatalogueHolder holder, Catalogue catalogue) {
        if (catalogue == null)
            return;
        Iterator<TextView> iViews = holder.categories.iterator();
        Iterator<String> iInterests = catalogue.getCategories().iterator();
        while (iViews.hasNext() && iInterests.hasNext())
            iViews.next().setText(iInterests.next());
        holder.infoPage.setBackgroundColor(context.getResources().getColor(catalogue.getBackground()));
        holder.name.setText(catalogue.getName());
    }

    class CatalogueHolder {
        ImageView leftCatalogue;
        ImageView rightCatalogue;
        View infoPage;

        List<TextView> categories = new ArrayList<>();
        TextView name;
    }
}
