package br.mack.ps2.persistencia;


import java.sql.*;
import java.util.*;


import br.mack.ps2.Conta;


public class ContaDAOMySQL implements ContaDAO {
    private String table = "contas";
    private String createSQL = "INSERT INTO " + table + " VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM " + table;
    private String updateSQL = "UPDATE " + table + " SET nome =?, agencia=?, saldo=? WHERE id=? ";
    private String deleteSQL = "DELETE FROM " + table + " WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Conta conta) {
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement stm = conn.prepareStatement(createSQL);

            stm.setInt(1, conta.getId());  
            stm.setString(2, conta.getNome());
            stm.setInt(3, conta.getAgencia()); 
            stm.setBigDecimal(4, conta.getSaldo());


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
    public List<Conta> read() {
        Connection conn = mysql.getConnection();
        List<Conta> contas = new ArrayList();
        try {
            PreparedStatement stm = conn.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setNome(rs.getString("nome"));
                conta.setAgencia(rs.getInt("agencia"));
                conta.setSaldo(rs.getBigDecimal("saldo"));
                contas.add(conta);
            }
            return contas;

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
        return contas;
    }

    @Override
    public boolean update(Conta conta) {
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement stm = conn.prepareStatement(updateSQL);

            stm.setInt(4, conta.getId());
            stm.setString(1, conta.getNome());
            stm.setInt(2, conta.getAgencia());
            stm.setBigDecimal(3, conta.getSaldo());

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
    public boolean delete(Conta conta) {
        
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement stm = conn.prepareStatement(deleteSQL);

            stm.setInt(1, conta.getId());

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