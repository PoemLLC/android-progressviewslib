

package com.natasa.progressviews.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;

public class ColorsHelper {
	static int[] colors2 = { Color.parseColor("#fb0000"),
			Color.parseColor("#fbf400"), Color.parseColor("#00FF00") };
	private boolean isAllowedMatchParent;
	static int[] colors1;
	public ColorsHelper() {
	}

	public int[] getColors2() {
		return colors2;
	}

	public static void setColors2(int[] colors) {
		colors1 = colors;
	}

	// *******************************GRADIENT
	// METHODS*****************************
	public static void setGradientPaint(Paint paint, float left, float top,
			float right, float bottom) {

		setGradientPaint(paint, left, top, right, bottom, colors2);
	}

	public static void setGradientPaint(Paint paint, float left, float top,
			float right, float bottom, int[] colors2) {
		LinearGradient linearGradient = new LinearGradient(left, top, right,
				bottom, colors2, null, TileMode.CLAMP);
		paint.setShader(linearGradient);
		paint.setAntiAlias(true);
	}

	public static void setRadialGradientPaint(Paint paint, float left,
			float top, float width) {
		setRadialGradientPaint(paint, left, top, width, colors2);
	}

	protected static void setRadialGradientPaint(Paint paint, float left,
			float top, float width, int[] colors2) {
		RadialGradient linearGradient = new RadialGradient(left, top, width,
				colors2, null, TileMode.CLAMP);
		paint.setShader(linearGradient);
		paint.setAntiAlias(true);
	}

	// *********************************END OF GRADIENT
	// METHODS**************************************************
	public static void drawTextCenter(Canvas canvas, String text, int color,
			int min) {
		Paint innerPaint = new Paint();
		// innerPaint.setARGB(255, 117, 161, 220); // blue
		innerPaint.setAntiAlias(true);
		innerPaint.setStyle(Style.FILL);
		innerPaint.setColor(color);
		innerPaint.setTextSize(48);
		// int cHeight = canvas.getClipBounds().height();
		// int cWidth = canvas.getClipBounds().width();
		Rect r = new Rect();
		// setTextMatchParent(text,innerPaint,width-strokeWidth*2-25);
		innerPaint.setTextAlign(Paint.Align.LEFT);
		innerPaint.getTextBounds(text, 0, text.length(), r);
		float x = min / 2f - r.width() / 2f - r.left;
		float y = min / 2f + r.height() / 2f - r.bottom;

		canvas.drawText(text, x, y, innerPaint);
	}

	private void setTextMatchParent(String text, Paint paint, float desiredWidth) {
		calculateTextlength(text);
		if (isAllowedMatchParent) {
			setTextSizeForWidth(text, paint, desiredWidth);
		}
	}

	private void calculateTextlength(String text) {
		int textLength = text.length();
		if (textLength > 4) {
			isAllowedMatchParent = true;
		} else {
			final float testTextSize = 38f;
		}
	}

	private static void setTextSizeForWidth(String text, Paint paint,
			float desiredWidth) {

		final float testTextSize = 48f;
		paint.setTextSize(testTextSize);
		Rect bounds = new Rect();
		paint.getTextBounds(text, 0, text.length(), bounds);
		float desiredTextSize = testTextSize * desiredWidth / bounds.width();
		paint.setTextSize(desiredTextSize);
	}

	@Deprecated
	private void drawText(String text, Canvas canvas) {
		Paint innerPaint = new Paint();
		innerPaint.setAntiAlias(true);
		innerPaint.setStyle(Style.FILL);
		innerPaint.setColor(Color.BLACK);
		int xPos = (canvas.getWidth() / 2);
		int yPos = (int) ((canvas.getHeight() / 2) - ((innerPaint.descent() + innerPaint
				.ascent()) / 2));

		canvas.drawText(text, xPos, yPos, innerPaint);
	}

}