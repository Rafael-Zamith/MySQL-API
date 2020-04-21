package br.mack.ps2.persistencia;

import java.util.List;

import br.mack.ps2.Computador;

public interface ComputadorDAO {

    boolean create(Computador computador);

    List<Computador> read();

    boolean update(Computador computador);

    boolean delete(Computador computador);

}