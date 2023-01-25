package com.example.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/*
* name: chuỗi? tên của db
* factory : SQLitdatatabase.CursorFactory? để sử dụng để tạo các đối tượng con trỏ, hoặc null cho mặc định
* version Int:số của cơ sở dữ liệu bắt bắt đầu từ 1
* nếu cơ sở dữ liệu cũ hơn, onUpgrade sẽ được sử dụng để nâng cấp cơ sở dữ liệu
* néu cơ sở dữ liệu mới hơn, Downgrade sẽ được sử dụng để hạ cấp cơ sở dữ liệu*/
class MyDataBase (context: Context) : SQLiteOpenHelper(context,"USERDB",null,1){
    override fun onCreate(p0: SQLiteDatabase?) {
        //tạo bảng
        p0?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME TEXT, PWD TEXT) ")
        //add data       CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME TEXT, PWD TEXT)
        p0?.execSQL("INSERT INTO USERS(UNAME, PWD) VALUES ('son hai dap thu','9999999')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}