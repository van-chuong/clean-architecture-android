package com.example.clean_chitecture.model.base

import com.example.domain.model.base.Model

interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToPresentation(model: M): MI

    fun mapToDomain(modelItem: MI): M
}