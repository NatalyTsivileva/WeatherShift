package ru.civilea.common

/* Interface for server and client
 * @param G - type for get request
 * @param A - type for add request
 * @param D - type for delete request
 */
interface Repository<T,D> {
    suspend fun getAll(): List<T>
    suspend fun add(elem:D)
    suspend fun deleteById(id: Long)
    suspend fun updateElem(elem: T):Int
}