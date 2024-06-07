#include <iostream>
#include <string>

class Person 
{
protected:
    std::string name;
    int age;

public:
    std::string getName() {return this->name;}

    int getAge()
    {
        return this->age;
    }

    void setName(std::string value) 
    {
        this->name = value;
    }

    void setAge(int value)
    {
        this->age = value;
    }

    Person()
    {
        std::cout << "An instance has been derived from Person." << std::endl;
    }

    Person(std::string name, int age)
    {
        std::cout << "An instance with parameters has been derived from Person." << std::endl;
        this->name = name;
        this->age = age;
    }

    virtual std::string toString()
    {
        return "My name is " + this->name + " and " + std::to_string(this->age) + " years old.";
    }
    
};

class Student : public Person 
{
private:
    int studentID;

public:

    int getStudentID() 
    {
        return this->studentID;
    }

    void setStudentID(int value)
    {
        this->studentID = value;
    }

    Student()
    {
        std::cout << "An instance has been derived from Student." << std::endl;
    }
    Student(std::string name, int age, int studentID)
    : Person(name,age)
    {
        std::cout << "An instance with parameters has been derived from Student." << std::endl;
        this->studentID = studentID;
    }

    std::string toString() override
    {
        return "My name is " + name + " and " + std::to_string(age) + " years old. My student ID is " + std::to_string(studentID) + "."; 
    }
};

class Teacher : public Person 
{
private:
    std::string course;

public:    

    std::string getCourse()
    {
        return this->course;
    }

    void setCourse(std::string value) 
    {
        this->course = value;
    }

    Teacher()
    {
        std::cout << "An instance has been derived from Teacher." << std::endl;
    }
    Teacher(std::string name, int age, std::string course)
    : Person(name, age)
    {
        std::cout << "An instance with parameters has been derived from Teacher." << std::endl;
        this->course = course;
    }
    std::string toString() override
    {
        return "My name is " + name + " and " + std::to_string(age) + " years old. I teach " + course + "."; 
    }
};

int main() {

    Person p1 = Person("Mehmet", 23);
    std::cout << p1.toString() << std::endl;

    Student p2 = Student("Elif", 22, 191201029);
    std::cout << p2.toString() << std::endl;

    Teacher p3 = Teacher("Ümmiye", 45, "fashion");
    std::cout << p3.toString() << std::endl;

    return 0;
}