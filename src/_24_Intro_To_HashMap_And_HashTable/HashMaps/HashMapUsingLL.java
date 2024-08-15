package _24_Intro_To_HashMap_And_HashTable.HashMaps;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapUsingLL<K, V> {

    // ArrayList type "linked list" and LinkedList type "custom-type Entity".
    private ArrayList<LinkedList<Entity>> list;
    private int size = 0;
    private float lf;

    public HashMapUsingLL() {
        this(10, 0.5f);
    }

    public HashMapUsingLL(int initialCapacity, float loadFactor) {
        list = new ArrayList<>();
        for (int i = 0; i < initialCapacity; i++) {
            list.add(new LinkedList<>()); // Added 10 empty linked lists
        }
        this.lf = loadFactor;
    }

    private class Entity {
        K key;
        V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int hash = getHash(key);
        LinkedList<Entity> entities = list.get(hash);//get the index from ArrayList and that index refer to LinkedList.

        // Search for the entity to update its value
        for (Entity entity : entities) {
            //check provided key is present or not inside the entity if yes then update the value.
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }

        // Load factor check before adding a new entity
        //size + 1 is what the map’s size would be after adding the new element.
        //size is the number of elements currently in the map.
        if ((float) (size + 1) / list.size() > lf) {
            reHash();
            hash = getHash(key); // Recalculate hash since list size changed
            entities = list.get(hash);
        }

        //if key is not found then add that key,vaue.
        entities.add(new Entity(key, value));
        size++;
    }

    private void reHash() {
        System.out.println("We are now rehashing!");

        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();
        size = 0;

        // Doubling the size
        for (int i = 0; i < old.size() * 2; i++) {
            list.add(new LinkedList<>());
        }

        // Inserting old list items into new list
        for (LinkedList<Entity> entries : old) {
            for (Entity entry : entries) {
                put(entry.key, entry.value);
            }
        }
    }

    public V get(K key) {
        int hash = getHash(key);
        LinkedList<Entity> entities = list.get(hash);

        // Search in the linked-list
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                return entity.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        Entity target = null;

        for(Entity entity : entities) {
            if(entity.key.equals(key)) {
                target = entity;
                break;
            }
        }

        entities.remove(target);
        size--;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return list.size();
    }

    public void clear() {
        list.clear();
        size = 0;
        for (int i = 0; i < capacity(); i++) {
            list.add(new LinkedList<>());
        }
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("{");
        boolean first = true;
        for (LinkedList<Entity> entities : list) {
            for (Entity entity : entities) {
                if (!first) {
                    build.append(", ");
                }
                build.append(entity.key);
                build.append(" = ");
                build.append(entity.value);
                first = false;
            }
        }
        build.append("}");
        return build.toString();
    }

    private int getHash(K key) {
        if (key == null) {
            return 0;
        }
        return (key.hashCode() & 0x7fffffff) % list.size(); //The constant 0x7fffffff in the hash function is used to ensure that the hash code is positive.
    }

    public static void main(String[] args) {
        HashMapUsingLL<String, String> map = new HashMapUsingLL<>();
        map.put("mango", "King of fruits");
        map.put("Lion", "King of animals");
        map.put("peacock", "Birds");

        System.out.println(map.get("mango"));
        System.out.println(map);
    }
}
