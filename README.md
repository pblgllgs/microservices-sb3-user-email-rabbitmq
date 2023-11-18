# Spring boot 3

## RabbitMQ Producer/Consumer email notification pattern

Get credentials for the email service in google or your email provider

```sh
PASSWORD_APPLICATION_GOOGLE=SOME_TOKEN
EMAIL_FROM=SOME_EMAIL 
```

## Run

```bash
docker compose up -d
```

## Test the endpoint

```curl
curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"NAME",
    "email":"EMAIL_TO_SEND@gmail.com"
}'
```

## Intellij rest api request request.http file

```bash
POST http://localhost:8080/users
Content-Type: application/json

{
  "name": "NAME",
  "email": "EMAIL_TO_SEND@gmail.com"
}
```