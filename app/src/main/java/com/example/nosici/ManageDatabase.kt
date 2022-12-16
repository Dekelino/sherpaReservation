package com.example.nosici
import com.google.firebase.database.FirebaseDatabase

class ManageDatabase {
    private val database = FirebaseDatabase.getInstance()
    private val usersReference = database.getReference("users")
    fun addUser(user: User) {
        usersReference.push().setValue(user)
    }
}