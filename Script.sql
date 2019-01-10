CREATE TABLE public.book
(
    book_id serial NOT NULL,
    title text COLLATE pg_catalog."default" NOT NULL,
    cost integer NOT NULL,
    stock text COLLATE pg_catalog."default" NOT NULL,
    quantity integer NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (book_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.book
    OWNER to postgres;


CREATE TABLE public.customer
(
    cust_id serial NOT NULL,
    lastname text COLLATE pg_catalog."default" NOT NULL,
    cust_district text COLLATE pg_catalog."default" NOT NULL,
    discount integer NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (cust_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;



CREATE TABLE public.shop
(
    shop_id serial NOT NULL,
    shop_name text COLLATE pg_catalog."default" NOT NULL,
    shop_district text COLLATE pg_catalog."default" NOT NULL,
    commission integer NOT NULL,
    CONSTRAINT shop_pkey PRIMARY KEY (shop_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.shop
    OWNER to postgres;



CREATE TABLE public.purchase
(
    order_id serial NOT NULL,
    date date NOT NULL,
    shop_id integer NOT NULL,
    cust_id integer NOT NULL,
    book_id integer NOT NULL,
    quantity integer NOT NULL,
    total integer NOT NULL,
    CONSTRAINT purchase_pkey PRIMARY KEY (order_id),
    CONSTRAINT book_fk FOREIGN KEY (book_id)
        REFERENCES public.book (book_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT cust_fk FOREIGN KEY (cust_id)
        REFERENCES public.customer (cust_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT shop_fk FOREIGN KEY (shop_id)
        REFERENCES public.shop (shop_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.purchase
    OWNER to postgres;



INSERT INTO public.book(
	title, cost, stock, quantity)
	VALUES ('Title1', 122,'Soviet', 15);
INSERT INTO public.book(
	title, cost, stock, quantity)
	VALUES ('Title2', 354,'Autoplane', 25);
INSERT INTO public.book(
	title, cost, stock, quantity)
	VALUES ('Title3', 3000,'Autoplane', 5);
INSERT INTO public.book(
	title, cost, stock, quantity)
	VALUES ('Title4', 2100,'Kanavino', 53);
INSERT INTO public.book(
	title, cost, stock, quantity)
	VALUES ('Title5', 300,'Autoplane', 10);
INSERT INTO public.book(
	title, cost, stock, quantity)
	VALUES ('Title Windows', 6,'Sormovo', 10);


INSERT INTO public.customer(
	lastname, cust_district, discount)
	VALUES ('Anton1', 'Autoplane', 90);
INSERT INTO public.customer(
	lastname, cust_district, discount)
	VALUES ('Anton2', 'Soviet', 23);
INSERT INTO public.customer(
	lastname, cust_district, discount)
	VALUES ('Anton3', 'nizhegorodkiy', 23);
INSERT INTO public.customer(
	lastname, cust_district, discount)
	VALUES ('Anton4', 'Soviet', 13);
INSERT INTO public.customer(
	lastname, cust_district, discount)
	VALUES ('Anton5', 'Kanavino', 11);


INSERT INTO public.shop(
	shop_name, shop_district, commission)
	VALUES ('Shop1', 'Autoplane', 10);
INSERT INTO public.shop(
	shop_name, shop_district, commission)
	VALUES ('Shop2', 'Kanavino', 11);
INSERT INTO public.shop(
	shop_name, shop_district, commission)
	VALUES ('Shop3', 'Soviet', 12);
INSERT INTO public.shop(
	shop_name, shop_district, commission)
	VALUES ('Shop4', 'Autoplane', 13);
INSERT INTO public.shop(
	shop_name, shop_district, commission)
	VALUES ('Shop5', 'Sormovo', 14);
INSERT INTO public.shop(
	shop_name, shop_district, commission)
	VALUES ('Shop6', 'Sormovo', 15);




INSERT INTO public.purchase(
	date, shop_id, cust_id, book_id, quantity, total)
	VALUES ('2018-04-27', 5, 1, 5, 3, 150);
INSERT INTO public.purchase(
	date, shop_id, cust_id, book_id, quantity, total)
	VALUES ('2018-04-27', 1, 1, 1, 10, 1500);
INSERT INTO public.purchase(
	date, shop_id, cust_id, book_id, quantity, total)
	VALUES ('2018-04-27', 4, 4, 4, 5, 200);
INSERT INTO public.purchase(
	date, shop_id, cust_id, book_id, quantity, total)
	VALUES ('2018-04-27', 2, 5, 2, 12, 6100);
INSERT INTO public.purchase(
	date, shop_id, cust_id, book_id, quantity, total)
	VALUES ('2018-04-27', 3, 2, 3, 1, 7000);
