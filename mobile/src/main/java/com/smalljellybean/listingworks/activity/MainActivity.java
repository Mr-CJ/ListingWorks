package com.smalljellybean.listingworks.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.smalljellybean.listingworks.R;
import com.smalljellybean.listingworks.activity.service.HttpService;
import com.smalljellybean.listingworks.activity.service.ListItem;
import com.smalljellybean.listingworks.activity.service.ListItemResponse;
import com.smalljellybean.listingworks.base.NavigationActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends NavigationActivity {

    private static final String TAG = MainActivity.class.getName();
    protected ListView menuList;
    private List data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrepareData();
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

    private void initNavigation(){
        menuList = ((ListView) navigationView.inflate());
        SimpleAdapter adapter = new SimpleAdapter(this, data,android.R.layout.simple_list_item_1, new String[] { "AAA" },
                new int[] { android.R.id.text1 });
        menuList.setAdapter(adapter);
        menuList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    private void PrepareData() {
        data = new ArrayList<Map<String, Object>>();
        Map<String, Object> item;
        item = new HashMap<String, Object>();
        item.put("1", "A");
        item.put("2", "B");
        data.add(item);
        item = new HashMap<String, Object>();
        item.put("3", "C");
        item.put("4", "D");
        data.add(item);
        item = new HashMap<String, Object>();
        item.put("5", "E");
        item.put("6", "F");
        data.add(item);
    }

    @Override
    protected int getDrawerLayoutResId() {
        return R.layout.drawer_listview;
    }

}
