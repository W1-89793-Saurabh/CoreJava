// Declare two Arrays of type String. Find the duplicate values of an array of string values. (Hint: use equals())

public class  ArrayString{
    public static void main(String[] args){
        String[] arr1 = {"A", "B", "C", "D", "E"};
        String[] arr2 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(arr1[i].equals(arr2[j])){
                    System.out.println("Duplicate value: " + arr1[i]);
                }
            }
        }
    }
}
