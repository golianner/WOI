package wto.com.wto.Asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import wto.com.wto.Adapter.ListProductAdapter;
import wto.com.wto.Model.ProductModel;
import wto.com.wto.Utils.BaseUrl;
import wto.com.wto.Utils.GlobalUtils;

/**
 * Created by Bilardo on 8/7/2017.
 */

public class GetListProductByCityAsynctask extends AsyncTask<String, Void, String> {

    ProgressDialog progressDialog;
    Activity act;
    String city;
    String type;

    public GetListProductByCityAsynctask(Activity _act, String _city, String _type)
    {
        act = _act;
        progressDialog = new ProgressDialog(act);
        try
        {
            JSONObject jsonObject = new JSONObject(_city);
            city = jsonObject.getString("name");
        }
        catch (Exception e)
        {
            Log.e("Product Async", e.toString());
        }
        type = _type;
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

            RequestBody body;
            if(type.equals(""))
            {
                body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("city", city)
                        .build();
            }
            else
            {
                body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("city", city)
                        .addFormDataPart("type", type)
                        .build();
            }

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(BaseUrl.GET_ALL_PRODUCT_BY_CITY)
                    .method("POST", RequestBody.create(null, new byte[0]))
                    .post(body)
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

    }
}
