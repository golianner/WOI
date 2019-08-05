package wto.com.wto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Fragment.fragmentHome;
import wto.com.wto.Fragment.fragmentProfil;
import wto.com.wto.Utils.FragmentTransfer;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        ButterKnife.bind(this);
        fn_Initialization();
    }

    public void fn_Initialization()
    {
        FragmentTransfer.callFragment(this, new fragmentProfil(), R.id.layoutProfil);
    }

    @OnClick({R.id.imageNotification, R.id.imageGoogleMaps, R.id.imageNews})
    public void onClickFooter(View view)
    {
        switch (view.getId())
        {
            case R.id.imageNotification :
            {
                Intent intent = new Intent(ProfilActivity.this, NotificationActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.imageGoogleMaps :
            {
                break;
            }
            case R.id.imageNews :
            {
                Intent intent = new Intent(ProfilActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
}
