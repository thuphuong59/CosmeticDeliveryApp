package com.example.cosmeticdeliveryapp.model

class Item {
    var id:String = ""
    var category:String = ""
    var timestamp:Long = 0
    var uid:String = ""
    var imageUrl: String = ""
    var title: String =""
    var description: String =""

    constructor()
    constructor(id: String, category: String, timestamp: Long, uid: String,imageUrl:String, title:String, description:String) {
        this.id = id
        this.category = category
        this.timestamp = timestamp
        this.uid = uid
        this.imageUrl=imageUrl
        this.title= title
        this.description= description
    }
}