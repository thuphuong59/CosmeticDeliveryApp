package com.example.cosmeticdeliveryapp.model


class ModelCategory {
    var id:String = ""
    var category:String = ""
    var timestamp:Long = 0
    var uid:String = ""
    var imageUrl: String = ""

    constructor()
    constructor(id: String, category: String, timestamp: Long, uid: String,imageUrl:String) {
        this.id = id
        this.category = category
        this.timestamp = timestamp
        this.uid = uid
        this.imageUrl=imageUrl
    }
}