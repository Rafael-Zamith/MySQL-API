package br.mack.ps2.persistencia;

import br.mack.ps2.Pais;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaisDAOMySQL implements PaisDAO {
    private String table = "paises";
    private String createSQL = "INSERT INTO " + table + " VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM " + table;
    private String updateSQL = "UPDATE " + table + " SET pais=?, continente=?, populacao=?, WHERE id=?";
    private String deleteSQL = "DELETE FROM " + table + "WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();

    public boolean create(Pais pais){
        Connection conn = mysql.getConnection();
        try{
            PreparedStatement stm = conn.prepareStatement(createSQL);

            stm.setInt(1, pais.getId());
            stm.setString(2, pais.getNome());
            stm.setString(3, pais.getContinente());
            stm.setDouble(4, pais.getPopulação());

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        }catch (final SQLException e){
            System.out.println("Falha na conexão com a base de dados!");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<Pais> read(){
        Connection conn = mysql.getConnection();
        List<Pais> paises = new ArrayList();

        try {
            PreparedStatement stm = conn.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                Pais pais = new Pais();
                pais.setId(rs.getInt("id"));
                pais.setNome(rs.getString("nome"));
                pais.setContinente(rs.getString("continente"));
                pais.setPopulacao(rs.getDouble("populacao"));
                paises.add(pais);
            }
            return paises;

        }catch (final SQLException e){
            System.out.println("Falha na conexão com a base de dados!");
            e.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (final Exception e){
                e.printStackTrace();
            }
        }
        return paises;
    }

    public boolean update(Pais pais){
        Connection conn = mysql.getConnection();

        try{
            PreparedStatement stm = conn.prepareStatement(updateSQL);

            stm.setString(1, pais.getNome());
            stm.setString(2, pais.getContinente());
            stm.setDouble(3, pais.getPopulação());
            stm.setInt(4, pais.getId());

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        }catch (final SQLException e){
            System.out.println("Falha na conexão com a base de dados!");
            e.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(Pais pais){
        Connection conn = mysql.getConnection();
        try{
            PreparedStatement stm = conn.prepareStatement(deleteSQL);

            stm.setInt(1, pais.getId());

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        }catch (final SQLException e){
            System.out.println("Falha na conexão com a base de dados!");
            e.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (final Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
