public class DuplicateFinder {
    static String findDuplicateTeam(String[] teamNames){

        for (int i=0;i<teamNames.length;i++){
            for (int j=i+1;j<teamNames.length;j++){
                if(teamNames[i].equals(teamNames[j])){
                    return "duplicate found "+teamNames[i];
                }
            }
        }  
        return "no duplicate found";                
    }
    public static void main(String[] args) {
        
        String[] teamname= {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teamname));
    }
}
