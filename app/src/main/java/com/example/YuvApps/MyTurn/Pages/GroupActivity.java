package com.example.YuvApps.MyTurn.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YuvApps.MyTurn.DataTypes.GroupDetails;
import com.example.YuvApps.MyTurn.MainActivity;
import com.example.YuvApps.MyTurn.R;

/**
 * Created by YuvApps on 25/09/15.
 */
public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
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

                MainActivity.setLang(this);

                break;

            case(android.R.id.home):
                Button btnEnter = (Button) findViewById(R.id.group_enter);
                EditText regGroup = (EditText) findViewById(R.id.group_group);
                TextView txtTitle = (TextView) findViewById(R.id.group_title);

                btnEnter.setVisibility(View.VISIBLE);
                regGroup.setHint(R.string.t_group_oldhint);
                regGroup.setText("");
                txtTitle.setText("Groups Screen");

                ActionBar mainActionBar = getSupportActionBar();
                mainActionBar.setDisplayHomeAsUpEnabled(false);
                mainActionBar.setDisplayShowHomeEnabled(false);

                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void setLocale(String lang) {

    }

    public void onGroup(View view) {

        String groupName = ((EditText) findViewById(R.id.group_group)).getText().toString();

        // Add Check in DataBase

        if (groupName.isEmpty()) {

            Toast.makeText(getApplicationContext(), R.string.t_group_noname, Toast.LENGTH_LONG).show();

        } else {

            GroupDetails mainGroup = GroupDetails.getGroupLineByName(groupName);

            if (mainGroup != null) {

                MainActivity.setNewLocale(getApplicationContext(), getResources());
                Intent signInIntent = new Intent(getApplicationContext(), SignInActivity.class);
                signInIntent.putExtra("group_name", mainGroup.getName());
                signInIntent.putExtra("group_users_table", mainGroup.getUsersTableName());
                signInIntent.putExtra("group_tasks_table", mainGroup.getTasksTasleName());
                startActivity(signInIntent);

            } else {

                Toast.makeText(getApplicationContext(), R.string.t_group_invldna, Toast.LENGTH_LONG).show();

            }
        }
    }

    public void onNewGroup(View view) {

        Button btnEnter = (Button) findViewById(R.id.group_enter);
        EditText regGroup = (EditText) findViewById(R.id.group_group);
        TextView txtTitle = (TextView) findViewById(R.id.group_title);

        if (btnEnter.isShown()) {

            btnEnter.setVisibility(View.INVISIBLE);
            regGroup.setHint(R.string.group_create);
            regGroup.setText("");
            txtTitle.setText("Create Group Screen");

            ActionBar mainActionBar = getSupportActionBar();
            mainActionBar.setDisplayHomeAsUpEnabled(true);
            mainActionBar.setDisplayShowHomeEnabled(true);

        } else {

            if (regGroup.getText().length() == 0) {

                Toast.makeText(getApplicationContext(), R.string.t_group_noname, Toast.LENGTH_LONG).show();

            } else {

                GroupDetails createdGroup = new GroupDetails(regGroup.getText().toString());

                if(!createdGroup.createTables()) {

                    Toast.makeText(getApplicationContext(), R.string.t_group_taken, Toast.LENGTH_LONG).show();

                } else {

                    Intent signOnIntent = new Intent(getApplicationContext(), SignOnActivity.class);
                    signOnIntent.putExtra("group_name", createdGroup.getName());
                    signOnIntent.putExtra("group_users_table", createdGroup.getUsersTableName());
                    signOnIntent.putExtra("group_tasks_table", createdGroup.getTasksTasleName());
                    startActivity(signOnIntent);

                }
            }

        }

    }
}
