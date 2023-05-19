/**
 * funcion para obtener valores de los input del registro y inicio de sesion
 * @returns un array[] de los input
 */
const obtenerValores = () => {
    const correoLogin = document.getElementById('correoL').value;
    const contraLogin = document.getElementById('contraL').value;
    const nombreRegistro = document.getElementById('nombreR').value;
    const correoRegistro = document.getElementById('correoR').value;
    const contraRegistro = document.getElementById('contraR').value;
    return[correoLogin, contraLogin, nombreRegistro, correoRegistro, contraRegistro]; 
};

/**
 * funcion para revisar que los input's del registro no esten vacios
 * @param {*} str 
 * @returns boolean verdadero o falso
 */
function comparacionStrVacio(str) {
    return (!str || str.length === 0 );
}
/**
 * funcion que valida que los input's no se encuentren vacios
 * @returns un String con si o no 
 */
const comparaValoresValidos = () => {
    const valorComparar = obtenerValores();

    return comparacionStrVacio(valorComparar[2]) === true ? "no" : 
    comparacionStrVacio(valorComparar[3]) === true ? "no" : 
    comparacionStrVacio(valorComparar[4]) === true ? "no" : "si";
}
/**
 * funcion que guarda los valores de registro en el localstorage
 */
const guardarUsuarios = () => {
    const guardarUsuario = obtenerValores();
    console.log(guardarUsuario);
    console.log(comparaValoresValidos());
    if(comparaValoresValidos() === "si") {
        localStorage.setItem("nombre-registrado", JSON.stringify(guardarUsuario[2]));
        localStorage.setItem("correo-registrado", JSON.stringify(guardarUsuario[3]));
        localStorage.setItem("contra-registrado", JSON.stringify(guardarUsuario[4]));
    } else {
        alert("no se pueden guardar datos vacios");
    }
};
/*
const guardarUsuariosJson = () =>{
    const usuario = obtenerValores;
    {
        nombre:usuario[2];
        correo:usuario[3];
        contrasenia:usuario[4];
    }
}
;
console.log(guardarUsuariosJson());

const fs = require('fs');
const usuariosJson = JSON.stringify(guardarUsuariosJson);
fs.writeFile('usuarios.json', usuariosJson, (error) => {
    if(error) throw error;
    console.log('Archivo guardado');
});
*/

/**
 * funcion que lee el localstorage y compara los datos para iniciciar sesion
 */
const revisarUsuarios = () => {
    const usuario = obtenerValores();
    let correoUsuario = usuario[0];
    let contraUsuario = usuario[1];
    let nombre = JSON.parse(localStorage.getItem('nombre-registrado'));
    let correo = JSON.parse(localStorage.getItem('correo-registrado'));
    let contra = JSON.parse(localStorage.getItem('contra-registrado'));
    console.log(typeof(correoUsuario) + " del obtenido ingresado " + correoUsuario);
    console.log(typeof(contraUsuario) + " del obtenido ingresado " + contraUsuario);
    console.log(typeof(correo) + " del obtenido localstorage " + correo);
    console.log(typeof(contra) + " del obtenido localstorage" + contra);
   /* if (correo == correoUsuario && contra == contraUsuario) {
        alert("El usuario ingresado es correcto, Bienvenido");
    } else {
        alert("El usuario ingresado no existe o es incorrecto");
    }*/

    return correo != correoUsuario ? alert("correo incorrecto") : contra != contraUsuario ? alert("contraseña incorrecta") : alert("Bienvenido, " + nombre);
}