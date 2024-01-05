# test_tasks5_7.py

# Python code to unittest the methods and agents
import unittest 
import os
import random
import string

import nbimporter
import pythonBasics1 as tasks

class TestAgent(unittest.TestCase): 

    def test_get_char(self):
        for i in range(0, 5):
            textlen = random.randint(10,15)
            text = ''.join(random.choice(string.ascii_letters + " ") for _ in range(textlen))
            pos = random.randint(0,textlen-1)
            result = tasks.get_char(text, pos)
            self.assertIsNotNone(result)
            self.assertTrue(isinstance(result, str), "Result is not a string")
            self.assertEqual(result, text[pos], str(pos) + "tes Element von \"" + text + "\" sollte " + text[pos] +
                             " sein, ist aber \"" + result + "\"")

    def test_get_word(self):
        for i in range(0, 5):
            wordnum = random.randint(3,8)
            words = []
            for i in range(wordnum):
                words += [''.join(random.choice(string.ascii_letters) for _ in range(random.randint(5,10)))]
            pos = random.randint(0,wordnum-1)
            text = " ".join(words)
            result = tasks.get_word(text, pos)
            self.assertIsNotNone(result)
            self.assertTrue(isinstance(result, str), "Result is not a string")
            self.assertEqual(result, words[pos], str(pos) + "tes Wort von \"" + text + "\" sollte " + words[pos] +
                             " sein, ist aber \"" + result + "\"")

    def test_join_by_dashes(self):
        for i in range(0, 5):
            wordnum = random.randint(3,8)
            words = []
            for i in range(wordnum):
                words += [''.join(random.choice(string.ascii_letters) for _ in range(random.randint(5,10)))]
            text = " ".join(words)
            expected = "--".join(words)
            result = tasks.join_by_dashes(text)
            self.assertIsNotNone(result)
            self.assertTrue(isinstance(result, str), "Result is not a string")
            self.assertEqual(result, expected, "Ergebnis \"" + expected +
                             "\" sein, ist aber \"" + result + "\"")


if __name__ == '__main__':
    main = TestAgent()

    # This executes the unit test/(itself)
    import sys
    suite = unittest.TestLoader().loadTestsFromTestCase(TestAgent)
    unittest.TextTestRunner(verbosity=4,stream=sys.stderr).run(suite)