package wto.com.wto.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import wto.com.wto.Model.StoreModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/9/2017.
 */

public class DeveloperPagerAdapter extends PagerAdapter {

    public Context context;
    LayoutInflater mLayoutInflater;
    List<StoreModel> listStore;

    public DeveloperPagerAdapter(Context context, List<StoreModel> _listStore) {
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStore = _listStore;
    }

    @Override
    public int getCount() {
        return listStore.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.fragment_developer_listrow, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imgStore);
        TextView txtTitleStore = (TextView) itemView.findViewById(R.id.txtTitleStore);
        TextView txtDetail = (TextView) itemView.findViewById(R.id.txtDetail);
        StoreModel model = listStore.get(position);
        Picasso.with(context).load(model.getImage()).into(imageView);
        txtTitleStore.setText(model.getName());
        txtDetail.setText(model.getAddress());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
