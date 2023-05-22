package org.obisidiana.app.repository;

import org.obisidiana.app.entity.Confirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ConfirmRepository extends CrudRepository<Confirm,Long> {
    public Confirm findByClientesId(Long clientesId);
}
