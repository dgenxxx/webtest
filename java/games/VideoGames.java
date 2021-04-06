package games;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Uzi
 */
@Entity
@Table(name = "Video Games")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Video Games.findAll", query = "SELECT a FROM VideoGames a"),
    @NamedQuery(name = "Video Games.findByGameID", query = "SELECT a FROM VideoGames a WHERE a.GameID = :GameID"),
    @NamedQuery(name = "Video Games.findByGameName", query = "SELECT a FROM VideoGames a WHERE a.GameName = :GameName"),
    @NamedQuery(name = "Video Games.findByYearReleased", query = "SELECT a FROM VideoGames a WHERE a.YearReleased = :YearReleased"),
    @NamedQuery(name = "Video Games.findByDeveloper", query = "SELECT a FROM VideoGames a WHERE a.Developer = :Developer")})
public class VideoGames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "GameID")
    private Integer GameID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GameName")
    private String GameName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "YearReleased")
    private String YearReleased;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Developer")
    private String Developer;

    public VideoGames() {
        
    }
    
    public VideoGames(Integer GameID) {
        this.GameID = GameID;
    }
    
    public VideoGames(Integer GameID, String GameName, String YearReleased, String Developer) {
        this.GameID = GameID;
        this.GameName = GameName;
        this.YearReleased = YearReleased;
        this.Developer = Developer;
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

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (GameID != null ? GameID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VideoGames)) {
            return false;
        }
        VideoGames other = (VideoGames) object;
        if ((this.GameID == null && other.GameID != null) || (this.GameID != null && !this.GameID.equals(other.GameID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "games.VideoGames[ id=" + GameID + " ]";
    }
    
}
