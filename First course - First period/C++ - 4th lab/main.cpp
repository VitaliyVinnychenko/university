#include <iostream>
using namespace std;

class Transport {
public:
    virtual void out() = 0;
    virtual void get() = 0;
    
    double weight;
    int seats;
    
    void basicInfo(){
        cout << " - вага: " << weight << endl;
        cout << " - місць для сидіння: " << seats << endl;
        cout << endl;
    }
};

class PrivateTransport: public Transport {
public:
    virtual void out() = 0;
};

class PublicTransport: public Transport {
public:
    virtual void out() = 0;
    double price;
    int standPlaces;
    
    void get(){
        cout << "Введіть вагу транспорту: ";
        cin >> weight;
        
        cout << "Введіть кількість місць для сидіння: ";
        cin >> seats;
        
        cout << "Введіть ціну за проїзд: ";
        cin >> price;
        
        cout << "Введіть кількість місць для стояння: ";
        cin >> standPlaces;
    }
};

class FuelPublicTransport: public PublicTransport {
public:
    virtual void out() = 0;
};

class ElectricPublicTransport:public PublicTransport {
public:
    virtual void out() = 0;
};

class Car: public PrivateTransport {
public:
    void get(){
        cout << "Введіть вагу транспорту: ";
        cin >> weight;
        
        cout << "Введіть кількість місць для сидіння: ";
        cin >> seats;
    }
    void out(){
        cout << '\0';
    }
};

class LightCar: public PrivateTransport {
public:
    void out(){
        cout << '\0';
    }
    void get(){
        cout << "Введіть вагу транспорту: ";
        cin >> weight;
        
        cout << "Введіть кількість місць для сидіння: ";
        cin >> seats;
    }
};

class Lorry: public PrivateTransport {
public:
    double maxWeight;
    
    void out(){
        cout << " - вантажопійомність: " << maxWeight << endl;
    }
    
    void get(){
        cout << "Введіть вагу транспорту: ";
        cin >> weight;
        
        cout << "Введіть кількість місць для сидіння: ";
        cin >> seats;
        
        cout << "Введіть максимальну вагу вантажу: ";
        cin >> maxWeight;
    }
};

class Bus: public FuelPublicTransport {
public:
    void out(){
        cout << " - ціна за проїзд: " << price << endl;
        cout << " - місця для стоячих: " << standPlaces << endl;
    }
};

class Trolleybus: public ElectricPublicTransport {
public:
    void out(){
        cout << " - ціна за проїзд: " << price << endl;
        cout << " - місця длястоячих: " << standPlaces << endl;
    }
};

class Tram: public ElectricPublicTransport {
public:
    void out(){
        cout << " - ціна за проїзд: " << price << endl;
        cout << " - місця длястоячих: " << standPlaces << endl;
    }
};

int main() {
    int transportType;
    Transport *transport[6];  //transport array
    
    transport[0] = new Car;
    transport[1] = new LightCar;
    transport[2] = new Lorry;
    transport[3] = new Bus;
    transport[4] = new Trolleybus;
    transport[5] = new Tram;
    
    cout << "Транспортні засоби: \n";
    cout << " 1. Автомобіль\n";
    cout << " 2. Легковий автомобіль\n";
    cout << " 3. Вантажний автомобіль\n";
    cout << " 4. Автобус\n";
    cout << " 5. Тролейбус\n";
    cout << " 6. Трамвай\n";
    
    cin >> transportType;
    
    transportType--;
    transport[transportType]->get();
    transport[transportType]->out();
    transport[transportType]->basicInfo();
    
    cout << endl;

    return 0;
}
