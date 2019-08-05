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
import wto.com.wto.Fragment.fragmentSide;
import wto.com.wto.Model.ProductModel;
import wto.com.wto.Utils.FragmentTransfer;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;
    @BindView(R.id.nav_view) NavigationView mDrawerLayout;
    List<ProductModel> listProduct;
    int typeShow = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        componentView();
    }

    public void componentView()
    {
        listProduct = new ArrayList<>();
        for(int i = 0; i < 7; i++)
        {
            listProduct.add(new ProductModel());
        }

        FragmentTransfer.callFragment(this, new fragmentHome(listProduct, typeShow), R.id.layoutHome);
        FragmentTransfer.callFragment(this, new fragmentSide(), R.id.layout_fragment_side_home);
    }

    @OnClick({R.id.imgMenu, R.id.txtCity, R.id.imgSearch})
    public void headerLayout(View view)
    {
        switch (view.getId())
        {
            case R.id.txtCity :
            {
                Intent intent = new Intent(HomeActivity.this, FilterActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.imgMenu :
            {
                mDrawer.openDrawer(mDrawerLayout);
                break;
            }
            case R.id.imgSearch :
            {
                Intent intent = new Intent(HomeActivity.this, FilterActivity.class);
                startActivity(intent);
                finish();
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
                Intent intent = new Intent(HomeActivity.this, NotificationActivity.class);
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
                Intent intent = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
}
