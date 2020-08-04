package ru.civilea.core.model.pagination

interface State<T> {
    fun refresh(){}
    suspend fun loadNewPage(){}
    fun release(){}
    fun newData(data:List<T>){}
    fun fail(error:Throwable){}
}