package wto.com.wto;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Fragment.fragmentHome;
import wto.com.wto.Fragment.fragmentNotification;
import wto.com.wto.Fragment.fragmentSide;
import wto.com.wto.Model.NotificationModel;
import wto.com.wto.Utils.FragmentTransfer;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;
    @BindView(R.id.nav_view) NavigationView mDrawerLayout;
    @BindView(R.id.imgList) ImageView imgList;

    List<NotificationModel> listNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ButterKnife.bind(this);
        fn_Initialization();
    }

    public void fn_Initialization()
    {
        listNotification = new ArrayList<>();
        for(int i = 0; i < 7; i++)
        {
            listNotification.add(new NotificationModel(i, "", "", "", "", i));
        }

        FragmentTransfer.callFragment(this, new fragmentNotification(listNotification), R.id.layoutNotification);
        FragmentTransfer.callFragment(this, new fragmentSide(), R.id.layout_fragment_side_home);

        imgList.setVisibility(View.GONE);
    }

    @OnClick({R.id.imgMenu})
    public void headerLayout(View view)
    {
        switch (view.getId())
        {
            case R.id.imgMenu :
            {
                mDrawer.openDrawer(mDrawerLayout);
                break;
            }
        }
    }

    @OnClick({R.id.imageNotification, R.id.imageGoogleMaps, R.id.imageNews})
    public void footerLayout(View view)
    {
        switch (view.getId())
        {
            case R.id.imageNotification :
            {
                Intent intent = new Intent(NotificationActivity.this, NotificationActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.imageGoogleMaps :
            {
                break;
            }
            case R.id.imageNews :
            {
                Intent intent = new Intent(NotificationActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
}
