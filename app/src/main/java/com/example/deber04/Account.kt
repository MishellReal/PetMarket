package com.example.deber04

class Account {

    var id: Int = 0
    var name: String? = null
    var email : String? = null
    var pw : String? = null

    constructor(){

    }

    constructor(id:Int, name:String, email: String, pw: String){
        this.id = id
        this.name = name
        this.email = email
        this.pw = pw
    }

    constructor(name:String, email: String, pw: String){
        this.id = id
        this.name = name
        this.email = email
        this.pw = pw
    }


}