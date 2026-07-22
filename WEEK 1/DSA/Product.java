package week_1.dsa;

// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class Product {
   private String productId;
   private String productName;
   private int quantity;
   private double price;

   public Product(String var1, String var2, int var3, double var4) {
      this.productId = var1;
      this.productName = var2;
      this.quantity = var3;
      this.price = var4;
   }

   public String getProductId() {
      return this.productId;
   }

   public String getProductName() {
      return this.productName;
   }

   public void setProductName(String var1) {
      this.productName = var1;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public void setQuantity(int var1) {
      this.quantity = var1;
   }

   public double getPrice() {
      return this.price;
   }

   public void setPrice(double var1) {
      this.price = var1;
   }

   public String toString() {
      return String.format("ID: %-8s | Name: %-20s | Qty: %-6d | Price: $%.2f", this.productId, this.productName, this.quantity, this.price);
   }
}

