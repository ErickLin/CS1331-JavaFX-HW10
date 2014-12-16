import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Animation that shows the inner planets of the solar system in orbit
 * Not drawn to scale
 * @author Erick Lin
 * @version 1.0
 */
public class Planetarium extends Application {
    /**
     * Sets up the Sun, the inner planets, and the PathTransitions
     * @param stage the stage for the JavaFX program
     */
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: black;");
        root.setPrefSize(720, 720);
        Circle sun = new Circle(360, 360, 65, Color.YELLOW);
        root.getChildren().add(sun);
        for (Planet planet : Planet.values()) {
            root.getChildren().add(planet.getOrbit());
            root.getChildren().add(planet.getShape());
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("The Inner Planets of the Solar System");
        stage.show();
        for (Planet planet : Planet.values()) {
            PathTransition orbitTransition = new PathTransition();
            orbitTransition.setDuration(
                    Duration.millis(planet.getPeriod() * 1000));
            orbitTransition.setPath(planet.getOrbit());
            orbitTransition.setNode(planet.getShape());
            //path transition moves at constant speed
            orbitTransition.setInterpolator(Interpolator.LINEAR);
            orbitTransition.setCycleCount(Timeline.INDEFINITE);
            orbitTransition.setAutoReverse(false);
            orbitTransition.play();
        }
    }
}