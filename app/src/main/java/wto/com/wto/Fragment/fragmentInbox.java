package wto.com.wto.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import wto.com.wto.Adapter.InboxListAdapter;
import wto.com.wto.DetailInboxActivity;
import wto.com.wto.Model.InboxModel;
import wto.com.wto.R;

/**
 * Created by Bilardo on 8/14/2017.
 */

public class fragmentInbox extends Fragment {

    @BindView(R.id.gridDeveloperNews) GridView gridView;

    List<InboxModel> listInbox;

    @SuppressLint("ValidFragment")
    public fragmentInbox(List<InboxModel> listInbox) {
        this.listInbox = listInbox;
    }

    public fragmentInbox() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        //Get Session

        ButterKnife.bind(this, view);

        fn_Initialization();

        return view;
    }

    public void fn_Initialization() {

        InboxListAdapter adapter = new InboxListAdapter(getActivity(), listInbox);
        gridView.setAdapter(adapter);
    }

    @OnItemClick(R.id.gridDeveloperNews)
    public void fnOnItemClick(int position)
    {
        InboxModel model = listInbox.get(position);
        Intent intent = new Intent(getActivity(), DetailInboxActivity.class);
        getActivity().startActivity(intent);
        getActivity().finish();
    }
}
