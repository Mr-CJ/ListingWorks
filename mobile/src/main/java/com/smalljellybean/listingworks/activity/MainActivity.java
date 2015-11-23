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
import com.smalljellybean.listingworks.activity.service.HttpService;
import com.smalljellybean.listingworks.activity.service.ListItem;
import com.smalljellybean.listingworks.activity.service.ListItemResponse;
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
        ListView listView = ((ListView) navigationView.inflate());
        listView.setAdapter(new NavigationItemAdapter(this));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    protected int getDrawerLayoutResId() {
        return R.layout.drawer_listview;
    }

    class NavigationItemAdapter extends BaseAdapter {

        private List<String> items;
        private Context context;

        public NavigationItemAdapter(Context context) {
            this.context = context;
            items = new ArrayList<>();
            items.add("个人主页");
            items.add("分享清单");
            items.add("意见反馈");
            items.add("设置");
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
