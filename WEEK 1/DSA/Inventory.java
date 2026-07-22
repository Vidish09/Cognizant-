package week_1.dsa;

// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
   private final Map<String, Product> products = new LinkedHashMap();

   public Inventory() {
   }

   public boolean addProduct(Product var1) {
      if (var1 == null) {
         System.out.println("Cannot add null product.");
         return false;
      } else if (this.products.containsKey(var1.getProductId())) {
         System.out.println("Product with ID " + var1.getProductId() + " already exists.");
         return false;
      } else {
         this.products.put(var1.getProductId(), var1);
         return true;
      }
   }

   public Product getProduct(String var1) {
      return (Product)this.products.get(var1);
   }

   public boolean updateProduct(String var1, String var2, Integer var3, Double var4) {
      Product var5 = (Product)this.products.get(var1);
      if (var5 == null) {
         System.out.println("Product with ID " + var1 + " does not exist.");
         return false;
      } else {
         if (var2 != null) {
            var5.setProductName(var2);
         }

         if (var3 != null) {
            var5.setQuantity(var3);
         }

         if (var4 != null) {
            var5.setPrice(var4);
         }

         return true;
      }
   }

   public boolean adjustQuantity(String var1, int var2) {
      Product var3 = (Product)this.products.get(var1);
      if (var3 == null) {
         System.out.println("Product with ID " + var1 + " does not exist.");
         return false;
      } else {
         int var4 = var3.getQuantity() + var2;
         if (var4 < 0) {
            System.out.println("Not enough stock for product ID " + var1 + ".");
            return false;
         } else {
            var3.setQuantity(var4);
            return true;
         }
      }
   }

   public List<Product> findLowStock(int var1) {
      ArrayList var2 = new ArrayList();

      for(Product var4 : this.products.values()) {
         if (var4.getQuantity() <= var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public boolean deleteProduct(String var1) {
      if (!this.products.containsKey(var1)) {
         System.out.println("Product with ID " + var1 + " does not exist.");
         return false;
      } else {
         this.products.remove(var1);
         return true;
      }
   }

   public List<Product> listAll() {
      return new ArrayList(this.products.values());
   }

   public int size() {
      return this.products.size();
   }
}

