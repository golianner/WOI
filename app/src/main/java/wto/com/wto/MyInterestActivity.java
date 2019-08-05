package wto.com.wto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wto.com.wto.Adapter.MyInterestAdapter;
import wto.com.wto.Model.MyInterestModel;
import wto.com.wto.Utils.GlobalUtils;

public class MyInterestActivity extends AppCompatActivity {

    @BindView(R.id.gridInterest) GridView gridInterest;
    @BindView(R.id.btnApply) Button btnApply;

    List<MyInterestModel> listInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_interest);

        ButterKnife.bind(this);

        fn_Initialization();
    }

    public void fn_Initialization()
    {
        listInterest = new ArrayList<>();
        for(int i = 0; i < 8; i++ )
        {
            MyInterestModel model = new MyInterestModel(i, "Kosmetik", R.drawable.interest2);
            listInterest.add(model);
        }

        MyInterestAdapter adapter = new MyInterestAdapter(this, listInterest);
        gridInterest.setAdapter(adapter);
        GlobalUtils.setListViewHeightBasedOnChildren(gridInterest);
    }

    @OnClick(R.id.btnApply)
    public void fnClick()
    {
        Intent intent = new Intent(MyInterestActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
