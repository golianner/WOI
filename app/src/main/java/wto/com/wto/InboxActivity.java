package wto.com.wto;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Adapter.TabsPagerAdapter;
import wto.com.wto.Fragment.fragmentArchieve;
import wto.com.wto.Fragment.fragmentInbox;
import wto.com.wto.Fragment.fragmentSent;
import wto.com.wto.Fragment.fragmentTrash;
import wto.com.wto.Model.InboxModel;

public class InboxActivity extends AppCompatActivity {

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.pagerInbox) ViewPager viewPager;

    List<InboxModel> listInbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        ButterKnife.bind(this);
        fn_Initialization();
    }

    public void fn_Initialization() {
        listInbox = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listInbox.add(new InboxModel(i, "Bilardo", "Interview", "Please come to the office", "", "1 hour ago"));
        }

        setupViewPager(viewPager, listInbox);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager, List<InboxModel> _listInbox) {
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragmentInbox(_listInbox), "Inbox");
        adapter.addFragment(new fragmentSent(_listInbox), "Sent");
        adapter.addFragment(new fragmentArchieve(_listInbox), "Archieve");
        adapter.addFragment(new fragmentTrash(_listInbox), "Trash");
        viewPager.setAdapter(adapter);
    }

    @OnClick({R.id.imgBack, R.id.imgCancel})
    public void fnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.imgBack :
            {
                break;
            }
            case R.id.imgCancel :
            {
                break;
            }
        }
    }
}
