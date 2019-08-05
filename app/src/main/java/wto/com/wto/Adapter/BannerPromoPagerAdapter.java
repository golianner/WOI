package wto.com.wto.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import wto.com.wto.R;

/**
 * Created by Bilardo on 8/9/2017.
 */

public class BannerPromoPagerAdapter extends PagerAdapter {

    int[] mResources = {
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
    };

    public Context context;
    LayoutInflater mLayoutInflater;

    public BannerPromoPagerAdapter(Context context) {
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.fragment_banner_promo, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imgBannerPromo);
        imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
