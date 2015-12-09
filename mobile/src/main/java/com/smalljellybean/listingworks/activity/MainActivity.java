package com.smalljellybean.listingworks.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smalljellybean.listingworks.R;
import com.smalljellybean.listingworks.activity.fragment.LogInFragment;
import com.smalljellybean.listingworks.activity.fragment.SignUpFragment;
import com.smalljellybean.listingworks.base.NavigationActivity;
import com.smalljellybean.listingworks.database.Preferences;
import com.smalljellybean.listingworks.domain.ListItem;
import com.smalljellybean.listingworks.domain.ListItemResponse;
import com.smalljellybean.listingworks.service.HttpService;

import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends NavigationActivity implements IMainActivity{

    private static final String TAG = MainActivity.class.getName();
    private ListView navigation;
    private FrameLayout navigationHeader;

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
        navigation = (ListView) findViewById(R.id.navigation_menu_list);
        navigationHeader = (FrameLayout) View.inflate(this, R.layout.navigation_header, null);
        navigation.addHeaderView(navigationHeader);
        navigation.setAdapter(new NavigationItemAdapter(this));
        navigation.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        navigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawers();
                if (position == 5) {
                    startFragment(new LogInFragment());
                }
                if (position == 6) {
                    startFragment(new SignUpFragment());
                }
            }
        });
    }

    private void startFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        String tag = fragment.getClass().getName();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

    @Override
    public void showUserInfo() {
        RelativeLayout userInfoLayout = (RelativeLayout) View.inflate(this, R.layout.navigation_header_user_info, null);
        TextView username = (TextView) userInfoLayout.findViewById(R.id.profile_username);
        Preferences preferences = Preferences.getInstance(this);
        if(preferences.getUsername()!=null){
            username.setText("Hi "+preferences.getUsername());
        }
        navigationHeader.addView(userInfoLayout);
    }

    @Override
    public void clearUserInfo() {
        navigationHeader.removeAllViews();
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
            items.add("Log In");
            items.add("Sign Up");
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
