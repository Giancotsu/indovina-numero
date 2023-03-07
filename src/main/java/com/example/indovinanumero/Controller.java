package com.example.indovinanumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    private final int numMax = 100;
    private int tMax = 10;
    private int nTentativiRimasti;
    private int numSegreto;
    private boolean indovinato = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button indovinaBtn;

    @FXML
    private TextField indovinaNumero;

    @FXML
    private TextField nMax;

    @FXML
    private Button nuovaPartitaBtn;

    @FXML
    private TextArea risultatoTxt;

    @FXML
    private TextField tentativiMax;

    @FXML
    private TextField tentativiRimasti;

    @FXML
    void onIndovina(ActionEvent event) {

        try {

            if(this.nTentativiRimasti > 0 && !this.indovinato){
                if(this.nTentativiRimasti == 1 && this.numSegreto != Integer.valueOf(this.indovinaNumero.getText())){
                    this.nTentativiRimasti--;
                    this.tentativiRimasti.setText(String.valueOf(this.nTentativiRimasti));
                    this.risultatoTxt.setMinSize(300,300);
                    this.risultatoTxt.setText("HAI PERSO!");
                    this.risultatoTxt.appendText("Il numero segreto era: " + this.numSegreto);
                    return;
                }
                if(this.numSegreto == Integer.valueOf(this.indovinaNumero.getText())){
                    this.indovinato = true;
                    this.risultatoTxt.setMinSize(300,300);
                    this.risultatoTxt.setText("HAI VINTO!");
                }else{
                    if (this.numSegreto > Integer.valueOf(this.indovinaNumero.getText())) {
                        this.risultatoTxt.appendText("\nSBAGLIATO! è piu' grande di: " + this.indovinaNumero.getText());
                    } else {
                        this.risultatoTxt.appendText("\nSBAGLIATO! è piu' piccolo di: " + this.indovinaNumero.getText());
                    }
                }
                this.nTentativiRimasti--;
                this.tentativiRimasti.setText(String.valueOf(this.nTentativiRimasti));
            }else{
                if(indovinato){
                    this.risultatoTxt.setMinSize(300,300);
                    this.risultatoTxt.setText("HAI VINTO!");
                }
            }

        }catch (Exception ex){
            this.risultatoTxt.setMinSize(100,100);
            this.risultatoTxt.setText("DEVI INSERIRE UN NUMERO!!!!!");
        }
    }

    @FXML
    void onNuovaPartita(ActionEvent event) {

        this.nTentativiRimasti = tMax;
        this.tentativiRimasti.setText(String.valueOf(this.nTentativiRimasti));
        this.indovinato = false;

        this.numSegreto = (int)(Math.random() * this.numMax)+1;
        this.risultatoTxt.setText("Buona Fortuna!!!");
    }

    @FXML
    void initialize() {
        assert indovinaBtn != null : "fx:id=\"indovinaBtn\" was not injected: check your FXML file 'scene.fxml'.";
        assert indovinaNumero != null : "fx:id=\"indovinaNumero\" was not injected: check your FXML file 'scene.fxml'.";
        assert nMax != null : "fx:id=\"nMax\" was not injected: check your FXML file 'scene.fxml'.";
        assert nuovaPartitaBtn != null : "fx:id=\"nuovaPartitaBtn\" was not injected: check your FXML file 'scene.fxml'.";
        assert risultatoTxt != null : "fx:id=\"risultatoTxt\" was not injected: check your FXML file 'scene.fxml'.";
        assert tentativiMax != null : "fx:id=\"tentativiMax\" was not injected: check your FXML file 'scene.fxml'.";
        assert tentativiRimasti != null : "fx:id=\"tentativiRimasti\" was not injected: check your FXML file 'scene.fxml'.";

        this.nTentativiRimasti = tMax;
        this.numSegreto = (int)(Math.random() * this.numMax)+1;

        this.nMax.setText(String.valueOf(this.numMax));
        this.tentativiMax.setText(String.valueOf(this.tMax));
        this.tentativiRimasti.setText(String.valueOf(this.nTentativiRimasti));



        this.risultatoTxt.setText("Buona Fortuna!!!");
    }

}
