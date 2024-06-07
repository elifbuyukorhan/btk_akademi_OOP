from Helpers.product_helper import ProductHelper

file_path = "/home/elif/BTK_AKADEMİ/Python/Products.txt"
products = ProductHelper.create_item_from_text(file_path)
total_balance = ProductHelper.get_total_balance(products)
print(f"Total balance including 20% VAT: {total_balance}")