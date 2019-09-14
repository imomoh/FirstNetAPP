package edu.iu.imomohimail.firstnetapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {userInformation.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserInformationDao userFormationDao();
}


