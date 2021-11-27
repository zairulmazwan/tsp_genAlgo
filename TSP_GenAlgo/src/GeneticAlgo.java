import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;


public class GeneticAlgo {
	
	static double [][] dataset;
	
	
	class Individual{
		
		public ArrayList<Integer> chromosome = new ArrayList<Integer>();
		double fitness;
		
		public Individual(int n) {
			
			Set<Integer> chromosome = new LinkedHashSet<Integer>();//we use set to get unique number within the range
			
			Random r = new Random();
			
			while(chromosome.size()<n) {
				chromosome.add(r.nextInt(n));
			}
			
			this.chromosome = new ArrayList<Integer>(chromosome); //convert set into arrayList
			setFitness();
		}
		
		public void setFitness () {
			
			double res = 0;
			int size = chromosome.size();
			
			for(int i=0; i<size-1; i++) {
				int from = chromosome.get(i);
				int to = chromosome.get(i+1);
				
				//System.out.println(from+" "+to);
				//System.out.println(dataset[from][to]);
				
				res += dataset[from][to];
			}
			//System.out.println(ind.chromosome.get(size-1)+" "+ind.chromosome.get(0));
			res+= dataset[chromosome.get(size-1)][chromosome.get(0)]; //x[n][0] - return to the origin
			//System.out.println(res);
				
			this.fitness = res;
			
		}
		
	}

	class Population{
		
		public ArrayList<Individual> population = new ArrayList<Individual>();
		
		public Population (int popSize, int chromosomeSize) {
		
			for (int i=0; i<popSize; i++) {
				Individual ind = new Individual(chromosomeSize);
				this.population.add(ind);
			}
		}
		
		public void printPop() {
			
			for (int i=0; i<population.size(); i++) {
				System.out.print(population.get(i).chromosome+"\t");
				System.out.println(population.get(i).fitness);
			}
		}
		
		public Individual crossOver (Individual p1, double rate) {
			
			Individual res =  null;
			
			int index = (int) (p1.chromosome.size()*rate);
			
			
			
			return res;
			
		}

		
	}

	public static void main(String[] args) {
		
		GeneticAlgo ga = new GeneticAlgo();
		
		int chromosomeSize = 5;
		
		dataset = Data.genData(chromosomeSize);
		Data.printArray(dataset);
		
		Population pop = ga.new Population(10, chromosomeSize); //create 10 candidates, each candidates has 5 genes (5 nodes), pass dataset to calculate fitness
		
		pop.printPop();
		
		Collections.sort(pop.population,new CompareFitness()); //sorting the population by fitness (asc)
		
		System.out.println("==After sorting fitness==");
		pop.printPop();
		
//		System.out.println(pop.population.get(0).chromosome);
//		System.out.println(pop.population.get(0).fitness);
		//pop.crossOver(pop.population.get(0), pop.population.get(1), 0.8);

	}

}
