FROM node:16

#Create app directory
WORKDIR /usr/src/app

#copied package 
#COPY package*.json ./
COPY . .
#install dependency
RUN npm install
#
#COPY . .

EXPOSE 8080
CMD [ "node", "--trace-deprecation", "server.js" ]