# Running the code

1. Compile the the code to bytecode 

```bash
javac -sourcepath ./src -d ./out ./src/*.java
```

2. Run the Main function with a discriminator representing the type of server that should be run. Valid options are `single` and `multi`, where they represent single threaded and multi threaded servers respectively. 

```bash
java -cp ./out Main <thread-type>
```

Examples:

```bash
java -cp ./out Main multi
java -cp ./out Main single
```


## Some observations

For some reason requesting from Postman results in some odd behaviour where client sockets are closed. I would suggest using a tool like `curl` to test the server. 

When running the single threaded server, the second request has to wait for the first request to finish. (taking approx. 20s in total)

When running the multi threaded server, the second request is processed in parallel with the first request. (taking approx. 10s in total)

