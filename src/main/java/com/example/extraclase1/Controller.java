package com.example.extraclase1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    ObservableList<String> provincias = FXCollections.observableArrayList("San José", "Alajuela", "Heredia", "Cartago", "Puntarenas", "Guanacaste", "Limon");
    private ArrayList<String> personasList= new ArrayList<>();
    ObservableList <String> personas;
    private int cantidad = 0;
    Personas personArray[]= new Personas[4];
    private int resultado;
    boolean esNum;
    private int valor1 = 0;
    private int valor2 = 0;
    @FXML
    private Label agregartext;
    @FXML
    private ChoiceBox provinciaChoice;
    @FXML
    private ChoiceBox choicePersona1;
    @FXML
    private ChoiceBox choicePersona2;
    @FXML
    private TextField inNombre;
    @FXML
    private TextField inEdad;
    @FXML
    private Label resulText;
    public String nombre;
    public String provincia;
    public int edad;
    private int i1 = 0;
    private int i2 = 0;


    public void validar () {
        for (int i = 0; i <= inEdad.getText().length() - 1; i++) {
            char digi = inEdad.getText().charAt(i);
            if (!(Character.isDigit(digi))) {
                System.out.println("No es int");
                esNum=false;
                return;
            } else {
                if (i == inEdad.getText().length() - 1) {
                    esNum=true;
                    break;
                } else {
                }
            }
        }
    }


    @FXML
    protected void agregar() {
        if (cantidad == 4) {
            agregartext.setText("Ya alcanzó el maximo de personas posibles :(");
            inNombre.clear();
            provinciaChoice.setValue("");
            inEdad.clear();
        } else {
            if (inNombre.getText().equals("") || inEdad.getText().equals("") || provinciaChoice.getValue() == null || inEdad.getText().equals("0")) {
                agregartext.setText("Debe completar todos los espacios");
            } else {
                validar();
                if (esNum) {
                    nombre= inNombre.getText();
                    provincia= provinciaChoice.getValue().toString();
                    edad= Integer.valueOf(inEdad.getText());

                    personArray[cantidad]= new Personas(nombre,provincia, edad);
                    personasList.add(inNombre.getText());

                    inNombre.clear();
                    provinciaChoice.setValue("");
                    inEdad.clear();
                    agregartext.setText("Persona agregada con exito :)");
                    personas= FXCollections.observableArrayList(personasList);
                    choicePersona1.setItems(personas);
                    choicePersona2.setItems(personas);
                    System.out.println(personArray[cantidad]);
                    cantidad += 1;

                } else {
                    agregartext.setText("La edad debe ser un numero entero");
                    inEdad.clear();
                }
            }
        }
    }

    public void firstValue() {
        if (choicePersona1.getValue() != null){
            if (choicePersona1.getValue()== personas.get(i1)){
                valor1= personArray[i1].edad;
                System.out.println(valor1);
                i1 = 0;

            }else {
                i1 += 1;
                firstValue();
            }
        }
    }

    public void secondValue (){
        if (choicePersona2.getValue()!= null){
            if (choicePersona2.getValue()== personas.get(i2)){
                valor2= personArray[i2].edad;
                System.out.println(valor2);
                i2 = 0;

            }else {
                i2 += 1;
                secondValue();
            }
        }

    }
    @FXML
    private void sumar() {
        firstValue();
        secondValue();
        if (valor1 == 0 || valor2 == 0 || (valor1 == 0 && valor2 == 0)){
            resulText.setText("Debe de seleccionar ambas personas");


        }else {
            resultado = valor1 + valor2;
            resulText.setText("Resultado: " + resultado);
            choicePersona1.setValue(null);
            choicePersona2.setValue(null);
            valor1 = 0;
            valor2 = 0;
            i1 = 0;
            i2 = 0;
        }
    }

    @FXML
    private void restar(){
        firstValue();
        secondValue();
        if (valor1 == 0 || valor2 == 0 || (valor1 == 0 && valor2 == 0)){
            resulText.setText("Debe de seleccionar ambas personas");


        }else {
            resultado = valor1 - valor2;
            resulText.setText("Resultado: " + resultado);
            choicePersona1.setValue("");
            choicePersona2.setValue("");
            valor1=0;
            valor2=0;
            i1 = 0;
            i2 = 0;
        }
    }

    @FXML
    private void multiplicar(){
        firstValue();
        secondValue();
        if (valor1 == 0 || valor2 == 0 || (valor1 == 0 && valor2 == 0)){
            resulText.setText("Debe de seleccionar ambas personas");


        }else {
            resultado = valor1 * valor2;
            resulText.setText("Resultado: " + resultado);
            choicePersona1.setValue("");
            choicePersona2.setValue("");
            valor1=0;
            valor2=0;
            i1 = 0;
            i2 = 0;
        }
    }

    @FXML
    private void dividir(){

        firstValue();
        secondValue();
        if (valor1 == 0 || valor2 == 0 || (valor1 == 0 && valor2 == 0)){
            resulText.setText("Debe de seleccionar ambas personas");


        }else {
            resultado = valor1 / valor2;
            resulText.setText("Resultado: " + resultado);
            choicePersona1.setValue("");
            choicePersona2.setValue("");
            valor1=0;
            valor2=0;
            i1 = 0;
            i2 = 0;
        }
    }


    @FXML
    public void initialize() {
        provinciaChoice.setItems(provincias);
    }
}