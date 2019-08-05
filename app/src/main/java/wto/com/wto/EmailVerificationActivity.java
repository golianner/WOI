package wto.com.wto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmailVerificationActivity extends AppCompatActivity {

    @BindView(R.id.btnOk) Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnOk)
    public void fnClick()
    {
        Intent intent = new Intent(EmailVerificationActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
