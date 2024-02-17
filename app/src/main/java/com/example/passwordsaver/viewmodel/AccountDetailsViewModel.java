package com.example.passwordsaver.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.passwordsaver.models.AccountDetails;
import com.example.passwordsaver.repo.AccountRepo;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AccountDetailsViewModel extends AndroidViewModel {
    private AccountRepo mRepo;
    public AccountDetailsViewModel(Application application) {
        super(application);
        mRepo = new AccountRepo(application);
    }
    public void insert(AccountDetails details) { mRepo.insert(details); }
    public void delete(AccountDetails details) { mRepo.delete(details); }
    public void update(AccountDetails details) { mRepo.update(details); }
    public List<AccountDetails> getAllAccountDetails() throws ExecutionException, InterruptedException { return mRepo.getAllAccountDetails(); }
}
