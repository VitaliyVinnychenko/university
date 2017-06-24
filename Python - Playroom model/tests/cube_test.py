import unittest
from src.playroom.cube import Cube


class CubeTest(unittest.TestCase):

    __cube = Cube(.5, .01, 'playcube', 'red', 5.0)

    def test_get_color(self):
        self.assertEqual(self.__cube.get_color, 'red')

    def test_get_edge_length(self):
        self.assertEqual(self.__cube.get_edge_length, 5)

    def test_calculate_toy_volume(self):
        self.__cube.calculate_toy_volume()
        self.assertEqual(self.__cube.get_volume, 125)


if __name__ == '__main__':
    unittest.main()
