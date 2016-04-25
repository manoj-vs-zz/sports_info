package com.vectoscalar.sportsinfo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.login.widget.LoginButton;
import com.vectoscalar.sportsinfo.Common.MyFacebookActivity;
import com.vectoscalar.sportsinfo.R;
import com.vectoscalar.sportsinfo.Utility.SPIFonts;
import com.vectoscalar.sportsinfo.Utility.SPIUtility;

public class LoginActivity extends AppCompatActivity {

    private int screenWidth,screenHeight;
    private Button facebookButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        // Initialize views
        initializeViews();

        // assign views
        assignViews();

        // set views
        setViews();

        // set fonts
        setFonts();
    }

    private void initializeViews(){
        screenWidth= SPIUtility.getDeviceScreenWidth(this);
        screenHeight=SPIUtility.getDeviceScreenHeight(this);
        facebookButton=(Button) findViewById(R.id.facebookButton);

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, MyFacebookActivity.class);
                startActivity(intent);
            }
        });

    }

    private void assignViews(){

    }

    private void setViews(){
        if(screenHeight>screenWidth) {  // portrait mode
            SPIUtility.setRelativeLayoutMargins(facebookButton,screenWidth*75/100,screenHeight*10/100,
                    0,0, 0, 0,false,false,false,false,true,true,null,null,null,null);
        }
    }

    private void setFonts(){

    }


}
