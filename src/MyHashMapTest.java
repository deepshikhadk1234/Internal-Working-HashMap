public class MyHashMapTest {
    
    public static void main(String[] args) {
        testBasicOperations();
        testCollisionHandling();
        testCapacityManagement();
        testEdgeCases();
    }
    
    private static void testBasicOperations() {
        System.out.println("\n=== Testing Basic Operations ===");
        MyHashMap<Integer, String> map = new MyHashMap<>(4);
        
        // Test put and get
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        
        assert map.get(1).equals("one") : "Failed: get(1) should return 'one'";
        assert map.get(2).equals("two") : "Failed: get(2) should return 'two'";
        assert map.get(3).equals("three") : "Failed: get(3) should return 'three'";
        
        // Test size
        assert map.size() == 3 : "Failed: size should be 3";
        
        // Test capacity
        assert map.getCapacity() == 4 : "Failed: capacity should be 4";
        
        System.out.println("Basic operations test passed!");
    }
    
    private static void testCollisionHandling() {
        System.out.println("\n=== Testing Collision Handling ===");
        MyHashMap<Integer, String> map = new MyHashMap<>(2);
        
        // Force collisions by using keys that will hash to the same index
        map.put(1, "one");
        map.put(3, "three");  // Should collide with 1
        map.put(5, "five");   // Should collide with 1
        
        // Verify all values can be retrieved despite collisions
        assert map.get(1).equals("one") : "Failed: get(1) should return 'one'";
        assert map.get(3).equals("three") : "Failed: get(3) should return 'three'";
        assert map.get(5).equals("five") : "Failed: get(5) should return 'five'";
        
        // Print all entries at index 1 to verify chaining
        System.out.println("Entries at index 1 (should show all collided entries):");
        map.printAllEntriesAtIndex(1);
        
        System.out.println("Collision handling test passed!");
    }
    
    private static void testCapacityManagement() {
        System.out.println("\n=== Testing Capacity Management ===");
        
        // Test default capacity
        MyHashMap<Integer, String> defaultMap = new MyHashMap<>();
        assert defaultMap.getCapacity() == 16 : "Failed: default capacity should be 16";
        
        // Test custom capacity
        MyHashMap<Integer, String> customMap = new MyHashMap<>(8);
        assert customMap.getCapacity() == 8 : "Failed: custom capacity should be 8";
        
        // Test maximum capacity
        MyHashMap<Integer, String> largeMap = new MyHashMap<>(1 << 20);  // Using 2^20 instead of 2^31
        assert largeMap.getCapacity() == (1 << 20) : "Failed: capacity should be 2^20";
        
        System.out.println("Capacity management test passed!");
    }
    
    private static void testEdgeCases() {
        System.out.println("\n=== Testing Edge Cases ===");
        MyHashMap<Integer, String> map = new MyHashMap<>(4);
        
        // Test non-existent key
        assert map.get(999) == null : "Failed: get(non-existent key) should return null";
        
        // Test updating existing key
        map.put(1, "first");
        map.put(1, "second");
        assert map.get(1).equals("second") : "Failed: updating existing key should update value";
        
        // Test size after updates
        assert map.size() == 1 : "Failed: size should be 1 after updating existing key";
        
        // Test entries at empty index
        System.out.println("Testing empty index (should show 'No entries at index 2'):");
        map.printAllEntriesAtIndex(2);
        
        // Test invalid index
        System.out.println("Testing invalid index (should show 'Invalid index'):");
        map.printAllEntriesAtIndex(-1);
        
        System.out.println("Edge cases test passed!");
    }
} 