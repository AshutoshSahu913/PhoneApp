package com.example.phoneapp.RoomDB.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact(
    @PrimaryKey var id: Int? = null,
    var profileImg: ByteArray? = null,
    var userName: String? = null,
    var userPhoneNo: String? = null,
    var userEmail: String? = null,
    //var date:Date
)