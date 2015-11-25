package com.smalljellybean.listingworks.activity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smalljellybean.listingworks.R;
import com.smalljellybean.listingworks.domain.User;
import com.smalljellybean.listingworks.service.HttpService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignUpFragment extends Fragment{

    private TextView username;
    private TextView email;
    private TextView password;
    private TextView userInfo;
    private Button signUp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        username = (TextView) rootView.findViewById(R.id.username);
        email = (TextView) rootView.findViewById(R.id.email);
        password = (TextView) rootView.findViewById(R.id.password);
        signUp = (Button) rootView.findViewById(R.id.sign_up);
        userInfo = (TextView) rootView.findViewById(R.id.user_info);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpService().build().signUp(new User(), new Callback<User>() {
                    @Override
                    public void success(User user, Response response) {

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });
        return rootView;
    }
}
