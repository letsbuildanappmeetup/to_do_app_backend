# To do app! 

First of all you have to download cassandra (database)


1- Download and install Cassandra

2- Run Cassandra with cassandra -f

3- add the keyspace. 

CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

4- run the statment in the script file 

YOUR_WORK_SPACE/letsbuildapp/to_do_app_backend/src/test/resources/setup.cql