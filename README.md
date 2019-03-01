# Travellers Character Creator

## background
The intent for this project is to create a character generator for travellers that gives the user an experience similar to an interactive story, giving them options based on what they have picked and luck.

## Implimentation

Still up for debate if this function as a stand alone application or a possible web app.

## Getting started 

### develoer
To get started you first need to download Docker https://www.docker.com/get-started

once you have pulled the repo do the following

Build the docker image `docker build -f Dockerfile -t travellers/oracle-java:8 .`

once built, run these from the location of dockerfile.

**to compile** `docker run --rm -v $PWD:/app -w /app travellers/oracle-java:8 javac Main.java`

**to run** `docker run --rm -v $PWD:/app -w /app travellers/oracle-java:8 java Main`

**to get onto your container**

if you want to get onto the docker container and run stuff like a linux system
you need to to docker run with 1 extra argument `-d` for detach as below

`docker run --rm -d -v $PWD:/app -w /app travellers/oracle-java:8`

then when you run

**`docker ps`**

this will give you output with titles like 

`CONTAINER ID        IMAGE                      COMMAND             CREATED             STATUS              PORTS               NAMES`

you can use the container id or the name given, in my case the name was `inspiring_raman`, you can use that to run

`docker exec -it inspiring_raman bash`

this is telling your detached docker container to run bash, which is your terminal, from here you can run 
` javac Main.java` or ` java Main`



> this is all pretty barebones but thats basically it. Make sure if you add any dependencies or anything record it here so if we need to bring someone up to speed its easy



Made for Aardvarks by Aardvarks :ok_hand: