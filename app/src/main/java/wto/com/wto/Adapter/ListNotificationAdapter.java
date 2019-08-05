package wto.com.wto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wto.com.wto.Model.NotificationModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/16/2017.
 */

public class ListNotificationAdapter extends BaseAdapter {

    List<NotificationModel> listNotification; //--> nanti string diganti jadi product model
    Context context;

    public ListNotificationAdapter(Context context, List<NotificationModel> listNotification)
    {
        this.context = context;
        this.listNotification = listNotification;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        if (convertView == null)
        {
            view = new View(context);

            // get layout from mobile.xml
            view = inflater.inflate(R.layout.fragment_listrow_notification, null);

        } else {
            view = (View) convertView;
        }

        ImageView imgProfile = (ImageView)view.findViewById(R.id.imgProfileNotification);
        TextView txtName = (TextView)view.findViewById(R.id.txtNameNotification);
        TextView txtDetail = (TextView)view.findViewById(R.id.txtDetailNotification);
        TextView txtTime = (TextView)view.findViewById(R.id.txtTimeNotification);
        ImageView imgIcon = (ImageView)view.findViewById(R.id.imgIconNotification);
        NotificationModel model = listNotification.get(position);



        return view;
    }

    @Override
    public int getCount()
    {
        return listNotification.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listNotification.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
}

