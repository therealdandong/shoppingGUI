package sample.View;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.awt.*;

public class CurrentCart extends ItemView {
    private Button sales;
    public CurrentCart(String initTitle,double initSizeX,double initSizeY,int initX,int initY, String initButtonName){
        super( initTitle, initSizeX, initSizeY, initX,initY, initButtonName);
    }
    public void drawButton(){
        super.drawButton();
        sales = new Button();
        sales.setPrefSize(120,30);
        sales.setWrapText(true);
        sales.relocate(getXLocation()+150,getYLocation()+getYSize()+10);
        sales.setText("Complete Sales");

    }
    public Pane drawPane(int x,int y){
        this.drawButton();
        super.drawPane(x,y);
        getBasePane().getChildren().add(sales);
        return getBasePane();
    }
    public Button getSalesButton(){
        return sales;
    }
}
