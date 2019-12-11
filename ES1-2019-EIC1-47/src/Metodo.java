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
	
	private double methodID;
	private String package1;
	private String class1;
	private String method;
	private double loc;
	private double cyclo;
	private double atfd;
	private double laa;
	private boolean is_long_method;
	private boolean iPlasma;
	private boolean PMD;
	private boolean is_feature_envy;
	private boolean ruleResult;

	public void setloc(double loc) {
		this.loc = loc;
	}

	public boolean isiPlasma() {
		return iPlasma;
	}


	public void setiPlasma(boolean iPlasma) {
		this.iPlasma = iPlasma;
	}


	public boolean isIs_feature_envy() {
		return is_feature_envy;
	}


	public void setIs_feature_envy(boolean is_feature_envy) {
		this.is_feature_envy = is_feature_envy;
	}


		@Override
	public String toString() {
		return "Metodo [methodID=" + methodID + ", package1=" + package1 + ", class1=" + class1 + ", method=" + method
				+ ", loc="+ loc + ", cyclo" + cyclo+  ", atf"+ atfd+  "]";
	}

	
	public Metodo() {
		super();
		
	}

	public double getMethodID() {
		return methodID;
	}

	public void setMethodID(double d) {
		this.methodID = d;
	}

	public String getPackage1() {
		return package1;
	}
	
	

	public void setPackage1(String package1) {
		this.package1 = package1;
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public double getLoc() {
		return loc;
	}

	public void setLoc(double loc) {
		this.loc = loc;
	}

	public double getCyclo() {
		return cyclo;
	}

	public void setCyclo(double cyclo) {
		this.cyclo = cyclo;
	}

	public double getAtfd() {
		return atfd;
	}

	public void setAtfd(double atfd) {
		this.atfd = atfd;
	}

	public double getLaa() {
		return laa;
	}

	public void setLaa(double laa) {
		this.laa = laa;
	}

	public boolean isIs_long_method() {
		return is_long_method;
	}

	public void setIs_long_method(boolean is_long_method) {
		this.is_long_method = is_long_method;
	}

	public boolean isPMD() {
		return PMD;
	}

	public void setPMD(boolean pMD) {
		PMD = pMD;
	}
	
	public boolean getRuleResult() {
		return ruleResult;
	}

	public void setRuleResult(boolean ruleResult) {
		this.ruleResult = ruleResult;
	}
}
