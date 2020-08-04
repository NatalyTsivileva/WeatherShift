package ru.civilea.city_list.paginator

import ru.civilea.common.Repository
import ru.civilea.common.models.City
import ru.civilea.common.models.CreateCityDto
import ru.civilea.core.model.pagination.Paginator
import ru.civilea.core.model.pagination.State

class CityPaginator(
    override var pageSize: Int = 10,
    val repository: Repository<City, CreateCityDto>
) : Paginator<City> {

    override var currentPage: Int = 0
    override var currentData = mutableListOf<City>()
    override var currentState: State<City> = EmptyState()

    override suspend fun loadNewPage() {
        currentState.loadNewPage()
    }

    inner class EmptyState : State<City> {
        override suspend fun loadNewPage() {
            currentData = repository.getPage(
                startId = getStartItemId(),
                pageSize = pageSize
            ).toMutableList()
        }
    }

    fun getStartItemId(): Long = (pageSize * currentPage).toLong()

}