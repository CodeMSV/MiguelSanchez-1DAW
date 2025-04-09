"use strict"

let thor = "Thor es el hijo de Odín";

// Largo de la cadena
console.log(thor.length);

//Encontrar la letra o
console.log(thor.indexOf("o"));

//Encontrar el carácter que ocupa la posición 3
console.log(thor.charAt(3));

//¿Qué carácter ocupa la posición 1?
console.log(thor.charAt(1));

//Trocea la cadena usando los espacios en blanco
console.log(thor.split(" "));

//Reemplaza Thor por Loki
console.log(thor.replace("Thor", "Loki"));

//Recorta la cadena para que devuelva la palabra Odín
console.log(thor.slice(19, 23));

//¿Puedes encontrar la letra a? Demuéstralo
console.log(thor.indexOf("a"));

//Pon la mitad de la cadena en minúsculas (Sin usar las posiciones de 0 a 11)
let mitad = Math.floor(thor.length / 2);
let nuevaCadena = thor.slice(0, mitad) + thor.slice(mitad).toLowerCase();
console.log(nuevaCadena);