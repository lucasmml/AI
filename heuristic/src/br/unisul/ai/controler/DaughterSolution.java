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
		Integer somaDaSolucaoInicial = pegaValorDaViagemDaLista(initialList);
		List<List<City>> solucoesFilhasDaListaInicialAbsoluta = geraSolucoesFilhasDaLista(initialList);

		StringBuilder sb;

		List<List<City>> listaComTodasAsSolucoes = new ArrayList<List<City>>();
		for (List<City> cities : solucoesFilhasDaListaInicialAbsoluta) {
			sb = new StringBuilder();

			for (City listCities : cities) {
				sb.append(listCities.getNmCity() + ", ");
			}

			String values = sb.toString().substring(0, sb.toString().length() - 2) + " | Distance: " + pegaValorDaViagemDaLista(cities);
			System.out.println(values);
			listaComTodasAsSolucoes.add(cities);
		}

		List<City> solucaoEscolhida = pegaViagemComMenorValor(listaComTodasAsSolucoes);
		Integer somaSolucaoEscolhida = pegaValorDaViagemDaLista(solucaoEscolhida);
		if (somaDaSolucaoInicial < somaSolucaoEscolhida) {
			exibeValoresDaListaComSoma(initialList);
			return null;
		} else {
			return solucaoEscolhida;
		}
	}

	private void exibeValoresDaListaComSoma(List<City> list) {
		StringBuilder sb = new StringBuilder();
		for (City c : list) {
			sb.append(c.getNmCity() + ", ");
		}

		String valores = sb.toString().substring(0, sb.toString().length() - 2) + " | Distance: " + pegaValorDaViagemDaLista(list);
		System.err.println(valores);
	}

	protected List<List<City>> geraSolucoesFilhasDaLista(List<City> listCities) {
		Object[] listaInicial = listCities.toArray();
		Object[] listaFilhos = null;
		City aux = null;

		List<List<City>> listaDeCidadesDaViagem = new ArrayList<List<City>>();
		List<City> solucaoFilha = null;
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 10; j++) {
				listaFilhos = new Object[listaInicial.length];

				System.arraycopy(listaInicial, 0, listaFilhos, 0,
						listaInicial.length);

				aux = (City) listaFilhos[i];
				listaFilhos[i] = listaFilhos[j];
				listaFilhos[j] = aux;

				solucaoFilha = new ArrayList<City>();
				for (int k = 0; k < listaFilhos.length; k++) {
					City filhoAtual = (City) listaFilhos[k];
					solucaoFilha.add(filhoAtual);
				}
				listaDeCidadesDaViagem.add(solucaoFilha);
			}
		}
		return listaDeCidadesDaViagem;
	}

	private Integer pegaValorDaViagemDaLista(List<City> listCities) {
		Object[] listaFilhos = listCities.toArray();
		Integer sum = 0;
		for (int k = 0; k < listaFilhos.length; k++) {
			City actualSon = (City) listaFilhos[k];

			if (k < (listaFilhos.length - 1)) {
				City proximoFilho = (City) listaFilhos[k + 1];
				if (proximoFilho != null) {
					sum = sum + actualSon.costTo(proximoFilho);
				}
			}
		}
		return sum;
	}

	private List<City> pegaViagemComMenorValor(List<List<City>> listCities) {
		Integer minValue = Integer.MAX_VALUE;
		int count = 1;
		List<City> solucaoEscolhida = null;

		for (List<City> cities : listCities) {
			Integer actualValue = pegaValorDaViagemDaLista(cities);
			if (actualValue < minValue) {
				minValue = actualValue;
				solucaoEscolhida = cities;
			}
			count++;
		}
		return solucaoEscolhida;
	}
}