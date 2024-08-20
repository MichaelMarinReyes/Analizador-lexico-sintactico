package frontend.reportes;

import backend.lexico.Lexer;
import backend.lexico.OperadorAritmetico;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author michael
 */
public class OperadoresMatematicos extends javax.swing.JPanel {

        private TableRowSorter<DefaultTableModel> sorter;
        
    /**
     * Creates new form OperadoresMatemáticos
     */
    public OperadoresMatematicos() {
        initComponents();
        llenarComboBox();
        actualizarTablaOperadoresMatematicos();
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

        filtroOperadoresMatematicos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOperadoresMatematicos = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(844, 590));
        setLayout(new java.awt.GridBagLayout());

        filtroOperadoresMatematicos.setBackground(new java.awt.Color(0, 153, 255));
        filtroOperadoresMatematicos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtroOperadoresMatematicosItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 455;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 12, 4, 0);
        add(filtroOperadoresMatematicos, gridBagConstraints);

        tablaOperadoresMatematicos = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tablaOperadoresMatematicos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaOperadoresMatematicos);

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

    private void filtroOperadoresMatematicosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtroOperadoresMatematicosItemStateChanged
        if (sorter == null) return;

        String filtro = filtroOperadoresMatematicos.getSelectedItem().toString();
        if (!filtro.equals("Todos")) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro, 0));
        } else {
            sorter.setRowFilter(null);
        }
    }//GEN-LAST:event_filtroOperadoresMatematicosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filtroOperadoresMatematicos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaOperadoresMatematicos;
    // End of variables declaration//GEN-END:variables

    private void llenarComboBox() {
        filtroOperadoresMatematicos.addItem("Todos");
        filtroOperadoresMatematicos.addItem("Suma");
        filtroOperadoresMatematicos.addItem("Resta");
        filtroOperadoresMatematicos.addItem("Multiplicación");
        filtroOperadoresMatematicos.addItem("División");
    }

    public void actualizarTablaOperadoresMatematicos() {
        String[] columnas = {"Operación", "Símbolo", "Línea", "Columna", "Ocurrencia"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tablaOperadoresMatematicos.setModel(modelo);
        sorter = new TableRowSorter<>(modelo);
        tablaOperadoresMatematicos.setRowSorter(sorter);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tablaOperadoresMatematicos.getColumnCount(); i++) {
            tablaOperadoresMatematicos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        // Asegúrate de que los datos se están cargando correctamente
        List<OperadorAritmetico> operadores = Lexer.operadorAritmetico;
        for (OperadorAritmetico operador : operadores) {
            Object[] fila = {
                    operador.getOperador(),
                    operador.getSimbolo(),
                    operador.getLinea(),
                    operador.getColumna(),
                    operador.getOcurrencia()
            };
            modelo.addRow(fila);
        }

        // Imprime los datos de la columna "Operación" para verificar su formato
        for (int i = 0; i < modelo.getRowCount(); i++) {
            System.out.println("Operación en fila " + i + ": " + modelo.getValueAt(i, 0));
        }
    }
}
