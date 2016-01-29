package org.projectspinoza.javaFX;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TabbedApp extends Application {
    Group root = new Group();
    TabPane tabPane = new TabPane();

    public void init() throws Exception {
        // Prepare tab pane with set of tabs
        BorderPane borderPane = new BorderPane();
        tabPane.setPrefSize(900, 700);
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        BubbleChart<Number, Number> bubbles = new BubbleGraph().start();
        Group chart = new PieGraph().start();
        
        /** tab for bubble graph **/
        final Tab tab = new Tab("Bubble Chart");
        tab.setId("1");
        tab.setContent(bubbles);
  //      tabPane.getTabs().add(tab);
        /** ends here  **/
        
        /** tab for bubble graph **/
        final Tab tab1 = new Tab("Pie Chart");
        tab1.setId("2");
        tab1.setContent(chart);
        
 //       tabPane.getTabs().add(tab1);
        /** ends here  **/
        tabPane.getTabs().addAll(tab,tab1);
        borderPane.setCenter(tabPane);
        root.getChildren().addAll(borderPane);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void navigateTo(String tab) {
        for (Tab t : tabPane.getTabs()) {
            if (tab.equals("#" + t.getId())) {
                tabPane.getSelectionModel().select(t);
                return;
            }
        }
    }
}