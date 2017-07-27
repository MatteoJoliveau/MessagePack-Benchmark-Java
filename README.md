# MessagePack-Benchmark-Java
Java Benchmark for MessagePack vs JSON (Using Jackson)

## Build 
`mvn package`

## Run
#### Without any parameter it executes the benchmark with 200000 objects
`java -jar target/msgpack-json-bench-1.0-full.jar`

#### Pass a number of object to override the standard
`java -jar target/msgpack-json-bench-1.0-full.jar 1500`
