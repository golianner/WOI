package wto.com.wto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailInboxActivity extends AppCompatActivity {

    @BindView(R.id.imgProfileInbox) ImageView imgProfil;
    @BindView(R.id.txtNameInbox) TextView txtName;
    @BindView(R.id.txtSubjectInbox) TextView txtSubject;
    @BindView(R.id.txtDetailInbox) TextView txtDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_inbox);

        ButterKnife.bind(this);
        fn_Initialization();
    }

    public void fn_Initialization()
    {
        txtName.setText("Bilardo");
        txtSubject.setText("Hello World");
        txtDetail.setText("Lorem ipsum dolor sit amet, vel nostro expetendis et, no agam case liberavisse mea. Duis tation vocibus sea ut, vix liber dolore causae in, in elit consul interesset his. Et ornatus vivendum scriptorem eam, wisi argumentum at his. Porro mnesarchum eu quo, et sit augue blandit assentior, at iusto primis qui.\n" +
                "\n" +
                "Nam ea wisi dolore eligendi, eam cu etiam propriae, partem reprehendunt est cu. Dicta constituam id vim, vide quaerendum te est, qui cu purto quando vituperata. Ius placerat delicata argumentum at, minim utroque eam ad. In offendit conceptam his, suas detraxit eu duo. Ea lorem delicata vim, pro eros signiferumque ut. Et iudico perfecto consulatu quo.");
    }

    @OnClick({R.id.imgBack, R.id.layoutReply, R.id.layoutArchieve, R.id.layoutTrash})
    public void fnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.imgBack :
            {
                Intent intent = new Intent(DetailInboxActivity.this, InboxActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.layoutReply : {
                break;
            }
            case R.id.layoutArchieve :
            {
                break;
            }
            case R.id.layoutTrash :
            {
                break;
            }
        }
    }
}
