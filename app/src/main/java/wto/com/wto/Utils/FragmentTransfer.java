package wto.com.wto.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bilardo on 8/8/2017.
 */

public class FragmentTransfer {

    public static void callFragment(AppCompatActivity act, Fragment fragment, int id)
    {
        FragmentTransaction ft = act.getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.commit();
    }

    public static void callFragment(FragmentActivity act, Fragment fragment, int id)
    {
        FragmentTransaction ft = act.getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.commit();
    }
}