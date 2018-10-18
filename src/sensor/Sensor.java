package sensor;

public interface Sensor {

    /**
     * @pre
     * @post
     */
    public double detect(String type);

    /**
     * @pre
     * @post
     */
    public void notifY();

    /**
     * @pre
     * @post
     */
    public double attach(Object o);

    /**
     * @pre
     * @post
     */
    public double detach(Object o);


}
