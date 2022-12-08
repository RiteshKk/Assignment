package ritesh.assignment.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ritesh.assignment.data.remote.NewsApi
import ritesh.assignment.paging.NewsPagingSource
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: NewsApi
) {

    fun getNewsStream(
        country: String,
        category: String
    ) = Pager(
        config = PagingConfig(
            pageSize = 10,
            maxSize = 100,
            enablePlaceholders = false,
            initialLoadSize = 10
        ),
        pagingSourceFactory = { NewsPagingSource(country, category,api) }
    ).flow
}