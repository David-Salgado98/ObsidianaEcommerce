package org.obisidiana.app.repository;

import org.obisidiana.app.entity.Material;
import org.obisidiana.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByMaterial(Material material);

    @Query(value = "SELECT * FROM productos WHERE mat_id in :mids", nativeQuery = true)
    List<Product> findByMat(@Param("mids") List<Long> matIds);

    @Query(value = "SELECT * FROM productos WHERE  typ_id in :tids", nativeQuery = true)
    List<Product> findByTyp(@Param("tids")List<Long> typIds);

    @Query(value = "SELECT * FROM productos WHERE mat_id in :mids and typ_id in :tids", nativeQuery = true)
    List<Product> findByMatAndTyp(@Param("mids") List<Long> matIds,@Param("tids")List<Long> typIds);
}
