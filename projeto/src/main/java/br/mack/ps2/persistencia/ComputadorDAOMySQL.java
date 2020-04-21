package br.mack.ps2.persistencia;


import java.sql.*;
import java.util.*;


import br.mack.ps2.Computador;


public class ComputadorDAOMySQL implements ComputadorDAO {
    private String table = "computadores";
    private String createSQL = "INSERT INTO " + table + " VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM " + table;
    private String updateSQL = "UPDATE " + table + " SET marca =?, processador=?, RAM=?, tamDisco=? WHERE id=? ";
    private String deleteSQL = "DELETE FROM " + table + " WHERE id=?";

    private final MySQLConnection1 mysql = new MySQLConnection1();

    @Override
    public boolean create(Computador computador) {
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement stm = conn.prepareStatement(createSQL);

            stm.setInt(1, computador.getId());  
            stm.setString(2, computador.getMarca());
            stm.setInt(3, computador.getProcessador()); 
            stm.setInt(4, computador.getRAM());
            stm.setInt(5, computador.getDiskSize());


            int reg = stm.executeUpdate();

            return reg > 0;

        } catch (final SQLException e) {
            System.out.println("Falha na conexão com a base de dados!");
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Computador> read() {
        Connection conn = mysql.getConnection();
        List<Computador> computadores = new ArrayList();
        try {
            PreparedStatement stm = conn.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Computador computador = new Computador();
                computador.setId(rs.getInt("id"));
                computador.setMarca(rs.getString("marca"));
                computador.setProcessador(rs.getInt("processador"));
                computador.setRAM(rs.getInt("RAM"));
                computador.setDiskSize(rs.getInt("tamDisco"));
                computadores.add(computador);
            }
            return computadores;

        } catch (final SQLException e) {
            System.out.println("Falha na conexão com a base de dados!");
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return computadores;
    }

    @Override
    public boolean update(Computador computador) {
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement stm = conn.prepareStatement(updateSQL);

            stm.setInt(5, computador.getId());
            stm.setString(1, computador.getMarca());
            stm.setInt(2, computador.getProcessador());
            stm.setInt(3, computador.getRAM());
            stm.setInt(4, computador.getDiskSize());

            int reg = stm.executeUpdate();

            return reg > 0;

        } catch (final SQLException e) {
            System.out.println("Falha na conexão com a base de dados!");
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
        
    }

    @Override
    public boolean delete(Computador computador) {
        
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement stm = conn.prepareStatement(deleteSQL);

            stm.setInt(1, computador.getId());

            int reg = stm.executeUpdate();

            return reg > 0;

        } catch (final SQLException e) {
            System.out.println("Falha na conexão com a base de dados!");
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}