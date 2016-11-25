package khromostech.khromosandroidproject_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

import static android.R.attr.data;
import static android.R.attr.logo;
import static android.R.attr.value;

public class DBHelper extends SQLiteOpenHelper {

    //Initiate variables
    private static final String DATABASE_NAME = "login_users";
    private static final String TABLE_NAME = "users_login";
    private static final String COL_ID = "ID";
    private static final String COL_FIRST_NAME = "name";
    private static final String COL_LAST_NAME = "last name";
    private static final String COL_GENRE = "genre";
    private static final String COL_BIRTHDAY = "Birthday";
    private static final String COL_CITY = "city";
    private static final String COL_COUNTRY = "country";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";



    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table" +
                        TABLE_NAME + "(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                        "COL_FIRST_NAME TEXT ," +
                        "COL_LAST_NAME TEXT" +
                        "COL_GENRE TEXT" +
                        "COL_BIRTHDAY TEXT" +
                        "COL_COUNTRY TEXT" +
                        "COL_CITY TEXT" +
                        "COL_EMAIL TEXT" +
                        "COL_PASSWORD TEXT" +
                        ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUsers(HashMap<String, String> data){
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("COL_FIRST_NAME", data.get("COL_FIRST_NAME"));
        values.put("COL_LAST_NAME", data.get("COL_LAST_NAME"));
        values.put("COL_GENRE", data.get("COL_GENRE"));
        values.put("COL_BIRTHDAY", data.get("COL_BIRTHDAY"));
        values.put("COL_COUNTRY", data.get("COL_COUNTRY"));
        values.put("COL_CITY", data.get("COL_CITY"));
        values.put("COL_EMAIL", data.get("COL_EMAIL"));
        values.put("COL_PASSWORD", data.get("COL_PASSWORD"));


        long result = database.insert("Users", null, values);
        if (result != 1){
            Log.d("#SQL", "Insert record successfully");
            return true;
        }else{
            Log.d("SQL", "insert record Fail");
            return false;
        }
    }

    public boolean insertData(String firstNameDB, String lastNameDB, String genreDB, String birthdayDB, String countryDB, String cityDB, String passwordDB, String emailDB){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_FIRST_NAME, firstNameDB);
        contentValues.put(COL_LAST_NAME, lastNameDB);
        contentValues.put(COL_GENRE, genreDB);
        contentValues.put(COL_BIRTHDAY, birthdayDB);
        contentValues.put(COL_COUNTRY, countryDB);
        contentValues.put(COL_CITY, cityDB);
        contentValues.put(COL_EMAIL, emailDB);
        contentValues.put(COL_PASSWORD, passwordDB);

        Long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }
}
