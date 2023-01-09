package net.osmtracker;

import android.app.Application;
import android.content.res.Resources;
import android.os.Build;


import com.yariksoffice.lingver.Lingver;
import com.yariksoffice.lingver.store.PreferenceLocaleStore;

import java.util.Locale;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Locale language = new Locale("xx", "Cap");
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        } else {
            //noinspection deprecation
            locale = Resources.getSystem().getConfiguration().locale;
        }
        Lingver.init(this, new PreferenceLocaleStore(this, language));
    }
}
