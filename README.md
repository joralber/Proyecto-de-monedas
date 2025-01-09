Aplicación Conversor de Monedas

Descripción

Esta aplicación en Java es un conversor de monedas que permite a los usuarios convertir entre varias monedas utilizando la ExchangeRate API.
Proporciona un menú intuitivo con opciones para convertir entre monedas como el dólar estadounidense (USD), peso argentino (ARS), real brasileño (BRL) y
peso colombiano (COP). Obtiene tasas de cambio en tiempo real y realiza las conversiones según la entrada del usuario.

Funcionalidades

Convierte monedas entre USD, ARS, BRL, y COP.

Interfaz simple basada en menús.

Tasas de cambio en tiempo real obtenidas de la API ExchangeRate.

Manejo de errores para entradas inválidas o problemas con la API.

Requisitos

Java 11 o superior.

Conexión a Internet para acceder a la API ExchangeRate.

Biblioteca Gson para el análisis de JSON.

Instalación

Descarga el código fuente del proyecto.

Abre el proyecto en IntelliJ IDEA.

Agrega la biblioteca Gson al proyecto:

Descarga el archivo JAR de Gson desde Maven Repository.

Añádelo al proyecto en IntelliJ IDEA desde File > Project Structure > Libraries.

Reemplaza el marcador YOUR-API-KEY en el código con tu clave API obtenida de ExchangeRate API.

Uso

Compila y ejecuta la aplicación en IntelliJ IDEA.

Sigue las instrucciones en pantalla para seleccionar una opción del menú.

Ingresa las monedas deseadas y la cantidad a convertir.

Visualiza la cantidad convertida en pantalla.

Opciones del Menú

--- Conversor de Monedas ---
1. Dólar =>> Peso argentino
2. Peso argentino =>> Dólar
3. Dólar =>> Real brasileño
4. Real brasileño =>> Dólar
5. Dólar =>> Peso colombiano
6. Peso colombiano =>> Dólar
7. Salir
   Seleccione una opción:

Ejemplo de Salida

--- Conversor de Monedas ---
1. Dólar =>> Peso argentino
2. Peso argentino =>> Dólar
3. Dólar =>> Real brasileño
4. Real brasileño =>> Dólar
5. Dólar =>> Peso colombiano
6. Peso colombiano =>> Dólar
7. Salir
   Seleccione una opción: 1
   Ingrese la cantidad en Dólar: 100
   Cantidad en Peso argentino: 35000.00

Manejo de Errores

Si la clave API es inválida o no hay conexión a Internet, el programa mostrará un mensaje de error.

Si el código de moneda no es compatible, se notificará al usuario.

Autor

Jorge Alberto Hernández Ramírez

Licencia

Este proyecto está bajo la licencia MIT. Codigo abierto.

