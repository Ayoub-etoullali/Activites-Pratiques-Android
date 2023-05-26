package com.example.etoullali;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

 @Dao
public interface MainDao {

    // Insert query
    @Insert(onConflict =REPLACE)
    void insert(MainData mainData);
     // Delete query
/*
     @Delete
     void delete(List<MainData> mainData);
     //to do
*/
     // delete Query
     @Query("Delete from  table_name where ID=:sID")
     void delete(int sID);
     // Update query
     @Query("UPDATE table_name SET text= :sText where ID=:sID")
     void update(int sID, String sText);

     // Get all data query
     @Query("SELECT * FROM table_name")
     List<MainData> getAll();


}
