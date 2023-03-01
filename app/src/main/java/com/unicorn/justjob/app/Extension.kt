package com.unicorn.justjob.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.TypedValue
import android.widget.TextView
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.blankj.utilcode.util.ToastUtils
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException



fun Activity.startAct(targetClass: Class<*>, finishSelf: Boolean = false) {
    startActivity(Intent(this, targetClass))
    if (finishSelf) finish()
}

fun Context.startAct(cls: Class<*>) {
    startActivity(Intent(this, cls))
}

fun Fragment.startAct(cls: Class<*>, finishAct: Boolean = false) {
    requireActivity().startAct(cls, finishSelf = finishAct)
}

fun TextView.trimText() = text.toString().trim()

fun TextView.isEmpty(): Boolean = trimText().isEmpty()

fun String?.toast() = this.let { ToastUtils.showShort(it) }

fun ViewPager2.removeEdgeEffect() {
    (this.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
}


fun Throwable.errorMsg(): String {
    val errorMsg = when (this) {
        is UnknownHostException -> "没有网络"
        is SocketTimeoutException -> "超时了"
        is HttpException -> when (code()) {
            500 -> "服务器内部错误"
            else -> "错误码${code()}"
        }
        else -> toString()
    }
    return errorMsg
}

fun Throwable.toast(): Unit {
    this.errorMsg().toast()
}

//fun Long.toDisplayDateFormat(): String = DateTime(this).toString(displayDateFormat)

@ColorInt
fun Context.getAttrColor(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}
