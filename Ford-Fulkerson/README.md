# Ford-Fulkerson  Max flow
Network Flow

University of Wisconsin Madison - COMP SCI 577 \
Instructor: Dr. Marc Renault\
Written by Zhiwei Cao

The input will start with a positive integer, giving the number of instances that follow. For each instance,
there will be two positive integers, indicating the number of nodes n = |V | in the graph and the number
of edges |E| in the graph. Following this, there will be |E| additional lines describing the edges. Each
edge line consists of a number indicating the source node, a number indicating the destination node, and
a capacity. The nodes are not listed separately, but are numbered {1 . . . n}.
Your program should compute the maximum flow value from node 1 to node n in each given graph.
A sample input is the following:\
2\
3 2\
2 3 4\
1 2 5\
6 9\
1 2 9\
1 3 4\
2 4 1\
2 5 6\
3 4 4\
3 5 5\
4 6 8\
5 6 5\
5 6 3

The sample input has two instances. For each instance, your program should output the maximum flow
on a separate line. Each output line should be terminated by a newline. The correct output for the
sample input would be: \
4\
11
