package ru.civilea.core.model

interface Repository<T> {
    fun getAll():List<T>
}