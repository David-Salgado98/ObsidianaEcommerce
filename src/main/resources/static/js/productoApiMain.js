// Initialize a new TaskManager with currentId set to 0
const productosControllador = new Producto(0);

// Select the New Task Form
const newItemForm = document.querySelector('#newItemForm');

// Add an 'onsubmit' event listener
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();

    // Select the inputs
    const newItemNameInput = document.querySelector('#newItemNameInput');
    const newItemImage = document.querySelector('#newItemImage');
    const newItemDescripcion = document.querySelector('#newItemDescripcion');
    const newItemPrecio = document.querySelector('#newItemPrecio');
    const newItemTipoRoca = document.querySelector('#newItemTipoRoca');
    const newItemColor = document.querySelector('#newItemColor');
    const newItemEdadMineral = document.querySelector('#newItemEdadMineral');

    /*
        Validation code here
    */

    // Get the values of the inputs
    const name = newItemNameInput.value;
    const imagenUrl = newItemImage.value;
    const descripcion = newItemDescripcion.value;
    const precio = newItemPrecio.value;
    const tipoRoca = newItemTipoRoca.value;
    const color = newItemColor.value;
    const edadDelMineral = newItemEdadMineral.value;

    const createdAt = new Date();

    productosControllador.addProducto(name, imagenUrl, descripcion, precio, tipoRoca,color,edadDelMineral);
    /* // Clear the form
    newItemNameInput.value = '';
    newItemDescription.value = ''; */
    console.log(productosControllador);

    //loadCardsListFromItemsController();
    loadProductsFromLocalStorage();

});


function loadProductsFromLocalStorage(){
    const storageProducts = localStorage.getItem("productos");
    if (storageProducts) {
        const productos = JSON.parse(storageProducts);
      console.log(productos);
       const divContainer = document.getElementsByClassName('card'); 
       console.log(divContainer);

        document.querySelectorAll(".card").forEach(el => el.remove());
    
        console.log("traido del localstorage");
        productos.forEach(producto => {
            addItemCard(producto);
        });
   
   
    }
}
function loadCardsListFromItemsController(){
    for(var i = 0, size = productosControllador.productos.length; i < size ; i++){
        const producto = productosControllador.productos[i];
        addItemCard(producto);
        console.log("debe recorrer el arreglo");
    } 
}

  function addItemCard(producto) {
    const itemHTML = '<div class="card" id="cards" style="width: 18rem;">\n' +
        '    <img src="" class="card-img-top" alt="image">\n' +
        '    <div class="card-body">\n' +
        '        <h5 class="card-title">'+producto.imagen+'</h5>\n' +
        '        <p class="card-text">'+producto.nombre+'</p>\n' +
        '        <a href="#" class="btn btn-primary">Add</a>\n' +
        '    </div>\n' +
        '</div>\n';
    const productosControllador = document.getElementById("list-items");
    productosControllador.innerHTML += itemHTML;
} 

/* function addCarouselItem(producto) {
    const itemHTML = '<div class="carousel-item">\n' +
        '    <img class="products" src='+producto.imagen+' class="d-block w-100" alt="...">\n' +
        '    <div class="carousel-caption d-none d-md-block">\n' +
        '        <h4>'+producto.nombre+'</h4>\n' +
        '        <h5>'+producto.precio+'</h5>\n' +
        '        </div>\n' +
        '    </div>\n';

    const productosControllador = document.getElementById("carouselContainner");
    productosControllador.innerHTML += itemHTML;
}
 */
function deleteCard(){
    $('.card').remove();
}
