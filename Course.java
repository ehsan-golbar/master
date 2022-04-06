public class Course {
    
    String name;
    int maxStudents = 5;
    Student[] students = new Student[maxStudents];

    int numStudents;
    //salam

    
    public Course(String name){
        this.name = name;
    }

    public boolean addStudent(Student s){
        int  numberOfnull = 0, fullPlaces = 0 ;

                if( maxStudents == numberOfnull ){
            maxStudents *= 2 ;
            Student[] temp = new Student[maxStudents];
            System.arraycopy(students, 0, temp, 0, maxStudents/2) ;
            students = temp;
        }


        for ( int i = 0 ; i < 5 ; i++){
            if ( s.courses[i] == null){
                numberOfnull++;
            }
        }
        if ( numberOfnull == 0 )
        return false ;
        for ( int i = 0 ; i < 5 - numberOfnull ; i++){
            if ( s.courses[i].name == name){
                return false ;
            }
        }
          s.courses[ 5 - numberOfnull ] = this ;


        for ( int i = 0 ; i < maxStudents ; i++){
            if ( students[i] == null){
                students[i] = s;
                fullPlaces = i + 1;
                break ;
            }
        }

        sort ( students, fullPlaces) ;

      
        
      
        
        computeNumStudents();

        return true ;
    }


    public void sort ( Student[] arr, int fullPlaces )
     {
            
                for (int i = 0; i < fullPlaces-1; i++)
                     for (int j = 0; j < fullPlaces-i-1; j++)
                        if (arr[j].gradeMean > arr[j+1].gradeMean)
                        {
                              Student temp = arr[j];
                              arr[j] = arr[j+1];
                             arr[j+1] = temp;
                       }
    }

    public Student deleteStudent(int studentID){
        
        Student returnStudent = new Student(0, 0);
        computeNumStudents();
       for ( int i = 0 ; i < numStudents ; i++){
            if ( students[i].studentId == studentID){
               returnStudent = students[i];
                System.arraycopy(students, i + 1, students, i, numStudents -(i+1));
                students[numStudents - 1] = null;
               int numberOfnull = 0;
                for ( int j = 0 ; j < 5 ; j++){
                    if ( returnStudent.courses[j] == null){
                        numberOfnull++;
                    }
                }
                for ( int j = 0 ; j < 5 - numberOfnull ; j++){
                    if ( returnStudent.courses[j].name == name ){
                        System.arraycopy(returnStudent.courses, j + 1 ,returnStudent.courses, j, 5 - numberOfnull -(j+1)); 
                        returnStudent.courses[5 - numberOfnull - 1] = null;
                        break;
                    }  
            }
                     return returnStudent;
              }
             }
                  return null;
            }

            public String  printStudents(){
                String output = "";
                computeNumStudents();
                if ( numStudents == 0)
                return "there is no student";
                for ( int i = 0 ; i < numStudents ; i++) {
                    output += students[i].studentId ;
                    output +=  " " ;
                }
                return output;
            }


            public String findBest(){
                String output = "";
                int max = 0 ;
                computeNumStudents();
                if ( numStudents == 0)
                return "there is no student in the class";
                for ( int i = 0 ; i < numStudents - 1 ; i++){
                    if ( students[i].gradeMean > students[i+1].gradeMean)
                    max = i;
                    else 
                    max = i+1;
                }
                output += "id : " + students[max].studentId + " grade : " + students[max].gradeMean;
                return output;


            }

            public int size(){
                computeNumStudents();
                return numStudents;
            }

            public Student findId(int id){
                computeNumStudents();

                for ( int i = 0 ; i < numStudents; i++){
                    if ( students[i].studentId == id )
                    return students[i];
                }
                return null;
            }

            public int getMaxStudents(){
                return maxStudents;
            }


            public void computeNumStudents(){
                int numberOfnull = 0;
                for ( int i = 0 ; i < maxStudents ; i++){
                    if ( students[i] == null){
                        numberOfnull++;
                    }
                }
                numStudents = maxStudents - numberOfnull ;
            }
}
