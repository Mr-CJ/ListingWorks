package com.smalljellybean.listingworks.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.smalljellybean.listingworks.R;
import com.smalljellybean.listingworks.database.Preferences;
import com.smalljellybean.listingworks.domain.User;
import com.smalljellybean.listingworks.service.HttpService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LogInFragment extends BaseFragment{

    private TextView username;
    private TextView password;
    private TextView userInfo;
    private Button login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        username = (TextView) rootView.findViewById(R.id.username);
        password = (TextView) rootView.findViewById(R.id.password);
        login = (Button) rootView.findViewById(R.id.sign_up);
        userInfo = (TextView) rootView.findViewById(R.id.user_info);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpService().build().login(username.getText().toString(), password.getText().toString(), new Callback<User>() {
                    @Override
                    public void success(User user, Response response) {
                        Preferences preferences = Preferences.getInstance(getActivity());
                        preferences.saveUserId(user.getObjectId());
                        preferences.saveUsername(user.getUsername());
                        preferences.saveToken(user.getSessionToken());
                        getParentActivity().showUserInfo();
                        Toast.makeText(getActivity(), "Login Successful!", Toast.LENGTH_LONG).show();
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
