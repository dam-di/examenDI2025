package org.examen.views;

import org.examen.models.AsignaturaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.examen.controllers.MainFrameController.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JComboBox cb_asignaturas;
    private JButton bt_anterior;
    private JButton bt_siguiente;
    private JButton bt_salir;
    private JButton bt_verAsignaturas;
    private JPanel contenedorPaneles;
    private JLabel lb_numpregunta;

    private CardLayout navegador;

    private int numPreguntaActual;

    private int totalPreguntas;


    public MainFrame(){
        initWindow();
        setCommands();
        numPreguntaActual = 1;
        lb_numpregunta.setText("Selecciona una asignatura y pulsa VER");
    }

    public void setTotalPreguntas(int totalPreguntas){
        this.totalPreguntas = totalPreguntas;
    }

    public int getTotalPreguntas(){
        return totalPreguntas;
    }

    public void setNumPreguntaActual(int preguntaActual){
        this.numPreguntaActual = preguntaActual;
    }

    public int getNumPreguntaActual(){
        return numPreguntaActual;
    }

    public void setLabelNumPregunta(){
        lb_numpregunta.setText("PREGUNTA "+getNumPreguntaActual() + " de" + getTotalPreguntas());
    }

    private void initWindow(){
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        navegador = (CardLayout) contenedorPaneles.getLayout();
    }

    public void cargarComboAsignaturas(ArrayList<AsignaturaModel> listaAsignaturas){
        cb_asignaturas.setModel(new DefaultComboBoxModel(listaAsignaturas.toArray()));
    }

    private void setCommands(){
        bt_verAsignaturas.setActionCommand(VER_PREGUNTAS);
        bt_siguiente.setActionCommand(SIGUIENTE_PREGUNTA);
        bt_anterior.setActionCommand(ANTERIOR_PREGUNTA);
        bt_salir.setActionCommand(SALIR);
    }

    public void addListener(ActionListener listener){
        bt_verAsignaturas.addActionListener(listener);
        bt_anterior.addActionListener(listener);
        bt_siguiente.addActionListener(listener);
        bt_salir.addActionListener(listener);
    }

    public void showWindow(){
        this.setVisible(true);
    }

    public void closeWindow(){
        dispose();
    }


    public String getAsignaturaId(){
        AsignaturaModel asignaturaModel = (AsignaturaModel) cb_asignaturas.getSelectedItem();
        return asignaturaModel.getId();
    }

    public void addPreguntaPanel(PreguntaPanel preguntaPanel, String panelName){
        contenedorPaneles.add(preguntaPanel, panelName);
    }

    public void resetPreguntasPanel(){
        contenedorPaneles.removeAll();
    }

    public void navegar(String panelName){
        navegador.show(contenedorPaneles, panelName);
    }
}
