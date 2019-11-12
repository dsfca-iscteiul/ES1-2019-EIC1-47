import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
public class Metodo {
	
	public static void main( String args[] ) throws IOException {
		
		File myFile = new File("Method.xlsx");
		FileInputStream file = new FileInputStream(myFile);
				
	//Get the workbook instance for XLS file 
		XSSFWorkbook workbook = new XSSFWorkbook (file);

	//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		 // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                
                switch(cell.getCellType()) {
				//if cell is a numeric format
				case NUMERIC:
					System.out.println(cell.getNumericCellValue() + "\t\t");
					break;
				//if cell is a string format	
				case STRING:
					System.out.println(cell.getStringCellValue() + "\t\t");
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue() + "\t");
					break;
				default:
			}
			System.out.println();
            }
        }
	}
}
		
		
		
		
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//Evaluates the cell type
//		FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
//		for(Row row: sheet) {
//			for(Cell cell : row) {
//				switch(formulaEvaluator.evaluateInCell(cell).getCellType()) {
//				//if cell is a numeric format
//				case NUMERIC:
//					System.out.println(cell.getNumericCellValue() + "\t\t");
//				//if cell is a string format	
//				case STRING:
//					System.out.println(cell.getStringCellValue() + "\t\t");
//				default:
//					System.out.println();
//					break;
//				}
//			}
//			System.out.println();


//	//Iterate through each rows from first sheet
//	@SuppressWarnings("unchecked")
//	Iterator<Row> rowIterator = sheet.iterator();
//	while(rowIterator.hasNext()) {
//		Row row = rowIterator.next();
//		
//		//For each row, iterate through each columns
//		Iterator<Cell> cellIterator = row.cellIterator();
//		while(cellIterator.hasNext()) {
//			
//			Cell cell = cellIterator.next();
//			
//			}
//		}
	

