package com.example.YuvApps.MyTurn.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.YuvApps.MyTurn.R;

/**
 * Created by YuvApps on 25/09/15.
 */
public class WatchAccActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchacc);

        ActionBar mainActionBar = getSupportActionBar();
        mainActionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getBundleExtra("user_details");

        if(bundle != null) {
            ((TextView)findViewById(R.id.watchacc_nametext)).setText(bundle.getString("user_name"));
            ((TextView)findViewById(R.id.watchacc_passwordtext)).setText(bundle.getString("user_password"));
            ((TextView)findViewById(R.id.watchacc_phonetext)).setText(bundle.getString("user_phone"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_simple, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        switch (item.getItemId()) {
            case(R.id.action_change_lang):
                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void onNameChange(View view) {
        Intent customizeIntent = new Intent(getApplicationContext(), CustomizeActivity.class);
        customizeIntent.putExtra("Type", "Name");
        Bundle bundle = getIntent().getBundleExtra("user_details");
        customizeIntent.putExtra("user_details", bundle);
        startActivity(customizeIntent);
    }

    public void onPasswordChange(View view) {
        Intent passChanIntent = new Intent(getApplicationContext(), PassChanActivity.class);
        Bundle bundle = getIntent().getBundleExtra("user_details");
        passChanIntent.putExtra("user_details", bundle);
        startActivity(passChanIntent);
    }

    public void onPhoneChange(View view) {
        Intent customizeIntent = new Intent(getApplicationContext(), CustomizeActivity.class);
        customizeIntent.putExtra("Type", "Phone");
        Bundle bundle = getIntent().getBundleExtra("user_details");
        customizeIntent.putExtra("user_details", bundle);
        startActivity(customizeIntent);
    }

    public void onDone(View view) {
        Intent myPageIntent = new Intent(getApplicationContext(), MyPageActivity.class);
        Bundle bundle = getIntent().getBundleExtra("user_details");
        myPageIntent.putExtra("user_details", bundle);
        startActivity(myPageIntent);
    }
}
