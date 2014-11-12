package br.unisul.ai.data.factory;

import java.util.ArrayList;
import java.util.List;

import br.unisul.ai.data.City;

public class CityFactory {

	private static List<City> cities;

	public static List<City> getInstance() {
		cities = new ArrayList<City>();
		createCityA();
		createCityB();
		createCityC();
		createCityD();
		createCityE();
		createCityF();
		createCityG();
		createCityH();
		createCityI();
		createCityJ();
		return cities;
	}

	private static void createCityA() {
		City cityA = new City("A");
		cityA.addCost(new City("B"), 180);
		cityA.addCost(new City("C"), 250);
		cityA.addCost(new City("D"), 200);
		cityA.addCost(new City("E"), 350);
		cityA.addCost(new City("F"), 320);
		cityA.addCost(new City("G"), 600);
		cityA.addCost(new City("H"), 500);
		cityA.addCost(new City("I"), 250);
		cityA.addCost(new City("J"), 100);
		cities.add(cityA);
	}

	private static void createCityB() {
		City cityB = new City("B");
		cityB.addCost(new City("A"), 180);
		cityB.addCost(new City("C"), 120);
		cityB.addCost(new City("D"), 150);
		cityB.addCost(new City("E"), 250);
		cityB.addCost(new City("F"), 200);
		cityB.addCost(new City("G"), 400);
		cityB.addCost(new City("H"), 450);
		cityB.addCost(new City("I"), 350);
		cityB.addCost(new City("J"), 300);
		cities.add(cityB);
	}

	private static void createCityC() {
		City cityC = new City("C");
		cityC.addCost(new City("A"), 250);
		cityC.addCost(new City("B"), 120);
		cityC.addCost(new City("D"), 100);
		cityC.addCost(new City("E"), 240);
		cityC.addCost(new City("F"), 180);
		cityC.addCost(new City("G"), 300);
		cityC.addCost(new City("H"), 270);
		cityC.addCost(new City("I"), 350);
		cityC.addCost(new City("J"), 420);
		cities.add(cityC);
	}

	private static void createCityD() {
		City cityD = new City("D");
		cityD.addCost(new City("A"), 200);
		cityD.addCost(new City("B"), 150);
		cityD.addCost(new City("C"), 100);
		cityD.addCost(new City("E"), 170);
		cityD.addCost(new City("F"), 120);
		cityD.addCost(new City("G"), 180);
		cityD.addCost(new City("H"), 250);
		cityD.addCost(new City("I"), 230);
		cityD.addCost(new City("J"), 290);
		cities.add(cityD);
	}

	private static void createCityE() {
		City cityE = new City("E");
		cityE.addCost(new City("A"), 350);
		cityE.addCost(new City("B"), 250);
		cityE.addCost(new City("C"), 240);
		cityE.addCost(new City("D"), 170);
		cityE.addCost(new City("F"), 190);
		cityE.addCost(new City("G"), 220);
		cityE.addCost(new City("H"), 160);
		cityE.addCost(new City("I"), 210);
		cityE.addCost(new City("J"), 270);
		cities.add(cityE);
	}

	private static void createCityF() {
		City cityF = new City("F");
		cityF.addCost(new City("A"), 320);
		cityF.addCost(new City("B"), 200);
		cityF.addCost(new City("C"), 180);
		cityF.addCost(new City("D"), 120);
		cityF.addCost(new City("E"), 190);
		cityF.addCost(new City("G"), 130);
		cityF.addCost(new City("H"), 210);
		cityF.addCost(new City("I"), 190);
		cityF.addCost(new City("J"), 220);
		cities.add(cityF);
	}

	private static void createCityG() {
		City cityG = new City("G");
		cityG.addCost(new City("A"), 600);
		cityG.addCost(new City("B"), 400);
		cityG.addCost(new City("C"), 300);
		cityG.addCost(new City("D"), 180);
		cityG.addCost(new City("E"), 220);
		cityG.addCost(new City("F"), 130);
		cityG.addCost(new City("H"), 130);
		cityG.addCost(new City("I"), 160);
		cityG.addCost(new City("J"), 240);
		cities.add(cityG);
	}

	private static void createCityH() {
		City cityH = new City("H");
		cityH.addCost(new City("A"), 500);
		cityH.addCost(new City("B"), 450);
		cityH.addCost(new City("C"), 270);
		cityH.addCost(new City("D"), 250);
		cityH.addCost(new City("E"), 160);
		cityH.addCost(new City("F"), 210);
		cityH.addCost(new City("G"), 130);
		cityH.addCost(new City("I"), 270);
		cityH.addCost(new City("J"), 290);
		cities.add(cityH);
	}

	private static void createCityI() {
		City cityI = new City("I");
		cityI.addCost(new City("A"), 250);
		cityI.addCost(new City("B"), 350);
		cityI.addCost(new City("C"), 350);
		cityI.addCost(new City("D"), 230);
		cityI.addCost(new City("E"), 210);
		cityI.addCost(new City("F"), 190);
		cityI.addCost(new City("G"), 160);
		cityI.addCost(new City("H"), 270);
		cityI.addCost(new City("J"), 190);
		cities.add(cityI);
	}

	private static void createCityJ() {
		City cityJ = new City("J");
		cityJ.addCost(new City("A"), 100);
		cityJ.addCost(new City("B"), 300);
		cityJ.addCost(new City("C"), 420);
		cityJ.addCost(new City("D"), 290);
		cityJ.addCost(new City("E"), 270);
		cityJ.addCost(new City("F"), 220);
		cityJ.addCost(new City("G"), 240);
		cityJ.addCost(new City("H"), 290);
		cityJ.addCost(new City("I"), 190);
		cities.add(cityJ);
	}
}