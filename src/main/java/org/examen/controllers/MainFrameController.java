package org.examen.controllers;

import org.examen.models.AsignaturaModel;
import org.examen.models.PreguntaModel;
import org.examen.views.MainFrame;
import org.examen.views.PreguntaPanel;
import org.examen.xml.XMLManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrameController implements ActionListener {

    public static final String VER_PREGUNTAS = "VER_PREGUNTAS";
    public static final String SIGUIENTE_PREGUNTA = "SIGUIENTE_PREGUNTA";
    public static final String ANTERIOR_PREGUNTA = "ANTERIOR_PREGUNTA";

    public static final String SALIR = "SALIR";

    private final MainFrame mainFrame;

    public MainFrameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        handleCargarAsignaturas();
    }

    private void handleCargarAsignaturas(){
        try {
            ArrayList<AsignaturaModel> listaAsignaturas = XMLManager.getAsignaturas();
            mainFrame.cargarComboAsignaturas(listaAsignaturas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void handleCargarPreguntas(){
        int num = 0;
        try {
            ArrayList<PreguntaModel> listaPreguntas = XMLManager.getPreguntas(mainFrame.getAsignaturaId());
            mainFrame.resetPreguntasPanel();

            for(PreguntaModel pregunta : listaPreguntas){
                num++;

                PreguntaPanel preguntaPanel = new PreguntaPanel();
                PreguntaPanelController preguntaPanelController = new PreguntaPanelController(preguntaPanel);
                preguntaPanelController.establecerDatosPregunta(pregunta);
                preguntaPanel.addListener(preguntaPanelController);
                mainFrame.addPreguntaPanel(preguntaPanel, "panel"+num);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        mainFrame.setTotalPreguntas(num);
        mainFrame.setNumPreguntaActual(1);
        mainFrame.setLabelNumPregunta();
    }

    private void handlePreguntaAnterior(){
        if(mainFrame.getNumPreguntaActual()-1 >= 1){
            mainFrame.setNumPreguntaActual(mainFrame.getNumPreguntaActual()-1);
            mainFrame.navegar("panel"+mainFrame.getNumPreguntaActual());
            mainFrame.setLabelNumPregunta();
        }
    }

    private void handlePreguntaSiguiente(){
        if(mainFrame.getNumPreguntaActual()+1 <= mainFrame.getTotalPreguntas()){
            mainFrame.setNumPreguntaActual(mainFrame.getNumPreguntaActual()+1);
            mainFrame.navegar("panel"+mainFrame.getNumPreguntaActual());
            mainFrame.setLabelNumPregunta();
        }
    }

    private void handleSalir(){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
            mainFrame.closeWindow();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case VER_PREGUNTAS:
                handleCargarPreguntas();
                break;
            case ANTERIOR_PREGUNTA:
                handlePreguntaAnterior();
                break;
            case SIGUIENTE_PREGUNTA:
                handlePreguntaSiguiente();
                break;
            case SALIR:
                handleSalir();
                break;
            default:
                break;
        }
    }
}
