package com.example.holamundokotlin.backend

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.view.View


class Grafico(context: Context?, var tipoGrafico: String) : View(context) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.argb(255, 125, 100, 180))
        val paint = Paint()
        if (tipoGrafico == "cuadrado") {
            drawCuadrado(canvas, paint, 500.0f)
        } else if(tipoGrafico == "cubo"){
            drawCubo(canvas, paint, 500.0f)
        } else if (tipoGrafico == "2D") {
            planoCartesiano2D(canvas, paint)
        } else if (tipoGrafico == "3D") {
            planoCartesiano3D(canvas, paint)
        } else if (tipoGrafico == "caratula"){
            drawCaratula(canvas, paint);
        }
    }

    private fun drawCaratula(canvas: Canvas, paint: Paint) {
        // Fondo gradiente
        val gradient = LinearGradient(
            0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(),
            Color.rgb(0, 128, 128), Color.rgb(0, 0, 255),
            Shader.TileMode.CLAMP
        )
        paint.shader = gradient
        canvas.drawRect(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(), paint)

        // Dibujar patrón en la parte superior
        paint.shader = null
        paint.color = Color.YELLOW
        for (i in 0 until canvas.width step 40) {
            canvas.drawLine(i.toFloat(), 0f, (i + 20).toFloat(), 100f, paint)
            canvas.drawLine((i + 20).toFloat(), 100f, (i + 40).toFloat(), 0f, paint)
        }

        // Dibujar patrón en la parte inferior
        paint.color = Color.MAGENTA
        for (i in 0 until canvas.width step 40) {
            canvas.drawLine(i.toFloat(), canvas.height.toFloat(), (i + 20).toFloat(), canvas.height.toFloat() - 100f, paint)
            canvas.drawLine((i + 20).toFloat(), canvas.height.toFloat() - 100f, (i + 40).toFloat(), canvas.height.toFloat(), paint)
        }

        paint.setColor(Color.YELLOW)
        paint.strokeWidth = 3f
        for (i in 0..17) {
            canvas.drawLine(200f, 550f, 900f-20f*i, (550 +20*i).toFloat(), paint)
            canvas.drawLine(900f, 550f, 200f+20f*i, (550 +20*i).toFloat(), paint)
        }
        val centerX = canvas.width / 2f + 50f
        val centerY = 1500f
        var lado = 400f
        val halfLado = lado / 2f
        paint.setColor(Color.MAGENTA)
        // Establecer el grosor de la línea y el color
        paint.strokeWidth = 5f  // Grosor de la línea

        // Coordenadas de los vértices del cubo
        val vertices = arrayOf(
            floatArrayOf(centerX - halfLado, centerY - halfLado),  // Vértice 0 (frontal superior izquierdo)
            floatArrayOf(centerX + halfLado, centerY - halfLado),  // Vértice 1 (frontal superior derecho)
            floatArrayOf(centerX + halfLado, centerY + halfLado),  // Vértice 2 (frontal inferior derecho)
            floatArrayOf(centerX - halfLado, centerY + halfLado),  // Vértice 3 (frontal inferior izquierdo)
            floatArrayOf(centerX - halfLado - lado / 4, centerY - halfLado - lado / 4),  // Vértice 4 (trasero superior izquierdo)
            floatArrayOf(centerX + halfLado - lado / 4, centerY - halfLado - lado / 4),  // Vértice 5 (trasero superior derecho)
            floatArrayOf(centerX + halfLado - lado / 4, centerY + halfLado - lado / 4),  // Vértice 6 (trasero inferior derecho)
            floatArrayOf(centerX - halfLado - lado / 4, centerY + halfLado - lado / 4)   // Vértice 7 (trasero inferior izquierdo)
        )

        // Dibujar líneas para formar las aristas del cubo
        canvas.drawLine(vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], paint) // Arista frontal superior
        canvas.drawLine(vertices[1][0], vertices[1][1], vertices[2][0], vertices[2][1], paint) // Arista frontal derecha
        canvas.drawLine(vertices[2][0], vertices[2][1], vertices[3][0], vertices[3][1], paint) // Arista frontal inferior
        canvas.drawLine(vertices[3][0], vertices[3][1], vertices[0][0], vertices[0][1], paint) // Arista frontal izquierda

        canvas.drawLine(vertices[4][0], vertices[4][1], vertices[5][0], vertices[5][1], paint) // Arista trasera superior
        canvas.drawLine(vertices[5][0], vertices[5][1], vertices[6][0], vertices[6][1], paint) // Arista trasera derecha
        canvas.drawLine(vertices[6][0], vertices[6][1], vertices[7][0], vertices[7][1], paint) // Arista trasera inferior
        canvas.drawLine(vertices[7][0], vertices[7][1], vertices[4][0], vertices[4][1], paint) // Arista trasera izquierda

        canvas.drawLine(vertices[0][0], vertices[0][1], vertices[4][0], vertices[4][1], paint) // Arista superior izquierda
        canvas.drawLine(vertices[1][0], vertices[1][1], vertices[5][0], vertices[5][1], paint) // Arista superior derecha
        canvas.drawLine(vertices[2][0], vertices[2][1], vertices[6][0], vertices[6][1], paint) // Arista inferior derecha
        canvas.drawLine(vertices[3][0], vertices[3][1], vertices[7][0], vertices[7][1], paint)

        // Configurar el color y el tamaño del texto
        paint.color = Color.MAGENTA
        paint.textSize = 120f

        // Dibujar el texto "SIS104"
        val textSIS104 = "SIS104"
        val xSIS104 = canvas.width / 2f - 140f
        val ySIS104 = 500f
        canvas.drawText(textSIS104, xSIS104, ySIS104, paint)

        // Dibujar el texto "MAAI"
        paint.color = Color.YELLOW
        val textMAAI = "MAAI"
        val xMAAI = canvas.width / 2f - 90f
        val yMAAI = 1500f
        canvas.drawText(textMAAI, xMAAI, yMAAI, paint)
    }

    private fun planoCartesiano3D(canvas: Canvas, paint: Paint) {
        canvas.drawColor(Color.BLACK)
        paint.setColor(Color.WHITE)
        paint.strokeWidth = 5f
        val ancho = width
        val alto = height
        // dibjuar los 3 ejes
        canvas.drawLine(0f, (alto / 2).toFloat(), ancho.toFloat(), (alto / 2).toFloat(), paint)
        canvas.drawLine((ancho / 2).toFloat(), 0f, (ancho / 2).toFloat(), alto.toFloat(), paint)
        canvas.drawLine(
            (ancho / 2 - 500).toFloat(),
            (alto / 2 + 500).toFloat(),
            (ancho / 2 + 500).toFloat(),
            (alto / 2 - 500).toFloat(),
            paint
        )
        paint.setColor(Color.YELLOW)
        var j = 0f
        while (j <= 10) {
            val limitInfX = -20 + j
            val limitSupX = 20 + j
            val LimitInfY = -20 + j
            val LimitSupY = 20 + j
            var x = limitInfX
            while (x <= limitSupX) {
                val Y = fx(x).toDouble()
                val xt = ((x - limitInfX) / (limitSupX - limitInfX) * ancho).toDouble()
                val yt = alto - (Y - LimitInfY) / (LimitSupY - LimitInfY) * alto
                //ouble zt = ((x - limitInfZ) / (limitSupZ - limitInfZ)) * ancho;
                paint.setColor(Color.YELLOW)
                canvas.drawCircle(xt.toFloat(), yt.toFloat(), 3f, paint)
                x += 0.1.toFloat()
            }
            j += 0.03.toFloat()
        }
    }

    private fun planoCartesiano2D(canvas: Canvas, paint: Paint) {
        canvas.drawColor(Color.BLACK)
        paint.setColor(Color.WHITE)
        paint.strokeWidth = 5f
        val ancho = width
        val alto = height
        canvas.drawLine(0f, (alto / 2).toFloat(), ancho.toFloat(), (alto / 2).toFloat(), paint)
        canvas.drawLine((ancho / 2).toFloat(), 0f, (ancho / 2).toFloat(), alto.toFloat(), paint)
        val limInfX = -20f
        val limSupX = 20f
        val limInfY = -20f
        val limSupY = 20f
        paint.setColor(Color.YELLOW)
        // f de (x) = x^2
        var x = limInfX
        while (x <= limSupX) {
            val y = fx(x)
            //Log.d(TAG, "x: " + x + " y: " + y);
            val xt = (x - limInfX) / (limSupX - limInfX) * ancho
            val yt = alto - (y - limInfY) / (limSupY - limInfY) * alto
            canvas.drawCircle(xt, yt, 3f, paint)
            x += 0.01.toFloat()
        }
    }

    private fun fx(x: Float): Float {
        return x * x
    }
    private fun drawCubo(canvas: Canvas, paint: Paint, ladoA: Float) {
        val centerX = canvas.width / 2f
        val centerY = canvas.height / 2f
        val screenWidth = canvas.width.toFloat()
        var lado = 0.0f
        if (ladoA > screenWidth){
            lado = calcularLadoEscalado(screenWidth, ladoA)
        } else {
            lado = ladoA
        }
        val halfLado = lado / 2f

        // Establecer el grosor de la línea y el color
        paint.strokeWidth = 5f  // Grosor de la línea
        paint.color = Color.CYAN  // Color de la línea

        // Coordenadas de los vértices del cubo
        val vertices = arrayOf(
            floatArrayOf(centerX - halfLado, centerY - halfLado),  // Vértice 0 (frontal superior izquierdo)
            floatArrayOf(centerX + halfLado, centerY - halfLado),  // Vértice 1 (frontal superior derecho)
            floatArrayOf(centerX + halfLado, centerY + halfLado),  // Vértice 2 (frontal inferior derecho)
            floatArrayOf(centerX - halfLado, centerY + halfLado),  // Vértice 3 (frontal inferior izquierdo)
            floatArrayOf(centerX - halfLado - lado / 4, centerY - halfLado - lado / 4),  // Vértice 4 (trasero superior izquierdo)
            floatArrayOf(centerX + halfLado - lado / 4, centerY - halfLado - lado / 4),  // Vértice 5 (trasero superior derecho)
            floatArrayOf(centerX + halfLado - lado / 4, centerY + halfLado - lado / 4),  // Vértice 6 (trasero inferior derecho)
            floatArrayOf(centerX - halfLado - lado / 4, centerY + halfLado - lado / 4)   // Vértice 7 (trasero inferior izquierdo)
        )

        // Dibujar líneas para formar las aristas del cubo
        canvas.drawLine(vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], paint) // Arista frontal superior
        canvas.drawLine(vertices[1][0], vertices[1][1], vertices[2][0], vertices[2][1], paint) // Arista frontal derecha
        canvas.drawLine(vertices[2][0], vertices[2][1], vertices[3][0], vertices[3][1], paint) // Arista frontal inferior
        canvas.drawLine(vertices[3][0], vertices[3][1], vertices[0][0], vertices[0][1], paint) // Arista frontal izquierda

        canvas.drawLine(vertices[4][0], vertices[4][1], vertices[5][0], vertices[5][1], paint) // Arista trasera superior
        canvas.drawLine(vertices[5][0], vertices[5][1], vertices[6][0], vertices[6][1], paint) // Arista trasera derecha
        canvas.drawLine(vertices[6][0], vertices[6][1], vertices[7][0], vertices[7][1], paint) // Arista trasera inferior
        canvas.drawLine(vertices[7][0], vertices[7][1], vertices[4][0], vertices[4][1], paint) // Arista trasera izquierda

        canvas.drawLine(vertices[0][0], vertices[0][1], vertices[4][0], vertices[4][1], paint) // Arista superior izquierda
        canvas.drawLine(vertices[1][0], vertices[1][1], vertices[5][0], vertices[5][1], paint) // Arista superior derecha
        canvas.drawLine(vertices[2][0], vertices[2][1], vertices[6][0], vertices[6][1], paint) // Arista inferior derecha
        canvas.drawLine(vertices[3][0], vertices[3][1], vertices[7][0], vertices[7][1], paint) // Arista inferior izquierda
    }


    private fun drawCuadrado(canvas: Canvas, paint: Paint, lado: Float) {
        paint.setColor(Color.CYAN)
        var ladoEscalado = 1.0f
        val screenWidth = canvas.width.toFloat()
        val screenHeight = canvas.height.toFloat()

        if (lado > screenWidth){
            ladoEscalado = calcularLadoEscalado(screenWidth, lado)
        } else {
            ladoEscalado = lado
        }

        val centerX = screenWidth / 2
        val centerY = screenHeight / 2

        val left = centerX - ladoEscalado / 2
        val top = centerY - ladoEscalado / 2
        val right = centerX + ladoEscalado / 2
        val bottom = centerY + ladoEscalado / 2

        canvas.drawRect(left, top, right, bottom, paint)
    }
    private fun calcularLadoEscalado(anchoPantalla: Float, lado: Float): Float {
        return if (lado >= 100000.0f) {
            anchoPantalla
        } else {
            lado * (anchoPantalla / 100000f)
        }
    }
}