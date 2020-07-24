package ru.civilea.weathershift.repository.network

interface Repository<T> {
    fun download():List<T>
}