package com.example.YuvApps.MyTurn.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.YuvApps.MyTurn.R;

/**
 * Created by YuvApps on 25/09/15.
 */
public class SignOnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signon);

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

    public void onSignOn(View view) {

        String enteredName = ((EditText) findViewById(R.id.signon_name)).getText().toString();
        String enteredPass = ((EditText) findViewById(R.id.signon_password)).getText().toString();
        String enteredConfig = ((EditText) findViewById(R.id.signon_passconfig)).getText().toString();
        String enteredPhone = ((EditText) findViewById(R.id.signon_phone)).getText().toString();


        if(enteredName.isEmpty()) {

            Toast.makeText(getApplicationContext(), R.string.t_signon_noname, Toast.LENGTH_LONG).show();

        } else if(enteredPass.isEmpty()) {

            Toast.makeText(getApplicationContext(), R.string.t_signon_nopass, Toast.LENGTH_LONG).show();

        } else if(enteredPass.length() < 4) {

            Toast.makeText(getApplicationContext(), R.string.t_signon_toshtpa, Toast.LENGTH_LONG).show();

        } else if(enteredConfig.isEmpty()) {

            Toast.makeText(getApplicationContext(), R.string.t_signon_noconf, Toast.LENGTH_LONG).show();

        } else if (!enteredConfig.equals(enteredPass)) {

            Toast.makeText(getApplicationContext(), R.string.t_signon_invldco, Toast.LENGTH_LONG).show();

        } else if(enteredPhone.isEmpty()) {

            Toast.makeText(getApplicationContext(), R.string.t_signon_nophne, Toast.LENGTH_LONG).show();

        } else if(enteredPhone.length() < 9) {

            Toast.makeText(getApplicationContext(), R.string.t_signon_invldph, Toast.LENGTH_LONG).show();

        } else {

            Intent myPageIntent = new Intent(getApplicationContext(), MyPageActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("user_name", enteredName);
            bundle.putString("user_password", enteredPass);
            bundle.putString("user_phone", enteredPhone);
            myPageIntent.putExtra("user_details", bundle);
            startActivity(myPageIntent);

        }
    }
}
