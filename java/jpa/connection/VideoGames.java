/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.sql.rowset.CachedRowSet;
import jsf.games.VideoGamesController;

@ManagedBean(name = "VideoGames")
public class VideoGames {

//    @Resource(name = "jdbc/games")
//    DataSource dataSource;

    // instance variables
    private Integer GameID;
    private String GameName;
    private String YearReleased;
    private String Developer;

    public VideoGames() {
    }

 public Integer getGameID() {
        return GameID;
        
    }
    
    public void setGameID() {
        this.GameID = GameID;
    }
    
    public String getGameName() {
        return GameName;
    }
    
    public void setGameName() {
        this.GameName = GameName;
    }
    
    public String setYearReleased() {
        return YearReleased;
    }
    
    public void getYearReleased() {
        this.YearReleased = YearReleased;
    }
    
    public String setDeveloper() {
        return Developer;
    }
    
    public void getDeveloper() {
        this.Developer = Developer;
    }

    /**
     *
     * @return
     */
    public int GameID() {
        //this is to get the running intstance of the session bean PublishersController object
        ExternalContext tmpEC;
        Map sMap;
        tmpEC = FacesContext.getCurrentInstance().getExternalContext();
        sMap = tmpEC.getSessionMap();
        VideoGamesController currentPublishersControllerInstance = (VideoGamesController) sMap.get("VideoGamesController");

        //get the selected publisherID from the "master" page List.xhtml of the publishers
        return currentPublishersControllerInstance.getSelected().getGameID();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    //this is to get the titles by a publisher ID
    // return a ResultSet of entities
    // allow the server to inject the DataSource
    public ResultSet getVideoGames() throws SQLException {

        String URL = "jdbc:derby://localhost:1527/games";
        String USERNAME = "IVAN";
        String PASSWORD = "UZUNOV";
        Connection connection = null; // manages connection 

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String queryString = "SELECT Video Games.Game ID, Video Games.Game Name, Video Games.Year Released, Video Games.Developer" + this.getGameID();

            PreparedStatement getVideoGames = connection.prepareStatement(queryString);

            CachedRowSet rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(getVideoGames.executeQuery());
            return rowSet;

        } // end try
        finally {
            connection.close(); // return this connection to pool
        } // end finally
    } // end method 

    public Boolean rowSetNotEmpty() throws SQLException {
        return getVideoGames().first();
    }

}