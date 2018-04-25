import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Building Simulator
 * Creates a building with given levels and elevators
 */
public class Building {

    /// \#Levels of this building
    private int levels;
    /// \#Elevators of this building
    private int elevators;
    /// Note for each elevator in this building
    public Vector<Elevator> elevatorList;
    /// Note for persons waiting for elevators in each level
    private Vector< Vector<Passenger> > levelList;
    /// A message center noting for events;
    public Vector<Message> messageCenter;
    /// A lock used to help lock levelList
    private ReentrantLock lock;

    /**
     * Creates a building
     * @param levs \#levels in ths building
     * @param elevs \#elevators in this building
     * @param maxPass max \# of passengers an elevator can contain
     */
    public Building(int levs, int elevs, int maxPass){
        this.levels = levs;
        this.elevators = elevs;
        this.elevatorList = new Vector<>();
        this.levelList = new Vector<>();
        this.messageCenter = new Vector<>();
        this.lock = new ReentrantLock();
        for (int i = 1; i <= this.elevators; ++i){
            Elevator tmp = new Elevator(i, this.levels, maxPass, this.levelList, this.messageCenter, this.lock);
            tmp.start();
            this.elevatorList.add(tmp);
        }
        for (int i = 0; i <= levs; ++i){
            this.levelList.add(new Vector<>());
        }
    }

    public synchronized boolean addPassenger(int lev, Passenger pass){
        if (lev < 0 || lev > this.levels + 1){
            return false;
        }
        else {
            this.levelList.get(lev).add(pass);
            return true;
        }
    }
}