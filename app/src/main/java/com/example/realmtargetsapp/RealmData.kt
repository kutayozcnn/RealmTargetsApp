package com.example.realmtargetsapp

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.types.ObjectId

class RealmData {

    val realm: Realm by lazy {
        val configuration = RealmConfiguration.Builder(schema =setOf(TargetTask::class)).name("targetDB").schemaVersion(1).build()
        Realm.open(configuration)
    }

    fun AddOnClick(
        nameTarget : String
    ) {
        realm.writeBlocking {
            copyToRealm(TargetTask().apply {
                targetName = nameTarget
            })
        }
    }
    fun getAllTarget(): List<TargetTask> {
        return realm.query<TargetTask>().find()
    }

    fun deletePerson(_id: ObjectId) {
        realm.writeBlocking {
            var target: TargetTask =
                this.query<TargetTask>("_id == $0", _id)
                    .find()
                    .first()
            delete(target)
        }
    }
}