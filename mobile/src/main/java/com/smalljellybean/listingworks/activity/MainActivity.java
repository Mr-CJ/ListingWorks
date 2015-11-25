package com.smalljellybean.listingworks.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.smalljellybean.listingworks.R;
import com.smalljellybean.listingworks.service.HttpService;
import com.smalljellybean.listingworks.domain.ListItem;
import com.smalljellybean.listingworks.domain.ListItemResponse;
import com.smalljellybean.listingworks.base.NavigationActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends NavigationActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigation();
        new HttpService().build().listItems(new retrofit.Callback<ListItemResponse>() {
            @Override
            public void success(ListItemResponse listItems, Response response) {
                Log.d(TAG, "success");
                for (ListItem listItem : listItems.getResults()) {
                    Log.d(TAG, listItem.toString());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "failure");
            }
        });
    }

    private void initNavigation() {
        navigationView.inflate();
        ListView listView = (ListView) findViewById(R.id.navigation_menu_list);
        listView.setAdapter(new NavigationItemAdapter(this));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    protected int getDrawerLayoutResId() {
        return R.layout.navigation_layout;
    }

    class NavigationItemAdapter extends BaseAdapter {

        private List<String> items;
        private Context context;

        public NavigationItemAdapter(Context context) {
            this.context = context;
            items = new ArrayList<>();
            items.add("Notifications");
            items.add("Share List");
            items.add("Feedback");
            items.add("Settings");
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.navigation_item, null);
            }

            TextView textView = (TextView) view.findViewById(R.id.navigation_item);
            textView.setText((String) getItem(position));
            return view;
        }
    }
}
