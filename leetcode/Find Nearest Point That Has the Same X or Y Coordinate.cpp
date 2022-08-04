// class Solution {
// public:
//     int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
//         int mini=INT_MAX,index=-1; 
//     for(int i=0;i<points.size();i++)
//     {
//         if(x==points[i][0]||y==points[i][1])
//         {
//             int diff=abs(points[i][0]-x)+abs(points[i][1]-y);
//             if(diff<mini)
//             {
//                 mini=diff;
//                 index=i;
//             }
//         }
//     }
//     return index;
//     }
// };