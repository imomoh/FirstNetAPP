package edu.iu.imomohimail.firstnetapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserInformationDao {

    @Insert
    public void addUser(userInformation user);

//    @Query("select * from users")
//    public List<UserDataInput> getUsers();
}
