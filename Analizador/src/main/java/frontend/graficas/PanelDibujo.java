package frontend.graficas;

import backend.figuras.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 * @author michael
 */
public class PanelDibujo extends JPanel {
    public static List<Figura> listaFiguras;

    public PanelDibujo() {
        this.setBackground(Color.GRAY);
    }

    public List<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (listaFiguras != null) {
            for (Figura figura : listaFiguras) {
                if (figura instanceof Circulo) {
                    Circulo circulo = (Circulo) figura;
                    g.setColor(devolverColor(circulo.getColor()));
                    g.fillOval((int) circulo.getPosicionX(), (int) circulo.getPosicionY(),
                            (int) circulo.getRadio() * 2, (int) circulo.getRadio() * 2);

                } else if (figura instanceof Linea) {
                    Linea linea = (Linea) figura;
                    g.setColor(devolverColor(linea.getColor()));
                    g.drawLine((int) linea.getPosicionInicialX(), (int) linea.getPosicionInicialY(),
                            (int) linea.getPosicionFinalX(), (int) linea.getPosicionFinalY());

                } else if (figura instanceof Cuadrado) {
                    Cuadrado cuadrado = (Cuadrado) figura;
                    g.setColor(devolverColor(cuadrado.getColor()));
                    g.fillRect((int) cuadrado.getPosicionX(), (int) cuadrado.getPosicionY(),
                            (int) cuadrado.getTamanio(), (int) cuadrado.getTamanio());

                } else if (figura instanceof Rectangulo) {
                    Rectangulo rectangulo = (Rectangulo) figura;
                    g.setColor(devolverColor(rectangulo.getColor()));
                    g.fillRect((int) rectangulo.getPosicionX(), (int) rectangulo.getPosicionY(),
                            (int) rectangulo.getAncho(), (int) rectangulo.getAlto());

                } else if (figura instanceof Poligono) {
                    Poligono poligono = (Poligono) figura;
                    g.setColor(devolverColor(poligono.getColor()));

                    int numLados = poligono.getCantidadLados();
                    int[] xPoints = new int[numLados];
                    int[] yPoints = new int[numLados];

                    double centroX = poligono.getPosicionX();
                    double centroY = poligono.getPosicionY();
                    double radio = Math.min(poligono.getAncho(), poligono.getAlto()) / 2.0;

                    for (int i = 0; i < numLados; i++) {
                        double angulo = 2 * Math.PI * i / numLados;
                        xPoints[i] = (int) (centroX + radio * Math.cos(angulo));
                        yPoints[i] = (int) (centroY + radio * Math.sin(angulo));
                    }

                    g.fillPolygon(xPoints, yPoints, numLados);
                }
            }
        }
    }

    private Color devolverColor(String color) {
        switch (color) {
            case "rojo":
                return Color.RED;
            case "azul":
                return Color.BLUE;
            case "verde":
                return Color.GREEN;
            case "negro":
                return Color.BLACK;
            case "amarillo":
                return Color.YELLOW;
            case "celeste":
                return Color.CYAN;
            case "rosado":
                return Color.PINK;
            case "morado":
                return Color.MAGENTA;
            default:
                return Color.WHITE;
        }
    }

    public void guardarComoPNG() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como PNG");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().toLowerCase().endsWith(".png")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".png");
            }
            BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            this.paint(g2d);
            g2d.dispose();

            try {
                ImageIO.write(image, "PNG", fileToSave);
                JOptionPane.showMessageDialog(this, "Archivo PNG guardado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void guardarComoPDF() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como PDF");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
            }

            BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            this.paint(g2d);
            g2d.dispose();

            Document document = null;
            try {
                document = new Document(new com.itextpdf.text.Rectangle(getWidth(), getHeight()));
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
                document.open();
                Image pdfImage = Image.getInstance(imageToByteArray(image));
                pdfImage.setAbsolutePosition(0, 0);
                pdfImage.scaleToFit(getWidth(), getHeight());
                document.add(pdfImage);
                document.close();
                JOptionPane.showMessageDialog(this, "Archivo PDF guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (DocumentException | IOException ex) {
                ex.printStackTrace();
            } finally {
                document.close();
            }
        }
    }

    private byte[] imageToByteArray(BufferedImage image) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        }
    }
}
