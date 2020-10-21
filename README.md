# RODRIGUEZ-MALDONADO-ARSW-T2

# Heroku

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://arsw-rodriguez-maldonado-t2.herokuapp.com/)

# Resumen

Se realizo una aplicación la cual consume una API de Clima en que se puede consultar por el nombre del pais

# Ejecucion

con el siguiente comando se podra ejecutar la aplicación

```
mvn spring-boot:run
```
# Diseño

la aplicacion se desarrollo con la ayuda de la arquitectura apiRest

# extensibilidad

1. para extender la aplicacion se puede incluir mas conecciones de otra api mediante la clase Httpconnect, esta tambien funcionara para realizar mas peticiones
2. La aplicacion contiene dos archivos js que maneja de manera independiente las peticiones para el manejo correcto del front
3. la cache se maneja por cada peticion, por lo que una nueva peticion se le tendra que crear otro hasmap de cache
