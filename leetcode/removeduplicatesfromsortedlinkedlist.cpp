class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
         ListNode* current = head;
         while(current && current->next){
             if(current->next->val == current->val){
                 current->next = current->next->next;
             }
             else{
                 current = current->next;
             }
         }
         return head;
    }
};