package wto.com.wto.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/19/2017.
 */

public class fragmentProfil extends Fragment {

    @SuppressLint("ValidFragment")
    public fragmentProfil(List<String> listString) {
    }

    public fragmentProfil() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        //Get Session

        ButterKnife.bind(this, view);

        fn_Initialization();

        return view;
    }

    public void fn_Initialization() {
    }
}

