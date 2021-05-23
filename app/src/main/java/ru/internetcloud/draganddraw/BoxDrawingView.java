package ru.internetcloud.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class BoxDrawingView extends View {

    private static final String TAG = "rustam";

    private Box currentBox;
    private List<Box> boxList = new ArrayList<>();

    private Paint boxPaint;
    private Paint backgroundPaint;


    // Конструтор № 1, используется при создании представления в коде
    public BoxDrawingView(Context context) {
        this(context, null); // вызов другого конструктора
    }

    // Конструктор № 2, используется при заполнении представления по разметке XML
    public BoxDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // Прямоугольники рисуются полупрозрачным красным цветом (ARGB)
        boxPaint = new Paint();
        boxPaint.setColor(0x22ff0000);

        backgroundPaint = new Paint();
        backgroundPaint.setColor(0xfff8efe0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // срабатывает при касании.
        PointF currentPointF = new PointF(event.getX(), event.getY());

        String action = "";
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // касание
                action = "ACTION_DOWN";
                currentBox = new Box(currentPointF);
                boxList.add(currentBox);
                break;

            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                if (currentBox != null) {
                    currentBox.setCurrentPointF(currentPointF);
                    invalidate(); // заставляет BoxDrawingView перерисовать себя, чтобы пользователь видел прямоугольник в процессе перетаскивания
                }
                break;

            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                currentBox = null;
                break;

            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                currentBox = null;
                break;
        }

        Log.i(TAG, action + " at x=" + currentPointF.x + ", y=" + currentPointF.y);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // заполнение фона:
        canvas.drawPaint(backgroundPaint);

        for (Box box : boxList) {
            float left = Math.min(box.getStartPointF().x, box.getCurrentPointF().x);
            float right = Math.max(box.getStartPointF().x, box.getCurrentPointF().x);

            float top = Math.min(box.getStartPointF().y, box.getCurrentPointF().y);
            float bottom = Math.max(box.getStartPointF().y, box.getCurrentPointF().y);

            canvas.drawRect(left, top, right, bottom, boxPaint);
        }
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }
}
