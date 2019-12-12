package classes;
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
	
/**
 * Date: Dec 12, 2019
 * @author engin
 *
 */
public class Metodo {
	/**
	 * methodID-coluna 1 do file
	 */
	private double methodID;
	/**
	 * package1-coluna 2 do file
	 */
	private String package1;
	/**
	 * class1-coluna 3 do file
	 */
	private String class1;
	/**
	 * method-coluna 4 do file
	 */
	private String method;
	/**
	 * loc-coluna 5 do file
	 */
	private double loc;
	/**
	 * cyclo-coluna 6 do file
	 */
	private double cyclo;
	/**
	 * atfd-coluna 7 do file
	 */
	private double atfd;
	/**
	 * atfd-coluna 8 do file
	 */
	private double laa;
	/**
	 * s_long_method-coluna 9 do file
	 */
	private boolean is_long_method;
	/**
	 * iPlasma-coluna 10 do file
	 */
	private boolean iPlasma;
	/**
	 * PMD-coluna 11 do file
	 */
	private boolean PMD;
	/**
	 *is_feature_envy-coluna 12 do file
	 */
	private boolean is_feature_envy;
	/**
	 * ruleResult
	 */
	private boolean ruleResult;
	
	/**
	 * 
	 * @param loc
	 */
	public void setloc(double loc) {
		this.loc = loc;
	}
	
	/**
	 * 
	 * @return isPlasma
	 */
	public boolean isiPlasma() {
		return iPlasma;
	}

	/**
	 * 
	 * @param iPlasma
	 */
	public void setiPlasma(boolean iPlasma) {
		this.iPlasma = iPlasma;
	}

	/**
	 * 
	 * @return is_feature_envy
	 */
	public boolean isIs_feature_envy() {
		return is_feature_envy;
	}

	/**
	 * 
	 * @param is_feature_envy
	 */
	public void setIs_feature_envy(boolean is_feature_envy) {
		this.is_feature_envy = is_feature_envy;
	}

	/**
	 *  The toString() method was changed for better readability, and it returns the given name of the rule, followed by the preset
	 */
	public String toString() {
		return "Metodo [methodID=" + methodID + ", package1=" + package1 + ", class1=" + class1 + ", method=" + method
				+ ", loc="+ loc + ", cyclo" + cyclo+  ", atf"+ atfd+  "]";
	}

	/**
	 * 
	 */
	public Metodo() {
		super();
		
	}
	/**
	 * 
	 * @return methodID
	 */
	public double getMethodID() {
		return methodID;
	}
	
	/**
	 * 
	 * @param d
	 */
	public void setMethodID(double d) {
		this.methodID = d;
	}
	
	/**
	 * 
	 * @return methodID
	 */
	public String getPackage1() {
		return package1;
	}
	
	/**
	 * 
	 * @param package1
	 */
	public void setPackage1(String package1) {
		this.package1 = package1;
	}
	
	/**
	 *  
	 * @return class1
	 */
	public String getClass1() {
		return class1;
	}
	
	/**
	 * 
	 * @param class1
	 */
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	
	/**
	 * 
	 * @return method
	 */
	public String getMethod() {
		return method;
	}
	
	/**
	 * 
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * 
	 * @return loc
	 */
	public double getLoc() {
		return loc;
	}
	
	/**
	 * 
	 * @param loc
	 */
	public void setLoc(double loc) {
		this.loc = loc;
	}
	
	/**
	 * 
	 * @return cyclo
	 */
	public double getCyclo() {
		return cyclo;
	}
	
	/**
	 * 
	 * @param cyclo
	 */
	public void setCyclo(double cyclo) {
		this.cyclo = cyclo;
	}
	
	/**
	 * 
	 * @return atfd
	 */
	public double getAtfd() {
		return atfd;
	}
	
	/**
	 * 
	 * @param atfd
	 */
	public void setAtfd(double atfd) {
		this.atfd = atfd;
	}
	
	/**
	 * 
	 * @return laa
	 */
	public double getLaa() {
		return laa;
	}
	
	/**
	 * 
	 * @param laa
	 */
	public void setLaa(double laa) {
		this.laa = laa;
	}
	
	/**
	 * 
	 * @return is_long_method
	 */
	public boolean isIs_long_method() {
		return is_long_method;
	}
	
	/**
	 * 
	 * @param is_long_method
	 */
	public void setIs_long_method(boolean is_long_method) {
		this.is_long_method = is_long_method;
	}
	
	/**
	 *
	 * @return PMD
	 */
	public boolean isPMD() {
		return PMD;
	}
	
	/**
	 *
	 * @param pMD
	 */
	public void setPMD(boolean pMD) {
		PMD = pMD;
	}
	
	/**
	 * 
	 * @return ruleResult
	 */
	public boolean getRuleResult() {
		return ruleResult;
	}
	
	/**
	 * 
	 * @param ruleResult
	 */
	public void setRuleResult(boolean ruleResult) {
		this.ruleResult = ruleResult;
	}
}
