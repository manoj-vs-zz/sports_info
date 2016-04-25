

package com.vectoscalar.sportsinfo.Common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.vectoscalar.sportsinfo.R;


import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MyFacebookActivity extends Activity {

    private CallbackManager mCallbackManage;

    public static Activity mActivity;

    public static Activity getActivity() {
        return mActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.main);

        mActivity = this;


        List<String> permissionNeeds = new ArrayList<>();
        permissionNeeds.add("public_profile");
        permissionNeeds.add("user_friends");
        permissionNeeds.add("email");
        permissionNeeds.add("user_about_me");
        permissionNeeds.add("user_birthday");
        permissionNeeds.add("user_education_history");
        permissionNeeds.add("user_location");

        //List<String> permissionNeeds= new ArrayList<>();
        //permissionNeeds.add("public_profile");
        //this loginManager helps you eliminate adding a LoginButton to your UI


        mCallbackManage = CallbackManager.Factory.create();
        LoginManager loginManager = LoginManager.getInstance();
        loginManager.logInWithReadPermissions(
                this,
                permissionNeeds);
        loginManager.registerCallback(mCallbackManage,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResults) {

                        Log.d("dd", "success");

                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResults.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(
                                            JSONObject object,
                                            GraphResponse response) {
                                        // Application code
                                        Log.v("LoginActivity", response.toString());

                                        try {

                                            String id = object.getString("id");
//                                            try {
//                                                URL profile_pic = new URL(
//                                                        "http://graph.facebook.com/" + id + "/picture?type=large");
//                                                Log.i("profile_pic",
//                                                        profile_pic + "");
//
//                                                Bitmap bitmap = BitmapFactory.decodeStream(profile_pic.openConnection().getInputStream());
//                                                ((ImageView) findViewById(R.id.profilePic)).setImageBitmap(bitmap);
//
//                                            } catch (MalformedURLException e) {
//                                                e.printStackTrace();
//                                            }

                                            String name = object.getString("name");
                                            String email = object.getString("email");
                                            String gender = object.getString("gender");
                                            String birthday = object.getString("birthday");

                                            Log.d("Info_name",name);
                                            Log.d("Info_email",email);
                                            Log.d("Info_gender",gender);
                                            Log.d("Info_birthday",birthday);
                                            Log.d("Info_id",id);
                                        } catch (Exception e) {
                                        }
                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,gender, birthday,picture");
                        request.setParameters(parameters);
                        request.executeAsync();

                    }

                    @Override
                    public void onCancel() {
                        Log.e("dd", "facebook login canceled");

                    }


                    @Override
                    public void onError(FacebookException e) {
                        e.printStackTrace();
                        Log.e("dd", "facebook login failed error  =  " + e.getMessage());
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        mCallbackManage.onActivityResult(requestCode, responseCode, data);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
