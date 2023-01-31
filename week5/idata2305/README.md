# Running the code

1. Compile the the code to bytecode 

```bash
javac -sourcepath ./src -d ./out ./src/*.java
```

2. Run the Main function with a discriminator representing the type of server that should be used. Valid options are `single` and `multi`. 

```bash
java -cp ./out Main <thread-type>
```

Examples:

```bash
java -cp ./out Main multi
java -cp ./out Main single
```
