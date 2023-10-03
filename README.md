Design a data structure that supports following operations in Θ(1) time.

insert(x): Inserts an item x to the data structure if not already present.

remove(x): Removes an item x from the data structure if present.

getRandom(): Returns a random element from current set of elements

Example:

insert(3); ds becomes {3}
insert(4); ds becomes {3,4}
insert(5); ds becomes {3,4,5}
insert(6); ds becomes {3,4,5,6}

search(4); - returns true,
search(10); - returns false;

getRandom()- can return anyone of the items in our data structure ....it may return either 3 or 4 or 5 or 6...because all form a part of the data structure now. So, returning any one of them is correct.

remove(4) - removes element 4 from the data structure, now data structure becomes {3,5,6}

getRandom()- returns any one of the elements from the set {3,5,6}. Returning any one of these 3 existing elements is correct