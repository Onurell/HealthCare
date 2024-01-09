package com.example.healthcare;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {

     @Insert
     void insterUser(UserTable userTable);


}
