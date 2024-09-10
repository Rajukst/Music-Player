package com.example.extensions.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class CustomBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    public CustomBottomSheetBehavior() {
        super();
    }

    public CustomBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // Override to add custom functionality
    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull V child, int layoutDirection) {
        // Custom layout logic
        boolean handled = super.onLayoutChild(parent, child, layoutDirection);
        // You can adjust the initial position, height, or appearance of the bottom sheet here
        if (getState() == STATE_COLLAPSED) {
            // Add custom logic for collapsed state
            child.setTranslationY(parent.getHeight() - 200);  // Example: Collapse to 200px from the bottom
        } else if (getState() == STATE_EXPANDED) {
            // Add custom logic for expanded state
            child.setTranslationY(0);  // Fully expanded
        }
        return handled;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout parent, @NonNull V child, @NonNull android.view.MotionEvent event) {
        // Custom touch handling logic
        switch (event.getAction()) {
            case android.view.MotionEvent.ACTION_DOWN:
                // Custom action for touch down event
                break;
            case android.view.MotionEvent.ACTION_MOVE:
                // Custom action for dragging event
                break;
            case android.view.MotionEvent.ACTION_UP:
                // Custom action for touch release
                break;
        }
        return super.onInterceptTouchEvent(parent, child, event);  // Delegate to parent behavior for default handling
    }

    // Custom method to trigger smooth transitions or animations
    public void animateToState(V bottomSheet, int targetState) {
        // Example of adding custom animation between states
        if (targetState == STATE_EXPANDED) {
            // Animate expansion
            bottomSheet.animate().translationY(0).setDuration(300).start();  // Fully expand in 300ms
            setState(STATE_EXPANDED);
        } else if (targetState == STATE_COLLAPSED) {
            // Animate collapse
            bottomSheet.animate().translationY(bottomSheet.getHeight() - 200).setDuration(300).start();  // Collapse in 300ms
            setState(STATE_COLLAPSED);
        } else if (targetState == STATE_HIDDEN) {
            // Animate hiding
            bottomSheet.animate().translationY(bottomSheet.getHeight()).setDuration(300).start();
            setState(STATE_HIDDEN);
        }
    }

    // Add additional customization as required
}
