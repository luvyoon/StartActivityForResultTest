package kr.tjeit.startactivityforresulttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    final static int REQUEST_FOR_USER_NAME = 1000;
    final static int REQUEST_FOR_USER_BIRTHDAY = 1001;
    final static int REQUEST_FOR_PICTURE_GALLERY = 1002;

    private android.widget.TextView mainTxt;
    private android.widget.Button nameInputBtn;
    private TextView birthdayTxt;
    private Button birthdayBtn;
    private android.widget.ImageView profileImg;
    private Button cameraBtn;
    private Button galleryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindviews();
        setupEvents();
        setvalues();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_FOR_USER_NAME) {
//            사용자 이름을 입력받아온 경우

            if (resultCode == RESULT_OK){

                String userName = data.getStringExtra("이름");
                mainTxt.setText(userName);

            }
            Toast.makeText(mContext, "사용자이름", Toast.LENGTH_SHORT).show();


        } 
        else  if (requestCode == REQUEST_FOR_USER_BIRTHDAY){

            Toast.makeText(mContext, "생년월일", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void setupEvents() {

        nameInputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, EditUserInfoActivity.class);
//                startActivity(intent);
//                입력결과를 받기위해 다른 메쏘드로 intent실행

                startActivityForResult(intent, REQUEST_FOR_USER_NAME);

            }
        });
        
        birthdayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent intent = new Intent(mContext, BirthdayInputActivity.class);
                startActivityForResult(intent,REQUEST_FOR_USER_BIRTHDAY);
                
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_FOR_PICTURE_GALLERY);

            }
        });

    }

    @Override
    public void setvalues() {

    }

    @Override
    public void bindviews() {

        this.galleryBtn = (Button) findViewById(R.id.galleryBtn);
        this.cameraBtn = (Button) findViewById(R.id.cameraBtn);
        this.profileImg = (ImageView) findViewById(R.id.profileImg);
        this.birthdayBtn = (Button) findViewById(R.id.birthdayBtn);
        this.birthdayTxt = (TextView) findViewById(R.id.birthdayTxt);
        this.nameInputBtn = (Button) findViewById(R.id.nameInputBtn);
        this.mainTxt = (TextView) findViewById(R.id.mainTxt);

    }
}
