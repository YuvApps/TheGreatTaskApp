package com.example.YuvApps.MyTurn.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.*;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YuvApps.MyTurn.R;

/**
 * Created by YuvApps on 25/09/15.
 */
public class CustomizeActivity extends AppCompatActivity {

    private String givenValue = "";
    private String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            type = bundle.getString("Type");
        }

        bundle = getIntent().getBundleExtra("user_details");

        if(bundle != null) {
            if(type.equals("Name")) {
                this.givenValue = bundle.getString("user_name");
            } else {
                this.givenValue = bundle.getString("user_phone");
                ((EditText)findViewById(R.id.customize_old)).setInputType(InputType.TYPE_CLASS_PHONE);
                ((EditText)findViewById(R.id.customize_new)).setInputType(InputType.TYPE_CLASS_PHONE);
            }

        }

        ((TextView)findViewById(R.id.customize_title)).setText(getString(R.string.customize_title) + " " + type);
        ((EditText)findViewById(R.id.customize_old)).setHint(getString(R.string.customize_old) + " " + type);
        ((EditText)findViewById(R.id.customize_new)).setHint(getString(R.string.customize_new) + " " + type);
        ((Button)findViewById(R.id.customize_btn)).setText(getString(R.string.customize_btn) + " " + type);

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

    public void onDataChange(View view) {

        String newValue = ((EditText)findViewById(R.id.customize_new)).getText().toString();
        String oldValue = ((EditText)findViewById(R.id.customize_old)).getText().toString();

        if(!oldValue.equals(this.givenValue)) {

            Toast.makeText(getApplicationContext(), getString(R.string.t_customize_invldold) + " " +type, Toast.LENGTH_LONG).show();

        } else {

            Intent watchAccIntent = new Intent(getApplicationContext(), WatchAccActivity.class);
            Bundle bundle = getIntent().getBundleExtra("user_details");
            if(bundle != null) {

                String newName = bundle.getString("user_name");
                String newPassword = bundle.getString("user_password");
                String newPhone = bundle.getString("user_phone");
                bundle.clear();

                if (type.equals("Name")) {
                    newName = newValue;
                } else if (type.equals("Phone")) {
                    newPhone = newValue;
                }

                bundle.putString("user_name", newName);
                bundle.putString("user_password", newPassword);
                bundle.putString("user_phone", newPhone);

            }

            watchAccIntent.putExtra("user_details", bundle);
            startActivity(watchAccIntent);
        }

    }
}
