# Travellers Character Creator

## background
The intent for this project is to create a character generator for travellers that gives the user an experience similar to an interactive story, giving them options based on what they have picked and luck.

## Implimentation

Still up for debate if this function as a stand alone application or a possible web app.

## Getting started 

### develoer
To get started you first need to download Docker https://www.docker.com/get-started

once you have pulled the repo do the following

To let the docker use your display for gui run `socat TCP-LISTEN:6000,reuseaddr,fork UNIX-CLIENT:\"$DISPLAY\"` in another terminal (It locks the teminal)
For some reason this only seems to work sometimes an alternative is to run `xhost +local:root`
if you add a new file make sure to add it to build
Build the docker image and compile the java `docker build -t creator .`

**to run** `docker run -v /tmp/.X11-unix:/tmp/.X11-unix -e DISPLAY=$(ipconfig getifaddr en0):0 creator`
 
**to get onto your container (I haven't been able to get this working)**



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