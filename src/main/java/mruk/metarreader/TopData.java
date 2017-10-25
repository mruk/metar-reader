package mruk.metarreader;

/**
 * Top level JSON container
 *
 */
public class TopData {

  private final System system;
  private DecodedMetar datagram;
  private final double version;

  public TopData() {
    this.system = new System();
    this.datagram = new DecodedMetar();
    this.version = 0.1025;
  }

  void setDatagram(DecodedMetar datagram) {
    this.datagram = datagram;
  }

  public System getSystemInfo() {
    return system;
  }

  public DecodedMetar getDatagram() {
    return datagram;
  }

  public double getVer() {
    return version;
  }

  /**
   * Class contains more or less basic infos used as log/debug.
   *
   * @param
   */
  public class System{
    private final String name = "sys";

    public String getName() {
      return name;
    }
  }
}
