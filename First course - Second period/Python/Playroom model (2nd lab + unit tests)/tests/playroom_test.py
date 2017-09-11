from src.playroom.playroom import Playroom
from src.playroom.ball import Ball
from src.playroom.car import Car
from src.playroom.cube import Cube
from src.playroom.doll import Doll
import unittest


class PlayroomTest(unittest.TestCase):

    __playroom = Playroom(10)
    __toys = [Ball(12.5, 0.342, "football", "white", 15),
            Cube(0.5, .01, "playcube", "red", 5.0),
            Car(150.0, 2.3, "Nissan", 0.15, 0.38, "silver"),
            Doll(3.75, 0.175, "barbie", "female", "Hello, world!", 21.0, "yellow")]

    def setUp(self):
        self.__toys[0].calculate_toy_volume()
        self.__toys[1].calculate_toy_volume()

        for toy in self.__toys: self.__playroom.push_toy(toy)

    def tearDown(self):
        self.__playroom.reset_values()

    def test_sort_toys_by_attr(self):
        expected_output = "Price: $0.5\nWeight: 0.01 kg\nType: \"playcube\"\n" \
                          "Color: red\nEdge length: 5.0 m\nVolume: 125.0 c.m.\n\n" \
                          "Price: $3.75\nWeight: 0.175 kg\nType: \"barbie\"\n" \
                          "Hair color: yellow\nSex: female\nHeight: 21.0 m\n\n" \
                          "Price: $12.5\nWeight: 0.342 kg\nType: \"football\"\n" \
                          "Color: white\nRadius: 15 m\nVolume: 10602.8752059 c.m.\n\n" \
                          "Price: $150.0\nWeight: 2.3 kg\nType: \"Nissan\"\n" \
                          "Color: silver\nWidth: 0.15 m\nLength: 0.38 m\n\n"

        self.__playroom.sort_toys_by_attr('price')
        self.assertEqual(self.__playroom.show_available_toys(), expected_output)

    def test_search_toys_by_type(self):
        expected_output = "Price: $12.5\nWeight: 0.342 kg\nType: \"football\"\n" \
                          "Color: white\nRadius: 15 m\nVolume: 10602.8752059 c.m.\n\n"

        self.assertEqual(self.__playroom.search_toys_by_type('football'), expected_output)

    def test_str(self):
        expected_output = "Capacity: 10\nNumber of toys: 4\nTotal toys price: $166.75\n\n"

        self.assertEqual(self.__playroom.__str__(), expected_output)

    def test_get_capability(self):
        self.assertEqual(self.__playroom.get_capability, 10)

    def test_get_available_toys(self):
        self.assertEqual(self.__playroom.get_available_toys, self.__toys)

    def test_get_total_toys_price(self):
        self.assertEqual(self.__playroom.get_total_toys_price, 166.75)

    def test_get_toys_number(self):
        self.assertEqual(self.__playroom.get_toys_number, len(self.__toys))


if __name__ == '__main__':
    unittest.main()
