package org.obisidiana.app.paso;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Filter {
    private List<String> materialesId;
    private List<String> tiposId;

    ///////////////////constructor/////////////////////
    public Filter() {
    }
///////////////////get and set/////////////////////


    public List<String> getMaterialesId() {
        return materialesId;
    }

    public void setMaterialesId(List<String> materialesId) {
        this.materialesId = materialesId;
    }

    public List<String> getTiposId() {
        return tiposId;
    }

    public void setTiposId(List<String> tiposId) {
        this.tiposId = tiposId;
    }
}
