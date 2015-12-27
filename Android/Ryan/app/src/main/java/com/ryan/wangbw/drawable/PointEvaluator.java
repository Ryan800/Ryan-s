package com.ryan.wangbw.drawable;

import android.animation.TypeEvaluator;

/**
 * author: wangbw
 * Date: 2015-12-04
 * Time: 16:31
 * Desc:
 */
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        return new Point(x, y);
    }
}
