 #!/bin/bash
clear

sudo rm -rf practicas-empresa-ull
git clone https://github.com/kaizten/practicas-empresa-ull
cd practicas-empresa-ull
cd kaizten-blue-task
mvn clean install
echo 'Kaizten Blue Task installed'
cd ../kaizten-red-task
mvn clean install
echo 'Kaizten Red Task installed'

cd ..

sudo rm -rf $HOME/docker/volumes/mongodb/*
mkdir $HOME/docker/volumes/mongodb/

export DATAFLOW_VERSION=2.4.2.RELEASE
export SKIPPER_VERSION=2.3.2.RELEASE
docker-compose up

