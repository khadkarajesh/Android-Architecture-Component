package com.crushcoder.movie;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import timber.log.Timber;

public class RectangleShape extends View {
    Paint paint;

    public RectangleShape(Context context) {
        this(context, null);
    }

    public RectangleShape(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectangleShape(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#FE763A"));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rect = new RectF(0, 0, getWidth(), getHeight());
        //canvas.drawRoundRect(rect, 20, 20, paint);

        float bottom_center_x = rect.centerX() + rect.width() / 2;
        float bottom_center_y = rect.centerY() + rect.height() / 2;

        Timber.d("rect center x = " + rect.centerX() + " y =" + rect.centerY());
        Timber.d("rect traingle x =" + rect.centerX() + "y =" + bottom_center_y);

        int point_a_x = (int) (rect.centerX() - 80);
        int point_a_y = (int) bottom_center_y;

        int point_b_x = point_a_x + 80;
        int point_b_y = (int) (bottom_center_y + 80);

        int point_c_x = point_b_x + 80;
        int point_c_y = point_b_y - 80;

        Timber.d("rect traingle first point a_x " + point_a_x + "point a_y " + point_a_y);
        Timber.d("rect traingle second point b_x " + point_b_x + "point b_y " + point_b_y);

        int traingleSize = 100;

        Point point_a = new Point(point_a_x, point_a_y);
        Point point_b = new Point(point_b_x, point_b_y);
        Point point_c = new Point(point_c_x, point_c_y);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.lineTo(point_a.x, point_a.y);
        path.lineTo(point_b.x, point_b.y);
        path.lineTo(point_c.x, point_c.y);
        path.close();
        canvas.drawPath(path, paint);
    }
}
