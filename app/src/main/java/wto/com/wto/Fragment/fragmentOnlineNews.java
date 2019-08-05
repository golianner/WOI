package wto.com.wto.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wto.com.wto.Adapter.GridOnlineNewsAdapter;
import wto.com.wto.Model.OnlineNewsModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/10/2017.
 */

public class fragmentOnlineNews  extends Fragment {

    @BindView(R.id.gridOnlineNews) GridView gridView;

    List<OnlineNewsModel> listNews;

    @SuppressLint("ValidFragment")
    public fragmentOnlineNews(List<OnlineNewsModel> listNews) {
        this.listNews = listNews;
    }

    public fragmentOnlineNews() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_online_news, container, false);
        //Get Session

        ButterKnife.bind(this, view);

        fn_Initialization();

        return view;
    }

    public void fn_Initialization() {

        GridOnlineNewsAdapter adapter = new GridOnlineNewsAdapter(getActivity(), listNews);
        gridView.setAdapter(adapter);
    }
}

