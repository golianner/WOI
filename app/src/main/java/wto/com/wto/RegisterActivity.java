package wto.com.wto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Asynctask.RegisterAsynctask;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.spinnerTitleName) Spinner spinnerTitleName;
    @BindView(R.id.edittxtName) EditText txtName;
    @BindView(R.id.edittxtEmailRegister) EditText txtEmail;
    @BindView(R.id.edittxtPasswordRegister) EditText txtPassword;
    @BindView(R.id.edittxtConfirmPasswordRegister) EditText txtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
    }

    public void fn_SaveData()
    {
        //Save Data into db
        if(txtName.getText().length() == 0)
        {
            Toast.makeText(this, "Please input your name!", Toast.LENGTH_LONG).show();
        }
        else if(txtPassword.getText().length() == 0)
        {
            Toast.makeText(this, "Please input your Password!", Toast.LENGTH_LONG).show();
        }
        else if(txtConfirmPassword.getText().length() == 0)
        {
            Toast.makeText(this, "Please input your Confirm Password!", Toast.LENGTH_LONG).show();
        }
        else if(txtEmail.getText().length() == 0)
        {
            Toast.makeText(this, "Please input your Email!", Toast.LENGTH_LONG).show();
        }
        else if(!txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString()))
        {
            Toast.makeText(this, "Please input your name", Toast.LENGTH_LONG).show();
        }
        else
        {
            RegisterAsynctask registerAsynctask = new RegisterAsynctask(this, txtName.getText().toString(), txtPassword.getText().toString(),
                    txtEmail.getText().toString(), spinnerTitleName.getSelectedItem().toString());
            registerAsynctask.execute();
        }
    }

    @OnClick(R.id.btnSignup)
    public void signUp()
    {
        fn_SaveData();
    }
}
