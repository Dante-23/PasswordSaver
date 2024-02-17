package com.example.passwordsaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.passwordsaver.adapter.AccountDetailsAdapter;
import com.example.passwordsaver.databinding.ActivityMainBinding;
import com.example.passwordsaver.models.AccountDetails;
import com.example.passwordsaver.viewmodel.AccountDetailsViewModel;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private AccountDetailsViewModel mViewModel;
    private AccountDetailsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.accountDetails.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AccountDetailsAdapter();
        mBinding.accountDetails.setAdapter(mAdapter);
        mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(AccountDetailsViewModel.class);
        mBinding.addProject.setOnClickListener(view-> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        try {
            mViewModel.getAllAccountDetails().observe(this, new Observer<List<AccountDetails>>() {
                @Override
                public void onChanged(List<AccountDetails> accountDetails) {
                }
            });
        } catch (ExecutionException e) {
        } catch (InterruptedException e) {
        }
    }
}