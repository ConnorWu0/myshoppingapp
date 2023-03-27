# My shopping app

先在MySQL Workbench實施sql-scripts裡的01-create-user.sql和02-create-tables.sql。如果不想創造新的MySQL使用者，可以不要實施01-create-user.sql，但是要把myshoppingapp/src/main/resources/application.properties
裡面的spring.datasource.username=user的user改成你的MySQL使用者名稱，還有把spring.datasource.password=user的user改成你的密碼。

實施02-create-tables.sql後，現在在MySQL的資料庫中，建立了一個名為my_shopping_demo的資料庫，有三個使用者，john、mary和susan。john的role是ROLE_CUSTOMER，
而mary和susan的role是ROLE_ADMIN。所有使用者的密碼都是fun123。

執行程式後，打開瀏覽器，在網誌列輸入http://localhost:8080/ ，會看到Homepage，此時還沒加入任何項目。

![The initial homepage](https://user-images.githubusercontent.com/98209295/227955126-27bc3db4-fe1d-476e-96f8-4a4598e0bff0.png)
點擊Account後，會出現登入畫面，可以選擇登入已經存在的使用者，或是註冊帳號，或是回到Homepage。
![Login page](https://user-images.githubusercontent.com/98209295/227955320-e3779214-165a-4161-8610-d90059ba7afb.png)
輸入資料到註冊欄位後，就可以註冊帳號了。註冊的使用者的role都是ROLE_CUSTOMER。
![Registration Form](https://user-images.githubusercontent.com/98209295/227955486-a5ccafa5-985c-4087-9420-6e1b48873853.png)
註冊成功會出現這個頁面。
![Process Registration Form](https://user-images.githubusercontent.com/98209295/227955734-c5d56444-ee67-4da5-b224-68fcb4c158f9.png)
登入role是ROLE_CUSTOMER的帳號後，回到Homepage，點擊Account後，會出現這個帳號的相關資訊。
![Account page](https://user-images.githubusercontent.com/98209295/227956027-f774e4cc-5abe-4bbd-b08c-52cc34e3ede6.png)
點擊Delete Account後，會出現確認是否刪除的選項，點選確定後，會刪除帳號，並且回到登入頁面。
![Delete confirmation](https://user-images.githubusercontent.com/98209295/227956205-0e9d7036-153f-4c85-8939-8464f5e437fa.png)
如果登入role是ROLE_ADMIN的帳號，像是mary和susan，在Homepage就不會有account的按鈕，而有System和Add Item的按鈕。
![The homepage with systems and add item](https://user-images.githubusercontent.com/98209295/227956351-dd1f3301-ec08-4f26-bc73-38086ff2b12a.png)
點擊System後，會進入SYSTEMS home page，這個頁面會顯示帳號資訊。
![SYSTEMS homepage](https://user-images.githubusercontent.com/98209295/227956588-df14510c-2c6c-469e-9a2e-6e1b4c4f0ad7.png)
在Account和SYSTEMS home page點擊Logout的話，會顯示成功登出的畫面。
![Logout](https://user-images.githubusercontent.com/98209295/227957612-6bce6c95-2b2b-4b69-ba5c-813aa47eb1cd.png)
在Homepage點擊Add Item後，可以新增項目。上傳圖片，填好資訊後，點擊Submit，確認上傳成功後，點擊Show All，會回到Homepage。
![Add item](https://user-images.githubusercontent.com/98209295/227970022-b9be755e-f084-4d06-98b3-fa489cc23ec8.png)
在Homepage可以看到已經存入資料庫的項目。
![The homepage has a picture](https://user-images.githubusercontent.com/98209295/227957330-029aad36-f230-4635-9a8e-817a5bb2d635.png)
點擊View後，可以看到詳細資訊。
![Image Details](https://user-images.githubusercontent.com/98209295/227957503-4f594ec5-fc27-417c-b264-0c0e21446d89.png)

