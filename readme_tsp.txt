/**********************************************************************
 *  readme template                                                   
 *  Traveling Salesperson Problem
 **********************************************************************/

Name: Ethan Chen
PennKey:etc
Recitation:217

Hours to complete assignment (optional):30


/**********************************************************************
 *  Have you entered all help, collaboration, and outside resources
 *  in your help log?  If not, do so now.  (And in future, make sure
 *  you make your help log entries as you go, not at the end!)
 *
 *  If you did not get any help in outside of TA or instructor office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA or instructor office hours.
 *  I did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/
 "I did not receive any help outside of TA or instructor office hours.
 I did not collaborate with anyone, and I did not use any
 resources beyond the standard course materials."



/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.
 **********************************************************************/
Calculated the distance from the current point to the point to be inserted
    and saved the node number of that point only if the distance calculated
    was less than previous ones

/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.
 *  It's sufficient to list only the differences between this
 *  heuristic and the nearest insertion heuristic.
 **********************************************************************/
Similar except I calculate the smallest sum of distance between this point
    and the next point to the point to be inserted


/**********************************************************************
 *  Fill in the distances computed by your heuristics.                
 **********************************************************************/

data file        order     nearest     smallest      extra credit
-----------------------------------------------------------------------
tsp10.txt        2586.7    1566.1     1655.7
tsp100.txt       25547     7389.9     4887.2
tsp1000.txt      3.2769e+05 27869     17266
usa13509.txt     3.9108e+06 77450     45075




 
 /**********************************************************************
 *  Why is it a good idea to repeat the first Node at the end of the
 *  Tour?
 **********************************************************************/
So the tour ends where it begins
 

 
/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/


 
 
 
/**********************************************************************
 *  If you did the extra credit, give instructions here for 
 *  running it.
 **********************************************************************/



 
/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Difficult to test and understand certain steps of the process. Also hard to 
    implement the first step in the linked list of insertInOrder without 
    much background of the for loop for linked lists.



/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

 
 
 
