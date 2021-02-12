package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import metier.Employe;
import metier.EmployeCoordonnees;
import metier.Responsable;
import metier.Salarie;

public class MainTest {

	public static void main(String[] args) {
		Employe res01 = new Responsable("001", "Mr", "Dupont", "Joe", LocalDate.parse("1976-04-21") , "dupont.joe@mail.com", "dupjo12", "06.12.23.34.45", new EmployeCoordonnees("23 rue jolit", 13006, "Marseille"));
		Employe sal01 = new Salarie("001", "Mme", "Durant", "Josie", LocalDate.parse("1986-06-11"), "durant.josie@mail.fr", "durjo20", "06.15.23.34.45", new EmployeCoordonnees("23 avenue Grande", 06006, "Nice"));
		Employe sal02 = new Salarie("002", "Mr", "Machin", "Jacques", LocalDate.parse("2000-02-07"), "machin_j@mail.com", "macj98", "06.23.23.34.45", new EmployeCoordonnees("23 boulevard du cheval rouge", 93200, "Saint-Denis"));
		Employe sal03 = new Salarie("003", "Mm", "Macpol", "Michelle", LocalDate.parse("1989-12-25"), "macMic@email.fr", "macpo76", "06.23.23.34.45", new EmployeCoordonnees("23 boulevard du cheval rouge", 93200, "Saint-Denis"));
		Employe sal04 = new Salarie("004", "Mm", "Tatata", "Agathe", LocalDate.parse("2009-08-08"), "tatata_agathe@mail.com", "tataA08", "06.23.23.34.45", new EmployeCoordonnees("23 boulevard du cheval rouge", 93200, "Saint-Denis"));
		Employe sal05 = new Salarie("005", "Mr", "Totoo", "Jean-Charles", LocalDate.parse("2001-01-01"), "ttjc@email.com", "ttjch01", "06.23.23.34.45", new EmployeCoordonnees("23 boulevard du cheval rouge", 93200, "Saint-Denis"));
		Employe res02 = new Responsable("002", "Mr", "Truc", "Gil", LocalDate.parse("1977-05-16"), "truc_gil@mail.com", "trgi12", "07.12.23.34.45", new EmployeCoordonnees("32 cours bellevue", 14098, "Pertuis"));
		ArrayList<Employe> list = new ArrayList<Employe>();
		list.add(res01);
		list.add(sal01);
		list.add(sal04);
		list.add(sal05);
		list.add(sal03);
		list.add(sal02);
		list.add(res02);
		
		System.out.println(list);
		System.out.println("*****************************************");
		System.out.println(res01.getCoordonnee().getNomVille());
	}

}
