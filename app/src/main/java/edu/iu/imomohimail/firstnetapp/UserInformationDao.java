package edu.iu.imomohimail.firstnetapp;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserInformationDao {

    @Insert
    public void addUser(userInformation user);
}
