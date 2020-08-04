package ru.civilea.core.model.pagination

interface ViewStateManager<T> {
    fun setEmptyProgressState(isShown:Boolean)
    fun setEmptyErrorState(isShown:Boolean,error:Throwable?=null)
    fun setEmptyViewState(isShown:Boolean)
    fun setDataState(isShown:Boolean, data:List<T> = emptyList())
    fun setErrorMessageState(error:Throwable)
    fun setRefreshProgressState(isShow:Boolean)
    fun setPageProgressState(isShow:Boolean)
}