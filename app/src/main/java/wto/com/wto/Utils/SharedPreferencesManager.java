package wto.com.wto.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPreferencesManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "WTOPreference";

    public SharedPreferencesManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void saveStringToCache(String key, String data){

        editor.putString(key, data);
        editor.commit();
    }

    public void saveObjectToCache(String key, Object data){

        Gson gson = new Gson();
        String json = gson.toJson(data);
        editor.putString(key, json);
        editor.commit();
    }

    public String getStringFromCache(String key){

        String data = pref.getString(key, null);
        return data;
    }

    public SharedPreferences.Editor getEditor()
    {
        return editor;
    }

    public SharedPreferences getPreference()
    {
        return pref;
    }

    public void clearCache()
    {
        editor.clear();
        editor.commit();
    }
}
