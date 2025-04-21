package com.rubik.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class Cube3DView extends BorderPane {

    private final Group cubeGroup;
    private final SubScene subScene;

    public Cube3DView() {
        cubeGroup = new Group();
        int size = 30;
        int spacing = 2;

        // Construir un cubo 3x3x3 (centro oscuro, caras visibles en gris claro)
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Box cube = new Box(size, size, size);
                    cube.setTranslateX(x * (size + spacing));
                    cube.setTranslateY(y * (size + spacing));
                    cube.setTranslateZ(z * (size + spacing));

                    PhongMaterial material = new PhongMaterial();

                    // Colorear sólo las piezas exteriores, centro en gris oscuro
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) >= 2) {
                        material.setDiffuseColor(Color.LIGHTGRAY);
                    } else {
                        material.setDiffuseColor(Color.DARKGRAY);
                    }

                    cube.setMaterial(material);
                    cubeGroup.getChildren().add(cube);
                }
            }
        }

        subScene = new SubScene(cubeGroup, 600, 600, true, SceneAntialiasing.BALANCED);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-500);
        camera.setNearClip(0.1);
        camera.setFarClip(1000.0);
        subScene.setCamera(camera);
        subScene.setFill(Color.LIGHTGRAY);

        // Contenedor centrado y responsive
        StackPane centerPane = new StackPane(subScene);
        centerPane.setStyle("-fx-background-color: lightgray;");
        centerPane.widthProperty().addListener((obs, oldVal, newVal) -> subScene.setWidth(newVal.doubleValue()));
        centerPane.heightProperty().addListener((obs, oldVal, newVal) -> subScene.setHeight(newVal.doubleValue()));

        // Botones de rotación
        Button rotateX = new Button("Rotar X");
        Button rotateY = new Button("Rotar Y");
        Button rotateZ = new Button("Rotar Z");

        rotateX.setOnAction(e -> cubeGroup.getTransforms().add(new Rotate(15, Rotate.X_AXIS)));
        rotateY.setOnAction(e -> cubeGroup.getTransforms().add(new Rotate(15, Rotate.Y_AXIS)));
        rotateZ.setOnAction(e -> cubeGroup.getTransforms().add(new Rotate(15, Rotate.Z_AXIS)));

        HBox buttonBox = new HBox(10, rotateX, rotateY, rotateZ);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setStyle("-fx-background-color: white;");

        setCenter(centerPane);
        setBottom(buttonBox);
    }
}
