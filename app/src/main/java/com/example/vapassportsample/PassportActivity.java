package com.example.vapassportsample;

import static android.view.View.inflate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.vapassportsample.database.table.User;
import com.example.vapassportsample.database.table.VaccineHistory;

import java.util.ArrayList;

public class PassportActivity extends AppCompatActivity {
    RecyclerView rvPassportCard;
    UserInfoView userInfoView;
    User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);

        initLayout();
        reloadUserInfo();
    }

    private void reloadUserInfo() {

        Thread getUserInfoThread = new Thread(new Runnable() {
            @Override
            public void run() {
                user = MyApplication.appDatabase.userDao().getUser();
            }
        });
        getUserInfoThread.start();
        try {
            getUserInfoThread.join();
        } catch (InterruptedException e) {
            Log.e("initUserInfo", "" + e);
        }

        if(user != null) {
            userInfoView.setName(user.name);
            userInfoView.setBirthday(user.birthday);
            userInfoView.setNumber(user.number);
        }
    }

    private void initLayout() {
        rvPassportCard = findViewById(R.id.rv_passport_card);
        userInfoView = findViewById(R.id.user_info_view);
        userInfoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("userInfoView:", "onClick: ");
                showUserEditDialog();
            }
        });

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvPassportCard.setLayoutManager(lm);

        PassportRvAdapter passportRvAdapter = new PassportRvAdapter(getDataBeans());
        rvPassportCard.setAdapter(passportRvAdapter);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(rvPassportCard);
    }

    private void showUserEditDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View editDialogView = inflate(this, R.layout.user_edit_dialog, null);
        builder.setView(editDialogView);
        EditText etName = editDialogView.findViewById(R.id.et_name);
        EditText etBirthday = editDialogView.findViewById(R.id.et_birthday);
        EditText etNumber = editDialogView.findViewById(R.id.et_number);
        etName.setText(user.name);
        etBirthday.setText(user.birthday);
        etNumber.setText(user.number);

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                updateUser(etName.getText().toString(), etBirthday.getText().toString(), etNumber.getText().toString());
            }
        });

        AlertDialog editDialog = builder.create();

        editDialog.show();


    }

    private void updateUser(String name, String birthday, String number) {
        Thread updateUserThread = new Thread(new Runnable() {
            @Override
            public void run() {
                MyApplication.appDatabase.userDao().deleteUser(user);
                user.name = name;
                user.birthday = birthday;
                user.number = number;

                MyApplication.appDatabase.userDao().insertUser(user);
            }
        });

        updateUserThread.start();
        try {
            updateUserThread.join();
        } catch (InterruptedException e) {
            Log.e("updateUserThread", e.toString());
        }

        reloadUserInfo();
    }

    private ArrayList<VaccineHistory> getDataBeans() {
        ArrayList<VaccineHistory> dataBeans = new ArrayList<>();

        dataBeans.add(new VaccineHistory(true, "已施打", "第一劑疫苗"));
        dataBeans.add(new VaccineHistory(false, "未施打", "第二劑疫苗"));
        dataBeans.add(new VaccineHistory(false, "未施打", "第三劑疫苗"));
        return dataBeans;
    }
}