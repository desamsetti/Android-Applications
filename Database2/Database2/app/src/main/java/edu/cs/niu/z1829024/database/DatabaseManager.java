package edu.cs.niu.z1829024.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static java.sql.Types.NULL;

/**
 * Created by Z1829024 on 4/16/2018.
 */

public class DatabaseManager extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "candyDB",
                                    TABLE_NAME = "candy",
                                    ID = "id",
                                    NAME = "name",
                                    PRICE = "price";

        private static final int VERSION_NUMBER = 1;

        //Constructor


        public DatabaseManager(Context context)
        {
            super(context,DATABASE_NAME,null,VERSION_NUMBER );
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String sqlCreate = "create table " + TABLE_NAME
                    +"(" + ID + " integer primary key autoincrement, "
                     + NAME + " text, "
                    + PRICE + "real" + " )";

            //Create the database
            sqLiteDatabase.execSQL(sqlCreate);
        }//End of onCreate

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            //String to drop the database
            String sqlDrop = "drop table if exists " + TABLE_NAME;
            sqLiteDatabase.execSQL(sqlDrop);

            //Create the Database
            onCreate(sqLiteDatabase);
        }//End of onUpgrade


        //Insert info into the database
        public void insert(Candy candy)
        {
            SQLiteDatabase database = getWritableDatabase();

            //String with insert command
            String sqlInsert = "insert into " + TABLE_NAME
                                + " values( null, '" +candy.getName()
                                +"','" + candy.getPrice() + "' )";
            database.execSQL(sqlInsert);
            database.close();
        }//End of insert


        //Method to get all of the info from the database
        public ArrayList<Candy> selectAll()
        {
            String sqlQuery = "select * from " + TABLE_NAME;
            SQLiteDatabase database = getWritableDatabase();

            //Create the cursor to hold the retrieved info
            Cursor cursor = database.rawQuery(sqlQuery, null);

            //Create the array list
            ArrayList<Candy> candies = new ArrayList<>();

            //Process the cursor and put the data into the array list
            while(cursor.moveToNext())
            {
                Candy candy = new Candy( Integer.parseInt(cursor.getString(0)),
                                        cursor.getString(1),
                                        cursor.getDouble(2));

                //Add the candy to the array list
                candies.add(candy);
            }

            //Close the database
            database.close();

            return candies;
        }//End selectAll


        public void deleteById(int id)
        {
            String sqlDelete = "delete from " + TABLE_NAME
                             + " where " + ID + " = " + id;
            SQLiteDatabase database = getWritableDatabase();

            database.execSQL(sqlDelete);
        }//End of deleteById



        public void updateById(int id, String name, double price)
        {
            String sqlUpdate = "update " + TABLE_NAME
                            + " set " + NAME + " = '" + name + "', "
                            + PRICE + " = '" + price + "' "
                            + " where " + ID + " = " + id;

            SQLiteDatabase database = getWritableDatabase();
            database.execSQL(sqlUpdate);
            database.close();

        }//End of updateById



    }//End of DataBaseManager
