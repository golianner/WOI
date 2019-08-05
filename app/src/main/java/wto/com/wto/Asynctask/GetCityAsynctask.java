package wto.com.wto.Asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wto.com.wto.Adapter.FilterImageAdapter;
import wto.com.wto.Model.CityModel;
import wto.com.wto.Utils.BaseUrl;
import wto.com.wto.Utils.GlobalUtils;

/**
 * Created by Bilardo on 8/7/2017.
 */

public class GetCityAsynctask extends AsyncTask<String, String, String> {

    ProgressDialog progressDialog;
    Activity act;
    GridView gridView;
    List<CityModel> listCity;

    public GetCityAsynctask(Activity _act, GridView gridView, List<CityModel> listCity)
    {
        act = _act;
        progressDialog = new ProgressDialog(act);
        this.gridView = gridView;
        this.listCity = listCity;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.setMessage("Please wait ...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            //get Data from API
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(BaseUrl.GET_CITY)
                    .get()
                    .build();

            Response response = client.newCall(request).execute();
            if (response.isSuccessful())
                return response.body().toString();
            else
                return "Download Failed";
        }
        catch (IOException e)
        {
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        if(progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }

        //Load Data

        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("result"));

            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject city = new JSONObject(jsonArray.get(i).toString());
                CityModel cityModel = new CityModel(city.getString("id"), city.getString("name"), city.getString("icon"),
                        city.getString("province"), city.getString("status"));
                listCity.add(cityModel);
            }

            FilterImageAdapter adapter = new FilterImageAdapter(act, listCity);
            gridView.setAdapter(adapter);
            GlobalUtils.setListViewHeightBasedOnChildren(gridView);
        } catch (JSONException e) {
            Log.e("City async", e.toString());
        }

    }
}
