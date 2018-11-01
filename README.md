# Spark web - proof of concept


Se puede generar un token con el siguiente código:

```Java
String secret = "god";
Algorithm algorithm = Algorithm.HMAC256(secret);
String token = JWT.create()
    .withClaim("user", 1)
    .sign(algorithm);

System.out.println(token); //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoxfQ.GDCk-9yZwlADFew9jI551Izq9Dj3SYsCfEL5qcUZYlM
```

O usando el siguiente sitio: [https://jwt.io/](https://jwt.io/)