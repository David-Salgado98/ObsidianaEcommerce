//Se crea una clase de tipo producto
console.log("Ya sirve el link al api de productos");
class Producto{
    
     constructor(currentId = 0) {
        this.productos = [];
        this.currentId = currentId;
    }
 
    //se crea el constructor y se le asigna un id que se actualiza automáticamente

    addProducto(nombre,imagen,descripcion,precio,tipoDeRoca,color,edadDelMineral){

        const producto = {
        id: this.currentId++,
        nombre:nombre,
        imagen: imagen,
        descripcion:descripcion,
        precio: precio,
        tipoDeRoca: tipoDeRoca,
        color:color,
        edadDelMineral: edadDelMineral,
        };

        this.productos.push(producto);

        localStorage.setItem("productos", JSON.stringify(this.productos));

    }

    loadItemsFromLocalStorage() {
        const storageItems = localStorage.getItem("productos")
        if (storageItems) {
            const items = JSON.parse(storageItems)
            for (var i = 0, size = items.length; i < size; i++) {
                const item = items[i];
                this.productos.push(item);
            }
        }
    }

 

}



