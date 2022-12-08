package ritesh.assignment.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ritesh.assignment.common.COUNTRY_CODE
import ritesh.assignment.common.NEWS_CATEGORY
import ritesh.assignment.data.repository.NewsRepository
import ritesh.assignment.domain.model.Article
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repo: NewsRepository
) : ViewModel() {

    val pagingData: Flow<PagingData<Article>> = repo.getNewsStream(
       country = COUNTRY_CODE,
       category = NEWS_CATEGORY
   )
}