package com.example.deber04

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHandler (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        val createContactsTable = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")")
        db.execSQL(createContactsTable)


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db);
    }

    fun addContact(name: String, phone:String) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(KEY_NAME, name)
        values.put(KEY_PH_NO, phone)
        db.insert(TABLE_CONTACTS, null, values)
        db.close()

    }

    fun getContact(id: Int): Contact {
        var contac = Contact()
        val db = this.writableDatabase
        val cursor = db.query(
            TABLE_CONTACTS, arrayOf(KEY_ID, KEY_NAME, KEY_PH_NO),
            "$KEY_ID=?", arrayOf(id.toString()),null,null,null,null
        )

        cursor?.moveToFirst()
        contac.id = (Integer.parseInt(cursor.getString(0)))
        contac.name = cursor.getString(1)
        contac.phone_number = cursor.getString(2)
        return contac

        // return null
    }

    fun getAllContacts(): List<Contact> {
        val contactList = ArrayList<Contact>()

        val sql_select = "SELECT * FROM $TABLE_CONTACTS"

        val db = this.writableDatabase
        val cursor = db.rawQuery(sql_select, null)

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                val contact = Contact()
                contact.id = Integer.parseInt(cursor.getString(0))
                contact.name = cursor.getString(1)
                contact.phone_number = cursor.getString(2)
                contactList.add(contact)
            }
        }
        return contactList
    }

    fun updateContact(contact: Contact): Int {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(KEY_NAME, contact.name)
            put(KEY_PH_NO, contact.phone_number)
        }

        return db.update(
            TABLE_CONTACTS, values, "$KEY_ID=?",
            arrayOf(contact.id.toString())
        )
    }


    fun deleteContact(contact: Contact) {
        val db = this.writableDatabase
        db.delete(
            TABLE_CONTACTS, "$KEY_ID =?",
            arrayOf(contact.id.toString())
        )
        db.close()
    }


    companion object {
        //Versión de la base de datos
        private const val DATABASE_VERSION = 1

        //Nombre de la base de datos
        private val DATABASE_NAME = "contactsManager.db"

        //Nombre de la tabla de contactos
        private val TABLE_CONTACTS = "contacts"

        //Nombres de las columnas de la tabla
        private val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_PH_NO = "phone_number"
    }
}