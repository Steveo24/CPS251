package com.ebookfrenzy.contactproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null
    var contactPhone: Int = 0

    constructor() {}

    constructor(contactName: String, contactPhone: Int) {
        this.contactName = contactName
        this.contactPhone = contactPhone
    }
}
