package com.example.passwordsaver.repo;

import android.content.Context;

import com.example.passwordsaver.database.AppDatabase;
import com.example.passwordsaver.models.AccountDetails;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AccountRepo {
    private AppDatabase mAppDatabase;
    private Executor mExecutor = Executors.newSingleThreadExecutor();
    public AccountRepo(Context context) {
        mAppDatabase = AppDatabase.getInstance(context);
    }
    public void insert(AccountDetails details) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.dao().insertAccountDetails(details);
            }
        });
    }
    public void delete(AccountDetails details) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.dao().deleteAccountDetails(details);
            }
        });
    }
    public void update(AccountDetails details) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.dao().updateAccountDetails(details);
            }
        });
    }
    public List<AccountDetails> getAllAccountDetails() throws ExecutionException, InterruptedException {
        Callable<List<AccountDetails>> callable = new Callable<List<AccountDetails>>() {
            @Override
            public List<AccountDetails> call() throws Exception {
                return mAppDatabase.dao().getAllAccountDetails();
            }
        };
        Future<List<AccountDetails>> future = Executors.newSingleThreadExecutor().submit(callable);
        return future.get();
    }
}
