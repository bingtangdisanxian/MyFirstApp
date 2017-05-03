package com.project.mine.wedgit.toast;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.project.mine.util.TypedValueUtils.getTypedValueInDP;


/**
 * Created by chenqi on 2017/2/19.
 * 描述:可以给吐司设置动画,图片,背景,文字颜色等....
 */
public class CustomToast implements OnToastFinished {

    private static final String DEFAULT_CONDENSED_FONT = "sans-serif-condensed";
    private static final int DEFAULT_BACKGROUND = Color.parseColor("#555555");
    private static final int DEFAULT_TEXT_COLOR = Color.WHITE;
    private static final int DEFAULT_TEXT_SIZE = 16;
    private static final int DEFAULT_CORNER_RADIUS = 25;
    private static final int DEFAULT_HORIZONTAL_PADDING = 25;
    private static final int DEFAULT_VERTICAL_PADDING = 11;
    private static final int DEFAULT_ALPHA = 230;
    private static int MAX_ALPHA = 255;

    private final Context context;
    private TextView textView;
    private Typeface font;

    private float strokeWidth;
    private int duration, style, alpha, drawable;
    private int backgroundColor, textColor, strokeColor;
    private int cornerRadius = -1;
    private boolean isBold;
    private boolean isAnimation;
    private String toastMsg;

    public CustomToast(Context context) {
        this.context = context.getApplicationContext();
    }

    public CustomToast(Context context, String toastMsg, int duration) {
        this.context = context.getApplicationContext();
        this.toastMsg = toastMsg;
        this.duration = duration;
    }

    public CustomToast(Context context, String toastMsg, int duration, @StyleRes int styleId) {
        this.context = context.getApplicationContext();
        this.toastMsg = toastMsg;
        this.duration = duration;
        this.style = styleId;
    }

    public void setStyle(@StyleRes int style) {
        this.style = style;
    }

    public void setBoldText() {
        isBold = true;
    }

    public void setTextFont(Typeface typeface) {
        this.font = typeface;
    }

    public void setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
    }

    public void setTextStyle(boolean isBold, Typeface font) {
        this.isBold = isBold;
        this.font = font;
    }

    public void setTextStyle(@ColorInt int textColor, Typeface font) {
        this.textColor = textColor;
        this.font = font;
    }

    public void setTextStyle(@ColorInt int textColor, boolean isBold) {
        this.textColor = textColor;
        this.isBold = isBold;
    }

    public void setTextStyle(@ColorInt int textColor, boolean isBold, Typeface font) {
        this.textColor = textColor;
        this.isBold = isBold;
        this.font = font;
    }

    public CustomToast spinIcon() {
        isAnimation = true;
        return this;
    }

    public void setBackgroundColor(@ColorInt int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setToastStroke(int strokeWidth, @ColorInt int strokeColor) {
        this.strokeWidth = strokeWidth;
        this.strokeColor = strokeColor;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public void setMaxAlpha() {
        this.alpha = MAX_ALPHA;
    }

    public void setIcon(@DrawableRes int drawable) {
        this.drawable = drawable;
    }

    private Toast buildToast() {
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setView(getToastLayout());
        return toast;
    }

    private View getToastLayout() {
        getImageViewStyleAttr();
        int horizontalPadding = (int) getTypedValueInDP(context, DEFAULT_HORIZONTAL_PADDING);
        int verticalPadding = (int) getTypedValueInDP(context, DEFAULT_VERTICAL_PADDING);
        RelativeLayout toastLayout = new RelativeLayout(context);
        toastLayout.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        toastLayout.setBackground(getToastShape());
        toastLayout.addView(getTextView());
        if (drawable > 0) {
            toastLayout.addView(getIcon());
            toastLayout.setPadding(0, verticalPadding, 0, verticalPadding);
        }
        return toastLayout;
    }

    @SuppressWarnings("ResourceType")
    private void getToastShapeAttrs() {
        if (style > 0) {
            int[] colorAttrs = {android.R.attr.colorBackground, android.R.attr.strokeColor};
            int[] floatAttrs = {android.R.attr.alpha, android.R.attr.strokeWidth};
            int[] dimenAttrs = {android.R.attr.radius};
            TypedArray colors = context.obtainStyledAttributes(style, colorAttrs);
            TypedArray floats = context.obtainStyledAttributes(style, floatAttrs);
            TypedArray dimens = context.obtainStyledAttributes(style, dimenAttrs);
            backgroundColor = colors.getColor(0, DEFAULT_BACKGROUND);
            cornerRadius = (int) dimens.getDimension(0, DEFAULT_CORNER_RADIUS);
            alpha = (int) floats.getFloat(0, DEFAULT_ALPHA);
            if (Build.VERSION.SDK_INT >= 21) {
                strokeWidth = floats.getFloat(1, 0);
                strokeColor = colors.getColor(1, Color.TRANSPARENT);
            }
            colors.recycle();
            floats.recycle();
            dimens.recycle();
        }
    }

    private GradientDrawable getToastShape() {
        getToastShapeAttrs();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getShapeCornerRadius());
        gradientDrawable.setStroke((int) getStrokeWidth(), getStrokeColor());
        gradientDrawable.setColor(getBackgroundColor());
        gradientDrawable.setAlpha(getShapeAlpha());
        return gradientDrawable;
    }

    private void getTextStylesAttr() {
        if (style > 0) {
            int[] colorAttrs = {android.R.attr.textColor};
            int[] stringAttrs = {android.R.attr.fontFamily};
            int[] intsAttrs = {android.R.attr.textStyle};
            TypedArray colors = context.obtainStyledAttributes(style, colorAttrs);
            TypedArray strings = context.obtainStyledAttributes(style, stringAttrs);
            TypedArray ints = context.obtainStyledAttributes(style, intsAttrs);

            textColor = colors.getColor(0, DEFAULT_TEXT_COLOR);
            String passedFont = strings.getString(0);

            if (passedFont != null && !passedFont.isEmpty()) {
                if (passedFont.contains("fonts")) {
                    font = Typeface.createFromAsset(context.getAssets(), passedFont);
                } else {
                    font = Typeface.create(passedFont, Typeface.NORMAL);
                }
            }
            if (ints.getInt(0, 0) == 1) {
                isBold = true;
            } else {
                isBold = false;
            }
            colors.recycle();
            strings.recycle();
            ints.recycle();
        }
    }

    private TextView getTextView() {
        getTextStylesAttr();
        textView = new TextView(context);
        textView.setText(toastMsg);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, DEFAULT_TEXT_SIZE);
        textView.setTextColor(getTextColor());
        textView.setTypeface(getTypeface());
        textView.setMaxLines(2);
        if (drawable > 0) {
            int leftPadding = (int) getTypedValueInDP(context, 18 * 2 + 5);
            int rightPadding = (int) getTypedValueInDP(context, 22);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            textView.setLayoutParams(layoutParams);
            textView.setPadding(leftPadding, 0, rightPadding, 0);
        }
        return textView;
    }

    private Animation getAnimation() {
        if (isAnimation) {
            RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setInterpolator(new LinearInterpolator());
            anim.setRepeatCount(Animation.INFINITE);
            anim.setDuration(1000);
            return anim;
        }
        return null;
    }

    private void getImageViewStyleAttr() {
        if (style > 0) {
            int[] drawableAttrSet = {android.R.attr.icon};
            TypedArray drawableId = context.obtainStyledAttributes(style, drawableAttrSet);
            drawable = drawableId.getResourceId(0, 0);
            drawableId.recycle();
        }
    }

    private ImageView getIcon() {
        if (drawable > 0) {
            int marginLeft = (int) getTypedValueInDP(context, 15);
            int maxHeightVal = (int) getTypedValueInDP(context, 20);
            int maxWidthVal = (int) getTypedValueInDP(context, 20);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(context.getResources().getDrawable(drawable));
            imageView.setAnimation(getAnimation());
            imageView.setMaxWidth(marginLeft + maxWidthVal);
            imageView.setMaxHeight(maxHeightVal);
            imageView.setAdjustViewBounds(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(marginLeft, 0, 0, 0);
            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
            imageView.setLayoutParams(layoutParams);
            return imageView;
        }
        return null;
    }

    private float getStrokeWidth() {
        return getTypedValueInDP(context, strokeWidth);
    }

    private int getStrokeColor() {
        return strokeColor;
    }

    private float getShapeCornerRadius() {
        if (cornerRadius >= 0) {
            return getTypedValueInDP(context, cornerRadius);
        } else {
            return getTypedValueInDP(context, DEFAULT_CORNER_RADIUS);
        }
    }

    private int getBackgroundColor() {
        if (backgroundColor == 0) {
            return DEFAULT_BACKGROUND;
        } else {
            return backgroundColor;
        }
    }

    private int getShapeAlpha() {
        if (alpha == 0) {
            return DEFAULT_ALPHA;
        } else {
            return alpha;
        }
    }

    private Typeface getTypeface() {
        if (isBold && font == null) {
            return Typeface.create(DEFAULT_CONDENSED_FONT, Typeface.BOLD);
        } else if (isBold && font != null) {
            return Typeface.create(font, Typeface.BOLD);
        } else if (font != null) {
            return Typeface.create(font, Typeface.NORMAL);
        } else {
            return Typeface.create(DEFAULT_CONDENSED_FONT, Typeface.NORMAL);
        }
    }

    @ColorInt
    private int getTextColor() {
        if (textColor == 0 && style <= 0) {
            return DEFAULT_TEXT_COLOR;
        } else {
            return textColor;
        }
    }

    public void show() {
        buildToast().show();
        if (isAnimation) {
            ToastDurationWatcher durationWatcher = new ToastDurationWatcher(buildToast().getDuration(), this);
        }
    }

    @Override
    public void onToastFinished() {
        getAnimation().cancel();
        getAnimation().reset();
    }

    public static CustomToast makeText(Context context, CharSequence text, int duration, int style) {
        CustomToast toast = new CustomToast(context, text.toString(), duration, style);
        return toast;
    }
}
