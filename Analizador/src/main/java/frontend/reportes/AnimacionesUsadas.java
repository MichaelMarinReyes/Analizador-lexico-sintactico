package frontend.reportes;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author michael
 */
public class AnimacionesUsadas extends javax.swing.JPanel {

    public static int curva;
    public static int linea;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAnimacionesUsadas;


    /**
     * Creates new form OperadoresMatemáticos
     */
    public AnimacionesUsadas() {
        initComponents();
        actualizarTablaAnimacionesUsadas();
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
        tablaAnimacionesUsadas = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(844, 590));
        setLayout(new java.awt.GridBagLayout());

        tablaAnimacionesUsadas = new javax.swing.JTable() {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tablaAnimacionesUsadas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(tablaAnimacionesUsadas);

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
    // End of variables declaration//GEN-END:variables

    public void actualizarTablaAnimacionesUsadas() {
        String[] columnas = {"Animación", "Cantidad de uso"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tablaAnimacionesUsadas.setModel(modelo);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tablaAnimacionesUsadas.getColumnCount(); i++) {
            tablaAnimacionesUsadas.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        modelo.addRow(new Object[]{"Curva", curva});
        modelo.addRow(new Object[]{"Línea", linea});
    }
}
