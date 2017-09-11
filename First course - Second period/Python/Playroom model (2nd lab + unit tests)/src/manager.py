from src.playroom.playroom import Playroom
from src.playroom.ball import Ball
from src.playroom.car import Car
from src.playroom.cube import Cube
from src.playroom.doll import Doll

playroom = Playroom(10)
searchParam = 'football'

toys = [Ball(12.5, 0.342, "football", "white", 15),
        Cube(0.5, .01, "playcube", "red", 5.0),
        Car(150.0, 2.3, "Nissan", 0.15, 0.38, "silver"),
        Doll(3.75, 0.175, "barbie", "female", "Hello, world!", 21.0, "yellow")]

toys[0].calculate_toy_volume()
toys[1].calculate_toy_volume()

for toy in toys: playroom.push_toy(toy)

print("Info about playroom:\n")
print(playroom.__str__())

print("Unsorted toys list:\n")
print(playroom.show_available_toys())

playroom.sort_toys_by_attr('price')

print("Sorted toys list:\n")
print(playroom.show_available_toys())

print("Search toy of \"%s\" type:\n" % searchParam)
print(playroom.search_toys_by_type(searchParam))
