package com.example.passwordsaver.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passwordsaver.R;
import com.example.passwordsaver.databinding.AccountDetailsItemLayoutBinding;
import com.example.passwordsaver.models.AccountDetails;
import com.example.passwordsaver.viewmodel.AccountDetailsViewModel;

import java.util.List;

public class AccountDetailsAdapter extends RecyclerView.Adapter<AccountDetailsAdapter.ViewHolder> {
    List<AccountDetails> mData;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AccountDetailsItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.account_details_item_layout, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mData != null) {
            AccountDetails details = mData.get(position);
            holder.mBinding.setAccountDetails(details);
        }
    }

    @Override
    public int getItemCount() {
        if (mData != null) return mData.size();
        return 0;
    }

    public void setProjects(List<AccountDetails> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AccountDetailsItemLayoutBinding mBinding;
        public ViewHolder(@NonNull AccountDetailsItemLayoutBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
