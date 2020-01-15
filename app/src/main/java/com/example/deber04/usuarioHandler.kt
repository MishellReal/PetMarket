package com.example.deber04

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class usuarioHandler (context: Context) : SQLiteOpenHelper(context, usuarioHandler.DATABASE_NAME, null, usuarioHandler.DATABASE_VERSION
) {

    override fun onCreate(db: SQLiteDatabase) {

        val createUserTable = ("CREATE TABLE " + usuarioHandler.TABLE_USER + "("
                + usuarioHandler.KEY_ID + " INTEGER PRIMARY KEY," + usuarioHandler.KEY_NAME + " TEXT," + usuarioHandler.KEY_APELLIDO + " TEXT,"
                + usuarioHandler.KEY_EMAIL + " TEXT," + usuarioHandler.KEY_PHONE + " TEXT," + usuarioHandler.KEY_PW + "TEXT,"+ ")")


        db.execSQL(createUserTable)


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        onCreate(db);
    }

    fun addAccount(name: String, email: String, pw: String) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(KEY_NAME, name)
        values.put(KEY_EMAIL, email)
        values.put(KEY_PW, pw)
        db.insert(TABLE_USER, null, values)
        db.close()

    }

    fun getAccount(id: Int): com.example.deber04.usuarioDB {
        var cuenta = usuarioDB()
        val db = this.writableDatabase
        val cursor = db.query(
            TABLE_USER, arrayOf(KEY_ID, KEY_NAME, KEY_EMAIL, KEY_PW),
            "$KEY_ID=?", arrayOf(id.toString()), null, null, null, null
        )

        cursor?.moveToFirst()
        cuenta.id = (Integer.parseInt(cursor.getString(0)))
        cuenta.name = cursor.getString(1)
        cuenta.email = cursor.getString(2)
        cuenta.pw = cursor.getString(3)
        return cuenta

        // return null
    }

    fun getAllAccounts(): List<com.example.deber04.usuarioDB> {
        val accountList = ArrayList<com.example.deber04.usuarioDB>()

        val sql_select = "SELECT * FROM $TABLE_USER"

        val db = this.writableDatabase
        val cursor = db.rawQuery(sql_select, null)

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                val contact = usuarioDB()
                contact.id = Integer.parseInt(cursor.getString(0))
                contact.name = cursor.getString(1)
                contact.email = cursor.getString(2)
                contact.pw = cursor.getString(3)
                accountList.add(contact)
            }
        }
        return accountList
    }

    /*fun updateContact(account: com.example.deber04.Account): Int {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(KEY_NAME, account.name)
            put(KEY_EMAIL, account.phone_number)
        }

        return db.update(
            TABLE_ACCOUNT, values, "$KEY_ID=?",
            arrayOf(account.id.toString())
        )
    }*/


    /*fun deleteContact(account: com.example.deber04.Account) {
        val db = this.writableDatabase
        db.delete(
            TABLE_ACCOUNT, "$KEY_ID =?",
            arrayOf(account.id.toString())
        )
        db.close()
    }*/


    companion object {
        //Versión de la base de datos
        private const val DATABASE_VERSION = 1

        //Nombre de la base de datos
        private val DATABASE_NAME = "contactsManager.db"

        //Nombre de la tabla de crear cuenta
        private val TABLE_USER = "usuario"

        //Nombres de las columnas de la tabla
        private val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_EMAIL = "email"
        private val KEY_PW = "pw"
        private val KEY_APELLIDO = "apellido"
        private val KEY_PHONE = "phone"
    }
}