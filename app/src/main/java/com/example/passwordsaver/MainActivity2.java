package com.example.passwordsaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.passwordsaver.databinding.ActivityMain2Binding;
import com.example.passwordsaver.models.AccountDetails;
import com.example.passwordsaver.viewmodel.AccountDetailsViewModel;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding mBinding;
    private AccountDetailsViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(AccountDetailsViewModel.class);
        mBinding.btnAddAccount.setOnClickListener(view -> {
            String accountName = mBinding.accountName.getText().toString().trim();
            String accountUserName = mBinding.accountUserName.getText().toString().trim();
            String accountPassword = mBinding.accountPassword.getText().toString().trim();
            AccountDetails details = new AccountDetails(accountName, accountUserName, accountPassword);
            mViewModel.insert(details);
        });
    }
}