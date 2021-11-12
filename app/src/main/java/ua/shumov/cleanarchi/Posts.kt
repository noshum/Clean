package ua.shumov.cleanarchi


data class Posts(val id: Long,
                 val userId: Long,
                 val title: String,
                 val body: String) {

    companion object {
        const val POST_TABLE_NAME = "Posts"
        const val POST_ID = "id"
        const val POST_USER_ID = "name"
        const val POST_TITLE = "hour"
        const val POST_BODY = "minute"
    }
}