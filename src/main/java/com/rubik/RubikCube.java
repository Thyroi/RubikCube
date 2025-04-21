package com.rubik;

public class RubikCube {
    private String[][][] faces = new String[6][3][3];

    public RubikCube() {
        String[] colors = {"W", "Y", "R", "O", "G", "B"};
        for (int i = 0; i < 6; i++) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    faces[i][row][col] = colors[i];
                }
            }
        }
    }

    public String[][][] getFaces() {
        return faces;
    }
}


