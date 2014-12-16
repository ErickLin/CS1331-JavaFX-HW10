import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 * Enum that holds representations of planets
 * @author Erick
 * @version 1.0
 */
public enum Planet {

    EARTH(Color.SPRINGGREEN, 1.0, 1.0, 1.0),
    MERCURY(Color.SILVER, 0.24, 0.1915, 0.387),
    VENUS(Color.GREEN, 0.62, 0.4745, 0.723),
    MARS(Color.RED, 1.88, 0.266, 1.52);

    private final int earthPeriod = 5;
    private final int earthRadius = 35;
    private final int earthDistance = 240;
    private final Color color;
    private final double period;
    private final double radius;
    private final double distance;
    private final Circle shape;
    private final Path orbit;

    /**
     * Constructor for Planet enum
     * @param c the Color for the representation of the Planet
     * @param t the period relative to Earth's
     * @param r the radius relative to Earth's
     * @param d the average distance from the Sun relative to Earth's
     */
    Planet(Color c, double t, double r, double d) {
        color = c;
        period = t * earthPeriod;
        radius = r * earthRadius;
        distance = d * earthDistance;
        shape = new Circle(360, 360 - distance, radius, color);
        orbit = new Path();
        orbit.getElements().add(new MoveTo(360, 360 - distance));
        ArcTo p1 = new ArcTo();
        p1.setX(360);
        p1.setY(360 + distance);
        p1.setRadiusX(distance);
        p1.setRadiusY(distance);
        orbit.getElements().add(p1);
        ArcTo p2 = new ArcTo();
        p2.setX(360);
        p2.setY(360 - distance);
        p2.setRadiusX(distance);
        p2.setRadiusY(distance);
        orbit.getElements().add(p2);
        orbit.setStroke(Color.WHITE);
    }

    /**
     * Retrieval method for color
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retrieval method for period
     * @return period
     */
    public double getPeriod() {
        return period;
    }

    /**
     * Retrieval method for radius of body
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Retrieval method for average distance from the Sun
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Retrieval method for circular-shaped graphic
     * @return shape
     */
    public Circle getShape() {
        return shape;
    }

    /**
     * Retrieval method for orbit Path
     * @return orbit
     */
    public Path getOrbit() {
        return orbit;
    }
}