package com.example.healthcare;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

     @Insert
     void insterUser(UserTable userTable);

     @Query("SELECT EXISTS(SELECT * from UserTable where userName=:username)")
     boolean is_taken(String userName);

     @Query("SELECT EXISTS (SELECT * from UserTable where userName=:username AND password=:password)")
     boolean login(String userName);

}
