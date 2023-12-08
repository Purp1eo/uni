# test_tasks1_3.py

# Python code to unittest the methods and agents
import unittest 
import os

import nbimporter
import pythonBasics1 as tasks

class TestAgent(unittest.TestCase): 

    def get_dimension_count(self, l):
        count = 0
        while isinstance(l, list):
            if not l:
                break
            count += 1
            l = l[0]
        return count
    
    def check_list(self, l, dim1, dim2):
        self.assertIsNotNone(l)
        self.assertTrue(isinstance(l, list), "Result is not a list")
        
         # Check that number of dimensions is correct
        self.assertEqual(self.get_dimension_count(l), 2, "Incorrect number of dimensions")

        self.assertEqual(len(l), dim1, "Length of result was expected to be " + str(dim1) + " but is " + str(len(l)))
        for i in range(dim1):
            self.assertTrue(isinstance(l[i], list), str(i) + "th element of result is not a list")
            self.assertEqual(len(l[i]), dim2,
                             "Length of " + str(i) + "th element of result was expected to be " + str(dim2) +
                             " but is " + str(len(l[i])))
   
    def test_create_3x3_list(self):
        result = create_3x3_list()
        self.check_list(result, 3, 3)
       
        self.assertIsNotNone(result)
        for i in range(0, 3):
            for j in range(0, 3):
                self.assertEqual(result[i][j], 0, "Element at position (" + str(i) + ", " + str(j) + ") is not 0")

    def test_create_3x3_list(self):
        result = tasks.create_3x3_list()
        self.check_list(result, 3, 3)

    def test_create_3x3_list_different(self):
        result = tasks.create_3x3_list_different()
        self.check_list(result, 3, 3)
        numset = set()
        self.assertIsNotNone(result)
        for i in range(0, 3):
            for j in range(0, 3):
                numset.add(result[i][j])
        self.assertEqual(len(numset), 9, "Not all numbers are different")

    def test_remove_middle_element(self):
        result = tasks.remove_middle_element([[0,0,0], [0,0,0], [0,0,0]])
        self.check_list(result, 2, 3)

if __name__ == '__main__':
    main = TestAgent()

    # This executes the unit test/(itself)
    import sys
    suite = unittest.TestLoader().loadTestsFromTestCase(TestAgent)
    unittest.TextTestRunner(verbosity=4,stream=sys.stderr).run(suite)