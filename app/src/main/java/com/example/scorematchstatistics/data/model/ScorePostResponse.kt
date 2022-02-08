package com.example.scorematchstatistics.data.model


data class ScorePostResponse(
    val data: Chidren
) {
    data class Chidren(
        val after: String?,
        val children: List<Data>
    )

    data class Data(
        val data: DataResponse
    )

    data class DataResponse(
        val title: String?,
        val thumbnail: String?,
        val post_hint: String?,
        val url_overridden_by_dest: String?,
        val link_flair_background_color: String?,
        val url: String?,
        val author: String?,
        val is_video: Boolean?
    )
}

