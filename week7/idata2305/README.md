# Week 7: Assignment 2 - Thread synchronization (IDATA2305)

## Running the code

1.  Compile the code to bytecode

```bash
javac -sourcepath ./src -d ./out ./src/*.java
``` 

2. Run the Main class

```bash
java -cp ./out Main
```

3. Observe the output of the program execution

## Observations

When the ticket server runs without synchronization, the clients are all able to get tickets. 
Since multiple threads read the same variable around the same time, the mutated value of the variable is inconsistent. 

When running the ticket server with synchronization, the clients are not all able to get tickets.
The synchronized keyword ensures that only one thread can execute at a time, and the number of available tickets is mutated in a synchronous fashion resulting in a consistent value. 
