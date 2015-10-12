package com.example.YuvApps.MyTurn.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.YuvApps.MyTurn.R;

/**
 * Created by YuvApps on 25/09/15.
 */
public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        ActionBar mainActionBar = getSupportActionBar();
        mainActionBar.setDisplayHomeAsUpEnabled(true);
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

    public void onSignIn(View view) {

        String enteredName = ((EditText) findViewById(R.id.signin_name)).getText().toString();
        int enteredPass = Integer.parseInt(((EditText) findViewById(R.id.signin_password)).getText().toString());

        Intent myPageIntent = new Intent(getApplicationContext(), MyPageActivity.class);
        startActivity(myPageIntent);
    }
}
