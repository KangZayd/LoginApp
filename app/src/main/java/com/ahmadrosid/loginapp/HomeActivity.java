package com.ahmadrosid.loginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmadrosid.loginapp.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.input_email) EditText email;
    @BindView(R.id.input_password) EditText password;
    @BindView(R.id.wrap) LinearLayout wrap;
    @BindView(R.id.result) TextView result;

    private ProgressDialog mProgressDialog;
    private Context context;
    private boolean isLogin = false;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        context = this;
    }

    @OnClick(R.id.btn_login) void clickLogin() {
        if (validate()) {
            showProgressDialog();
            final User user = new User(email.getText().toString(), email.getText().toString());
            new Handler().postDelayed(new Runnable() {
                @Override public void run() {
                    hideProgressDialog();
                    wrap.setVisibility(View.GONE);
                    result.setText(user.toString());
                    result.setVisibility(View.VISIBLE);
                    isLogin = true;
                }
            }, 2500);
        }
    }

    private boolean validate() {
        if (TextUtils.isEmpty(email.getText())) {
            showMessage("Email is empty!");
            return false;
        } else if (TextUtils.isEmpty(password.getText())) {
            showMessage("Password is empty!");
            return false;
        }
        return true;
    }


    private void showMessage(String s) {
        Toast.makeText(HomeActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show progress dialog
     */
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }
        mProgressDialog.show();
    }

    /**
     * Hide progress dialog
     */
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override public void onBackPressed() {
        if (isLogin) {
            wrap.setVisibility(View.VISIBLE);
            result.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }
}
