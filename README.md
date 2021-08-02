# easy-chat
This repository contains a Java project for a chat application.

## Explanation about the project

In the AppEasyChat directory, you will find all the files of the project.
With him, you can run the project to see the application windows and
interact with the database.

To run the project, you will need to use java in the command line interpreter,
and use the classpath to the database. Together with the database, you need a 
SQLite 3 Driver, that is a .JAR file used to communicate with the tables.

About the source codes, the Main code, like cited above, is the root of the
project. In the sequence comes the TelaInicial.java, that is a code to render
the first window. The first windows has two button, Login and Registrar. If 
you have registered in the app, click Login. If not, click Registrar to create
an account.

Before logged, you can find a window with a menu bar. The options in menu bar
are some operations of the application, like creating a chat or sending messages.

We hope you enjoy the use of EasyChat and comment your impressions. And, once the
project is open-source, feel free to download the code and edit. Just follow the
MIT license and cite this repository. Thank you!

## Explanation about the database

About the database, it is a SQLite 3 based database, that contains 6
tables: usuario, conversa, conversaGrupo, mensagem, participante e
administrador.

The usuario table contains data describing people who are registered in
the app system. 

The conversa table contains data describing chats among 2 or more people.

The conversaGrupo table describes chats that have more than 2 participants.

The mensagem table has data that show messages sent via the chats.

The participante table describes people and in what chats they are in.

Finish, the administrador table describes users that are admins of chats.

## Some prints of the EasyChat

![image](https://user-images.githubusercontent.com/54182167/127801256-b88ce21b-0031-4106-a8ed-a8322d66982d.png)
Initial window.

![image](https://user-images.githubusercontent.com/54182167/127801311-a6939994-5e68-4172-b910-32f06a2bef11.png)
Login window.

![image](https://user-images.githubusercontent.com/54182167/127801348-b3e10fc4-47d9-4598-bdfc-0c83ba06519b.png)
Register window.

![image](https://user-images.githubusercontent.com/54182167/127801434-7fb1ae1a-0926-470c-922d-587a83ceec6a.png)
Chat creation window.

![image](https://user-images.githubusercontent.com/54182167/127801498-88e0de19-6c80-4efd-877b-c6836f0a9f4b.png)
Chat joining window.
