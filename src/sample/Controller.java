package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import ru.kalantyr.nameCreator.*;

public class Controller {

    @FXML
    private void onStartClicked(ActionEvent event)
    {
        var nameDetector = new NameDetector();
        var result = nameDetector.Detect(new RuWordsSource(), new LetterConverter(), true);
        var alert = new Alert(Alert.AlertType.INFORMATION, String.join(", ", result));
        alert.showAndWait();
    }

}
