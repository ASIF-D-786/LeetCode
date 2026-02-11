class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newNode=head;
        while(newNode!=null&&newNode.next!=null){
            if(newNode.val==newNode.next.val){
                newNode.next=newNode.next.next;
            }
            else{
                newNode=newNode.next;
            }
        }
        return head;
    }
}