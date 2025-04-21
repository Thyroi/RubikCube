package com.rubik;

import com.rubik.ui.Cube3DView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Crea la vista 3D del cubo Rubik
        Cube3DView cube3DView = new Cube3DView();

        // Crea la escena con la vista 3D como nodo raíz
        Scene scene = new Scene(cube3DView, 800, 600); // Puedes cambiar el tamaño inicial

        primaryStage.setTitle("Rubik Cube 3D Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



