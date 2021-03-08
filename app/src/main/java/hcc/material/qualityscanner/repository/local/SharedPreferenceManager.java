package hcc.material.qualityscanner.repository.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class SharedPreferenceManager {
    private Context context;

    private SharedPreferences sharedUserPreferences;
    private SharedPreferences sharedNotificationPreferences;

    public SharedPreferenceManager(Context context) {
        this.context = context;

        if (sharedUserPreferences == null) {
            sharedUserPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        }

        if (sharedNotificationPreferences == null) {
            sharedNotificationPreferences = context.getSharedPreferences("notification", Context.MODE_PRIVATE);
        }
    }



}
