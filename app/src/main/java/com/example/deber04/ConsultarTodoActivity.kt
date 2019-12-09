package com.example.deber04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ConsultarTodoActivity : AppCompatActivity() {

        var showcontact:ListView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_id)
        var db = DatabaseHandler(this)

        showcontact = findViewById<ListView>(R.id.lista)
         var listViewItems = ArrayList<String>(10)
         var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewItems)

        showcontact!!.adapter = adapter
        adapter.add(" ID \t Nombre \t Teléfono ")
        val contacts = db.getAllContacts()
        for (c in contacts) {
            var id = c.id
            var name = c.name
            var phone = c.phone_number
            adapter.add(" $id \t $name \t $phone ")
        }

        adapter.notifyDataSetChanged()

    }
}
