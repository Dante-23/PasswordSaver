package com.example.passwordsaver.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "account_details")
public class AccountDetails {
    @ColumnInfo(name = "account_id")
    @PrimaryKey(autoGenerate = true)
    private int mId;

    @ColumnInfo(name = "account_name")
    private String mAccountName;
    @ColumnInfo(name = "account_username")
    private String mUserName;
    @ColumnInfo(name = "account_password")
    private String mPassword;

    public AccountDetails() {}

    public AccountDetails(String accountName, String accountUserName, String accountPassword) {
        this.mAccountName = accountName;
        this.mUserName = accountUserName;
        this.mPassword = accountPassword;
    }
    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getAccountName() {
        return mAccountName;
    }

    public void setAccountName(String mAccountName) {
        this.mAccountName = mAccountName;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
