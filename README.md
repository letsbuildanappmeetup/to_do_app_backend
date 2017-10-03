# To do app! 

First of all you have to download cassandra (database)


1- Download and install Cassandra

2- Run Cassandra with cassandra -f

3- now switch to the in the CQLSH console and run the following commands:

3.1- CREATE KEYSPACE todoapp WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

3.2- use todoapp ;

4- run the statments that are in the following project file:

YOUR_WORK_SPACE/letsbuildapp/to_do_app_backend/src/test/resources/setup.cql