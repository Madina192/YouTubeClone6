package com.example.youtubeclone.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.youtubeclone.core.network.RemoteDataSource
import com.example.youtubeclone.core.network.Resource
import com.example.youtubeclone.data.model.PlaylistModel
import com.example.youtubeclone.utils.Constants

class PlaylistsPagingSource(
    private val remoteDataSource: RemoteDataSource
) : PagingSource<String, PlaylistModel.Item>() {
    override fun getRefreshKey(state: PagingState<String, PlaylistModel.Item>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, PlaylistModel.Item> {
        try {
            val nextPageToken = params.key ?: Constants.EMPTY_STRING
            val response = remoteDataSource.getPlaylists(nextPageToken)

            val items = when(response.status){
                Resource.Status.SUCCESS -> response.data!!.items
                else -> {
                    emptyList()
                }
            }

            val prevKey = null
            val nextKey = response.data?.nextPageToken

            return LoadResult.Page(
                data = items,
                prevKey = prevKey,
                nextKey = nextKey,
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}