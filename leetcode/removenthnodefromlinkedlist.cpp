class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
    if(n<0 || head == NULL)
        return head;
    if(head->next == NULL )
        return NULL;
    
    ListNode *p = head;
    ListNode *count = head;
    
    int length=0;
    while(count){
        length+=1;
        count=count->next;
    }
    if(length-n == 0)
        return head->next;
    else
        for(int i = 1; i<(length-n);i++)
            p=p->next;
    p->next = p->next->next;
    return head;
    }
};