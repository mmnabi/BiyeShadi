package com.lubdhok.biyeshadi.Concrete;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lubdhok.biyeshadi.Domain.User;

/**
 * Created by PrinceOfNightmareH on 31-Dec-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "BiyeShadi.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_USERNAME = "user_username";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private static final String COLUMN_USER_FULLNAME = "user_fullname";
    private static final String COLUMN_USER_ADDRESS = "user_address";
    private static final String COLUMN_USER_DIVISION = "user_division";
    private static final String COLUMN_USER_MOBILE = "user_mobile";
    private static final String COLUMN_USER_EMAIL = "user_email";

    private static final String COLUMN_USER_AGE = "user_age";
    private static final String COLUMN_USER_GENDER = "user_gender";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_USERNAME + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT"
            + COLUMN_USER_FULLNAME + " TEXT,"
            + COLUMN_USER_ADDRESS + " TEXT,"
            + COLUMN_USER_DIVISION + " TEXT,"
            + COLUMN_USER_MOBILE + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_AGE + " INTEGER,"
            + COLUMN_USER_GENDER + " CHARACTER(1),"
            + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Drop User Table if exist
        sqLiteDatabase.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(sqLiteDatabase);
    }


    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USERNAME, user.getUsername());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        values.put(COLUMN_USER_FULLNAME, user.getUserInfo().getFullName());
        values.put(COLUMN_USER_ADDRESS, user.getUserInfo().getAddress());
        values.put(COLUMN_USER_DIVISION, user.getUserInfo().getDivision());
        values.put(COLUMN_USER_MOBILE, user.getUserInfo().getMobile());
        values.put(COLUMN_USER_EMAIL, user.getUserInfo().getEmail());
        values.put(COLUMN_USER_AGE, user.getUserInfo().getAge());
        values.put(COLUMN_USER_GENDER, String.valueOf(user.getUserInfo().getGender()));

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

}
