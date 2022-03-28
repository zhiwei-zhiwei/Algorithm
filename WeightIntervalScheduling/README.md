# WeightIntervalScheduling
Dynamic Programming

University of Wisconsin Madison - COMP SCI 577 \
Instructor: Dr. Marc Renault\
Written by Zhiwei Cao

The input will start with an positive integer, giving the number of instances that follow. For each
instance, there will be a positive integer, giving the number of jobs. For each job, there will be a trio of
positive integers i, j and k, where i < j, and i is the start time, j is the end time, and k is the weight.
A sample input is the following: \
2 \
1 \
1 4 5 \
3 \
1 2 1 \
3 4 2 \
2 6 4 

The sample input has two instances. The first instance has one job to schedule with a start time of 1
and an end time of 4. The second instance has 3 jobs.\
For each instance, your program should output the total weight of the intervals scheduled on a separate
line. Each output line should be terminated by a newline. The correct output to the sample input would
be: \
5 \
5

