package main;

import com.sun.org.apache.bcel.internal.generic.Type;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * CSVParser pour le dataframe
  * @author IHELLIOUN Khalid, SARRAJ Ahhmed, ABDULLAH HASIM Mohd Thaqif
 * @version 1.0
 */
public class CSVParser {
	
	private String file = "";
    private ArrayList<String> header;
    private ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();
    private int columnNumber = 0;
    private int lineNumber = 0;
    private String fileName;

    /**
     * Parser les données depuis le fichier CSV
     * @param file Le nom du fichier CSV à être parsé
     * @throws FileNotFoundException 
     * @throws IOException 
     */
    public CSVParser(String file) throws FileNotFoundException, IOException {
        this.file = file;
        System.out.println(file);
        BufferedReader br = new BufferedReader(new FileReader(this.file));
        this.convertCsvToArrayList(br);
    }

    /**
     * Récupérer le nom de fichier csv
     * @return Le nom de fichier csv
     */
    public String getName() {
        String[] fullPath = fileName.split("/");
        String fileWithExtension = fullPath[fullPath.length - 1];

        return fileWithExtension;
    }

    /**
     * Récupérer toutes les colonnes
     * @return Une liste de colonnes
     */
    public ArrayList<Colonne> getAllColumn() {
        return this.convertArrayListToDataFrame();
    }

    /**
     * Convertir le fichier csv en une liste
     * @param br BufferedReader
     * @throws IOException
     */
    private void convertCsvToArrayList(BufferedReader br) throws IOException {
        String line = "";

        this.header = new ArrayList<String>(Arrays.asList(br.readLine().split(",")));
        this.columnNumber = header.size();

        while ((line = br.readLine()) != null) {
            this.lineNumber++;
            ArrayList<String> lineStr = new ArrayList<String>(Arrays.asList(line.split(",")));
            this.content.add(lineStr);
        }

    }

    private ArrayList<Colonne> convertArrayListToDataFrame() {
        ArrayList<String> firstLine = this.content.get(1);
        ArrayList<Colonne> colonnes = new ArrayList<Colonne>();

        for (int i = 0; i <= firstLine.size() - 1; i++) {

            Type typeColumn = Type(firstLine.get(i));
            int j = 1;
            boolean remainUnknown = false;
            while (typeColumn == Type.UNKNOWN || remainUnknown == true) {

                ArrayList<String> firstLineNext = this.content.get(j++);
                typeColumn = Type(firstLineNext.get(i));

                if (j + 1 == this.content.size()) {
                    remainUnknown = true;
                }
            }
            Colonne col = new Colonne(this.header.get(i), typeColumn, null);
            colonnes.add(col);
        }

        for (int i = 0; i <= colonnes.size() - 1; i++) {

            Type typeColumn = colonnes.get(i).getColonneType();
            ArrayList<Unit> unitList = new ArrayList<Unit>();

            for (int j = 0; j < this.lineNumber; j++) {
                boolean nullValue = false;

                if (this.content.get(j).get(i).trim().equals("") || this.content.get(j).get(i).equals(null)) {
                    nullValue = true;
                }

                if (typeColumn == Type.INT) {

                    if (nullValue) {
                        unitList.add(new Unit<Integer>());
                    } else {
                        unitList.add(new Unit<Integer>(Integer.parseInt(this.content.get(j).get(i))));
                    }

                } else if (typeColumn == Type.DOUBLE) {

                    if (nullValue) {
                        unitList.add(new Unit<Integer>());
                    } else {
                        unitList.add(new Unit<Double>(Double.parseDouble(this.content.get(j).get(i))));
                    }

                } else if (typeColumn == Type.STRING) {

                    if (nullValue) {
                        unitList.add(new Unit<Integer>());
                    } else {
                        unitList.add(new Unit<String>(this.content.get(j).get(i)));
                    }
                }

            }
            colonnes.get(i).setUnits(unitList);
        }

        return colonnes;

    }
    
    private Type Type(String get) {
        Type ret = null;
        int it = 0;
        boolean done = false;

        if (get == null) {
            done = true;
            ret = Type.UNKNOWN;
        }

        while (done == false) {

            switch (it) {
                case 0:
                    it++;
                    Integer.parseInt(get);
                    ret = Type.INT;
                    done = true;
                    break;
                case 1:
                    it++;
                    Double.parseDouble(get);
                    ret = Type.DOUBLE;
                    done = true;
                    break;
                default:
                    it++;
                    ret = Type.STRING;
                    done = true;
            }
        }

        return ret;
    }

}
