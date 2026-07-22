

public class Main {
    public static void main(String[] args) {

        
        Computer officeComputer = new Computer.Builder("Intel i3", "8GB", "256GB SSD")
                .build();

        Computer gamingPC = new Computer.Builder("Intel i9", "32GB", "2TB NVMe SSD")
                .gpu("NVIDIA RTX 4090")
                .motherboard("ASUS ROG Strix Z790")
                .powerSupply("850W Gold Certified")
                .wifi(true)
                .bluetooth(true)
                .coolingSystem("Liquid Cooling")
                .build();

       
        Computer budgetPC = new Computer.Builder("AMD Ryzen 5", "16GB", "512GB SSD")
                .wifi(true)
                .build();

        System.out.println("=== Office Computer ===");
        System.out.println(officeComputer);

        System.out.println("\n=== Gaming PC ===");
        System.out.println(gamingPC);

        System.out.println("\n=== Budget PC ===");
        System.out.println(budgetPC);
    }
}
