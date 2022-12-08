package ritesh.assignment.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ritesh.assignment.common.API_KEY
import ritesh.assignment.common.COUNTRY_CODE
import ritesh.assignment.common.NEWS_CATEGORY
import ritesh.assignment.data.remote.dto.NewsArticleDto

interface NewsApi {
    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=3d06792c937e4225b8e12a9a69410832&pageSize=10&page=1
    @GET("top-headlines")
    suspend fun getNewList(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") key: String = API_KEY,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): NewsArticleDto
}