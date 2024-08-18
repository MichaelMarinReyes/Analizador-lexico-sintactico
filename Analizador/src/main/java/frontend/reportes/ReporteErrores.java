package frontend.reportes;

import backend.lexico.Lexer;
import backend.reportes.ErrorReporte;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author michael
 */
public class ReporteErrores extends javax.swing.JPanel {

    /**
     * Creates new form OperadoresMatemáticos
     */
    public ReporteErrores() {
        initComponents();
        actualizarTablaErrores();
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
        tablaErrores = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(844, 590));
        setLayout(new java.awt.GridBagLayout());

        filtroOperadoresMatematicos.setBackground(new java.awt.Color(0, 153, 255));
        filtroOperadoresMatematicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 455;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 12, 4, 0);
        add(filtroOperadoresMatematicos, gridBagConstraints);

        tablaErrores.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaErrores.setSelectionForeground(new java.awt.Color(255, 255, 204));
        jScrollPane1.setViewportView(tablaErrores);

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
    private javax.swing.JComboBox<String> filtroOperadoresMatematicos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaErrores;
    // End of variables declaration//GEN-END:variables

    public void actualizarTablaErrores() {
        String[] columnas = {"Lexema", "Línea", "Columna", "Tipo", "Descripción"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tablaErrores.setModel(modelo);

        // Centrar el texto en todas las columnas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tablaErrores.getColumnCount(); i++) {
            tablaErrores.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        for (int i = 0; i < Lexer.errores.size(); i++) {
            ErrorReporte errorReporte = Lexer.errores.get(i);
            Object[] fila = {
                errorReporte.getLexema(),
                errorReporte.getLinea(),
                errorReporte.getColumna(),
                errorReporte.getTipo(),
                errorReporte.getDescripcion()
            };
            modelo.addRow(fila);
        }
    }
}
