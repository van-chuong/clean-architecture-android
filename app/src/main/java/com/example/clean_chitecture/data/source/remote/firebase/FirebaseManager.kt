package com.example.clean_chitecture.data.source.remote.firebase

import com.example.clean_chitecture.model.Movie
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class FirebaseManager {
    companion object {
        private const val COLLECTION_MOVIES = "movies"
    }

    suspend fun getMovie(): List<Movie> {
        return Firebase.firestore.collection(COLLECTION_MOVIES)
            .get()
            .await()
            .toObjects(Movie::class.java)
    }
}