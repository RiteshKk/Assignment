package ritesh.assignment.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ritesh.assignment.data.remote.NewsApi
import ritesh.assignment.data.remote.dto.toNewsArticle
import ritesh.assignment.domain.model.Article
import java.io.IOException

class NewsPagingSource(
    private val country: String,
    private val category: String,
    private val api: NewsApi
) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.nextKey?.plus(1)
                ?: state.closestPageToPosition(it)?.prevKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val position = params.key ?: 1
        return try {
            val remoteData = api.getNewList(
                country = country,
                category = category,
                page = position,
                pageSize = params.loadSize
            ).toNewsArticle()
            val nextKey = if (remoteData.articles.size < params.loadSize) null else position + 1
            val prevKey = if (position == 1) null else position - 1
            LoadResult.Page(
                remoteData.articles,
                prevKey,
                nextKey
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}