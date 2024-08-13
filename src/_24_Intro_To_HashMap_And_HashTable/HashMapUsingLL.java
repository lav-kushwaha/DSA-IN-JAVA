package _24_Intro_To_HashMap_And_HashTable;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapFinal<K,V> {

    //ArrayList type "linked list" and LinkedList type "custom-type Entity".
    ArrayList<LinkedList<Entity>> list;
    private int size =0;
    private float lf = 0.5f;

    public HashMapFinal(){
        list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new LinkedList<>()); //added 10 empty linked list
        }
    }

    private class Entity{
        K key;
        V value;
        public Entity(K key,V value){
            this.key=key;
            this.value=value;
        }
    }

    public void put(K key,V value){

        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash); //get index from list.

        //we got the index now, search for entities.
        for(Entity entity : entities){
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }

        //load factor
        if((float)(size)/list.size()>lf){
            reHash();
        }

        entities.add(new Entity(key, value));
        size++;
    }

    private void reHash() {
        System.out.println("We are now rehashing!");

        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();
        size = 0;

        //doubling the size
        for(int i=0;i<old.size()*2;i++){
            list.add(new LinkedList<>());
        }

        //inserting old list item into new list
        for(LinkedList<Entity> entries : old){
           for(Entity entry:entries){
              put(entry.key, entry.value);
           }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode()%list.size());
        LinkedList<Entity> entities = list.get(hash);
        //we get the index of list, now search in the linked-list
        for(Entity entity: entities){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int hash = Math.abs(key.hashCode()%list.size());
        LinkedList<Entity> entities = list.get(hash);

        Entity target = null;
        for(Entity entity : entities){
            if(entity.key.equals(key)){
                target = entity;
                break;
            }
        }
        entities.remove(target);
        size--;
    }

    public boolean containsKey(K key){
        return get(key)!=null;
    }

    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("{");
        for (LinkedList<Entity> entities: list){
            for (Entity entity: entities){
                build.append(entity.key);
                build.append(" = ");
                build.append(entity.value);
                build.append(" , ");
            }
        }
        build.append("}");
        return build.toString();
    }

}
