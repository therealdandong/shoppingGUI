package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.baseCode.ElectronicStore;

public class ElectronicStoreApp extends Application {
    ElectronicStore model;
    // view
    ElectronicStoreView view;



    @Override
    public void start(Stage primaryStage) throws Exception{

        //model
        model= ElectronicStore.createStore();
        // view
        view = new ElectronicStoreView(model);
        view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleAddButton();
            }
        });
        view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleRemoveButton();
            }
        });
        view.getCompleteButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleCompleteButton();
            }
        });
        view.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleResetButton();
            }
        });
        view.getStockList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleStockListMouseClick();
            }
        });
        view.getCartList().setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleCartListMouseClick();
            }
        });
        view.getRemoveButton().setDisable(true);
        view.getAddButton().setDisable(true);
        view.getCompleteButton().setDisable(true);
        primaryStage.setTitle("Best Buy");
        primaryStage.setScene(new Scene(view, 800, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }










    private void handleCartListMouseClick(){
        int index = view.getCartList().getSelectionModel().getSelectedIndex();
        if(index >=0){
            view.getRemoveButton().setDisable(false);
        }else{
            view.getRemoveButton().setDisable(true);
        }
        if(model.getCurrentCart().length==0){
            view.getCompleteButton().setDisable(true);
        }
    }













    private void handleStockListMouseClick(){
        int index = view.getStockList().getSelectionModel().getSelectedIndex();
        if(index >=0){
            view.getAddButton().setDisable(false);
        }else{
            view.getAddButton().setDisable(true);
        }
        view.update();
    }









    private void handleResetButton(){
        model.reset();
        view.update();
    }










    private void handleAddButton() {
        int index = view.getStockList().getSelectionModel().getSelectedIndex();
        if(index >=0){
            model.addProductToCart(model.getStock()[index]);
            view.getAddButton().setDisable(false);
            view.getCompleteButton().setDisable(false);
        }else{
            view.getAddButton().setDisable(true);
        }
        view.update();
    }











    private void handleRemoveButton(){
        int index = view.getCartList().getSelectionModel().getSelectedIndex();
        if(index >=0){
            model.removeProductFromCart(model.getCurrentCart()[index],index);
            view.getRemoveButton().setDisable(false);
        }else{
            view.getRemoveButton().setDisable(true);
        }
        view.update();
    }













    private void handleCompleteButton(){
        model.sellCurrentCart();
        view.update();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
