# test_tasks8_11.py

# Python code to unittest the methods and agents
import unittest 
import os
import random
import string

import nbimporter
import pythonBasics1 as tasks

class TestAgent(unittest.TestCase): 

    def test_text_to_array(self):
        for i in range(0, 5):
            textlen = random.randint(10,15)
            chars = [random.choice(string.ascii_letters + " ") for _ in range(textlen)]
            result = text_to_array(''.join(chars))
            self.assertIsNotNone(result)
            self.assertTrue(isinstance(result, list), "Result is not a list")
            self.assertListEqual(result, chars)

    def test_text_to_unique_array(self):
        result = text_to_unique_array("This is a test")
        self.assertIsNotNone(result)
        self.assertTrue(isinstance(result, list), "Result is not a list")
        self.assertListEqual(result, ["T", "h", "i", "s", " ", "a", "t", "e"])

    def test_invert_text(self):
        result = invert_text("Zeichenkette")
        self.assertIsNotNone(result)
        self.assertTrue(isinstance(result, str), "Result is not a string")
        self.assertEqual(result, "etteknehcieZ")

    def test_make_rotations(self):
        result = aufgaben.make_rotations("test")
        self.assertIsNotNone(result)
        self.assertTrue(isinstance(result, list), "Result is not a list")
        self.assertListEqual(result, ["test", "estt", "stte", "ttes"])


if __name__ == '__main__':
    main = TestAgent()

    # This executes the unit test/(itself)
    import sys
    suite = unittest.TestLoader().loadTestsFromTestCase(TestAgent)
    unittest.TextTestRunner(verbosity=4,stream=sys.stderr).run(suite)