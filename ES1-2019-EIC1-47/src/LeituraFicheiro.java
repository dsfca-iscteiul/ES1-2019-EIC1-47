

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LeituraFicheiro extends JPanel{
	private JTable jt;
	private File file;
	private String[] columns;
	private String[][] linhas;
	private XSSFSheet sheet;
	private static ArrayList<Metodo> dados = new ArrayList<Metodo>();
	public static ArrayList<Metodo> getDados() {
		return dados;
	}


	private FileInputStream fis;



	// construtor
	public LeituraFicheiro(File file) {
		this.file = file;
	}
	
	public LeituraFicheiro() {
	
	}

	//metodo para criar um fileChooser(que nos da opcao para escolher o ficheiro)
	public File openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}else {
			return null;
		}
	}

	//Metodo para ler o Ficheiro Excel

	public void CorreFicheiro() throws IOException{		
		// Columns for table
		columns = new String[12];
		
		// 2D array is used for data in table
		linhas = new String[421][];
		
		if(file!=null)  fis = new FileInputStream(file);
		else 			fis = new FileInputStream(openFile());
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);

		FormulaEvaluator forlulaval = wb.getCreationHelper().createFormulaEvaluator();
		
		int countLinhas = 0;
		int count = 0;
		
		for (Row row : sheet) {
			count = 0;
			String[] linha = new String[16];
			for (Cell cell : row) {

				switch(forlulaval.evaluateInCell(cell).getCellType()){
				case NUMERIC:
					if(countLinhas == 0) columns[count] = Double.toString(cell.getNumericCellValue());
					else linha[count] = Double.toString(cell.getNumericCellValue());
					count++;
					break;
					
				case STRING:
					if(countLinhas == 0) columns[count] =  cell.getStringCellValue();
					else linha[count] = cell.getStringCellValue();
					count++;
					break;
					
				case BOOLEAN:
					if(countLinhas == 0) columns[count] = Boolean.toString(cell.getBooleanCellValue());
					else linha[count]= Boolean.toString(cell.getBooleanCellValue());
					count++;
					break;
					
				case BLANK:
					count++;
					break;
				case ERROR:
					break;
				case FORMULA:
					break;
				case _NONE:
					break;
				default:
					break;
				}
				linhas[countLinhas] = linha;
			}
			countLinhas++;

		}
	}

	public void ShowTable() {
		
		jt = new JTable(linhas, columns) {
			// Determines if data can be entered by users
			public boolean isCellEditable(int data, int columns){
				return false;
			}
		};
		// Creates Table

		jt.setRowHeight(20);
		for(int i = 0; i < 12; i++) {
			jt.getColumnModel().getColumn(i).setWidth(100);;
		}
		// Set size of table     
		jt.setPreferredScrollableViewportSize(new Dimension(750, 600));

		// This will resize the height of the table automatically 
		// to all data without scrolling. 
		jt.setFillsViewportHeight(true);

		JScrollPane jps = new JScrollPane(jt);
		add(jps);
		createList(sheet);
	}
	
	public FileInputStream getFis() {
		return fis;
	}
	public ArrayList<Metodo> createList(){
		return createList(sheet);
	}
	public static ArrayList<Metodo> createList(XSSFSheet sheet) {
		Iterator<Row> rowIterator = sheet.iterator();

		// Traversing over each row of XLSX file
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Metodo metodo = new Metodo();
			dados.add(metodo);
			if(row.getRowNum()==0) {
				dados.remove(metodo);
			}

			// For each row, iterate through each columns
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				if(row.getRowNum()>0) {

					switch(cell.getColumnIndex()) {
					case 0:
						metodo.setMethodID(cell.getNumericCellValue());
						break;
					case 1:
						metodo.setPackage1(cell.getStringCellValue());;

						break;
					case 2:
						metodo.setClass1(cell.getStringCellValue());
						break;
					case 3:
						metodo.setMethod(cell.getStringCellValue());
						break;
					case 4:
						metodo.setloc(cell.getNumericCellValue());
						break;
					case 5:
						metodo.setCyclo (cell.getNumericCellValue() ) ;
						break;
					case 6:
						metodo.setAtfd(cell.getNumericCellValue());
						break;
//					case 7:
//						metodo.setLaa(cell.getNumericCellValue());
//						break;
					case 8:
						metodo.setIs_long_method(cell.getBooleanCellValue() );
						break;
					case 9:
						metodo.setiPlasma(cell.getBooleanCellValue() );
						break;
					case 10:
						metodo.setPMD(cell.getBooleanCellValue() );
						break;
					case 11:
						metodo.setIs_feature_envy(cell.getBooleanCellValue() );
						break;
					default:
					}
				}
			}
		}
		return dados;
	}
}







