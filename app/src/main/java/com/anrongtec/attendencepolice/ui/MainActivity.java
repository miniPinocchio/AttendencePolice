package com.anrongtec.attendencepolice.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anrongtec.attendencepolice.KqApp;
import com.anrongtec.attendencepolice.R;
import com.anrongtec.attendencepolice.adapter.RankAdapter;
import com.anrongtec.attendencepolice.base.BaseActivity;
import com.anrongtec.attendencepolice.bean.BaseRankData;
import com.anrongtec.attendencepolice.bean.RankData;
import com.anrongtec.attendencepolice.utils.GsonUtil;
import com.anrongtec.attendencepolice.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author huiliu
 * 考勤统计
 */
public class MainActivity extends BaseActivity implements Callback<String> {

    private RecyclerView mRecyclerView;
    private List<RankData> mList;
    private RankAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rl_attendance_rank);
        initRecycler();
        getNetData();
    }


    private void initRecycler() {
        mList = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            RankData da = new RankData();
//            da.setRank(i);
//            da.setCompanyName("河西太湖派出所");
//            Random random = new Random();
//            da.setSignedPerson(random.nextInt(50) + 1);
//            da.setAllPerson(random.nextInt(50) + 50);
//            mList.add(da);
//        }

//        Collections.sort(mList);
        mAdapter = new RankAdapter(this, mList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getNetData() {
        long timeMillis = System.currentTimeMillis();
        String timestamp = TimeUtils.timestampToDate(timeMillis);
        KqApp.getRetrofit().getAttenRank("timeNyr=" + timestamp).enqueue(this);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        String data = response.body();
        if (response.isSuccessful()) {
            resolveData(data);
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        showToast(R.string.net_error);
    }

    /**
     * 解析数据
     *
     * @param data
     */
    private void resolveData(String data) {
        if (data != null) {
            BaseRankData baseRankData = GsonUtil.parseJsonWithGson(data, BaseRankData.class);
            List<RankData> rows = baseRankData.getRows();
            if (rows != null && rows.size() > 0) {
                Collections.sort(rows);
                mList.addAll(rows);
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}

