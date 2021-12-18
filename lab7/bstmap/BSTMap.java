package bstmap;

import com.sun.jdi.Value;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.security.Key;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;
        public  Node(K key, V val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }

    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key){
        return containsKey(root,key);

    }
    private boolean containsKey(Node node, K key){
        if (node == null){
            return false;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return containsKey(node.left, key);
        }
        else if(cmp > 0){
            return containsKey(node.right, key);
        }
        else{
            return true;
        }
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key){
        return get(root,key);
    }
    private V get(Node L, K key){
        if(L == null){
            return null;
        }
        int cmp = key.compareTo(L.key);
        if (cmp < 0){
            return get(L.left,key);
        }
        else if(cmp > 0){
            return get(L.right,key);
        }
        else{
            return L.val;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size(){
        return size(root);
    }
    private int size(Node L){
        if (L == null){
            return 0;
        }
        else{
            return L.size;
        }
    }
    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value){
        //if(value == null){
            //remove(key);
           // return;
        //}
        root = put(root,key,value);
    }
    private Node put( Node L, K key, V value){
        if(L == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(L.key);
        if(cmp < 0){
            L.left = put(L.left,key,value);
        }
        else if(cmp > 0){
            L.right = put(L.right,key,value);
        }
        else{
            L.val = value;
        }
        L.size = 1 + size(L.left) + size(L.right);
        return L;
    }
    //Need to test
    public void printInOrder(){
        printInOrder(root);
    }
    private void printInOrder(Node node){
        if(node == null){
            return;
        }
        printInOrder(node.left);
        System.out.println(node.key.toString() + " -> " + node.val.toString());
        printInOrder(node.right);
    }
    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }


}
