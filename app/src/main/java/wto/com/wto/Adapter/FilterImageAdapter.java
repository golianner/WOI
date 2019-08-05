package wto.com.wto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import wto.com.wto.Model.CityModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/9/2017.
 */

public class FilterImageAdapter extends BaseAdapter {

    private Context context;
    private List<CityModel> listCity;

    public FilterImageAdapter(Context _context, List<CityModel> listCity)
    {
        context = _context;
        this.listCity = listCity;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (convertView == null)
        {
            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.gridrow_filter, null);

            ImageView imgLandmark = (ImageView)gridView.findViewById(R.id.imgLandmark);
            TextView txtLandmark = (TextView)gridView.findViewById(R.id.txtLandmark);
            CityModel cityModel = listCity.get(position);
            txtLandmark.setText(cityModel.getName());

            Picasso.with(context).load(cityModel.getIcon()).into(imgLandmark);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount()
    {
        return listCity.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listCity.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
}
