class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A); //sort A for compare
        //encapsulate B in a class to better memory B' index
        LinkedList<Node> listB = new LinkedList<>();
        for (int i = 0; i < B.length; i++) {
            listB.add(new Node(B[i], i));
        }
        //sort listB by overwrite the collection.sort comparator
        Collections.sort(listB, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return n1.value - n2.value;
            }
        });
        for (int i = 0; i < A.length; i++) {
            if (A[i] > listB.getFirst().value) {
                B[listB.removeFirst().index] = A[i];
            }else {
                B[listB.removeLast().index] = A[i];
            }
        }
        return B;
    }
}
//define Node class
class Node{
    int value;
    int index;
    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}