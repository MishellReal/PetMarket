package com.example.deber04

class Contact {

    var id: Int = 0
    var name: String? = null
    var phone_number : String? = null

    constructor(){

    }

    constructor(id:Int, name:String, phone_numbre: String){
        this.id = id
        this.name = name
        this.phone_number = phone_number
    }

    constructor(name:String, phone_numbre: String){
        this.id = id
        this.name = name
        this.phone_number = phone_number
    }


}