package org.arcball.internal;

import javafx.scene.PerspectiveCamera;

/**
 * Ye olde Utility class.
 * 
 * @author Jonathan Merritt (<a href="mailto:j.s.merritt@gmail.com">j.s.merritt@gmail.com</a>)
 */
public final class Util {

    /**
     * Returns the horizontal field of view of a camera, in degrees.
     * @param camera camera for which to return the horizontal field of view
     * @param width width of the viewport
     * @param height height of the viewport
     * @return horizontal field of view (degrees)
     */
    public static double getHorizontalFieldOfView(PerspectiveCamera camera, double width, double height) {
        final double camFovDegrees = camera.getFieldOfView();
        if (camera.isVerticalFieldOfView()) {
            final double fovRad = Math.toRadians(camFovDegrees);
            final double hFovRad = 2.0 * Math.atan((width / height) * Math.tan(fovRad / 2.0));
            return Math.toDegrees(hFovRad);
        } else {
            return camFovDegrees;
        }
    }
    
    /**
     * Normalizes an angle (in degrees) to the range 0 <= angle < 360.0.
     * @param angle angle (degrees) to normalize
     * @return normalized angle (degrees)
     */
    public static double normalizeAngle(double angle) {
        return ((angle >= 0) && (angle < 360.0)) ? angle : (angle - 360.0 * Math.floor(angle / 360.0));
    }
    
}
