/*Singly Linked List: Student Record Management
Problem Statement: Create a program to manage student records using a singly linked list. Each node will store information about a student, including their Roll Number, Name, Age, and Grade. Implement the following operations:
Add a new student record at the beginning, end, or at a specific position.
Delete a student record by Roll Number.
Search for a student record by Roll Number.
Display all student records.
Update a student's grade based on their Roll Number.
Hint:
Use a singly linked list where each node contains student information and a pointer to the next node.
The head of the list will represent the first student, and the last node’s next pointer will be null.
Update the next pointers when inserting or deleting nodes.
*/
package com.studentrecordmanagement;

class StudentNode {
    int rollNumber;
    String name;
	char grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, char grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }
    
}
class StudentLinkedList {
    private StudentNode head;

    public void addAtBeginning(int rollNumber, String name, char grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, char grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, grade);
        if (head == null) {
            head = newStudent;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
    }
	public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student not found");
        } else {
            current.next = current.next.next;
        }
    }
	public void searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Found: Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found");
    }
	 public void displayAll() {
        if (head == null) {
            System.out.println("No students to display");
            return;
        }

        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Grade: " + current.grade);
            current = current.next;
        }
    }
	public void updateGrade(int rollNumber, char newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll Number: " + rollNumber);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found");
    }
}
public class SinglyLinkedListStudentManagement {
    public static void main(String[] args){
        StudentLinkedList studentList = new StudentLinkedList();

        studentList.addAtEnd(1, "Rishika", 'A');
        studentList.addAtBeginning(2, "Geeta", 'B');
        studentList.addAtEnd(3, "Charlie",'C');

        System.out.println("Student records:");
        studentList.displayAll();

        System.out.println("\nSearching for Roll Number 2:");
        studentList.searchByRollNumber(2);

        System.out.println("\nUpdating grade for Roll Number 1 to 'B'");
        studentList.updateGrade(1, 'B');
        studentList.displayAll();

        System.out.println("\nDeleting student with Roll Number 3");
        studentList.deleteByRollNumber(3);
        studentList.displayAll();
    }
}