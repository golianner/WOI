package wto.com.wto;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Adapter.SplashImagePagerAdapter;

public class TutorialActivity extends AppCompatActivity {

    @BindView(R.id.pagerSplash)
    ViewPager viewPager;
    @BindView(R.id.indicatorSplash)
    CirclePageIndicator circlePageIndicator;
    @BindView(R.id.txtSkipSplash)
    TextView txtSkip;
    @BindView(R.id.btnGetStarted)
    Button btnGetStarted;

    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.splash1, R.drawable.splash2, R.drawable.splash3};
    private List<Integer> ImagesArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        ButterKnife.bind(this);

        fn_Initialization();
    }

    public void fn_Initialization()
    {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);

        SplashImagePagerAdapter adapter = new SplashImagePagerAdapter(this, ImagesArray);
        viewPager.setAdapter(adapter);
        circlePageIndicator.setViewPager(viewPager);
        final float density = getResources().getDisplayMetrics().density;

        circlePageIndicator.setRadius(5 * density);
        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        circlePageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                if(currentPage == IMAGES.length - 1)
                {
                    btnGetStarted.setVisibility(View.VISIBLE);
                    txtSkip.setVisibility(View.GONE);
                }
                else
                {
                    btnGetStarted.setVisibility(View.GONE);
                    txtSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    @OnClick({R.id.txtSkipSplash, R.id.btnGetStarted})
    public void fnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.txtSkipSplash :
            {
                Intent intent = new Intent(TutorialActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.btnGetStarted :
            {
                Intent intent = new Intent(TutorialActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
}
