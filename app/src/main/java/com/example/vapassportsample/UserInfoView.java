package com.example.vapassportsample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class UserInfoView extends ConstraintLayout {
    public UserInfoView(Context context) {
        super(context);

        inflate(context, R.layout.view_user_info, this);
    }

    public UserInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.view_user_info, this);
    }

    public UserInfoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.view_user_info, this);
    }

    public UserInfoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        inflate(context, R.layout.view_user_info, this);
    }
}
