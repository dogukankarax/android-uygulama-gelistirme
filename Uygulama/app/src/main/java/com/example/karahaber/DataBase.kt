package com.example.karahaber

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME ="MyDB"
val TABLE_NAME="Users"
val COL_MAIL = "mail"
val COL_SIFRE = "sifre"

class DataBase(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_MAIL + " VARCHAR(256)," +
                COL_SIFRE + " VARCHAR(256)"

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(user: User) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_MAIL, user.mail)
        cv.put(COL_SIFRE, user.sifre)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong())
            Toast.makeText(context, "Başarısız", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Başarılı", Toast.LENGTH_SHORT).show()
    }
}