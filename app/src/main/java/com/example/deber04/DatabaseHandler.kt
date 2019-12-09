package com.example.deber04

import android.accounts.Account
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHandler (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        val createAccountTable = ("CREATE TABLE " + TABLE_ACCOUNT + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT," + KEY_PW + "TEXT,"+ ")")


        db.execSQL(createAccountTable)


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ACCOUNT")
        onCreate(db);
    }

    fun addAccount(name: String, email:String, pw:String) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(KEY_NAME, name)
        values.put(KEY_EMAIL, email)
        values.put(KEY_PW, pw)
        db.insert(TABLE_ACCOUNT, null, values)
        db.close()

    }

    fun getAccount(id: Int): com.example.deber04.Account {
        var cuenta = Account()
        val db = this.writableDatabase
        val cursor = db.query(
            TABLE_ACCOUNT, arrayOf(KEY_ID, KEY_NAME, KEY_EMAIL, KEY_PW),
            "$KEY_ID=?", arrayOf(id.toString()),null,null,null,null
        )

        cursor?.moveToFirst()
        cuenta.id = (Integer.parseInt(cursor.getString(0)))
        cuenta.name = cursor.getString(1)
        cuenta.email = cursor.getString(2)
        cuenta.pw = cursor.getString(3)
        return cuenta

        // return null
    }

    fun getAllAccounts(): List<com.example.deber04.Account> {
        val accountList = ArrayList<com.example.deber04.Account>()

        val sql_select = "SELECT * FROM $TABLE_ACCOUNT"

        val db = this.writableDatabase
        val cursor = db.rawQuery(sql_select, null)

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                val contact = Account()
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
        private val TABLE_ACCOUNT = "cuentas"

        //Nombres de las columnas de la tabla
        private val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_EMAIL = "email"
        private val KEY_PW = "pw"
    }
}