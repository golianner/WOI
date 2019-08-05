package wto.com.wto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Fragment.fragmentHome;
import wto.com.wto.Fragment.fragmentUploadPromotion;
import wto.com.wto.Utils.FragmentTransfer;

public class UploadPromotionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_promotion);

        ButterKnife.bind(this);
        fn_Initiliazition();
    }

    public void fn_Initiliazition()
    {
        FragmentTransfer.callFragment(this, new fragmentUploadPromotion(), R.id.layoutUploadPromotion);
    }

    @OnClick({R.id.imageNotification, R.id.imageGoogleMaps, R.id.imageNews})
    public void footerLayout(View view)
    {
        switch (view.getId())
        {
            case R.id.imageNotification :
            {
                Intent intent = new Intent(UploadPromotionActivity.this, NotificationActivity.class);
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
                Intent intent = new Intent(UploadPromotionActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
}
