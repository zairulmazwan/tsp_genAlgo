import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;



class Individual{
	
	public Set<Integer> chromosome = new LinkedHashSet<Integer>();
	
	public Individual(int n) {
		
		Random r = new Random();
		while(chromosome.size()<n) {
			this.chromosome.add(r.nextInt(n)+1);
		}
	}
	
	
}

class Population{
	
	ArrayList<Individual> population = new ArrayList<Individual>();
	
	public Population (int popSize, int chromosomeSize) {
	
		for (int i=0; i<popSize; i++) {
			Individual ind = new Individual(chromosomeSize);
			this.population.add(ind);
		}
	}
	
	public void printPop() {
		
		for (int i=0; i<population.size(); i++) {
			System.out.println(population.get(i).chromosome);
		}
	}
	
	
}


public class GeneticAlgo {
	


	public static void main(String[] args) {
		
//		Individual ind = new Individual(5);
//		
//		System.out.println(ind.chromosome);
		
		Population pop = new Population(10,10);
		pop.printPop();
		
	
	
	}

}
