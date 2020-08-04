package ru.civilea.common

interface Repository<T, D> {
    suspend fun getAll(): List<T>
    suspend fun getPage(startId: Long, pageSize: Int): List<T>
    suspend fun add(elem: D)
    suspend fun deleteById(id: Long)
    suspend fun updateElem(elem: T): Int
}