package ritesh.assignment.data.remote.dto

import ritesh.assignment.domain.model.Article

data class ArticleDto(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceDto?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)

fun ArticleDto.toArticle(): Article {
    return Article(
        title = this.title ?: "",
        description = this.description ?: "",
        urlToImage = this.urlToImage ?: ""
    )
}