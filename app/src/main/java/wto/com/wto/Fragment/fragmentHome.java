package wto.com.wto.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Adapter.BannerPromoPagerAdapter;
import wto.com.wto.Adapter.DeveloperPagerAdapter;
import wto.com.wto.Adapter.FilterImageAdapter;
import wto.com.wto.Adapter.GridProductAdapter;
import wto.com.wto.Adapter.ListProductAdapter;
import wto.com.wto.Asynctask.GetAllStoreAsynctask;
import wto.com.wto.Asynctask.GetListAllProductAsynctask;
import wto.com.wto.Asynctask.GetListProductByCityAsynctask;
import wto.com.wto.FilterActivity;
import wto.com.wto.Model.CityModel;
import wto.com.wto.Model.ProductModel;
import wto.com.wto.Model.StoreModel;
import wto.com.wto.R;
import wto.com.wto.Utils.GlobalUtils;
import wto.com.wto.Utils.SharedPreferencesManager;

/**
 * Created by Bilardo on 8/9/2017.
 */

public class fragmentHome extends Fragment {

    @BindView(R.id.listProduct) ListView listView;
    @BindView(R.id.viewPagerBanner) ViewPager viewPager;
    @BindView(R.id.viewPagerDeveloper) ViewPager viewPagerDeveloper;

    List<ProductModel> listProduct;
    List<StoreModel> listDeveloper;
    int typeShow;
    SharedPreferencesManager sharedPreferencesManager;

    @SuppressLint("ValidFragment")
    public fragmentHome(List<ProductModel> listProduct, int typeShow)
    {
        this.listProduct = listProduct;
        this.typeShow = typeShow;
    }

    public  fragmentHome(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sharedPreferencesManager = new SharedPreferencesManager(getActivity());
        //Get Session

        ButterKnife.bind(this, view);

        fn_Initialization();

        return view;
    }

    public void fn_Initialization()
    {
        listProduct = new Vector<>();
        listDeveloper = new Vector<>();
        try
        {
            String cityResponse = sharedPreferencesManager.getStringFromCache("city");
            Log.e("cityresponse = ", cityResponse);

            GetListProductByCityAsynctask getAllProduct = new GetListProductByCityAsynctask(getActivity(), cityResponse, "normal");
            GetAllStoreAsynctask getAllStoreAsynctask = new GetAllStoreAsynctask(getActivity());
            String response = getAllProduct.execute().get();
            String responseAllStore = getAllStoreAsynctask.execute().get();
            JSONObject object = new JSONObject(response);
            if(!object.getBoolean("error"))
            {
                Toast.makeText(getActivity(), object.getString("message"), Toast.LENGTH_SHORT).show();
            }
            else
            {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = new JSONArray(jsonObject.getString("result"));

                for(int i = 0; i < jsonArray.length(); i++)
                {
                    JSONObject product = new JSONObject(jsonArray.get(i).toString());
                    ProductModel productModel = new ProductModel(product.getString("id"), product.getString("name"), product.getString("image_arr"),
                            product.getString("detail"), product.getString("url_share"), product.getString("category_id"), product.getString("post_date"),
                            product.getString("end_date"), product.getString("rating"), product.getString("keyword"), product.getString("user_id"),
                            product.getString("type"), product.getString("category_name"), product.getString("insert_date"), product.getString("status"),
                            product.getString("store_id"), product.getString("price"), product.getString("discount"), product.getString("store_name"));
                    listProduct.add(productModel);
                }

                ListProductAdapter adapter = new ListProductAdapter(getActivity(), listProduct);
                listView.setAdapter(adapter);
                GlobalUtils.setListViewHeightBasedOnChildren(listView);

            }

            JSONObject objectStore = new JSONObject(responseAllStore);
            if(!objectStore.getString("success").equals("1"))
            {
                Toast.makeText(getActivity(), objectStore.getString("message"), Toast.LENGTH_SHORT).show();
            }
            else
            {
                JSONObject jsonObject = new JSONObject(responseAllStore);
                JSONArray jsonArray = new JSONArray(jsonObject.getString("result"));

                for(int i = 0; i < jsonArray.length(); i++)
                {
                    JSONObject store = new JSONObject(jsonArray.get(i).toString());
                    StoreModel storeModel = new StoreModel(store.getString("id"), store.getString("name"), store.getString("address"),
                            store.getString("geo_location"), store.getString("image"), store.getString("phone"), store.getString("open_hour"),
                            store.getString("close_hour"), store.getString("city_id"), store.getString("user_id"), store.getString("insert_date"),
                            store.getString("status"), store.getString("username"), store.getString("city_name"));
                    listDeveloper.add(storeModel);
                }

                DeveloperPagerAdapter adapterDeveloper = new DeveloperPagerAdapter(getActivity(), listDeveloper);
                viewPagerDeveloper.setAdapter(adapterDeveloper);
            }
        }
        catch (Exception e)
        {
            Log.e("error", e.toString());
        }
    }

}