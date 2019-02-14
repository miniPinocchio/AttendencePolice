package com.anrongtec.attendencepolice.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anrongtec.attendencepolice.R;
import com.anrongtec.attendencepolice.bean.RankData;

import java.util.List;


/**
 * @author Created by huiliu on 2019/icon_rank1/17.
 * @email liu594545591@126.com
 * @introduce 考勤排行
 */
public class RankAdapter extends RecyclerView.Adapter<RankAdapter.RankViewHolder> {
    private Context mContext;
    private List<RankData> mList;


    public RankAdapter(Context context, List<RankData> list) {
        mContext = context;
        mList = list;
    }


    @NonNull
    @Override
    public RankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, viewGroup, false);
        return new RankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankViewHolder rankViewHolder, int position) {
        RankData rankData = mList.get(position);
        if (0 == position) {
            rankViewHolder.tv_rank_num.setBackgroundResource(R.drawable.icon_rank1);
            rankViewHolder.rl_rank.setBackgroundResource(R.drawable.bg_rank_first);
            rankViewHolder.tv_rank_num.setText("");
        } else if (1 == position) {
            rankViewHolder.tv_rank_num.setBackgroundResource(R.drawable.icon_rank2);
            rankViewHolder.rl_rank.setBackgroundResource(R.drawable.bg_rank_second);
            rankViewHolder.tv_rank_num.setText("");
        } else if (2 == position) {
            rankViewHolder.tv_rank_num.setBackgroundResource(R.drawable.icon_rank3);
            rankViewHolder.rl_rank.setBackgroundResource(R.drawable.bg_rank_second);
            rankViewHolder.tv_rank_num.setText("");
        } else {
            rankViewHolder.tv_rank_num.setBackgroundResource(0);
            rankViewHolder.tv_rank_num.setText(String.valueOf(position + 1));
            rankViewHolder.rl_rank.setBackgroundResource(R.drawable.bg_rank_second);
        }


        rankViewHolder.tv_rank_company_name.setText(rankData.getCompanyName());

        String signedPerson = String.valueOf(rankData.getSignedPerson());
        String allPerson = String.valueOf(rankData.getAllPerson());
        String s3 = signedPerson + "/" + allPerson;
        SpannableString spanString = new SpannableString(s3);
        spanString.setSpan(new ForegroundColorSpan(Color.RED), signedPerson.length() + 1, s3.length(), 0);

        rankViewHolder.tv_signed.setText(signedPerson);
        rankViewHolder.tv_signed_num.setText(spanString);
    }

    @Override
    public int getItemCount() {
        return mList.size() > 0 ? mList.size() : 0;
    }

    class RankViewHolder extends RecyclerView.ViewHolder {
        TextView tv_rank_num;
        TextView tv_rank_company_name;
        TextView tv_signed_num;
        TextView tv_signed;
        RelativeLayout rl_rank;

        RankViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rank_num = itemView.findViewById(R.id.tv_rank_num);
            tv_rank_company_name = itemView.findViewById(R.id.tv_rank_company_name);
            tv_signed_num = itemView.findViewById(R.id.tv_signed_num);
            tv_signed = itemView.findViewById(R.id.tv_signed);
            rl_rank = itemView.findViewById(R.id.rl_rank);
        }
    }
}
