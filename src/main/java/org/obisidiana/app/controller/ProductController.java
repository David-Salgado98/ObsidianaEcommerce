package org.obisidiana.app.controller;

import org.obisidiana.app.entity.Product;
import org.obisidiana.app.paso.Filter;
import org.obisidiana.app.service.MaterialService;
import org.obisidiana.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

//@RequestMapping("/pages")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private MaterialService materialService;




    @GetMapping("pages/detalleProducto")
    public ResponseEntity<Product> procesar(@RequestParam Long id)
    {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @RequestMapping(value = "pages/filtrar" ,method = RequestMethod.GET)
    public ResponseEntity<List<Product>> filtrar(){
        Filter filter = new Filter();
        List<Product> productos = productService.listAllProduct();

        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }


        return ResponseEntity.ok(productos);
    }

    @PostMapping("pages/filtrar")
    public ResponseEntity<List<Product>> procesar(@RequestBody Filter filter, BindingResult result)
    {
        List<Product> productos;
        if(filter.getMaterialesId().isEmpty() && filter.getTiposId().isEmpty()){
            productos = productService.listAllProduct();
        }else{
            if(!(filter.getMaterialesId().isEmpty()) && !(filter.getTiposId().isEmpty())){
                List<String> tipos = filter.getTiposId();
                List<Long> largosT= tipos.stream().map(a->Long.valueOf(a)).collect(Collectors.toList());
                List<String> mates = filter.getMaterialesId();
                List<Long> largosM = mates.stream().map(a->Long.valueOf(a)).collect(Collectors.toList());

                productos = productService.findByTiposAndMateriales(largosM,largosT);
            }

            else if(filter.getMaterialesId().isEmpty()){
                System.out.println(filter.getTiposId().get(0));
                List<String> tipos = filter.getTiposId();
               List<Long> largos = tipos.stream().map(Long::valueOf).collect(Collectors.toList());
               //largos.forEach(System.out::println);

               /* Long id = Long.valueOf(filter.getMaterialesId().get(0));
                Material material = materialService.getMaterial(id);
                List<Long> matIds = new ArrayList<>();
                matIds.add(1L);
                matIds.add(2L);*/
                System.out.println(largos);
                productos = productService.findByTipos(largos);
            }else{

                System.out.println("materiales"+filter.getMaterialesId().get(0));
                List<String> mates = filter.getMaterialesId();
                List<Long> largos = mates.stream().map(a->Long.valueOf(a)).collect(Collectors.toList());
               // largos.forEach(System.out::println);
                System.out.println("materiales"+largos);
                productos = productService.findByMateriales(largos);
            }


        }








        return ResponseEntity.ok(productos);
    }




}
