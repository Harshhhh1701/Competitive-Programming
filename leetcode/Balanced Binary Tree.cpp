class Solution {
public:
    
    bool isBalanced(TreeNode* root) {
        return validate(root)!=-1;
    }
    int validate(TreeNode* root){
        if(root==0){
            return 0;
        }
        int left=validate(root->left);
        int right=validate(root->right);
        if(left==-1 || right==-1){return -1;}
        if(abs(left-right)>1){
            return -1;
        }
        return 1+max(left,right);
    }
};