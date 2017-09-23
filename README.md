# To do app! 

First of all you have to download cassandra (database)

For Mac:

1- Downland Homebrew. 

ruby -e "$(curl -fsSL https://raw.github.com/Homebrew/homebrew/go/install)"


2- Install Cassandra

brew install cassandra


3- Add Cassandra to your bash_profile so you can use it everywhere 

subl ~/.bash_profile

-- Add this line to the file 

if [ -d "$HOME/opt/cassandra" ]; then
    export PATH="$PATH:$HOME/opt/cassandra/bin"
fi

4- Run Cassandra 

cassandra -f


5- add the keyspace. 

CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };



You are good to go.

Dont forget to run the statments in setup.cql in the first time you run the application 