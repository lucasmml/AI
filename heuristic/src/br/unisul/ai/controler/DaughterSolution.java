package br.unisul.ai.controler;

import java.util.ArrayList;
import java.util.List;

import br.unisul.ai.data.City;
import br.unisul.ai.data.factory.CityFactory;

public class DaughterSolution {

	public static void main(String arg[]) {
		List<City> orderedList = CityFactory.getInstance();
		new DaughterSolution(orderedList);
	}
	
	public DaughterSolution(List<City> initialCitiesList) {
		List<City> daughterSolutionGenerated = null;
		boolean first = true;

		while (daughterSolutionGenerated != null || first) {
			if(first){
				daughterSolutionGenerated = initialCitiesList;
			}
			
			System.out.println("-----------------------------+");
			daughterSolutionGenerated = generateDaughterSolution(daughterSolutionGenerated);
			first = false;
		}
		System.out.println("The end");
	}

	public List<City> generateDaughterSolution(List<City> initialList) {
		Integer sumOfInitialSolution = getValueOfTripFromlist(initialList);
		List<List<City>> solucoesFilhasDaListaInicialAbsoluta = geraSolucoesFilhasDaLista(initialList);

		StringBuilder sb;

		List<List<City>> solutionsList = new ArrayList<List<City>>();
		for (List<City> cities : solucoesFilhasDaListaInicialAbsoluta) {
			sb = new StringBuilder();

			for (City listCities : cities) {
				sb.append(listCities.getNmCity() + ", ");
			}

			String values = sb.toString().substring(0, sb.toString().length() - 2) + " | Distance: " + getValueOfTripFromlist(cities);
			System.out.println(values);
			solutionsList.add(cities);
		}

		List<City> chosenSolution = getTripLowestValue(solutionsList);
		Integer sumOfChosenSolution = getValueOfTripFromlist(chosenSolution);
		if (sumOfInitialSolution < sumOfChosenSolution) {
			displaySumValuesFromList(initialList);
			return null;
		} else {
			return chosenSolution;
		}
	}

	private void displaySumValuesFromList(List<City> list) {
		StringBuilder sb = new StringBuilder();
		for (City c : list) {
			sb.append(c.getNmCity() + ", ");
		}

		String values = sb.toString().substring(0, sb.toString().length() - 2) + " | Distance: " + getValueOfTripFromlist(list);
		System.err.println(values);
	}

	protected List<List<City>> geraSolucoesFilhasDaLista(List<City> listCities) {
		Object[] initialList = listCities.toArray();
		Object[] sonsList = null;
		City aux = null;

		List<List<City>> citiesOfTripList = new ArrayList<List<City>>();
		List<City> daughterSolution = null;
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 10; j++) {
				sonsList = new Object[initialList.length];

				System.arraycopy(initialList, 0, sonsList, 0, initialList.length);

				aux = (City) sonsList[i];
				sonsList[i] = sonsList[j];
				sonsList[j] = aux;

				daughterSolution = new ArrayList<City>();
				for (int k = 0; k < sonsList.length; k++) {
					City actualSon = (City) sonsList[k];
					daughterSolution.add(actualSon);
				}
				citiesOfTripList.add(daughterSolution);
			}
		}
		return citiesOfTripList;
	}

	private Integer getValueOfTripFromlist(List<City> listCities) {
		Object[] sonsList = listCities.toArray();
		Integer sum = 0;
		for (int k = 0; k < sonsList.length; k++) {
			City actualSon = (City) sonsList[k];

			if (k < (sonsList.length - 1)) {
				City nextSon = (City) sonsList[k + 1];
				if (nextSon != null) {
					sum = sum + actualSon.costTo(nextSon);
				}
			}
		}
		return sum;
	}

	private List<City> getTripLowestValue(List<List<City>> listCities) {
		Integer minValue = Integer.MAX_VALUE;
		int count = 1;
		List<City> chosenSolution = null;

		for (List<City> cities : listCities) {
			Integer actualValue = getValueOfTripFromlist(cities);
			if (actualValue < minValue) {
				minValue = actualValue;
				chosenSolution = cities;
			}
			count++;
		}
		return chosenSolution;
	}
}