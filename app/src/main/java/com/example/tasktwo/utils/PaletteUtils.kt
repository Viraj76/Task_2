package com.example.tasktwo.utils


import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Shader
import android.util.Log
import androidx.palette.graphics.Palette

object PaletteUtils {
    fun getUpperSideDominantColor(bitmap: Bitmap): Int {
        val builder = Palette.Builder(bitmap)
            .setRegion(0, 0, bitmap.width, bitmap.height / 2)
        val defaultValue = 0xFFFFFF
        val p = builder.generate()
        return p.getDominantColor(defaultValue)
    }

    fun getLowerSideDominantColor(bitmap: Bitmap): Int {
        val defaultValue = 0xFFFFFF
        val builder = Palette.Builder(bitmap)
            .setRegion(0, bitmap.height / 2, bitmap.width, bitmap.height)
        return builder.generate().getDominantColor(defaultValue)
    }

    fun getDominantGradient(bitmap: Bitmap, height: Int, width: Int): Bitmap {
        var topColor = 0
        var bottomColor = 0
        topColor = getUpperSideDominantColor(bitmap)
        bottomColor = getLowerSideDominantColor(bitmap)
        val topHex = Integer.toHexString(topColor).trim()
        val topHexFinal = "#$topHex"

        val bottomHex = Integer.toHexString(bottomColor).trim()
        val bottomHexFinal = "#$bottomHex"

        Log.e("color ", topHexFinal)
        Log.e("color ", bottomHexFinal)
        val colors = intArrayOf(Color.parseColor(topHexFinal), Color.parseColor(bottomHexFinal))
        val mShader = LinearGradient(0f, 0f, width / 2.toFloat(), height / 2.toFloat(), colors, null, Shader.TileMode.CLAMP)
        val m = Matrix()
        m.setRotate(90f)
        mShader.setLocalMatrix(m)
        val paint = Paint()
        paint.shader = mShader
        val resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(resultBitmap)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
        val matrix = Matrix()
        canvas.drawBitmap(resultBitmap, matrix, paint)
        return resultBitmap
    }
}
