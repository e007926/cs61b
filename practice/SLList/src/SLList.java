public class SLList {
    /*The first item(if it exists) is at sentinel.next */
    /* A special node which always exists*/
    private IntNode sentinel;
    private int size;
    /* Create empty list*/
    public SLList(){
        sentinel = new IntNode(1,null);
        size = 0;
    }
    public SLList(int x){
        sentinel = new IntNode(1,null);
        sentinel.next = new IntNode(x,null);
        size = 1;
    }
    public void addFirst(int f){
        sentinel.next = new IntNode(f,sentinel.next);
        size +=1;
    }
    public int getFirst(){
            return sentinel.next.item;
    }
    public void addLast(int l){
        size += 1;
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(l,null);

    }

    public int size(){
        return size;
    }
    public static void main(String[] args){
        /*Creates a list of one integer*/
        SLList L = new SLList();
        L.addFirst(1);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());
    }
}
