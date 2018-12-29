package kr.tjeit.startactivityforresulttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private android.widget.TextView mainTxt;
    private android.widget.Button nameInputBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindviews();
        setupEvents();
        setvalues();
    }

    @Override
    public void setupEvents() {

        nameInputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, EditUserInfoActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void setvalues() {

    }

    @Override
    public void bindviews() {

        this.nameInputBtn = (Button) findViewById(R.id.nameInputBtn);
        this.mainTxt = (TextView) findViewById(R.id.mainTxt);

    }
}
