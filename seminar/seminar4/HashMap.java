package algorithms.seminar.seminar4;

class HashMap {
    class Entity{
        int key;
        int value;
    }
    class Basket{
        Node head;
        class Node{
            Entity entity;
            Node next;
        }

        public Integer find(int key){ // O(1)
            Node node = head;
            while(node != null){
                if(node.entity.key == key){
                    return node.entity.value;
                }
                node = node.next;
            }
            return null;
        }

        public boolean push(Entity entity){ // O(1)
            Node node = new Node();
            node.entity = entity;

            if(head == null){
                head = node;
            }else{
                if(head.entity.key == entity.key){
                    return false;
                }else {
                    Node cur = head;
                    while (cur.next != null) {
                        if (cur.next.entity.key == entity.key) {
                            return false;
                        }
                        cur = cur.next;
                    }
                    cur.next = node;
                }
            }
            return true;
        }

        public boolean remove(int key){ // O(1)
            if(head != null) {
                if (head.entity.key == key) {
                    head = head.next;
                    return true;
                } else {
                    Node cur = head;
                    while (cur.next != null) {
                        if (cur.next.entity.key == key) {
                            cur.next = cur.next.next;
                            return true;
                        }
                        cur = cur.next;
                    }
                }
            }
            return false;
        }
    }

    static final int INIT_SIZE = 16;

    Basket[] baskets;

    public HashMap(){
        this(INIT_SIZE);
    }

    public HashMap(int size){
        baskets = new Basket[size];
    }

    private int getIndex(int key){
        return key % baskets.length;
    }

    public Integer find(int key){ // O(1)
        int index = getIndex(key);
        Basket basket = baskets[index];
        if(basket != null){
            return basket.find(key);
        }
        return null;
    }

    public boolean push(int key, int value){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if(basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.push(entity);
    }

    public boolean remove(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if(basket != null){
            return basket.remove(key);
        }
        return false;
    }
}

