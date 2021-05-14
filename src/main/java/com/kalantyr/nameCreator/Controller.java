package com.kalantyr.nameCreator;

import com.kalantyr.nameCreator.core.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class Controller {

    @FXML
    private void onStartClicked(ActionEvent event)
    {
        var nameDetector = new NameDetector(new RuToEnConverter());
        var result = nameDetector.detect(new RuWordsCollection());
        var alert = new Alert(Alert.AlertType.INFORMATION, String.join(", ", result));
        alert.showAndWait();
    }

}
