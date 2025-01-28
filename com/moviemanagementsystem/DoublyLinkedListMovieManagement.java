//Movie Management System
//Problem Statement: Implement a movie management system using a doubly linked list. Each node will represent a
// movie and contain Movie Title, Director, Year of Release, and Rating. Implement the following functionalities:
//Add a movie record at the beginning, end, or at a specific position.
//Remove a movie record by Movie Title.
//        Search for a movie record by Director or Rating.
//Display all movie records in both forward and reverse order.
//Update a movie's Rating based on the Movie Title.
//Hint:
//Use a doubly linked list where each node has two pointers: one pointing to the next node and the other to the previous node.
//Maintain pointers to both the head and tail for easier insertion and deletion at both ends.
//For reverse display, start from the tail and traverse backward using the prev pointers.
package com.moviemanagementsystem;
class Movie {
    String title, director;
    int year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieList {
    private Movie head, tail;

    public void addFirst(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) head = tail = newMovie;
        else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addLast(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) head = tail = newMovie;
        else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void remove(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current == head && current == tail) head = tail = null;
                else if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public void searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director))
                System.out.println(current.title + " (" + current.year + ") - Rating: " + current.rating);
            current = current.next;
        }
    }

    public void searchByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating)
                System.out.println(current.title + " (" + current.year + ") - Director: " + current.director);
            current = current.next;
        }
    }

    public void displayForward() {
        Movie current = head;
        while (current != null) {
            System.out.println(current.title + " (" + current.year + ") - Director: " + current.director + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public void displayBackward() {
        Movie current = tail;
        while (current != null) {
            System.out.println(current.title + " (" + current.year + ") - Director: " + current.director + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }
}

public class DoublyLinkedListMovieManagement {
    public static void main(String[] args) {
        MovieList movies = new MovieList();

        movies.addFirst("ABC", "abc", 2010, 8.8);
        movies.addLast("DEF", "def", 1997, 7.8);
        movies.addLast("IJK", "ijk", 1972, 9.2);

        System.out.println("Forward List:");
        movies.displayForward();

        System.out.println("\nBackward List:");
        movies.displayBackward();

        System.out.println("\nSearch by Director (def):");
        movies.searchByDirector("def");

        System.out.println("\nSearch by Rating (7.8):");
        movies.searchByRating(7.8);

        System.out.println("\nUpdate ABC Rating to 9.0:");
        movies.updateRating("ABC", 8.0);
        movies.displayForward();

        System.out.println("\nRemove IJK :");
        movies.remove("IJK");
        movies.displayForward();
    }
}