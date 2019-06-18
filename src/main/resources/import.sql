insert into product(description, price) values('P8 Mini Projector Portable Projection Device 80 LM 1920 X', 169.05);
insert into product(description, price) values('G2S Wi-Fi Display TV Dongle, TV Stick Airplay for Google ', 19.01);
insert into product(description, price) values('Gen Game S5 Wireless Bluetooth Gamepad Bluetooth 3.0 Joystick', 16.99);
insert into product(description, price) values('HDMI Out Retro Classic Mini Game Console with 821 Different', 32.30);
insert into product(description, price) values('X96 Max Smart TV Box Android 8.1 Amlogic S905X2 LPDDR4', 47.62);
insert into product(description, price) values('Zeblaze Thor PRO 3G GPS Smartwatch 1.53inch Android 5.1', 87.99);
insert into product(description, price) values('Original Xiaomi Smart IR Human Body Sensor', 12.69);

insert into role (description) values('CUSTOMER');
insert into users(username, password) values('one', '{bcrypt}$2a$10$rtwSnyJyncBjQ3LR6xZWTuRIyN1k9nkAOeys453k4rbAWmudItjUq');
insert into users(username, password) values('two', '{bcrypt}$2a$10$JUSWxAajlJUU9Sdc8bc5DuUqzvJMh15c6pDRX6OtKWbdYJhXwAjb6');
insert into users(username, password) values('three', '{bcrypt}$2a$10$sDZcAdCp779s2FwWX693MucJATIFU99GhDdtU0bv5u5nuG5l/U/2y');
insert into user_roles(user_id, role_id) values(1, 1);
insert into user_roles(user_id, role_id) values(2, 1);
insert into user_roles(user_id, role_id) values(3, 1);