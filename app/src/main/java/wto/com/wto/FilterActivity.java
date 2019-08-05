package wto.com.wto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import wto.com.wto.Adapter.FilterImageAdapter;
import wto.com.wto.Asynctask.GetCityAsynctask;
import wto.com.wto.Model.CityModel;
import wto.com.wto.Utils.GlobalUtils;
import wto.com.wto.Utils.SharedPreferencesManager;

public class FilterActivity extends AppCompatActivity {

    @BindView(R.id.imgSearch) ImageView imgSearch;
    @BindView(R.id.edittxtSearch) EditText txtSearch;
    @BindView(R.id.imgCancel) ImageView imgCancel;
    @BindView(R.id.gridKota) GridView gridView;

    List<CityModel> listCity;
    SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        sharedPreferencesManager = new SharedPreferencesManager(this);
        ButterKnife.bind(this);

        fn_Initialization();
    }

    public void fn_Initialization()
    {
        try
        {
            listCity = new Vector<>();
            GetCityAsynctask getCityAsynctask = new GetCityAsynctask(this, gridView, listCity);
            getCityAsynctask.execute();
        }
        catch (Exception e)
        {
            Log.e("Filter Act", e.toString());
        }
    }

    @OnClick({R.id.imgSearch, R.id.imgCancel, R.id.btnApply})
    public void fnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.imgSearch :
            {
                imgSearch.setVisibility(View.GONE);
                imgCancel.setVisibility(View.VISIBLE);
                txtSearch.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.imgCancel :
            {
                imgSearch.setVisibility(View.VISIBLE);
                imgCancel.setVisibility(View.GONE);
                txtSearch.setVisibility(View.GONE);
                break;
            }
            case R.id.btnApply :
            {
                Intent intent = new Intent(FilterActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }

    @OnItemClick(R.id.gridKota)
    public void itemClickLandmark(int position)
    {
        CityModel cityModel = listCity.get(position);
        sharedPreferencesManager.saveObjectToCache("city", cityModel);
    }
}
