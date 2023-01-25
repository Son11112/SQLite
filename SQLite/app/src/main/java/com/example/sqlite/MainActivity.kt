package com.example.sqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var helper = MyDataBase(applicationContext)
        val db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS",null)

        if(rs.moveToFirst())
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()

        //xem co nhan nut add hay khong
        btnAddUser.setOnClickListener{
            var cv = ContentValues( )
                cv.put("UNAME",edtUser.text.toString())
                cv.put("PWD",edtPass.text.toString())
            db.insert("USERS",null, cv)
            Toast.makeText(applicationContext,"add xong",Toast.LENGTH_LONG).show()

            edtUser.setText("")
            edtPass.setText("")
            edtUser.requestFocus()
        }
    }
}