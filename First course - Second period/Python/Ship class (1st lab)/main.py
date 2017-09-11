from ship.ship_model import Ship


ships = [Ship(),
         Ship(name="Grandeur of the Seas", decks=2, capacity=1500, crew=400),
         Ship("Oasis of the Seas", 16, 22.6, 5400, 2165)]

print("\n=========== ALL SHIPS INFO ===========\n")
for ship in ships:
    print(ship.to_string())

ships[1].reset_values("Grandeur of the Seas", 11, 22.0, 2446, 760)

print("\n=========== NEW SECOND SHIP ===========\n")
print(ships[1].to_string())
