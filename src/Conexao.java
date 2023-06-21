import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) throws SQLException {
        Connection conexao = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_lutas","root","");
            ResultSet rsClient = conexao.createStatement().executeQuery("SELECT * FROM tb_eventos");
            while (rsClient.next()){
                System.out.println("Nome parceiro: " + rsClient.getString("nome_evento"));
            }
        }catch (ClassNotFoundException ex){
            System.out.println("Driver do BD não localizado");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco " + e.getMessage());
        }finally {
            if(conexao != null) {
                conexao.close();
            }

        }
    }
}
