package ru.civilea.common

/* Interface for server and client
 * @param G - type for get request
 * @param A - type for add request
 * @param D - type for delete request
 */
interface Repository<G,A,D> {
    suspend fun getAll(): List<G>
    suspend fun add(elem:A)
    suspend fun deleteParent(parent: D)
}