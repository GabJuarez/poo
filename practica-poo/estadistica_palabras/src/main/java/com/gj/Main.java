package com.gj;
import com.gj.models.EstadisticaTexto;

import javax.naming.directory.InvalidAttributeValueException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ventana principal del programa
        JFrame frame = new JFrame("Estadística de palabras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // entrada de las palabras
        JPanel panel_entrada = new JPanel();
        panel_entrada.setLayout(new FlowLayout());
        JLabel label = new JLabel("Ingrese palabras separadas por espacios:");
        JTextField campo_palabras = new JTextField(20);
        JButton boton_procesar = new JButton("Procesar");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        campo_palabras.setFont(new Font("Arial", Font.PLAIN, 20));
        boton_procesar.setFont(new Font("Arial", Font.PLAIN, 20));
        panel_entrada.add(label);
        panel_entrada.add(campo_palabras);
        panel_entrada.add(boton_procesar);

        // panel donde se muestran los resultados
        JTextArea area_resultados = new JTextArea();
        area_resultados.setEditable(false);
        area_resultados.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane scroll_pane = new JScrollPane(area_resultados);

        // agregar los dos paneles a la ventana principal
        frame.add(panel_entrada, BorderLayout.NORTH);
        frame.add(scroll_pane, BorderLayout.CENTER);

        // catchear los eventos del boton
        boton_procesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = campo_palabras.getText();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ingrese palabras antes de procesar", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String[] palabras = input.split(" ");

                try {
                    EstadisticaTexto.setPalabras(palabras);
                } catch (InvalidAttributeValueException ex) {
                    JOptionPane.showMessageDialog(frame, "uso: palabras separadas por espacios (solo letras).", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                area_resultados.setText("");

                //mostrar las estadisticas
                int cantidad = EstadisticaTexto.contar_palabras(EstadisticaTexto.getPalabras());
                area_resultados.append("cantidad de palabras: " + cantidad + "\n");

                ArrayList<String> unicas = EstadisticaTexto.palabras_unicas(EstadisticaTexto.getPalabras());
                area_resultados.append("palabras unicas: " + unicas + "\n");

                String corta = EstadisticaTexto.palabra_mas_corta(EstadisticaTexto.getPalabras());
                String larga = EstadisticaTexto.palabra_mas_larga(EstadisticaTexto.getPalabras());
                area_resultados.append("palabra mas corta: " + corta + "\n");
                area_resultados.append("palabra mas larga: " + larga + "\n");
            }
        });

        frame.setVisible(true);
    }
}
