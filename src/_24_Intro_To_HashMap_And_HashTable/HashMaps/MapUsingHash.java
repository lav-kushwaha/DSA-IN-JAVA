package _24_Intro_To_HashMap_And_HashTable.HashMaps;

public class MapUsingHash {
    private Entity[] entities;

    public MapUsingHash(){
        entities = new Entity[100];// Initialize the array with a fixed size
    }

    private class Entity{
        String key;
        String value;

        public Entity(String key,String value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, String value){
     // Hash function to calculate the index for a given key
      int hash = Math.abs(key.hashCode() % entities.length);
      entities[hash] = new Entity(key,value); //overriding
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash]!=null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash]!=null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }
    }

    public static void main(String[] args) {
        MapUsingHash map = new MapUsingHash();
        map.put("mango","King of fruits");
        map.put("Lion","King of animal");
        map.put("peacock","Birds");

        map.remove("mango");

        System.out.println(map.get("mango"));

        System.out.println(map);
    }

}
