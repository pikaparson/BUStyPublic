package com.example.busty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TableActivity extends AppCompatActivity {

    TextView text1;

    private static final String DATABASE_NAME = "baza.db";
    private static String DB_PATH;
    private static SQLiteDatabase db;

    void create_db(){
        File file = new File(DB_PATH);
        if (file.exists()) {
            //получаем локальную бд как поток
            try(InputStream myInput = getApplicationContext().getAssets().open(DATABASE_NAME);
                // Открываем пустую бд
                OutputStream myOutput = new FileOutputStream(DB_PATH)) {

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            }
            catch(IOException ex){
                Log.d("Database", ex.getMessage());
            }
        }
    }
    public SQLiteDatabase open()throws SQLException {
        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        DB_PATH = getApplicationContext().getFilesDir().getPath() + "/" + DATABASE_NAME;

        create_db();
        db = open();

        Cursor cursor = db.rawQuery( "select * from products", null );


        text1 = findViewById(R.id.textView1);
        cursor.moveToFirst();
        text1.setText(cursor.getString(0) + ' ' + cursor.getString(1) + ' ' + cursor.getString(2) + '\n');
        cursor.moveToNext();
        text1.setText(text1.getText() + cursor.getString(0) + ' ' + cursor.getString(1) + ' ' + cursor.getString(2) + '\n');
        cursor.moveToNext();
        text1.setText(text1.getText() + cursor.getString(0) + ' ' + cursor.getString(1) + ' ' + cursor.getString(2) + '\n');
        cursor.moveToNext();
        text1.setText(text1.getText() + cursor.getString(0) + ' ' + cursor.getString(1) + ' ' + cursor.getString(2) + '\n');
    }
}