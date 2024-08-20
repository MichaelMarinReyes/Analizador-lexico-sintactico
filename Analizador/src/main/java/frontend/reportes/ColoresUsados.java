package frontend.reportes;

import backend.figuras.*;
import frontend.graficas.PanelDibujo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author michael
 */
public class ColoresUsados extends javax.swing.JPanel {


    /**
     * Creates new form OperadoresMatemáticos
     */
    public ColoresUsados() {
        initComponents();
        actualizarTablaColoresUsados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaColoresUsados = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(844, 590));
        setLayout(new java.awt.GridBagLayout());

        tablaColoresUsados = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tablaColoresUsados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaColoresUsados);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 514;
        gridBagConstraints.ipady = 405;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 13, 20, 8);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaColoresUsados;
    // End of variables declaration//GEN-END:variables


    public void actualizarTablaColoresUsados() {
        String[] columnas = {"Color", "Cantidad de uso"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tablaColoresUsados.setModel(modelo);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        tablaColoresUsados.setDefaultRenderer(Object.class, centrado);

        Map<String, Integer> contadorColores = new HashMap<>();
        String[] colores = {"amarillo", "rojo", "azul", "negro", "verde", "rosado", "celeste", "morado"};

        for (String color : colores) {
            contadorColores.put(color, 0);
        }

        if (!PanelDibujo.listaFiguras.isEmpty()) {
            for (Figura figura : PanelDibujo.listaFiguras) {
                String color = figura.getColor();
                if (contadorColores.containsKey(color)) {
                    contadorColores.put(color, contadorColores.get(color) + 1);
                }
            }
        }

        for (String color : colores) {
            Object[] fila = {color, contadorColores.get(color)};
            modelo.addRow(fila);
        }
    }
}
