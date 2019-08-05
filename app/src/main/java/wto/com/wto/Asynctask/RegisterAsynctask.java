package wto.com.wto.Asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import wto.com.wto.FilterActivity;
import wto.com.wto.HomeActivity;
import wto.com.wto.RegisterActivity;
import wto.com.wto.Utils.BaseUrl;

/**
 * Created by Bilardo on 8/7/2017.
 */

public class RegisterAsynctask extends AsyncTask<String, Void, String> {

    ProgressDialog progressDialog;
    Activity act;
    String username, password, email, title;

    public RegisterAsynctask(Activity _act, String _username, String _password, String _email, String _title)
    {
        act = _act;
        progressDialog = new ProgressDialog(act);
        username = _username;
        password = _password;
        email = _email;
        title = _title;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.setMessage("Please wait ...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            //post Data from API
            RequestBody body = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("email", email)
                    .addFormDataPart("name", username)
                    .addFormDataPart("password", password)
                    .addFormDataPart("repassword", password)
                    .addFormDataPart("gender", (title.equals("Mr") ? "male" : "female"))
                    .build();

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(BaseUrl.REGISTER)
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
        try {
            JSONObject object = new JSONObject(result);
            if(!object.getBoolean("error"))
            {
                Toast.makeText(act, object.getString("message"), Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent intent = new Intent(act, FilterActivity.class);
                act.startActivity(intent);
                act.finish();
            }
        } catch (JSONException e) {
            Log.e("Reg Async", e.toString());
        }

    }
}
