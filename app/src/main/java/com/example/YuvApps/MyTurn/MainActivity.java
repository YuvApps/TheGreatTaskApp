package com.example.YuvApps.MyTurn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.YuvApps.MyTurn.Pages.GroupActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static String strLanguage;

    private static String getLang(Context currContext) {

        SharedPreferences preferences = currContext.getSharedPreferences(currContext.getString(R.string.pref_lang_key), Context.MODE_WORLD_WRITEABLE);

        if (!preferences.contains("KeyLang")) {
            return null;
        }

        String currLang = preferences.getString("KeyLang", "en");

        return currLang;
    }

    public static void setLang(Context currContext) {

        if (strLanguage.isEmpty()) {
            getLang(currContext);
        }

        if (strLanguage.equals("en")) {
            strLanguage = "iw";
        } else {
            strLanguage = "en";
        }

        currContext.getSharedPreferences(currContext.getString(R.string.pref_lang_key), Context.MODE_WORLD_WRITEABLE)
                .edit().putString("KeyLang", strLanguage).commit();

        setLocale(currContext, currContext.getClass(), currContext.getResources());
    }

    private static void setLocale(Context cnxChanged, Class clsChanged, Resources res) {

        if (strLanguage == null) {
            MainActivity.getLang(cnxChanged);
        }

        Locale locale = new Locale(strLanguage);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        res.updateConfiguration(configuration, res.getDisplayMetrics());
        Intent refresh = new Intent(cnxChanged, clsChanged);
        cnxChanged.startActivity(refresh);
    }

    public static void setNewLocale(Context cnxChanged, Resources resources) {

        if (strLanguage == null) {
            MainActivity.getLang(cnxChanged);
        }

        Locale locale = new Locale(strLanguage);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNewLocale(getApplicationContext(), getResources());
        Intent groupIntent = new Intent(getApplicationContext(), GroupActivity.class);
        startActivity(groupIntent);
    }
}