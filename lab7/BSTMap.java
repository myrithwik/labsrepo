import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BSTMap() {
        root = new Node(null, null ,0);
    }

    /** Removes all of the mappings from this map. */
    public void clear() {
        root = new Node(null, null ,0);
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        if (size() == 0) {
            return false;
        }
        Node p = root;
        while (p != null) {
            int cmp = key.compareTo(p.key);
            if(cmp > 0) {
                p = p.right;
            }
            else if (cmp < 0) {
                p = p.left;
            }
            else {
                return true;
            }
        }
        return false;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        if (size() == 0) {
            return null;
        }
        Node p = root;
        while (p != null) {
            int cmp = key.compareTo(p.key);
            if(cmp > 0) {
                p = p.right;
            }
            else if (cmp < 0) {
                p = p.left;
            }
            else {
                return p.val;
            }
        }
        return null;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return root.size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value){
        Node nn = new Node(key,value, 1);
        if (size() == 0) {
            root = nn;
        }
        else {
            Node p = root;
            while (p != null) {
                int cmp = key.compareTo(p.key);
                if(cmp > 0) {
                    p.size++;
                    if (p.right == null) {
                        p.right = nn;
                        break;
                    }
                    p = p.right;
                }
                else if (cmp < 0) {
                    p.size++;
                    if (p.left == null) {
                        p.left = nn;
                        break;
                    }
                    p = p.left;
                }
                else {
                    break;
                }
            }
        }
    }

    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    private void printRecursive (Node n) {
        if (n == null){
            return;
        }
        printRecursive(n.left);
        System.out.println(n.val + " ");
        printRecursive(n.right);
    }

    public void printInOrder(){
        printRecursive(root);
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
