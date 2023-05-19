//const boton = document.querySelector('.boton');
const formularioRegistro = document.querySelector('.registro');
const respuesta = document.querySelector('.respuesta');

const obtenerDatos = () => {
    const datos = new FormData(formularioRegistro);
    const datosCompletos = Object.fromEntries(
        datos.entries());

    console.log(JSON.stringify(datosCompletos));
    //formularioRegistro.reset();
    return datosCompletos;
};


/*const postData = async () => {
    const newUser = obtenerDatos();
    try {
        const response = await fetch ('http://localhost:3000/usuarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newUser)
        });
        if (response.ok) {
            const jsonResponse = await response.json();
            const {nombre, correo, contraseña} = jsonResponse;
            respuesta.innerHTML = `
            <ul>
            se guardo la siguinte info: 
            <li>${nombre}</li>
            <li>${correo}</li>
            <li>${contraseña}</li>
            </ul>
            `
        }
    } catch (error) {
        console.log(error);
    }
};*/
 /*const url = 'http://localhost:3000/usuarios';

const envio = (url = 'http://localhost:3000/usuarios') =>{
    const data = obtenerDatos();
    fetch(url, {
    method: 'POST', // or 'PUT'
    body: JSON.stringify(data), // data can be `string` or {object}!
    headers:{
        'Content-Type': 'application/json'
    }
    }).then(res => res.json())
    .catch(error => console.error('Error:', error))
    .then(response => console.log('Success:', response));
}

//formularioRegistro.addEventListener('submit', obtenerDatos);
boton.addEventListener('click', (event) => {
    event.preventDefault();
    envio();
});*/


//obteniendo los datos del json
fetch('http://localhost:3000/users')
    .then((response) => response.json())
    .then((json) => console.log(json));



const boton = document.getElementById('boton');
//posteando los datos
boton.addEventListener('click', ()=>{

    const url = 'http://localhost:3000/users';
    const datos =  obtenerDatos(); /*{
        nombre: document.getElementById('nombreR').value,
        correo:document.getElementById('correoR').value,
        contraseña: document.getElementById('contraR').value
    };*/
    
    fetch(url, {
      method: 'POST', 
      body: JSON.stringify(datos), 
      headers:{
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
    console.log(JSON.stringify(datos))
    alert("espera un poco")
    //.then(response => console.log('Success:', response))
    //alert("espera un poco2")
    .catch(error => console.error('Error:', error));
    alert("Error espera un poco")

});

//-----------------------------------------------------------------

