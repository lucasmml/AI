package br.unisul.ai.data;

import java.util.HashMap;
import java.util.Map;

public class City {
	
	private String nmCity;
	private Map<String, Integer> costs;

	public City (String nmCity){
		this.nmCity = nmCity;
	}
	
	public void addCost(City city, Integer cost) {
		getCosts().put(city.getNmCity(), cost);
	}
	
	public Integer costTo(City city){
		Map<String, Integer> costBetweenCities = getCosts();
		return costBetweenCities.get(city.getNmCity());
	}
	
	private Map<String,Integer> getCosts(){
		if(costs == null){
			this.costs = new HashMap<String, Integer>();
		}
		return this.costs;
	}
	
	public String getNmCity(){
		return nmCity;
	}

	public void setNmCity(String nmCity) {
		this.nmCity = nmCity;
	}
}