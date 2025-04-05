package _30_Graph_Theory.ShortestPath_Algorithm.Questions;

import java.util.*;

//https://www.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=cheapest-flights-within-k-stops
//Cheapest Flights Within K Stops (Easy Questions)
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
class CheapestFlightsWithinKStops {
    
    class Pair {
        int destination, weight;
        Pair(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    class Tuple {
        int stops, node, cost;
        Tuple(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }
    
    public int findCheapestFlight(int numCities, int[][] flights, int source, int destination, int maxStops) {

        ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
        
        for (int i = 0; i < numCities; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            int fromCity = flight[0];
            int toCity = flight[1];
            int price = flight[2];
            adjacencyList.get(fromCity).add(new Pair(toCity, price));
        }
        
        int[] minCost = new int[numCities];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[source] = 0;
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, source, 0));
        
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int currentStops = current.stops;
            int currentNode = current.node;
            int currentCost = current.cost;
            
            if (currentStops > maxStops) continue;
            
            for (Pair neighbor : adjacencyList.get(currentNode)) {
                int neighborCity = neighbor.destination;
                int flightCost = neighbor.weight;
                
                if (currentCost + flightCost < minCost[neighborCity]) {
                    minCost[neighborCity] = currentCost + flightCost;
                    queue.add(new Tuple(currentStops + 1, neighborCity, currentCost + flightCost));
                }
            }
        }
        
        // If destination is unreachable, return -1
        return minCost[destination] == Integer.MAX_VALUE ? -1 : minCost[destination];
    }
    
    public static void main(String[] args) {
        CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();
        
        int numCities = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 3, 100},
            {0, 2, 500}
        };
        int source = 0;
        int destination = 3;
        int maxStops = 1;
        
        int result = solution.findCheapestFlight(numCities, flights, source, destination, maxStops);
        System.out.println("Cheapest flight cost: " + result);
    }
}
