# BagADT
Summary

The Abstract Data Type Bag is a collection of elements wherein duplicates are allowed and element retrieval is not necessarily limited by any rules such as with Stack or Queue.

Design

This Bag ADT is written as an interface and implemented with a Sorted Array, Unsorted Array, and Sorted Linked List. The Sorted Array implementation is highly optimized with O(log n) insertion and deletion of elements via a binary search algorithm that returns either the location of a specified element or, if not found, the index where that element should be inserted.

Supported methods of the Bag ADT include add an element, remove an element, remove every occurrence of an element, grab a random element, and several others.
Included is a test driver with options for the user to choose an implementation and invoke its methods.
