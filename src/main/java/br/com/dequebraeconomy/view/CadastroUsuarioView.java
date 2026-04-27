package br.com.dequebraeconomy.view;

import br.com.dequebraeconomy.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
//ds_email            VARCHAR2(100)   NOT NULL,
//senha_usuario       VARCHAR2(50)    NOT NULL,
//nm_usuario          VARCHAR (100)   NOT NULL,
//dt_nascimento
public class CadastroUsuarioView {
    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            Statement stm = conexao.createStatement();
            stm.executeUpdate("INSERT INTO  T_USUARIO (ds_email, senha_usuario, nm_usuario, dt_nascimento) " +
                    "   values ('contato#email.com', '755075','Nicolas', '27/09/1994')");
            System.out.println("Usuário cadastrado");
            stm.close();
            conexao.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
