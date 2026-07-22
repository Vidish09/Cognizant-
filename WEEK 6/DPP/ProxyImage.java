interface Image {
    void display();
}

/**
 * Proxy: stands in for RealImage. Delays creating (and thus loading) the
 * RealImage until display() is first called (lazy initialization), then
 * caches that instance so subsequent display() calls skip the remote
 * load entirely.
 */
public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage; // null until first needed — this IS the cache

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        // Note: no loading happens here. Constructing a ProxyImage is cheap.
    }

    public void display() {
        if (realImage == null) {
            // First call: pay the real cost once, then cache the result.
            realImage = new RealImage(fileName);
        } else {
            // Subsequent calls: reuse the cached, already-loaded image.
            System.out.println("Using cached image for \"" + fileName + "\" (no reload).");
        }
        realImage.display();
    }

    /**
     * The real image implementation is kept here so this source file can be
     * compiled independently when no separate RealImage.java is available.
     */
    private static class RealImage implements Image {
        private final String fileName;

        RealImage(String fileName) {
            this.fileName = fileName;
            System.out.println("Loading image: " + fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }
}