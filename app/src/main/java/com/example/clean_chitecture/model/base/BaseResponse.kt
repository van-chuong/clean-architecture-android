package com.example.clean_chitecture.model.base

import io.appwrite.models.Document

abstract class BaseResponse<T, D> {
    abstract fun fromDocument(document: Document<D>): T

    fun fromDocumentList(documents: List<Document<D>>): List<T> {
        return documents.map { fromDocument(it) }
    }
}