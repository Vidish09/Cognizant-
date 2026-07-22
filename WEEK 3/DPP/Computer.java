

public class Computer {
   
    private final String cpu;
    private final String ram;
    private final String storage;

    
    private final String gpu;
    private final String motherboard;
    private final String powerSupply;
    private final boolean hasWifi;
    private final boolean hasBluetooth;
    private final String coolingSystem;

    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.motherboard = builder.motherboard;
        this.powerSupply = builder.powerSupply;
        this.hasWifi = builder.hasWifi;
        this.hasBluetooth = builder.hasBluetooth;
        this.coolingSystem = builder.coolingSystem;
    }

    @Override
    public String toString() {
        return """
               Computer Configuration:
                 CPU: """ + cpu + "\n" +
               "  RAM: " + ram + "\n" +
               "  Storage: " + storage + "\n" +
               "  GPU: " + (gpu != null ? gpu : "Integrated Graphics") + "\n" +
               "  Motherboard: " + (motherboard != null ? motherboard : "Standard") + "\n" +
               "  Power Supply: " + (powerSupply != null ? powerSupply : "Standard 450W") + "\n" +
               "  WiFi: " + (hasWifi ? "Yes" : "No") + "\n" +
               "  Bluetooth: " + (hasBluetooth ? "Yes" : "No") + "\n" +
               "  Cooling System: " + (coolingSystem != null ? coolingSystem : "Stock Cooler");
    }

    
    public static class Builder {
        // Required attributes
        private final String cpu;
        private final String ram;
        private final String storage;

        // Optional attributes â€” default values
        private String gpu;
        private String motherboard;
        private String powerSupply;
        private boolean hasWifi = false;
        private boolean hasBluetooth = false;
        private String coolingSystem;

        
        public Builder(String cpu, String ram, String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this; // return Builder for chaining
        }

        public Builder motherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder powerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder wifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Builder bluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Builder coolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        
        public Computer build() {
            return new Computer(this);
        }
    }
}
