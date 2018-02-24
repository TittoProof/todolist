#!/bin/bash
mvn clean install
cp target/ToDoList-*.jar .
docker build -t todolist .