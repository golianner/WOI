package wto.com.wto;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Adapter.TabsPagerAdapter;
import wto.com.wto.Fragment.fragmentDeveloperNews;
import wto.com.wto.Fragment.fragmentOnlineNews;
import wto.com.wto.Fragment.fragmentSide;
import wto.com.wto.Model.OnlineNewsModel;
import wto.com.wto.Utils.FragmentTransfer;

public class NewsActivity extends AppCompatActivity {

    @BindView(R.id.pagerNews) ViewPager viewPager;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;
    @BindView(R.id.nav_view) NavigationView mDrawerLayout;


    List<OnlineNewsModel> listNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);
        fn_Intialization();
    }

    public void fn_Intialization()
    {
        listNews = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            listNews.add(new OnlineNewsModel(i, R.drawable.sample1, "Pesawat jatuh di ketinggian 3000 kaki dari laut", "Detik.com"));
        }

        setupViewPager(viewPager, listNews);
        tabLayout.setupWithViewPager(viewPager);

        FragmentTransfer.callFragment(this, new fragmentSide(), R.id.layout_fragment_side_news);
    }

    private void setupViewPager(ViewPager viewPager, List<OnlineNewsModel> _listNews) {
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragmentOnlineNews(_listNews), "Online News");
        adapter.addFragment(new fragmentDeveloperNews(_listNews), "Developer News");
        viewPager.setAdapter(adapter);
    }

    @OnClick({R.id.imgMenu, R.id.imgList})
    public void headerLayout(View view)
    {
        switch (view.getId())
        {
            case R.id.imgList :
            {
                break;
            }
            case R.id.imgMenu :
            {
                mDrawer.openDrawer(mDrawerLayout);
                break;
            }
        }
    }
}
