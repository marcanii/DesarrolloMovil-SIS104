package com.example.primerparcial.backend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.graphics.Path;
import androidx.annotation.NonNull;

public class Grafico extends View {
    private static final String TAG = "GRAFICO";
    public Grafico(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.argb(255, 125, 100, 180));
        Paint paint = new Paint();
        drawTriangle(canvas, paint, 400);
    }

    private void drawTriangle(Canvas canvas, Paint paint, int n) {
        float centerX = canvas.getWidth() / 2f;
        float centerY = canvas.getHeight() / 2f;
        float halfSideLength = n / 2f;
        float height = (float) (n * Math.sqrt(3) / 2);

        // Calcular las coordenadas de los vértices del triángulo equilátero
        float[] verticesX = {
                centerX - halfSideLength,
                centerX + halfSideLength,
                centerX
        };

        float[] verticesY = {
                centerY + height / 2,
                centerY + height / 2,
                centerY - height / 2
        };

        // Dibujar el triángulo equilátero
        Path trianglePath = new Path();
        trianglePath.moveTo(verticesX[0], verticesY[0]);
        trianglePath.lineTo(verticesX[1], verticesY[1]);
        trianglePath.lineTo(verticesX[2], verticesY[2]);
        trianglePath.close();

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        canvas.drawPath(trianglePath, paint);

        // Dibujar las mediatrices
        for (int i = 0; i < 3; i++) {
            int nextIndex = (i + 1) % 3;
            float startX = verticesX[i];
            float startY = verticesY[i];
            float endX = verticesX[nextIndex];
            float endY = verticesY[nextIndex];

            drawMediatriz(canvas, paint, startX, startY, endX, endY);
        }
    }
    private void drawMediatriz(Canvas canvas, Paint paint, float startX, float startY, float endX, float endY) {
        float dx = endX - startX;
        float dy = endY - startY;
        float midX = (startX + endX) / 2;
        float midY = (startY + endY) / 2;
        float perpEndX = midX + dy;
        float perpEndY = midY - dx;
        canvas.drawLine(midX, midY, perpEndX, perpEndY, paint);
    }
}
