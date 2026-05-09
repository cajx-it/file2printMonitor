package application.ui_components;
import application.controller.DoneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class done_rows {

    public static VBox build(String str, String path) {

        // -- DOT INDICATOR --
        Label dot = new Label("●");
        dot.setStyle("-fx-text-fill: #4fff1e; -fx-font-size: 8px;");

        // -- FOLDER NAME --
        Label nameLabel = new Label(str);
        nameLabel.setStyle(
            "-fx-text-fill: #e0e0e0;" +
            "-fx-font-size: 12px;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-weight: bold;"
        );

        // -- SUBTITLE --
        Label subLabel = new Label("submitted today");
        subLabel.setStyle(
            "-fx-text-fill: #3a3a3a;" +
            "-fx-font-size: 10px;" +
            "-fx-font-family: 'Courier New';"
        );

        // -- LEFT SIDE: dot + name + subtitle stacked --
        VBox leftInfo = new VBox(2, nameLabel, subLabel);
        leftInfo.setAlignment(Pos.CENTER_LEFT);

        HBox leftSide = new HBox(10, dot, leftInfo);
        leftSide.setAlignment(Pos.CENTER_LEFT);

        // -- SPACER --
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // -- PENDING BADGE --
        Label badge = new Label("DONE");
        badge.setStyle(
            "-fx-text-fill: #4fff1e;" +
            "-fx-font-size: 9px;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: #0a2200;" +
            "-fx-padding: 3 8 3 8;" +
            "-fx-background-radius: 2;"
        );

        // -- OPEN BUTTON --
        Button openBtn = new Button("OPEN →");
        openBtn.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #444444;" +
            "-fx-font-size: 9px;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: #222222;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 2;" +
            "-fx-background-radius: 2;" +
            "-fx-padding: 3 10 3 10;" +
            "-fx-cursor: hand;"
        );
        openBtn.setId("open");
        openBtn.setOnMouseClicked(event -> DoneController.OpenFolder(event));
        openBtn.setUserData(path);

        // hover on button
        openBtn.setOnMouseEntered(e -> openBtn.setStyle(
            "-fx-background-color: #1a1a1a;" +
            "-fx-text-fill: #4fff1e;" +
            "-fx-font-size: 9px;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: #4fff1e;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 2;" +
            "-fx-background-radius: 2;" +
            "-fx-padding: 3 10 3 10;" +
            "-fx-cursor: hand;"
        ));
        openBtn.setOnMouseExited(e -> openBtn.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #444444;" +
            "-fx-font-size: 9px;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: #222222;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 2;" +
            "-fx-background-radius: 2;" +
            "-fx-padding: 3 10 3 10;" +
            "-fx-cursor: hand;"
        ));
        
        
        // -- DELETE BUTTON --
        Button deletetBtn = new Button("DELETE");
        deletetBtn.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #FF1900;" +
            "-fx-font-size: 9px;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: #222222;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 2;" +
            "-fx-background-radius: 2;" +
            "-fx-padding: 3 10 3 10;" +
            "-fx-cursor: hand;"
        );
        
     
        
        deletetBtn.setId("deletetBtn");
        deletetBtn.setOnMouseClicked(event -> DoneController.DeleteFolder(event));
        deletetBtn.setUserData(path);

        // hover on button
        deletetBtn.setOnMouseEntered(e -> deletetBtn.setStyle(
            "-fx-background-color: #1a1a1a;" +
            "-fx-text-fill: #FF1900;" +
            "-fx-font-size: 9px;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: #FF1900;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 2;" +
            "-fx-background-radius: 2;" +
            "-fx-padding: 3 10 3 10;" +
            "-fx-cursor: hand;"
        ));
        
        deletetBtn.setOnMouseExited(e -> deletetBtn.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #FF1900;" +
            "-fx-font-size: 9px;" +
            "-fx-font-family: 'Courier New';" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: #222222;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 2;" +
            "-fx-background-radius: 2;" +
            "-fx-padding: 3 10 3 10;" +
            "-fx-cursor: hand;"
        ));

        // -- RIGHT SIDE --
        HBox rightSide = new HBox(8, badge, deletetBtn, openBtn);
        rightSide.setAlignment(Pos.CENTER_RIGHT);

        // -- FULL INNER ROW --
        HBox hb = new HBox(leftSide, spacer, rightSide);
        hb.setPrefWidth(576.0);
        hb.setPrefHeight(63.0);
        hb.setAlignment(Pos.CENTER_LEFT);
        hb.setPadding(new Insets(0, 14, 0, 14));

        // -- OUTER VBOX (your original structure) --
        VBox vb = new VBox();
        vb.setPrefHeight(63.0);
        vb.setPrefWidth(598.0);
        vb.setAlignment(Pos.CENTER);
        vb.setId(str); // for delete removeIf
        vb.setStyle(
            "-fx-background-color: #111111;" +
            "-fx-border-color: transparent transparent #1a1a1a transparent;" +
            "-fx-border-width: 0 0 1 0;"
        );

        // hover on row
        vb.setOnMouseEntered(e -> vb.setStyle(
            "-fx-background-color: #161616;" +
            "-fx-border-color: transparent transparent #1a1a1a transparent;" +
            "-fx-border-width: 0 0 1 0;" +
            "-fx-cursor: hand;"
        ));
        vb.setOnMouseExited(e -> vb.setStyle(
            "-fx-background-color: #111111;" +
            "-fx-border-color: transparent transparent #1a1a1a transparent;" +
            "-fx-border-width: 0 0 1 0;"
        ));
        

        vb.getChildren().add(hb);

        return vb;
    }
}