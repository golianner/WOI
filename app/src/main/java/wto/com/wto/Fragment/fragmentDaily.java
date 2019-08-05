package wto.com.wto.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import butterknife.ButterKnife;
import wto.com.wto.Adapter.GridOnlineNewsAdapter;
import wto.com.wto.Model.OnlineNewsModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/15/2017.
 */

public class fragmentDaily extends Fragment {

    @SuppressLint("ValidFragment")
    public fragmentDaily(List<String> listString) {
    }

    public fragmentDaily() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_daily, container, false);
        //Get Session

        ButterKnife.bind(this, view);

        fn_Initialization();

        return view;
    }

    public void fn_Initialization() {
    }
}
