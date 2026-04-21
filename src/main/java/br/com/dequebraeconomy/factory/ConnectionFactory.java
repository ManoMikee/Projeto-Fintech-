package br.com.dequebraeconomy.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USER = "RM566918";
    private static final String PASSWORD = "270994";


    // MÉTODO PARA OBTER UMA CONEXÃO COMO BANCO DE DADOS

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
