package ru.civilea.common

interface Repository<P,C> {
    suspend fun getAll(): List<P>
    suspend fun add(parent: P,child:C)
    suspend fun deleteParent(parent: P)
}