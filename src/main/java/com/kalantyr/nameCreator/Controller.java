package com.kalantyr.nameCreator;

import com.kalantyr.nameCreator.core.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Controller {
    @FXML
    private TextArea taConverts;
    @FXML
    private TextArea taRuWords;
    @FXML
    private TextArea taResult;
    @FXML
    private javafx.scene.control.CheckBox cbCaps;

    private Desktop desktop = Desktop.getDesktop();
    final FileChooser fileChooser = new FileChooser();

    @FXML
    void initialize() {
        var lines = RuToEnConverter.defaultConverts
                .entrySet()
                .stream()
                .map(m -> m.getKey() + " => " + m.getValue())
                .collect(Collectors.toList());
        taConverts.setText(String.join(System.lineSeparator(), lines));
    }

    @FXML
    private void onStartClicked(ActionEvent event)
    {
        var converter = new RuToEnConverter(taConverts.getText());
        var nameDetector = new NameDetector(converter);
        var result = nameDetector.detect(new RuWordsCollection(taRuWords.getText()), cbCaps.isSelected());
        taResult.setText(result
                .stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .collect(Collectors.joining(System.lineSeparator())));
    }

    @FXML
    private void onAddWordsClicked(ActionEvent event) {
        Scene scene = taRuWords.getScene();
        var file = fileChooser.showOpenDialog(scene.getWindow());
        if (file != null)
            try {
                scene.setCursor(Cursor.WAIT);

                var text = load(file);
                var newWords = RuWordsCollection.parseWords(text);

                var words = new ArrayList<String>();
                words.addAll(RuWordsCollection.parseWords(taRuWords.getText()));
                var oldCount = words.size();

                for (var word : newWords)
                    if (!words.contains(word))
                        words.add(word);

                taRuWords.setText(String.join(System.lineSeparator(), words));

                int i = words.size() - oldCount;
                var alert = new Alert(Alert.AlertType.INFORMATION, "Добавлено слов: " + i);
                alert.showAndWait();
            } catch (Exception ex) {
                var alert = new Alert(Alert.AlertType.ERROR, String.join(", ", ex.getMessage()));
                alert.showAndWait();
            } finally {
                scene.setCursor(Cursor.DEFAULT);
            }
    }

    private String load(File file) {
        try (var reader = new FileReader(file)) {
            CharBuffer buffer = CharBuffer.allocate((int) file.length());
            reader.read(buffer);
            buffer.flip();
            return buffer.toString();
        }
        catch (Exception e) {
            var alert = new Alert(Alert.AlertType.ERROR, String.join(", ", e.getMessage()));
            alert.showAndWait();
            return "";
        }
    }
}
