package ge.nlatsabidze.summary_8.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ActiveCourse(
    @Json(name = "background_color_percent")
    val backgroundColorPercent: String?,
    @Json(name = "booking_time")
    val bookingTime: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "main_color")
    val mainColor: String?,
    @Json(name = "play_button_color_percent")
    val playButtonColorPercent: String?,
    @Json(name = "progress")
    val progress: String?,
    @Json(name = "title")
    val title: String?
)