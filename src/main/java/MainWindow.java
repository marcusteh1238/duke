import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private IceBear iceBear;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaIceBear.png"));
    private static final long BYE_DELAY = 1000;

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setIceBear(IceBear d) {
        iceBear = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = iceBear.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input),
                DialogBox.getDukeDialog(response)
        );
        userInput.clear();
        if (input.equals("bye")) {
            exitApp();
        }
    }

    /**
     * Delays the program from exiting to show the bye message.
     */
    private void exitApp() {
        new Timer().schedule(new TimerTask() {
            public void run () { Platform.exit(); }
        }, BYE_DELAY);
    }

    /**
     * Displays the welcome message when the app is launched.
     */
    protected void showWelcomeMessage() {
        String welcomeMessage = iceBear.getUi().welcomeMessage();
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(welcomeMessage)
        );
    }
}