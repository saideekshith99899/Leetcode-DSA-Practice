class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        temp=[]
        for i in range(0,len(names)):
            temp.append([names[i],heights[i]])
        temp.sort(key=lambda x:-x[1])
        arr=[]
        for i in range(0,len(names)):
            arr.append(temp[i][0])
        return arr
        
