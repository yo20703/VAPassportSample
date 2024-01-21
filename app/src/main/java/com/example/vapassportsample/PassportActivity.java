package com.example.vapassportsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PassportActivity extends AppCompatActivity {
    RecyclerView rvPassportCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);

        initLayout();
    }

    private void initLayout() {
        rvPassportCard = findViewById(R.id.rv_passport_card);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvPassportCard.setLayoutManager(lm);

        PassportRvAdapter passportRvAdapter = new PassportRvAdapter(getDataBeans());
        rvPassportCard.setAdapter(passportRvAdapter);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(rvPassportCard);
    }

    private ArrayList<DataBean> getDataBeans() {
        ArrayList<DataBean> dataBeans = new ArrayList<>();

        dataBeans.add(new DataBean(true, "已施打", "第一劑疫苗"));
        dataBeans.add(new DataBean(false, "未施打", "第二劑疫苗"));
        dataBeans.add(new DataBean(false, "未施打", "第三劑疫苗"));
        return dataBeans;
    }
}