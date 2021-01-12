package sample.View;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Summary extends Pane{
    private TextField number;
    private TextField revenue;
    private TextField averageSale;
    public Summary(){
        draw();
    }
    public void draw(){
        Label numberLabel = new Label("# Sales:");
        numberLabel.setPrefSize(80,30);
        numberLabel.relocate(10,40);
        number = new TextField();
        number.setPrefSize(80,30);
        number.relocate(100,40);
        number.setText("0");
        Label revenueLabel = new Label("Revenue:");
        revenueLabel.setPrefSize(80,30);
        revenueLabel.relocate(10,80);
        revenue = new TextField();
        revenue.setPrefSize(80,30);
        revenue.relocate(100,80);
        revenue.setText("0");
        Label averageLabel = new Label("$/Sale:");
        averageLabel.setPrefSize(80,30);
        averageLabel.relocate(10,120);
        averageSale = new TextField();
        averageSale.setPrefSize(80,30);
        averageSale.relocate(100,120);
        averageSale.setText("N/A");


        Label title = new Label();
        title.setText("Store Summary");
        title.relocate(25,0);
        title.setPrefSize(150,30);
        getChildren().addAll(numberLabel,number,revenueLabel,revenue,averageLabel,averageSale,title);
        relocate(10,10);
    }

    public TextField getNumberField(){
        return number;
    }
    public TextField getRevenueField(){
        return revenue;
    }
    public TextField getAverageSaleField(){
        return averageSale;
    }
}
