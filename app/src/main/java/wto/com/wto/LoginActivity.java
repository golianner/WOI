package wto.com.wto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edittxtEmail) EditText txtUsername;
    @BindView(R.id.edittxtPassword) EditText txtPassword;
    @BindView(R.id.txtError) TextView txtError;
    @BindView(R.id.txtForgotPassword) TextView txtForgotPassword;
    @BindView(R.id.imgFacebook) ImageView imgFb;
    @BindView(R.id.imgGoogle) ImageView imgGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        fn_Initialization();
    }

    public void fn_Initialization()
    {
        ProgressDialog progressDialog = ProgressDialog.show(this, "", "Please wait ...", true);
        progressDialog.setCancelable(true);

        progressDialog.dismiss();
    }

    @OnClick({R.id.btnLogin, R.id.txtRegister, R.id.txtForgotPassword, R.id.imgFacebook, R.id.imgGoogle})
    public void fn_Click(View view)
    {
        switch (view.getId())
        {
            case R.id.btnLogin :
            {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.txtRegister :
            {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.txtForgotPassword :
            {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.imgFacebook :
            {
                break;
            }
            case R.id.imgGoogle :
            {
                break;
            }
        }

    }

    public void fn_LoginProcess()
    {
        if(txtUsername.getText().equals(""))
        {
            txtError.setText("Please input your username!");
            txtError.setVisibility(View.VISIBLE);
        }
        else if(txtPassword.getText().equals(""))
        {
            txtError.setText("Please input your password!");
            txtError.setVisibility(View.VISIBLE);
        }
        else
        {

        }
    }
}
