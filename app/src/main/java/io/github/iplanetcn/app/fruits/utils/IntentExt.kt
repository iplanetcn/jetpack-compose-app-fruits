package io.github.iplanetcn.app.fruits.utils

import android.content.Intent
import android.os.Build
import java.io.Serializable

/**
 * IntentExt
 *
 * @author john
 * @since 2022-11-30
 */
fun <T : Serializable?> Intent.getSerializable(key: String, clazz: Class<T>): T {

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializableExtra(key, clazz)!!
    } else {
        @Suppress("DEPRECATION", "UNCHECKED_CAST")
        this.getSerializableExtra(key) as T
    }
}