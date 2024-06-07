package com.example.data.model.base

import com.example.domain.model.base.Model


interface EntityMapper<M : Model, ME : ModelEntity> {

    fun mapToDomain(modelEntity: ME): M

    fun mapToEntity(model: M): ME
}