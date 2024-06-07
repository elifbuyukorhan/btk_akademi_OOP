class Product(object):
    def __init__(self,name:str="Default" ,price:float=0, quantity:int=0) -> None: 
        if 3 <= len(name) <= 8:
            self.__name = name
        else:
            raise ValueError("Name must be between 3 and 8 characters long.")
        if price >= 0:
            self.__price = price
        else:
            raise ValueError("Price must be non-negative.")
        if quantity >= 1:
            self.__quantity = quantity
        else:
            raise ValueError("Quantity must be at least 1.")
        print(f"An instance with name: {name} has been derived from Product class in 31 May 2024")
    
    @property    
    def name(self):
        return self.__name
    @property
    def price(self):
        return self.__price
    @property
    def quantity(self):
        return self.__quantity
    
    @name.setter
    def name(self, value:str) -> None:
        if 3 <= len(value) <= 8:
           self.__name = value 
        else: 
            print("Name must be between 3 and 8 characters long.")
        
    @price.setter
    def price(self, value:float) -> None:
        if (self.__price >= 0):
            self.__price = value
        else:
            print("Price must be non-negative.")
    @quantity.setter
    def quantity(self, value:int) -> None:
        if(self.__quantity >= 1):
            self.__quantity = value
        else:
            print("Quantity must be at least 1.")
        
    def get_total_price(self) -> float:
        return self.__price * self.__quantity

    def __repr__(self):
        return f"{self.__name} - {self.__price} - {self.__quantity}"