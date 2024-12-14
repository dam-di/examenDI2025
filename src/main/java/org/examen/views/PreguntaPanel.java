package org.examen.views;

import org.examen.models.PreguntaModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.examen.controllers.PreguntaPanelController.EDITAR_PREGUNTA;

public class PreguntaPanel extends JPanel {
    private JPanel mainPanel;
    private JLabel lb_preguntaNum;
    private JTextField tx_a;
    private JTextField tx_b;
    private JTextField tx_c;
    private JTextField tx_d;
    private JComboBox cb_respuesta;
    private JTextField tx_preunta;
    private JButton bt_editar;

    private PreguntaModel preguntaModel;

    public PreguntaPanel(){
        initPanel();
        setCommands();
    }

    private void initPanel(){
        add(mainPanel);
        ArrayList<String> listaSoluciones = new ArrayList<>();
        listaSoluciones.add("a");
        listaSoluciones.add("b");
        listaSoluciones.add("c");
        listaSoluciones.add("d");
        cb_respuesta.setModel(new DefaultComboBoxModel(listaSoluciones.toArray()));
    }

    public void establecerDatosPregunta(PreguntaModel preguntaModel){
        this.preguntaModel = preguntaModel;
        tx_preunta.setText(preguntaModel.getEnunciado());
        tx_a.setText(preguntaModel.getA());
        tx_b.setText(preguntaModel.getB());
        tx_c.setText(preguntaModel.getC());
        tx_d.setText(preguntaModel.getD());
        cb_respuesta.setSelectedItem(preguntaModel.getSolucion());

    }

    public PreguntaModel obtenerPregunta(){
        return new PreguntaModel(preguntaModel.getId(), preguntaModel.getAsignatura_id(),
                tx_preunta.getText(), tx_a.getText(), tx_b.getText(), tx_c.getText(), tx_d.getText() ,
                (String)cb_respuesta.getSelectedItem());
    }

    public void habilitarDatosPregunta(boolean state){
        tx_preunta.setEnabled(state);
        tx_a.setEnabled(state);
        tx_b.setEnabled(state);
        tx_c.setEnabled(state);
        tx_d.setEnabled(state);
        cb_respuesta.setEnabled(state);

    }

    private void setCommands(){
        bt_editar.setActionCommand(EDITAR_PREGUNTA);
    }

    public void addListener(ActionListener listener){
        bt_editar.addActionListener(listener);
    }


}
