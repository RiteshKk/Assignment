package ritesh.assignment.data.remote.dto

import ritesh.assignment.domain.model.NewsArticle

data class NewsArticleDto(
    val articles: List<ArticleDto>?,
    val status: String?,
    val totalResults: Int?
)

fun NewsArticleDto.toNewsArticle(): NewsArticle {
    return NewsArticle(
        articles = this.articles?.map { it.toArticle() } ?: emptyList(),
        totalResults = this.totalResults ?: 0
    )
}