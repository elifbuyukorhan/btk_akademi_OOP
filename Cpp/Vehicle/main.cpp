#include <iostream>
#include <string>

class Vehicle {
protected:
    std::string manufacturer;
    int year;
    std::string color;

public:
    std::string getManufacturer() {
        return manufacturer;
    } 

    void setManufacturer(std::string value) {
        this->manufacturer = value;
    }

    int getYear() {
        return year;
    }

    void setYear(int value) {
        this->year = value;
    }

    std::string getColor() {
        return this->color;
    }

    void setColor(std::string value) {
        this->color = value;
    }

    Vehicle() {
        std::cout << "\nAn instance has been derived from Vehicle." << std::endl;
    }
    Vehicle(std::string manufacturer, int year, std::string color) : Vehicle() {
        std::cout << "\nAn instance with full parameters has been derived from Vehicle." << std::endl;
        this->manufacturer = manufacturer;
        this->year = year;
        this->color = color;

    }

    virtual void start() 
    {
        std::cout << "Vehicle has been started." << std::endl;
    }

    virtual void stop() 
    {
        std::cout << "Vehicle has been stopped." << std::endl;
    }

    virtual void drive() 
    {
        std::cout << "Vehicle is being driven." << std::endl;
    }

    virtual std::string toString() 
    {
        return manufacturer + " - " + std::to_string(year) + " - " + color;
    }
};

class Car : public Vehicle
{
public:
    Car() {
        std::cout << "\nAn instance has been derived from Car." << std::endl;
    }
    Car(std::string manufacturer, int year, std::string color)
        : Vehicle(manufacturer, year, color)
    {
        std::cout << "\nAn instance with full parameters has been derived from Car." << std::endl;
    }
    void openSunRoof() 
    {
        std::cout << "The sunroof has been opened." << std::endl;
    }

    void drive() override
    {
        std::cout << "The car manufacturer by " << this->manufacturer << " is being driven." << std::endl;
    }
};

class Truck : public Vehicle
{
public:
    Truck()
    {
        std::cout << "\nAn instance has been derived from Truck." << std::endl;
    }
    Truck(std::string manufacturer, int year, std::string color)
        : Vehicle(manufacturer, year, color)
    {
        std::cout << "\nAn instance with full parameters has been derived from Truck." << std::endl;
    }
    void transport() 
    {
        std::cout << "The transport has been completed." << std::endl;
    }
};

class Bus : public Vehicle 
{
public:
    Bus(std::string manufacturer, int year, std::string color)
        : Vehicle(manufacturer, year, color)
    {
        std::cout << "\nAn instance with full parameters has been derived from Bus." << std::endl;
    }

    void scheduling()
    {
        std::cout << "Scheduled." << std::endl;
    }

    void drive() override
    {
        std::cout << "The bus manufacturer by " << this->manufacturer << " is being driven." << std::endl;
    }
};

class SchoolBus : public Bus 
{
public:
    SchoolBus(std::string manufacturer, int year, std::string color)
    : Bus(manufacturer, year, color)
    {
        std::cout << "\nAn instance with full parameters has been derived from School Bus." << std::endl;
    }

    void getFare() 
    {
        std::cout << "getFare() has been called." << std::endl;
    }

    void drive() override
    {
        std::cout << "The school bus manufacturer by " << this->manufacturer << " is being driven." << std::endl;
    }
};

int main() {
    Vehicle item1 = Vehicle("Skoda", 2019, "white");
    std::cout << "Vehicle " << item1.getManufacturer() << std::endl;
    std::cout << item1.toString() << std::endl;
    

    Car item2 = Car();
    item2.setManufacturer("TOGG");
    std::cout << item2.toString() << std::endl;
    item2.openSunRoof();
    

    Car item3 = Car("Opel", 2020, "black");
    std::cout << item3.toString() << std::endl;
    item3.openSunRoof();
    

    Bus item4 = Bus("Anadolu Isuzu", 2016, "red");
    std::cout << item4.toString() << std::endl;
    item4.scheduling();
    

    SchoolBus item5 = SchoolBus("Isuzu", 2015, "yellow");
    std::cout << item5.toString() << std::endl;
    item5.scheduling();
    item5.getFare();
    

    item1.drive();
    item1.stop();

    item2.drive();
    item2.stop();

    item3.drive();
    item3.stop();

    item4.drive();
    item4.stop();

    item5.drive();
    item5.stop();


    char c = getchar();

    return 0;
}