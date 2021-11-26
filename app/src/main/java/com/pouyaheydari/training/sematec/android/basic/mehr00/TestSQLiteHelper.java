package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TestSQLiteHelper extends SQLiteOpenHelper {

    String TABLE_NAME = "students";

    public TestSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "grade INTEGER" +
                ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    public void insertStudent(String name, int grade) {
        String INSERT_STUDENT_QUERY = "INSERT INTO " + TABLE_NAME + "(name,grade) VALUES(" +
                "'" + name + "'" + "," + grade +
                ")";
        this.getWritableDatabase().execSQL(INSERT_STUDENT_QUERY);
    }

    public List<String> getAllStudentsNames() {
        ArrayList<String> names = new ArrayList<>();
        String GET_ALL_STUDENTS_QUERY = "SELECT name,grade FROM " + TABLE_NAME;
        Cursor cursor = this.getReadableDatabase().rawQuery(GET_ALL_STUDENTS_QUERY, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            names.add(name);
        }

        return names;
    }
}
