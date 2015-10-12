package com.example.YuvApps.MyTurn;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.YuvApps.MyTurn.Pages.GroupActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent groupIntent = new Intent(getApplicationContext(), GroupActivity.class);
        startActivity(groupIntent);
    }

    public static void setLocale(String lang, Context cnxChanged, Class clsChanged, Resources res) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        res.updateConfiguration(configuration, res.getDisplayMetrics());
        Intent refresh = new Intent(cnxChanged, clsChanged);
        cnxChanged.startActivity(refresh);

    }
}
