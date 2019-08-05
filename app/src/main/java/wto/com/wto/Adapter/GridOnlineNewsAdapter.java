package wto.com.wto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wto.com.wto.Model.OnlineNewsModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/10/2017.
 */

public class GridOnlineNewsAdapter extends BaseAdapter {

    List<OnlineNewsModel> listNews;
    Context context;

    public GridOnlineNewsAdapter(Context context, List<OnlineNewsModel> listNews) {
        this.context = context;
        this.listNews = listNews;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        if (convertView == null) {
            view = new View(context);

            // get layout from mobile.xml
            view = inflater.inflate(R.layout.fragment_listrow_news, null);

        } else {
            view = (View) convertView;
        }

        OnlineNewsModel model = listNews.get(position);

        ImageView imgNews = (ImageView) view.findViewById(R.id.imgNews);
        TextView txtNewsTitle = (TextView) view.findViewById(R.id.txtNewsTitle);
        TextView txtNewsSource = (TextView) view.findViewById(R.id.txtNewsSource);

        imgNews.setImageResource(model.getImgNews());
        txtNewsTitle.setText(model.getTitleNews());
        txtNewsSource.setText(model.getSourceNews());

        return view;
    }

    @Override
    public int getCount() {
        return listNews.size();
    }

    @Override
    public Object getItem(int position) {
        return listNews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}