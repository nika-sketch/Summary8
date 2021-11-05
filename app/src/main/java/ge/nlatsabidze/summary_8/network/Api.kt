package ge.nlatsabidze.summary_8.network

import ge.nlatsabidze.summary_8.model.Data
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/v3/4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun getItems(): Response<Data>
}