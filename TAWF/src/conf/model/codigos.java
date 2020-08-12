package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Juan J. Medina
 */
public class codigos {
    
    private String ruta_archivo;
    private String nombre_archivo;
    
    public codigos() {

    }

    public String getRuta_archivo() {
        return ruta_archivo;
    }

    public void setRuta_archivo(String ruta_archivo) {
        this.ruta_archivo = ruta_archivo;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public String[][] insertarCodigos() {
        FileReader fr = null;
        BufferedReader br = null;
        int i = 0, inicio, fin, k, j, m;
        try {
            ruta_archivo = getRuta_archivo();
            nombre_archivo = getNombre_archivo();
            fr = new FileReader("C:\\Users\\Ramses\\Documents\\codigos.txt");
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                i++;
            }

            String codigos[][] = new String[i][2];
            i = 0;
            k = 0;
            j = 0;
            m = 0;
            linea = "";
            conexion conex = new conexion();
            fr = new FileReader("C:\\Users\\Ramses\\Documents\\codigos.txt");
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                inicio = linea.indexOf(" ");
                fin = linea.indexOf(",", inicio + 1);
                codigos[i][0] = linea.substring(inicio + 1, fin);

                if (codigos[i][0].length() == 9 && codigos[i][0].substring(0, 1).equals("C") || codigos[i][0].substring(0, 1).equals("M") || codigos[i][0].substring(0, 1).equals("G") || codigos[i][0].substring(0, 1).equals("E")) {
                    final String vc = "Select * from codigo where codigo = ?";
                    PreparedStatement validar_c = conex.obtenerConnexion().prepareStatement(vc);
                    validar_c.setString(1, codigos[i][0]);
                    ResultSet resultado = validar_c.executeQuery();
                    if (resultado.next()) {
                        codigos[i][1] = "duplicado";
                    } else {
                        final String sql = "Insert into codigo(codigo) values(?)";
                        PreparedStatement insertarCodigo = conex.obtenerConnexion().prepareStatement(sql);

                        insertarCodigo.setString(1, codigos[i][0]);
                        insertarCodigo.executeUpdate();

                        codigos[i][1] = "valido";
                    }
                } else {
                    codigos[i][1] = "invalido";
                }
                
                i++;
            }
            return codigos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String[][] p = new String[1][1];
        p[0][0] = "incorrecto";
        return p;
    }

    public static void main(String[] args) {
        codigos c = new codigos();
        String im = "";
        String[][] codigos = c.insertarCodigos();
        int stop = codigos.length;
        for (int filas = 0; filas < stop; filas++) {
            System.out.print(codigos[filas][0] + "\t");
            System.out.print(codigos[filas][1] + "\t");
            System.out.println("\n");
        }
    }
    
}
