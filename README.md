# Movie Recommendation System

A Java desktop application that recommends movies based on genre selection.

## Overview

This project uses a Binary Search Tree (BST) to store and sort movies by rating.
Users can select a genre from a dropdown and view a sorted list of recommendations.

## Data Structure

The application uses a Binary Search Tree where each node holds a Movie object.
Movies are inserted sorted by rating in ascending order.
When two movies share the same rating, year is used as a secondary sort key.
In-order traversal produces a list sorted from lowest to highest rating.
