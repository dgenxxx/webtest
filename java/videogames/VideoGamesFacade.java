package videogames;

import games.VideoGames;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Uzi
 */
@Stateless
public class VideoGamesFacade extends AbstractFacade<VideoGames> {
    @PersistenceContext(unitName = "Ivan's App")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VideoGamesFacade() {
        super(VideoGames.class);
    }

    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}