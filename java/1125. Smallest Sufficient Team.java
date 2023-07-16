/**
 *Problem: 1125. Smallest Sufficient Team
 *In a project, you have a list of required skills req_skills, and a list of people. The ith person people[i] contains a list of skills that the person has.
 *Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill. We can represent these teams by the index of each person.
 *For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
 *Return any sufficient team of the smallest possible size, represented by the index of each person. You may return the answer in any order.
 *It is guaranteed an answer exists.
 */


class Solution {
    //Find the smallest team of people who collectively possess all the required skills.
    //To tackle this problem we use a combination of bitmasking and backtracking.
    
    List<Integer> mainTeam = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        for(String skill : req_skills){
            map.put(skill,i++);
        }

        //Bitwise left shift operator e.g. 1<<3 = 8 the example goes 0000001<<3 =  00001000
        int reqSkills = (1<<i)-1;
        int skills[] = getPeopleSkillsMask(people, map);
        List<Integer> localTeam = new ArrayList<>();
        findTeam(reqSkills, skills, 0, 0, localTeam);
        return convertListToArray();        
    }

    //Bracelet with switches, each switch represents a particular skill. If a switch is ON, it means the friend has that skill; otherwise it's OFF.
    
    public int[] getPeopleSkillsMask(List<List<String>> people, HashMap<String, Integer> map){
        int len = people.size();
        int skills[] = new int[len];
        for(int i = 0; i < len; i++){
            //Bitwise OR operation
            //int a = 12; // binary: 1100
            //int b = 9;  // binary: 1001
            //int result = a | b; // binary: 1101

            for(String skill : people.get(i)){
                skills[i] |= (1<<map.get(skill));
                System.out.println(i+" , "+skills[i]);
            }
        }
        return skills;
    }

    public void findTeam(int reqSkills, int[] skills, int teamSkills, int person, List<Integer> localTeam){
        if(mainTeam.size()>0 && localTeam.size() >= mainTeam.size()-1 || person == skills.length){
            return ;
            //Early stopping
        }

        //Taking current person into team
        localTeam.add(person);

        if((teamSkills|skills[person]) == reqSkills){
            mainTeam = new ArrayList<Integer>(localTeam);
            localTeam.remove(localTeam.size()-1);
            return;
        }
        else if ((teamSkills|skills[person])>teamSkills){
            findTeam(reqSkills, skills, teamSkills|skills[person], person+1, localTeam);
        }

        localTeam.remove(localTeam.size()-1);

        findTeam(reqSkills, skills, teamSkills, person+1, localTeam);
    }
    
    public int[] convertListToArray(){
        int len = mainTeam.size();
        int skills[] = new int[len];
        for(int i = 0; i < len; i++){
            skills[i] = mainTeam.get(i);
        }
        return skills;
    }



}
