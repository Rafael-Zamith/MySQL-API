package br.mack.ps2.persistencia;

import br.mack.ps2.Pais;
import java.util.List;

public interface PaisDAO {
    boolean create (Pais pais);

    List<Pais> read();

    boolean update(Pais pais);

    boolean delete(Pais pais);
}
