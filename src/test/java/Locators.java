//        //XPath
//        By.xpath("//div[@class='login_logo']"); //Поиск по атрибуту на странице https://www.saucedemo.com/
//        By.xpath("//*[contains(text(),='Swag Labs')]"); //Поиск по тексту на странице https://www.saucedemo.com/
//        By.xpath("//div[contains(@id,='menu')]"); //Поиск по частичному совпадению атрибута на странице https://www.saucedemo.com/inventory-item.html?id=4
//        By.xpath("//*[contains(text(),='Backpack')]"); // Поиск по частичному совпадению текста на странице https://www.saucedemo.com/inventory-item.html?id=4
//        By.xpath("//*[@class="inventory_item_desc"]//ancestor::div"); // Поиск всех предков класса "inventory_item_desc"
//        By.xpath("//*[@class="inventory_item_label"]//descendant::div"); // Поиск всех потомков класса "inventory_item_label"
//        By.xpath("  //*[@class="inventory_item_label"]//following::div");// Поиск всех элементов с тегом div после "inventory_item_label"
//        By.xpath("  //*[@class="inventory_item_label"]//parent::div"); //Поиск родительских элементов
//        By.xpath("  //*[@class="inventory_item_label"]//preceding::div"); // Поиск всех элементов div перед текущим
//        By.xpath("//img[@alt='Sauce Labs Bike Light' and @class= 'inventory_item_img']");//Поиск элемента с условием AND
//
//        //CSS
//        By.cssSelector(".btn.btn_secondry.btn_small.cart_button");//.class
//        By.cssSelector(".bm-item.menu-item[style*='display']");//.class1.class2
//        By.cssSelector(".bm-menu [style*='display']");//.class1 .class2
//        By.cssSelector("#item_4_title_link");//#id
//        By.cssSelector("div");//tagname
//        By.cssSelector("div.primary_header");//tagname.class
//        By.cssSelector("[src='/static/media/red-tatt-1200x1500.e32b4ef9.jpg'']">); //[attribute=value]
//        By.cssSelector("[src~='/static/media/red-tatt-1200x1500.e32b4ef9.jpg'']");//[attribute~=value]???
//        By.cssSelector("[src|='/static/media/red-tatt-1200x1500.e32b4ef9.jpg']");//[attribute|=value]???
//        By.cssSelector("img.inventory_item_img[src^='/']");//[attribute^=value]
//        By.cssSelector("img.inventory_item_img[src$='g']");//[attribute$=value]
//        By.cssSelector("img.inventory_item_img[src*='bike']");//[attribute*=value]