package com.chyrta.onboarder;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.widget.ImageView;

public class OnboarderPage {

    public String title;
    public String description;
    public Drawable[] imageResources;
    @StringRes public int titleResourceId;
    @StringRes public int descriptionResourceId;
    @DrawableRes public int[] imageResourceIds;
    @ColorRes public int titleColor;
    @ColorRes public int descriptionColor;
    @ColorRes public int backgroundColor;
    public float titleTextSize;
    public float descriptionTextSize;

    public ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;

    public OnboarderPage(String title, String description) {
        this.title = title;
        this.description = description;
        this.backgroundColor = R.color.black_transparent;
    }

    public OnboarderPage(String title, String description, int[] imageResourceIds) {
        this.title = title;
        this.description = description;
        this.imageResourceIds = imageResourceIds;
        this.backgroundColor = R.color.black_transparent;
    }

    public OnboarderPage(String title, String description, Drawable[] imageResources) {
        this.title = title;
        this.description = description;
        this.imageResources = imageResources;
        this.backgroundColor = R.color.black_transparent;
    }

    public OnboarderPage(int title, int description) {
        this.titleResourceId = title;
        this.descriptionResourceId = description;
        this.backgroundColor = R.color.black_transparent;
    }

    public OnboarderPage(int title, int description, int[] imageResourceIds) {
        this.titleResourceId = title;
        this.descriptionResourceId = description;
        this.imageResourceIds = imageResourceIds;
        this.backgroundColor = R.color.black_transparent;
    }

    public OnboarderPage(int title, int description, Drawable[] imageResources) {
        this.titleResourceId = title;
        this.descriptionResourceId = description;
        this.imageResources = imageResources;
        this.backgroundColor = R.color.black_transparent;
    }

    public String getTitle() {
        return title;
    }

    public int getTitleResourceId() {
        return titleResourceId;
    }

    public String getDescription() {
        return description;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getDescriptionColor() {
        return descriptionColor;
    }

    public void setTitleColor(int color) {
        this.titleColor = color;
    }

    public void setDescriptionColor(int color) {
        this.descriptionColor = color;
    }

    public int[] getImageResourceIds() {
        return imageResourceIds;
    }

    public OnboarderPage setImageResourceIds(int[] imageResourceIds) {
        this.imageResourceIds = imageResourceIds;
        return this;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public float getTitleTextSize() {
        return titleTextSize;
    }

    public void setTitleTextSize(float titleTextSize) {
        this.titleTextSize = titleTextSize;
    }

    public float getDescriptionTextSize() {
        return descriptionTextSize;
    }

    public void setDescriptionTextSize(float descriptionTextSize) {
        this.descriptionTextSize = descriptionTextSize;
    }

    public ImageView.ScaleType getScaleType() {
        return scaleType;
    }

    public OnboarderPage setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }
}
