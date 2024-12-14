package org.examen.controllers;

import org.examen.models.PreguntaModel;
import org.examen.views.PreguntaPanel;
import org.examen.xml.XMLManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreguntaPanelController implements ActionListener {
    public static final String EDITAR_PREGUNTA = "EDITAR PREGUNTA";
    private final PreguntaPanel preguntaPanel;

    public PreguntaPanelController(PreguntaPanel preguntaPanel) {
        this.preguntaPanel = preguntaPanel;
    }

    public void establecerDatosPregunta(PreguntaModel preguntaModel){
        preguntaPanel.establecerDatosPregunta(preguntaModel);
    }

    private void handleEditarPregunta(){

        try {
            if(XMLManager.actualizarPregunta(preguntaPanel.obtenerPregunta())){
                JOptionPane.showMessageDialog(null, "Pregunta actualizada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case EDITAR_PREGUNTA:
                handleEditarPregunta();
                break;
            default:
                break;
        }
    }
}
