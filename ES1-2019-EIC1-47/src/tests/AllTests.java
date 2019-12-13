package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({InterfaceUser_thresholdsTest.class , InterfaceUserTest.class, LeituraFicheiroTest.class , LogicParserTest.class , 
	MetodoTest.class, RegrasDetencaoTest.class , ResultRepresenterTest.class, RuleCheckerTest.class, RuleTest.class})
public class AllTests {

}
