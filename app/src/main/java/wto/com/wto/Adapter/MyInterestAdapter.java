package wto.com.wto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wto.com.wto.Model.MyInterestModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/10/2017.
 */

public class MyInterestAdapter extends BaseAdapter {

    List<MyInterestModel> listInterest;
    Context context;

    public MyInterestAdapter(Context context, List<MyInterestModel> listInterest)
    {
        this.context = context;
        this.listInterest = listInterest;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        if (convertView == null)
        {
            view = new View(context);

            // get layout from mobile.xml
            view = inflater.inflate(R.layout.fragment_grid_myinterest, null);

        } else {
            view = (View) convertView;
        }

        MyInterestModel model = listInterest.get(position);

        TextView txtInterest = (TextView) view.findViewById(R.id.txtMyInterest);
        ImageView imgInterest = (ImageView) view.findViewById(R.id.imgMyInterest);

        txtInterest.setText(model.getTitleInterest());
        imgInterest.setImageResource(model.getIconInterest());

        return view;
    }

    @Override
    public int getCount()
    {
        return listInterest.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listInterest.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
}
