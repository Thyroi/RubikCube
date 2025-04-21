package com.rubik.ui;

import com.rubik.RubikCube;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CubeView extends GridPane {
    private final RubikCube cube;

    public CubeView(RubikCube cube) {
        this.cube = cube;
        drawCube();
    }

    private void drawCube() {
        String[][][] faces = cube.getFaces();
        String[][] frontFace = faces[0];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Rectangle rect = new Rectangle(40, 40);
                rect.setFill(getColor(frontFace[row][col]));
                rect.setStroke(Color.BLACK);
                this.add(rect, col, row); // 👈 esta "add" es de GridPane
            }
        }
    }

    private Color getColor(String code) {
        return switch (code) {
            case "W" -> Color.WHITE;
            case "Y" -> Color.YELLOW;
            case "R" -> Color.RED;
            case "O" -> Color.ORANGE;
            case "G" -> Color.GREEN;
            case "B" -> Color.BLUE;
            default -> Color.GRAY;
        };
    }
}




