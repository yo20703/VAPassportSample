package com.example.vapassportsample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class UserInfoView extends ConstraintLayout {
    TextView tvName;
    TextView tvBirthday;
    TextView tvNumber;
    public UserInfoView(Context context) {
        super(context);

        inflate(context, R.layout.view_user_info, this);
        initLayout();
    }

    public UserInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.view_user_info, this);
        initLayout();
    }

    public UserInfoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.view_user_info, this);
        initLayout();
    }

    public UserInfoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        inflate(context, R.layout.view_user_info, this);
        initLayout();
    }

    public void setName(String name) {
        tvName.setText(name);
    }

    public void setBirthday(String birthday) {
        tvBirthday.setText(birthday);
    }

    public void setNumber(String number) {
        tvNumber.setText(number);
    }

    private void initLayout() {
        tvName = findViewById(R.id.tv_user);
        tvBirthday = findViewById(R.id.user_birthday);
        tvNumber = findViewById(R.id.tv_user_number);
    }
}
