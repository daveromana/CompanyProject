package com.lhc.android.great.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lhc.android.great.Bmod.Person;
import com.lhc.android.great.R;
import com.lhc.android.great.Utils.CheckAccount;
import com.lhc.android.great.Utils.NavigateUtil;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class LoginActivity extends Activity {

    private EditText mEtName,mEtPwd;
    private Button mBtnCancel,mBtnConfirm;
    private TextView mTvForgetPwd,mTvRegistNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.log_in);
        toolbar.setNavigationIcon(R.drawable.arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mEtName=(EditText)findViewById(R.id.et_login_name);
        mEtPwd=(EditText)findViewById(R.id.et_login_password);
        mBtnCancel=(Button)findViewById(R.id.btn_login_cancel);
        mBtnConfirm=(Button)findViewById(R.id.btn_login_confirm);
        mTvForgetPwd=(TextView)findViewById(R.id.tv_forget_password);
        mTvRegistNow=(TextView)findViewById(R.id.tv_regist_now);

        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mEtName.getText().toString();
                String pwd=mEtPwd.getText().toString();
                CheckAccount.isAccountValid(name);
                if(!CheckAccount.isValid){
                    Toast.makeText(getApplicationContext(),R.string.tips_account_is_not_valid,Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(pwd)){
                    Toast.makeText(getApplicationContext(),R.string.tips_password_can_not_empty,Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtName.setText("");
                mEtPwd.setText("");
            }
        });


        mTvRegistNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigateUtil.navigateToRegistActivity(LoginActivity.this);
            }
        });

        mTvForgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigateUtil.navigateToFindPasswordActivity(LoginActivity.this);
            }
        });
    }

}