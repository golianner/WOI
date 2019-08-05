package wto.com.wto.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wto.com.wto.Adapter.BannerPromoPagerAdapter;
import wto.com.wto.Adapter.GridProductAdapter;
import wto.com.wto.Adapter.ListNotificationAdapter;
import wto.com.wto.Adapter.ListProductAdapter;
import wto.com.wto.Model.NotificationModel;
import wto.com.wto.R;
import wto.com.wto.Utils.GlobalUtils;

/**
 * Created by Bilardo on 8/16/2017.
 */

public class fragmentNotification extends Fragment {

    @BindView(R.id.listNotification) ListView listView;

    List<NotificationModel> listNotification;

    @SuppressLint("ValidFragment")
    public fragmentNotification(List<NotificationModel> listNotification)
    {
        this.listNotification = listNotification;
    }

    public  fragmentNotification(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        //Get Session

        ButterKnife.bind(this, view);

        fn_Initialization();

        return view;
    }

    public void fn_Initialization()
    {
        /*listProduct = new ArrayList<>();
        for(int i = 0; i < 7; i++)
        {
            listProduct.add("");
        }*/

        ListNotificationAdapter adapter = new ListNotificationAdapter(getActivity(), listNotification);
        listView.setAdapter(adapter);
        GlobalUtils.setListViewHeightBasedOnChildren(listView);

    }

}
