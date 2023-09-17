I used a react to create my frontend and spring to generate my tables and create an API that sends emails and saves of what email was sent where of thease. 

tools used for bootstrapping
spring initializr
vite 


# yakara-test
Prerequesit installs for running this coding test.

`postgresql`

`node`

`java`


# Database setup 

Create a postgresql database named "yakara"

`createdb yakara`


# Starting the backend 

In the `application.properties` some configuration will be needed 

You need to change the PSQL user 
`spring.datasource.username=<user-name>` 

you will need to set some enviromental variables for gmail user name and password. 

```
spring.mail.username=${SPRING_MAIL_USERNAME}
spring.mail.password=${SPRING_MAIL_PASSWORD}
```

this can be done in a terminal (unix based)

```bash
export SPRING_MAIL_USERNAME=<email_adress> 
export SPRING_MAIL_PASSWORD=<password> 
```

I used a google app password to connect to my google mail, details how to set that up are below. 
https://support.google.com/accounts/answer/185833?hl=en  

After this run the `main` function YakaraCodeTestBackEndApplication.java



## Starting the front end 

change directory into `YakaraCodeTestFrontEnd`

`npm i`

`npm run dev`
