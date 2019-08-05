package wto.com.wto.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.MyInterestActivity;
import wto.com.wto.ProfilActivity;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/8/2017.
 */

public class fragmentSide extends Fragment {

    @BindView(R.id.txtPromotionJlhInfo) TextView txtJlhPromotion;
    @BindView(R.id.txtInterestJlhInfo) TextView txtJlhInterest;
    @BindView(R.id.txtMessageJlhInfo) TextView txtJlhMessage;
    @BindView(R.id.txtIndoorMapsJlhInfo) TextView txtJlhIndoorMaps;

    @BindView(R.id.imgProfileSide) ImageView imgProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_side, container, false);
        //Get Session

        ButterKnife.bind(this, view);

        //Picasso.with(getContext()).load(sharedPreferencesManager.getStringFromCache("sider_image")).into(imgSider);

        return view;
    }

    @OnClick({R.id.layoutPromotions, R.id.layoutInterest, R.id.layoutMesssage, R.id.layoutIndoorMaps, R.id.layoutAccountSetting, R.id.layoutTerms,
            R.id.layoutPrivacy, R.id.layoutAboutUs, R.id.layoutLogOut, R.id.imgProfileSide})
    public void leftSideClick(View view)
    {
        switch (view.getId())
        {
            case R.id.imgProfileSide :
            {
                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
                break;
            }
            case R.id.layoutPromotions : {
                break;
            }
            case R.id.layoutInterest : {
                Intent intent = new Intent(getActivity(), MyInterestActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
                break;
            }
            case R.id.layoutMesssage : {
                break;
            }
            case R.id.layoutIndoorMaps : {
                break;
            }
            case R.id.layoutAccountSetting : {
                break;
            }
            case R.id.layoutTerms : {
                break;
            }
            case R.id.layoutPrivacy : {
                /*Intent intent = new Intent(getActivity(), SideActivity.class);
                intent.putExtra("header", "MARKETING TOOLS");
                startActivity(intent);*/
                break;
            }
            case R.id.layoutAboutUs : {
                break;
            }
            case R.id.layoutLogOut : {
                break;
            }
        }
    }

}
