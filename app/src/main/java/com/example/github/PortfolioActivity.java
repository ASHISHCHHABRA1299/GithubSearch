package com.example.github;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PortfolioActivity extends AppCompatActivity {


    String user;
    ImageView profile;
    TextView follower,following,bio;
    String url="https://api.github.com/users/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        profile=(ImageView) findViewById(R.id.image);
        follower=(TextView)findViewById(R.id.followers);
        following=(TextView)findViewById(R.id.following);
        bio=(TextView)findViewById(R.id.bio);
        // to get the username from the mainactivity.java
        user=getIntent().getStringExtra("Username");
        url=url+user;


    }
    // method to load the data
    public void loaddata(String url)
    {

    }
    // method to load the repositories
    public void loadrepository(String url)
    {

    }


}