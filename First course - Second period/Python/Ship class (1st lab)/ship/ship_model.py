class Ship:
    'Class that describes a ship'
    def __init__(self, name="N/A", decks=1, speed=10, capacity=15, crew=2):
        self.reset_values(name, decks, speed, capacity, crew)

    #change ship params
    def reset_values(self, name, decks, speed, capacity, crew):
        self.name = name
        self.decks = decks
        self.speed = speed
        self.capacity = capacity
        self.crew = crew

    # print out info about about ship
    def to_string(self):
        return """\t\t{0}
        - Decks: {1} passenger decks
        - Speed: {2} knots
        - Capacity: {3} passengers at double occupancy
        - Crew: {4} on maiden voyage\n""".format(self.name, self.decks, self.speed, self.capacity, self.crew)
