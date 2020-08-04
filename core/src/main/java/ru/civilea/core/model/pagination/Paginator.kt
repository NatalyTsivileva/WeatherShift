package ru.civilea.core.model.pagination

interface Paginator<T> {
    var currentState:State<T>
    var currentPage:Int
    var currentData:MutableList<T>
    var pageSize:Int

    fun refresh()=currentState.refresh()
    suspend fun loadNewPage()=currentState.loadNewPage()
    fun release()=currentState.release()
    fun fail(e: Throwable)=currentState.fail(e)
}