package com.example.passwordsaver.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.passwordsaver.models.AccountDetails;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAccountDetails(AccountDetails accountDetails);
    @Update
    void updateAccountDetails (AccountDetails accountDetails);
    @Delete
    void deleteAccountDetails(AccountDetails accountDetails);

    @Query("select * from account_details")
    List<AccountDetails> getAllAccountDetails();

    @Query("select * from account_details where account_name = :accountName")
    List<AccountDetails> getAllAccountDetailsByAccountName(String accountName);

    @Query("select * from account_details where account_name = :accountUserName")
    List<AccountDetails> getAllAccountDetailsByAccountUserName(String accountUserName);
}
