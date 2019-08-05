package wto.com.wto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends AppCompatActivity {

    @BindView(R.id.btnSubmit) Button btnSubmit;
    @BindView(R.id.txtAlreadyRemember) TextView txtAlreaedyRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSubmit, R.id.txtAlreadyRemember})
    public void fnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnSubmit :
            {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.txtAlreadyRemember :
            {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
}
