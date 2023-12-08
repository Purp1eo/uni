# test_task4.py

# Python code to unittest the methods and agents
import unittest 
import os

import nbimporter
import pythonBasics1 as tasks

class TestAgent(unittest.TestCase): 

    def test_convert_to_dict(self):
        result = tasks.convert_to_dict([[0,0,0], [0,0,0], [0,0,0]])
        self.assertIsNotNone(result)
        self.assertTrue(isinstance(result, dict), "Result is not a dictionary")
        self.assertEqual(len(result), 3, "Length of result was expected to be 3 but is " + str(len(result)))
        for i in result.keys():
            self.assertTrue(isinstance(i, str), "Key " + str(i) + " is not a string")
            self.assertTrue(isinstance(result[i], list), "Value " + str(result[i]) + " (at key " + str(i) +
                            ") is not an array")
            self.assertEqual(len(result[i]), 3,
                             "Length of element \"" + i + "\" of result was expected to be 3 but is " +
                             str(len(result[i])))

if __name__ == '__main__':
    main = TestAgent()

    # This executes the unit test/(itself)
    import sys
    suite = unittest.TestLoader().loadTestsFromTestCase(TestAgent)
    unittest.TextTestRunner(verbosity=4,stream=sys.stderr).run(suite)