# Custom HashMap Implementation

This project implements a custom HashMap data structure in Java, demonstrating the internal workings of how a HashMap functions. This implementation includes basic HashMap operations and collision handling using chaining.

## Features

- Custom HashMap implementation with generic key-value pairs
- Collision handling using chaining (linked list)
- Dynamic capacity management
- Basic HashMap operations:
  - put(key, value)
  - get(key)
  - size()
  - getCapacity()
- Utility methods to inspect internal state:
  - getEntryAtIndex(index)
  - printAllEntriesAtIndex(index)

## Implementation Details

- Default capacity: 16
- Maximum capacity: 2^30
- Collision resolution: Chaining (using linked list)
- Hash function: key.hashCode() % table.length

## Usage Example

```java
MyHashMap<Integer, String> map = new MyHashMap<>(5);
map.put(1, "hi");
map.put(2, "my");
map.put(3, "name");

// Get value
String value = map.get(1);  // returns "hi"

// Get size
int size = map.size();      // returns number of key-value pairs

// Get capacity
int capacity = map.getCapacity();  // returns the size of the underlying array

// Print entries at specific index
map.printAllEntriesAtIndex(2);     // prints all entries at index 2
```

## Test Cases

The project includes comprehensive test cases covering:
1. Basic operations (put/get)
2. Collision handling
3. Capacity management
4. Edge cases
5. Null handling

To run the tests, execute the main method in `MyHashMap.java`.

## Performance Considerations

- Time Complexity:
  - Average case: O(1) for put and get operations
  - Worst case: O(n) when many collisions occur
- Space Complexity: O(n) where n is the number of key-value pairs

## Limitations

1. No automatic resizing (fixed capacity)
2. No load factor management
3. No concurrent access support
4. No key or value null handling

## Future Improvements

1. Implement automatic resizing
2. Add load factor management
3. Add concurrent access support
4. Implement proper null handling
5. Add more utility methods (clear, remove, etc.) 