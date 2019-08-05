package wto.com.wto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wto.com.wto.Model.InboxModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/14/2017.
 */

public class InboxListAdapter extends BaseAdapter {

    List<InboxModel> listInbox;
    Context context;

    public InboxListAdapter(Context context, List<InboxModel> listInbox)
    {
        this.context = context;
        this.listInbox = listInbox;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        if (convertView == null)
        {
            view = new View(context);

            // get layout from mobile.xml
            view = inflater.inflate(R.layout.fragment_inbox_row, null);

        } else {
            view = (View) convertView;
        }

        ImageView img = (ImageView)view.findViewById(R.id.imgInbox);
        TextView txtName = (TextView)view.findViewById(R.id.txtNameInbox);
        TextView txtSubject = (TextView)view.findViewById(R.id.txtSubjectInbox);
        TextView txtDetail = (TextView)view.findViewById(R.id.txtDetailInbox);
        TextView txtLogs = (TextView)view.findViewById(R.id.txtLogsInbox);

        InboxModel model = listInbox.get(position);
        txtName.setText(model.getName());
        txtSubject.setText(model.getSubject());
        txtDetail.setText(model.getDetail());
        txtLogs.setText(model.getLogs());

        return view;
    }

    @Override
    public int getCount()
    {
        return listInbox.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listInbox.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
}

