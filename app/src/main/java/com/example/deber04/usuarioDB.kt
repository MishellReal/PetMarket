package com.example.deber04

import android.provider.ContactsContract

class usuarioDB {

    var id: Int = 0
    var name: String? = null
    var apellido : String? = null
    var email : String? = null
    var phone: Number? = null
    var pw : String? = null
    constructor(){

    }

    constructor(id:Int, name:String, email: String, pw: String, phone: Number){
        this.id = id
        this.name = name
        this.email = email
        this.pw = pw
        this.phone = phone
        this.apellido = apellido

    }

    constructor(name:String, email: String, pw: String, phone: Number, apellido: String){
        //this.id = id
        this.name = name
        this.email = email
        this.pw = pw
        this.phone = phone
        this.apellido = apellido
    }


}