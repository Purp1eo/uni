# test_tasks16_17.py

# Python code to unittest the methods and agents
import unittest 
import os
import random
import string
import ast
import inspect
import pytest
import math

import nbimporter
import pythonBasics2 as tasks

class TestAgent(unittest.TestCase): 

    def test_odd_numbers_generator_isgenerator(self):
        self.assertTrue(inspect.isgenerator(odd_numbers_generator()), "Funktion soll ein Generator sein.")

    def test_odd_numbers_generator_values(self):
        lastvalue = -1
        for value in odd_numbers_generator():
            self.assertTrue(value % 2 == 1)
            self.assertEqual(2, value - lastvalue)
            lastvalue = value
            if lastvalue > 200:
                break

    def test_fibonacci_generator_isgenerator(self):
        self.assertTrue(inspect.isgenerator(fibonacci_generator()), "Funktion soll ein Generator sein.")

    def test_fibonacci_generator_values(self):
        fib = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811]
        pos = 0
        for value in fibonacci_generator():
            self.assertEqual(value, fib[pos])
            pos += 1
            if pos >= len(fib):
                break

if __name__ == '__main__':
    main = TestAgent()

    # This executes the unit test/(itself)
    import sys
    suite = unittest.TestLoader().loadTestsFromTestCase(TestAgent)
    unittest.TextTestRunner(verbosity=4,stream=sys.stderr).run(suite)