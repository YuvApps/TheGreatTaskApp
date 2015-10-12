package com.example.YuvApps.MyTurn.Pages;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.YuvApps.MyTurn.MainActivity;
import com.example.YuvApps.MyTurn.R;

import java.util.Locale;

/**
 * Created by YuvApps on 25/09/15.
 */
public class MyPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        setupTabs();
    }

    private void setupTabs() {
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        actionBar.setDisplayShowTitleEnabled(true);
//
//        ActionBar.Tab tab1 = actionBar.newTab().setText("Filler").setTabListener(new SupportFragmentTabListener<FirstFragment>(R.id.flContainer,
//                this, "Filler", FillerFragment.class));
//        actionBar.addTab(tab1);
//        actionBar.selectTab(tab1);
//        ActionBar.Tab tab2 = actionBar.newTab().setText("Drainer").setTabListener(new SupportFragmentTabListener<FirstFragment>(R.id.flContainer,
//                this, "Drainer", DrainerFragment.class));
//        actionBar.addTab(tab2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        if(1 == 1) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_admin, menu);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(false);

        } else {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_logedin, menu);;

        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        switch (item.getItemId()) {
            case(R.id.action_change_lang):

                if(getBaseContext().getResources().getConfiguration().locale != Locale.forLanguageTag("iw") &&
                        getBaseContext().getResources().getConfiguration().locale != Locale.forLanguageTag("he") ) {
                    MainActivity.setLocale("iw", this, getClass(), getBaseContext().getResources());
                } else {
                    MainActivity.setLocale("en", this, getClass(), getBaseContext().getResources());
                }

                break;
            case(R.id.action_watch_account):

                Intent watchAccIntent = new Intent(getApplicationContext(), WatchAccActivity.class);
                Bundle bundle = getIntent().getBundleExtra("user_details");
                watchAccIntent.putExtra("user_details", bundle);
                startActivity(watchAccIntent);

                break;

            case(R.id.action_show_pers):

                Intent showPersIntent = new Intent(getApplicationContext(), ShwPersActivity.class);
                startActivity(showPersIntent);

                break;

            case(R.id.action_show_task):

                Intent showTaskIntent = new Intent(getApplicationContext(), ShwTaskActivity.class);
                startActivity(showTaskIntent);

                break;

            case(R.id.action_log_out):

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are You Sure You Want To LogOut?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("Cencel", dialogClickListener).show();

                break;

            default:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch(which) {
                case(DialogInterface.BUTTON_POSITIVE):
                    Intent signinIntent = new Intent(getApplicationContext(), SignInActivity.class);
                    startActivity(signinIntent);
                    break;
                case(DialogInterface.BUTTON_NEGATIVE):
                    break;
            }
        }
    };
}
