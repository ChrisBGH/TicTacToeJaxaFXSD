package org.example.tictactoejavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Button button00;
    @FXML
    private Button button01;
    @FXML
    private Button button02;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button20;
    @FXML
    private Button button21;
    @FXML
    private Button button22; 

    private boolean isXturn = true;
    private Button[][] grd;

    @FXML
    public void initialize() {
        grd = new Button[][]{
                {button00, button01, button02},
                {button10, button11, button12},
                {button20, button21, button22}
        };
    }

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals(" ")) {  // Only allow clicking on an empty button
            clickedButton.setText(isXturn ? "X" : "O");
            isXturn = !isXturn;

            // Update label after turn switch
            statusLabel.setText(isXturn ? "X turn" : "O turn");

            // Check for a winner after each move
            checkWinner();
        }
    }


    private void checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (grd[i][0].getText().equals(grd[i][1].getText()) &&
                    grd[i][1].getText().equals(grd[i][2].getText()) &&
                    !grd[i][0].getText().equals(" ")) {
                announceWinner(grd[i][0].getText());
                return;
            }
            if (grd[0][i].getText().equals(grd[1][i].getText()) &&
                    grd[1][i].getText().equals(grd[2][i].getText()) &&
                    !grd[0][i].getText().equals(" ")) {
                announceWinner(grd[0][i].getText());
                return;
            }
        }
        // Check diagonals
        if (grd[0][0].getText().equals(grd[1][1].getText()) &&
                grd[1][1].getText().equals(grd[2][2].getText()) &&
                !grd[0][0].getText().equals(" ")) {
            announceWinner(grd[0][0].getText());
            return;
        }
        if (grd[0][2].getText().equals(grd[1][1].getText()) &&
                grd[1][1].getText().equals(grd[2][0].getText()) &&
                !grd[0][2].getText().equals(" ")) {
            announceWinner(grd[0][2].getText());
            return;
        }
    }


    @FXML
    private Label statusLabel; // A label in FXML for displaying winner or turn status

    private void announceWinner(String winner) {
        statusLabel.setText("The winner is " + winner + "!");
        // Optionally, disable further moves
        disableButtons();
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grd[i][j].setDisable(true);  // Disable all buttons once there is a winner
            }
        }
    }

}
