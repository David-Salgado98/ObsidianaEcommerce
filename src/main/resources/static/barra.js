document.addEventListener('DOMContentLoaded',function(){
  agregarEncabezado();
});

function agregarEncabezado(){
  

        //link.href = 'http://fonts.googleapis.com/css?family=Oswald&effect=neon';
        
        let link2 = document.createElement('link');
        
        link2.rel = 'stylesheet';
        link2.href =  href="../css/normalize.css"
        document.head.appendChild(link2);
        let link3 = document.createElement('link');
       
        link3.rel = 'preconnect';
        link3.href =  href="https://fonts.googleapis.com"
        document.head.appendChild(link3);

        let link4 = document.createElement('link');
        
        link4.rel = 'stylesheet';
        link4.href =  href="https://fonts.googleapis.com/css2?family=Suez+One&display=swa";
        document.head.appendChild(link4);

        let link = document.createElement('link');
        link.type = 'text/css';
        link.rel = 'stylesheet';
        link.href =  href="../css/barra.css"
        document.head.appendChild(link);

        let script2= document.createElement('script');
        
        script2.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js';
        document.body.appendChild(script2);

        let script = document.createElement('script');
        
        script.src = '../js/bar.js';
        document.body.appendChild(script);

        

        

        

      
  let nav = document.querySelector('header')
    nav.innerHTML = `
   
    <section class="navigation">
                <div class="nav-container">
                  <div class="brand">
                     <a th:href="@{/index}" class=".nav-centrado logo-cont"><img src="https://res.cloudinary.com/dzham2sp8/image/upload/v1676485585/barra/logo_obsidiana_sin_letras_cj9zvx.png" alt="" class="logo"></a>
                  </div>
                  <nav>
                    <div class="nav-mobile"><a id="nav-toggle" href="#!"><span></span></a></div>
                    <ul class="nav-list">
                      <li>
                        <a th:href="@{/index}">Home</a>
                      </li>
                      <li>
                        <a href="#!">Servicios</a>
                        <ul class="nav-dropdown">
                          <li>
                            <a href="#!">Todos los Productos</a>
                          </li>
                          <li>
                            <a href="./tuPiedra.html">Piedra de Nacimiento</a>
                          </li>
                          <li>
                            <a href="./aboutus.html">Nosotros</a>
                          </li>
                          
                          <li>
                            <a href="./contacto.html">Contacto</a>
                          </li>
                        </ul>
                      </li>
                      <li class="li-encuentra">
                        <div class="parteD nav-centrado">
                            <div class="encuentra">
                                <a href="./findYourRock.html" class="visitado .nav-centrado">¡Encuentra tu piedra!</a>
                            </div>
                        </div>
                      </li>
                      <li>
                      <a href="./catalogo.html">Catálogo</a>
                    </li>
                     
                      <li class="li-iconos">
                        <div class="parteE nav-centrado">
                            <div class="iconos">
                                <a href="##"><img src="https://res.cloudinary.com/dzham2sp8/image/upload/v1675874139/barra/carrito_wbkn0j.svg" alt="" class="icono iconoA"></a>
                                <a href="#"><img src="https://res.cloudinary.com/dzham2sp8/image/upload/v1675874139/barra/insta_s625xj.svg" alt="" class="icono iconoB"></a>
                                     <div class="iconoC iconoCBarra">
                                        <img src="https://res.cloudinary.com/dzham2sp8/image/upload/v1675874139/barra/search_vyjo8i.svg" alt="" class=""><input type="text" class="iconoC" size="1">
                                    </div>
                                <a href="./login.html"><img src="https://res.cloudinary.com/dzham2sp8/image/upload/v1675874139/barra/login_e3b87g.svg" alt="" class="icono iconoD"></a>
                                
                            </div>
                      </li>
                      
                        <li>
                            <a href="./findYourRock.html" class="parteF">¡Encuentra tu piedra!</a>
                          </li>
                      
                        <li>
                            <a href="./contacto.html" class="parteF">Contacto</a>
                          </li>
                      
                     
                    </ul>
                  </nav>
                </div>
              </section>
              <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
      <script src="./js/bar.js"></script>
              `
}
