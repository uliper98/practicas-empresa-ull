 #!/bin/bash
clear

if [ -d "practicas-empresa-ull" ]; then
  sudo rm -rf practicas-empresa-ull
fi

git clone https://github.com/kaizten/practicas-empresa-ull
cd practicas-empresa-ull
cd kaizten-blue-task
mvn clean install
echo 'Kaizten Blue Task installed'
cd ../kaizten-red-task
mvn clean install
echo 'Kaizten Red Task installed'

cd ..

if [ -d "$HOME/docker/volumes/mongodb/" ]; then
  sudo rm -rf $HOME/docker/volumes/mongodb/*
else
  mkdir -p $HOME/docker/volumes/mongodb/
fi

export DATAFLOW_VERSION=2.4.2.RELEASE
export SKIPPER_VERSION=2.3.2.RELEASE
docker-compose up

