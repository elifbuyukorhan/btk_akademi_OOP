from Models.product import Product

class ProductHelper(Product):
    @staticmethod 
    def create_item_from_text(file_path: str) -> list:
        products = [] 
        with open(file_path, 'r') as file:
            for line in file:
                line = line.strip()
                if line: #Boş satırları atla
                    parts = line.split(',')
                    if len(parts) == 4:
                        _, name, price, quantity = parts
                        name = name.strip()
                        price = float(price.strip())
                        quantity = int(quantity.strip())
                        try:
                            product = Product(name, price, quantity)
                            products.append(product)
                        except Exception as e:
                            print(f"An error occured while reading the file: {e}")
                    else:
                        print(f"Skipped invalid line: {line}")
        return products
            
    @staticmethod 
    def get_total_balance(products) -> float:
        total = 0
        for product in products:
            total += product.get_total_price()
        total += total*0.2
        return total
        