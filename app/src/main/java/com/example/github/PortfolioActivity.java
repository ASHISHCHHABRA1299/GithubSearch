package com.example.github;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

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
        loaddata(url);
        loadrepository(url);
    }
    // method to load the data
    public void loaddata(String url)
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String imageurl=response.getString("avatar_url");
                            String bioInfo=response.getString("bio");
                            String followersc=response.getString("followers");
                            String followingc=response.getString("following");
                            follower.setText("FOLLOWERS: "+followersc);
                            following.setText("FOLLOWING: "+followingc);
                            bio.setText("BIO: "+bioInfo);
                            // to set an image in the image view
                            Glide.with(PortfolioActivity.this).load(imageurl).into(profile);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PortfolioActivity.this, "Unable to fetch the data", Toast.LENGTH_SHORT).show();
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
    // method to load the repositories
    public void loadrepository(String url)
    {

    }


}