package framework.core.driver;

import org.openqa.selenium.Dimension;

public interface ViewPort {

    // Standard ViewPorts
    Dimension VGA = new Dimension(800, 600);
    Dimension SHD = new Dimension(1800, 720);
    Dimension FHD = new Dimension(1920, 1080);
    Dimension UHD = new Dimension(3120,2146);

}
