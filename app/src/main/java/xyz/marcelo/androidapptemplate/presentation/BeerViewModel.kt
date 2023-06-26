package xyz.marcelo.androidapptemplate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import xyz.marcelo.androidapptemplate.data.local.BeerEntity
import xyz.marcelo.androidapptemplate.data.remote.toBeer
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    pager: Pager<Int, BeerEntity>
) : ViewModel() {

    val beerPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toBeer() }
        }
        .cachedIn(viewModelScope)
}