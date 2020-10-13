package com.android.roundup.service

import com.android.roundup.dashboard.model.MODDashBoardResponse
import com.android.roundup.dashboard.model.MODSubjectModelResponse
import com.android.roundup.dashboard.model.MODVideoModeResponse
import com.android.roundup.models.MODSearchResponse
import com.android.roundup.models.NotificationResponse
import com.android.roundup.scan.model.MODSafetyModel
import com.android.roundup.models.ResponseModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.*

interface RoundUpRepositoryService {
    @FormUrlEncoded
    @POST("get/search.html")
    suspend fun getSearchResults(@Field("terms") searchTag: String): Response<MODSearchResponse?>

    @POST("get/latex")
    @Headers("Accept:application/vnd.yourapi.v1.full+json")
    suspend fun getTokenAsync(
        @Header("content-type") applicationtype: String,
        @Header("app_id") app_id: String,
        @Header("app_key") app_key: String,
        @Body body: JsonObject
    ): Response<ResponseModel>

    @GET("get/is_paid.php")
    suspend fun isSafeCall(): Response<MODSafetyModel>

    @FormUrlEncoded
    @POST("get/dashboard.html")
    suspend fun getDashboardResponse(@Field("user_id") userId: Int): Response<MODDashBoardResponse>

    @FormUrlEncoded
    @POST("get/getsubjects.html")
    suspend fun getSubjectResponse(@Field("user_id") userId: Int,@Field("subcategory_id") subcategory_id: String): Response<MODSubjectModelResponse>

    @FormUrlEncoded
    @POST("get/getvideos.html")
    suspend fun getVideosResponse(@Field("user_id") userId: Int,@Field("topic_id") subcategory_id: String): Response<MODVideoModeResponse>

    @FormUrlEncoded
    @POST("get/gettopics.html")
    suspend fun getTopicResponse(@Field("user_id") userId: Int,@Field("subject_id") subcategory_id: String): Response<MODSubjectModelResponse>

    @FormUrlEncoded
    @POST("user/check.html")
    suspend fun getLogin(@Field("mobile") userId: String): Response<MODSafetyModel>

    @FormUrlEncoded
    @POST("get/notifications.html")
    suspend fun getNotification(@Field("userid") userId: String): Response<NotificationResponse>

    @FormUrlEncoded
    @POST("user/editprofile.html")
    suspend fun getProfileNotification(@Field("name") name: String,@Field("email") email: String, @Field("mobile") mobile: String, @Field("userid") userid: String): Response<NotificationResponse>

}
