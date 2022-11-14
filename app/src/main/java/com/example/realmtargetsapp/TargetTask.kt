package com.example.realmtargetsapp

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject

class TargetTask : RealmObject {
    var _id: ObjectId = ObjectId.create()
    var targetName: String = ""
}