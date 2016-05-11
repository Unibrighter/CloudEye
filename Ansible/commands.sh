#!/bin/bash
# setup environment
sudo apt-get update
sudo apt-get install default-jre
sudo apt-get install default-jdk

# git setup
sudo apt-get install git
git clone https://github.com/zhangy10/ccc_team_2.git
ccc_team_2

# ansible setup
sudo easy_install pip
sudo pip install paramiko PyYAML Jinja2 httplib2 six
sudo apt-get install ansible

# execute 8 twitter harvester applications (each vm will execute 2 commands to run both of streaming API and REST API
sudo nohup java -jar /home/ubuntu/ccc_team_2/cloudtweets.jar -ap 1 > streaming.log &
sudo nohup java -jar /home/ubuntu/ccc_team_2/cloudtweets.jar -ap 5 > rest.log &

sudo nohup java -jar /home/ubuntu/ccc_team_2/cloudtweets.jar -ap 2 > streaming.log &
sudo nohup java -jar /home/ubuntu/ccc_team_2/cloudtweets.jar -ap 6 > rest.log &

sudo nohup java -jar /home/ubuntu/ccc_team_2/cloudtweets.jar -ap 3 > streaming.log &
sudo nohup java -jar /home/ubuntu/ccc_team_2/cloudtweets.jar -ap 7 > rest.log &

sudo nohup java -jar /home/ubuntu/ccc_team_2/cloudtweets.jar -ap 4 > streaming.log &
sudo nohup java -jar /home/ubuntu/ccc_team_2/cloudtweets.jar -ap 8 > rest.log &

# couchdb setup
sudo apt-get install couchdb

#create the external storing dir
sudo mkdir /mnt/tw_conchdb
sudo mkdir /mnt/tw_conchdbview

#change the user group and mod
sudo chown -R couchdb:couched /usb/tw_conchdb
sudo chown -R couchdb:couched /usb/tw_conchdbview

# edit couchdb local.ini to open the ip access and redirect the store dir to external dir if necessary
# sudo nano /etc/couchdb/local.ini

sudo service couchdb stop/start
# test service
curl http://localhost:5984/

#start web server
sudo apt-get install nginx
sudo nginx -s reload
