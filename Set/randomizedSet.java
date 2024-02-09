class RandomizedSet {
    //380. Insert Delete GetRandom O(1)
    // Remove method may take O(n), while remove last element takes O(1)
    private HashSet<Integer> elementSet;
    private ArrayList<Integer> elements;
    private Random random;

    public RandomizedSet() {
        elementSet = new HashSet<>();
        elements = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (elementSet.contains(val)) {
            // Element already exists in the set
            return false;
        }

        // Add the element to the HashSet and ArrayList
        elementSet.add(val);
        elements.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!elementSet.contains(val)) {
            // Element does not exist in the set
            return false;
        }

        // Remove the element from the HashSet
        elementSet.remove(val);

        // Remove the element from the ArrayList
        elements.remove(Integer.valueOf(val));

        return true;
    }

    public int getRandom() {
        // Generate a random index and return the corresponding element
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }
    
}

// Betetr approach?



// class RandomizedSet {
//     private ArrayList<Integer> elements;
//     private HashMap<Integer, Integer> elementToIndex;
//     private Random random;

//     public RandomizedSet() {
//         elements = new ArrayList<>();
//         elementToIndex = new HashMap<>();
//         random = new Random();
//     }

//     public boolean insert(int val) {
//         if (elementToIndex.containsKey(val)) {
//             // Element already exists in the set
//             return false;
//         }

//         // Add the element to the end of the array
//         elements.add(val);

//         // Update the hash map with the element's index in the array
//         elementToIndex.put(val, elements.size() - 1);

//         return true;
//     }

//     public boolean remove(int val) {
//         if (!elementToIndex.containsKey(val)) {
//             // Element does not exist in the set
//             return false;
//         }

//         // Swap the element with the last element in the array
//         int indexToRemove = elementToIndex.get(val);
//         int lastElement = elements.get(elements.size() - 1);
//         elements.set(indexToRemove, lastElement);
//         elementToIndex.put(lastElement, indexToRemove);

//         // Remove the last element and update the hash map
//         elements.remove(elements.size() - 1);
//         elementToIndex.remove(val);

//         return true;
//     }

//     public int getRandom() {
//         // Generate a random index and return the corresponding element
//         int randomIndex = random.nextInt(elements.size());
//         return elements.get(randomIndex);
//     }
// }
