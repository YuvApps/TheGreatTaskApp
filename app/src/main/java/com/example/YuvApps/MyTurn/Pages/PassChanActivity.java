package com.example.YuvApps.MyTurn.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.*;
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
public class PassChanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passchan);

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

    public void onPasswordChange(View view) {

        Bundle bundle = getIntent().getBundleExtra("user_details");
        String givenValue = bundle.getString("user_password");

        String oldValue = ((EditText)findViewById(R.id.passchan_old)).getText().toString();
        String newValue = ((EditText)findViewById(R.id.passchan_new)).getText().toString();
        String newValueConf = ((EditText)findViewById(R.id.passchan_confirm)).getText().toString();

        if(!oldValue.equals(givenValue)) {

            Toast.makeText(getApplicationContext(), getString(R.string.t_passchan_invldold), Toast.LENGTH_LONG).show();

        } else if(newValue.length() < 4) {

            Toast.makeText(getApplicationContext(), getString(R.string.t_signon_toshtpa), Toast.LENGTH_LONG).show();

        } else if (!newValue.equals(newValueConf)) {

            Toast.makeText(getApplicationContext(), getString(R.string.t_passchan_invldnew), Toast.LENGTH_LONG).show();

        } else {

            Intent watchAccIntent = new Intent(getApplicationContext(), WatchAccActivity.class);
            if(bundle != null) {

                String newName = bundle.getString("user_name");
                String newPassword = newValue;
                String newPhone = bundle.getString("user_phone");
                bundle.clear();

                bundle.putString("user_name", newName);
                bundle.putString("user_password", newPassword);
                bundle.putString("user_phone", newPhone);

            }

            watchAccIntent.putExtra("user_details", bundle);
            startActivity(watchAccIntent);
        }
    }
}
