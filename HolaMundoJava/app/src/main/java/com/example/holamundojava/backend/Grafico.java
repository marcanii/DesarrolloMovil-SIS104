package com.example.holamundojava.backend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class Grafico extends View {
    private static final String TAG = "GRAFICO";

    String tipoGrafico;
    public Grafico(Context context, String tipoGrafico) {
        super(context);
        this.tipoGrafico = tipoGrafico;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.argb(255, 125, 100, 180));
        Paint paint = new Paint();

        if (tipoGrafico.equals("linea")) {
            drawLineas(canvas, paint);
        } else if (tipoGrafico.equals("circulo")) {
            drawCirculos(canvas, paint);
        } else if (tipoGrafico.equals("ramdonCirculo")) {
            ramdonCircles(canvas, paint);
        } else if (tipoGrafico.equals("arbol")) {
            drawArbol(canvas, paint);
        } else if (tipoGrafico.equals("2D")) {
            planoCartesiano2D(canvas, paint);
        } else if (tipoGrafico.equals("3D")) {
            planoCartesiano3D(canvas, paint);
        }
    }
    private void planoCartesiano3D(Canvas canvas, Paint paint) {
        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        int ancho = getWidth();
        int alto = getHeight();
        // dibjuar los 3 ejes
        canvas.drawLine(0, alto/2, ancho, alto/2, paint);
        canvas.drawLine(ancho/2, 0, ancho/2, alto, paint);
        canvas.drawLine(ancho/2-500, alto/2+500, ancho/2+500, alto/2-500, paint);
        paint.setColor(Color.YELLOW);

        for(float j=0; j<=10; j+=0.03){
            float limitInfX = -20+j;
            float limitSupX = 20+j;
            float LimitInfY = -20+j;
            float LimitSupY = 20+j;
            for (float x = limitInfX; x <= limitSupX; x += 0.1) {
                double Y = fx(x);
                double xt = ((x - limitInfX) / (limitSupX - limitInfX)) * ancho;
                double yt = alto - ((Y - LimitInfY) / (LimitSupY - LimitInfY)) * alto;
                //ouble zt = ((x - limitInfZ) / (limitSupZ - limitInfZ)) * ancho;
                paint.setColor(Color.YELLOW);
                canvas.drawCircle((float) xt, (float) yt, 3, paint);
            }
        }
    }
    private void planoCartesiano2D(Canvas canvas, Paint paint) {
        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        int ancho = getWidth();
        int alto = getHeight();
        Log.d(TAG, "ancho: " + ancho + " alto: " + alto);
        canvas.drawLine(0, alto/2, ancho, alto/2, paint);
        canvas.drawLine(ancho/2, 0, ancho/2, alto, paint);
        float limInfX = -20;
        float limSupX = 20;
        float limInfY = -20;
        float limSupY = 20;
        paint.setColor(Color.YELLOW);
        // f de (x) = x^2
        for (float x = limInfX; x <= limSupX; x+=0.01) {
            float y = fx(x);
            //Log.d(TAG, "x: " + x + " y: " + y);
            float xt = (x-limInfX)/(limSupX-limInfX)*ancho;
            float yt = alto - (((y-limInfY)/(limSupY-limInfY))*alto);
            canvas.drawCircle(xt, yt, 3, paint);
            Log.d(TAG, "x"+x+"xt: " + xt + " y"+y+"yt: " + yt);
        }
    }
    private float fx(float x) {
        return x*x;
    }
    private void ramdonCircles(Canvas canvas, Paint paint) {
        for (int i = 0; i < 200; i++) {
            int x = (int) (Math.random() * 1000);
            int y = (int) (Math.random() * 2000);
            int r = (int) (Math.random() * 100);
            paint.setColor(Color.argb(100, 10*i+5, 5*i+10, 3*i+20));
            canvas.drawCircle(x, y, r, paint);
        }
    }
    private void drawCirculos(Canvas canvas, Paint paint) {
        for (int i = 0; i < 200; i++) {
            paint.setColor(Color.argb(100, 10*i+5, 5*i+10, 3*i+20));
            canvas.drawCircle(200+i*3, 1000+i*2, 150, paint);
        }
    }
    private void drawLineas(Canvas canvas, Paint paint) {
        for (int i = 0; i < 200; i++) {
            paint.setColor(Color.argb(100, 10*i+5, 5*i+10, 3*i+20));
            canvas.drawLine(10, 10, 600-i*3, 3*i, paint);
        }
    }
    private void drawArbol(Canvas canvas, Paint paint) {
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.argb(255, 0, 255, 0));
        // hojas del arbol
        for (int i = 0; i < 320; i++) {
            canvas.drawLine(500, 300, 1000-i*3, 1300, paint);
        }
        // tronco del arbol
        for (int i = 0; i < 170; i++) {
            paint.setColor(Color.argb(200, 100, 50, 0));
            canvas.drawLine(450+i, 1300, 450+i, 1700, paint);
        }
        // focos de luz del arbol
        ramdonCirculosArbol(canvas, paint);

    }
    private void ramdonCirculosArbol(Canvas canvas, Paint paint) {
        // Puntos del triángulo
        int x1 = 500, y1 = 300;
        int x2 = 50, y2 = 1300;
        int x3 = 1000, y3 = 1300;

        // Generar círculos aleatorios dentro del triángulo
        for (int i = 0; i < 150; i++) {
            paint.setColor(Color.argb(100, 10*i+5, 5*i+10, 3*i+20));
            // Generar coordenadas aleatorias dentro del triángulo
            double r1 = Math.random();
            double r2 = Math.random();

            // Asegurarse de que los puntos estén dentro del triángulo
            if ((r1 + r2) <= 1) {
                int x = (int) (x1 + r1 * (x2 - x1) + r2 * (x3 - x1));
                int y = (int) (y1 + r1 * (y2 - y1) + r2 * (y3 - y1));
                int radius = (int) (Math.random() * 70);
                canvas.drawCircle(x, y, radius, paint);
            }
        }
    }
}
