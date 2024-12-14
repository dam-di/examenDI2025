package org.examen;

import com.formdev.flatlaf.FlatLightLaf;
import org.examen.controllers.MainFrameController;
import org.examen.views.MainFrame;

import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "INICIO APLICACION" );

        FlatLightLaf.setup();
        // Vista
        MainFrame mainFrame = new MainFrame();

        // Controladores
        MainFrameController mainFrameController = new MainFrameController(mainFrame);

        // Listeners
        mainFrame.addListener(mainFrameController);

        mainFrame.showWindow();




    }
}
