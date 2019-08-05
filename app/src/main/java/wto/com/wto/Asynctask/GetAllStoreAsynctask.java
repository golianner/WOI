package wto.com.wto.Asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import wto.com.wto.Utils.BaseUrl;

/**
 * Created by Bilardo on 8/7/2017.
 */

public class GetAllStoreAsynctask extends AsyncTask<String, Void, String> {

    ProgressDialog progressDialog;
    Activity act;

    public GetAllStoreAsynctask(Activity _act)
    {
        act = _act;
        progressDialog = new ProgressDialog(act);
    }

    @Override
    protected void onPreExecute() {
        progressDialog.setMessage("Please wait ...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(BaseUrl.GET_ALL_STORE)
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
    }
}
