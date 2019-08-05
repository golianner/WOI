package wto.com.wto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wto.com.wto.Model.ProductModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/9/2017.
 */

public class ListProductAdapter extends BaseAdapter {

    List<ProductModel> listProduct;
    Context context;

    public ListProductAdapter(Context context, List<ProductModel> listProduct)
    {
        this.context = context;
        this.listProduct = listProduct;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        if (convertView == null)
        {
            view = new View(context);

            // get layout from mobile.xml
            view = inflater.inflate(R.layout.fragment_list_product_row, null);

        } else {
            view = (View) convertView;
        }

        return view;
    }

    @Override
    public int getCount()
    {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
}
