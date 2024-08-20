package frontend.reportes;

import backend.figuras.*;
import frontend.graficas.PanelDibujo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

/**
 * @author michael
 */
public class ObjetosUsados extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaObjetosUsados;


    /**
     * Creates new form OperadoresMatemáticos
     */
    public ObjetosUsados() {
        initComponents();
        actualizarTablaObjetosUsados();
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
        tablaObjetosUsados = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(844, 590));
        setLayout(new java.awt.GridBagLayout());

        tablaObjetosUsados = new javax.swing.JTable() {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tablaObjetosUsados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaObjetosUsados);

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

    public void actualizarTablaObjetosUsados() {
        String[] columnas = {"Objeto", "Creados"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tablaObjetosUsados.setModel(modelo);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        tablaObjetosUsados.setDefaultRenderer(Object.class, centrado);

        Map<String, Integer> objetosUsados = new HashMap<>();
        String[] objetos = {"Círculo", "Cuadrado", "Línea", "Rectángulo", "Polígono"};

        for (String objeto : objetos) {
            objetosUsados.put(objeto, 0);
        }

        if (!PanelDibujo.listaFiguras.isEmpty()) {
            for (Figura figura : PanelDibujo.listaFiguras) {
                String tipoFigura = "";

                if (figura instanceof Circulo) {
                    tipoFigura = "Círculo";
                } else if (figura instanceof Cuadrado) {
                    tipoFigura = "Cuadrado";
                } else if (figura instanceof Linea) {
                    tipoFigura = "Línea";
                } else if (figura instanceof Rectangulo) {
                    tipoFigura = "Rectángulo";
                } else if (figura instanceof Poligono) {
                    tipoFigura = "Polígono";
                }

                if (!tipoFigura.isEmpty() && objetosUsados.containsKey(tipoFigura)) {
                    objetosUsados.put(tipoFigura, objetosUsados.get(tipoFigura) + 1);
                }
            }
        }

        for (String objeto : objetos) {
            Object[] fila = {objeto, objetosUsados.get(objeto)};
            modelo.addRow(fila);
        }
    }

}
