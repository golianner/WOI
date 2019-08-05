package wto.com.wto;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Adapter.TabsPagerAdapter;
import wto.com.wto.Fragment.fragmentArchieve;
import wto.com.wto.Fragment.fragmentDaily;
import wto.com.wto.Fragment.fragmentInbox;
import wto.com.wto.Fragment.fragmentSent;
import wto.com.wto.Fragment.fragmentTrash;
import wto.com.wto.Fragment.fragmentWeekly;
import wto.com.wto.Model.InboxModel;

public class OverviewStatistikActivity extends AppCompatActivity {

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.pagerOverviewStatistic) ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_statistik);

        ButterKnife.bind(this);
        fn_Initialization();
    }

    public void fn_Initialization()
    {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragmentWeekly(), "Weekly");
        adapter.addFragment(new fragmentDaily(), "Daily");
        viewPager.setAdapter(adapter);
    }

    @OnClick(R.id.imgBack)
    public void fnClick()
    {
        Intent intent = new Intent(OverviewStatistikActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
