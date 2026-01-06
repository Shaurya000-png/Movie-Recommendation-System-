# Movie Recommendation System

A Java desktop application that recommends movies based on genre selection.

## Overview

This project uses a Binary Search Tree (BST) to store and sort movies by rating.
Users can select a genre from a dropdown and view a sorted list of recommendations.
The application is built entirely with Java standard library - no external dependencies.

## Data Structure

The application uses a Binary Search Tree where each node holds a Movie object.
Movies are inserted sorted by rating in ascending order.
When two movies share the same rating, year is used as a secondary sort key.
In-order traversal produces a list sorted from lowest to highest rating.

## Project Structure

    movierecsys/
        src/
            movierecsys/
                Movie.java                     - Movie data model
                MovieNode.java                 - BST node wrapper
                MovieRecommendationSystem.java - Core BST logic and file loading
                MovieRecommenderUI.java        - Swing GUI with table and popup
        bin/                                   - Compiled class files (Eclipse output)
        movies.txt                             - Movie dataset (not tracked)

## Movie Data Format

Each line in the dataset file follows this comma-separated format:

    Title, Genre, Rating, Year, Description

Example entries:

    Inception, Sci-Fi, 8.8, 2010, A thief who steals corporate secrets using dream-sharing technology
    The Dark Knight, Action, 9.0, 2008, Batman faces the Joker in a battle for Gotham City
