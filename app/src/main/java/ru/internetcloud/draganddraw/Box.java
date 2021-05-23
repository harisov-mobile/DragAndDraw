package ru.internetcloud.draganddraw;

import android.graphics.PointF;

public class Box {
    private PointF startPointF;
    private PointF currentPointF;

    public Box(PointF startPointF) {
        this.startPointF = startPointF;
        this.currentPointF = startPointF;
    }

    public PointF getStartPointF() {
        return startPointF;
    }

    public PointF getCurrentPointF() {
        return currentPointF;
    }

    public void setCurrentPointF(PointF currentPointF) {
        this.currentPointF = currentPointF;
    }
}
