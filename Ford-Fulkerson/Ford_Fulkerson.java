// Written by Zhiwei
import java.util.LinkedList;
import java.util.Scanner;

public class Ford_Fulkerson {
    public static int root = 1;

    static long maxFlow(int[][] graph, int node) {
        int residualG[][] = graph;
        long maxFlow = 0;
        int[] path = new int[node+1];
        while (bfs(residualG, node, path)) {
            // while there is a path between 1 to node number
            int maxCapacity = Integer.MAX_VALUE;
            // set a boundary
            for (int i = node; i != 1; i = path[i]) {
                // find the min capacity
                int temp = path[i];
                maxCapacity = Math.min(maxCapacity, temp);
                // NF only can hold the min capacity on a path
            }
            // update the flow
            for (int i = node; i != 1; i = path[i]) {
                int temp = path[i];
                residualG[temp][i] -= maxCapacity;
                // forward = original capacity - residual capacity
                residualG[i][temp] += maxCapacity;
                // residual capacity += residual capacity
            }
            maxFlow += maxCapacity;
        }
        return maxFlow;
    }

    // https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
    static boolean bfs(int[][] residualG, int node, int[] path) {
        boolean visited[] = new boolean[node+1];
        for (int i = 1; i <= node; i++) {
            visited[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(root); // root node, the begining of the graph
        visited[root] = true;
        path[root] = -1;
        while (queue.size() != 0) {
            int tmp = queue.poll();
            for (int i = 1; i < node + 1; i++) {
                if (visited[i] == false && residualG[tmp][i] > 0) {
                    if (i == node) {
                        // when the algo find the path between source node to sink node
                        path[i] = tmp;
                        return true;
                    }
                    queue.add(i);
                    path[i] = tmp;
                    visited[i] = true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int outLoop = Integer.parseInt(key.nextLine());
        Long[] sol = new Long[outLoop];
        for (int i = 0; i < outLoop; i++) {
            String input = key.nextLine();
            String[] arrInput = input.split(" ");
            int node = Integer.parseInt(arrInput[0]);
            int edge = Integer.parseInt(arrInput[1]);
//            System.out.println("node :"+node+" dege: "+edge);
            int graph[][] = new int[node+1][node+1];
            for (int j = 0; j < edge; j++) {
                String temp = key.nextLine();
                String[] tempArr = temp.split(" ");
                int row = Integer.parseInt(tempArr[0]);
                int col = Integer.parseInt(tempArr[1]);
                int cap = Integer.parseInt(tempArr[2]);
//                System.out.println("row: "+row+"col: "+col+"cap: "+cap);
                graph[row][col] += cap;
            }
            long solution = maxFlow(graph, node);
            sol[i] = solution;
//            for (int j = 0; j < edge; j++) {
//                for (int k = 0; k < edge; k++) {
//                    System.out.print(graph[j][k]);
//                }
//                System.out.println();
//            }
        }

        for (int i = 0; i < outLoop; i++) {
            System.out.println(sol[i]);
        }
    }

}
