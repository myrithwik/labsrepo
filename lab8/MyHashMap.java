import java.util.*;

public class MyHashMap<K, V> implements Map61B<K, V> {
    /*
    @TA Omar Khan
    The solution we worked on this lab did not work at all.
    TA Omar Khan went over the whole solution during lab
    so that's where this solution comes from.
     */
    private class Item {
        private K key;
        private V val;

        public Item(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private List<Item>[] buckets;
    private double loadFactor;
    private int size;
    private HashSet<K> holder;


    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, 0.75);
    }

    public MyHashMap(int initialSize, double loadFactor) {
        buckets = (List<Item>[]) new ArrayList[initialSize];
        this.loadFactor = loadFactor;
        this.holder = new HashSet<K>();
    }

    private int wrap(K k, int m) {
        return Math.floorMod(k.hashCode(), m);
    }

    private Item getItem (K key) {
        int bucketInd = wrap(key, buckets.length);
        List<Item> bucket = buckets[bucketInd];
        if (bucket == null) {
            return null;
        }
        for (Item item : bucket) {
            if (item.key.equals(key)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        buckets = (List<Item>[]) new ArrayList[16];
        size = 0;
        holder = new HashSet<K>();
    }

    @Override
    public boolean containsKey(K key) {
        return holder.contains(key);
    }

    @Override
    public V get(K key) {
        Item item = getItem(key);
        if (item == null) {
            return null;
        }
        else {
            return item.val;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        Item item = getItem(key);

        if (item != null) {
            item.val = value;
            size += 1;
        }
        else {
            int bucketInd = wrap(key, buckets.length);
            List<Item> bucket = buckets[bucketInd];
            Item toAdd = new Item(key, value);
            if (bucket == null) {
                buckets[bucketInd] = new ArrayList<Item>();
            }
            buckets[bucketInd].add(toAdd);
            size += 1;
            holder.add(key);

            double currentLoadFactor = ((double) size) / buckets.length;

            if (currentLoadFactor > this.loadFactor) {
                resize(2 * buckets.length);
            }
        }
    }

    private void resize (int newSize) {
        List<Item>[] newBuckets = (List<Item>[]) new ArrayList[newSize];

        for (int i=0; i < buckets.length; i++) {
            List<Item> bucket = this.buckets[i];
            if (bucket == null) {
                continue;
            }
            for (Item item : bucket) {
                int newBucketInd = wrap(item.key, newSize);
                if (newBuckets[newBucketInd] == null) {
                    newBuckets[newBucketInd] = new ArrayList<Item>();
                }
                List<Item> newBucket = newBuckets[newBucketInd];
                newBucket.add(item);
            }
        }
    }

    @Override
    public Set<K> keySet() {
        return holder;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return holder.iterator();
    }
}
